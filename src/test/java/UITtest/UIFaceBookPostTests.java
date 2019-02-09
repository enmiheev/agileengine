package UITtest;

import Common.Environment;
import Pages.HomePage;
import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;

public class UIFaceBookPostTests extends UIBaseTest {

    @Test
    public void createPostTest(){
        String postText = UUID.randomUUID().toString();
        HomePage homePage = new HomePage();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        homePage.OpenPostPopUp();
        homePage.GetNewPostPopUp().EnterPostText(postText);
        homePage.GetNewPostPopUp().CliCkPostBtn();
        homePage.GetNewsFeed().WaitProgressLineDisappear();

        homePage.GetNewsFeed().GetPostsCollection().first().shouldHave(text(postText));

        Assert.assertEquals(
                homePage.GetNewsFeed().GetPostsTextCollection().get(0),
                postText,
                "Post text isn't created");
    }

    @Test
    public void editPostTest(){
        String savePostText = UUID.randomUUID().toString();
        String editPostText = UUID.randomUUID().toString();
        HomePage homePage = new HomePage();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(savePostText);

        SelenideElement post = homePage.GetNewsFeed().GetPostsCollection().first();
        homePage.GetNewsFeed().OpenPostMenu(post);
        homePage.GetNewsFeed().ClickEditPostBtn();
        homePage.GetEditPostPopUp().EnterPostText(editPostText);
        homePage.GetEditPostPopUp().ClickSaveBtn();

        Assert.assertEquals(
                homePage.GetNewsFeed().GetPostsTextCollection().get(0),
                savePostText + editPostText,
                "Post text isn't edited");
    }

    @Test
    public void deletePostTest(){
        String postText = UUID.randomUUID().toString();
        HomePage homePage = new HomePage();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(postText);

        ElementsCollection postCollection = homePage.GetNewsFeed().GetPostsCollection();
        int expectedNumberOfPosts = postCollection.size() - 1;
        SelenideElement post = postCollection.first();
        homePage.GetNewsFeed().OpenPostMenu(post);
        homePage.GetNewsFeed().ClickDeletePostBtn();
        homePage.GetDeletePostPopUp().ClickDeleteBtn();

        Assert.assertEquals(
                homePage.GetNewsFeed().GetPostsCollection().size(),
                expectedNumberOfPosts,
                "News feed contains wrong number of posts");

        Assert.assertFalse(
                homePage.GetNewsFeed().GetPostsTextCollection().contains(postText),
                "Post isn't deleted");
    }
}

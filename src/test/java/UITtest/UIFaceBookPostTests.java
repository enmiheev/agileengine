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
        homePage.openPostPopUp();
        homePage.getNewPostPopUp().enterPostText(postText);
        homePage.getNewPostPopUp().clickPostBtn();
        homePage.getNewsFeed().waitProgressLineDisappear();

        homePage.getNewsFeed().getPostsCollection().first().shouldHave(text(postText));

        Assert.assertEquals(
                homePage.getNewsFeed().getPostsTextCollection().get(0),
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

        SelenideElement post = homePage.getNewsFeed().getPostsCollection().first();
        homePage.getNewsFeed().openPostMenu(post);
        homePage.getNewsFeed().clickEditPostBtn();
        homePage.getEditPostPopUp().enterPostText(editPostText);
        homePage.getEditPostPopUp().clickSaveBtn();

        Assert.assertEquals(
                homePage.getNewsFeed().getPostsTextCollection().get(0),
                savePostText + editPostText,
                "Post text isn't edited");
    }

    @Test
    public void deletePostTest(){
        String postText = UUID.randomUUID().toString();
        HomePage homePage = new HomePage();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(postText);

        ElementsCollection postCollection = homePage.getNewsFeed().getPostsCollection();
        int expectedNumberOfPosts = postCollection.size() - 1;
        SelenideElement post = postCollection.first();
        homePage.getNewsFeed().openPostMenu(post);
        homePage.getNewsFeed().clickDeletePostBtn();
        homePage.getDeletePostPopUp().clickDeleteBtn();

        Assert.assertEquals(
                homePage.getNewsFeed().getPostsCollection().size(),
                expectedNumberOfPosts,
                "News feed contains wrong number of posts");

        Assert.assertFalse(
                homePage.getNewsFeed().getPostsTextCollection().contains(postText),
                "Post isn't deleted");
    }
}

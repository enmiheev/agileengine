package UITtest;

import Common.Environment;
import org.testng.annotations.Test;
import java.util.UUID;

import static com.codeborne.selenide.Condition.text;

public class UIFaceBookPostTests extends UIBaseTest {

    @Test
    public void createPostTest(){
        String postText = UUID.randomUUID().toString();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(postText)
            .getNewsFeed()
                .getPostsCollection()
                .first()
                .shouldHave(text(postText));
    }

    @Test
    public void editPostTest(){
        String savePostText = UUID.randomUUID().toString();
        String editPostText = UUID.randomUUID().toString();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(savePostText);
        editPost(savePostText, editPostText)
                .getNewsFeed()
                .getPostsCollection()
                .first()
                .shouldHave(text(savePostText + editPostText));
    }

    @Test
    public void deletePostTest(){
        String postText = UUID.randomUUID().toString();

        logIn(Environment.getUserEmail(), Environment.getUserPassword());
        addPost(postText);
        deletePost(postText)
                .getNewsFeed()
                .getPostsCollection()
                .stream()
                .forEach(x -> x.shouldNotHave(text(postText)));
    }
}

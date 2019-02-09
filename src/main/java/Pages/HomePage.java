package Pages;

import Pages.Components.DeletePostPopUpComponent;
import Pages.Components.EditPostPopUpComponent;
import Pages.Components.NewsFeedComponent;
import Pages.Components.NewPostPopUpComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private NewPostPopUpComponent newPostPopUpComponent = new NewPostPopUpComponent();
    private NewsFeedComponent newsFeedComponent = new NewsFeedComponent();
    private EditPostPopUpComponent editPostPopUpComponent = new EditPostPopUpComponent();
    private DeletePostPopUpComponent deletePostPopUpComponent = new DeletePostPopUpComponent();
    private SelenideElement newPostPopUp = $(byId("pagelet_composer"));

    public NewPostPopUpComponent GetNewPostPopUp() {
        return newPostPopUpComponent;
    }

    public NewsFeedComponent GetNewsFeed() {
        return newsFeedComponent;
    }

    public EditPostPopUpComponent GetEditPostPopUp() {
        return editPostPopUpComponent;
    }

    public DeletePostPopUpComponent GetDeletePostPopUp() {
        return deletePostPopUpComponent;
    }

    public void OpenPostPopUp() {
        newPostPopUp.click();
    }
}

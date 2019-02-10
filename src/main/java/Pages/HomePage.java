package Pages;

import Pages.Components.NewsFeedComponent;
import Pages.Components.NewPostPopUpComponent;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    public NewsFeedComponent getNewsFeed() {
        return page(NewsFeedComponent.class);
    }

    public NewPostPopUpComponent openPostPopUp() {
        $(byId("pagelet_composer")).click();
        return page(NewPostPopUpComponent.class);
    }
}

package Pages.Components;

import Pages.HomePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NewsFeedComponent {

    public ElementsCollection getPostsCollection() {
        return getNewsFeed().$$(byCssSelector("div .userContentWrapper"));
    }

    public SelenideElement getNewsFeed() {
        return $(byAttribute("data-testid","newsFeedStream"));
    }

    public HomePage waitProgressLineDisappear() {
        SelenideElement progressLine = getNewsFeed().$(byText("Uploading..."));
        progressLine.waitUntil(appear, 2000);
        progressLine.waitUntil(disappear, 5000);
        Selenide.refresh();
        return page(HomePage.class);
    }

    public NewsFeedComponent openPostMenu(SelenideElement postElement) {
        postElement.$(byAttribute("data-testid", "post_chevron_button"))
                .click();
        return this;
    }

    public EditPostPopUpComponent clickEditPostBtn() {
        $(byAttribute("data-feed-option-name","FeedEditOption"))
                .waitUntil(appear, 3000)
                .click();
        return page(EditPostPopUpComponent.class);
    }

    public DeletePostPopUpComponent clickDeletePostBtn() {
        $(byAttribute("data-feed-option-name","FeedDeleteOption"))
                .waitUntil(appear, 3000)
                .click();
        return page(DeletePostPopUpComponent.class);
    }
}

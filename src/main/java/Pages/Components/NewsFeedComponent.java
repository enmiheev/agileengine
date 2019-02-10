package Pages.Components;

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

public class NewsFeedComponent {
    private SelenideElement newsFeed = $(byAttribute("data-testid","newsFeedStream"));
    private SelenideElement progressLine = newsFeed.$(byText("Uploading..."));
    private ElementsCollection postsCollection = newsFeed.$$(byCssSelector("div .userContentWrapper"));
    private By postMenuBtn = byAttribute("data-testid", "post_chevron_button");
    private SelenideElement editPostBtn = $(byAttribute("data-feed-option-name","FeedEditOption"));
    private SelenideElement deletePostBtn = $(byAttribute("data-feed-option-name","FeedDeleteOption"));

    public ElementsCollection getPostsCollection() {
        return postsCollection;
    }

    public List<String> getPostsTextCollection() {
        List<String>  postsTextList  = new ArrayList<>();
        postsCollection.forEach(x -> postsTextList.add(x.$(By.tagName("p")).text()));
        return postsTextList;
    }

    public void waitProgressLineDisappear() {
        progressLine.waitUntil(appear, 2000);
        progressLine.waitUntil(disappear, 5000);
        Selenide.refresh();
    }

    public void openPostMenu(SelenideElement postElement) {
        postElement.$(postMenuBtn).click();
    }

    public void clickEditPostBtn() {
        editPostBtn.waitUntil(appear, 3000).click();
    }

    public void clickDeletePostBtn() {
        deletePostBtn.waitUntil(appear, 3000).click();
    }
}

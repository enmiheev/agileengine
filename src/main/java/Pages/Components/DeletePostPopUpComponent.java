package Pages.Components;

import Pages.HomePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DeletePostPopUpComponent {

    public HomePage clickDeleteBtn(){
        SelenideElement deleteBtn = $(byCssSelector("button.layerConfirm.uiOverlayButton"));
        deleteBtn.click();
        deleteBtn.waitUntil(disappear, 10000);
        return page(HomePage.class);
    }
}

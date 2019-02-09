package Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class DeletePostPopUpComponent {
    private SelenideElement deleteBtn = $(byCssSelector("button.layerConfirm.uiOverlayButton"));

    public void ClickDeleteBtn(){
        deleteBtn.click();
        deleteBtn.waitUntil(disappear, 10000);
    }
}

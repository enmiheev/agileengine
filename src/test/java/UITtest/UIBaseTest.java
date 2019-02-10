package UITtest;

import Pages.HomePage;
import Pages.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class UIBaseTest {
    private ChromeOptions options = new ChromeOptions();
    private String chromeDriverPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "WebDrivers" + File.separator + "chromedriver";
    protected HomePage homePage;

    @BeforeSuite
    protected void oneTimeSetUp() {
        if (System.getProperty("os.name").toLowerCase().contains("windows"))
            System.setProperty("webdriver.chrome.driver", chromeDriverPath + ".exe");

        else
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--kiosk");
    }

    @BeforeMethod
    protected void setUp() {
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
        homePage = new HomePage();
    }

    @AfterMethod
    protected void tearDown() {
        getWebDriver().quit();
    }

    protected HomePage logIn(String email, String password){
        return new LoginPage().go()
                .enterEmail(email)
                .enterPassword(password)
                .clickLogIn();
    }

    protected HomePage addPost(String postText){
        return homePage.openPostPopUp()
                .enterPostText(postText)
                .clickPostBtn()
                .waitProgressLineDisappear();
    }

    protected HomePage editPost(String searchPosttext, String editPostText){
        SelenideElement post = homePage.getNewsFeed().getPostsCollection().find(Condition.text(searchPosttext));
        return homePage.getNewsFeed()
                .openPostMenu(post)
                .clickEditPostBtn()
                .enterPostText(editPostText)
                .clickSaveBtn();
    }

    protected HomePage deletePost(String postText) {
        SelenideElement post = homePage.getNewsFeed().getPostsCollection().find(Condition.text(postText));
        return homePage.getNewsFeed()
                .openPostMenu(post)
                .clickDeletePostBtn()
                .clickDeleteBtn();
    }
}

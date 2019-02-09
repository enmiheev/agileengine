package UITtest;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class UIBaseTest {
    private ChromeOptions options = new ChromeOptions();

    @BeforeSuite
    protected void oneTimeSetUp() {
        String chromeDriverPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "WebDrivers" + File.separator + "chromedriver";
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
    }

    @AfterMethod
    protected void tearDown() {
        getWebDriver().quit();
    }

    protected void logIn(String email, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.Go();
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.ClickLogIn();
    }

    protected void addPost(String postText){
        HomePage homePage = new HomePage();
        homePage.OpenPostPopUp();
        homePage.GetNewPostPopUp().EnterPostText(postText);
        homePage.GetNewPostPopUp().CliCkPostBtn();
        homePage.GetNewsFeed().WaitProgressLineDisappear();
    }
}

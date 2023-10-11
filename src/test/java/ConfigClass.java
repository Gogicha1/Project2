import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

public class ConfigClass {
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        timeout=20000;
        open("https://www.swoop.ge/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}

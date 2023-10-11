package Steps;

import Pages.SushiBuyPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertTrue;

public class SushiBuySteps {
    SushiBuyPage sushiBuyPage = new SushiBuyPage();

    @Step("Clicking On Share")
    public SushiBuySteps clickOnShare(){
        sushiBuyPage.share.click();
        return this;
    }

    @Step("Checking That Facebook Window Appeared")
    public SushiBuySteps checkingNewWindow(){
        switchTo().window(1);
        assertTrue(title().contains("Facebook"), "Title is Not Facebook");
        closeWindow();
        switchTo().window(0);
        return this;
    }
}

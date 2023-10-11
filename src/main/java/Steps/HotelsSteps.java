package Steps;

import Pages.HotelsPage;
import Pages.LoadingWaitPage;
import Pages.SideMenuPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;


import static com.codeborne.selenide.Condition.*;

public class HotelsSteps {
    HotelsPage hotelsPage = new HotelsPage();
    SideMenuPage sideMenuPage = new SideMenuPage();
    LoadingWaitPage loadingWaitPage = new LoadingWaitPage();
    SoftAssert softAssert = new SoftAssert();



    @Step("Scroll To Filter Zone")
    public HotelsSteps scroll(){
        sideMenuPage.submitButton.scrollTo();
        return this;
    }
    @Step("Setting Min Price")
    public HotelsSteps setMinPrice(){
        sideMenuPage.minPriceInput.setValue("200");
        return this;
    }

    @Step("Setting Max Price")
    public HotelsSteps setMaxPrice(){
        sideMenuPage.maxPriceInput.setValue("230");
        return this;
    }

    @Step("Clicking On Filter Submit Button")
    public HotelsSteps clickOnSubmit(){
        sideMenuPage.submitButton.click();
        return this;
    }

    @Step("Waiting For Filter To Complete")
    public HotelsSteps waitForFilter(){
        loadingWaitPage.loading.shouldNot(appear);
        return this;
    }

    @Step("Checking Validity of Prices")
    public HotelsSteps checkPriceValidity(){
        hotelsPage.hotels.forEach(element -> {

            int price = Integer.parseInt(element.$(".discounted-prices p").getText().replaceAll("[^0-9]", ""));

            softAssert.assertTrue(price>=200 && price <=230, "Price is Not Between These Prices");

        });
        softAssert.assertAll();
        return this;
    }
}


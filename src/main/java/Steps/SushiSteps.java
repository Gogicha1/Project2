package Steps;

import Pages.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static org.testng.Assert.assertTrue;

public class SushiSteps {
    SushiPage sushiPage = new SushiPage();
    RegisterPopUpPage registerPopUpPage = new RegisterPopUpPage();
    LoadingWaitPage loadingWaitPage = new LoadingWaitPage();

    @Step("clicking On Wishlist")
    public SushiSteps clickOnWishlist(){
        sushiPage.firstSushiWishlist.click();
        return this;
    }

    @Step("Checking that Register PopUp Appeared")
    public SushiSteps checkPopup(){
        registerPopUpPage.popUp.should(appear);
        return this;
    }

    @Step("Checking if Voucher is Available")
    public SushiSteps checkVoucherDiagram(){
        int diagramSize = sushiPage.voucherCount.getSize().getWidth();
        boolean voucherAvailability = diagramSize >= 0 && diagramSize < 100;
        assertTrue(voucherAvailability, "Voucher Not Available");
        return this;
    }

    @Step("Making Price Descending")
    public SushiSteps makeDesc(){
        sushiPage.sort.selectOptionContainingText("ფასით კლებადი");
        return this;
    }

    @Step("Checking That Second Price is Lower Than First")
    public SushiSteps checkDesc(){
        int firstPrice = Integer.parseInt(sushiPage.price1.getText().replaceAll("[^0-9]", ""));
        int secondPrice = Integer.parseInt(sushiPage.price2.getText().replaceAll("[^0-9]", ""));
        loadingWaitPage.loading.shouldNot(appear);
        assertTrue(firstPrice > secondPrice, "First Sushi is Cheaper Than Second");
        return this;

    }

    @Step("Navigating To First Sushi")
    public SushiSteps navigateToFirstSushi(){
        sushiPage.sushiObject.click();
        return this;
    }


}

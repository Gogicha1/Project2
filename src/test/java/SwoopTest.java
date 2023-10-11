import DDT.DataOperations;
import DDT.User;
import Steps.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;


@Listeners(ListenerConfig.class)
@Epic("Swoop Test")
public class SwoopTest extends ConfigClass{
    HotelsSteps hotelsSteps = new HotelsSteps();

    SushiSteps sushiSteps = new SushiSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    SushiBuySteps sushiBuySteps = new SushiBuySteps();
    RegisterPopUpSteps registerPopUpSteps = new RegisterPopUpSteps();


    @Feature("Hotels Price Range")
    @Story("Testing Hotel Price Range Functionality")
    @Description("Clicking On Hotels Button, scrolling to price input section and putting min price max price," +
            " pressing submit button and checking that hotel's prices are in range")
    @Test(description = "Test hotels functionality", groups = "Regression1")
    public void hotelsTest(){
        headerSteps.clickOnHotels();
        hotelsSteps.scroll().setMinPrice().setMaxPrice().clickOnSubmit().waitForFilter().checkPriceValidity();

    }

    @Feature("Sushi Voucher Availability")
    @Story("Testing Wishlist Button on Sushi and Vouchers Availability")
    @Description("Going to Categories, hovering on Eat Title and pressing sushi" +
            "clicking on first sushi's wishlist button, checking popup and last checking that voucher diagram is not full")
    @Test(description = "Test Sushi Wishlist Voucher Diagram Functionality", groups = "Regression1")
    public void clickOnSushi(){
        headerSteps.goToCategories().hoverOnEat().clickOnSushi();
        sushiSteps.clickOnWishlist().checkPopup().checkVoucherDiagram();

    }

    @Feature("Sushi Page Descending Price")
    @Story("Testing Descending Filter and Checking")
    @Description("Going to Categories, hovering on Eat Title and pressing sushi" +
            "making price descending and checking that sushi's list price is descending")
    @Test(description = "Test Sushi Page Descending Functionality", groups = "Regression2")
    public void sushiPriceSortDesc(){
        headerSteps.goToCategories().hoverOnEat().clickOnSushi();
        sushiSteps.makeDesc().checkDesc();

    }

    @Feature("Sushi Share")
    @Story("Clicking On First Sushi, then Share and Checking That Facebook Window Showed Up")
    @Description("Going to Categories, hovering on Eat Title and pressing sushi" +
            "navigating to the first sushi object, clicking on share and checking if facebook Window showed up")
    @Test(description = "Test Sushi share Functionality", groups = "Regression2")
    public void shareSushi(){
        headerSteps.goToCategories().hoverOnEat().clickOnSushi();
        sushiSteps.navigateToFirstSushi();
        sushiBuySteps.clickOnShare().checkingNewWindow();

    }

    @Feature("User Registration")
    @Story("Inserting User in DataBase, selecting Info from it and Filling The registration Form")
    @Description("Creating Connection, Inserting Information In database, selecting that database and saving it in to the new class" +
            "clicking on login button then registration, filling form with that information, except the gender, then clicking on " +
            "register button and checking that message has appeared")
    @Test(description = "Test Registration", groups = "Regression2")
    public void registration() throws SQLException{
        int id = DataOperations.insertOperation();
        User user = DataOperations.returnDB(id);
        headerSteps.clickOnLogin();
        registerPopUpSteps.clickOnRegister().fillFirstName(user.getFirstName()).fillLastName(user.getLastName()).fillEmail(user.getEmail())
                .fillPhone(user.getMobileNumber()).fillDate(user.getDateOfBirth()).fillPass(user.getPassword()).fillConfirmPass(user.getPassword())
                .clickOnAgree().clickOnRegisterButton().checkMessage();
        DataOperations.delete(id);
    }

}

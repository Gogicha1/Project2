package Steps;

import Pages.HeaderPage;
import io.qameta.allure.Step;

public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    @Step("Click On დასვენება")
    public void clickOnHotels(){
        headerPage.hotelsPageButton.click();
    }

    @Step("Go to Categories")
    public HeaderSteps goToCategories(){
        headerPage.categoriesTitle.click();
        return this;
    }

    @Step("Hover on Eat Title")
    public HeaderSteps hoverOnEat(){
        headerPage.eat.hover();
        return this;
    }

    @Step("Click on Sushi Section")
    public HeaderSteps clickOnSushi(){
        headerPage.sushi.click();
        return this;
    }

    @Step("Clicking on Login Button")
    public HeaderSteps clickOnLogin(){
        headerPage.login.click();
        return this;

    }
}

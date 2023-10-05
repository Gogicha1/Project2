package Steps;

import Pages.RegisterPopUpPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;


public class RegisterPopUpSteps {
    RegisterPopUpPage registerPopUpPage = new RegisterPopUpPage();

    @Step("Clicking On Register")
    public RegisterPopUpSteps clickOnRegister(){
        registerPopUpPage.registration.click();
        return this;
    }

    @Step("Filling First Name")
    public RegisterPopUpSteps fillFirstName(String name){
        registerPopUpPage.firstName.sendKeys(name);
        return this;
    }

    @Step("Filling Last Name")
    public RegisterPopUpSteps fillLastName(String lname){
        registerPopUpPage.lastName.sendKeys(lname);
        return this;
    }

    @Step("Filling Email")
    public RegisterPopUpSteps fillEmail(String email){
        registerPopUpPage.email.sendKeys(email);
        return this;
    }
    @Step("Filling Phone Number")
    public RegisterPopUpSteps fillPhone(String phone){
        registerPopUpPage.phone.sendKeys(phone);
        return this;
    }

    @Step("Filling Date")
    public RegisterPopUpSteps fillDate(String date){
        registerPopUpPage.dataBirth.sendKeys(date);
        return this;
    }

    @Step("Filling Password")
    public RegisterPopUpSteps fillPass(String password){
        registerPopUpPage.password.sendKeys(password);
        return this;
    }

    @Step("Filling Confirm Password")
    public RegisterPopUpSteps fillConfirmPass(String password){
        registerPopUpPage.confirmPassword.sendKeys(password);
        return this;
    }

    @Step("Clicking On Agree Terms CheckBox")
    public RegisterPopUpSteps clickOnAgree(){
        registerPopUpPage.agreeTerms.click();
        return this;
    }

    @Step("Clicking On Register Button")
    public RegisterPopUpSteps clickOnRegisterButton(){
        registerPopUpPage.registrationButton.click();
        return this;
    }

    @Step("Checking Message")
    public RegisterPopUpSteps checkMessage(){
        registerPopUpPage.infoMessage.shouldHave(text("გთხოვთ აირჩიოთ სქესი!"));
        return this;
    }
}

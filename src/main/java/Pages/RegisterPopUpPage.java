package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPopUpPage {
    public SelenideElement popUp = $(".login-register-outer"),
            registration = $(".register"),
            firstName = $("#pFirstName"),
            lastName = $("#pLastName"),
            email = $("#pEmail"),
            phone = $("#pPhone"),
            dataBirth = $("#pDateBirth"),
            password = $("#pPassword"),
            confirmPassword = $("#pConfirmPassword"),
            agreeTerms = $("#pIsAgreeTerns"),
            registrationButton = $(".dashbord-registration"),
            infoMessage = $("#physicalInfoMassage");



}

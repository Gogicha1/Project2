package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SideMenuPage {
    public SelenideElement minPriceInput = $("[class*='category-filter-desk']").$("[id='minprice']"),
            maxPriceInput = $("[class*='category-filter-desk']").$("[id='maxprice']"),
            submitButton = $("[class*='category-filter-desk']").$(".submit-button");
}

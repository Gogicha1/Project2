package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SushiPage {
    public SelenideElement sushiObject = $("[class*='deal-container']").$(".special-offer:first-child"),
            firstSushiWishlist = sushiObject.$(".deal-basket-wishlist"),
            voucherCount = sushiObject.$(".voucher-diagram div"),

            sort = $(".category-page-head").$("#sort"),
            price1 = sushiObject.$(".discounted-prices p:first-child"),
            price2 = $("[class*='deal-container']").$(".special-offer:nth-child(2)").$(".discounted-prices p:first-child");


}

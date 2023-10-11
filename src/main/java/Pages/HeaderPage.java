package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderPage {
    public SelenideElement hotelsPageButton = $x("//div[@class='Menus']//a[contains(@href, '/category/24/dasveneba')]"),
            categoriesTitle = $(".categoriesTitle"),
            eat = $("[cat_id = 'CatId-3']"),
            sushi = $("[class *= subCategory-3] ul li:nth-child(5) a"),
            login = $(".HeaderTools.swoop-login");
}

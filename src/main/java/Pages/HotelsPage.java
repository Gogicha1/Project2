package Pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class HotelsPage {
    public ElementsCollection hotels = $("[class*='deal-container']").$$(".special-offer");





}

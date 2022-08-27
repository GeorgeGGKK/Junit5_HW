package com.alconost.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static SelenideElement languageMenu = $x("//a[@class='language']");
    private static ElementsCollection languageSwitchers = $$(".language-switcher a");
    private static ElementsCollection buttonNames = $$x("//div[@class='menu-sections']//span[@class='section-name']");

    public void languageSelectionAndMenuButtonComparison(String language, List<String> expected) {
        languageMenu.click();
        languageSwitchers.find(text(language)).click();
        buttonNames.shouldHave(CollectionCondition.texts(expected));
    }
}

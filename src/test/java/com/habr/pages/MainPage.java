package com.habr.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
private static SelenideElement searchButton = $x("//a[@data-test-id='search-button']");
private static SelenideElement searchInput = $x("//input[@name='q']");

public SearchResultPage searchByValue(String name){
    searchButton.click();
    searchInput.setValue(name).pressEnter();
    return new SearchResultPage();
}
}

package com.habr.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {
    private static ElementsCollection reports = $$x("//h2");

    public ReportPage choiceOfReport() {
        reports.first().click();
        return new ReportPage();
    }
}

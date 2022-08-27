package com.habr.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ReportPage {
    private static SelenideElement reportBody = $x("//div[@id='post-content-body']");

    public void equalReportOwner(String name) {
        reportBody.shouldHave(text(name));
    }
    public void equalReportOwnersAndNameReports(String name, String report) {
        reportBody.shouldHave(text(name));
        reportBody.shouldHave(text(report));
    }
}

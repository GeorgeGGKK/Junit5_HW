package com.habr.tests;

import com.habr.helpers.BaseTest;
import com.habr.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Веб тесты на Хабре")
public class HabrTests extends BaseTest {
    private static String nameReportTest = "Дизайнерское тестирование: топ-10 докладов Heisenbug 2018 Piter";
    private static String nameTest = "Дмитрий Тучс";
    MainPage mainPage = new MainPage();

    @DisplayName("Поиск доклада на сайте Хабра")
    @Test
    public void searchReportDefault() {
        open(" ");
        mainPage.searchByValue(nameReportTest)
                .choiceOfReport()
                .equalReportOwner(nameTest);
    }

    @DisplayName("Поиск доклада на сайте Хабр. Junit5 - ValueSource")
    @ParameterizedTest(name = "Докладчик - {0}")
    @ValueSource(strings = {"Дмитрий Тучс","Артем Ерошенко"})
    public void searchReport(String reportOwner) {
        open(" ");
        mainPage.searchByValue(nameReportTest)
                .choiceOfReport()
                .equalReportOwner(reportOwner);
    }

    @DisplayName("Поиск доклада на сайте Хабр. Junit5 - CsvSource")
    @ParameterizedTest(name = "Докладчик - {0}, Название доклада - {1}")
    @CsvSource(value = {
            "Дмитрий Тучс, JUnit, дай пять! Переносим код в JUnit 5 Extensions",
            "Артем Ерошенко, Вы всё еще пилите свой отчет? Тогда мы идем к вам!"
    })
    public void searchReport2(String reportOwner, String nameReport) {
        open(" ");
        mainPage.searchByValue(nameReportTest)
                .choiceOfReport()
                .equalReportOwnersAndNameReports(reportOwner,nameReport);
    }
}

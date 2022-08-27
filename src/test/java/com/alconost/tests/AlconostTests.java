package com.alconost.tests;

import com.alconost.pages.MainPage;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AlconostTests {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> dataProviderForAlconostSiteMenuTest() {
        return Stream.of(
                Arguments.of("Deutsch", List.of("Lokalisierung & Übersetzung", "Videoproduktion",
                        "Mehrsprachiges Marketing", "Unternehmen")),
                Arguments.of("Русский", List.of("Локализация и перевод", "Создание видеороликов",
                        "Мультиязычный маркетинг", "Компания"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки меню: {1}")
    public void dataProviderForAlconostSiteMenuTest(String lang, List<String> expectedButtons) {
        open("https://alconost.com/");
        mainPage.
                languageSelectionAndMenuButtonComparison(lang, expectedButtons);
    }
}

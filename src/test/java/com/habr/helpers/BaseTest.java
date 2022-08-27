package com.habr.helpers;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "2160x1440";
        Configuration.baseUrl = "https://habr.com/ru";
    }
}

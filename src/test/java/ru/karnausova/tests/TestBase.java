package ru.karnausova.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.*;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class TestBase {
    @Test
    @Step("Тестовый тест на playwright")
    public void test() {
        try (Playwright playwright = Playwright.create()) {

            LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200);
            BrowserType webkit = playwright.webkit();
            BrowserType chrome = playwright.chromium();
            BrowserType firefox = playwright.firefox();

            Browser browser = webkit.launch(options);

            Page page = browser.newPage();
            page.navigate("https://leonardo.ru/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

            System.out.println("тест закончен");
        }
    }
}
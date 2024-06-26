package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BeforeAfterForTest {

    protected static final String URL = "https://qa-scooter.praktikum-services.ru/";

    WebDriver webDriver;
    @Before
    public void init() {
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void destroy() {
        webDriver.quit();
    }
}

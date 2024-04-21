package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webDriver;

    By headerOrderButton = By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']");
    By centerOrderButton = By.xpath("//div[contains(@class,'Button')]/button[text()='Заказать']");
    By cookiesButton = By.id("rcc-confirm-button");

    By accordionExpandText;

    private final String questionAccordion = "accordion__heading-%s";
    private final String answerAccordion = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickHeaderOrderButton() {
        webDriver.findElement(headerOrderButton).click();
    }

    public void clickCenterOrderButton() {
        WebElement element = webDriver.findElement(centerOrderButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(3L)).until(ExpectedConditions.elementToBeClickable(element));
        webDriver.findElement(centerOrderButton).click();
    }

    public void closeCookiesWindow() {
        webDriver.findElement(cookiesButton).click();
    }

    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionAccordion, index)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(3L)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String expectAnswer) {
        accordionExpandText = By.xpath(String.format(answerAccordion, expectAnswer));
        WebElement element = webDriver.findElement(accordionExpandText);
        new WebDriverWait(webDriver, Duration.ofSeconds(3L)).until(ExpectedConditions.textToBePresentInElementLocated(accordionExpandText, expectAnswer));
        return element.isDisplayed();
    }
}

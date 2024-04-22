package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver webDriver;
    private final By inputFieldName = By.xpath("//input[@placeholder='* Имя']");
    private final By inputFieldLastName = By.xpath("//input[@placeholder='* Фамилия']");
    private final By inputFieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputFieldSubway = By.xpath("//input[@placeholder='* Станция метро']");
    private final By inputFieldPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//div[contains(@class,'Order_NextButton')]/button[text()='Далее']");
    private final By inputFieldDeliveryDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By inputFieldRendPeriod = By.xpath("//div[(@class='Dropdown-placeholder') and text()='* Срок аренды']");
    private final By orderButton = By.xpath("//div[contains(@class,'Button')]/button[text()='Заказать']");
    private final By orderModalHeaderConfirmationButton = By.xpath("//button[text()='Да']");
    private final By successOrderWindow = By.xpath("//div[(@class = 'Order_ModalHeader__3FDaJ') and text()='Заказ оформлен']");
    private By chooseRendPeriodLocator;
    private By dropDownSubwayStation;
    private final String chooseRendPeriod = "//div[(@class='Dropdown-option') and text()='%s']";
    private final String subwayStation = "//div[text()= '%s']";

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputName(String name) {
        webDriver.findElement(inputFieldName).sendKeys(name);
    }

    public void inputLastName(String lastName) {
        webDriver.findElement(inputFieldLastName).sendKeys(lastName);
    }

    public void inputAddress(String address) {
        webDriver.findElement(inputFieldAddress).sendKeys(address);
    }

    public void inputSubway(String subway) {
        webDriver.findElement(inputFieldSubway).sendKeys(subway);
        dropDownSubwayStation = By.xpath(String.format(subwayStation, subway));
        webDriver.findElement(dropDownSubwayStation).click();
    }

    public void inputPhone(String phone) {
        webDriver.findElement(inputFieldPhone).sendKeys(phone);
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    public void inputDeliveryDate(String date) {
        new WebDriverWait(webDriver, Duration.ofSeconds(5L)).until(ExpectedConditions.presenceOfElementLocated(inputFieldDeliveryDate));
        webDriver.findElement(inputFieldDeliveryDate).sendKeys(date, Keys.ENTER);
    }

    public void inputRendPeriod(String period) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3L)).until(ExpectedConditions.elementToBeClickable(inputFieldRendPeriod));
        webDriver.findElement(inputFieldRendPeriod).click();
        chooseRendPeriodLocator = By.xpath(String.format(chooseRendPeriod, period));
        webDriver.findElement(chooseRendPeriodLocator).click();
    }

    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    public void orderConfirmationButton() {
        webDriver.findElement(orderModalHeaderConfirmationButton).click();
    }

    public boolean isSuccessOrderWindow() {
        return webDriver.findElement(successOrderWindow).isDisplayed();
    }
}

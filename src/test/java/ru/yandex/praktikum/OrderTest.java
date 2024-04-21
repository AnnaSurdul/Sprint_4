package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BeforeAfterForTest{

    private final String name;
    private final String lastName;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final String deliveryDate;
    private final String rentPeriod;

    public OrderTest(String name, String lastName, String address, String subwayStation, String phone, String deliveryDate, String rentPeriod) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentPeriod = rentPeriod;
    }

    @Parameterized.Parameters
    public static String[][] text() {
        return new  String[][]{
                {"Алексей", "Иванов", "Тунгуская 9", "Университет", "12345678900", "12.06.2024", "сутки" },
                {"Санёк", "Петров", "Новомосковская 7", "Фрунзенская", "12345678900", "07.05.2024", "трое суток" },
                {"Анна", "Сидорова", "Никифорова 16", "Нагатинская", "12345678900", "16.07.2024", "семеро суток" },
        };
    }

    @Test
    public void headerOrderTest() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.clickHeaderOrderButton();
        orderPage.inputName(name);
        orderPage.inputLastName(lastName);
        orderPage.inputAddress(address);
        orderPage.inputSubway(subwayStation);
        orderPage.inputPhone(phone);
        orderPage.clickNextButton();
        orderPage.inputDeliveryDate(deliveryDate);
        orderPage.inputRendPeriod(rentPeriod);
        orderPage.clickOrderButton();
        orderPage.orderConfirmationButton();
        boolean isSuccessOrderWindow = orderPage.isSuccessOrderWindow();
        assertTrue(isSuccessOrderWindow);
    }

    @Test
    public void centerOrderTest() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        mainPage.closeCookiesWindow();
        mainPage.clickCenterOrderButton();
        orderPage.inputName(name);
        orderPage.inputLastName(lastName);
        orderPage.inputAddress(address);
        orderPage.inputSubway(subwayStation);
        orderPage.inputPhone(phone);
        orderPage.clickNextButton();
        orderPage.inputDeliveryDate(deliveryDate);
        orderPage.inputRendPeriod(rentPeriod);
        orderPage.clickOrderButton();
        orderPage.orderConfirmationButton();
        boolean isSuccessOrderWindow = orderPage.isSuccessOrderWindow();
        assertTrue(isSuccessOrderWindow);
    }
}

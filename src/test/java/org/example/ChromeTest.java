package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.model.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ChromeTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        driver.manage().deleteAllCookies();

        homePage = new HomePage(driver);
        homePage.closeCookiesPopup();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", homePage.getBlockTitle(), "Название блока не совпадает!");
    }

    @Test
    void testEmptyFieldsValidation() {
        homePage.selectServiceType("Услуги связи");
        homePage.verifyEmptyFieldsMessages();
    }

    @Test
    void testOnlinePaymentForm() {
        homePage.selectServiceType("Услуги связи");
        homePage.fillPaymentForm("297777777", "5");
        homePage.verifyPaymentForm("297777777", "5.00 BYN");
    }
}
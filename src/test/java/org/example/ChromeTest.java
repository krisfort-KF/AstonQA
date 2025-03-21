package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://www.mts.by/");

        // Закрываем всплывающее окно с куками, если оно появилось
        closeCookiesPopup();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {

        // Найти заголовок блока "Онлайн пополнение без комиссии"
        String blockTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']" +
                "//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")).getText();

        // Проверить соответствие текста, убирая возможные переносы строк
        assertEquals("Онлайн пополнение без комиссии", blockTitle.replace("\n", " "), "Название блока не совпадает!");
    }

    private void closeCookiesPopup() {
        try {
            // Найти и нажать кнопку "Принять" в окне с куками
            driver.findElement(By.xpath("//button[@id=\"cookie-agree\"]")).click();
        } catch (NoSuchElementException e) {
            // Если окно не появилось, продолжаем тест дальше
            System.out.println("Окно с куками не появилось.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
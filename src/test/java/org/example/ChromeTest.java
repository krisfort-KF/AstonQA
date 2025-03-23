package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ChromeTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().deleteAllCookies();

        closeCookiesPopup();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {

        String blockTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']" +
                "//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")).getText();

        assertEquals("Онлайн пополнение без комиссии", blockTitle.replace("\n", " "), "Название блока не совпадает!");
    }

    private void closeCookiesPopup() {
        try {
            driver.findElement(By.xpath("//button[@id=\"cookie-agree\"]")).click();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Окно с куками не появилось.");
        }
    }

    @Test
    void testPaymentLogosPresence() {

        WebElement logoElement1 = driver.findElement(By.xpath("//div[@class='pay__partners']//ul/li/img[contains(@src, 'visa.svg')]"));
        WebElement logoElement2 = driver.findElement(By.xpath("//div[@class='pay__partners']//ul/li/img[contains(@src, 'visa-verified.svg')]"));
        WebElement logoElement3 = driver.findElement(By.xpath("//div[@class='pay__partners']//ul/li/img[contains(@src, 'mastercard.svg')]"));
        WebElement logoElement4 = driver.findElement(By.xpath("//div[@class='pay__partners']//ul/li[img[contains(@src, 'mastercard-secure.svg')]]"));
        WebElement logoElement5 = driver.findElement(By.xpath("//div[@class='pay__partners']//ul/li[img[contains(@src, 'belkart.svg')]]"));

        assertTrue(logoElement1.isDisplayed(), "Логотип visa не найден на странице!");
        assertTrue(logoElement2.isDisplayed(), "Логотип mastercard не найден на странице!");
        assertTrue(logoElement3.isDisplayed(), "Логотип belkart не найден на странице!");
        assertTrue(logoElement4.isDisplayed(), "Логотип maestro не найден на странице!");
        assertTrue(logoElement5.isDisplayed(), "Логотип mir не найден на странице!");
    }

    @Test
    void testServiceDetailsLink() {
        WebElement detailsLink = driver.findElement(By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));

        assertNotNull(detailsLink, "Ссылка 'Подробнее о сервисе' не найдена");
        assertTrue(detailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        assertTrue(detailsLink.isEnabled(), "Ссылка 'Подробнее о сервисе' не активна");
        detailsLink.click();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertEquals(expectedUrl, driver.getCurrentUrl(), "Некорректный URL после перехода по ссылке");
    }

    @Test
    void testOnlinePaymentForm() {
        WebElement phoneInput = driver.findElement(By.xpath("//form[@id='pay-connection']//input[@id='connection-phone' and @type='text']"));
        phoneInput.sendKeys("297777777");

        WebElement serviceType = driver.findElement(By.xpath("//div[@class='select__wrapper']/button[@class='select__header']"));
        if (!serviceType.isSelected()) {
            serviceType.click();
        }
        WebElement amountInput = driver.findElement(By.xpath("//div[@class='input-wrapper input-wrapper_label-right']/input[@id='connection-sum']"));
        amountInput.sendKeys("5");

        WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and text()='Продолжить']"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement paymentStep = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper__content']")));
        assertTrue(paymentStep.isDisplayed(), "Форма оплаты не открылась!");
    }
}
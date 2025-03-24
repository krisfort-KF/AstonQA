package org.example.model;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
        private WebDriver driver;
        private WebDriverWait wait;

        private By cookiesPopupButton = By.xpath("//button[@id='cookie-agree']");
        private By blockTitleLocator = By.xpath("//div[@class='pay__wrapper']//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]");
        private By serviceTypeDropdown = By.xpath("//div[@class='select__wrapper']/button[@class='select__header']");
        private By phoneInput = By.xpath("//input[@id='connection-phone']");
        private By amountInput = By.xpath("//input[@id='connection-sum']");
        private By continueButton = By.xpath("//button[@type='submit' and text()='Продолжить']");
        private By paymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
        private By paymentStep = By.xpath("//div[@class='app-wrapper__content']");

        private By telecomOption = By.xpath("//button[@class='select__header']/span[@class='select__now' and text()='Услуги связи']");
        private By internetOption = By.xpath("//p[@class='select__option' and text()='Домашний интернет']");
        private By installmentOption = By.xpath("//li[contains(@class, 'select__item') and contains(@class, 'active')]/p[text()='Рассрочка']");
        private By debtOption = By.xpath("//li[contains(@class, 'select__item') and contains(@class, 'active')]/p[text()='Задолженность']");                            //задолженность

        private By emptyPhoneMessage = By.xpath("//input[@type='text' and @placeholder='Номер телефона']");
        private By emptyAmountMessage = By.xpath("//input[@type='text' and @placeholder='Сумма']");
        private By cardNumberField = By.xpath("//label[contains(text(), 'Номер карты')]");
        private By paymentSystemIconVisa = By.xpath("//img[contains(@src, 'visa-system.svg')]");
        private By paymentSystemIconMasterCard = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
        private By paymentSystemIconBelkart= By.xpath("//img[contains(@src, 'belkart-system.svg')]");



        public HomePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void closeCookiesPopup() {
            try {
                driver.findElement(cookiesPopupButton).click();
            } catch (NoSuchElementException | ElementNotInteractableException e) {
                System.out.println("Окно с куками не появилось.");
            }
        }

        public String getBlockTitle() {
            return driver.findElement(blockTitleLocator).getText().replace("\n", " ");
        }

        public void selectServiceType(String type) {
            driver.findElement(serviceTypeDropdown).click();
            switch (type) {
                case "Услуги связи":
                    driver.findElement(telecomOption).click();
                    break;
                case "Домашний интернет":
                    driver.findElement(internetOption).click();
                    break;
                case "Рассрочка":
                    driver.findElement(installmentOption).click();
                    break;
                case "Задолженность":
                    driver.findElement(debtOption).click();
                    break;
            }
        }

        public void verifyEmptyFieldsMessages() {
            driver.findElement(continueButton).click();
            assertTrue(driver.findElement(emptyPhoneMessage).isDisplayed(), "Сообщение о пустом номере телефона отсутствует!");
            assertTrue(driver.findElement(emptyAmountMessage).isDisplayed(), "Сообщение о пустой сумме отсутствует!");
        }

        public void fillPaymentForm(String phone, String amount) {
            driver.findElement(phoneInput).sendKeys(phone);
            driver.findElement(amountInput).sendKeys(amount);
            driver.findElement(continueButton).click();
        }

        public void verifyPaymentForm(String expectedPhone, String expectedAmount) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));

            WebElement paymentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentStep));
            assertTrue(paymentElement.isDisplayed(), "Форма оплаты не открылась!");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement phoneField = driver.findElement(By.xpath("//div[@class = 'pay-description__text']" +
                    "/span[contains(text(), 'Оплата: Услуги связи') and contains(text(), 'Номер:375" + expectedPhone + "')]"));
            assertTrue(phoneField.isDisplayed(), "Номер телефона не совпадает!");

            WebElement amountField = driver.findElement(By.xpath("//div[@class = 'pay-description__cost']/span[text()='" + expectedAmount + "']"));
            assertTrue(amountField.isDisplayed(), "Сумма платежа не совпадает!");

            assertTrue(driver.findElement(cardNumberField).isDisplayed(), "Поле ввода номера карты отсутствует!");
            assertTrue(driver.findElement(paymentSystemIconVisa).isDisplayed(), "Иконка платежной системы Visa отсутствует!");
            assertTrue(driver.findElement(paymentSystemIconMasterCard).isDisplayed(), "Иконка платежной системы MasterCard отсутствует!");
            assertTrue(driver.findElement(paymentSystemIconBelkart).isDisplayed(), "Иконка платежной системы Belkart отсутствует!");
        }
    }


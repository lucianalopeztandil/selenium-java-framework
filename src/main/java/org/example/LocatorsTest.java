package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.FirstPage;
import page_objects.LoginPage;
import page_objects.PasswordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocatorsTest {

    private static final Logger logger = LogManager.getLogger(LocatorsTest.class);
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

    }

    @Test
    public void executionLocators() {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        FirstPage firstPage = new FirstPage(driver);
        firstPage.executeLogin("Rahul", "Hello1234");
        logger.info("Se ejecuta el primer login incorrecto.");
        System.out.println(firstPage.getMessageError());
        logger.info("Se selecciona el link de olvido de password");
        firstPage.clickForgotPassword();
        PasswordPage passwordPage = new PasswordPage(driver);
        logger.info("Se resetea el password con el usuario de Evelyn.");
        passwordPage.resetData("Evelyn", "eveTand@gmail.com");
        passwordPage.clickResetBtn();

        String password = passwordPage.getPassword();
        passwordPage.clickToLogin();

        logger.info("Se ejecuta el loguin con los datos correctos.");
        firstPage.executeLogin("Evelyn", password);
        LoginPage loginPage = new LoginPage(driver);
        String successMessage = loginPage.getSucessMessage();
        System.out.println(successMessage);

        Assert.assertEquals(successMessage, "You are successfully logged in.", "El mensaje no coincide");

        driver.close();
    }
}

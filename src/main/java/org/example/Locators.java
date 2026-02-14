package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import page_objects.FirstPage;
import page_objects.LoginPage;
import page_objects.PasswordPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Locators {

    private static final Logger logger = LogManager.getLogger(Locators.class);

    static void main() {
        WebDriver driver = new ChromeDriver();
        FirstPage firstPage = new FirstPage(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
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

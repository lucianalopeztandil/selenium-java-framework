package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.FirstPage;
import page_objects.LoginPage;
import page_objects.PasswordPage;

public class Locators {
    static void main() {
        WebDriver driver = new ChromeDriver();
        FirstPage firstPage = new FirstPage(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        firstPage.executeLogin("Rahul", "Hello1234");
        System.out.println(firstPage.getMessageError());
        firstPage.clickForgotPassword();
        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.resetData("Evelyn", "eveTand@gmail.com");
        passwordPage.clickResetBtn();

        String password = passwordPage.getPassword();
        passwordPage.clickToLogin();

        firstPage.executeLogin("Evelyn", password);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginPage.getSucessMessage());

        driver.close();
    }
}

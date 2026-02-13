package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.general.BasePage;

import java.time.Duration;

public class FirstPage extends BasePage {

    private By inputUsername = By.id("inputUsername");
    private By inputPassword = By.name("inputPassword");
    private By signInBtn = By.className("signInBtn");
    private By error = By.className("error");
    private By forgotPassword = By.linkText("Forgot your password?");

    public FirstPage(WebDriver driver){
        super(driver);
    }

    public void executeLogin(String username, String password){
        driver.findElement(inputUsername).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("overlay-panel")));
        clickBtn(signInBtn);
    }

    public void printError(){
        System.out.println(driver.findElement(error).getText());
    }

    public void clickForgotPassword(){
        clickBtn(forgotPassword);
    }
}

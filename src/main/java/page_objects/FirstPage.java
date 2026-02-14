package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.general.BasePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstPage extends BasePage {

    private By inputUsername = By.id("inputUsername");
    private By inputPassword = By.name("inputPassword");
    private By signInBtn = By.className("signInBtn");
    private By error = By.className("error");
    private By forgotPassword = By.linkText("Forgot your password?");
    private static final Logger logger = LogManager.getLogger(FirstPage.class);

    public FirstPage(WebDriver driver){
        super(driver);
    }

    public void executeLogin(String username, String password){
        driver.findElement(inputUsername).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("overlay-panel")));
        logger.info("Se procede a ejecutar el login del usuario " + username);
        clickBtn(signInBtn);
    }

    public String getMessageError(){
        return getText(error);
    }

    public void clickForgotPassword(){
        clickBtn(forgotPassword);
    }
}

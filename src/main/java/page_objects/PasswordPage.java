package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.general.BasePage;

public class PasswordPage extends BasePage {
    private By userName = By.xpath("//input[@placeholder='Name']");
    private By userEmail = By.xpath("//input[@placeholder='Email']");
    private By resetBtn = By.className("reset-pwd-btn");
    private By loginBtn = By.className("go-to-login-btn");
    private By infoMsg = By.className("infoMsg");

    public PasswordPage(WebDriver driver){
        super(driver);
    }

    public void resetData(String username, String email){
        driver.findElement(userName).
                sendKeys(username);
        driver.findElement(userEmail).
                sendKeys(email);
    }

    public void clickResetBtn(){
        clickBtn(resetBtn);
    }

    public void clickToLogin(){
        clickBtn(loginBtn);
    }

    public String getPassword(){
        String loginMsg = driver.findElement(infoMsg).getText();
        System.out.println("The new password is: " + loginMsg);
        String[] loginData = loginMsg.split("'");
        return loginData[1];
    }
}

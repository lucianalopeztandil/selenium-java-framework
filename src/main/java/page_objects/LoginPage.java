package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.general.BasePage;

public class LoginPage extends BasePage {
    private By loginMsg = By.xpath("//div[@class='login-container']/p");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public String getSucessMessage(){
        return getText(loginMsg);
    }
}

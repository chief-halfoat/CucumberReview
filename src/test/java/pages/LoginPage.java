package pages;


import utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement usernameTxtField;
    @FindBy(id = "txtPassword")
    public WebElement passwordTxtField;
    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}

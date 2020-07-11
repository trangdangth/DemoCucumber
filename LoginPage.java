package loginfunction;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class LoginPage {
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 30);
    }
    //locators
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private WebElement company;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@type='tel']")
    private List<WebElement> OTP;

    @FindBy(how = How.XPATH, using = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'Login__button')]")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//span[@class='NavSideHeader__header-title--xehbs']")
    private WebElement homeTitle;

    @FindBy(how = How.CLASS_NAME, using = "message")
    private WebElement error_message;

    public String baseUrl = "https://web.qa.leapxpert.app/account/profile";

    public void enter_company(String name){
        wait.until(ExpectedConditions.visibilityOf(company));
        company.sendKeys(name);
    }

    public void enter_username(String user_name){
        wait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(user_name);
    }

    public void enter_password(String pass){
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pass);
    }

    public void enter_otp(int num1, int num2, int num3, int num4, int num5, int num6){
        wait.until(ExpectedConditions.visibilityOfAllElements(OTP));
        int[] my_num = {num1, num2, num3, num4, num5, num6};
        for(int i=0; i< OTP.size(); i++){
            OTP.get(i).sendKeys(String.valueOf(my_num[i]));
        }
    }

    public void tapOn_next_button(){
        nextButton.click();
    }

    public void tapOn_login_button(){
        loginButton.click();
    }

    public void home_title_displayed(){
        wait.until(ExpectedConditions.visibilityOf(homeTitle));
        String actual_text = homeTitle.getText();
        Assert.assertEquals("Chats", actual_text);
    }

    public void error_message_displayed(String message){
        wait.until(ExpectedConditions.visibilityOf(error_message));
        String actual_text = error_message.getText();
        Assert.assertEquals(message, actual_text);
    }
}
package loginfunction;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_steps {
    WebDriver driver;
    LoginPage login;

    @Given("the user input company name {string}")
    public void input_company_name(String name) {
        login.enter_company(name);
    }

    @When("the user input OTP {int} {int} {int} {int} {int} {int}")
    public void input_otp_number(int num1, int num2, int num3, int num4, int num5, int num6) {
        login.enter_otp(num1,num2,num3,num4,num5,num6);
    }

    @When("the user tap on {string} button")
    public void tap_on_button(String buttonName) {
        switch (buttonName){
            case "Next":
                login.tapOn_next_button();
                break;
            case "Login":
                login.tapOn_login_button();
                break;
                default :
                    System.out.println("no match");
        }
    }

    @When("the user input username {string} and password {string}")
    public void tap_on_button(String username, String pass) {
        login.enter_username(username);
        login.enter_password(pass);
    }

    @Then("^the user login to system successfully$")
    public void user_login_successfully() {
        login.home_title_displayed();
    }

    @Then("the user can see error message {string}")
    public void error_message_displayed(String message) {
        login.error_message_displayed(message);
    }

    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        login = new LoginPage(driver);
        driver.get(login.baseUrl);
    }

    @After
    public void afterScenario(){
        driver.quit();
    }

}

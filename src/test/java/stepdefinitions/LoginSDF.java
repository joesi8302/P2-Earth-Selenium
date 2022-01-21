package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;
import poms.ForgotPasswordPOM;

public class LoginSDF {
    LoginPOM loginPOM;
    

    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("A user is on the login page")
    public void a_user_is_on_the_login_page() throws InterruptedException {
        DriverSingleton.getInstance().get("http://localhost:4200/");
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.loginPOM.getCurrentUrl());
    }
    @When("A user inputs incorrect credentials on the login form")
    public void a_user_inputs_incorrect_credentials_on_the_login_form() {
        this.loginPOM.enterUsername("wrongturn");
        this.loginPOM.enterPassword("pass123");
        this.loginPOM.clickLogin();
    }
    @Then("invalid username or password will be displayed to the user")
    public void invalid_username_or_password_will_be_displayed_to_the_user() {
        Assertions.assertEquals("Invalid username or password", this.loginPOM.getMessage());
    }

    @When("A user inputs correct credentials on the login form")
    public void a_user_inputs_correct_credentials_on_the_login_form() {
        this.loginPOM.enterUsername("joesi");
        this.loginPOM.enterPassword("password");
        this.loginPOM.clickLogin();
        this.loginPOM.waitForSuccessfulLogin();

    }
    @Then("the user will be redirect to the user's account page")
    public void the_user_will_be_redirect_to_the_dashboard() {
        Assertions.assertEquals("http://localhost:4200/account", this.loginPOM.getCurrentUrl());
    }

    @When("A user clicks the register button")
    public void a_user_clicks_the_register_button() {
        this.loginPOM.clickRegister();
    }
    @Then("user will be redirected to the register page")
    public void user_will_be_redirected_to_the_register_page() {
        Assertions.assertEquals("http://localhost:4200/register", this.loginPOM.getCurrentUrl());
    }
    @When("A user clicks the forgot password link")
    public void a_user_clicks_the_forgot_password_link() {
        this.loginPOM.clickForgotPassword();
        this.loginPOM.waitForSuccessfulRedirect();

    }

    @Then("user will be redirected to the forgot password page")
    public void user_will_be_redirected_to_the_forgot_password_page() {

        Assertions.assertEquals("http://localhost:4200/forget-password", this.loginPOM.getCurrentUrl());
    }
}

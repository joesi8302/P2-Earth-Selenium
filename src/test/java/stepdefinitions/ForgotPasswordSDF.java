package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;

public class ForgotPasswordSDF {
    ForgotPasswordPOM forgotPasswordPOM;

    @Given("A user is on the login page")
    public void a_user_is_on_the_login_page() throws InterruptedException {
        DriverSingleton.getInstance().get("http://localhost:4200");
        Thread.sleep(5000);
        this.forgotPasswordPOM = new forgotPasswordPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.forgotPasswordPOM.getCurrentUrl());
    }
    @When("A user clicks the forgot password link")
    public void a_user_clicks_the_forgot_password_link() {
        this.forgotPasswordPOM.clickForgotPassword();
    }
    @Then("user will be redirected to the forgot password page")
    public void user_will_be_redirected_to_the_forgot_password_page() {
        this.forgotPasswordPOM.waitForSuccessfulRedirect();
        Assertions.assertEquals("http://localhost:4200/forget-password", this.forgotPasswordPOM.getCurrentUrl());
    }

    @Given("A user is on the forgot password page")
    public void a_user_is_on_the_forgot_password_page() throws InterruptedException {
        Assertions.assertEquals("http://localhost:4200/forget-password", this.forgotPasswordPOM.getCurrentUrl());
    }
    @When("A user enters an existing email")
    public void a_user_enters_an_existing_email(){
        this.registerPOM.enterEmail("joe.si@revature.net");
        this.forgotPasswordPOM.clickSend();
    }
    @Then("user clicks send and will be sent a temporary password")
    public void user_clicks_send_and_will_be_sent_a_temporary_password(){
        String success = this.forgotPasswordPOM.getSuccessMessage();
        Assertions.assertEquals("A temporary password has been sent.", success);
    }
}
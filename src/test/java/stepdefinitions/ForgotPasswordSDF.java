package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.ForgotPasswordPOM;

public class ForgotPasswordSDF {
    ForgotPasswordPOM forgotPasswordPOM;




    @Given("A user is on the forgot password page")
    public void a_user_is_on_the_forgot_password_page() throws InterruptedException {
        this.forgotPasswordPOM = new ForgotPasswordPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/forget-password", this.forgotPasswordPOM.getCurrentUrl());
    }
    @When("A user enters an existing email")
    public void a_user_enters_an_existing_email(){
        this.forgotPasswordPOM.enterEmail("joe.si@revature.net");

    }
    @Then("user clicks send and will be sent a temporary password")
    public void user_clicks_send_and_will_be_sent_a_temporary_password(){
        this.forgotPasswordPOM.clickSend();
        String success = this.forgotPasswordPOM.getSuccessMessage();
        Assertions.assertEquals("Email has been sent", success);
    }
}
package steps;

//import cucumber.api.PendingException;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.*;

import org.junit.Assert;
import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;


/**
 * Created by MiguelTerceros on 11/9/2015.
 */
public class Login {
    private PageTransporter page = PageTransporter.getInstance();
    private LoginPage loginPage;
    private LoginPage loginErrorPage;
    private MainPage mainPage;

//    private String errorEmail = "There isn't an account for this email";
//    private String errorPass = "Invalid password";
//    private String errorEmptyFields = "Missing email";


    @Given("^I navigate to login page of Trello.com$")
    public void navigateLoginPage(){
        loginPage = page.navigateToLoginPage();
    }

    @When("^I login in Trello.com as \"(.*?)\" with password \"(.*?)\"$")
    public void I_login_as_with_password(String userName, String userPassword){
        mainPage = loginPage.loginSuccessful(userName, userPassword);
    }

    @Then("^I should login to Trello.com successfully$")
    public void verifyMainTrelloIsDisplayed(){
        assertTrue(mainPage.isLogoTrelloDisplayed(), "the main project is displayed");
        mainPage.logout();
    }

    @When("^I login in Trello.com as \"(.*?)\" with wrong password \"(.*?)\"$")
    public void I_login_as_with_wrong_password(String userName, String userPassword){
        loginErrorPage = loginPage.loginFailed(userName, userPassword);
    }

    @Then("^I not should login to Trello.com$")
    public void verifyMainTrelloIsNotDisplayed(){
        assertTrue(loginErrorPage.getErrorMessage());
    }

    @When ("^I login in Trello.com with fields empty$")
    public void I_login_with_fields_empty(){
        loginErrorPage = loginPage.clickLoginBtnFailed();
    }

    @When("^I login in Trello.com with a wrong email \"(.*?)\"$")
    public void LoginWithAWrongEmail(String userName) throws Throwable {
        loginPage.setUserNameInput(userName);
        loginErrorPage = loginPage.clickLoginBtnFailed();
    }
}

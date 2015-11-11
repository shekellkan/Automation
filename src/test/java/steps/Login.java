package steps;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.PageTransporter;
import ui.pages.LoginPage;


/**
 * Created by MiguelTerceros on 11/9/2015.
 */
public class Login {
    private PageTransporter page = PageTransporter.getInstance();
    private LoginPage loginPage;
    private DriverManager automation = DriverManager.getInstance();
    private WebDriver driver;


    @Given("^I navigate to login page of Trello.com$")
    public void navigateLoginPage(){
       driver = automation.initialize();
        //driver.get("https://trello.com/login");
        page.navigateToLoginPage();
    }

    @When("^I login in Trello.com as \"(.*?)\" with password \"(.*?)\"$")
    public void I_login_as_with_password(String userName, String userPassword){
        driver.findElement(By.id("user")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(userPassword);
        driver.findElement(By.id("login")).click();
    }

    @Then("^I should login to Trello.com successfully$")
    public void verifyMainTrelloIsDisplayed(){
       Assert.assertEquals("Miguel Terceros", driver.findElement(By.xpath("//span[text()='Miguel Terceros']")).getText());
    }
}

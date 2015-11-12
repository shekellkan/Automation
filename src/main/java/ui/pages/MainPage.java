package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/11/15
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */


public class MainPage extends BasePageObject{
    PageTransporter page =PageTransporter.getInstance();

    @FindBy(xpath = "//a[@aria-label='Trello Home']")
    WebElement logo;

    @FindBy(xpath = "//span[contains(text(),'Miguel Terceros')]")
    WebElement users;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }
    public MainPage(){
        waitUntilPageObjectIsLoaded();
    }

    public boolean isUserNameDisplayed() {
        return users.isDisplayed();
    }

    public void logout() {
        users.click();
        logoutBtn.click();
        page.navigateToHomePage();
    }
}

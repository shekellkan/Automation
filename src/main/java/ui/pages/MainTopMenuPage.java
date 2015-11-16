package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;

/**
 * Created by amateur on 15/11/2015.
 */
public class MainTopMenuPage extends BasePageObject {
    PageTransporter page =PageTransporter.getInstance();

    @FindBy(xpath = "//a[@aria-label='Trello Home']")
    WebElement logo;

    @FindBy(xpath = "//a[contains(@aria-label,'Open Member Menu')]")
    WebElement users;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public MainTopMenuPage(){
        waitUntilPageObjectIsLoaded();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void logout() {
        users.click();
        logoutBtn.click();
        page.navigateToHomePage();
    }

    public WebElement getLogo(){
        return logo;
    }
}

package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectsPage extends BasePageObject {
    private MainTopMenuPage topMenu;

    @FindBy(xpath = "//span[@class='board-header-btn-text']")
    WebElement nameProject;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameProject));
    }

    public ProjectsPage(){
        //PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
        topMenu = new MainTopMenuPage();
    }

    public boolean isNameProjectDisplayed() {
        return nameProject.isDisplayed();
    }

    public WebElement titleProject(){
        return nameProject;
    }
}

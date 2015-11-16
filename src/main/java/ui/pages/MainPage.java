package ui.pages;

import org.apache.log4j.chainsaw.Main;
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
    MainTopMenuPage topMenuPage;

    @FindBy(xpath = "//a[contains(text(),'Create new board…')]")
    WebElement newProject;

    @FindBy(xpath = "//input[@id='boardNewTitle']")
    WebElement projectTitle;

    @FindBy(xpath = "//input[@value='Create']")
    WebElement createProject;

    public MainPage(){
        waitUntilPageObjectIsLoaded();
        topMenuPage = new MainTopMenuPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(topMenuPage.getLogo()));
    }

    public boolean isLogoTrelloDisplayed() {
        return topMenuPage.isLogoDisplayed();
    }

    public void logout() {
        topMenuPage.logout();
    }

    public MainPage clickNewProject(){
        newProject.click();
        return this;
    }

    public  MainPage setProjectTitle(String title){
        projectTitle.clear();
        projectTitle.sendKeys(title);
        return this;
    }

    public ProjectsPage clickCreateNewProject(){
        createProject.click();
        return new ProjectsPage();
    }

    public ProjectsPage createNewProjects(String title){
        clickNewProject();
        setProjectTitle(title);
        return clickCreateNewProject();
    }
}

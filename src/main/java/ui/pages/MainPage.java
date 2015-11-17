package ui.pages;

import common.Utils;
import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.By;
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
    //MainTopMenuPage topMenuPage;
    //declare WebElements
    @FindBy(xpath = "//li/a[contains(text(),'Create new board…')]")
    WebElement newProject;
    @FindBy(xpath = "//a[@aria-label='Trello Home']")
    WebElement logo;
    @FindBy(xpath = "//a[contains(@aria-label,'Open Member Menu')]")
    WebElement users;
    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logoutBtn;
    @FindBy(xpath = "//input[@id='boardNewTitle']")
    WebElement projectTitle;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement createProject;
    @FindBy(xpath = "//a[contains(text(),'Create a new team…')]")
    WebElement teamsBtn;
    @FindBy(xpath = "//input[@id='org-display-name']")
    WebElement teamsTitle;
    @FindBy(xpath = "//textarea[@id='org-desc']")
    WebElement teamsDescription;
    @FindBy(xpath = "//input[@value='Create']")
    WebElement teamsCreateBtn;

    public MainPage(){
        waitUntilPageObjectIsLoaded();
        //topMenuPage = new MainTopMenuPage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //logo = topMenuPage.getLogo();
        //System.out.println(logo.getText());
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    public boolean isLogoTrelloDisplayed() {
        return logo.isDisplayed();//topMenuPage.isLogoDisplayed();
    }

    public void logout() {
        //topMenuPage.logout();
        users.click();
        logoutBtn.click();
        page.navigateToHomePage();
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

    public MainPage clickNewTeams(){
        teamsBtn.click();
        return this;
    }

    public  MainPage setTeamsTitle(String title){
        teamsTitle.clear();
        teamsTitle.sendKeys(title);
        return this;
    }

    public  MainPage setTeamsDescription(String description){
        teamsDescription.clear();
        teamsDescription.sendKeys(description);
        return this;
    }

    public TeamsPage createNewTeams(String name){
        setTeamsTitle(name);
        teamsCreateBtn.click();
        return new TeamsPage();
    }

    public TeamsPage createNewTeamsWithDescription(String name, String description){
        setTeamsTitle(name);
        setTeamsDescription(description);
        teamsCreateBtn.click();
        return new TeamsPage();
    }

    public boolean isTeamPresent(String nameTeam){
        By isDeleted = By.xpath("//div[@class='boards-page-board-section-header']/h3[contains(text(),'"+nameTeam+"')]");
        return Utils.isElementPresent(isDeleted);
    }
}

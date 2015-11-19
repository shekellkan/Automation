package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamsPage extends BasePageObject {
    @FindBy(xpath = "//h1[@class='u-inline']")
    WebElement titleTeam;
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
    WebElement menuSettings;
    @FindBy(xpath = "//a[contains(text(),'Boards')]")
    WebElement menuBoards;
    @FindBy(xpath = "//a[contains(text(),'Members')]")
    WebElement menuMembers;
    @FindBy(xpath = "//a[contains(text(),'Business Class')]")
    WebElement menuBusiness;
    @FindBy(xpath = "//a[contains(text(), 'Delete this team?')]")
    WebElement deletedBtn;
    @FindBy(xpath = "//input[@value='Delete Forever']")
    WebElement deletedForever;
    @FindBy(xpath = "//a[contains(text(), 'Add Members')]")
    WebElement addMembersBtn;
    @FindBy(xpath = "//div[@class='search-with-spinner']/input")
    WebElement setEmailField;
    @FindBy(xpath = "//a[contains(@class,'icon-close' )]")
    WebElement iconClose;
    @FindBy(xpath = "//div[contains(@class,'js-search-results')]/ul/div/li/a")
    WebElement membersOption;

    WebElement memberInTeam = null;

    public TeamsPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleTeam));
    }

    public boolean isNameTeamsDisplayed() {
        return titleTeam.isDisplayed();
    }

    public String nameTeam(){
        return titleTeam.getText();
    }

    public TeamsPage clickMenuSetting(){
        menuSettings.click();
        wait.until(ExpectedConditions.visibilityOf(deletedBtn));
        return this;
    }

    public TeamsPage clickMenuBoards(){
        menuBoards.click();
        return this;
    }

    public TeamsPage clickMenuMembers(){
        menuMembers.click();
        wait.until(ExpectedConditions.visibilityOf(addMembersBtn));
        return this;
    }

    public TeamsPage clickMenuBusiness(){
        menuBusiness.click();
        return this;
    }

    public TeamsPage clickBtnDeleted(){
        deletedBtn.click();
        return this;
    }

    public MainPage clickBtnDeletedForever(){
        deletedForever.click();
        waitUntilPageObjectIsLoaded();
        return new MainPage();
    }

    public TeamsPage clickAddMembersBtn(){
        addMembersBtn.click();
        return this;
    }

    public TeamsPage setEmailMembers(String email){
        setEmailField.clear();
        setEmailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(membersOption));
        return this;
    }

    public TeamsPage clickMemberOptions(){
        membersOption.click();
        return this;
    }

    public TeamsPage clickIconClose(){
        iconClose.click();
        return this;
    }

    public String isNewMemberTeamDisplayed(String fullName){
        memberInTeam = driver.findElement(By.xpath("//span[contains(text(),'"+fullName+"')]"));
        System.out.println(memberInTeam.getText());
        return memberInTeam.getText();
    }

    public TeamsPage addMemberInTeam(String email){
        clickAddMembersBtn();
        setEmailMembers(email);
        clickMemberOptions();
        clickIconClose();
        return this;
    }
}

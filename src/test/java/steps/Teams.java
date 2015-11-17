package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import ui.pages.MainPage;
import ui.pages.TeamsPage;

/**
 * Created with IntelliJ IDEA.
 * User: MiguelTerceros
 * Date: 11/17/15
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teams {
    private MainPage mainPage = new MainPage();
    private TeamsPage teamPage;// = new TeamsPage();

    @Given("^I need a new team$")
    public void new_Team(){
        mainPage.clickNewTeams();
    }

    @And("^I have to create a new team \"([^\"]*)\"$")
    public void create_Teams(String name){
        teamPage = mainPage.createNewTeams(name);
    }

    @And("^I have to create a new team \"([^\"]*)\" with description \"([^\"]*)\"$")
    public void create_Teams_Description(String name, String description){
        teamPage = mainPage.createNewTeamsWithDescription(name, description);
    }

    @Then("^The new team \"([^\"]*)\" is created.$")
    public void new_Team_Created(String name){
        Assert.assertTrue(teamPage.isNameTeamsDisplayed());
        Assert.assertEquals(name, teamPage.nameTeam());
    }

    @Given("^I deleted a team \"([^\"]*)\" that is disolved$")
    public void deleted_a_team(String name){
        mainPage.clickNewTeams();
        teamPage = mainPage.createNewTeams(name);
    }

    @And("^I deleted the team$")
    public void deleted_Teams(){
        teamPage.clickMenuSetting();
        teamPage.clickBtnDeleted();
        mainPage = teamPage.clickBtnDeletedForever();
    }

    @Then("^The team \"([^\"]*)\" is deleted$")
    public void teams_is_deleted(String isDeleted){
        //Assert.assertFalse(mainPage.isTeamPresent(isDeleted));
    }

    @After(value = "@teams", order = 999)
    public void afterLoginScenario() {
        mainPage.logout();
    }
}

package steps;

import common.Utils;
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
    public String newMember;

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

    @Given("^I need add new members in team \"([^\"]*)\"$")
    public void new_members_team(String nameTeam){
        mainPage.clickNewTeams();
        teamPage = mainPage.createNewTeams(nameTeam);
    }

    @And("^I navigate until to menu Members$")
    public void navigate_menu_members(){
        teamPage.clickMenuMembers();
    }

    @And("I add to member \"([^\"]*)\" with the email \"([^\"]*)\"")
    public void add_new_member(String nameMember, String email){
        teamPage.addMemberInTeam(email);
        newMember = teamPage.isNewMemberTeamDisplayed(nameMember);
    }

    @Then("^The  member \"([^\"]*)\" is added in the team$")
    public void new_member_is_added(String nameMember){
        Assert.assertEquals(nameMember, newMember);
    }

    @After(value = "@teams", order = 999)
    public void afterLoginScenario() {
        mainPage.logout();
    }
}

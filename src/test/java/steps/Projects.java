package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import ui.PageTransporter;
import ui.pages.MainPage;
import ui.pages.ProjectsPage;

/**
 * Created by amateur on 15/11/2015.
 */
public class Projects {
    private PageTransporter page = PageTransporter.getInstance();
    private MainPage mainPage;
    private ProjectsPage projectPage;

    @Given("^I have to create a new project$")
    public void Create_A_New_Project(){
        mainPage = mainPage.clickNewProject();
    }

    @And("^I add a new project \"([^\"]*)\"$")
    public void Add_A_New_Project(String title){
        projectPage = mainPage.createNewProjects(title);
    }

    @Then("^the new project \"([^\"]*)\" is created$")
    public void theNewProjectIsCreated(String title){
        Assert.assertEquals(title, projectPage.titleProject().getText());
    }

    @Given("^I have a project \"([^\"]*)\" existent$")
    public void Project_Existent(String title){
        mainPage = mainPage.clickNewProject();
        projectPage = mainPage.createNewProjects(title);
    }


}

package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by amateur on 15/11/2015.
 */
public class ProjectMenuPage extends BasePageObject {
    private ProjectsPage projectPage;

    @FindBy(xpath = "//h3[contains(text(),'Menu')]")
    WebElement title;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}

package pages;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class ProjectsPage {

    private final By CREATE_NEW_PROJECT_BUTTON = By.cssSelector("#createButton");
    private final By CREATE_PROJECT_BUTTON = By.cssSelector("button[type='submit']");
    private final By PROJECT_NAME_FIELD = By.cssSelector("input#inputTitle");
    private final By PROJECT_CODE_FIELD = By.cssSelector("input#inputCode");
    private final By PROJECT_TEXT_AREA = By.cssSelector("textarea#inputDescription");
    private final By PUBLIC_RADIO_BUTTON = By.cssSelector("label[for='public-access-type']");
    private final By DROPDOWN_BUTTON = (By.cssSelector(".btn-dropdown"));
    private final By DROPDOWN_SELECT_SETTINGS = (By.linkText("Settings"));


    public void openPage() {
        open("/projects");
    }

    public void isOpened() {
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(Condition.visible);
    }

    public void createNewPublicProject(String projectName, String projectCode, String description) {
        $(CREATE_NEW_PROJECT_BUTTON).click();
        $(PROJECT_NAME_FIELD).sendKeys(projectName);
        $(PROJECT_CODE_FIELD).sendKeys(projectCode);
        $(PROJECT_TEXT_AREA).sendKeys(description);
        $(PUBLIC_RADIO_BUTTON).click();
        $(CREATE_PROJECT_BUTTON).click();

    }

    public void updateProject(String projectName, String changedProjectName) {
        $$(".project-row").findBy(text(projectName)).find(DROPDOWN_BUTTON).click();
        $$(".project-row").findBy(text(projectName)).find(DROPDOWN_SELECT_SETTINGS).click();
        $("input[data-qase-test='project-title']").clear();
        $("input[data-qase-test='project-title']").sendKeys(changedProjectName);
        $("button#update").click();
        openPage();
        $(".project-row").find(linkText(changedProjectName)).shouldBe(Condition.visible);

    }

    public void deleteProject(String projectName) {
        $$(".project-row").findBy(text(projectName)).find(By.cssSelector(".btn-dropdown")).click();
        $$(".project-row").findBy(text(projectName)).find(By.linkText("Delete")).click();
        $(".btn-cancel").click();
    }

    public void projectShouldBeVisible(String projectName) {
        openPage();
        $$(".project-row").findBy(text(projectName)).shouldBe(visible);
    }

    public void projectShouldNOTBeVisible(String projectName) {
        openPage();
        $(By.linkText(projectName)).shouldNotBe(visible);
    }


}

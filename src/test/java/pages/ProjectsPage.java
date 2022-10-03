package pages;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    private final By CREATE_NEW_PROJECT_BUTTON = By.cssSelector("#createButton");
    private final By CREATE_PROJECT_BUTTON = By.cssSelector("button[type='submit']");
    private final By PROJECT_NAME_FIELD = By.cssSelector("input#inputTitle");
    private final By PROJECT_CODE_FIELD = By.cssSelector("input#inputCode");
    private final By PROJECT_TEXT_AREA = By.cssSelector("textarea#inputDescription");
    private final By PUBLIC_RADIO_BUTTON = By.cssSelector("label[for='public-access-type']");


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
}

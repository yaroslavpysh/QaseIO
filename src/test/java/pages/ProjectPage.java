package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private final By CREATE_SUITE_BUTTON = By.cssSelector("#create-suite-button");

    public void isOpened(){
        $(CREATE_SUITE_BUTTON).shouldBe(Condition.visible);
    }

}

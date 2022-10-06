package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class ProjectTest extends BaseTest{

    String projectName= "Web Application2";
    String projectCode= "WA2";
    String changedProjectName;


    @Test
    public void createNewPublicProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, projectCode, "BlaBla");
        projectPage.isOpened();
        projectsPage.openPage();
        $$(".project-row").findBy(text(projectName)).shouldBe(visible);

    }

    @Test
    public void updateProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, projectCode,"blabla");
        $$(".project-row").findBy(text(projectName)).find(By.cssSelector(".btn-dropdown")).click();
        $$(".project-row").findBy(text(projectName)).find(By.linkText("Settings")).click();
        $("input[data-qase-test='project-title']").clear();
        $("input[data-qase-test='project-title']").sendKeys(projectName + "1");
        changedProjectName = $("input[data-qase-test='project-title']").getText();
        $("button#update").click();
        projectsPage.openPage();
        $(".project-row").find(linkText(changedProjectName)).shouldBe(Condition.visible);
    }

    @Test
    public void deleteProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, projectCode,"blabla");
        projectsPage.openPage();
        $$(".project-row").findBy(text(projectName)).find(By.cssSelector(".btn-dropdown")).click();
        $$(".project-row").findBy(text(projectName)).find(By.linkText("Delete")).click();
        $(".btn-cancel").click();
        projectsPage.openPage();
        $(By.linkText(projectName)).shouldNotBe(visible);

    }

}

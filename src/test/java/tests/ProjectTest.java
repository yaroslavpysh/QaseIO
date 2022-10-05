package tests;

import lombok.Data;
import org.testng.annotations.Test;

@Data
public class ProjectTest extends BaseTest{

    String projectName= "Web Application2";
    String projectCode= "WA2";
    String changedProjectName = "Wert";


    @Test
    public void createNewPublicProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, projectCode, "BlaBla");
        projectPage.isOpened();
        projectsPage.openPage();
        projectsPage.projectShouldBeVisible(projectName);
    }

    @Test
    public void updateProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, changedProjectName,"blabla");
        projectsPage.openPage();
        projectsPage.updateProject(projectName, changedProjectName);
        projectsPage.openPage();
    }

    @Test
    public void deleteProject(){
        loginPage.openPage();
        loginPage.login(user,password);
        projectsPage.createNewPublicProject(projectName, projectCode,"blabla");
        projectsPage.openPage();
        projectsPage.deleteProject(projectName);
        projectsPage.projectShouldNOTBeVisible(projectName);
    }

}

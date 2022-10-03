package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void createProject(){
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.isOpened();
    }
}

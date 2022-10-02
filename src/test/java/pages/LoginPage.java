package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {


        private final By USERNAME_INPUT = By.cssSelector("#inputEmail");
        private final By PASSWORD_INPUT = By.cssSelector("#inputPassword");
        private final By LOGIN_BUTTON = By.cssSelector("#btnLogin");

        public void openPage(){
            open("/login");
        }

        public void login(String user, String password){
            $("#inputEmail").sendKeys(user);
            $("#inputPassword").sendKeys(password);
            $("#btnLogin").click();
        }
}

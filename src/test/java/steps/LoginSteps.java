package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class LoginSteps {

    private LoginPage loginPage;
    private MainPage mainPage;
    private String standardUsername = "standard_user";
    private String standardPassword = "secret_sauce";

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    public void logIn(){
        logIn(standardUsername, standardPassword);
    }

    public void logIn(String username, String password){
        loginPage.openUrl();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isLogoVisible());
    }
}

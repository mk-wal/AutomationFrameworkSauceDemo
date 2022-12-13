package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.LoginSteps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest{

    private LoginSteps loginSteps;

    @BeforeMethod
    public void initializeObjects(){
        loginSteps = new LoginSteps(driver);
    }

    @Test(dataProvider = "getUsersData")
    public void logInToAppTest(HashMap<String, String> input){
        loginSteps.logIn(input.get("username"), input.get("password"));
    }

    @DataProvider
    public Object[][] getUsersData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/Users.json";
        List<HashMap<String, String>> data = gesJsonDataToMap(filePath);
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
}

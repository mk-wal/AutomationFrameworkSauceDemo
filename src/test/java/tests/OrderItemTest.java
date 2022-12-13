package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.MainSteps;
import steps.CheckoutSteps;

public class OrderItemTest extends BaseTest{
    private LoginSteps loginSteps;
    private MainSteps mainSteps;
    private CheckoutSteps checkoutSteps;
    private String itemName = "Sauce Labs Onesie";
    private String firstName = "Tom";
    private String lastName = "Riddle";
    private String postalCode = "01-001";

    @BeforeMethod
    public void initializeObjects(){
        loginSteps = new LoginSteps(driver);
        mainSteps = new MainSteps(driver);
        checkoutSteps = new CheckoutSteps(driver);
    }

    @Test
    public void orderItemTest(){
        loginSteps.logIn();
        mainSteps.addItemToCard(itemName);
        mainSteps.clickYourCart();
        checkoutSteps.clickCheckout();
        checkoutSteps.enterUserData(firstName, lastName, postalCode);
        checkoutSteps.clickContinue();
        checkoutSteps.checkIfTotalPriceCorrect();
        checkoutSteps.clickFinish();
    }
}

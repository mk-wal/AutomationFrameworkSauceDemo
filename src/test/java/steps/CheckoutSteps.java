package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CheckoutPage;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;

    public CheckoutSteps(WebDriver driver){
        checkoutPage = new CheckoutPage(driver);
    }

    public void clickCheckout(){
        checkoutPage.clickCheckoutButton();
    }

    public void enterUserData(String firstName, String lastName, String postalCode){
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
    }

    public void clickContinue(){
        checkoutPage.clickContinueButton();
    }

    public void checkIfTotalPriceCorrect(){
        Float itemTotal = checkoutPage.getItemTotal();
        Float tax = checkoutPage.getTax();
        Float totalPrice = checkoutPage.getTotalPrice();
        Assert.assertEquals(itemTotal + tax, totalPrice);
    }

    public void clickFinish(){
        checkoutPage.clickFinishButton();
        String completeMessage = checkoutPage.getCompleteMessage();
        Assert.assertEquals(completeMessage, "THANK YOU FOR YOUR ORDER");
    }
}

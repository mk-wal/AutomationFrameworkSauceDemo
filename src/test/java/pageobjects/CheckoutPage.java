package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(className = "complete-header")
    WebElement completeMessage;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotal;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement totalPrice;

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public String getCompleteMessage(){
        return completeMessage.getText();
    }

    public Float getItemTotal(){
        return getPriceValue(itemTotal);
    }

    public Float getTax(){
        return getPriceValue(tax);
    }

    public Float getTotalPrice(){
        return getPriceValue(totalPrice);
    }

    private Float getPriceValue(WebElement element){
        String text = element.getText();
        String price = text.substring(text.lastIndexOf("$") + 1);
        return Float.valueOf(price);
    }
}

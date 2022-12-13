package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends UtilsPO{
    private WebDriver driver;
    private Select sortingDropdownSelect;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    WebElement swagLabsLogo;

    @FindBy(className = "product_sort_container")
    WebElement sortingDropdown;

    @FindBy(className = "inventory_item_name")
    List<WebElement> listOfProductsNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> listOfProductsPrices;

    @FindBy(className = "inventory_item")
    List<WebElement> listOfProducts;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;

    public Boolean isLogoVisible(){
        return isExists(swagLabsLogo);
    }

    private void createSelectDropdownIfNotExists(){
        if (sortingDropdownSelect == null) {
            sortingDropdownSelect = new Select(sortingDropdown);
        }
    }

    public void selectSortingOption(String optionValue) {
        createSelectDropdownIfNotExists();
        sortingDropdownSelect.selectByValue(optionValue);
    }

    public String getSortingDropdownCurrentOptionText(){
        createSelectDropdownIfNotExists();
        return sortingDropdownSelect.getFirstSelectedOption().getText();
    }

    public List<String> getProductNames(){
        List<String> products = new ArrayList<>();
        for(WebElement productWebElement : listOfProductsNames){
            products.add(productWebElement.getText());
        }
        return products;
    }

    public List<Float> getProductPrices(){
        List<Float> prices = new ArrayList<>();
        for(WebElement productWebElement : listOfProductsPrices){
            String price = productWebElement.getText().replace("$", "");
            prices.add(Float.valueOf(price));
        }
        return prices;
    }

    private WebElement getProductWebElement(String productName){
        for (WebElement product : listOfProducts) {
            if (product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public void addProductToCart(String productName){
        getProductWebElement(productName).findElement(By.xpath(".//button")).click();
    }

    public String checkProductButtonText(String productName){
        return getProductWebElement(productName).findElement(By.xpath(".//button")).getText();
    }

    public void clickOnShoppingCart(){
        shoppingCart.click();
    }

}

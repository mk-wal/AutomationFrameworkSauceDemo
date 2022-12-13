package steps;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.MainPage;

import java.util.List;

public class MainSteps {

    private MainPage mainPage;

    public MainSteps(WebDriver driver){
        mainPage = new MainPage(driver);
    }

    public void selectSorting(SortingType sortingType) {
        mainPage.selectSortingOption(sortingType.getValue());
        String currentSortingOption = mainPage.getSortingDropdownCurrentOptionText();
        Assert.assertEquals(currentSortingOption, sortingType.getText());
    }

    public void checkNamesSorting(){
        checkNamesSorting(false);
    }

    public void checkNamesSorting(boolean reverse){
        List<String> products = mainPage.getProductNames();
        boolean isCorrectOrder = checkSorting(reverse, products);
        Assert.assertTrue(isCorrectOrder);
    }

    public void checkPricesSorting(){
        checkPricesSorting(false);
    }

    public void checkPricesSorting(boolean reverse){
        List<Float> prices = mainPage.getProductPrices();
        boolean isCorrectOrder = checkSorting(reverse, prices);
        Assert.assertTrue(isCorrectOrder);
    }

    public void addItemToCard(String productName) {
        mainPage.addProductToCart(productName);
        String buttonText = mainPage.checkProductButtonText(productName);
        Assert.assertEquals(buttonText, "REMOVE");
    }

    public void clickYourCart(){
        mainPage.clickOnShoppingCart();
    }

    private <T extends Comparable<? super T>>
    boolean checkSorting(boolean reverse, List<T> listToCheck){
        if(reverse){
            return Ordering.natural().reverse().isOrdered(listToCheck);
        } else {
            return Ordering.natural().isOrdered(listToCheck);
        }
    }
}

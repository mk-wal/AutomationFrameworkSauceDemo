package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class UtilsPO {

    public Boolean isExists(WebElement element){
        try{
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}

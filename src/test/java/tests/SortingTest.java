package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.MainSteps;
import steps.SortingType;

public class SortingTest extends BaseTest{
    private LoginSteps loginSteps;
    private MainSteps mainSteps;

    @BeforeMethod
    public void initializeObjects(){
        loginSteps = new LoginSteps(driver);
        mainSteps = new MainSteps(driver);
    }

    @Test
    public void aToZSortingTest() {
        loginSteps.logIn();
        mainSteps.selectSorting(SortingType.ATOZ);
        mainSteps.checkNamesSorting();
    }

    @Test
    public void zToASortingTest() {
        loginSteps.logIn();
        mainSteps.selectSorting(SortingType.ZTOA);
        mainSteps.checkNamesSorting(true);
    }

    @Test
    public void highToLowSortingTest() {
        loginSteps.logIn();
        mainSteps.selectSorting(SortingType.HIGHTOLOW);
        mainSteps.checkPricesSorting(true);
    }

    @Test
    public void lowToHighSortingTest() {
        loginSteps.logIn();
        mainSteps.selectSorting(SortingType.LOWTOHIGH);
        mainSteps.checkPricesSorting();
    }
}

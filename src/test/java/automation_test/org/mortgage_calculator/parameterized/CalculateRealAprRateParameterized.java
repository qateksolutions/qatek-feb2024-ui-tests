package automation_test.org.mortgage_calculator.parameterized;

import automation_test.BaseClass;
import data.DataStore;
import org.testng.annotations.Test;
import page_objects.NavigationBar;

public class CalculateRealAprRateParameterized extends BaseClass {
    @Test(dataProvider = "RealAprRates" , dataProviderClass = DataStore.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String expectedApr) {
        new NavigationBar(driver)
                .mouseHoverToRate()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .clickDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateRateButton()
                .validateRealAprRate(expectedApr);
    }
}

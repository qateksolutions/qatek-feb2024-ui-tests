package automation_test.org.mortgage_calculator;

import automation_test.BaseClass;
import command_providers.ActOn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;

public class CalculateMortgageRate extends BaseClass {
    @Test
    public void calculateMonthlyPayment() {
        String[] date = DateUtils.returnNextMonth();
        String month = date[0];
        String year = date[1];
        new Home(driver)
                .validateTitle("Mortgage Calculator")
                .typeHomePrice("300000")
                .clickDownPaymentInDollar()
                .typeDownPayment("60000")
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectStartMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHOA("100")
                .selectLoanType("FHA")
                .selectBuyOrRefinance("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("$1,611.85");
    }
}

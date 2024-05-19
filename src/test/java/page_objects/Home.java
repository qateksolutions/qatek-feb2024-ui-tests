package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By DownPaymentInDollar = By.xpath("//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HoiInputField = By.id("hoi");
    private final By HoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By BuyOrRefinanceDropDown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    private final By TotalMonthlyPayment = By.xpath("//div[@class='repayment-block']/div/div[contains(.,'Total Monthly Payment')]//following-sibling::h3");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver) {
        super(driver);
    }

    public Home typeHomePrice(String value) {
        LOGGER.debug("Typing Home Value: " + value);
        ActOn.element(driver, HomeValueInputField).setValue(value);
        return this;
    }

    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ radio button");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public Home typeDownPayment(String value) {
        LOGGER.debug("Type Down Payment value: " + value);
        ActOn.element(driver, DownPaymentInputField).setValue(value);
        return this;
    }

    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing the loan amount: " + value);
        ActOn.element(driver, LoanAmountInputField).setValue(value);
        return this;
    }

    public Home typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver, InterestRateInputField).setValue(value);
        return this;
    }

    public Home typeLoanTermYears(String value) {
        LOGGER.debug("Typing the loan term years: " + value);
        ActOn.element(driver, LoanTermInputField).setValue(value);
        return this;
    }

    public Home selectStartMonth(String month) {
        LOGGER.debug("Selecting the start date month: " + month);
        ActOn.element(driver, StartMonthDropDown).selectValue(month);
        return this;
    }

    public Home typeYear(String year) {
        LOGGER.debug("Typing the loan start year: " + year);
        ActOn.element(driver, StartYearInputField).setValue(year);
        return this;
    }

    public Home typePropertyTax(String value) {
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver, PropertyTaxInputField).setValue("5000");
        return this;
    }

    public Home typePmi(String value) {
        LOGGER.debug("Typing the pmi: " + value);
        ActOn.element(driver, PmiInputField).setValue(value);
        return this;
    }

    public Home typeHomeOwnerInsurance(String value) {
        LOGGER.debug("Typing the home owner insurance: " + value);
        ActOn.element(driver, HoiInputField).setValue(value);
        return this;
    }

    public Home typeMonthlyHOA(String value) {
        LOGGER.debug("Typing the monthly HOA: " + value);
        ActOn.element(driver, HoaInputField).setValue(value);
        return this;
    }

    public Home selectLoanType(String value) {
        LOGGER.debug("Selecting the loan type: " + value);
        ActOn.element(driver, LoanTypeDropDown).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefinance(String value) {
        LOGGER.debug("Selecting loan option: " + value);
        ActOn.element(driver, BuyOrRefinanceDropDown).selectValue(value);
        return this;
    }

    public Home validateTitle(String expectedTitle) {
        LOGGER.debug("Validate the page title");
        String actualTitle = ActOn.browser(driver).captureTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The title is failed to match");
        return this;
    }

    public Home clickOnCalculateButton() {
        LOGGER.debug("Clicking on the calculate button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String expectedMonthlyPayment) {
        LOGGER.debug("Validating total monthly payment is: " + expectedMonthlyPayment);
        ActOn.wait(driver, TotalMonthlyPayment).waitForElementToBeVisible();
        String actualMonthlyPayment = ActOn.element(driver, TotalMonthlyPayment).getTextValue();

        Assert.assertEquals(actualMonthlyPayment, expectedMonthlyPayment, "Total monthly payment is failed to match");
        return this;
    }

}

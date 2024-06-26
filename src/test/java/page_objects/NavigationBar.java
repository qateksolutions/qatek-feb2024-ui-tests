package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar mouseHoverToRate() {
        LOGGER.debug("Mouse Hover to Rates Link");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    public RealApr navigateToRealApr() {
        LOGGER.debug("Clicking on the Real APR link from the navigation bar");
        ActOn.element(driver, RealAprLink).click();
        return new RealApr(driver);
    }

    public Home navigateToHome() {
        LOGGER.debug("Navigation to the Home Page");
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }
}

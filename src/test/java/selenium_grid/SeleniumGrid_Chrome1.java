package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumGrid_Chrome1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Chrome1.class);
    WebDriver driver;
    URL gridUrl;

    @Test
    public void executeInAwsDocker() {
        ChromeOptions chromeOptions = new ChromeOptions();
        try {
            gridUrl = new URL("http://100.25.162.31:4444/wd/hub");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new RemoteWebDriver(gridUrl, chromeOptions);
        driver.get("https://www.mortgagecalculator.org/");
        LOGGER.info(driver.getTitle());
        driver.quit();
    }
}

package data;

import org.testng.annotations.DataProvider;

public class DataStore {
    @DataProvider(name = "RealAprRates")
    public Object[][] storeRealAprData() {
        return new Object[][] {
                {"200000", "15000", "3", "3.130%"}
        };
    }
}

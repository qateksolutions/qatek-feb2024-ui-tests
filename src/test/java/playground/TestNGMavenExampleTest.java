package playground;

import org.testng.annotations.Test;
import utilities_qatek.CsvConnector;


public class TestNGMavenExampleTest {
    // This is github learning
    @Test
    public void run() throws Exception {
        String[] lines;
        lines = CsvConnector.readCsvData("src/test/resources/test_data.csv");
        for (String line: lines) {
            System.out.println("Each Line: " + line);
            String[] dataArr = line.split(",");
            System.out.println("First Name: " + dataArr[0]);
            System.out.println("Last Name: " + dataArr[1]);
            System.out.println("Designation: " + dataArr[2]);
            System.out.println("Phone Number: " + dataArr[3]);
            System.out.println("Zip Code: " + dataArr[4]);
            System.out.println("State: " + dataArr[5]);
        }
    }
}

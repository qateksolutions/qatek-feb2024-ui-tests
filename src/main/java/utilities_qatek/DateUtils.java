package utilities_qatek;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth() {
        // Create date object
        Date dNow = new Date();

        //Create calendar object for Gregorian Calendar
        Calendar calendar = new GregorianCalendar();
        // Set calendar object to current date
        calendar.setTime(dNow);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(Calendar.MONTH, 1);

        String date = sdf.format(calendar.getTime());

        return date.split("-");
    }
}

package org.teachingextensions.approvals.lite.util;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DateDifferenceTest extends TestCase {
    private static final long YEAR_MS = 1000 * 60 * 60 * 24 * 365L;
    private static final long MONTH_MS = 1000 * 60 * 60 * 24 * 30L;
    // private static final long WEEK_MS   = 1000 * 60 * 60 * 24 * 7L;
    private static final long DAY_MS = 1000 * 60 * 60 * 24L;
    String[] unitsArray = {
            "Year", "Years", "Month", "Months", "Week", "Weeks", "Day", "Days", "Hour", "Hours", "Min", "Mins", "Sec",
            "Secs", "Milli", "Millis"};
    private GetTimeTextUseCase getTimeTextUseCases[] = {
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, YEAR_MS,
                    "1 Year, 0 Months, 0 Weeks, 0 Days, 0 Hours"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, YEAR_MS
                    + (2 * MONTH_MS), "1 Year, 2 Months, 0 Weeks, 0 Days, 0 Hours"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, YEAR_MS
                    - (2 * MONTH_MS), "10 Months, 0 Weeks, 5 Days, 0 Hours, 0 Mins"),
            new GetTimeTextUseCase(2, Calendar.YEAR, Calendar.MILLISECOND, "", "ago", unitsArray, YEAR_MS
                    + (2 * MONTH_MS), "1 Year, 2 Months ago"),
            new GetTimeTextUseCase(5, Calendar.MILLISECOND, Calendar.MILLISECOND, "now", "", unitsArray, YEAR_MS
                    + (2 * MONTH_MS), "36720000000 Millis"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.DATE, "today", "ago", unitsArray, DAY_MS, "1 Day ago"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.DATE, "today", "ago", unitsArray, DAY_MS - 1, "today"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, new GregorianCalendar(
                    2003, 1, 28), /* 1 = Feb */
                    new GregorianCalendar(2003, 2, 31), "1 Month, 0 Weeks, 1 Day, 0 Hours, 0 Mins"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, new GregorianCalendar(
                    2003, 1, 1), new GregorianCalendar(2003, 2, 1), "4 Weeks, 0 Days, 0 Hours, 0 Mins, 0 Secs"),
            new GetTimeTextUseCase(5, Calendar.YEAR, Calendar.MILLISECOND, "now", "", unitsArray, new GregorianCalendar(
                    2004, 1, 1), new GregorianCalendar(2004, 2, 1), "4 Weeks, 1 Day, 0 Hours, 0 Mins, 0 Secs"),
            new GetTimeTextUseCase(5, Calendar.MONTH, Calendar.MILLISECOND, "now", "", unitsArray,
                    new GregorianCalendar(1990, 0, 1), /* 7 * 12 should be 84 */
                    new GregorianCalendar(1997, 0, 1), "85 Months, 1 Week, 0 Days, 0 Hours, 0 Mins"),
            new GetTimeTextUseCase(5, Calendar.DATE, Calendar.MILLISECOND, "now", "", unitsArray, new GregorianCalendar(
                    2004, 3, 3, 10, 0), /* Daylight savings is in month '3' */
                    new GregorianCalendar(2004, 3, 4, 11, 0), "1 Day, 0 Hours, 0 Mins, 0 Secs, 0 Millis")};


    /**
     * *******************************************************************
     */
    public void testGetTimeText() {

        for (GetTimeTextUseCase getTimeTextUseCase : getTimeTextUseCases) {
            int amount = getTimeTextUseCase.amount;
            int maxUnit = getTimeTextUseCase.maxUnit;
            int minUnit = getTimeTextUseCase.minUnit;
            String nowText = getTimeTextUseCase.nowText;
            String agoText = getTimeTextUseCase.agoText;
            String units[] = getTimeTextUseCase.units;
            long milli = getTimeTextUseCase.milli;
            String expected = getTimeTextUseCase.expected;
            DateDifference d = new DateDifference(milli);
            assertEquals("getTimeText(" + amount + ", " + maxUnit + ", " + minUnit + ", " + nowText + ", " + agoText
                            + ", " + Arrays.toString(units) + ") on " + milli, expected,
                    d.getTimeText(amount, maxUnit, minUnit, nowText, agoText, units));
        }
    }

    /**
     * *******************************************************************
     */
    private class GetTimeTextUseCase {
        int amount;
        int maxUnit;
        int minUnit;
        String nowText;
        String agoText;
        String units[];
        long milli;
        String expected;

        public GetTimeTextUseCase(int amount, int maxUnit, int minUnit, String nowText, String agoText,
                                  String[] units, long milli, String expected) {
            this.init(amount, maxUnit, minUnit, nowText, agoText, units, milli, expected);
        }

        /**
         * *******************************************************************
         */
        public GetTimeTextUseCase(int amount, int maxUnit, int minUnit, String nowText, String agoText,
                                  String[] units, Calendar date1, Calendar date2, String expected) {
            long time = date1.getTimeInMillis() - date2.getTimeInMillis();
            if (time < 0) {
                time = -time;
            }
            this.init(amount, maxUnit, minUnit, nowText, agoText, units, time, expected);
        }

        /**
         * *******************************************************************
         */
        private void init(int amount, int maxUnit, int minUnit, String nowText, String agoText, String[] units,
                          long milli, String expected) {
            this.amount = amount;
            this.maxUnit = maxUnit;
            this.minUnit = minUnit;
            this.nowText = nowText;
            this.agoText = agoText;
            this.units = units;
            this.milli = milli;
            this.expected = expected;
        }
    }
    /***********************************************************************/
    /***********************************************************************/
}

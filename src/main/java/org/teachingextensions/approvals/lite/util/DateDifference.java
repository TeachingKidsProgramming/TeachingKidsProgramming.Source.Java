package org.teachingextensions.approvals.lite.util;

import java.util.Calendar;
import java.util.Date;

public class DateDifference {
    public static final String STANDARD_TIME_TEXT[] = {"Year", "Years", "Month", "Months", "Week", "Weeks", "Day", "Days", "Hour", "Hours", "Min", "Mins", "Sec", "Secs", "Milli", "Millis"};
    public static final String MILLISECONDS = "milliseconds";
    public static final String SECONDS = "seconds";
    public static final String MINUTES = "minutes";
    public static final String HOURS = "hours";
    public static final String DAYS = "days";
    public static final String WEEKS = "weeks";
    public static final String MONTHS = "months";
    public static final String YEARS = "years";
    public static String TIME_UNITS[] = {YEARS, MONTHS, WEEKS, DAYS, HOURS, MINUTES, SECONDS, MILLISECONDS};
    // assumes a 30 day month
    private static int TIME_SCALE[] = {Calendar.YEAR, Calendar.MONTH, Calendar.WEEK_OF_YEAR, Calendar.DATE, Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
    private static long DIVIDERS[] = {1000 * 60 * 60 * 24 * 365L, 1000 * 60 * 60 * 24 * 30L, 1000 * 60 * 60 * 24 * 7L, 1000 * 60 * 60 * 24L, 1000 * 60 * 60L, 1000 * 60L, 1000L, 1L};
    /**
     * ********************************************************************
     */
    private long milli;

    /**
     * ********************************************************************
     */
    public DateDifference(long timeDifference) {
        this.milli = timeDifference;
    }

    /**
     * ********************************************************************
     */
    public DateDifference(Date date1, Date date2) {
        milli = date1.getTime() - date2.getTime();
        if (milli < 0) {
            milli = milli * -1;
        }
    }

    /**
     * ********************************************************************
     */
    public static long getAbsoluteDifference(int unit, long time) {
        return time / DIVIDERS[getTimeScaleIndex(unit)];
    }

    /**
     * ********************************************************************
     */
    public static long getRemainingDifference(int wantedUnit, int roundTo, long time) {
        int wantedIndex = getTimeScaleIndex(wantedUnit);
        int roundToIndex = getTimeScaleIndex(roundTo);
        if (wantedIndex < roundToIndex) {
            throw new Error("Can't round with a smaller Unit.[" + TIME_UNITS[wantedIndex] + ", " + TIME_UNITS[roundToIndex] + "]");
        }
        return (time % DIVIDERS[roundToIndex]) / DIVIDERS[wantedIndex];
    }
    /***********************************************************************/
    /**
     * @return the index in TIME_SCALE[] of the largest Unit to be > 0
     */
    private int getMaximumTimeUnit() {
        int i = 0;
        while ((i < DIVIDERS.length) && (milli < DIVIDERS[i])) {
            i++;
        }
        return i;
    }
    /***********************************************************************/
    /**
     * Finds the index for a Calendar.DATE ect.
     *
     * @return the index in TIME_SCALE[]
     */
    public static int getTimeScaleIndex(int calendarTime) {
        int i = 0;
        while (calendarTime != TIME_SCALE[i]) {
            i++;
        }
        return i;
    }

    /**
     * *******************************************************************
     */
    private static long getStandardRoundedTime(int unitIndex, boolean forceAbsolute, long time) {
        if (unitIndex == 0 || forceAbsolute) {
            return getAbsoluteDifference(TIME_SCALE[unitIndex], time);
        } else {
            return getRemainingDifference(TIME_SCALE[unitIndex], TIME_SCALE[unitIndex - 1], time);
        }
    }

    /**
     * *******************************************************************
     */
    public String getTimeText(int amount, int maxUnit, int minUnit, String nowText, String agoText, String units[]) {
        if (amount == 0) {
            throw new Error("getTimeText() requires amount > 0");
        }
        maxUnit = getTimeScaleIndex(maxUnit);
        minUnit = getTimeScaleIndex(minUnit);
        int realMax = getMaximumTimeUnit();
        String timeText = nowText;
        if (realMax < maxUnit) {
            realMax = maxUnit;
        }
        if (realMax <= minUnit) {
            timeText = "";
            long remainingTime = this.milli;
            for (int i = realMax; i < (realMax + amount) && (i <= minUnit); i++) {
                long time = getStandardRoundedTime(i, i == realMax, remainingTime);
                remainingTime -= time * DIVIDERS[i];
                timeText += time + " " + units[(time == 1) ? i * 2 : i * 2 + 1] + ", ";
            }
            timeText = timeText.substring(0, timeText.length() - 2);
            if ((agoText != null) && (agoText.length() > 0)) {
                timeText += " " + agoText;
            }
        }
        return timeText;
    }

    /**
     * *******************************************************************
     */
    public String getStandardTimeText(int amountShown) {
        return getTimeText(amountShown, Calendar.YEAR, Calendar.MILLISECOND, "now", "", STANDARD_TIME_TEXT);
    }
    /************************************************************************/
    /************************************************************************/
}
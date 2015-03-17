package org.teachingextensions.approvals.lite.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A static class of convenience functions for database access
 */
public class DateUtils {
    private static int TIME_SCALE[] = {Calendar.YEAR,
            Calendar.MONTH,
            Calendar.DATE,
            Calendar.HOUR_OF_DAY,
            Calendar.HOUR,
            Calendar.MINUTE,
            Calendar.SECOND,
            Calendar.MILLISECOND};

    public static boolean isSame(Date firstDate, Date secondDate, int smallestUnits) {
        if ((firstDate == null) || (secondDate == null)) {
            return (firstDate == secondDate);
        }
        return isSame(firstDate.getTime(), secondDate.getTime(), smallestUnits);
    }

    public static boolean isSame(long firstDate, long secondDate, int smallestUnits) {
        if (!ArrayUtils.contains(TIME_SCALE, smallestUnits)) {
            throw new Error("Invalid Timescale " + smallestUnits);
        }
        GregorianCalendar first = new GregorianCalendar();
        first.setTime(new Date(firstDate));
        setSignificantDigit(first, smallestUnits);
        GregorianCalendar second = new GregorianCalendar();
        second.setTime(new Date(secondDate));
        setSignificantDigit(second, smallestUnits);
        return (first.getTime().getTime() == second.getTime().getTime());
    }

    /**
     * ********************************************************************
     */
    public static Timestamp getStartOfXDaysAgo(int numberOfDays) {
        return getStartOfXDaysAgo(numberOfDays, new Date());
    }

    /**
     * ********************************************************************
     */
    public static Timestamp getStartOfXDaysAgo(int numberOfDays, Date startingFrom) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(startingFrom);
        DateUtils.setSignificantDigit(gregorianCalendar, Calendar.DATE);
        gregorianCalendar.add(Calendar.DATE, -numberOfDays);
        return new Timestamp(gregorianCalendar.getTime().getTime());
    }

    /**
     * ********************************************************************
     */
    public static Calendar setSignificantDigit(Calendar calendar, int smallestUnits) {
        boolean removeOn = false;
        for (int i : TIME_SCALE) {
            if (removeOn) {
                if (i == Calendar.DATE) {
                    // Work around since this is broke
                    calendar.set(i, 1);
                } else if (i == Calendar.HOUR_OF_DAY) {
                    // Work around since this is broke
                    calendar.set(i, 0);
                } else {
                    calendar.clear(i);
                }
            }
            if (i == smallestUnits) {
                removeOn = true;
            }
        }
        return calendar;
    }

    public static void main(String args[]) {
        MySystem.variable("Calendar.DATE = " + Calendar.DATE);
        MySystem.variable("Year", setSignificantDigit(new GregorianCalendar(), Calendar.YEAR).getTime());
        MySystem.variable("Month", setSignificantDigit(new GregorianCalendar(), Calendar.MONTH).getTime());
        MySystem.variable("Day", setSignificantDigit(new GregorianCalendar(), Calendar.DAY_OF_MONTH).getTime());
        MySystem.variable("Hour", setSignificantDigit(new GregorianCalendar(), Calendar.HOUR).getTime());
        MySystem.variable("Minute", setSignificantDigit(new GregorianCalendar(), Calendar.MINUTE).getTime());
        MySystem.variable("End Of Day", rollToEndOfDay(new Date()).getTime());
    }

    /**
     * ********************************************************************
     */
    public static GregorianCalendar rollToEndOfDay(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 23);
        gregorianCalendar.set(Calendar.MINUTE, 59);
        gregorianCalendar.set(Calendar.SECOND, 59);
        gregorianCalendar.set(Calendar.MILLISECOND, 999);
        return gregorianCalendar;
    }

    /**
     * *******************************************************************
     */
    public static Timestamp asTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * ********************************************************************
     */
    public static boolean isToday(Date date) {
        return DateUtils.isSame(date, new Date(), Calendar.DATE);
    }

    /**
     * ********************************************************************
     */
    public static Calendar asCalendar(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    /************************************************************************/
    /**
     * @param date "yyyy/MM/dd"
     */
    public static Timestamp parse(String date) {
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
        try {
            return asTimestamp(format.parse(date));
        } catch (ParseException e) {
            throw ObjectUtils.throwAsError(e);
        }
    }
    /************************************************************************/
}
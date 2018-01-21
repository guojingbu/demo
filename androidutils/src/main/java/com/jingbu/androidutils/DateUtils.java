package com.jingbu.androidutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by guojingbu on 2017/12/16.
 */

public class DateUtils {

    /** The Constant timestampDateFormatter. */
    public static final SimpleDateFormat timestampDateFormatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());

    /** The Constant birthdayFormatter. */
    public static final SimpleDateFormat birthdayFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public static String getTimestamp() {
        return timestampDateFormatter.format(new Date());
    }

    /**
     * Checks if is night.
     *
     * @return true, if is night
     */
    public static boolean isNight() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 17;
    }

    /**
     * Gets the hour and minute.
     *
     * @param timeStirng the time stirng
     * @return the hour and minute
     */
    public static String getHourAndMinute(String timeStirng) {
        if (timeStirng != null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return new SimpleDateFormat("HH:mm").format(dateFormat.parse(timeStirng));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getYearAndDate(String timeStirng) {
        if (timeStirng != null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return new SimpleDateFormat("yyyy-MM-dd").format(dateFormat.parse(timeStirng));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    /**
     * Gets the date and week.
     *
     * @param date the date
     * @return the date and week
     */
    public static String getDateAndWeek(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA).format(date);
    }

    /**
     * Gets the date and week.
     *
     * @param timeStirng the time stirng
     * @return the date and week
     */
    public static String getDateAndWeek(String timeStirng) {
        if (timeStirng != null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return new SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINA).format(dateFormat.parse(timeStirng));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getDateNow(){
        SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd");
        String    date    =    sDateFormat.format(new Date());
        return date;
    }

    public static String dateAndWeek() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new SimpleDateFormat("MM/dd EEEE", Locale.CHINA).format(new Date());
    }

    public static String DateToStrHM(Date date){
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        String date1=dd.format(date);
        return date1;
    }
}

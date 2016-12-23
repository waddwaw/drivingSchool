package com.yoflying.drivingschool.utils.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by arvin on 2016/12/23.
 */
public class TimeUtils {

    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String getBackTime(String f, int day) {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat(f);
        String date = format.format(d);
//        System.out.println("现在的日期是：" + date);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, day);     // 30为增加的天数，可以改变的
        d = ca.getTime();
        String backTime = format.format(d);
//        System.out.println("增加天数以后的日期：" + backTime);
        return backTime;
    }

    public static int getAMorPM(String time) {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        GregorianCalendar ca = new GregorianCalendar();
        try {
            ca.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
        return ca.get(GregorianCalendar.AM_PM);
    }
}

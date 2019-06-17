package otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("date===" + date);
        DateFormat df = DateFormat.getDateInstance();

        df = DateFormat.getDateInstance(DateFormat.FULL);
        df = DateFormat.getDateInstance(DateFormat.LONG);
        df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        df = DateFormat.getDateInstance(DateFormat.SHORT);

        df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

        df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String formatDate = df.format(date);
        System.out.println("FormatDate==-" + formatDate);

        String date_str = "2019-03-21";
        DateFormat df2 = DateFormat.getDateInstance();
        Date d2 = df2.parse(date_str);
        System.out.println("d2===" + d2);
        System.out.println(d2.getMonth() + 1);

        long time = System.currentTimeMillis();
        // long time = 1553140853894;
        System.out.println("currntTimeMillis===" + time);

        Date d3 = new Date(time);
        System.out.println("d3===" + d3);
        String d3_str = df.format(d3);
        System.out.println("d3_str===" + d3_str);

        Calendar c = Calendar.getInstance();
        int year = 2010;
        c.set(year, 2, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);

        showDate(c);
    }

    private static void showDate(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String week = getWeek(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(year + "-" + month + "-" + day + "-" + week);
    }

    private static String getWeek(int i) {
        if (i > 7 || i <= 0)
            throw new NotWeekException("没有对应的星期1-7");

        String[] weeks = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        return weeks[i];
    }
}

class NotWeekException extends RuntimeException {

    public NotWeekException(String string) {
    }
}
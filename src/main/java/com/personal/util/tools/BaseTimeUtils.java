package com.personal.util.tools;

import com.personal.util.config.Constants;
import com.personal.util.tools.string.StringUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 时间工具类，方便处理日常时间格式
 *
 * @author yuanss
 */
public class BaseTimeUtils {

    private static final String[] WEEK_DAYS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 获取当前日期 yyyy-MM-dd
     */
    public static String dateNow() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当前日期时间 yyyy-MM-dd HH:mm:ss
     */
    public static String dateTimeNow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前日期 yyyy-MM-dd HH:mm:ss
     */
    public static String getDateStr(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 获取当月第一天日期
     */
    public static String firstDateMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(firstDay);
    }

    /**
     * 获取当月最后一天日期
     */
    public static String lastDateMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        Date lastDay = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(lastDay);
    }

    /**
     * 获取本月开始日期
     */
    public static String getMonthStart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) + " 00：00：00";
    }

    /**
     * 获取本月最后一天
     */
    public static String getMonthEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) + " 23:59:59";
    }

    /**
     * 获取本周的第一天
     */
    public static String getWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) + " 00:00:00";
    }

    /**
     * 获取本周的最后一天
     */
    public static String getWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time) + " 23:59:59";
    }

    /**
     * 获取本年的第一天
     **/
    public static String getYearStart() {
        return new SimpleDateFormat("yyyy").format(new Date()) + "-01-01 00:00:00";
    }

    /**
     * 获取本年的最后一天
     **/
    public static String getYearEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast) + " 23:59:59";
    }

    /**
     * 当前日期+天数
     */
    public static String addDays(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, n);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 指定日期+天数
     */
    public static String addDays(String str, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long subLong = n * 24 * 3600 * 1000L;
        try {
            Date date = new Date(sdf.parse(str).getTime() + subLong);
            return sdf.format(date);
        } catch (ParseException e) {
            return sdf.format(new Date());
        }
    }

    /**
     * 指定日期+时分秒（年月日）
     */
    public static String addTimes(String str, String type, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(str));
            switch (type) {
                case Constants.YEAR:
                    calendar.add(Calendar.YEAR, n);
                    return sdf.format(calendar.getTime());
                case Constants.MONTH:
                    calendar.add(Calendar.MONTH, n);
                    return sdf.format(calendar.getTime());
                case Constants.DATE:
                    calendar.add(Calendar.DATE, n);
                    return sdf.format(calendar.getTime());
                case Constants.HOUR:
                    calendar.add(Calendar.HOUR, n);
                    return sdf.format(calendar.getTime());
                case Constants.MINUTE:
                    calendar.add(Calendar.MINUTE, n);
                    return sdf.format(calendar.getTime());
                case Constants.SECOND:
                    calendar.add(Calendar.SECOND, n);
                    return sdf.format(calendar.getTime());
                default:
                    return "";
            }
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 指定日期+时分秒（年月日）
     */
    public static String addTimes(Date date, String type, int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (type) {
            case Constants.YEAR:
                calendar.add(Calendar.YEAR, n);
                return sdf.format(calendar.getTime());
            case Constants.MONTH:
                calendar.add(Calendar.MONTH, n);
                return sdf.format(calendar.getTime());
            case Constants.DATE:
                calendar.add(Calendar.DATE, n);
                return sdf.format(calendar.getTime());
            case Constants.HOUR:
                calendar.add(Calendar.HOUR, n);
                return sdf.format(calendar.getTime());
            case Constants.MINUTE:
                calendar.add(Calendar.MINUTE, n);
                return sdf.format(calendar.getTime());
            case Constants.SECOND:
                calendar.add(Calendar.SECOND, n);
                return sdf.format(calendar.getTime());
            default:
                return "";
        }
    }

    /**
     * 当前日期+月份
     */
    public static String addMonths(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, n);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 指定日期+月份
     */
    public static String addMonths(String str, int n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, n);
            return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 当前日期+月份（第一天）
     */
    public static String addMonthsFirstDay(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = calendar.getTime();
        calendar.setTime(firstDay);
        calendar.add(Calendar.MONTH, n);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**
     * 根据字符串获取日期 参数：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss 或 CST格式
     */
    public static Date getDate(String str) {
        Date date = null;
        try {
            if (str.length() == 10) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
                return date;
            } else if (str.length() == 19) {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
                return date;
            } else if (str.contains("CST") || str.contains("cst")) {
                date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(str);
                return date;
            } else {
                return null;
            }
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取毫秒级时间戳
     */
    public static Long milliSecondStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取秒级时间戳
     */
    public static Long secondStamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 把时间戳转为时间字符串
     */
    public static String formatStampToTime(String currentTime) {
        if (currentTime.length() == 10) {
            currentTime = currentTime + "000";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.parseLong(currentTime));
    }

    /**
     * 获取两个时间之间的间隔
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return *分钟/*小时*分钟/*天*小时*分钟
     */
    public static String timeInterval(String beginTime, String endTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long begin = sdf.parse(beginTime).getTime();
            Long end = sdf.parse(endTime).getTime();
            return handleSubTime(begin, end);
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 获取两个时间之间的间隔
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return *分钟/*小时*分钟/*天*小时*分钟
     */
    public static String timeInterval(Date beginTime, Date endTime) {
        try {
            Long begin = beginTime.getTime();
            Long end = endTime.getTime();
            String str = handleSubTime(begin, end);
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取两个时间之间的间隔
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return *分钟
     */
    public static String timeStrIntervalMin(String beginTime, String endTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long begin = sdf.parse(beginTime).getTime();
            Long end = sdf.parse(endTime).getTime();
            long l = end - begin;
            int m = (int) l / 1000;
            int i = m / 60;
            return i + "";
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 时间格式转换  yyyy-MM-dd 转为 yyyy年MM月dd日
     */
    public static String transTimType(String str) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            return new SimpleDateFormat("yyyy年MM月dd日").format(date);
        } catch (ParseException e) {
            return "";
        }
    }

    /**
     * 当前时间是否为白天
     *
     * @return true白天/false晚上
     */
    public static boolean nowDayOrNight() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour >= 6 && hour < 18;
    }

    /**
     * 把日期转换为星期
     */
    public static String dateToWeek(Date dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        return WEEK_DAYS[week];
    }

    /**
     * 把日期字符串转换为星期
     */
    public static String dateToWeek(String dateTime) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
        } catch (ParseException e) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        return WEEK_DAYS[week];
    }

    /**
     * 获取当天日期开始时间
     */
    public static Date getDateBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天日期结束时间
     */
    public static Date getDateEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取今天
     */
    public static String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取昨天
     */
    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 分钟转为*dd*HH*mm
     */
    public static String transFullByMin(int m) {
        String str = "";
        if (m > 1440) {
            int k = m / 1440;
            int h = m % 1440;
            int i = h / 60;
            int j = h % 60;
            str = k + "天" + i + "小时" + j + "分钟";
        } else if (m > 60) {
            int i = m / 60;
            int j = m % 60;
            str = i + "小时" + j + "分钟";
        } else {
            str = m + "分钟";
        }
        return str;
    }

    /**
     * 转换为*dd*HH*mm
     */
    public static String transFullBySec(int s) {
        int L = s / 60;
        int min = 0;
        if (s % 60 > 0) {
            min = 1;
        }
        String str = "";
        if (L > 1440) {
            int k = L / 1440;
            int h = L % 1440;
            int i = h / 60;
            int j = h % 60 + min;
            str = k + "天" + i + "小时" + j + "分钟";
        } else if (L > 60) {
            int i = L / 60;
            int j = L % 60 + min;
            str = i + "小时" + j + "分钟";
        } else {
            str = L + min + "分钟";
        }
        return str;
    }

    /**
     * 计算两个字符串之间的天数差
     */
    public static Long betweenDays(String a, String b) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 自定义时间格式
        Calendar cal_a = Calendar.getInstance();    // 获取日历对象
        Calendar cal_b = Calendar.getInstance();

        Date date_a = null;
        Date date_b = null;

        try {
            date_a = simpleDateFormat.parse(a);//字符串转Date
            date_b = simpleDateFormat.parse(b);
            cal_a.setTime(date_a);  // 设置日历
            cal_b.setTime(date_b);
        } catch (ParseException e) {
            e.printStackTrace();    //格式化异常
        }

        long time_a = cal_a.getTimeInMillis();
        long time_b = cal_b.getTimeInMillis();

        long betweenDays = (time_b - time_a) / (1000 * 3600 * 24);  //计算相差天数

        return betweenDays;
    }

    public static String calcTimeByMinCount(int minTotalCount) {
        String time = "";
        int hourCount = minTotalCount / 60;
        int minCount = minTotalCount % 60;
        time = StringUtils.addZeroForNum(String.valueOf(hourCount), 2) + ":"
            + StringUtils.addZeroForNum(String.valueOf(minCount), 2);
        return time;
    }

    /**
     * 时间字符串计算分钟数
     * @param minTime HH:mm 时间字符串
     * @return
     */
    public static Long calcMinSumByString(String minTime) {
        try {
            Long minCount = 0L;
            if (!StringUtils.isEmpty(minTime)) {
                String[] eTime = minTime.split(":");
                minCount = Long.parseLong(eTime[0]) * 60 + Long.parseLong(eTime[1]);
            }
            return minCount;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 根据年份，获取该年所有时间 (yyyy-MM-dd)
     */
    public static List<String> getDays(String year) {
        // 返回的日期集合
        List<String> resultDays = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(year + "-01-01");
            Date end = dateFormat.parse(year + "-12-31");

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);     // 日期加1（包含结束）
            while (tempStart.before(tempEnd)) {
                resultDays.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultDays;
    }

    private static String handleSubTime(Long begin, Long end) {
        long l = end - begin;
        int m = (int) l / 1000;
        return transFullBySec(m);
    }

}

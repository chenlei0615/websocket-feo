package com.sunlands.feo.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Project : simple-feo
 * @Package Name : com.sunlands.feo.demo.util
 * @Description : TODO
 * @Author : chenlei
 * @Create Date : 2019年01月25日 17:43
 * ------------    --------------    ---------------------------------
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{


    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    public DateUtils() {

    }

    /**
     * 获得当天时间
     *
     * @param parrten
     *            输出的时间格式
     * @return 返回时间
     */
    public static String getTime(String parrten) {

        String timestr;
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyyMMddHHmmss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);
        Date cday = new Date();
        timestr = sdf.format(cday);
        return timestr;
    }

    public static Date parseDate(String date) {
        return parseDate(date,new String[] { "yyyy-MM","yyyy-MM-dd", "yyyy/MM/dd","yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm" });
    }

    public static Date parseDate(String date,String ... partten) {
        Date dt = null;
        try {
            dt = org.apache.commons.lang3.time.DateUtils.parseDate(date,partten);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        return dt;
    }

    public static Date parseDate(String date,String partten){
        return parseDate(date,new String[]{partten});
    }
    /**
     * 获得当天日期
     *
     * @param parrten
     * @return
     */
    public static String getDate(String parrten) {

        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM-dd";
        }
        return DateUtils.getTime(parrten);
    }

    /**
     * 计算两个日期之间相差的天数
     * @param end
     * @param start
     * @return
     */
    public static int getDifferDays(Date end, Date start){
        Calendar aCalendar = Calendar.getInstance();
        Calendar bCalendar = Calendar.getInstance();
        aCalendar.setTime(end);
        bCalendar.setTime(start);
        int days = 0;
        while(bCalendar.before(aCalendar)){
            days++;
            bCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return days;
    }

    /**
     * 时间格式转换
     *
     * @param cday
     * @param parrten
     * @return
     */
    public static String getTime(Date cday, String parrten) {

        String timestr;
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyyMMddHHmmss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);
        timestr = sdf.format(cday);
        return timestr;
    }

    /**
     * 日期格式转换
     *
     * @param parrten
     * @return
     */
    public static String getDate(Date date, String parrten) {

        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM-dd";
        }
        return DateUtils.getTime(date, parrten);
    }

    /**
     * 日期格式转换
     *
     * @param parrten
     * @return
     */
    public static String getNowDate(Date date, String parrten) {

        if (parrten == null || parrten.equals("")) {
            parrten = "yyyyMMdd";
        }
        return DateUtils.getTime(date, parrten);
    }


    /**
     * 得到昨天的时间
     *
     * @return
     */
    public static String getYestday() {

        String timestr;
        Calendar cc = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ((cc.get(Calendar.MONTH) + 1) == 1 && cc.get(Calendar.DAY_OF_MONTH) == 1) {
            cc.roll(Calendar.YEAR, -1);
        }
        cc.roll(Calendar.DAY_OF_YEAR, -1);

        timestr = sdf.format(cc.getTime());
        return timestr;
    }

    /**
     * 将字串转换为指定格式的日期
     *
     * @param time
     *            时间
     * @param parrten
     *            为空时，将使用yyyy-MM-dd格式
     * @return
     */
    public static Date StrToDate(String time, String parrten) {

        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM-dd";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        ParsePosition pos = new ParsePosition(0);
        Date dt1 = formatter.parse(time, pos);
        return dt1;
    }



    /**
     * 将时间转换为xxxx-xx-xx日格式
     *
     * @param t1
     *            原时间
     * @param parrten
     *            原时间格式
     * @return
     */
    public static String getTime(String t1, String parrten) {

        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date dt1 = formatter.parse(t1, pos);
        return formatter2.format(dt1);
    }

    /**
     * 将时间转换为parrten2格式
     *
     * @param t1
     *            时间字符串
     * @param parrten
     *            原时间格式
     * @param parrten2
     *            要转化的格式
     * @return
     */
    public static String getTime(String t1, String parrten, String parrten2) {

        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        SimpleDateFormat formatter2 = new SimpleDateFormat(parrten2);
        ParsePosition pos = new ParsePosition(0);
        Date dt1 = formatter.parse(t1, pos);
        return formatter2.format(dt1);
    }



    /**
     * 比较两个日期相差的天数
     *
     * @param endDt
     * @param startDt
     * @return
     */
    public static int compareTime2(String endDt,String startDt) {
        //算两个日期间隔多少天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = parseDate(endDt);
        Date date2 = parseDate(startDt);

        int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
        return a;
    }


    /**
     * 增加天数
     * @param datetime
     * @param parrten
     * @param days
     * @return
     */
    public static String addTime(String datetime, String parrten, long days) {

        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        ParsePosition pos = new ParsePosition(0);
        Date dt1 = formatter.parse(datetime, pos);
        long l = dt1.getTime() / 1000 + days * 24 * 60 * 60;
        dt1.setTime(l * 1000);
        String mydate = formatter.format(dt1);

        return mydate;
    }


    /**
     * 将当前日期yyyy-MM-dd 设置为yyyy-MM-dd 23:59:59
     * @param datetime yyyy-MM-dd
     * @param days
     * @return
     */
    public static String toDateEndTime(String datetime, long days){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        try {
            dt1 = formatter.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l = dt1.getTime() + days * 24 * 60 * 60 * 1000 - 1 ;
        dt1.setTime(l);
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate = formatter2.format(dt1);

        return mydate;
    }

    public static String getDateTime(String datetime, String parrten){
        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        Date dt1 = null;
        try {
            dt1 = formatter.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l = dt1.getTime();
        dt1.setTime(l);

        String mydate = formatter.format(dt1);

        return mydate;
    }


    /**
     * 减少天数
     * @param datetime
     * @param parrten
     * @param days
     * @return
     */
    public static String subTime(String datetime, String parrten, long days) {
        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        ParsePosition pos = new ParsePosition(0);
        Date dt1 = formatter.parse(datetime, pos);
        long l = dt1.getTime() / 1000 - days * 24 * 60 * 60;
        dt1.setTime(l * 1000);
        String mydate = formatter.format(dt1);
        return mydate;
    }


    /**
     * 取得指定日期的前一天
     *
     * @param date
     * @return
     */
    public static Date getPreDate(Date date) {

        Calendar calendar = Calendar.getInstance();

        Date tempDate = date;

        calendar.setTime(date);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);

        Calendar cal = Calendar.getInstance();

        cal.setTime(tempDate);

        if (cal.get(Calendar.DAY_OF_YEAR) == 1) {
            calendar.roll(Calendar.YEAR, -1);
        }

        Date preDate = calendar.getTime(); // 得到前一天的日期
        return preDate;

    }

    /**
     * @author 童贝
     * @version 2007-5-17
     * @return 当前时间的后一天
     * @param date
     * @return
     */
    public static Date nextDate(Date date) {

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
    }

    /**
     * 格式化日期  指定格式
     * @param date
     * @param formatStyle
     * @return
     */
    public static String formatDate(Date date,String formatStyle){
        String defaultStyle="yyyy-MM-dd HH:mm:ss";
        if(formatStyle!=null && !formatStyle.equals("")) {
            defaultStyle = formatStyle;
        }
        DateFormat df=new SimpleDateFormat(defaultStyle);
        String dt=df.format(date);
        return dt;
    }
    /**
     * 格式化日期 默认格式:yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        return formatDate(date,null);
    }

    /**
     *
     *描述：得到指定月份后的时间(比如:2009-1-10,3,"yyyy-MM-dd",那么得到的是2009-4-10)
     *时间：2010-1-13
     *作者：童贝
     *参数：curDate(日期),monthCount(往后退的月数),parrten(格式)
     *返回值:后推得时间
     *抛出异常：
     */
    public static String getNextDate(Date curDate,Integer monthCount,String parrten){
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);

        Calendar calendar = Calendar.getInstance();
        try {
            String strDate=DateUtils.getDate(curDate, parrten);
            calendar.setTime(sdf.parse(strDate));
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        calendar.add(Calendar.MONTH, monthCount);
        return sdf.format(calendar.getTime());
    }

    /**
     *
     *描述：比较两个时间相差的天数
     *时间：2010-1-14
     *作者：童贝
     *参数：
     *返回值:0表示相等，>0表示t1大,<0表示t2大
     *抛出异常：
     */
    public static int compareStringTimes(String t1, String t2, String parrten) {

        SimpleDateFormat formatter = new SimpleDateFormat(parrten);
        ParsePosition pos = new ParsePosition(0);
        ParsePosition pos1 = new ParsePosition(0);
        Date dt1 = formatter.parse(t1, pos);
        Date dt2 = formatter.parse(t2, pos1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt1);
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(dt2);
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return (day1 - day2);

    }

    /**
     * 获取某年上一个月
     *@author  MrBao
     *@date 	  2010-2-10
     *@param currDate  当前时间
     *@param parrten
     *@return
     *@return String
     *@remark
     */
    public static String  getPrevMonth(String currDate ,String parrten){
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);
        Calendar   calendar = Calendar.getInstance();
        Date mydate = new Date();
        try {
            mydate = sdf.parse(currDate);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        calendar.setTime(mydate);
        calendar.add(Calendar.MONTH, -1);
        String result =sdf.format(calendar.getTime()).toString();
        return  result;
    }

    /**
     * 获取某个日期的上个月
     * @param date
     * @return
     */
    public static Date  getPrevMonth(Date date){
        Calendar   calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return  calendar.getTime();
    }

    /**
     * 获取某个日期的上周
     * @param date
     * @return
     */
    public static Date  getPrevWeek(Date date){
        Calendar   calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        return  calendar.getTime();
    }

    /**
     * 获取某年下一个月
     *@author  MrBao
     *@date 	  2010-2-10
     *@param currDate
     *@param parrten
     *@return
     *@return String
     *@remark
     */
    public static String  getNextMonth(String currDate ,String parrten){
        if (parrten == null || parrten.equals("")) {
            parrten = "yyyy-MM";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrten);
        Calendar   calendar = Calendar.getInstance();
        Date mydate = new Date();
        try {
            mydate = sdf.parse(currDate);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        calendar.setTime(mydate);
        calendar.add(Calendar.MONTH, 1);
        String result =sdf.format(calendar.getTime()).toString();
        return  result;
    }

    /**
     * 获取上一年
     *@author  MrBao
     *@date 	  2010-2-10
     *@param currYear
     *@return
     *@return String
     *@remark
     */
    public static String  getPrevYear(String currYear){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar   calendar = Calendar.getInstance();
        Date mydate = new Date();
        try {
            mydate = sdf.parse(currYear);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        calendar.setTime(mydate);
        calendar.add(Calendar.YEAR, -1);
        String result =sdf.format(calendar.getTime()).toString();
        return  result;
    }

    /**
     * 获取下一年
     *@author  MrBao
     *@date 	  2010-2-10
     *@param currYear
     *@return
     *@return String
     *@remark
     */
    public static String  getNextYear(String currYear){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar   calendar = Calendar.getInstance();
        Date mydate = new Date();
        try {
            mydate = sdf.parse(currYear);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        calendar.setTime(mydate);
        calendar.add(Calendar.YEAR, 1);
        String result =sdf.format(calendar.getTime()).toString();
        return  result;
    }

    /**
     * 获取某个日期的上个小时
     * @param date
     * @return
     */
    public static Date  getPrevHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -1);
        return  calendar.getTime();
    }

    /**
     * 功能说明:得到指定月份的第一天,精确到时分秒(2015-01-01 00:00:00)
     */
    public static String getMonthFirstTime(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day_end=df.format(cal.getTime());
        return day_end;
    }

    /**
     * 功能说明:得到指定月份的第一天,精确到时分秒(2015-01-01 00:00:00)
     */
    public static Date getFirstTimeOfMonth(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return cal.getTime();
    }

    /**
     * 功能说明:得到指定月份的最后一天,精确到时分秒(2015-01-31 23:59:59)
     */
    public static String getMonthLastTime(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前月＋1，即下个月
        cal.add(Calendar.MONTH,1);
        //将下个月1号作为日期初始zhii
        cal.set(Calendar.DATE,1);
        //下个月1号减去一天，即得到当前月最后一天
        cal.add(Calendar.DATE,-1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,999);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day_end=df.format(cal.getTime());
        //System.out.println("day_end>>>"+day_end);
        return day_end;
    }

    /**
     * 功能说明:得到指定月份的最后一天,精确到时分秒(2015-01-31 23:59:59)
     */
    public static Date getLastTimeOfMonth(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前月＋1，即下个月
        cal.add(Calendar.MONTH,1);
        //将下个月1号作为日期初始zhii
        cal.set(Calendar.DATE,1);
        //下个月1号减去一天，即得到当前月最后一天
        cal.add(Calendar.DATE,-1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,999);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastDay = cal.getTime();
        String format = df.format(lastDay);
        try {
            lastDay = df.parse(format);
        } catch (ParseException e) {
            logger.error("字符串无法解析为时间",e);
        }
        return lastDay;
    }

    /**
     * 功能说明:得到指定月份的最后一天
     * @author 童贝
     * @version Feb 16, 2009
     * @return
     */
    public static String getLastDate(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //当前月＋1，即下个月
        cal.add(Calendar.MONTH,1);
        //将下个月1号作为日期初始zhii
        cal.set(Calendar.DATE,1);
        //下个月1号减去一天，即得到当前月最后一天
        cal.add(Calendar.DATE,-1);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        String day_end=df.format(cal.getTime());
        //System.out.println("day_end>>>"+day_end);
        return day_end;
    }
    /**
     * 功能说明:得到指定月份的最后一天
     * @author 童贝
     * @version Feb 16, 2009
     * @return
     */
    public static String getLastDate(String date){
        Date newDate=DateUtils.StrToDate(date, "");
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(newDate);
        //当前月＋1，即下个月
        cal.add(Calendar.MONTH,1);
        //将下个月1号作为日期初始zhii
        cal.set(Calendar.DATE,1);
        //下个月1号减去一天，即得到当前月最后一天
        cal.add(Calendar.DATE,-1);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        String day_end=df.format(cal.getTime());
        //System.out.println("day_end>>>"+day_end);
        return day_end;
    }

    /**
     * 功能说明:得到一年的最后一天
     * @author 童贝
     * @version Feb 16, 2009
     * @return
     */
    public static String getLastYearByDate(String year){
        Calendar cal = Calendar.getInstance();
        String newYear=year+"-01-01";//一年的第一天
        Date date=DateUtils.StrToDate(newYear, "yyyy-mm-dd");
        cal.setTime(date);
        cal.add(Calendar.MONTH,12);
        cal.add(Calendar.DATE,-1);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        String day_end=df.format(cal.getTime());
        //System.out.println("day_end>>>"+day_end);
        return day_end;
    }

    /**
     * 返回两个时间之间时间集合
     * @param startTime
     * @param endTime
     * @return
     */
    public static String[] getDaysBetween(String endTime,String startTime){
        int i1 = compareTime2(endTime, startTime)+1;
        String[] dates = new String[i1];
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendarTemp = Calendar.getInstance();
            calendarTemp.setTime(sdf.parse(startTime));

            Calendar calendarEndTemp = Calendar.getInstance();
            calendarEndTemp.setTime(sdf.parse(endTime));
            int i = 0;
            while (calendarTemp.getTime().getTime()!= calendarEndTemp.getTime().getTime()) {//遍历查询时间
                String dt = new SimpleDateFormat("yyyy-MM-dd").format(calendarTemp.getTime().getTime() / 1000 * 1000);
//    	    	String dt = new SimpleDateFormat("yyyy-MM-dd").format(calendarTemp.getTime());
                calendarTemp.add(Calendar.DAY_OF_YEAR, 1);
                dates[i] = dt;
                i++;
            }
            dates[dates.length-1] = sdf.format(sdf.parse(endTime));
        } catch (ParseException e) {
            logger.error("访问属性异常",e);
        }
        return dates;
    }

    /**
     * 功能说明:得到指定天开始时间,精确到时分秒(2015-01-01 00:00:00)
     */
    public static String getDateFirstTime(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day_end=df.format(cal.getTime());
        return day_end;
    }

    /**
     * 功能说明:得到指定天开始时间,精确到时分秒(2015-01-01 00:00:00)
     */
    public static Date getFirstTimeOfDate(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTime();
    }

    /**
     * 功能说明:得到指定天结束时间,精确到时分秒(2015-01-01 23:59:59)
     */
    public static String getDateLastTime(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day_end=df.format(cal.getTime());
        return day_end;
    }


    /**
     * 功能说明:得到指定天结束时间,精确到时分秒(2015-01-01 23:59:59)
     */
    public static Date getLastTimeOfDate(Date date){
        //Date date=new Date(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND,999);
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return cal.getTime();
    }

    /**
     * 取得某天所在周的第一天 时间显示yyyy-MM-dd 00：00：00
     * @param date  某天
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
//        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        return parseDate(getDate(c.getTime(),"yyyy-MM-dd"),"yyyy-MM-dd");
    }

    /**
     * 取得某天所在周的最后一天 时间显示yyyy-MM-dd 23：59：59
     * @param date  某天
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
//        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        return parseDate(getDate(c.getTime(),"yyyy-MM-dd")+" 23:59:59","yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 设置23:59:59
     * @param date
     * @return
     */
    public static Date setEndDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND,999);
        return calendar.getTime();
    }

    /**
     * 设置00:00:00
     * @param date
     * @return
     */
    public static Date setStartDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     * @param beginDate
     * @param endDate
     * @return date[]
     */
    public static Date[] getDatesBetween(Date beginDate, Date endDate) {
        if(beginDate == null){
            throw new NullPointerException();
        }
        if(endDate == null){
            throw new NullPointerException();
        }
        if(beginDate.after(endDate)){
            throw new IllegalArgumentException();
        }
        int init_size = 31;
        Date[] lDate = new Date[init_size];
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        lDate[0] = beginDate;//把开始时间加入集合
        int index = 1;
        while (true) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if(cal.getTime().after(endDate)){
                break;
            }
            if(index >= lDate.length - 1){//扩容
                lDate = Arrays.copyOf(lDate,lDate.length + init_size);
            }
            lDate[index] = cal.getTime();
            index ++ ;
        }
        return Arrays.copyOfRange(lDate,0,index);
    }

    public static Date newDate(int y,int m, int d){
        Calendar cal = Calendar.getInstance();
        cal.set(y,m-1,d);
        return cal.getTime();
    }

    /**
     * 将日期类字符串转为时间戳
     * @param str
     * @return
     */
    public static Timestamp str2Timestamp(String str){
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        try{
            ts=Timestamp.valueOf(str);
            return ts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期类字符串转为时间戳
     * @param str
     * @return
     */
    public static Timestamp dateStr2Timestamp(String str){
        String s = dateStr2Str(str);
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        try{
            ts=Timestamp.valueOf(s);
            return ts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String timestamp2Str(Date timestamp){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try{
            tsStr = sdf.format(timestamp);
            return tsStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String timestamp2Str1(Date timestamp){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try{
            tsStr = sdf.format(timestamp);
            return tsStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String timestamp2Str(Date timestamp,String parrten){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat(parrten);
        try{
            tsStr = sdf.format(timestamp);
            return tsStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static String timestamp2String(Timestamp timestamp){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            tsStr = sdf.format(timestamp);
            return tsStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }





    /**
     * yyyy-MM-dd 转为 yyyy-MM-dd HH:mm:ss
     * @param strDate 格式必须是 yyyy-MM-dd的，转换出来的结果为 yyyy-MM-dd HH:mm:ss
     */
    public static String dateStr2Str(String strDate) {
        String resStr = "";
        if(StringUtils.isNotEmpty(strDate)){
            //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
            SimpleDateFormat ssimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = parseDate(strDate.split("\\.")[0]);
            resStr = formatDate(date, "yyyy-MM-dd HH:mm:ss");
        }
        return resStr;
    }

    public static void main(String args[]) {
        //System.out.println(getMonthLastTime(new Date()));
        /*Date[] ds = getDatesBetween(new Date(2016-1900,7-1,9),new Date());
        for (int i =0;i<ds.length;i++){
            System.out.println(getTime(ds[i],"yyyy-MM-dd"));
        }*/
//        System.out.println(getTime(newDate(2016,6,1),"yyyy-MM-dd"));
//        System.out.println(getTime(getPrevMonth(new Date()),"yyyy-MM-dd"));
//        System.out.println(getTime(getPrevWeek(new Date()),"yyyy-MM-dd"));
//        System.out.println(getTime(getFirstTimeOfDate(new Date()),"yyyy-MM-dd HH"));
//        System.out.println(getTime(getLastTimeOfDate(new Date()),"yyyy-MM-dd HH"));
//        System.out.println(Arrays.asList(getDaysBetween("2018-08-23","2018-07-26")));

//        String s = toDateEndTime("2018-10-16", 1);
//        System.out.println(s);

//        String[] daysBetween = getDaysBetween("2018-10-10", "2018-10-16 23:59:59");
//        System.out.println(daysBetween);


//        String dateTime = getDateTime("2018-10-16 23:59:59", "yyyy-MM-dd");
//        System.out.println(dateTime);

//        String s = dateStr2Str("2018-10-16 23:59:59");
//        String s2 = dateStr2Str("2018-10-16");
//        String s3 = dateStr2Str("2018-10-16 23:59:59.0");
//        Timestamp timestamp = dateStr2Timestamp("2018-10-16");
//        System.out.println(s);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(timestamp);


//        String leaveDate = "2018-10-12 00:00:00";
//        Date leave_date_date = DateUtils.parseDate(leaveDate);
//
//        //时间戳的开始日期
//        Date timestampDate = DateUtils.parseDate("1970-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
//
//        if(leave_date_date.before(timestampDate)){
//            System.out.println("111111");
//        }else{
//            System.out.println("222222");
//        }

//        Timestamp currentTimestamp = DateUtils.getCurrentTimestamp();
//
//        System.out.println(currentTimestamp);


//        Date preDate = DateUtils.StrToDate("2019-01-03 19:08:09","yyyy-MM-dd");
//
//        String startDate = DateUtils.getTime(preDate,"yyyy-MM-dd");
//        String endDate = DateUtils.getTime(new Date(),"yyyy-MM-dd");
//
//        Boolean flag = false;
//        if(startDate.equals(endDate)){
//            flag = true;
//        }
//
//        System.out.println(flag);


        String[] daysBetween = DateUtils.getDaysBetween("2019-01-02", "2018-12-20");

        System.out.println(daysBetween);


    }

}

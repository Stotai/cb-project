package com.qianya.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SuppressWarnings("all")
public class DateUtil {

	public final static String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public final static String FORMAT_YYYY_MM_TO_START = "yyyy-MM-dd 00:00:00";


	public final static String FORMAT_YYYY = "yyyy";
	public final static String FORMAT_YYYY_CH = "yyyy年";


	public final static String FORMAT_YYYY_MM = "yyyy-MM";
	public final static String FORMAT_YYYY_MM_CH = "yyyy年MM月";

	public final static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public final static String FORMAT_YYYY_MM_DD_CH = "yyyy年MM月dd日";
	public final static String FORMAT_MM_DD_CH = "MM月dd日";
	public final static String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";


	public final static String FORMAT_A_HH_MM = "a HH:mm";
	public final static String FORMAT_HH_MM = "HH:mm";

	public final static String FORMAT_HH_MM_CH = "HH小时mm分";

	public static final SimpleDateFormat SFMDATE = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 将字符串转换成日期
	* @Title: parseDate
	* @Description: TODO
	* @author txy
	* @param date
	* @param format
	* @return
	* @throws ParseException
	* @throws
	 */
	public static Date parseDate(String date, SimpleDateFormat format) throws ParseException {
		if (StringUtil.isEmpty(date))
			return null;
		return format.parse(date);
	}

	/**
	 * 将字符串转换成日期,使用自定义格式
	* @Title: parseDate
	* @Description: TODO
	* @author txy
	* @param date
	* @param pattern
	* @return
	* @throws ParseException
	* @throws
	 */
	public static Date parseDate(String date, String pattern) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat(pattern);
		return parseDate(date, ft);
	}
	/**
	 * 将日期转换成字符串,
	* @Title: formatDate
	* @Description: TODO
	* @author txy
	* @param date
	* @param format
	* @return
	* @throws
	 */
	public static String formatDate(Date date, SimpleDateFormat format) {
		if (date == null)
			return null;
		return format.format(date);
	}

	public static String addDaysToTime(String timeString, int days) {
		// 定义时间格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// 将时间字符串解析为LocalDateTime对象
		LocalDateTime dateTime = LocalDateTime.parse(timeString, formatter);

		// 增加指定天数
		LocalDateTime newDateTime = dateTime.plusDays(days);

		// 将新的时间转换为字符串
		String newTimeString = newDateTime.format(formatter);

		return newTimeString;
	}


	/**
	 * 将对象装换为字符串
	* @Title: formatDate
	* @Description: TODO
	* @author txy
	* @param date
	* @param pattern
	* @return
	* @throws
	 */
	public static String formatDate(Object date, String pattern) {
		SimpleDateFormat ft = new SimpleDateFormat(pattern);
		if (date == null){
			return null;
		}
		return ft.format(date);
	}

	/**
	 * 获取某天开始时间
	* @Title: getEndTime
	* @Description:
	* @param startTime
	* @return
	* @throws  null
	* @author txy
	* @time 2016年8月8日   上午10:49:21
	 */
	public static Date getDayStartTime(Date startTime){
		Calendar c= Calendar.getInstance();
		c.setTime(startTime);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 00);
		c.set(Calendar.SECOND, 00);
        Date time = c.getTime();
        c = null;
        return time;
	}

	/**
	 * 获取某天结束时间
	* @Title: getEndTime
	* @Description:
	* @param endTime
	* @return
	* @throws  null
	* @author txy
	* @time 2016年8月8日   上午10:49:28
	 */
	public static Date getDayEndTime(Date endTime){
		Calendar c= Calendar.getInstance();
		c.setTime(endTime);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
        Date time = c.getTime();
        c = null;
        return time;
	}

	/**
	 * 得到某月的开始时间
	* @Title: getMonthStartTime
	* @Description:
	* @param startTime
	* @return
	* @throws  null
	* @author txy
	* @time 2016年8月8日   上午10:53:54
	 */
	public static Date getMonthStartTime(Date startTime){
		Calendar c= Calendar.getInstance();
		c.setTime(startTime);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 00);
		c.set(Calendar.SECOND, 00);
        Date time = c.getTime();
        c = null;
        return time;
	}

	/**
	 * 得到某月的结束时间
	* @Title: getMonthEndTime
	* @Description:
	* @param endTime
	* @return
	* @throws  null
	* @author txy
	* @time 2016年8月8日   上午10:54:35
	 */
	public static Date getMonthEndTime(Date endTime){
		Calendar c= Calendar.getInstance();
		c.setTime(endTime);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
        Date time = c.getTime();
        c = null;
        return time;
	}

	/**
	 * 得到预约时间段
	* @Title: getOrderTime
	* @Description: TODO
	* @author txy
	* @param startTime
	* @param endTime
	* @return
	* @throws  null
	 */
	public static String getOrderTime(Date startTime ,Date endTime){

		StringBuffer orderTime =  new StringBuffer();

		SimpleDateFormat sdfYMD = new SimpleDateFormat(FORMAT_YYYY_MM_DD_CH);
		orderTime.append(sdfYMD.format(startTime));
		SimpleDateFormat sdfHM = new SimpleDateFormat(FORMAT_HH_MM_CH);
		orderTime.append(" ("+sdfHM.format(startTime)+"-" +sdfHM.format(endTime)+") " );
		return orderTime.toString();
	}
    /**
     * 获取当前时间
     * @param format 格式
     * @return
     */
    public static String getNowFormat(String format){
    	return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }
    /***
     *
     * @Title: getFutureSomeTime
     * @Description: 返回未来某个时间
     * @author yehg.
     * @param minute 分钟数
     * @return
     * @return Date    返回类型
     * @throws
     */
    public static Date getFutureSomeTime(Long minute){
    	minute = (minute*1000*60)+System.currentTimeMillis();
    	return new Date(minute);
    }

    /**
     *
    * @Title: getSeason
    * @Description:
    * @return
    * @throws  null
    * @author txy
    * @time 2016年11月16日   上午9:51:41
     */
    public static Integer getSeason(Date date){

    	 int season = 0;

         Calendar c = Calendar.getInstance();
         c.setTime(date);
         int month = c.get(Calendar.MONTH);
         switch (month) {
         case Calendar.JANUARY:
         case Calendar.FEBRUARY:
         case Calendar.MARCH:
             season = 1;
             break;
         case Calendar.APRIL:
         case Calendar.MAY:
         case Calendar.JUNE:
             season = 2;
             break;
         case Calendar.JULY:
         case Calendar.AUGUST:
         case Calendar.SEPTEMBER:
             season = 3;
             break;
         case Calendar.OCTOBER:
         case Calendar.NOVEMBER:
         case Calendar.DECEMBER:
             season = 4;
             break;
         default:
             break;
         }
         return season;
    }

    /**
     * 获取当前所在时间属于的季度
    * @Title: getSeason
    * @Description:
    * @return
    * @throws  null
    * @author txy
    * @time 2016年11月16日   上午9:52:34
     */
    public static Integer getSeason(){
    	Date date = new Date();
    	return getSeason(date);
    }
    /***
     *
     * @Title: resutFutureTime
     * @Description: 返回未来某个时间
     * @author yehg.
     * @param data 已经知道的某个时间
     * @param calendar Calendar. 类型
     * @param i
     * @return
     * @return Date    返回类型
     * @throws
     */
    public static Date resutFutureTime(Date data,int calendar, int i){
    	 Calendar c = Calendar.getInstance();
		 c.setTime(data);
		 c.add(calendar, i);
        Date time = c.getTime();
        c = null;
        return time;
    }
	  /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        currCal = null;
        return getYearFirst(currentYear);
    }
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        calendar = null;
        return currYearFirst;
    }


    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        calendar = null;
        return currYearLast;
    }
    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        currCal= null;
        return getYearLast(currentYear);
    }
	/**
	 * 得到几天前的时间
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d,int day){
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        Date time = now.getTime();
        now = null;
        return time;
	}
	/**
	 * Date转换为String
	 *
	 * @return返回字符串格式 yyyy-MM-dd
	 */
 	public static String getStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
        formatter = null;
        return dateString;
	}

	/**
	 *
	 * @Title: getCurrTimeToOver
	 * @Description: 获取此时此刻距离当天结束还剩多少秒
	 * @author Sunt.
	 * @time 2019年3月10日 下午5:17:51
	 * @return Integer    返回类型
	 * @throws
	 */
	public static Integer getCurrTimeToOver() {
		Date date = new Date();
		Calendar midnight=Calendar.getInstance();
		midnight.setTime(date);
		midnight.add(Calendar.DAY_OF_MONTH,1);
		midnight.set(Calendar.HOUR_OF_DAY,0);
		midnight.set(Calendar.MINUTE,0);
		midnight.set(Calendar.SECOND,0);
		midnight.set(Calendar.MILLISECOND,0);
		Integer seconds=(int)((midnight.getTime().getTime()-date.getTime())/1000);
		date = null;
		midnight = null;
		return seconds>0?seconds:1;
	}

    /**
     * 两个日期相差天数
     * @param satrtDate
     * @param endDate
     * @return
     */
    public static int daysOfTwo(Date satrtDate, Date endDate) {
        int days = (int) ((endDate.getTime() - satrtDate.getTime()) / (1000*3600*24));
        return days;
    }
	/**
	 *  获取当前时间到明日凌晨0:00的分钟数
	 *
	 * @author ZhouXiaoGang
	 * @date 2019/6/5 0005 上午 10:36
	 * @param
	 * @return long
	 */
	public static long getTodayEndTime() {
		Date date = new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.MILLISECOND,0);
		Long timeout=(calendar.getTimeInMillis()-System.currentTimeMillis())/1000/60;
        date = null;
		calendar = null;
		return timeout;
	}

    // 获得某天最大时间 2017-10-15 23:59:59
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    // 获得某天最小时间 2017-10-15 00:00:00
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

	/**
	 * 计算得到MongoDB存储的日期，（默认情况下mongo中存储的是标准的时间，中国时间是东八区，存在mongo中少8小时，所以增加8小时）
	 * http://www.iteye.com/problems/88487
	 * @author: Ralph Zhao
	 * @date:  2019年 06月 11日 下午 04:00
	 * @param: date    基准时间
	 * @param: hours   相差时间
	 * @return:
	 */
	public static Date getBeforeOrAfterDate(Date date, int hours) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.HOUR_OF_DAY, hours);
        Date time = ca.getTime();
        ca = null;
        return time;
	}

	/**
	 * 获取当天（今日）零点零分零秒
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Date getEarlyMorningDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date zero = calendar.getTime();
		calendar = null;
		return zero;
	}




    /**
     * 日期转化方法
     * mongo 日期查询isodate
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr){
        //T代表后面跟着时间，Z代表UTC统一时间
        Date date = formatD(dateStr);
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
        String isoDate = format.format(date);
        try {
            return format.parse(isoDate);
        } catch (ParseException e) {
            LogUtil.error(Object.class, e);
        }
        return null;
    }

    public static Date formatD(String dateStr){
        return formatDate(dateStr,FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    public static Date formatDate(String dateStr ,String format)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date ret = null ;
        try {
            ret = simpleDateFormat.parse(dateStr) ;
        } catch (ParseException e) {
            LogUtil.error(Object.class, e);
        }
        return ret;
    }

    /**
     *
     * @Title: getRandomTimeMinutes
     * @Description: 在原来的分钟上随机加20分钟以内
     * @param timeMinutes 原来分钟数
     * @author Sunt.
     * @time 2019年7月11日 上午11:41:27
     * @return long    返回类型
     * @throws
     */
    public static long getRandomTimeMinutes(long timeMinutes)  {
    	return Math.addExact(timeMinutes, (long)Math.ceil(Math.random() * 20));
    }

    /**
     * @description: 在原来的分钟上随机加200分钟以内
     * @param timeMinutes
	 * @return long
     * @author zhouli
     * @date: 2022-12-13 下午 2:18
     */
	public static long getRandomTimeMinutes200(long timeMinutes)  {
		return Math.addExact(timeMinutes, (long)Math.ceil(Math.random() * 120));
	}

	/**
	 * 获取当前时间的时分
	 * @param date
	 * @return
	 */
	public static String getStringTime(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String dateString = formatter.format(date);
		formatter = null;
		return dateString;
	}
	public  static String getDateStrByDays(int days){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -days);
		return SFMDATE.format(calendar.getTime());
	}

	/**
	 * 判断当前时间在时间区间内
	 * @param nowTime   当前时间
	 * @param startTime	开始时间
	 * @param endTime   结束时间
	 * @return
	 * @author zhouli
	 * @date 2020-09-16 18:26:22
	 */
	public static int isEffectiveTime(String nowTimeStr, String startTimeStr, String endTimeStr) throws ParseException {
		Date nowTime = null;
		SimpleDateFormat ft = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
		if(StringUtil.isEmpty(nowTimeStr)){
			nowTime = new Date();
		}else{
			nowTime = ft.parse(nowTimeStr);
		}
		if(StringUtil.isEmpty(startTimeStr) || StringUtil.isEmpty(endTimeStr)){
			return  0;//时间数据不正确
		}
		Date startTime = ft.parse(startTimeStr);
		Date endTime = ft.parse(endTimeStr);

		if (nowTime.getTime() == startTime.getTime()) {
			return 1;//有效
		}

		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if (date.after(begin) && date.before(end)) {
			return 1;//有效
		} else if (date.before(begin)){
			return -1;//还未到
		}else if (date.after(end)){
			return 2;//已过期
		}else{
			return 0;//时间数据不正确
		}
	}

	/**
	 * 根据日期字符串转时间戳
	 * @param strTime
	 * @return
	 */
	public static Integer timeStringToTimestamp(String strTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Long l = sdf.parse(strTime).getTime() / 1000;
			return l.intValue();
		} catch (Exception e) {
			LogUtil.error(Object.class, e);

		}
		return null;
	}


	private final static long minute = 60 * 1000;// 1分钟
	private final static long hour = 60 * minute;// 1小时
	private final static long day = 24 * hour;// 1天
	private final static long month = 31 * day;// 月
	private final static long year = 12 * month;// 年

	/**
	 * 返回文字描述的日期
	 *
	 * @param date
	 * @return
	 */
	public static String getTimeFormatText(Date date) {
		if (date == null) {
			return null;
		}
		long diff = new Date().getTime() - date.getTime();
		long r = 0;
		if (diff > year) {
			r = (diff / year);
			return r + "年前";
		}
		if (diff > month) {
			r = (diff / month);
			return r + "个月前";
		}
		if (diff > day) {
			r = (diff / day);
			return r + "天前";
		}
		if (diff > hour) {
			r = (diff / hour);
			return r + "个小时前";
		}
		if (diff > minute) {
			r = (diff / minute);
			return r + "分钟前";
		}
		return "刚刚";
	}

	/**
	 *  时间字符串转换
	 * @author lhl
	 * @date 2022-06-22 下午 03:05
	 * @param time
	 * @param format
	 */
	public static String timeChangeStrTime(String time,String format){
		return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS)).format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 *  计算两个时间小时差
	 * @author lhl
	 * @date 2022-06-22 下午 03:05
	 * @param time
	 * @param format
	 */
	public static long countTimeHour(LocalDateTime time1,String time){
		return Duration.between(time1,LocalDateTime.parse(time, DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS))).toHours()+1;
	}

	/**
	 *  计算两个时间毫秒值
	 * @author lhl
	 * @date 2022-06-22 下午 03:05
	 * @param time
	 * @param format
	 */
	public static long countTimeMinSec(LocalDateTime time1,String time){
		return Duration.between(time1,LocalDateTime.parse(time, DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD_HH_MM_SS))).toMillis();
	}

	/**
	 * 毫秒转化为天小时分钟秒
	 *
	 * @param ms 毫秒值
	 * @return
	 */
	public static Map<String, Long> formatTime(long ms) {
		int ss = 1000;
		int mi = ss * 60;  //1分毫秒数
		int hh = mi * 60; //1小时毫秒数
		int dd = hh * 24; //1天毫秒数
		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh)/ mi;
		long sec = (ms - day * dd - hour * hh-minute*mi)/ ss;
		//double second = (ms - day * dd - hour * hh - minute * mi) * 1.0 / ss;
		// long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
		Map<String, Long> timeMap=new HashMap<>();
		timeMap.put("day",day);
		timeMap.put("hour",hour);
		timeMap.put("min",minute);
		timeMap.put("sec",sec);
		return timeMap;
	}
}

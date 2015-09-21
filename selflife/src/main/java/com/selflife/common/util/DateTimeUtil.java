package com.selflife.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于实现时间类型与字符串之间的转换；
 * 
 * @version
 * @author
 */
public class DateTimeUtil {
	/**
	 * 将当前时间，转换成格式为"yyyy-MM-dd HH:mm:ss"的字符串 Return current datetime string.
	 * 
	 * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * 按照给定的格式，返回当前事件的字符串.
	 * 
	 * @param pattern
	 *            String 制订的格式字串，格式应符合SimpleDateFormat支持的内容
	 * @return String
	 */
	public static String getDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * 按照给定的日期，默认转换成格式 "yyyy-MM-dd" 的字符串.
	 * 
	 * @param date
	 *            Date
	 * @param dateFormat
	 *            String
	 * @return String
	 */
	public static String shortFmt(Date date, String dateFormat) {
		if (null == dateFormat || "".equals(dateFormat.trim())) {
			dateFormat = "yyyy-MM-dd";
		}
		String strDate = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			strDate = sdf.format(date);
		}
		return strDate;
	}

	/**
	 * 当前时间默认转换成格式 "yyyy-MM-dd HH:mm:ss" 的字符串.
	 * 
	 * @param date
	 *            Timestamp
	 * @param dateFormat
	 *            String
	 * @return String
	 */

	public static String shortFmt(java.sql.Timestamp date, String dateFormat) {
		if (null == dateFormat || "".equals(dateFormat.trim())) {
			dateFormat = "yyyy-MM-dd HH:mm:ss";
		}
		String strDate = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			strDate = sdf.format(date);
		}
		return strDate;
	}

	/**
	 * 将传递的字符串转换成Date值.
	 * 
	 * @param param
	 *            String 格式是: "yyyy-MM-dd HH:mm"、“yyyy-MM-dd”.
	 * @return Date
	 */
	public static Date parse(String param) {
		Date date = null;

		if (param == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
			try {
				date = sdf2.parse(param);
			} catch (ParseException ex2) {

			}
		} finally {
			if (date != null) {
				return date;
			} else {
				return null;
			}
		}
	}

	/**
	 * 将传递的字符串转换成Timestamp值.
	 * 
	 * @param param
	 *            String 格式是: "yyyy-MM-dd HH:mm"、“yyyy-MM-dd”.
	 * @return Timestamp
	 */
	public static Timestamp parseTimestamp(String param) {
		Date date = null;
		Timestamp time = null;
		if (param == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
			try {
				date = sdf2.parse(param);
			} catch (ParseException ex2) {
			}
		} finally {
			if (date != null) {
				return new Timestamp(date.getTime());
			} else {
				return null;
			}
		}
	}

	/**
	 * * 比较两个给定的Date值的大小.
	 * 
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return int 0 date1等于date2 ;1 date1>date2;-1 date1<date2
	 */

	public static int compareDatetime(Date date1, Date date2) {
		int compareResult = 0;

		if (date1 == null || date2 == null)
			return -2;

		long lngTime1 = date1.getTime();
		long lngTme2 = date2.getTime();

		if (lngTime1 == lngTme2)
			return 0;
		else if (lngTime1 > lngTme2)
			return 1;
		else
			return -1;
	}

	/**
	 * 检查时间格式
	 * 
	 * @param time
	 *            String
	 * @param dateFormat
	 *            String 默认为"yyyy-MM-dd hh:mm:ss"
	 * @return boolean
	 */
	public static boolean checkTime(String time, String dateFormat) {
		if (null == dateFormat || "".equals(dateFormat.trim())) {
			dateFormat = "yyyy-MM-dd hh:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			sdf.parse(time);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String dat = "1900-1-1 00:00:00";
		String dat2 = "2100-1-1 00:00:00";
		String dat3 = "2003-05-09";
		//System.out.println(DateTimeUtil.shortFmt(new Date(), null));
		System.out.println(digitalToChinese(1011345));
	}
	/**
	 * 
	 * @param time
	 * @param dateFormat
	 * @return
	 * @author:
	 * @create:Dec 13, 20106:14:24 PM
	 */
	
	public static Date parseDate(String time, String dateFormat){
		
		if (null == dateFormat || "".equals(dateFormat.trim())) {
			dateFormat = "yyyy-MM-dd hh:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date =null;
		try {
			date = sdf.parse(time);
		
		} catch (Exception e) {
			
		}
		return date;
	}
//	public static String changetoChinese(Date date){
//		
//		 
//		 Calendar ca = Calendar.getInstance();
//		 ca.setTime(date);
//		 int year = ca.get(Calendar.YEAR);
//		 int month = ca.get(Calendar.MONTH)+1;
//		 int day = ca.get(Calendar.DAY_OF_MONTH);  
//		 String y = DateTimeUtil.digitalToChinese(year);
//		 String m = Util.numberTohzsz(new Integer(month).toString());
//		 String d = Util.numberTohzsz(new Integer(day).toString());
//		 
//		return y+"年"+m+"月"+d+"日";
//	}
	public static String digitalToChinese(int digital){
		String[] zharray = {"零","一","二","三","四","五","六","七","八","九"};
		 String st = Integer.toString(digital);
		  StringBuffer buf = new StringBuffer();  
		  for(int i=0;i<st.length();i++){
			 String sub = st.substring(i, i+1);
			 buf.append(zharray[Integer.parseInt(sub)]);
		 }
		 return buf.toString();
	}
	
	/**
	 * 将当前时间，转换成格式为"yyyy-MM-dd HH:mm:ss"的字符串 Return current datetime string.
	 * 
	 * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getDateChinese() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String dt = sdf.format(new Date());
		return dt;
	}
	   
	   private static final String COMMON_DATE = "yyyyMMddHHmmss";  
	   
	/**
	 *  ce shi shi yong UTC shi jian
	 * @return
	 */
	public static String getStamp(){
		 java.util.Calendar cal = java.util.Calendar.getInstance();
         int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
         int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
         cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
         SimpleDateFormat sdf4 = new SimpleDateFormat(COMMON_DATE); 
     	java.util.Date d=new java.util.Date(cal.getTimeInMillis());
     	return sdf4.format(d).substring(2, 14);
     	
	}
	
	
}

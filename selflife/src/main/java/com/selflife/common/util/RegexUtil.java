package com.selflife.common.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import java.text.SimpleDateFormat;

/**
 * interface验证工具类
 * 
 * @author jeff
 * 
 */
@SuppressWarnings("unchecked")
public class RegexUtil {

 
    
    public final static boolean isNull(Object[] objs){
        if(objs==null||objs.length==0) return true;
        return false;
    }
    
    public final static boolean isNull(Integer integer){
        if(integer==null||integer==0) return true;
        return false;
    }
    
    public final static boolean isNull(Collection collection){
        if(collection==null||collection.size()==0) return true;
        return false;
    }
    
    public final static boolean isNull(Map map){
        if(map==null||map.size()==0) return true;
        return false;
    }
    
    public final static boolean isNull(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase());
    }
    
    
    public final static boolean isNull(Long longs){
        if(longs==null||longs==0) return true;
        return false;
    }
    
    public final static boolean isNotNull(Long longs){
        return !isNull(longs);
    }
    
    public final static boolean isNotNull(String str){
        return !isNull(str);
    }
    
    public final static boolean isNotNull(Collection collection){
        return !isNull(collection);
    }
    
    public final static boolean isNotNull(Map map){
        return !isNull(map);
    }
    
    public final static boolean isNotNull(Integer integer){
        return !isNull(integer);
    }
    
    public final static boolean isNotNull(Object[] objs){
        return !isNull(objs);
    }
    
    public final static boolean isTypeid(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.toLowerCase())||isDigits(str);

    }
    
    /**
     * 匹配URL地址
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isUrl(String str) {
        return match(str, "^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$");
    }
    
    /**
     * 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isPwd(String str) {
        return match(str, "^[a-zA-Z]\\w{6,12}$");
    }
    /**
     * 匹配密码，以字母开头，长度在1-22之间，只能包含小写字母
、数字和下划线
     * @param str
     * @return
     */
    public final static boolean isAccount(String str) {
        return match(str, "^[A-Za-z]\\w{2,19}$");
    }
    
    /**
     * 验证字符，只能包含中文、英文、数字、下划线等字符。
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean stringCheck(String str) {
        return match(str, "^[a-zA-Z0-9\u4e00-\u9fa5-_]+$");
    }
    
    /**
     * 匹配Email地址
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isEmail(String str) {
    		if(null==str) return true;
        return "".equals(str)?true : match(str, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }
    
    /**
     * 匹配非负整数（正整数+0）
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isInteger(String str) {
        return match(str, "^[+]?\\d+$");
    }
    
    /**
     * 判断数值类型，包括整数和浮点数
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isNumeric(String str) { 
        if(isFloat(str) || isInteger(str)) return true;
        return false;
    }
    
    /**
     * 只能输入数字
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isDigits(String str) {
        return match(str, "^[0-9]*$");
    }
    
    /**
     * 匹配正浮点数
     * 
     * @param str
     * @return
     * @author 
     */
    public final static boolean isFloat(String str) {
        return match(str, "^[-\\+]?\\d+(\\.\\d+)?$");
    }
    
    /**
     * 联系电话(手机/电话皆可)验证   
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isTel(String text){
        if(isMobile(text)||isPhone(text)) return true;
        return false;
    }
    
    /**
     * 电话号码验证  
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isPhone(String text){
        return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
    }
    
    /**
     * 手机号码验证   
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isMobile(String text){
    	
    		if(text==null||"".equals(text))return true;
        if(text.length()!=11) return false;
        	
        return match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }
    
    /**
     * 身份证号码验证 
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isIdCardNo(String text){
        return match(text, "^(\\d{6})()?(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\w)$");
    }
    
    /**
     * 邮政编码验证 
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isZipCode(String text){
        return match(text, "^[0-9]{6}$");
    }
    
    /**
     * 判断整数num是否等于0
     * 
     * @param num
     * @return
     * @author 
     */
    public final static boolean isIntEqZero(int num){ 
         return num==0;
    }
    
    /**
     * 判断整数num是否大于0
     * 
     * @param num
     * @return
     * @author 
     */
    public final static boolean isIntGtZero(int num){ 
         return num>0;
    }
    
    /**
     * 判断整数num是否大于或等于0
     * 
     * @param num
     * @return
     * @author 
     */
    public final static boolean isIntGteZero(int num){ 
        return num>=0;
    }
    
    /**
     * 判断浮点数num是否等于0
     * 
     * @param num 浮点数
     * @return
     * @author 
     */
    public final static boolean isFloatEqZero(float num){ 
         return num==0f;
    }
    
    /**
     * 判断浮点数num是否大于0
     * 
     * @param num 浮点数
     * @return
     * @author 
     */
    public final static boolean isFloatGtZero(float num){ 
         return num>0f;
    }
    
    /**
     * 判断浮点数num是否大于或等于0
     * 
     * @param num 浮点数
     * @return
     * @author 
     */
    public final static boolean isFloatGteZero(float num){ 
        return num>=0f;
    }
    
    /**
     * 判断是否为合法字符(a-zA-Z0-9-_)
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isRightfulString(String text){
        return match(text, "^[A-Za-z0-9_-]+$"); 
    }
    
    /**
     * 判断英文字符(a-zA-Z)
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isEnglish(String text){
        return match(text, "^[A-Za-z]+$"); 
    }
    
    /**
     * 判断中文字符(包括汉字和符号)
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isChineseChar(String text){
        return match(text, "^[\u0391-\uFFE5]+$");
    }
    
    /**
     * 匹配汉字
     * 
     * @param text
     * @return
     * @author 
     */
    public final static boolean isChinese(String text){
        return match(text, "^[\u4e00-\u9fa5]+$");
    }
    
    /**
     * 是否包含中英文特殊字符，除英文"-_"字符外
     * 
     * @param str
     * @return
     */
    public static boolean isContainsSpecialChar(String text) {
        if(StringUtils.isBlank(text)) return false;
        String[] chars={"[","`","~","!","@","#","$","%","^","&","*","(",")","+","=","|","{","}","'",
                ":",";","'",",","[","]",".","<",">","/","?","~","！","@","#","￥","%","…","&","*","（","）",
                "—","+","|","{","}","【","】","‘","；","：","”","“","’","。","，","、","？","]"};
        for(String ch : chars){
            if(text.contains(ch)) return true;
        }
        return false;
    }
    
    /**
     * 过滤中英文特殊字符，除英文"-_"字符外
     * 
     * @param text
     * @return
     */
    public static String stringFilter(String text) {
        String regExpr="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
        Pattern p = Pattern.compile(regExpr);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();     
    }
    
    /**
     * 过滤html代码
     * 
     * @param inputString 含html标签的字符串
     * @return
     */
    public static String htmlFilter(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        java.util.regex.Pattern p_ba;
        java.util.regex.Matcher m_ba;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String patternStr = "\\s+";

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_ba = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
            m_ba = p_ba.matcher(htmlStr);
            htmlStr = m_ba.replaceAll(""); // 过滤空格

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;// 返回文本字符串
    }
    
    /**
     * 正则表达式匹配
     * 
     * @param text 待匹配的文本
     * @param reg 正则表达式
     * @return
     * @author 
     */
    private final static boolean match(String text, String reg) {
        if (StringUtils.isBlank(text) || StringUtils.isBlank(reg))
            return false;
        return Pattern.compile(reg).matcher(text).matches();
    }
    
    /**
     *    check number scope
     */
    public final static boolean checkScope(long num,long min,long max){
    	if(min<=num&&num<=max){
    		return true;
    	}else
    		return false;
    }
    public final static boolean checkScope(String num,long min,long max){
    	if(!isDigits(num))return false;
    	long num1=Long.parseLong(num);
    	if(min<=num1&&num1<=max){
    		return true;
    	}else
    		return false;
    }
    /**
     *  valid stamp
     */
	private final static String sty="yyyyMMddHHmmss";


    public final static boolean validStamp(String stamp,int dsecord){
    	if(stamp.length()!=12)return false;
  //  	java.util.Date d=new java.util.Date();
    	int stamp_y=2000+Integer.parseInt(stamp.substring(0, 2));
    	int stamp_mm=Integer.parseInt(stamp.substring(2, 4));
    	int stamp_d=Integer.parseInt(stamp.substring(4, 6));
    	int stamp_h=Integer.parseInt(stamp.substring(6, 8));
    	int stamp_m=Integer.parseInt(stamp.substring(8, 10));
    	int stamp_s=Integer.parseInt(stamp.substring(10, 12));
    	if(stamp_y<2000||stamp_y>2100) return false;
    	if(stamp_mm<1||stamp_mm>12) return false;
    	if(stamp_d<1||stamp_d>31) return false;
    	if(stamp_h<0||stamp_h>23) return false;
    	if(stamp_m<0||stamp_m>60) return false;
    	if(stamp_s<0||stamp_s>60) return false;
    	
    	  java.util.Calendar cal = java.util.Calendar.getInstance();
          int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
          int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
          cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
      	java.util.Date d=new java.util.Date(cal.getTimeInMillis());
    	long d1=d.getTime()/1000;
    	try{   
         SimpleDateFormat sdf3 = new SimpleDateFormat(sty);
            d=sdf3.parse("20"+stamp);
    	}catch(Exception e){
    		e.getMessage();
    	}
    	long  d2=d.getTime()/1000;
    	long dSpace=0;
    	if(d1>d2)dSpace=d1-d2;
    	else dSpace=d2-d1;
    	//System.out.println(d1+"|"+dSpace+"|"+d2);
    	if(dSpace>dsecord)return false;
    	return true;
    }

    public static boolean validStrLen(String verify,int len){
    	if(verify.length()==len)return true;
    	else return false;
    }
    public static boolean validStrScope32(String verify){
    	if(verify.length()<=32&&verify.length()>=1)return true;
    	else return false;
    }
    public static boolean validStrScope(String verify,int len){
    	if(verify.length()<=len&&verify.length()>=1)return true;
    	else return false;
    }
    
    public static boolean validTypeValue(String type,String value){
    	boolean a=false;
    	switch (Integer.parseInt(type)){
    	case 1:
    		a= validStrLen(value,32);
    		break;
    	case 2:
    		a=true;
    		break;
    	case 3:
        
    		a=isMobile(value);
    		break;
    	case 4:
        
    		a=isEmail(value);
    		break;
    	default:
    		a=false;
    		break;
    	}
    	return a;
    }
    

}
package com.xnpool.gaogtest.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    /**
     *
     * @param date
     * @param duration 分钟
     * @return
     */
    public static Date addMinute(Date date, int duration){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,duration);
        return calendar.getTime();
    }
    public static String getBetween(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int m = calendar.get(Calendar.MINUTE);

        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHH");
        String result = sd.format(calendar.getTime());
        if(m < 15){
            return result + "15";
        }else if(m < 30){
            return result + "30";
        }else if(m < 45){
            return result + "45";
        }else if(m >= 45){
            calendar.add(Calendar.HOUR,1);
            return sd.format(calendar.getTime()) + "00";
        }
        return "";
    }

    /**
     *  获取时间点集合
     */
    public static List<String> getPoint(List<String> list,Long time,int count){
        time = time-900000;
        String previous = DateUtil.getBetween(time);
        list.add(previous);
        if(list.size() < count){
            getPoint(list,time,count);
        }
        return list;
    }

    /**
     * 功能描述：返回分
     * @param date
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String value ="13188.88 GH/s";
        BigDecimal bigDecimal = new BigDecimal(value.split(" ")[0]);
        System.out.println(BigDecimal.ZERO.add(bigDecimal));

        System.out.println(DateUtil.getBetween(new Date().getTime() - 300000));
    }
}

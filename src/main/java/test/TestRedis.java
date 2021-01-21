package test;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

/**
 * @author Jason
 * @date 2019/11/25 10:54
 * @description
 */
public class TestRedis {

    public static void main(String[] args) throws ParseException {
        System.out.println(BigDecimal.valueOf(1).add(BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(3))));
    }

    public static String getLastMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        /*calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月*/
        calendar.add(Calendar.MONTH,-1);
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;

    }
}

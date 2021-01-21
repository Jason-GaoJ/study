package leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;

/**
 * @Author Jason
 */
public class Solution {


    public static void main(String[] args) {

        try {

            String jsonStr="{\"amount\":3300,\"channel\":\"CMGE_PAY\",\"currency\":\"TWD\",\"extInfo\":\"{\"goodId\":\"1209242046\",\"userID\":\"61395317\",\"proType\":\"1\",\"proID\":\"1\"}\",\"orderNo\":\"1911151504300790392\",\"otherInfo\":\"\",\"payProjectID\":51,\"payType\":\"Google Play\",\"succ\":0,\"type\":\"FeeCallback\",\"userID\":61395317,\"version\":\"UNKNOW\"}";
            //Socket socket=new Socket("52.194.216.186",51566);
            //Socket socket=new Socket("52.194.216.186",51580);
            Socket socket=new Socket("52.194.216.186",51530);
            socket.setSoTimeout(5000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.write(jsonStr);
            writer.flush();
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            System.out.println(socket.getOutputStream());
            System.out.println(reader.read());
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s="武神";
        String ss=String.format("%s=%s","name",s);
        System.out.println(ss);
    }



    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        try {
            boolean is0 = x < 0;
            x = Math.abs(x);
            String xStr = String.valueOf(x);
            char[] xBytes = xStr.toCharArray();
            boolean isOdd = xBytes.length % 2 == 1;
            for (int i = 0; i < xBytes.length; i++) {
                if (isOdd) {
                    if (i == (xBytes.length - 1 - i)) {
                        break;
                    }
                } else {
                    if (i == ((xBytes.length - 1) / 2)) {
                        char temp = xBytes[i];
                        xBytes[i] = xBytes[xBytes.length - 1 - i];
                        xBytes[xBytes.length - 1 - i] = temp;
                        break;
                    }
                }
                char temp = xBytes[i];
                xBytes[i] = xBytes[xBytes.length - 1 - i];
                xBytes[xBytes.length - 1 - i] = temp;
            }

            x = Integer.parseInt(String.valueOf(xBytes));
            return is0 ? -x : x;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 更优解法，反转数字
     * @param x
     * @return
     */
    private static int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            // x % 10 可以取到 x 最后一位的值，即此时 pop 是 x 的最后一位，也就是新值的第一位
            int pop = x % 10;
            // x 的位数少了最后一位
            x = x / 10;

            // 由于后续运算 result = result * 10 + pop
            // 如果 result 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MAX_VALUE / 10，那么 pop 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
            // 相反的，result 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MIN_VALUE / 10，那么 pop 的值如果小于于 Integer.MIN_VALUE % 10 也会溢出

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                result = 0;
                return result;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                result = 0;
                return result;
            }

            result = result * 10 + pop;
        }
        return result;
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int y=0;
        while(x!=0){
            int temp=x%10;
            x=x/10;
            y=y*10+temp;
        }
        System.out.println(y);
        return y==x;
    }
}

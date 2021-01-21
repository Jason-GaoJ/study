package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason
 * @date 2019/11/22 11:43
 * @description 罗马数转整数。
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RomanToInt {

    static Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };

    public static void main(String[] args) {

        System.out.println(solutionV1("III"));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String pre=strs[0];
        for (int i = 1; i < strs.length; i++) {
            String last=strs[i];
            int length= Math.min(pre.length(), last.length());
            while (length>=1&&!pre.substring(0,length).equals(last.substring(0,length))){
                length--;
            }
            pre=pre.substring(0,length);
        }
        return pre;
    }

    public static int solutionV1(String s) {
        char[] chars=s.toCharArray();
        int result=0;
        for (int i = 0; i <chars.length ; i++) {
            int last=(i+1)>=chars.length?map.get(String.valueOf(chars[i])):map.get(String.valueOf(chars[i+1]));
            int value=map.get(String.valueOf(chars[i]));
            if(value>=last){
                result+=value;
            }else{
                result-=value;
            }
        }
        return result;
    }
}

package leetcode;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description 给定一个字符串式子，返回它的计算结果。算术规则为: k*[encoded_string]，
 * 表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。e.g. s = "3*[a2*[c]]", 返回 “accaccacc”
 * @createTime 2021年03月08日 11:44:00
 */
public class ComputeString {

    /**
     *
     * @param str string字符串
     * @return string字符串
     */
    public String computeString (String str) {
        // write code here
        char[] chars=str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            if(c>='0'&&c<='9'){

            }else if(c>='a'&&c<='z'){

            }else if(c=='*'){

            }
        }
        return "";
    }
}

package leetcode;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @description
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 输入例子1:
 * "()"
 *
 * 输出例子1:
 * true
 *
 * 输入例子2:
 * "(*)"
 *
 * 输出例子2:
 * true
 *
 * 输入例子3:
 * "(*))"
 *
 * 输出例子3:
 * true
 * @createTime 2021年03月08日 11:56:00
 */
public class CheckValidString {

    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean checkValidString (String s) {
        // write code here
        int right=0;
        int left=0;
        int star=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(') left++;
            if(c==')') right++;
            if(c== '*') star++;
        }
        return Math.abs(right-left)==star||right==star;
    }
}

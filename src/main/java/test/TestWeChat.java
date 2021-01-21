package test;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Jason
 * @date 2019/12/18 14:06
 * @description
 */
public class TestWeChat {


    public static void main(String[] args) {

        try {
            int count = 0;
            while (StringUtils.isNotEmpty("aa")) {
                if (count >=3) {
                    throw new Exception("正在处理");
                }
                Thread.sleep(10);
                System.out.println(count);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




 /*   *
     * 生成用于获取access_token的Code的Url
     *
     * @param redirectUrl
     * @return
    public String getRequestCodeUrl(String redirectUrl) {
        return String.format("https://open.weixin.qq
        * .com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                APPID, redirectUrl, "snsapi_userinfo", "xxxx_state");
*/

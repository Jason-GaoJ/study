package test;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Jason
 * @date 2019/12/14 10:31
 * @description
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String content="POST&%2FNewMJFeeCallBack%2FqqH5Callback&amt=20&app_remark={\"proId\":\"179101\",\"proType\":\"4\",\"projectID\":\"15501001\",\"userId\":\"92314443\"}&bill_no=210128153344mQFRGGFp&openid=95BDED4D84EA5C72C785ECB2F8662CE3&ts=1611819240&AppSecret=7RIVRbOiQ63SwqLP";
        String secret = "7RIVRbOiQ63SwqLP";// 加密使用的key
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        byte[] hash =sha256_HMAC.doFinal(content.getBytes());// 重点

        System.out.println(byte2hex(hash));
    }
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString();
    }
}
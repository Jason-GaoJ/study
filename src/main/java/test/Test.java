package test;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import sun.misc.BASE64Decoder;

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

    public static void main(String[] args){
        System.out.println("a".hashCode());
        System.out.println("A".hashCode());
        System.out.println((char)97);
        System.out.println((char)65);
        System.out.println((char)1);
        System.out.println(JSON.toJSONString(args));

    }
}
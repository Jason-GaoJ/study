package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月11日 10:57:00
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        readFile();
    }

    private static void readFile() throws IOException {
        File day6file=new File("D:\\Software\\WXWork\\DATA\\WXWork\\1688850650262532\\Cache\\File\\2021-01\\zz.0106.txt");
        File day7file=new File("D:\\Software\\WXWork\\DATA\\WXWork\\1688850650262532\\Cache\\File\\2021-01\\zz.0107.txt");
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();

        FileReader reader6=new FileReader(day6file);
        FileReader reader7=new FileReader(day7file);
        BufferedReader bufferedReader6 = new BufferedReader(reader6);
        BufferedReader bufferedReader7 = new BufferedReader(reader7);
        String str6;
        String str7;
        while ((str6=bufferedReader6.readLine())!=null){
            JSONObject jsonObject=JSON.parseObject(str6);
            Map<String,String> map6=new HashMap<>();
            map6.put("userid",jsonObject.getString("userid"));
            map6.put("openid",jsonObject.getString("openid"));
            map6.put("amount",jsonObject.getString("amount"));
            list6.add(JSONObject.toJSONString(map6));
        }
        while ((str7=bufferedReader7.readLine())!=null){
            JSONObject jsonObject=JSON.parseObject(str7);
            Map<String,String> map7=new HashMap<>();
            map7.put("userid",jsonObject.getString("userid"));
            map7.put("openid",jsonObject.getString("openid"));
            map7.put("amount",jsonObject.getString("amount"));
            list7.add(JSONObject.toJSONString(map7));
        }

        System.out.println(JSONObject.toJSONString(list6));
        //System.out.println(JSONObject.toJSONString(list7));

        bufferedReader6.close();
        reader6.close();
        bufferedReader7.close();
        reader7.close();
    }
}

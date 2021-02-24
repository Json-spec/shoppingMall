package com.wx.shopmall.common;


import net.sf.json.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * httpclient工具类
 */
public class HttpClientUtils {
/**
 * 测试方法
*/
    public static void main(String[] args) throws IOException {
        String url = "http://data.chi4rec.com.cn/xfr/toilet/addToiletData";

        String json1 =  "{\n" +
                "    \"loginName\":\"mhqapi\",\n" +
                "    \"loginPassword\":\"123456\"\n" +
                "}";
String json="{\n" +
        "\t\"temperature\": \"23.00\",\n" +
        "\t\"humidity\": \"89\",\n" +
        "\t\"carbonDioxide\": \"888.20\",\n" +
        "\t\"hydrogenSulfide\": \"0\",\n" +
        "\t\"ammonia\": \"0\",\n" +
        "\t\"water\": 8,\n" +
        "\t\"electric\": 8,\n" +
        "\t\"paper\": 16,\n" +
        "\t\"soap\": 16,\n" +
        "\t\"peopleFlow\": 90,\n" +
        "\t\"groupType\": 0\n" +
        "}";
     String facilityId ="115337";
        String token = "dc794bce-3f14-4735-af85-eb36d4afcde8";
        String postJson = doPostJson(url, json,facilityId,token);
        //String doPostString = doPostString(url, json1);
       // System.out.println(doPostString);
        JSONObject jsonObject = JSONObject.fromObject(postJson);
      //  String token = (String)jsonObject.get("data");
        System.out.println(jsonObject);



    }

        public static String doGet(String url, Map<String, String> param) {
            // 创建Httpclient对象
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String resultString = "";
            CloseableHttpResponse response = null;
            try {
                // 创建uri
                URIBuilder builder = new URIBuilder(url);
                if (param != null) {
                    for (String key : param.keySet()) {
                        builder.addParameter(key, param.get(key));
                    }
                }
                URI uri = builder.build();
                // 创建http GET请求
                HttpGet httpGet = new HttpGet(uri);
                // 执行请求
                response = httpclient.execute(httpGet);
                // 判断返回状态是否为200
                if (response.getStatusLine().getStatusCode() == 200) {
                    resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (response != null) {
                        response.close();
                    }
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return resultString;
        }

        public static String doPost(String url, Map<String, String> param) {
            // 创建Httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            String resultString = "";
            try {
                // 创建Http Post请求
                HttpPost httpPost = new HttpPost(url);
                // 创建参数列表
                if (param != null) {
                    List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                    for (String key : param.keySet()) {
                        paramList.add(new BasicNameValuePair(key, param.get(key)));
                    }
                    // 模拟表单
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                    httpPost.setEntity(entity);
                }
                // 执行http请求
                response = httpClient.execute(httpPost);
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return resultString;
        }


    public static String doPostString(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求 并设置请求头参数
            HttpPost httpPost = new HttpPost(url);

            // 创建请求内容参数传递
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }



        public static String doPostJson(String url, String json,String facilityId,String token) {
            // 创建Httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            String resultString = "";
            try {
                // 创建Http Post请求 并设置请求头参数
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("facilityId",facilityId);
                httpPost.setHeader("token",token);
                //获取请求头参数
                Header[] tokens = httpPost.getHeaders("token");
                // 创建请求内容参数传递
                StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
//
                httpPost.setEntity(entity);
                // 执行http请求
                response = httpClient.execute(httpPost);
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return resultString;
        }




    public static String doGetForWeChat(String url, Map<String, String> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String param = "";
        Iterator<String> it = paramMap.keySet().iterator();

        while(it.hasNext()) {
            String key = it.next();
            param += key + "=" + paramMap.get(key) + "&";
        }
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }







    }



/*
count++;
String url="http://116.228.154.33:9980/toilet/addToiletInfoData";
//创建连接对象
HttpClient httpClient = new HttpClient();
//创建请求
PostMethod method = new PostMethod(url);
//设置请求头格式为json格式
TolitesDataEntity tolitesDataEntity=new TolitesDataEntity();
tolitesDataEntity= testService.a(count,count);
System.out.println(tolitesDataEntity.toString());
System.out.println(tolitesDataEntity.toString());
RequestEntity entity=new StringRequestEntity(tolitesDataEntity.toString(),"application/json","UTF-8");
method.setRequestEntity(entity);
method.setRequestHeader("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5In0.uDkCjYWEAREHe72awxkbcRyFSGKu6hH1IoYwwFw6JNo");
method.setRequestHeader("facilityId", "10086");
httpClient.executeMethod(method);*/

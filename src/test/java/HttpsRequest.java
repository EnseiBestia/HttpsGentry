import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


public class HttpsRequest {

    public static void main(String[] args) {
        try {

            String param ="source=index_nav&redir%3ahttps%3a%2f%2fwww.douban.com%2f&form_email=flb13%40163.com";
            param+="&form_password=Doudou3321%23";//password
            param+="&captcha-solution=brain";//captcha
            param+="&captcha-id=LrqVUCJ9DHKaYlR7L7cWTrGv%3aen";//captcha-id
            System.out.println("param--:"+param);
            System.out.println(HttpsRequest.sendPost("https://accounts.douban.com/login",
                    param));

          /*  String cookies="ll=\"108288\"; bid=dhJVDXeK6wM; __utmc=30149280; __utmz=30149280.1517998955.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ga=GA1.2.538789487.1517998955; ps=y; _gid=GA1.2.893373104.1519353732; ue=\"flb13@163.com\"; ap=1; __yadk_uid=1pROpVT9f3bO3gsXnF1EuXJvrl1zwpmB; push_noty_num=0; push_doumail_num=0; __utmv=30149280.17443; _pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1519359128%2C%22https%3A%2F%2Fgithub.com%2Fxchaoinfo%2Ffuck-login%22%5D; _pk_ses.100001.8cb4=*; __utma=30149280.538789487.1517998955.1519353416.1519359129.3; __utmt=1; dbcl2=\"174431518:WUPOjfloSRE\"; ck=UALy; ct=y; _pk_id.100001.8cb4=b0261007cea1885b.1517998954.4.1519360050.1519356375.; __utmb=30149280.17.10.1519359129";
            System.out.println(HttpsRequest.sendGet("https://www.douban.com/people/174431518/",
                    "",cookies));*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /** * 向指定URL发送GET方法的请求,默认编码UTF-8 * * @param url * 发送请求的URL * @param param * 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 * @return URL 所代表远程资源的响应结果 */
    public static String sendGet(String url, String param,String cookies) {
        return sendGet(url, param, "utf-8",cookies);
    }

    /** * 向指定URL发送GET方法的请求 * * @param url * 发送请求的URL * @param param * 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 * @param charset * 网页编码 * @return URL 所代表远程资源的响应结果 */
    public static String sendGet(String url, String param,String charSet,String cookies) {
        String result = "";
        BufferedReader in = null;
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0],
                    new TrustManager[] { new DefaultTrustManager() },
                    new SecureRandom());
            SSLContext.setDefault(ctx);

            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Cookie",cookies==null?"":cookies);
            connection.setHostnameVerifier(new HostnameVerifier() {

                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),charSet));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


    /** * 向指定 URL 发送POST方法的请求，默认编码UTF-8 * * @param url * 发送请求的 URL * @param param * 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 * @return 所代表远程资源的响应结果 */
    public static String sendPost(String url, String param){
        return sendPost(url, param, "utf-8");
    }

    /** * 向指定 URL 发送POST方法的请求 * * @param url * 发送请求的 URL * @param param * 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 * @param charSet * 网页编码 * @return 所代表远程资源的响应结果 */
    public static String sendPost(String url, String param , String charSet) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0],
                    new TrustManager[] { new DefaultTrustManager() },
                    new SecureRandom());
            SSLContext.setDefault(ctx);


            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setHostnameVerifier(new HostnameVerifier() {

                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),charSet));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
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



    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

}
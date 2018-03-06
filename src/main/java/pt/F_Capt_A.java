package pt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;


public class F_Capt_A {

    public static String STATIC_AUTHORIZATION = "bearer MWJzHS7eNMbN2nMwQHXCfg8Cm9Z7iVVec2o9w76loGH7i3D22VD30kcJ_6hl_TFZXAKj1ZcDypwq66cDgrjEkXVEvd9gmsc5YXZvRimtDDEu3rlgeHJ3ozkBTP7QAM6SSVOvsQLegLBPahamYxgLokJzAq0lRJB211hmWhnbnTNhORk6OaxzD8NrmtMLA3fhJOGsLl2FvZeNGxSb8uryjKHbbemiPMp1O62wMVOfFnqg2z3WFdoIKbQH6r6BcvSS51m4Xm_NDx0TMgRVVub5Oh1P8dt5Dd739GU9Hw2WcmI9zXudQrrdYpJriT0QKdNqn3iIFjVxBJVuSPYMDz5apfBEQbpQabfwechBrRvNjheCCp-4HH4nszhO-p8YHtaXgaONFmi68A1mzD4WIHu3r2JTkZB9Wilkq_lUmgQr94QWlLGGJDK0JOQjOqLNHPYGzYJoRVLrbF7gx422hLd_qnpgK3QOCAOfs89i3ollgrK5Wkz_Uatek59okKmB05dVJFNwKvM4RCN4mNipukA_Jo64LyTTCIh9pCF8Vt4aYQ0aLpYFQ8tG_7aEo7IEOJF6bYyKN0Q1ih_JQZXk1nuTL8x210dz-JQ110SgryVJAm21c77wi7mGcr_fU4hF41jc5rDJB8k2mVxv2v3AGW-T5ry1MBQ";
    public static String STATIC_COOKIES = "access_token=MWJzHS7eNMbN2nMwQHXCfg8Cm9Z7iVVec2o9w76loGH7i3D22VD30kcJ_6hl_TFZXAKj1ZcDypwq66cDgrjEkXVEvd9gmsc5YXZvRimtDDEu3rlgeHJ3ozkBTP7QAM6SSVOvsQLegLBPahamYxgLokJzAq0lRJB211hmWhnbnTNhORk6OaxzD8NrmtMLA3fhJOGsLl2FvZeNGxSb8uryjKHbbemiPMp1O62wMVOfFnqg2z3WFdoIKbQH6r6BcvSS51m4Xm_NDx0TMgRVVub5Oh1P8dt5Dd739GU9Hw2WcmI9zXudQrrdYpJriT0QKdNqn3iIFjVxBJVuSPYMDz5apfBEQbpQabfwechBrRvNjheCCp-4HH4nszhO-p8YHtaXgaONFmi68A1mzD4WIHu3r2JTkZB9Wilkq_lUmgQr94QWlLGGJDK0JOQjOqLNHPYGzYJoRVLrbF7gx422hLd_qnpgK3QOCAOfs89i3ollgrK5Wkz_Uatek59okKmB05dVJFNwKvM4RCN4mNipukA_Jo64LyTTCIh9pCF8Vt4aYQ0aLpYFQ8tG_7aEo7IEOJF6bYyKN0Q1ih_JQZXk1nuTL8x210dz-JQ110SgryVJAm21c77wi7mGcr_fU4hF41jc5rDJB8k2mVxv2v3AGW-T5ry1MBQ;token_type=bearer;token={\"access_token\":\"MWJzHS7eNMbN2nMwQHXCfg8Cm9Z7iVVec2o9w76loGH7i3D22VD30kcJ_6hl_TFZXAKj1ZcDypwq66cDgrjEkXVEvd9gmsc5YXZvRimtDDEu3rlgeHJ3ozkBTP7QAM6SSVOvsQLegLBPahamYxgLokJzAq0lRJB211hmWhnbnTNhORk6OaxzD8NrmtMLA3fhJOGsLl2FvZeNGxSb8uryjKHbbemiPMp1O62wMVOfFnqg2z3WFdoIKbQH6r6BcvSS51m4Xm_NDx0TMgRVVub5Oh1P8dt5Dd739GU9Hw2WcmI9zXudQrrdYpJriT0QKdNqn3iIFjVxBJVuSPYMDz5apfBEQbpQabfwechBrRvNjheCCp-4HH4nszhO-p8YHtaXgaONFmi68A1mzD4WIHu3r2JTkZB9Wilkq_lUmgQr94QWlLGGJDK0JOQjOqLNHPYGzYJoRVLrbF7gx422hLd_qnpgK3QOCAOfs89i3ollgrK5Wkz_Uatek59okKmB05dVJFNwKvM4RCN4mNipukA_Jo64LyTTCIh9pCF8Vt4aYQ0aLpYFQ8tG_7aEo7IEOJF6bYyKN0Q1ih_JQZXk1nuTL8x210dz-JQ110SgryVJAm21c77wi7mGcr_fU4hF41jc5rDJB8k2mVxv2v3AGW-T5ry1MBQ\",\"token_type\":\"bearer\",\"expires_in\":7199,\"refresh_token\":\"ba6a0875c8ef4a9f818c95eab49b6605\",\"userId\":\"6321\",\"username\":\"wangsis1\",\"loginRole\":\"FC\",\"dealer\":\"北京鹏龙星徽汽车销售服务有限公司\",\"financialConsultant\":\"张 爽\",\"saleperson\":\"刘曼\",\"showroom\":\"鹏龙星徽-华威里\",\"dealerId\":\"43047\",\"financialConsultantId\":\"45586\",\"salepersonId\":\"3134\",\"showroomId\":\"43048\",\"FCName\":\"王 思思\",\".issued\":\"Tue, 27 Feb 2018 03:59:54 GMT\",\".expires\":\"Tue, 27 Feb 2018 05:59:54 GMT\"}";
    private String token;
    private String cookies;
    private String authorization;
    public static void main(String[] args) {
        try {
            F_Capt_A fc = new F_Capt_A();
          //  fc.token = fc.login();
           // fc.parseToken();
            fc.parseList(fc.getList());
       //    fc.parseApplication("171378");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String login() throws IOException {
        Map tMap = Base64DecodeUtil.decode();
        String url ="https://pos.mercedes-benz-finance.com.cn/desktop/api/Token";
        String param = "username="+ URLEncoder.encode(tMap.get("u").toString(),"UTF-8")
                +"&password="+URLEncoder.encode(tMap.get("p").toString(),"UTF-8")
                +"&Scope="+URLEncoder.encode(tMap.get("c").toString(),"UTF-8")
                +"&grant_type=password";

        String token = HttpsHandler.sendPost(url,param);
        return token;
    }
    public String getList(){
        String reponse = null;
        String url = "https://pos.mercedes-benz-finance.com.cn/desktop/api/dealerApplication/getworkqlist";
        String getParam  = "index=1&size=10&keyword=&companyFilter=&statusFilter=&startDate=01%2F14%2F2018&endDate=02%2F27%2F2018&order=2&appFilter=1&userFilter=true&dealerID=-1&digitalFormStatus=0";
        String authorizationT = STATIC_AUTHORIZATION;
        String cookiesT = STATIC_COOKIES;
        return HttpsHandler.sendGet(url,getParam,"UTF-8",cookiesT,authorizationT);
    }
    public void parseList(String json){
        JSONObject obj = JSON.parseObject(json);
        JSONArray arr  = obj.getJSONObject("data").getJSONArray("workqViewList");
        for(int i=0;i<arr.size();i++){
            JSONObject it = arr.getObject(i,JSONObject.class);
            System.out.println(it.getString("ApplicationID")+" "+it.getString("Name")+""+it.getString("AssetModelNameCN")+""+it.getString("AssetModelNameEN")+""+it.getString("SerialNumber")+""+it.getString("DealerName")+"");
        }
    }
    private void parseToken(String token){
        JSONObject obj = JSON.parseObject(token);
            String access_token= obj.getString("access_token");
            String token_type = obj.getString("token_type");
            String cookies = "";
            cookies+="access_token="+access_token+";";
            cookies+="token_type="+token_type+";";
            cookies+="token="+token;
            this.cookies = cookies;
            this.authorization = "bearer "+access_token;
        // System.out.println(cookies);
    }
    public void parseApplication(String appID,String cookies){
        String reponse = null;
        String url = "https://pos.mercedes-benz-finance.com.cn/desktop/api/DealerApplication/GetApplication";
        String getParam  = "applicationId="+appID+"&companyId=1";
        String authorizationT = STATIC_AUTHORIZATION;
        String cookiesT = STATIC_COOKIES;
        String rtn= HttpsHandler.sendGet(url,getParam,"UTF-8",cookiesT,authorizationT);
        JSONObject jo = JSON.parseObject(rtn);
        StringBuffer sb = new StringBuffer();
        JSONObject da = jo.getJSONObject("data");
        JSONObject qutation = da.getJSONObject("Quotation");
        sb.append("首付:"+qutation.getDouble("TotalPrincipal")+"\t");
        sb.append("贷款总额(贷款+利息):"+qutation.getDouble("TotalLeasingAmount")+"\t");
        sb.append("利息总额:"+qutation.getDouble("TotalInterestAmount")+"\t");
        sb.append("购买人地址:"+da.getJSONObject("Borrower").getString("AddressDetailAddress")+"\t");
        System.out.println(rtn);
        System.out.println(sb.toString());
    }
}
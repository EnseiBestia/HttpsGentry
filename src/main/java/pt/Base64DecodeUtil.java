package pt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Base64DecodeUtil{
    public static void main(String[] args) throws IOException {

        System.out.println((decode()));

    }
    public static Map<String,String> decode() throws IOException {
        Map<String,String> authMap = new HashMap<String,String>(0);
        BASE64Decoder decoder = new BASE64Decoder();
        String des= new String(decoder.decodeBuffer("aa"));
        String[] desArray = des.split("-");
        authMap.put("u",desArray[0]);
        authMap.put("p",desArray[1]);
        authMap.put("c",desArray[2]);

        return authMap;
    }
}

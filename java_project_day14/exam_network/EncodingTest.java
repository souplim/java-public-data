package exam_network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingTest {
    public static void main(String[] args) {
        String strEncoding;
        try {
            strEncoding = URLEncoder.encode("JAVA 안녕하세요 ! @ # $ % 12345", "utf-8");
            String strDecoding = URLDecoder.decode(strEncoding, "utf-8");

            System.out.println("인코딩된 문자열:"+strEncoding);
            System.out.println("디코딩된 문자열:"+strDecoding);
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}

package exam_network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLOpenStreamTest01 {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            URL url = new URL("https://www.hanbit.co.kr");
            // url.openStream()의 반환형 - InputStream  -> InputStreamReader로 바이트 스트림을 문자스트림으로 변환 -> BufferedReader
            in = new BufferedReader(new InputStreamReader(url.openStream())); // 바이트 -> 문자

            out = new PrintWriter(new FileWriter("index.html"));
            String inLine;
            while((inLine = in.readLine()) != null)
                out.println(inLine);
            System.out.println("파일 복사 완료되었습니다.");
        } catch (MalformedURLException e){
            System.out.println("URL ERROR");
        } catch (IOException i){
            System.out.println("IO ERROR");
        } finally {
            try {
                if( in != null)
                    in.close();
            } catch(Exception e){
                System.out.println("CLOSE ERROR");
            }
        }
    }
}

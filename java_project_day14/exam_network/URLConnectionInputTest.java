package exam_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnectionInputTest {
    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            URL url = new URL("https://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=10");
            URLConnection con = url.openConnection();

            System.out.println("응답헤더 : "+con.getHeaderField(null));
            System.out.println("문서의 타입 : "+con.getHeaderField("Content-Type"));
            System.out.println(" / 문서의 타입 : "+con.getContentType());

            /* 전체 헤더 정보 출력 */
            Map<String, List<String>> map = con.getHeaderFields();
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();

            while(it.hasNext()){
                String key = it.next();
                System.out.println(key + "-----> " +con.getHeaderField(key));
            }

            System.out.println("\n------------문서의 내용------------");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inLine;
            while((inLine = in.readLine()) != null )
                System.out.println(inLine);
        } catch(MalformedURLException e){
            System.out.println("URL ERROR");
        } catch(IOException io){
            System.out.println("IO ERROR");
        } finally {
            try {
                if(in != null)
                    in.close();
            } catch (Exception e){
                System.out.println("CLOSE ERROR");
            }
        }
    }
}

package exam_network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLClassTest {
    public static void main(String[] args) {
        try {
            URL myURL = new URL("http://java.sun.com:80/docs/books/index.html?name=database#TOP");

            System.out.println("프로토콜 = "+myURL.getProtocol());
            System.out.println("호스트명과 포트 = "+myURL.getAuthority());
            System.out.println("호스트명 = "+myURL.getHost());
            System.out.println("포트 = "+myURL.getPort());
            System.out.println("경로 = "+myURL.getPath());
            System.out.println("query = "+myURL.getQuery());
            System.out.println("경로와 query = "+myURL.getFile());
            System.out.println("ref = "+myURL.getRef()); // #

        } catch (MalformedURLException e){
            System.out.println("URL ERROR");
        }
    }
}

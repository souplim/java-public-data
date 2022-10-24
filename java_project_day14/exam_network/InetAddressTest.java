package exam_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress itan = InetAddress.getByName("www.naver.com");
        InetAddress itad = InetAddress.getByName("www.daum.net");

        System.out.println("호스트명과 IP: "+itan.toString());
        System.out.println("호스트명: "+itad.getHostName());
        System.out.println("IP: "+itad.getHostAddress());
        System.out.println();

        InetAddress[] ina = InetAddress.getAllByName("www.naver.com"); // 주소 두개 나오면 서버 두개?
        for(int i=0; i<ina.length; i++)
            System.out.println(ina[i]);
        System.out.println();

        InetAddress ital = InetAddress.getLocalHost();
        System.out.println("로컬 호스트명과 IP: "+ital);
        System.out.println("로컬 호스트명: "+ital.getHostName());
        System.out.println("로컬 컴퓨터 IP주소: "+ital.getHostAddress());


    }
}

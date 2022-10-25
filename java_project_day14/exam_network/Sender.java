package exam_network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 문자열 1개를 보내고 받는 프로그램을 작성하여보자.
public class Sender {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        String s = "우리는 여전히 우리 운명의 주인이다.";
        byte[] buf = s.getBytes();

        StringBuffer sb = new StringBuffer();
        sb.append("실체가 없는 두려움에 뒷걸음치는 것은 자기 자신에 대해 가장 비겁한 짓이다.");
        sb.append("더디더라도 노력하면서 앞으로 나아가면 무엇이든 해낼 수 있고 얼마만큼이든 이룰 수 있다.");
        buf = sb.toString().getBytes();

        // "address"의 "port"에 있는 클라이언트에게 데이터를 보낸다.
        InetAddress address = InetAddress.getByName("127.0.0.1");
        // 로컬 호스트
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
        socket.send(packet);
        socket.close();
    }
}

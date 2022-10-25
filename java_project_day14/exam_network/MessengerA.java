package exam_network;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* UDP 통신을 이용하여서 간단한 채팅을 할 수 있는 메시저를 작성하여 보자.
 * 여기서 송신용 포트 번호와 수신용 포트 번호가 고정되어 있다.*/
public class MessengerA {
    protected JTextField textField;
    protected JTextArea textArea;
    protected JScrollPane scrollPane;

    DatagramSocket socket;
    DatagramPacket packet;
    InetAddress address = null;

    final int myPort = 5000; // 수신용 포트 번호
    final int otherPort = 6000; // 송신용 포트 번호

    public MessengerA() throws IOException {
        new MyFrame();
        address = InetAddress.getByName("127.0.0.1");
        socket = new DatagramSocket(myPort);
    }

    // 패킷 받아서 텍스트 영역에 표시
}

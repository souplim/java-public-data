package exam_network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter out = null;
        Socket socket = null;
        String ServerIP;
        try {
            // 접속할 서버가 클라이언트와 동일 컴퓨터에 존재 시 아래와 같이 작성할 수 있다.
            ServerIP = InetAddress.getLocalHost().getHostAddress(); // 서버의 ip 주소
            // 그러나 서버와 클라이언트가 서로 다른 컴퓨터라면 반드시 서버의 IP를 명시해주어야 한다.
            // 예를 들어 서버 IP가 192.168.0.12라면 ServerIP = "192.168.0.12"로 작성해야 한다.
            socket = new Socket(ServerIP,9999); // localhost == 127.0.0.1. 클라이언트 소켓 생성. 서버에 바로 접속
            System.out.println(ServerIP+" 서버에 접속하였습니다...");

            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력스트림
            String outputMessage;
            while(true){
                System.out.print("텍스트 입력 >> ");
                outputMessage = scanner.nextLine();
                out.write(outputMessage+"\n"); // 서버로 보냄
                out.flush();
                if(outputMessage.equals("끝")){
                    System.out.println("연결을 종료합니다.");
                    break;
                }
            }
            socket.close(); // 연결 종료. 클라이언트 소켓 닫기
            scanner.close();
        } catch (IOException io){
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}

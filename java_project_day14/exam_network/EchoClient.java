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
            ServerIP = InetAddress.getLocalHost().getHostAddress(); // 서버의 ip 주소
            // localhost == 127.0.0.1.
            socket = new Socket("localhost",9999); // 클라이언트 소켓 생성. 서버에 바로 접속
            System.out.println("서버에 접속하였습니다...");

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

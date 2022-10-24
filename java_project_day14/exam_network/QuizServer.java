package exam_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5555); // ServerSocket의 인스턴스를 생성한다.
            System.out.println("클라이언트를 기다린다.");
        } catch(IOException e){
            System.err.println("다음의 포트 번호에 연결할 수 없습니다: 5555");
            System.exit(1);
        }

        // 클라이언트가 서버에 대하여 연결을 요청할 때까지 기다린다.
        // 연결이 되면 새로운 포트와 연결된 Socket 객체를 반환한다.
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("서버와 클라이언트가 연결되었습니다.");
        } catch(IOException e){
            System.out.println("accept() 실패");
            System.exit(1);
        }

        // 서버는 클라이언트와 스트림을 이용하여 통신한다.
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // 출력스트림(서버 -> 클라이언트 데이터 전송)
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 입력스트림(클라이언트 -> 서버 데이터 읽음)

        String inputLine, outputLine;
        QuizProtocol qp = new QuizProtocol();
        outputLine = qp.process(null);
        out.println(outputLine);

        while((inputLine = in.readLine()) != null){
            outputLine = qp.process(inputLine);
            out.println(outputLine);
            if(outputLine.equals("quit"))
                break;
        }
        out.close();
        in.close();

        clientSocket.close();
        serverSocket.close();
    }
}

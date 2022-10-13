package exam_inputstream_read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample1 {
    public static void main(String[] args){
        // try-catch-finally 블록 이용한 예외처리
        InputStream is = null; // 추상클래스 참조변수 = null; try {} 바깥에 선언해야 함
        try {
            is = new FileInputStream("C:/Temp/test.txt"); // 참조변수 = new 서브클래스 생성자()
            System.out.println("[다 읽어들인 문자]");

            // 1
//            int readByte;
//            while(true){
//                readByte = is.read();
//                if(readByte == -1) break;
//                System.out.print((char)readByte);
//            }

            // 2. 바이트 배열에 4개씩 담기. 제일 많이 활용
//            int readByteNo;
//            byte[] readBytes = new byte[4]; // 4개 다 담았을 때 이후에 어떻게 처리되는가
//
//            String data = "";
//            while(true){
//                readByteNo = is.read(readBytes); // 읽어들인 바이트 값을 바이트 배열에 저장하고 그 바이트 수를 반환.
//                System.out.println("읽은 바이트 수: "+readByteNo); // 확인을 위한 코드
//                if(readByteNo == -1) break;
//                data += new String(readBytes, 0, readByteNo);
//            }
//            System.out.println(data);

            // 3. 바이트 배열에 10개씩 담기. 2부터 다섯개만 담기
             int readByteNo;
            byte[] readBytes = new byte[10];
            // read 바이트 배열에 저장할 길이수는 5 이고 배열의 저장위치는 2번째부터
            readByteNo = is.read(readBytes, 2, 5);
            System.out.println("리턴 바이트 수: "+readByteNo);

            for(int i=0; i<readBytes.length; i++)
                System.out.println((char)readBytes[i]);

        } catch (IOException io){ // FileNotFoundException은 IOException의 서브클래스이다
            io.printStackTrace();
        } finally {
            try {
                if(is != null) is.close(); // if문 제거하면 오류남. 객체 생성 안 되었는데 해제하면 안 됨. -> 예외처리해야함
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

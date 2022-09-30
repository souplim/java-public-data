package exam_throws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionMethod3 {
    public static void main(String[] args) {
        FileInputStream fi = null;

        byte[] readBytes = new byte[6];
        int readByteNo;
        String data = "";

        try{
            fi = new FileInputStream("test.txt");
            while(true){
                readByteNo = fi.read(readBytes);
                //System.out.println("읽어들인 바이트 수 : "+readByteNo);
                if(readByteNo == -1) // 더 이상 읽을 데이터가 존재하지 않음
                    break;
                data += new String(readBytes, 0, readByteNo); // 6바이트 밖에 안 되므로
            }
            System.out.println(data);
        } catch(FileNotFoundException fne){
            System.out.println("파일이 존재하지 않습니다.");
        } catch(IOException io){
            System.out.println("파일을 읽는 도중에 문제가 발생하였습니다.");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(fi != null)
                    fi.close(); // IOException 예외 발생 가능
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}

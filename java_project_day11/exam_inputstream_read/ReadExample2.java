package exam_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {
    public static void main(String[] args) {
        // try-with-resources문 이용
        int readByte;
        try (InputStream fis = new FileInputStream("C:/Temp/test.txt")){
            while(true){
                readByte = fis.read();
                if(readByte == -1) break;
                System.out.print((char)readByte);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

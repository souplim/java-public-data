package exam_throws;

import java.io.IOException;

public class ExceptionMethod2 {
    public static void main(String[] args) {
        try{
            System.out.println(readString());
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String readString() throws IOException {
        byte[] buf = new byte[100];
        System.out.print("문자열을 입력하시오: ");
        int readCount = System.in.read(buf); // java: 한글 한글자 2byte / 영문 한글자 1byte
        return new String(buf, 0, readCount-1); // 엔터값 2byte(이클립스) 1byte(인텔리제이)
    }
}

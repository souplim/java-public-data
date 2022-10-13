package exam_outputstream_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample1 {
    public static void main(String[] args) {
        OutputStream os = null; // 추상클래스 참조변수 = null
        try {
            os = new FileOutputStream("C://Temp/test.txt"); // 참조변수 = new 서브클래스 생성자();

//            // getBytes() 메서드는 문자열을 바이트 배열로 변환하여 반환하는 메서드
            // 1
//            byte[] data = "Java".getBytes();
//            for(int i=0; i<data.length; i++)
//                os.write(data[i]);

            // 2
//            byte[] data = "Hello! Java".getBytes();
//            os.write(data);

            // 3
//            byte[] data = "HelloWorld! Java".getBytes();
//            os.write(data, 1, 2); // write 배열의 값 중에서 첫번째 인덱스부터 2개의 길이만큼 저장

            // 4
            byte[] data = "God doesn't require us to succeed.\nhe only requires that you try.".getBytes();
            os.write(data);

            System.out.println("파일 생성되었습니다.");
        } catch (FileNotFoundException fnf){
            System.out.println("저장할 폴더가 생성되어 있지 않습니다.");
        } catch (IOException io){
            io.printStackTrace();
        } finally {
            try {
                if(os != null) { // 인스턴스 생성이 정상적으로 이루어지면 os는 null이 아니라 주솟값 가지게 됨
                    os.close();
                }
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

package exam_writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample1 {
    public static void main(String[] args) throws Exception {
        Writer writer = new FileWriter("test.txt");
        char[] data = {'A','B','C','D','E'};
//        char[] data = {'홍','길','동'};
//        char[] data = "오늘 하루도 최선을 다해~".toCharArray();

        //  1. write(int c) 메서드
        for(int i=0; i<data.length; i++) {
            writer.write(data[i]);
        }

        //  2. write(char[] cbuf) 메서드
//        writer.write(data);

        StringBuffer sb = new StringBuffer();
        sb.append("신은 우리가 성공할 것을 ");
        sb.append("요구하지 않는다. \n");
        sb.append("우리가 노력할 것을 요구할 ");
        sb.append("뿐이다. (마더 테레사)");

        // write(String str) 메서드
        writer.write(sb.toString());

        System.out.println("파일 출력 완료");
        writer.flush();
        writer.close();

    }
}

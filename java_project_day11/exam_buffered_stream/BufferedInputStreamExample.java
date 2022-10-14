package exam_buffered_stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExample {
    public static void main(String[] args)throws Exception {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        BufferedInputStream bis = null;
        long start = 0;
        long end = 0;

        fis1 = new FileInputStream("C:/ImageTest/page1.jpg");
        start = System.currentTimeMillis();
        while(fis1.read() != -1) { }
        end = System.currentTimeMillis();

        System.out.println("사용하지 않았을 때: "+(end-start)+"ms");
        fis1.close();

        fis2 = new FileInputStream("C:/ImageTest/page1.jpg");
        bis = new BufferedInputStream(fis2);

        start = System.currentTimeMillis();
        while(bis.read() != -1) { }
        end = System.currentTimeMillis();

        System.out.println("사용했을 때: "+(end-start)+"ms");
        bis.close();
        fis2.close();

    }
}

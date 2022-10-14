package exam_reader_read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadExample1 {
    public static void main(String[] args) throws Exception {
        // 1
//        Reader reader = new FileReader("test.txt");
//        int readData;
//        while(true){
//            readData = reader.read();
//            if(readData == -1) break;
//            System.out.print((char)readData);
//        }

        // 2
//        Reader reader = new FileReader("test.txt");
//        int readCharNo;
//        char[] cbuf = new char[2];
//        String data = "";
//
//        while(true){
//            readCharNo = reader.read(cbuf);
//            if(readCharNo == -1) break;
//            data += new String(cbuf, 0, readCharNo);
//        }
//        System.out.println(data);

        // 3. 문자를 읽어오고자 할 때 BufferedReader의 readLine() 메서드를 이용
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String str = null;
        while((str = reader.readLine()) != null)
            System.out.print(str);


        reader.close();
    }
}

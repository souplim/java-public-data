package exam_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesBookExample {
    public static void main(String[] args) {
        try {
            // 파일 읽기
            Path input = Paths.get("alphabet.txt"); // java.nio.file.Paths의 get()메서드

            byte[] bytes = Files.readAllBytes(input); // 파일을 바이트 배열로 읽음
            System.out.println("== readAllBytes ==");
            System.out.println(new String(bytes));

            // 파일 쓰기
            Path out1 = Paths.get("c.txt"); // Path 인터페이스 - 메서드로 객체 생성
            Files.write(out1, bytes);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

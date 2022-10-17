package exam_file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBookExample {
    public static void main(String[] args) {
        try {
            // 디렉터리 생성
            Path dir = Paths.get("c:", "work2","subDir"); // Path 객체 생성
            Files.createDirectories(dir); // 새로운 디렉토리 생성

            // 파일 생성
            Path file1 = Paths.get("c:\\work2\\file1.txt");
            Files.createFile(file1);

            // File을 Path로 변환
            File f1 = new File("c:\\work2\\file1.txt");
            Path p1 = f1.toPath();

            // Path를 File로 변환
            File f2 = file1.toFile();

            // 경로 조합은 고정된 루트 경로에 부분 경로를 추가하는 방법인데
            // 이는 공통부분은 두고 경로를 정의할 때 유용함. 이 때 resolve() 메서드를 사용하면 됨
            
        }

    }
}

package exam_printstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("file.txt"));

        ps.println("[프린터 보조 스트림]");
        ps.println("마치 ");
        ps.println("프린터가 출력하는 것처럼 ");
        ps.println("데이터를 출력합니다.");

        ps.printf("상품의 가격: %d원\n", 123);
        ps.printf("상품의 가격: %6d원\n", 123);
        ps.printf("상품의 가격: %-6d원\n", 123);
        ps.printf("상품의 가격: %06d원\n", 123);

        ps.printf("반지름이 %d인 원의 넓이: %10.2f\n", 10, Math.PI*10*10);

        ps.printf("%6d | %-10s | %10s\n", 1, "홍길동", "도적");

        ps.close();
    }
}

package exam_lambda;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> func = (s) -> {
            int cnt = 0;
            String[] word = s.split(" ");
            cnt = word.length;
            return cnt;
        };

        int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지 말고...");
        System.out.println(wordCnt);

    }
}

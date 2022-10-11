package example_collection;

import java.util.HashSet;

/* [요구사항] 전체 문자에서 중복된 단어를 검출하는 프로그램을 작성하여 보자.
 * 이 예제 HashSet을 이용하여 코딩해 보세요.
 * String[] sample = { "단어", "의미", "구절", "의미", "단락"};
 * [출력 결과]
 * 중복된 단어: 의미
 * 단어 수 : 4
 * 중복되지 않은 단어: [단락, 의미, 구절, 단어] */
public class FindDupplication {
    public static void main(String[] args) {
        String[] sample = { "단어", "의미", "구절", "의미", "단락"};

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<sample.length; i++){
            if(!set.add(sample[i]))
                System.out.println("중복된 단어: "+sample[i]);
        }

        System.out.println("단어 수: "+ set.size());
        System.out.println("중복되지 않은 단어: "+set);
    }
}

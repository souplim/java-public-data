package exam_api_stringtokenizer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 문자열을 처리하는 프로그램을 작성하여 보자.
 * (1) StringTokenizer 클래스를 이용하여서 사용자로부터 받은 문자열을 단어로 분리(, 공백)한다.
 * 분리된 단어와 단어의 개수를 출력한다.
 * (2) 단어들을 문자열 배열에 넣고 이 배열을 Arrays의 sort() 메소드를 이용하여 정렬한다.
 */
public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("아무 문장이나 입력하세요 : ");
        String word = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(word, ", ");
        int countTokens = st.countTokens();

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        System.out.println("분리된 단어의 개수: "+countTokens);

        String[] sArr = new String[countTokens];
        st = new StringTokenizer(word, ", ");
        int i=0;
        while(st.hasMoreTokens()){
            sArr[i++] = st.nextToken();
        }

        Arrays.sort(sArr); // 문자열의 경우 유니코드 기준으로 정렬됨
        System.out.println(Arrays.toString(sArr));
    }
}

package exam_api_stringbuffer;

import java.util.Scanner;

/* StringBuffer 클래스를 활용하여 명령처럼 문자열을 수정하라. (클래스명: WordReplace)
 * 아래 실행 예제에서 love!LOVE는 love를 찾아 LOVE로 수정하라는 명령이다. 첫번째 만난 문자열만 수정한다
 *
 * [실행예시]
 * 	>>우리는 love Java Programming.
	명령: 우리는!We
	We love Java Programming.
	명령: love!LOVE
	We LOVE Java Programming.
	명령: love!사랑
	찾을 수 없습니다!
	명령: !JAVA
	잘못된 명령입니다!
	명령: 종료
	종료합니다
 */
public class WordReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuffer sb = new StringBuffer("우리는 love Java Programming.");


        do{
            System.out.println(sb);
            System.out.print("명령: ");
            String input = scanner.nextLine().trim();

            if(input.equals("종료")){ // StringBuffer는 String과 다르게 equals() 메서드를 오버라이딩 하지 않아 주소비교함
                System.out.println("종료합니다");
                return;
            }

            if(!input.contains("!")){
                System.out.println("잘못된 명령입니다!");
                continue;
            }

            int idx = input.indexOf("!");
            String targetWord = input.substring(0,idx); // 변경할 단어
            String changingWord = input.substring(idx+1); // 변경 단어
            String sbToString = sb.toString();
            if(!sbToString.contains(targetWord))
                System.out.println("찾을 수 없습니다!");
            else if(targetWord=="" || changingWord==""){
                System.out.println("잘못된 명령입니다!");
                continue;
            } else{
                int idxChange = sb.indexOf(targetWord); // 변경할 단어의 시작 인덱스
                sb.replace(idxChange, idxChange+idx, input.substring(idx+1)); // 단어 치환
            }
        } while(true);
    }
}

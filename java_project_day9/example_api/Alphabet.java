package example_api;
/*[요구사항] 알파벳 대문자들 중 무작위로 추출하여 다음 [보기]와 같은 형식으로 출력해 보자!
 * 단) 반복문은 한번만 사용해야 한다.

[보기]
G  K  O  P  W
R  V  T  S  K
B  Z  Q  U  Y

 */
public class Alphabet {
    public static void main(String[] args) {
        // 1. 무작위 알파벳 대문자 15개 추출하여 stringbuffer에 추가
        // 2. 5개씩 잘라서 출력

        StringBuffer sb = new StringBuffer(30);

        for(int i=0; i<15; i++){
            // 65~90 -> 26개
            char ranEng = (char)((int)(Math.random()*26)+65);

            sb.append(ranEng).append(" ");
        }

        System.out.println(sb.substring(0,10));
        System.out.println(sb.substring(10,20));
        System.out.println(sb.substring(20,30));
    }
}

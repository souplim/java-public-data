package example;

// [요구사항] 문자열 "no news is good news"을 대상으로 반복하며 문자 'n'이 나타나는 횟수를 카운팅한다.
// 만약 현재의 문자가 'n'이 아니면 continue문에 의하여 루프의 나머지 부분을 생략하고 다음 문자를 처리한다.
// (참고) 문자의 길이는 문자열변수명.length()로 얻을 수 있으며
//        문자열변수명.charAt(0)을 사용하면 문자열변수명에 저장된 문자열의 첫번째 문자 하나(0)를 반환한다.
public class ContinueExample {
    public static void main(String[] args) {
        String news = "no news is good news";

        int count = 0;
        for(int i=0; i<news.length(); i++){
            if(news.charAt(i)=='n'){
                count++;
            } else{
                continue;
            }
        }
        System.out.println("n의 횟수 : "+ count);
    }
}
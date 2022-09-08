package exam_input;

import java.util.Scanner;

public class TwoNumberSum {
    public static void main(String[] args){
        // 메인 메서드에서부터 실행이 시작된다.
        Scanner scanner = new Scanner(System.in);
        int x, y; // 첫번째, 두번째 숫자 받기
        int sum; // 두 수의 합

        System.out.print("첫번째 숫자를 입력하시오. >");
        x = scanner.nextInt();

        System.out.print("두번째 숫자를 입력하시오. >");
        y = scanner.nextInt();

        sum = x+y;
        System.out.println("두 수의 합:"+sum);

        
        
        // 연습(String)
        System.out.print("첫번째 단어를 입력하시오. >");
        String word = scanner.nextLine();

        System.out.print("두번째 단어를 입력하시오. >");
        String word2 = scanner.nextLine();

        String word3 = word+word2;
        System.out.println("두 단어의 합:"+word3);

        scanner.close();
    }
}

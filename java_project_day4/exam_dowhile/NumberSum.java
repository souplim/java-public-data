package exam_while;

import java.util.Scanner;

// 사용자로부터 5개의 정수를 읽어서 합과 평균값을 계산하여 출력하는 프로그램을 작성하여라.
/* [출력 예시]
 * 1번째 수 입력: 1
 * 2번째 수 입력: 2
 * 5번째 수 입력: 5
 * 입력 받은 수
 * 합계: 15 평균: 3.0
 */
public class NumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3, num4, num5;

        int count = 0;
        int sum = 0;
        double avg = 0;
        while(count<5){
            System.out.print((count+1)+"번째 수 입력: ");
            sum += scanner.nextInt();
            count++;
        }

        avg = sum / count;

        System.out.printf("합계: %d 평균: %.1f",sum, avg);
    }
}
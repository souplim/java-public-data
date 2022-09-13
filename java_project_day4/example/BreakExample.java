package example;

import java.util.Scanner;

public class BreakExample {
    public static void main(String[] args){
        // [요구사항] 사용자가 입력한 점수의 총점, 평균을 내는 프로그램을 작성하시오.
        // 단, 종료는 0~100 사이가 아닌 값 입력하면 된다.
        Scanner scanner = new Scanner(System.in);
        int num;
        int sum = 0;
        int count = 0;
        float avg;

        do {
            System.out.print("점수를 입력하세요(종료는 0~100사이 아닌 값 입력) : ");
            num = scanner.nextInt();

            if(!(0<=num && num<=100)){
                break;
            }

            sum += num;
            avg = sum;
            count++;
        } while(true);

        avg = sum/count;
        System.out.println("sum ="+sum);
        System.out.println("avg ="+avg);
    }
}
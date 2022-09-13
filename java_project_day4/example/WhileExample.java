package example;

import java.util.Scanner;

public class WhileExample {
    public static void main(String[] args){
        // [요구사항] 1이 입력될 때까지 정수를 입력받아 그 수들의 합을 출력하는 프로그램을 작성하시오.
        Scanner scanner = new Scanner(System.in);
        int num=0;
        int sum=0;

        do {
            System.out.print("정수를 입력하시오 : ");
            num = scanner.nextInt();
            sum += num;
        } while(num!=1);

        System.out.println(sum);
    }
}

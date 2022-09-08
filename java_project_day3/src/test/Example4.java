package test;

import java.util.Scanner;

// 100부터 999까지의 숫자(3자리수)를 입력 받아 각 자리의 수를 합한 합계를 출력하는 프로그램을 작성하시오.
// 예시) 입력값: 123 출력값: 6
public class Example4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("100부터 999까지의 숫자(3자리수)를 입력해주세요. > ");
        int number = scanner.nextInt();

        if(!(100<=number&&number<=999)){
            System.out.println("100부터 999까지의 숫자(3자리수)를 입력해주셔야 합니다.");
        } else {
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += (number%10); // i=0 sum=0+999%10=9    i=1 sum=9+99%10=9+9   i=2 sum=9+9+9%1
                number /= 10; //       number=999/10=99      number=99/10=9
            }

            System.out.println("각 자리수 합계="+sum);
        }

    }
}

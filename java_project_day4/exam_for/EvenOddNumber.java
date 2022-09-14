package exam_for;

import java.util.Scanner;

// 두 수를 입력받아, 두 수 사이에 홀수의 합과 짝수의 합을 출력하는 프로그램을 작성하시오.
// 작성 완료 후 수의 크기에 상관없이 수행 가능해야 한다.
public class EvenOddNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num1, num2;
        int even=0, odd=0;

        System.out.println("두 수를 입력하시오 : ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        if(num1<=num2){
            for(int i=num1; i<=num2; i++){
                if(i%2==0){
                    even += i;
                } else {
                    odd += i;
                }
            }
        } else {
            for(int i=num2; i<=num1; i++) {
                if (i % 2 == 0) {
                    even += i;
                } else {
                    odd += i;
                }
            }
        }

        System.out.println("짝수의 합 : "+even);
        System.out.println("홀수의 합 : "+odd);

    }
}

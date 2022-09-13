package exam_if;

import java.util.Scanner;

// 3개의 정수를 입력 받아서 최대값 출력하도록 프로그램 작성해주세요.
public class MaximumFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        int max;
        System.out.print("3개의 정수를 입력해 주세요. : ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

       if(num1>num2){
           if(num1>num3){
               max = num1;
           } else {
               max = num3;
           }
       } else {
           if(num2>num3){
               max = num2;
           } else {
               max = num3;
           }
       }
       System.out.println("max="+max);
    }
}

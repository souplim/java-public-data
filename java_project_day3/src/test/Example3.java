package test;

import java.util.Scanner;

// 수량, 단가를 입력받아 금액(수량*단가)을 계산한 후, 25%를 할인하여, 원래 금액, 할인액, 지불금액을 출력하는 프로그램을 작성하시오.
public class Example3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("수량과 단가를 입력하세요. > ");
        int number = scanner.nextInt();
        int price = scanner.nextInt();

        double disPrice = price * 0.75;

        System.out.printf("원래 금액: %d 할인액: %.2f 지불금액 %f", price, disPrice, disPrice*number);
    }
}

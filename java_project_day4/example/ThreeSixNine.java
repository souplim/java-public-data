package example;

import java.util.Scanner;

// [요구사항 3] 369게임을 간단히 작성해보자
/* 1~99까지의 정수를 키보드로부터 입력받고 그 수가 범위에 속하지 않으면 "값의 범위를 초과하였습니다"라고 출력하고 종료한다.
 *  정수에 3, 6, 9중 하나가 있는 경우는 "박수짝"을 출력하고
 *                 두 개 있는 경우는 "박수짝짝"을 출력하는 프로그램을 작성하라.
 *  정수가 13인 경우 "박수짝", 36인 경우 "박수짝짝"을 출력하면 된다.*/
public class ThreeSixNine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number;
        System.out.print("1~99까지의 정수를 입력하세요 > ");
        number = scanner.nextInt();
        if(number<1 || 99<number){
            System.out.println("값의 범위를 초과하였습니다.");
            scanner.close();
            return;
        } else {
            if(number<10){
                if(number%3==0){
                    System.out.println("박수짝");
                }
            } else {
                if(((number/10)%3==0)&&((number%10)%3==0)){
                    System.out.println("박수짝짝");
                } else if(((number/10)%3==0)||((number%10)%3==0)){
                    System.out.println("박수짝");
                }
            }
        }
    }
}
package example;

import java.util.Scanner;

// [요구사항] 메뉴에 있는 연산자를 선택하고 피연산자 두 개를 입력받아 사칙연산을 하는 프로그램의 코드를 작성해라.
// [조건] 1. 메뉴에서 1~5사이가 아니면 다시 입력
//       2. 종료가 선택될 때까지 반복
//       3. 나눗셈의 결과는 소수 첫번째 자리까지로 표현
public class RepetitiveExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operator;
        int num1; int num2;
        int result=0;
        System.out.println("연산자를 1~4으로, 종료는 5를 선택해주세요.");

        while(true){
            System.out.println("1. +");
            System.out.println("2. -");
            System.out.println("3. *");
            System.out.println("4. /");
            System.out.println("5. 종료");
            System.out.print("선택>>");
            operator = scanner.nextInt();

            if(operator==1 || operator==2 || operator==3 || operator==4){
                System.out.print("사칙연산을 할 두 수를 입력하세요 : ");
                num1 = scanner.nextInt();
                num2 = scanner.nextInt();
                switch(operator){
                    case 1 :
                        result = num1 + num2;
                        break;
                    case 2 :
                        result = num1 - num2;
                        break;
                    case 3 :
                        result = num1 * num2;
                        break;
                    case 4 :
                        if(num2!=0){
                            result = num1 / num2;
                        } else{
                            System.out.println("0으로 나눌 수 없습니다.");
                        }
                    default :
                        System.out.println("1~5 사이의 숫자를 입력해주세요.");
                }
                System.out.printf("%d + %d = %d%n", num1, num2, result);
            } else if(operator==5){
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                return;
            } else {
                System.out.println("1~5 사이의 숫자를 입력해주세요.");
            }
        }
    }
}

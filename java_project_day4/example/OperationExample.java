package example;

import java.util.Scanner;

public class OperationExample {
    public static void main(String[] args) {
        // [요구사항 1] 간단한 계산기 프로그램을 작성하여보자.
        /* 먼저 사용자로부터 2개의 숫자를 입력받는다 이어서 사용자로부터 하나의 문자를 입력받는다.
        *  사용자로부터 받은 문자가 '+'이면 두 수의 덧셈을, '-'이면 뺄셈을, '*'이면 곱셈을, '/'이면 나눗셈을 수행하도록 작성하라.
        *  나눗셈의 경우, 분모가 0이 아닌지를 먼저 검사하여야 한다.
        *  참고) System.out.println("한 문자를 입력하세요 : ");
        *       char ch = input.next().charAt(0); */

        Scanner scanner = new Scanner(System.in);
        System.out.print("두 개의 숫자를 입력하세요 : ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.nextLine(); // 엔터를 뒤에서 문자열로 인식함을 방지하기 위함

        System.out.print("한 개의 문자(+,-,*,/)를 입력하세요 : ");
        char ch = scanner.next().charAt(0);

        int result = 0;
        if(ch=='+'){
            result = num1+num2;
        } else if(ch=='-'){
            result = num1-num2;
        } else if(ch=='*'){
            result = num1*num2;
        } else if(ch=='/'){
            if(num2!=0){
                result = num1/num2;
            } else {
                System.out.println("0으로 나눌 수 없습니다.");
                scanner.close();
                return; // 종료
            }
        } else {
            System.out.println("사칙연산이 아닙니다.");
            scanner.close();
            return; // 종료
        }
        System.out.printf("%d %c %d = %d\n", num1, ch, num2, result); // 출력코드 동일하므로 조건문 밖으로 빼는 게 더 효율적

        // [switch문으로 제어]
        result = 0;
        switch(ch){
            case '+' :
                result = num1+num2;
                break;
            case '-' :
                result = num1-num2;
                break;
            case '*' :
                result = num1*num2;
                break;
            case '/' :
                if(num2!=0){
                    result = num1/num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    scanner.close();
                    return; // 종료
                }
                break;
           default :
               System.out.println("사칙연산이 아닙니다.");
               scanner.close();
               return; // 종료
        }
        System.out.printf("%d %c %d = %d\n", num1, ch, num2, result); // 출력코드 동일하므로 조건문 밖으로 빼는 게 더 효율적
        scanner.close();
    }
}

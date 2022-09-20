package exam_class_static;

import java.util.Scanner;

public class StaticClassTest {
    private static Scanner scanner = new Scanner(System.in);
    private static int num1, num2;

    public static void main(String[] args) {
        numberInput();
        int sum = add(num1, num2);
        System.out.println("두 수의 합 : "+sum);
    }

    public static void numberInput(){
        System.out.print("첫번째 숫자를 입력해주세요 : ");
        num1 = scanner.nextInt();
        System.out.print("두번째 숫자를 입력해주세요 : ");
        num2 = scanner.nextInt();
    }

    public static int add(int x, int y){ return x+y; }
}

package example;

import java.util.Scanner;

public class Example {
    public static void prn() throws Exception {
        throw new Exception("예외가 발생!!");
    }
    public static void main(String[] args) {
        try {
            prn();
        } catch (Exception e) {
            System.out.print("예외가 발생되어 처리합니다. ");
            System.out.print(e);
        }


        try {
            int n = Integer.parseInt("3");
        } catch (NumberFormatException e){
            e.printStackTrace();
        }


        // 7
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        try {
            System.out.println("두 수의 나눗셈 결과 : "+num1/num2);
        } catch (ArithmeticException e){
            System.out.println("부적절한 나눗셈을 시도하였습니다.");
        }

        // 15
        try {
            int[] array=new int[-10];
            System.out.println("try");
        } catch (NumberFormatException e){
            System.out.println("숫자 형식 오류");
        } catch (NegativeArraySizeException e){
            System.out.println("배열 크기 음수 오류");
        } catch (Exception e){
            System.out.println("오류");
        } finally {
            System.out.println("처리 끝");
        }

    }
}

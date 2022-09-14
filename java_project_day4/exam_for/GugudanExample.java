package exam_for;

import java.util.Scanner;

// 사용자로 하여금 2단~9단 사이의 값을 입력받아 해당 구구단을 출력하는 프로그램을 작성하시오.
public class GugudanExample {
    public static void main(String[] args){
        int dan;

        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 단을 입력해주세요 : ");
        dan = scanner.nextInt();

        if(dan<2 || 9<dan){
            System.out.println("단은 2단에서부터 9단까지로 입력해주세요.");
        } else {
            for(int i=1; i<=9; i++){
                    System.out.printf("%d * %d = %d\n", dan, i, dan*i);
            }
        }
        scanner.close();
    }
}

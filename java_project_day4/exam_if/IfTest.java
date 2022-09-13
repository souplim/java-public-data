package exam_if;

import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
        int su1, su2, temp;
        Scanner scanner = new Scanner(System.in);
        System.out.print("두 수를 입력해 주세요 : ");
        su1 = scanner.nextInt();
        su2 = scanner.nextInt();

        if(su1 > su2){
            temp = su1;
            su1 = su2;
            su2 = temp;
        }
        System.out.print(su1 + " " + su2);
        scanner.close();

    }
}

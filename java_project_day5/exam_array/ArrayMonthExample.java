package exam_array;

import java.util.Scanner;

public class ArrayMonthExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int su = 0;

        do{
            System.out.print("원하는 달 : ");
            su = scanner.nextInt();
        } while(su<1 || 12<su);

        System.out.println(su+"월은 "+ month[su-1]+"일입니다.");
        scanner.close();

    }
}

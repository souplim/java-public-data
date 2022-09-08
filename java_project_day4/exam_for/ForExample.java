package exam_for;

import java.util.Scanner;

public class ForExample {
    public static void main(String[] args){
        // [실습1]
        for(int i=1; i<=5; i++){
            System.out.print(i+". ");
            System.out.print("Hello world!");
            System.out.println("I love Coding");
        }
        System.out.println();

        // [실습2] - 1부터 10까지의 합
        int sum = 0;
        for(int i=1; i<=10; i++){
            sum += i;
        }
        System.out.printf("1부터 10까지의 정수의 합 = %d\n", sum);
        System.out.println();

        // [실습3]
        int start, end;
        Scanner scanner = new Scanner(System.in);
        System.out.print("두개의 수를 입력해주세요. > ");
        start = scanner.nextInt();
        end = scanner.nextInt();

        for(int i=start; i<=end; i++){
            System.out.print(i +"");
        }

        scanner.close();
        System.out.println("\n");

        // [실습4]
        // for문을 이용해서 1부터 10까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성해보세요.
        sum = 0;
        for(int i=1; i<=10; i++){
            if(i%3==0){
                sum += i;
            }
        }
        System.out.println("3의 배수의 합 : "+sum);
        System.out.println();

    }
}

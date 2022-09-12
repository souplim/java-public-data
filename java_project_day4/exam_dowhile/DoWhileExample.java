package exam_dowhile;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        int num = 0;
        do {
            System.out.println("num의 값: "+ num);
            num++;
        } while(num<0); // while(false)일 때 do-while문 빠져나감

        System.out.println();

        // 1에서부터 10까지 출력
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while(i <= 10);

        System.out.println();

        // 10에서부터 1까지 출력
        i = 10;
        do {
            System.out.print(i + " ");
            i--;
        } while (i >= 1);

        System.out.println();

        // 1에서 100까지의 합을 출력해주세요.(do-while문을 이용하여)
        i = 1;
        int sum = 0;
        do{
            sum += i;
            i++;
        } while(i<=100);
        System.out.println("sum="+sum);

        System.out.println();

        // 사용자에게 문자 및 숫자를 입력 받아서 출력하고자 한다. 이때 종료는 q를 입력하면 된다.
        System.out. println("\n메시지를 입력하세요");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String inputString;

        do {
            System.out.print(">");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        } while(!inputString.equals("q"));

        System.out.println("프로그램 종료");

        System.out.println();

        // 학점 구하기(0~100사이로 점수를 입력하지 않으면 범위값으로 입력 받기 위해 다시 요구)
        int jumsu = 0;

        // do-while문 사용
        do {
            System.out.print("점수는 0~100 사이로 입력해주세요. > ");
            jumsu = scanner.nextInt();
        } while(!(0<=jumsu && jumsu<=100));

        char hakjum = '\0';

        if(jumsu>=90){
            hakjum = 'A';
        } else if(jumsu>=80){
            hakjum = 'B';
        } else if(jumsu>=70){
            hakjum = 'C';
        } else if(jumsu>=60){
            hakjum = 'D';
        } else {
            hakjum = 'F';
        }

        System.out.printf("점수는 %d 학점은 %c 입니다.", jumsu, hakjum);
    }
}

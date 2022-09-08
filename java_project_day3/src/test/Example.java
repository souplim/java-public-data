package test;

import java.util.Scanner;

public class Example {
    public static void main(String[] args){
        int kor;
        int eng;
        int math;
        int sum;
        float average;

        Scanner scanner = new Scanner(System.in);
//        System.out.print("국어 점수를 입력하세요. > ");
//        kor = scanner.nextInt();
//
//        System.out.print("영어 점수를 입력하세요. > ");
//        eng = scanner.nextInt();
//
//        System.out.print("수학 점수를 입력하세요. > ");
//        math = scanner.nextInt();

        // 점수 한 번에 받을 수 있다. 단, 공백으로 구분해야 함
        System.out.print("국어 영어 수학 점수를 입력하세요. > ");
        kor = scanner.nextInt();
        eng = scanner.nextInt();
        math = scanner.nextInt();


        sum = kor + eng + math;
        average = sum/3.0f;

        System.out.println("총점="+sum);
        System.out.println("평균="+average);

        System.out.printf("총점 : %d, 평균 : %.1f", sum, average);
    }
}
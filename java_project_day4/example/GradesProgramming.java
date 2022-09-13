package example;

import java.util.Scanner;

public class GradesProgramming {
    public static void main(String[] args){
        // [요구사항 2] 다음과 같은 조건으로 성적 처리 프로그램을 작성하시오.
        /* [조건] 1. 중간고사, 기말고사, 레포트, 출석 점수를 입력받아서 계산한다.
                 2. 성적은 아래에 준한 점수를 합산하되 소수 이하 2자리까지 출력하라.
                  1) (중간+기말)/2 -> 60%
                  2) 레포트 -> 20%
                  3) 출석 -> 20%

                 3. 학점의 기준(if ~ else if ~ else문 이용)
                  90이상 'A'학점 / 80이상 'B'학점 / 70이상 'C'학점 / 60이상 'D'학점 / 나머지 'F'학점
                 4. 평가기준(switch문 이용)
                  A,B학점 "excellent" / C,D학점 "good" / F학점 "poor"
                 5. 출력화면
                  중간고사 : 90
                  기말고사 : 89
                  레포트 : 99
                  출석점수 : 100

                  성적 : 93.50
                  학점 : A
                  평가 : excellent
        * */

        Scanner scanner = new Scanner(System.in);
        int midScore;
        int finalScore;
        int reportScore;
        int attendScore;

        float score;
        char grade;
        String assessment;

        System.out.print("중간고사, 기말고사, 레포트, 출석 점수를 입력해주세요 : ");
        midScore = scanner.nextInt();
        finalScore = scanner.nextInt();
        reportScore = scanner.nextInt();
        attendScore = scanner.nextInt();

        score = ((int)(((midScore+finalScore)/2*0.6f+reportScore*0.2f+attendScore*0.2f)*100))/100f;

        if(score>=90){
            grade = 'A';
        } else if(score>=80){
            grade = 'B';
        } else if(score>=70){
            grade = 'C';
        } else if(score>=60){
            grade = 'D';
        } else {
            grade = 'F';
        }

        switch(grade){
            case 'A' : case 'B' :
                assessment = "excellent";
            case 'C' : case 'D' :
                assessment = "good";
            default :
                assessment = "poor";
        }

        System.out.println("중간고사: "+midScore);
        System.out.println("기말고사: "+finalScore);
        System.out.println("레포트: "+reportScore);
        System.out.println("출석점수: "+attendScore);

        System.out.println();

        System.out.println("성적: "+score);
        System.out.println("학점: "+grade);
        System.out.println("평가: "+assessment);
    }
}

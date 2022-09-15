package example;

import java.util.Scanner;

// [요구사항2] 다음 코드와 같이 과목과 점수가 짝을 이루도록 2개의 배열을 작성하라.
/* 문자열(course 배열)에 다음과 같이 초기값을 가진다.
 * "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"
 * 그리고 그 과목에 대한 점수(score 배열)도 다음과 같이 초기값을 가진다.
 * 95, 88, 76, 62, 55
 *
 * 그리고 다음 예시와 같이 과목 이름을 입력받아 점수를 출력하는 프로그램을 작성하라.
 * "종료"를 입력받으면 종료한다.
 * if(문자열배열명[인덱스].equals(문자열변수) o */
public class ScoreArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] course = {"Java", "C++", "HTML5", "컴퓨터구조", "데이터베이스"};
        int[] score = {95, 88, 76, 62, 55};

        String courseName;

        System.out.println("[과목 정보]\nJava, C++, HTML5, 컴퓨터구조, 데이터베이스(종료는 종료를 입력하시오)");
        do{
            System.out.print("과목 이름>>");
            courseName = scanner.nextLine();

            if(courseName.equals("Java")||courseName.equals("C++")||courseName.equals("HTML5")||courseName.equals("컴퓨터구조")||courseName.equals("데이터베이스")){
                for(int i=0; i<course.length; i++){
                    if(courseName.equals(course[i])){
                        System.out.printf("%s의 점수는 %d\n", course[i], score[i]);
                    }
                }
            } else {
                System.out.println("없는 과목입니다.");
            }
        } while(!(courseName.equals("종료")));
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
        return;



    }
}

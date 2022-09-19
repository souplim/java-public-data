package exam_class_basic;

import java.util.Scanner;

import static exam_class_basic.MovieTest.scanner;

// 성적을 구현하는 Score 클래스를 정의하자.
/* [필드 구현] 이름/국어/영어/수학/총점을 저장하고자 한다. public
 * [메서드 구현] 필드에 값을 설정할 수 있는 기능, 점수들의 합을 구하는 기능, 평균을 구하는 기능,
 *             학점을 구하는 기능, 모든 필드를 출력할 수 있는 기능을 포함하도록 한다.
 * [출력 결과] 사용자로 하여금 이름 및 점수들을 입력받아 아래의 결과를 출력하도록 한다.
 * ====================
 * 이름  국어  영어  수학
 * ====================
 * 홍길동 90   75   61
 * 홍길동 50   56   46
 * 홍길동 90   90   90
 *
 * 그 후 총점과 평균과 학점을 출력하도록 코드를 수정한다
 * ===================================
 * 이름  국어  영어  수학  총점  평균  학점
 * ===================================
 * 홍길동 90   75   61   226   75.3  C
 * 홍길동 50   56   46   157   52.3  F
 * 홍길동 90   90   90   270   90.0  A
 */
class Score { //이름/국어/영어/수학/총점
    public String name;
    public int kor;
    public int eng;
    public int math;
    public int total;

    public void scoreData(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 총점을 필드에 구현하라는 요구가 있었기 때문에 return값 반환할 필요 없이 필드값에 대입만 해주면 됨!
    // 요구사항에 따라 필드값에 대입할 지, return값으로 반환할지를 결정
    public void getTotal(){
        total = kor+eng+math;
    }
    public double avg(){
        return total/3.0;
    }
    public char grade(){
        char hakjum = '\0'; // null을 의미 '0'줘버리면 48주는 것
        if(avg()>=90)
            hakjum = 'A';
        else if(avg()>=80)
            hakjum = 'B';
        else if(avg()>=70)
            hakjum = 'C';
        else if(avg()>=60)
            hakjum = 'D';
        else
            hakjum = 'F';

        return hakjum;
    }

    public String toString(){
        return String.format("%s\t%d\t%d\t%d\t %d\t %.1f\t%c", name, kor, eng, math, total, avg(), grade());
    }
}

public class ScoreTest {
    // 데이터를 입력받기 위한 아래의 inputData메서드 Q.Score 클래스안에 정의하지 않는 이유?
    // 이는 실행할 때 값을 어떻게 받기 위한 것이지 Score클래스의 주요 속성은 아님. 굳이 Score 클래스에 만들어서 메모리 줄 필요 없음
    public static void inputData(Score score){ // 매개변수 : 클래스명 참조변수 = 주소값
        // 필드에 직접 대입 Score score = s1
        System.out.print("이름 입력 : ");
        score.name = scanner.nextLine();

        System.out.print("국어 점수 입력 : ");
        score.kor = scanner.nextInt();

        System.out.print("영어 점수 입력 : ");
        score.eng = scanner.nextInt();

        System.out.print("수학 점수 입력 : ");
        score.math = scanner.nextInt();
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Score s1 = new Score();
//        s1.scoreData("홍길동", 90, 75, 61);
        inputData(s1); // 매개변수로 넣지 않는 이상 메인메서드 밖에서 객체 사용할 수 없다. 사용자에게 입력값을 받기 때문에 생긴 일
        s1.getTotal();

        Score s2 = new Score();
//        s2.scoreData("김철수", 55, 56, 46);
        inputData(s2);
        s2.getTotal();

        Score s3 = new Score();
//        s3.scoreData("이진희", 90, 90, 90);
        inputData(s3);
        s3.getTotal();

        System.out.println("===================================");
        System.out.println("이름  국어  영어  수학  총점  평균  학점");
        System.out.println("===================================");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}

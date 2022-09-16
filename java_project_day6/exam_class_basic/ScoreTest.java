package exam_class_basic;

import java.util.Scanner;

// 성적을 구현하는 Score 클래스를 정의하자.
/* [필드 구현] 이름/국어/영어/수학/총점을 저장하고자 한다.
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
    private String name;
    private int kor;
    private int eng;
    private int math;

//    Score(){ }
//    Score(String name, int kor, int eng, int math){
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.math = math;
//    }

    public void scoreData(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public int sum(){
        return kor+eng+math;
    }
    public double avg(){
        return (kor+eng+math)/3.0;
    }
    public char grade(){
        if(avg()>=90)
            return 'A';
        else if(avg()>=80)
            return 'B';
        else if(avg()>=70)
            return 'C';
        else if(avg()>=60)
            return 'D';
        else
            return 'F';
    }

    public String toString(){
        return String.format("%s\t%d\t%d\t%d\t %d\t %.1f\t%c", name, kor, eng, math, sum(), avg(), grade());
    }
}

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Score s1 = new Score();
        Score s2 = new Score();
        Score s3 = new Score();

        System.out.print("이름, 국어점수, 영어점수, 수학점수를 입력하시오 : ");
        String name1 = scanner.next();
        int kor1 = scanner.nextInt();
        int eng1 = scanner.nextInt();
        int math1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("이름, 국어점수, 영어점수, 수학점수를 입력하시오 : ");
        String name2 = scanner.next();
        int kor2 = scanner.nextInt();
        int eng2 = scanner.nextInt();
        int math2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("이름, 국어점수, 영어점수, 수학점수를 입력하시오 : ");
        String name3 = scanner.next();
        int kor3 = scanner.nextInt();
        int eng3 = scanner.nextInt();
        int math3 = scanner.nextInt();

        s1.scoreData(name1, kor1, eng1, math1);
        s2.scoreData(name2, kor2, eng2, math2);
        s3.scoreData(name3, kor3, eng3, math3);

//        s1.scoreData("홍길동", 90, 75, 61);
//        s2.scoreData("김철수", 55, 56, 46);
//        s3.scoreData("이진희", 90, 90, 90);

        System.out.println("===================================");
        System.out.println("이름  국어  영어  수학  총점  평균  학점");
        System.out.println("===================================");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}

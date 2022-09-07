import java.util.Scanner;

public class TotalScore {
    public static void main(String[] args){
        int kor;
        int eng;
        int math;
        int sum;
        float average;

        Scanner scanner = new Scanner(System.in);
        System.out.print("국어 점수를 입력하세요. > ");
        kor = scanner.nextInt();

        System.out.print("영어 점수를 입력하세요. > ");
        eng = scanner.nextInt();

        System.out.print("수학 점수를 입력하세요. > ");
        math = scanner.nextInt();

        sum = kor + eng + math;
        average = sum/3.0f;

        System.out.println("총점="+sum);
        System.out.println("평균="+average);
    }
}

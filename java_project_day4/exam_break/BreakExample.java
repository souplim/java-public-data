package exam_break;

import java.util.Scanner;

// 사용자가 입력한 점숭의 총점, 평균을 내는 프로그램을 작성하시오.
// 단 종료는 0~100 사이가 아닌 값 입력하면 된다.
public class BreakExample {
    public static void main(String[] args) {
        int total = 0, count = 0, score;

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("원하는 값을 입력해주세요 : ");
            score = scanner.nextInt();
            if(score<1 || 100<score){
                break;
            }
            total += score;
            count++;
        }
        if(count==0){
            System.out.println("평균을 구할 수 없습니다.");
        } else {
            System.out.printf("총점 : %d 평균 : %.2f\n", total, (float)total/count);
        }
        System.out.println("시스템이 종료되었습니다.");
        scanner.close();
    }
}

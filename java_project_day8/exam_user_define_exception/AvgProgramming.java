package exam_user_define_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 사용자로부터 국어, 영어, 수학 점수를 입력 받아서 평균을 계산하는 프로그램을 작성하여 보자.(AvgProgramming)
   만약 사용자가 음수를 입력하면 NegativeNumberException(사용자 정의 예외 클래스)을 발생한다.
        이 예외를 catch 블록으로 잡아서 처리하는 코드도 추가하라.
        또한 sum() 이라는 점수의 합을 반환 받도록 메서드를 정의하여 보자. */

// 사용자 정의 예외 클래스
@SuppressWarnings("serial")
class NegativeNumberException extends Exception{
    public NegativeNumberException(){
        super("음수는 입력할 수 없음");
    }
}

public class AvgProgramming {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tot = 0;

        try{
            tot = sum();
            System.out.printf("평균은 %.2f 입니다.\n", tot/3.0);
        } catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        } catch(InputMismatchException i){
            System.out.println("입력값이 잘못되었습니다.");
        } catch(Exception et){
            System.out.println("예외발생");
        } finally{
            scanner.close();
        }
    }

    public static int sum() throws NegativeNumberException {
        int score, tot = 0;
        String[] subject = {"국어", "영어", "수학"};

        for(int i=0; i<subject.length; i++){
            System.out.print(subject[i]+"점수 입력 : ");
            score = scanner.nextInt();

            if(score<0)
                throw new NegativeNumberException();
            tot = score;
        }
        return tot;
    }
}

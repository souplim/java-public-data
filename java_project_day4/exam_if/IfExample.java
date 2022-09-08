package exam_if;

import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // [예제1] 사용자로 하여금 숫자 하나를 입력받아 짝수와 홀수를 출력하는 코드를 작성해주세요.
//        int su = 0;
//        String even = ""; // 짝홀
//
//        System.out.print("짝수와 홀수를 구할 수를 입력해주세요. > ");
//        su = scanner.nextInt();
//
//        System.out.println("su의 초기값 : "+su);
//
//
//        if (su%2==0){
//            even = "짝수";
//        } else {
//            even = "홀수";
//        }
//        System.out.println("입력한 "+su+"는"+even+"입니다.");


        // [예제2] 사용자로 하여금 점수를 입력받아 학점을 출력하는 프로그램을 작성해주세요.
        // 작성 완료 후 점수가 0~100 사이로 입력하지 않았다면
        // "점수는 0과 100 사이로 입력해주셔야 합니다."라고 출력되도록 제어한다.

//        int jumsu = 0;
//        System.out.print("점수는 0~100 사이로 입력해주세요. > ");
//        jumsu = scanner.nextInt();
//
//        char hakjum = '\0';
//
//        // [제어1 방법]
//        if(!(0<=jumsu && jumsu<=100)){
//            System.out.println("점수는 0~100 사이로 입력해 주셔야 합니다.");
//        } else {
//            if(jumsu>=90){
//                hakjum = 'A';
//            } else if(jumsu>=80){
//                hakjum = 'B';
//            } else if(jumsu>=70){
//                hakjum = 'C';
//            } else if(jumsu>=60){
//                hakjum = 'D';
//            } else {
//                hakjum = 'F';
//            }
//            System.out.printf("점수는 %d 학점은 %c 입니다.", jumsu, hakjum);
//        }

        // [제어2 방법]
//        if(0<=jumsu && jumsu<=100){
//            if(jumsu>=90){
//                hakjum = 'A';
//            } else if(jumsu>=80){
//                hakjum = 'B';
//            } else if(jumsu>=70){
//                hakjum = 'C';
//            } else if(jumsu>=60){
//                hakjum = 'D';
//            } else {
//                hakjum = 'F';
//            }
//            System.out.printf("점수는 %d 학점은 %c 입니다.", jumsu, hakjum);
//
//        } else {
//            System.out.println("점수는 0~100 사이로 입력해 주셔야 합니다.");
//        }


        // [switch문으로 바꿔보기]
//        if(0<=jumsu && jumsu<=100){
//            switch(jumsu/10){ // 10으로 나누면 정수값 구해짐
//                case 10: case 9:
//                    hakjum = 'A';
//                case 8:
//                    hakjum = 'B';
//                case 7:
//                    hakjum = 'C';
//                case 6:
//                    hakjum = 'D';
//                default:
//                    hakjum = 'F';
//            }
//
//            System.out.printf("점수는 %d 학점은 %c 입니다.", jumsu, hakjum);
//        } else {
//            System.out.println("점수는 0~100 사이로 입력해 주셔야 합니다.");
//        }


        // 0~100사이의 점수가 아니면 다시 입력요청
        int jumsu = 0;
        System.out.print("점수는 0~100 사이로 입력해주세요. > ");
        jumsu = scanner.nextInt();

        while(!(0<=jumsu && jumsu<=100)){
            System.out.println("점수는 0~100 사이로 입력해 주셔야 합니다.");
            jumsu = scanner.nextInt();
        }

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

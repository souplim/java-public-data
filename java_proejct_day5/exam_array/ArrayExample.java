package exam_array;

import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        System.out.println("numbers[0] = " + numbers[0] );
        System.out.println("numbers[1] = " + numbers[1] );
        System.out.println("numbers[2] = " + numbers[2] );

        double[] arrayDouble = new double[2];
        for(int i=0; i<2; i++){
            System.out.println("arrayDouble["+i+"] = "+arrayDouble[i]);
        }
        System.out.println();

        String[] arrayString = new String[3];
        arrayString[0] = "java";
        arrayString[1] = "oracle";
        arrayString[2] = "spring";
        for(int i=0; i<arrayString.length; i++){
            System.out.println("arrayString["+i+"] = "+arrayString[i]);
        }
        System.out.println();

        /* 사용자로 하여금 5개의 정수를 입력받아 그 값을 출력하시오.(단 배열을 이용하여) */
        int[] nums = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("===배열의 값 입력===");
        for(int i=0; i<5; i++){
            System.out.print((i+1)+"번째 정수 입력 : ");
            nums[i] = scanner.nextInt();
        }

        System.out.println("===배열의 값 출력==="); // 첫번째 방법
        for(int i=0; i<5; i++){
            System.out.println("nums["+i+"] = "+nums[i]);
        }

        System.out.println("===배열의 값 출력==="); // 두번째 방법
        for(int value : nums){
            System.out.print(value + " ");
        }

        System.out.println();

        // 5명의 국어점수는 배열에 초기화하고 영어점수는 입력을 받아 배열에 저장하여 출력하는 프로그램을 작성하시오.
        int[] kor = new int[]{80, 95, 90, 85, 100}; // 배열초기화(국어점수)
        int[] eng = new int[5];

        for(int i=0; i<eng.length; i++){ // 입력값 배열저장(영어점수)
            System.out.println("영어 점수를 입력해주세요.");
            eng[i] = scanner.nextInt();
        }

        for(int i=0; i<eng.length; i++){ // 배열값 출력
            System.out.print("kor["+i+"] ="+kor[i]+", ");
            System.out.println("eng["+i+"] ="+eng[i]);
        }
        scanner.close();
    }
}

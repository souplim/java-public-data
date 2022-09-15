package exam_for;

import java.util.Scanner;

// 10개의 데이터를 입력받아 최소값, 최대값을 구하여 출력하는 코드를 작성하시오.
public class MaxMinExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = 10;
        int num;
        int min=0, max=0;


        for(int i=0; i<NUMBER; i++){
            System.out.print("10개의 수를 입력하세요 : ");
            num = scanner.nextInt();
            min = num;
            max = num;
            if(num<min){
                min = num;
            }
            if(num>max){
                max = num;
            }
        }

        System.out.println("최소값 : "+min);
        System.out.println("최대값 : "+max);





//        int count=0;
//        do {
//            System.out.print("10개의 수를 입력하세요 : ");
//            count++;
//        } while(count<10)
//
//
//
//        // 최소값 구하기
//        min = nums[0];
//        for(int i=1; i<10; i++){
//            if(nums[i]<min){
//                min = nums[i];
//            }
//        }
//
//        // 최대값 구하기
//        max = nums[0];
//        for(int i=1; i<10; i++){
//            if(nums[i]>max){
//                max = nums[i];
//            }
//        }


    }
}

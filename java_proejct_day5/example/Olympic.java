package example;

import java.util.Scanner;

/* 올림픽과 같은 국제 대회에서 심사위원들이 선수들에게 점수를 주고 평균을 구하는 과정을 살펴보면
 * 전체 심사위원들의 점수를 모두 합하는 것이 아니라 최대 점수와 최소점수를 제거한 나머지 점수의 평균으로
 * 최종점수를 확정하는 경우가 많다.
 * 아래와 같이 심사위원 5명의 점수를 입력 받아 최대와 최소 점수를 제거한 점수들의 평균(소수 2자리까지 출력)을
 * 구하는 프로그램을 작성하세요.
 */
public class Olympic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] score = new int[5];
        int tempNum;
        int count=0;

        int i = 0;
        do{
            System.out.print("점수를 입력해주세요 : ");
            tempNum = scanner.nextInt();
            if(!(0<= tempNum && tempNum <=100)){
                System.out.println("점수는 0~100 사이로 입력해주세요.");
            } else {
                while (i < score.length) {
                    score[i] = tempNum;
                    count++;
                    i++;
                    break;
                }
            }
        } while(count<score.length);

        System.out.println("-----총 입력된 점수들-----");
        for(int j=0; j<score.length; j++){
            System.out.println(score[j]+"점");
        }
        System.out.println("-----제거 대상 점수-----");
        int max = score[0];
        for(int j=1; j<score.length; j++){
            if(score[j]>max){
                max = score[j];
            }
        }

        int min = score[0];
        for(int j=1; j<score.length; j++){
            if(score[j]<min){
                min = score[j];
            }
        }
        System.out.println("최고 점수 : "+max);
        System.out.println("최고 점수 : "+min);

        System.out.println("-----최종 입력 점수-----");
        for(int j=0; j<score.length; j++){
            if(score[j]!=max && score[j]!=min){
                System.out.println(score[j]+"점");
            }
        }

        System.out.println("---------------------");
        int total = 0;
        float avg = 0;
        for(int j=0; j<score.length; j++){
            if(score[j]!=max && score[j]!=min){
                total += score[j];
            }
        }
        avg = ((int)(((float)total / (score.length - 2))*100+0.5))/100f;
        System.out.println("총점 : "+total);
        System.out.println("평균 : "+avg);
    }
}
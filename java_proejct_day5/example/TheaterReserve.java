package example;

import java.util.Scanner;

// 간단한 극장 예약 시스템을 작성해보자.
// 아주 작은 극장이라서 좌석이 10개 밖에 안 된다.
// 사용자가 예약을 하려고 하면 먼저 좌석 배치표를 보여준다.
// 즉 예약이 끝난 좌석은 1로, 예약이 안 된 좌석은 0으로 나타낸다.
public class TheaterReserve {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] seats = new int[SIZE];
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("-----------------------");
            for(int i=1; i<=SIZE; i++){ // 좌석번호
                System.out.print(i + " ");
            }
            System.out.println("\n-----------------------"); // escape 문자로 윗줄에 빈칸 넣기
            for(int i=0; i<seats.length; i++){ // 예약여부
                System.out.print(seats[i]+" ");
            }
            System.out.println("\n-----------------------");
            System.out.print("원하시는 좌석번호를 입력하세요(종료는-1) : ");

            int seat = scanner.nextInt();

            if(seat==-1){
                break;
            }

            if((seat-1)<0 || 10<(seat-1)){
                System.out.println("좌석 번호 선택이 잘못되었습니다.");
            } else {
                if(seats[(seat-1)]==0){
                    seats[(seat-1)] = 1;
                    System.out.println("예약되었습니다.");
                } else if(seats[(seat-1)]==1) {
                    System.out.println("이미 예약된 자리입니다.");
                }
            }
        } while(true);
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}

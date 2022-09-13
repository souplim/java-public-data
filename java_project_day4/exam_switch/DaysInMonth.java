package exam_switch;

import java.util.Scanner;

// 1년의 각 월의 일수를 출력하는 프로그램을 작성해보자.
// 즉 특정 월을 입력받아 그 월의 일수를 출력한다.
public class DaysInMonth {
    public static void main(String[] args) {
        int month;
        int year = 2022;
        int days = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("일수를 알고 싶은 월을 입력하시오 : ");
        month = scanner.nextInt();
        if(1<=month && month<=12){
            switch(month){
                case 1 : case 3 : case 5: case 7 : case 8 : case 10 : case 12 :
                    days = 31;
                    break;
                case 2 :
                    // 4의 배수이고 100의 배수가 아니거나 400의 배수이면 윤년
                    if(((year%4==0)&&!(year%100==0)) || (year%400==0)){
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;
                case 4 : case 6 : case 9: case 11 :
                    days = 30;
                    break;
                default :
                    System.out.println("월을 잘못 입력하셨습니다.");
            }
            System.out.printf("해당 %d월의 일수는 %d일입니다.\n", month, days);
        } else {
            System.out.println("월을 잘못 입력하셨습니다.");
        }

        // 위 소스를 if문으로 변경하면
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            days = 31;
        } else if(month==4 || month==6 || month==9 || month==11){
            days = 30;
        } else if(month==2){
            days = 28;
        } else {
            System.out.println("월을 잘못 입력하셨습니다.");
        }
        System.out.printf("해당 %d월의 일수는 %d일입니다.\n", month, days);

    }
}

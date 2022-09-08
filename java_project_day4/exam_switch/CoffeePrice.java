package exam_switch;

import java.util.Scanner;

public class CoffeePrice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("무슨 커피 드릴까요? > ");
        String order = scanner.next();
        int price =0;

        // [제어문 없음]
        switch(order){
            case "카푸치노" : case "카페라떼" :
                price = 3500;
                break;
            case "에스프레소" : case "아메리카노" :
                price = 2000;
                break;
            default :
                System.out.println("메뉴에 없습니다.");
        }

        if(price!=0) { // 정확한 메뉴가 들어왔을 때만 수행하기 위한 조건문
            System.out.print(order+"는 "+price+"원입니다.");
        }




        scanner.close();


    }
}

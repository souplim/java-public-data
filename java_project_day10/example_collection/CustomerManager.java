package example_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* [요구사항] 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성하라.
 * 프로그램은 고객이름과 포인트를 함께 저장 관리하는데, 포인트는 추가될 때마다 누적하여 저장된다.

[실행결과 예시]
  ** 포인트 관리 프로그램입니다 **
이름과 포인트 입력>> 김희수 40
(김희수,40)
이름과 포인트 입력>> 홍길동 50
(김희수,40)(홍길동,50)
이름과 포인트 입력>> 홍길동 60
(김희수,40)(홍길동,110)
이름과 포인트 입력>> 김남기 30
(김희수,40)(홍길동,110)(김남기,30)
이름과 포인트 입력>> 김희수 20
(김희수,60)(홍길동,110)(김남기,30)
이름과 포인트 입력>> 종료
*/
public class CustomerManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("**포인트 관리 프로그램입니다**");

        while(true){
            System.out.print("이름과 포인트 입력>>");
            String name = scanner.next();
            int point = scanner.nextInt();

            if("종료".equals(name)){
                break;
            } else if(map.containsKey(name)){
                map.replace(name, map.get(name)+point);
            } else {
                map.put(name, point);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.print("("+entry.getKey()+","+entry.getValue()+")");
            }
            System.out.println();
        }
        scanner.close();
    }
}

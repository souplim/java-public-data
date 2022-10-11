package example_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*[요구사항] 장기 자랑 프로그램에 사용될 수 있는 심사 위원들의 점수를 집계하는 프로그램을 작성하라.
 * 점수는 0.0에서 10.0까지 가능하다.
 * 10명의 점수 입력받아 그 중에서 최고 점수(Collections.max(리스트의 참조변수))와 최저 점수(Collections.min(리스트의 참조변수)) 는 제외된다.
 * Double 타입의 ArrayList를 사용하라.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = new ArrayList<>();

        // 심사위원이 열명 모두 정확하게 0~10 사이의 값이 들어왔다는 것이 전제된 코드
//        for(int i=0; i<10; i++){
//            System.out.print("심사위원의 점수 : ");
//            list.add(scanner.nextDouble());
//        }

        // 그렇지 않을 경우
        int i = 1;
        double value = 0.0;
        while(true){
            System.out.printf("(%d)번째 심사위원의 점수: ", i);
            value = scanner.nextDouble();
            if(value<0 || 10<value)
                continue;
            list.add(value);
            i++;
            if(i>10) break;
        }

        list.remove(Collections.max(list));
        list.remove(Collections.min(list));

        double total = 0;
        for(int j=0; j<list.size(); j++){
            total += list.get(j);
        }
        System.out.println("점수의 합 : "+total);
    }
}

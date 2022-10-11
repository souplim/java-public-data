package example_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* [요구사항] 1~100사이의 임의의 숫자 10개를 출력하고 오름차순(낮은 값에서 높은 값)으로 정렬하여 출력해 주세요. */
public class RandomList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        final int NUM = 10;

        for(int i=0; i<NUM; i++){
            list.add((int)(Math.random()*100)+1);
        }

        System.out.println("정렬 전 list 데이터");
        for(Integer number : list)
            System.out.print(number+" ");
        System.out.println();

        System.out.println("정렬 후 list 데이터");
        Collections.sort(list);
        for(Integer number : list)
            System.out.print(number+" ");
    }
}

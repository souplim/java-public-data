package example_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*[요구사항] 범죄, 112 / 화재, 119 / 전화번호, 114 데이터가 HashMap에 저장되어 있다.
 * 이 값(value)을 ArrayList 자료구조에 저장할 수 있도록 toArrayList() 메서드를 정의하고 main()에서 출력하도록 프로그램 작성해 주세요.*/
public class HashToArrayList {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("범죄", Integer.valueOf(112));
        map.put("화재", Integer.valueOf(119));
        map.put("전화번호", Integer.valueOf(114));

        System.out.println(toArrayList(map));
    }

    static ArrayList<Integer> toArrayList(Map<String, Integer> map){
        ArrayList<Integer> array = new ArrayList<>();

        for(Map.Entry<String, Integer> mp : map.entrySet()){
            array.add(mp.getValue());
        }

        return array;
    }
}

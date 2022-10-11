package exam_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample0 {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();

        // put(key, value) : 원소 추가
        dic.put("고진감래","고생 끝에 즐거움이 옴");
        dic.put("분골쇄신","몸이 부서질 정도로 노력을 다함");
        dic.put("권토중래","실패를 발판삼아 재기함");
        dic.put("교학상자","가르치고 배우면서 서로 성장함");
        // dic.put(null, null); // HashMap은 null값 저장 가능

        // get(key) : 특정 키의 value를 반환하는 메서드
        System.out.println(dic.get("고진감래"));
        System.out.println();

        System.out.println("총 Entry 수: "+dic.size());

        // 객체 삭제
        dic.remove("교학상자");
        System.out.println("총 Entry 수: "+dic.size());

        // {key=value, key=value...} 이렇게 출력됨. 간단하게 원소 확인. 내가 원하는 대로 출력할 수 없음
        System.out.println(dic.toString());
        System.out.println();

        // 방법 1 - 객체를 하나씩 처리
        Set<String> keySet = dic.keySet(); // keySet()은 모든 키를 Set 객체에 담아서 리턴
        Iterator<String> keys = keySet.iterator();
        while(keys.hasNext()){
            String key = keys.next(); // 반환 받아 온 key값은 String
            System.out.println(String.format("%s : %s", key, dic.get(key))); // key값 줘서 value 값 얻기
        }
        System.out.println();

        // 방법 2 - set은 향상for문으로 접근 가능
        for(String key : dic.keySet())
            System.out.println(String.format("%s : %s", key, dic.get(key)));
        System.out.println();

        // 방법 3 - 키와 값의 한 쌍으로 구성된 객체를 Set에 담아서 리턴
        // entrySet() 메서드는 키와 값의 한 쌍으로 구성된 객체(Map.Entry)를 Set에 담아서 리턴
        Set<Map.Entry<String, String>> entrySet = dic.entrySet();
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry = it.next(); // entry는 key와 value 다 가지고 있음
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" : "+value);
        }
        System.out.println();

        // 방법 4 - key와 value 따로 얻을 수 있어 2번보다 용이할 수도
        for(Map.Entry<String, String> elem : dic.entrySet())
            System.out.printf("%s : %s\n", elem.getKey(), elem.getValue());
    }
}

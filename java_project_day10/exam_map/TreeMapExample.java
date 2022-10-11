package exam_map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, String> users = new TreeMap<>();
        users.put("20080319", "김푸름");
        users.put("20070620", "김하늘");
        users.put("20050817", "오정수");
        users.put("20120728", "이영희");
        users.put("20120924", "홍길동");

        System.out.print("모든 사원 정보 : ");
        System.out.println(users);
        System.out.println();

        Map.Entry<String, String> entry = null;
        entry = users.firstEntry();
        print("입사일자가 가장 빠른 사람 ", entry);

        entry = users.lastEntry();
        print("입사일자가 가장 늦은 사람 ", entry);

        // lowerEntry()는 인자로 전달한 키값 바로 이전의 키값을 가진 Entry를 찾아서 반환한다.
        entry = users.lowerEntry("20121231");
        print("2012년도에 가장 늦게 입사한 사람 ", entry);

        // higherEntry()는 인자로 전달한 키값 바로 다음의 키값을 가진 Entry를 찾아서 반환한다.
        entry = users.higherEntry("20120101");
        print("2012년도에 가장 빨리 입사한 사람 ", entry);

        // pollFirstEntry()는 Map의 Entry 중 가장 작은 키값을 가진 Entry를 추출한 후 삭제한다.
        // pollLastEntry()는 가장 큰 키값을 가진 Entry를 추출한 후 삭제한다.
        while(!users.isEmpty()){
            entry = users.pollFirstEntry();
            print("퇴직한 사람", entry);
            System.out.println("남아있는 직원 수 : "+users.size());
        }
    }

    public static void print(String s, Map.Entry<String, String> entry){
        System.out.println(s+" : "+ entry.getKey()+" / "+entry.getValue());
        System.out.println();
    }
}
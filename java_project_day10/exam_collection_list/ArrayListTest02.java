package exam_collection_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest02 {
    public static void print(int n, List<String> list){
        System.out.println(n+" : "+list.toString());
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("서울");
        list.add("북경");
        list.add("상해");
        list.add("서울");
        list.add("도쿄");
        list.add("뉴욕");

        // ArrayList의 원소를 인덱스로 접근하고자 할 때
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));

        System.out.println("========================");

        list.add("런던");
        list.add("로마");
        list.add("방콕");
        list.add("북경");
        list.add("도쿄");
        list.add("서울");

        // 1 : [서울, 북경, 상해, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울]
        System.out.println("1 : "+list.toString());
        // 2 : [서울, LA, 북경, 상해, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울]
        list.add(1, "LA");
        print(2, list);
        // int indexOf(Object o) / int lastIndexOf(Object o)
        // 3 : 0
        // 4 : 12
        System.out.println("3 : "+list.indexOf("서울"));
        System.out.println("3 : "+list.lastIndexOf("서울"));
        // boolean remove(Object o)
        // 5 : [서울, 북경, 상해, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울]
        list.remove("LA");
        print(5, list);
        // E remove(int index)
        // 6 : [서울, 북경, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울] 상해 인덱스: 2
        list.remove(list.indexOf("상해"));
        print(6, list);
        // boolean contains(Object o)
        // 7 : false
        System.out.println("7 : "+list.contains("LA"));
        // Object[] toArray(): Object 타입의 배열 생성
        // 8 : [서울, 북경, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울]
        Object obj[] = list.toArray();
        System.out.println("8 : "+ Arrays.toString(obj));
        // <T> T
        // 9 : [서울, 북경, 서울, 도쿄, 뉴욕, 런던, 로마, 방콕, 북경, 도쿄, 서울]
        // 10 : []
        // 11 : true
        // 12 : [서울, 뉴욕, 상해]
        // 13 : [파리, 방콕, LA, 서울, 뉴욕, 상해]
        // 14 : false
        // 15 : [서울, 뉴욕, 상해]
        // 16 : []
    }
}

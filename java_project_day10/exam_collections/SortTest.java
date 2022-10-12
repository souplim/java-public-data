package exam_collections;

import java.util.*;

/* 클래스 : Fruit
 * 필드 :과일명(name), 가격(price)*/
class Fruit implements Comparable<Fruit> {
    private String name;
    private int price;

    Fruit(){ }
    Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getPrice(){ return price; }
    public void setPrice(int price){ this.price = price; }

    @Override
    public int compareTo(Fruit obj){
        int r = this.getPrice() - obj.getPrice();
        if(r>0) return 1;
        else if(r==0) return 0;
        else return -1;
    }

    @Override
    public String toString(){
        return name+"-"+price;
    }
}

public class SortTest {
    public static void main(String[] args) {
		/* 1. 객체배열을 선언하여 "포도"-3000, "수박"-20000, "딸기"-11900 저장한다.
           1-1. 객체 배열의 값에서 가격순으로 정렬하여 출력한다 (배열 오름차순 정렬) */
        Fruit[] f = { new Fruit("포도", 3000),
                      new Fruit("수박",20000),
                      new Fruit("딸기",11900)
        };

        Arrays.sort(f);
        System.out.println(Arrays.toString(f)); // 배열의 원소를 문자로 반환하는 메서드

        /* 2. 그 값을 리스트 타입으로 변환하여 Collections.sort()를 사용하여 정렬한 후 출력한다.  */
        List<Fruit> list = Arrays.asList(f);
        Collections.sort(list);
        System.out.println("오름차순 : "+list);

        Collections.reverse(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("내림차순 : "+list);

        /* 3. TreeSet에 저장하여 출력한다.*/
        TreeSet<Fruit> set = new TreeSet<>(list);
        System.out.println(set);

        Iterator<Fruit> it = set.iterator();
        while(it.hasNext()){
            Fruit fruit = it.next();
            System.out.println(fruit.getName()+":"+fruit.getPrice());
        }
    }
}

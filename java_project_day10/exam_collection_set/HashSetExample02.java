package exam_collection_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Key {
    private int number;

    public Key(int number){
        this.number = number;
    }

    @Override
    public boolean equals(Object obj){ // 부모클래스 참조변수 = 서브클래스 주솟값 -> 업캐스팅
        if(obj instanceof Key){
            Key compareKey = (Key)obj; // 서브클래스 참조변수 = (서브클래스)부모클래스 타입 참조변수; -> 다운캐스팅
            if(this.number == compareKey.number)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return number;
    }

    @Override
    public String toString(){
        return "number : "+number;
    }
}

public class HashSetExample02 {
    public static void main(String[] args) {
        // 인터페이스<타입인자> 참조변수 = new 구현클래스 생성자<>();
        Set<Key> set = new HashSet<>();

        set.add(new Key(1));
        set.add(new Key(13));
        set.add(new Key(1));
        set.add(new Key(35));
        set.add(new Key(3));

        int size = set.size();
        System.out.println("총 객체 수: "+size);

        Iterator<Key> it = set.iterator();
        while(it.hasNext()){
            Key k = it.next();
            System.out.println("\t"+k.toString());
//            System.out.println(it.next());
        }

    }
}

package exam_collection_set;

/* Member 클래스를 생성한다. 필드는 이름(name)과 나이(age)를 가지고 있다.
 * [요구사항]
 * 1. 나이가 같으면 동일 객체로 본다.
 * 2. 이름이 같으면 동일 객체로 본다.
 * 3. 이름과 나이가 같으면 동일 객체로 본다. */

import java.util.HashSet;
import java.util.Set;

class Member implements Comparable<Member>{
    private String name;
    private int age;

    Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
//        return "member - (name : "+name+", age : "+age+")";
        return String.format("member - (name : %s, age : %d)",name,age);
    }

    // 1. 나이 비교
//    @Override
//    public boolean equals(Object obj){
//        if (obj instanceof Member){
//            Member m = (Member)obj;
//            if(this.age == m.age)
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode(){
//        return age; // 동일객체로 바라볼 필드의 대상을 return하게 해주면 됨
//    }


    // 2. 이름 비교
//    @Override
//    public boolean equals(Object obj){
//        if (obj instanceof Member){
//            Member m = (Member)obj;
//            if(this.name.equals(m.name))
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode(){
//        return name.hashCode(); // String 클래스의 hashCode()
//    }

    // 3. 나이와 이름 비교
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Member){
            Member m = (Member)obj;
            if((this.age == m.age)&&(this.name.equals(m.name)))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return name.hashCode(); // String 클래스의 hashCode()
    }

    @Override
    public int compareTo(Member m){
        if(this.age>m.age) return 1;
        else if(this.age==m.age) return 0;
        else return -1;
    }

}

public class HashSetExample03 {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        set.add(new Member("홍길동", 50));
        set.add(new Member("홍길동", 46));
        set.add(new Member("김희진", 50));
        set.add(new Member("김철수", 36));

        System.out.println("총 객체수 : "+set.size());
        System.out.println("\t"+set);
    }
}

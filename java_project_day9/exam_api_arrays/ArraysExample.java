package exam_api_arrays;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Arrays;

class Member implements Comparable<Member> {
    private String name;
    private String address;
    private int age;

    public Member(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address = address; }
    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    @Override
    public int compareTo(Member o){
        if(this.age>o.age) return 1;
        else if(this.age==o.age) return 0;
        else return -1;
    }

    @Override
    public String toString(){
        return String.format("name=%s address=%s age=%d\n", name, address, age);
    }
}

public class ArraysExample {
    public static void main(String[] args) {
        int[] scores = {99,97,98};
        Arrays.sort(scores);
        for(int i=0; i<scores.length; i++)
            System.out.println("scores["+i+"]="+scores[i]);
        System.out.println();

        String[] names = {"홍길동","박동수","김민수"};
        Arrays.sort(names);
        for(int i=0; i<names.length; i++)
            System.out.println("names["+i+"]="+names[i]);
        System.out.println();

        Member m1 = new Member("홍길동","서울시 성동구 마장동",50);
        Member m2 = new Member("김철수","서울시 마포구 대흥동",35);
        Member m3 = new Member("홍길동","서울시 강남구 삼성동",20);
        Member[] members = {m1,m2,m3};

        // 나이 순으로 정렬해주세요
        Arrays.sort(members);
        for(int i=0; i<members.length; i++)
            System.out.print("members["+i+"]="+members[i]);
    }
}

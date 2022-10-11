package exam_collection_set;

import exam_collection_set.Member;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class Score implements Comparable<Score>{
    private int kor; // 국어점수
    private int math; // 수학점수

    public Score(int kor, int math){
        this.kor = kor;
        this.math = math;
    }

    public int getSum(){
        return kor + math;
    }

    @Override
    public int compareTo(Score obj){
        int r = this.getSum() - obj.getSum();
        if(r>0) return 1;
        else if(r==0) return 0;
        else return -1;
    }

    @Override
    public String toString(){
        return String.format("[Score - 국어:%d, 수학:%d, 총점:%3d]",kor, math, getSum());
    }
}

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(90);
        set.add(Integer.valueOf(75));
        set.add(Integer.valueOf(92));
        set.add(Integer.valueOf(50));

        System.out.println("Sorting(오름차순): "+set.toString());
        System.out.println("Sorting(내림차순): "+set.descendingSet());

        System.out.println("가장 낮은 점수: "+set.first());
        System.out.println("가장 높은 점수: "+set.last());
        System.out.println();

        // TreeSet 클래스는 NavigableSet<E> 인터페이스를 구현한 구현 클래스
        // NavigableSet<E> 인터페이스는 SortedSet<E> 인터페이스를 상속받은 인터페이스
        SortedSet<Member> mSet = new TreeSet<>();
        mSet.add(new Member("홍길동", 30));
        mSet.add(new Member("김철수", 34));
        mSet.add(new Member("이민수", 29));
        mSet.add(new Member("김희진", 45));
        mSet.add(new Member("홍길동", 30));

        System.out.println("Member Sorting: "+mSet); // Member 클래스에 Comparable 구현해야

        Iterator<Member> it = mSet.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        // Score 클래스는 국어, 수학 점수를 필드로 갖는 클래스로, 인스턴스 생성시 초기값 설정되도록 코딩
        // 국어와 수학 점수의 합을 기준으로 정렬
        TreeSet<Score> tSet = new TreeSet<>();
        tSet.add(new Score(21, 22));
        tSet.add(new Score(71, 78));
        tSet.add(new Score(11, 12));
        tSet.add(new Score(31, 32));

        System.out.println("\n반복자를 이용하여 출력 - 오름차순");
        Iterator<Score> tIter = tSet.iterator();
        while(tIter.hasNext())
            System.out.println(tIter.next());

        System.out.println("\n반복자를 이용하여 출력 - 내림차순");
        SortedSet<Score> sSet = tSet.descendingSet();
        Iterator<Score> sIter = sSet.iterator();
        while(sIter.hasNext())
            System.out.println(sIter.next());
    }
}

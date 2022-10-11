package exam_map;

import java.util.*;

class Student implements Comparable<Student> {
    private int sno; // 학번
    private String name; // 이름

    public Student(int sno, String name){
        this.sno = sno;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student s = (Student)obj;
            if((this.sno==s.sno) && (this.name.equals(s.name)))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return sno+name.hashCode();
    }

    @Override
    public String toString(){
        return "이름: "+name+" 학번: "+sno;
    }

    @Override
    public int compareTo(Student obj){ // Comparable-> 제네릭 인터페이스. 형변환 해줄 필요없음
        if(this.sno > obj.sno) return 1;
        else if(this.sno == obj.sno) return 0;
        else return -1;
    }
}

public class HashMapExample2 {
    public static void main(String[] args) {
        HashMap<String, Student> st = new HashMap<>();
        st.put("1", new Student(99030001, "홍길동"));
        st.put("2", new Student(99030002, "김도훈"));
        st.put("3", new Student(99030003, "윤도희"));

        System.out.println(st.toString());

        Set<String> keySet = st.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            String key = it.next();
            Student value = st.get(key);
            System.out.println("key="+key+", value="+value);
        }

        // 키와 값의 한 쌍으로 구성된 객체를 Set에 담아서 리턴
        for(Map.Entry<String, Student> s : st.entrySet()){
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println(key+" "+value);
        }

        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student(70010001, "홍길동"), 95);
        map.put(new Student(70010001, "홍길동"), 89);

        System.out.println("총 Entry 수: "+map.size());
        System.out.println(map);

        // (번호, Student 객체)를 저장하는 트리맵 생성
        TreeMap<String, Student> tMap = new TreeMap<>();
        tMap.put("1", new Student(94010001, "홍길동"));
        tMap.put("4", new Student(95020001, "김희진"));
        tMap.put("2", new Student(97010001, "윤도희"));
        tMap.put("3", new Student(99030003, "김철수"));
        System.out.println(tMap);

        TreeMap<Student, Integer> sMap = new TreeMap<>();
        sMap.put(new Student(97010001, "윤도희"), 89);
        sMap.put(new Student(95020001, "김희진"), 90);
        sMap.put(new Student(94010001, "홍길동"), 99);
        sMap.put(new Student(99030003, "김철수"), 79);

        for(Map.Entry<Student, Integer> sd : sMap.entrySet()){
            Student key = sd.getKey();
            Integer value = sd.getValue();
            System.out.println("key="+key+", value="+value);
        }
    }
}

package exam_generic_type;

import exam_non_generic_type.Apple;

class Box<T>{
    private T t;

    public void set(T t){ this.t = t; }
    public T get(){ return t; }
}

public class BoxExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        //box1.set(New String("hello);
        box1.set("hello");
        String str = box1.get(); // 형변환 필요없음
        System.out.println(str);

        // 정수 자료형으로 설정 후 6을 대입
        Box<Integer> box2 = new Box<Integer>();
//        box2.set(Integer.valueOf(6));  // 기초형 -> 참조형 : 박싱
        box2.set(6);
//        int value = box2.get().intValue(); 참조형 -> 기초형 : 언박싱
        int value = box2.get(); // 오토언박싱
        System.out.println(value);

        // 생성한 Apple 클래스를 설정 후 청색사과를 대입
        Box<Apple> box3 = new Box<Apple>();
        box3.set(new Apple("청색"));
        Apple app = box3.get();
        System.out.println(app);

        Box<Double> box4 = new Box<Double>();
//        box4.set(Double.valueOf(3.6));
        box4.set(3.6);
//        double data = box4.get().doubleValue();
        double data = box4.get();
        System.out.println(data);

        Box<Integer> box5 = new Box<Integer>();
        box5.set(5);
        System.out.println(box5.get());
    }
}

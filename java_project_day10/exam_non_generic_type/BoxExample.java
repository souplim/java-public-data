package exam_non_generic_type;

class Box{
    private Object data; // 어떤 타입도 다 대입가능한 최상위 클래스 타입으로 선언

    // 설정자
    public void set(Object data) { this.data = data; }
    // 접근자
    public Object get(){ return data; }
}

public class BoxExample {
    public static void main(String[] args) {
        Box box = new Box();

        box.set("홍길동"); // 객체 생성한 것
//        box.set(new String("홍길동"));
        String name = (String)box.get(); // 형변환 필요
        System.out.println("name = "+name);

        // Box에 정수형의 값(5) 대입 - 1
        // Integer iNum = Integer.valueOf(5); // 박싱
        // box.set(iNum);
        box.set(Integer.valueOf(5)); // box.set(5);
        Integer i = (Integer)box.get();
        System.out.println("i = "+i);
        System.out.println("i = "+i.intValue()); // 언박싱

        // Box에 정수형의 값(5) 대입 - 2
        box.set(5); // 오토박싱(기초형 -> 참조형)
        int iValue = (Integer)box.get(); // 오토언박싱(참조형 -> 기초형) // 확인하기 위해 int형으로 형변환 안 한 걸까
        System.out.println("iValue = "+iValue);

        // Box에 실수형의 값(8.4) 대입 - 1
        Double dNum = Double.valueOf(8.4);
        box.set(dNum);
        Double d = (Double)box.get();
        System.out.println("d = "+d.doubleValue());

        // Box에 실수형의 값(8.4) 대입 - 2
        // box.set(Double.valueOf(8.4);
        box.set(8.4);
        double dValue = (Double)box.get();
        System.out.println("dValue = "+dValue);

        Character ch = Character.valueOf('잠');
        box.set(ch);
        Character c = (Character)box.get();
        System.out.println("c = "+c.charValue());

        box.set('잠');
        char cValue = (Character)box.get();
        System.out.println("cValue = "+cValue);

        // color를 필드로 갖는 Apple 크래스 생성하여 Box클래스에 설정해보자
         Apple a = new Apple("빨간색");
         box.set(a);
        box.set(new Apple("빨간색"));
        Apple apple = (Apple)box.get();
        System.out.println(apple.toString());

        String str = "java";
        box.set(str);
        System.out.println("값: "+(Integer)box.get());
    }
}


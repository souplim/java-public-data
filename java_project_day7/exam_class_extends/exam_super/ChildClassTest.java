package exam_super;

class ParentClass { // 원래는 소스파일 하나 당 클래스 하나지만... 편의상
    protected int data; // 다른 패키지의 상속관계에 있는 클래스까지 접근 가능
    public ParentClass(){ data = 100; }

    public void print(){
        System.out.println("수퍼 클래스의 print() 메소드");
    }
}

class ChildClass extends ParentClass{
    protected int data; // 일부러 이름 동일하게 준 것
    public ChildClass(){ data = 200; } // 핃드명 동일할 때 누구를 우선시하는가?

    @Override
    public void print(){ // 메소드 재정의
        super.print();
        System.out.println("서브 클래스의 print() 메소드");
        System.out.println("data : "+data);
        System.out.println("this.data : "+this.data);
        System.out.println("super.data : "+super.data);
    }
}

public class ChildClassTest {
    public static void main(String[] args) {
        ChildClass obj = new ChildClass();
        obj.print(); // ChildClass의 재정의한 메소드 호출
    }
}

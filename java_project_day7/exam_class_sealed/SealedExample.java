package exam_class_sealed;

sealed class Person permits Employee, Manager{
    // 필드
    public String name;

    // 메소드
    public void work(){
        System.out.println("하는 일이 결정되지 않았습니다.");
    }
}

final class Employee extends Person{
    @Override
    public void work(){
        System.out.println("제품을 생산합니다.");
    }
}

public non-sealed class Manager extends Person{
    @Override
    public void work(){
        System.out.println("생산 관리를 합니다.");
    }
}

public class SealedExample {
    public static void main(String[] args){

    }
}

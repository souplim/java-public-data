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

non-sealed class Manager extends Person{
    @Override
    public void work(){
        System.out.println("생산 관리를 합니다.");
    }
}

class Director extends Manager{
    @Override
    public void work(){
        System.out.println("제품을 기획합니다.");
    }
}


public class SealedExample {
    public static void main(String[] args){
        Person p = new Person();
        Employee e = new Employee();
        Manager m = new Manager();
        Director d = new Director();

        p.work();
        e.work();
        m.work();
        d.work();

        // 위 내용을 객체배열로 정의
        Person[] p1 = {
                new Person(),
                new Employee(),
                new Manager(),
                new Director()
        };

        for(Person per : p1)
           per.work();
    }
}

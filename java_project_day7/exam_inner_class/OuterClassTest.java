package exam_inner_class;

class OuterClass {
    private String famous;
    public OuterClass(){
        famous = "할 수 있다는 믿음을 가지면 처음에는 그런 능력이 없을지라도 "
                +"결국에는 할 수 있는 능력을 확실히 갖게 된다. - 간디";
    }
//    public void outerMethod(){
//       InnerClass inner = new InnerClass();
//       inner.innerMethod();
//    }

    class InnerClass {
        private String wise;
        public InnerClass(){
            wise = "성공이라는 못을 박으려면 끈질김이라는 망치가 필요하다. - 존 메이슨";
        }
        public void innerMethod(){
            System.out.println("1. "+wise);
            System.out.println("2. "+famous);
        }
    }
}

public class OuterClassTest {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        // 외부 클래스명.내부 클래스명 참조변수명 = 외부 클래스의 객체명.new 내부클래스 생성자;
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.innerMethod();

//        OuterClass outer2 = new OuterClass();
//        outer2.outerMethod();
    }
}

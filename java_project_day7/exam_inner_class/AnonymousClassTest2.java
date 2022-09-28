package exam_inner_class;

abstract class AsInner{ // 추상클래스
    int x;
    int y;
    public AsInner(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void display(String data); // 추상메서드
}

class AsOuter{
    public void outerDisplay(AsInner obj){ // 매개변수로 추상클래스 받음 -> 추상클래스 상속한 클래스의 주소값 받아오겠다
        obj.display("Outer.display");
    }
}

class AsInnerExtend extends AsInner{
    public AsInnerExtend(int x, int y){
        super(x, y);
    }
    public void display(String data){
        System.out.println("display("+data+")"+x+" "+y);
    }
}

public class AnonymousClassTest2 {
    public static void main(String[] args){
//        AsInnerExtend as = new AsInnerExtend(10, 20); // AsInner 하위 클래스
//        AsOuter out = new AsOuter();
//        out.outerDisplay(as); // outerDisplay(AsInner obj) - 추상크래스를 상속받아 만든 서브클래스의 주소
        // 그러나 굳이 이렇게 만들 필요 없음. 익명 클래스로 대체 가능

        AsOuter out = new AsOuter();
        out.outerDisplay(new AsInner(10, 20){
            @Override
            public void display(String data){
                System.out.println("AsInner.display("+data+"):"+x+","+y);
            }
        });
    }
}

package exam_variable;

// 변수 2개를 선언하여 각각 변수에 값을 초기화 하여 두 수를 교환한 값을 출력하는 프로그램을 작성해보자
public class VariableExchangeExample {
    public static void main(String[] args){
        int x=10;
        int y=20;
        int tmp;

        tmp = x;
        x = y;
        y = tmp;

        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.printf("x:%d, y:%d", x,y);

    }
}

package exam_operation;

public class LogicalOperator {
    public static void main(String[] args){
        int x = 3;
        int y = 4;

        System.out.println((x==3) && (y==7)); // 논리곱 false
        System.out.println((x==3) || (y==4)); // 논리합 true

        boolean result = (++x==3) && (y++==7); // false 앞에 식이 거짓이니 뒤에 판단할 이유가 없음. 그래서 뒤에 식 실행 안 됨 x=4 y=4

        System.out.println(("x="+x+", y="+y)); // x==4, y==4
        System.out.println("result="+result); // false

        result = (x++==4) || (++y==7); // true 앞에 식이 참이니 뒤에 판단할 이유가 없음. 그래서 뒤에 식 실행 안 됨 x==5, y==4

        System.out.println(("x="+x+", y="+y)); //x==5, y==4
        System.out.println("result="+result); // true
    }
}

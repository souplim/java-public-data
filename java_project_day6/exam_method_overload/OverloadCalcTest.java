package exam_method_overload;

/* 메소드 오버로딩(Overloading)
 * - 클래스 내에 같은 이름으로 메소드를 여러개 선언하는 것
 * - 하나의 메소드 이름으로 다양한 매개값 받기 위해 메소드 오버로딩
 * - 오버로딩의 조건 : 매개변수의 타입, 개수 달라야 한다.
 */
class OverLoadCal {
    public int plus(int a, int b){
        System.out.println("plus(int a, int b)");
        return a+b;
    }

    public float plus(float a, float b){
        System.out.println("plus(float a, float b)");
        return a+b;
    }
    public double plus(double a, double b){
        System.out.println("plus(double a, double b)");
        return a+b;
    }
    public int plus(int ... a){ // 가변길이 메서드 호출
        System.out.println("plus(int ... a)");
        int sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    public int plusInt(int[] v){ // int[] v = values1
        System.out.println("plusInt(int[] v)");
        int sum = 0;
        for(int i=0; i<v.length; i++){
            sum += v[i];
        }
        return sum;
    }
}
public class OverloadCalcTest {
    public static void main(String[] args) {
        OverLoadCal over = new OverLoadCal();

        int i = over.plus(3, 5);
        System.out.println("int의 합 : "+i+"\n");

        float j = over.plus(1.5f, 3.2f);
        System.out.println("float의 합 : "+j+"\n");

        double k = over.plus(2.4, 4.5);
        System.out.println("double의 합 : "+k+"\n");

        int num = over.plus(5, 3, 8, 9, 2);
        System.out.println("\n가변 길이 메서드 호출에 의한 합 : "+ num);

        int[] values1 = {1, 2, 3};
        int result = over.plus(values1);
        System.out.println("\nint 배열을 매개변수로 갖는 메서드 호출에 의한 합(1) : "+ result);

        result = over.plusInt(new int[]{1, 2, 3, 4, 5});
        System.out.println("\nint 배열을 매개변수로 갖는 메서드 호출에 의한 합(2) : "+ result);
    }
}

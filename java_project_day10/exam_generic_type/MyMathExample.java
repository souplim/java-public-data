package exam_generic_type;

/*
 * 타입 매개 변수 T를 가지는 클래스 MyMath를 작성하여 보자.
 * MyMath에는 평균을 구하는 getAverage() 메소드를 추가하여 보자.
 * Integer나 Double과 같은 다양한 타입의 데이터에 대하여 평균을 구할 수 있도록 하라.
 */
class MyMath<T extends Number> {
    double v = 0.0;
    public double getAverage(T[] a){
        for(int i=0; i<a.length; i++)
            v = v + a[i].doubleValue();
        return v / a.length;
    }
}

public class MyMathExample {
    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5, 6};

        MyMath<Integer> m = new MyMath<>();
        System.out.println(m.getAverage(list));

        Double[] data = {6.9, 9.2, 5.3};
        MyMath<Double> m1 = new MyMath<>();
        System.out.println(m1.getAverage(data));

//        String[] value = {"1","4","9"};
//        MyMath<String> m2 = new MyMath<>();
    }
}

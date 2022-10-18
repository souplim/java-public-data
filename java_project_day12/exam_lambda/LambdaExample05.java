package exam_lambda;

interface MyFunction<T>{
    T modify(T data);
}

public class LambdaExample05 {
    public static void main(String[] args) {
        MyFunction<String> mf1 = (str) -> str.toUpperCase()+":"+str.length();
        System.out.println("결과값: "+mf1.modify("java"));
        System.out.println("결과값: "+mf1.modify("java programming"));

        MyFunction<Integer> mf2 = (n) -> n*2;
        System.out.println("결과값2: "+mf2.modify(22));
        System.out.println("결과값2: "+mf2.modify(43));

    }
}

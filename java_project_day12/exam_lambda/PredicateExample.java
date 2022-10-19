package exam_lambda;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> func = (n) -> n%2 == 0;
        if(func.test(123))
            System.out.println("짝수입니다.");
        else
            System.out.println("홀수입니다.");
    }
}

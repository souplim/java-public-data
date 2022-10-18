package exam_lambda;

interface NumberFunction {
    int sum(int n);
}

public class LambdaExample04 {
    public static void main(String[] args) {
        NumberFunction number = (n) -> {
            int result = 0;
            for(int i=1; i<=n; i++)
                result += i;
            return result;
        };

        System.out.println("1부터 10까지의 합: "+number.sum(10));
        System.out.println("1부터 100까지의 합: "+number.sum(100));


    }
}

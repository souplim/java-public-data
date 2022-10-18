package exam_lambda;

interface NumberFunction {
    int sum(int n);
}

public class LambdaExample04 {
    public static void main(String[] args) {
        NumberFunction number = new NumberFunction() {
            @Override
            public int sum(int n){
                int total = 0;
                for(int i=0; i<n; i++)
                    if(i%2 ==0)
                        total += i;
                return total;
            }
        };

        System.out.println("1부터 10까지의 짝수의 합 : "+ number.sum(10));

    }
}

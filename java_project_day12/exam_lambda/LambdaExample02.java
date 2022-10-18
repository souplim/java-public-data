package exam_lambda;

@FunctionalInterface
interface Verify {
    boolean check(int n);
}

public class LambdaExample02 {
    public static void main(String[] args) {
        Verify isEven = new Verify(){
            @Override
            public boolean check(int n){
                return  n%2==0;
            }
        };
        System.out.println(isEven.check(3));
    }
}

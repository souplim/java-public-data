package exam_lambda;

@FunctionalInterface
interface Verify2 {
    boolean check(int n, int d);
}

public class LambdaExample03 {
    public static void main(String[] args) {
        Verify2 vf = (n , d) -> (n%d==0);
        System.out.println(vf.check(24,3));

        Verify2 vff = new Verify2(){
            @Override
            public boolean check(int n, int d){
                return (n % d)==0;
            }
        };
        System.out.println(vff.check(24, 3));

    }
}

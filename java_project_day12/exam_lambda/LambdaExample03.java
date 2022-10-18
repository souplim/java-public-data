package exam_lambda;

interface Verify2 {
    boolean check(int n, int d);
}

public class LambdaExample03 {
    public static void main(String[] args){
        Verify2 vf = new Verify2(){
            @Override
            public boolean check(int n, int d){
                if(n % d == 0) return true;
                return false;
            }
        };
        System.out.println("결과값: "+vf.check(19, 4));


        vf = (n, d) -> (n % d)==0;
        System.out.println("결과값: "+vf.check(24, 3));

    }
}

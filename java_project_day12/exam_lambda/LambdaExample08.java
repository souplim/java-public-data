package exam_lambda;

interface Calculator {
    int func();
}

public class LambdaExample08 {
    static int num1 = 10;
    int num2 = 20;

    public static void main(String[] args) {
        LambdaExample08 test = new LambdaExample08();
        int num3 = 30;

        Calculator calc = () -> {
            int num4 = 40;
            LambdaExample08.num1++;
            test.num2++;
//            num3++;
            num4++;
            return num4;
        };
        System.out.println("실행결과: "+calc.func());

    }
}

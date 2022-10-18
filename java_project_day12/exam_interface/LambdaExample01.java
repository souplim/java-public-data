package exam_interface;

@FunctionalInterface
interface Multiply {
    double getValue();
}

public class LambdaExample01 {
    public static void main(String[] args) {
        Multiply m;
        m = new Multiply(){
            @Override
            public double getValue(){
                return 3 + 6;
            }
        };
        System.out.println(m.getValue());

        m = () -> 5.0 * 2;
        System.out.println(m.getValue());
        m = () -> 10 / 3;
        System.out.println(m.getValue());
    }
}

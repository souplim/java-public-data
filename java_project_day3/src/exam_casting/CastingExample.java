package exam_casting;

public class CastingExample {
    public static void main(String[] args) {
        int intValue = 65;
        System.out.println((char)intValue);

        long longValue = 500L;
        intValue = (int)longValue;
        System.out.println(intValue);

        double doubleValue = 3.14;
        intValue = (int)doubleValue;
        System.out.println(intValue);

        int result;
        double resultDouble;

        result = 3/2;
        System.out.println(result);

        resultDouble = 3/2;
        System.out.println(resultDouble);
        resultDouble = (double)3/2;
        System.out.println(resultDouble);

    }
}

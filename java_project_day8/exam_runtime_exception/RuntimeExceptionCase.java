package exam_runtime_exception;

public class RuntimeExceptionCase {
    public static void main(String[] args) {
        // RuntimeException 종류 - 비체크 예외
        // ArrayIndexOutOfBoundsException 예외 발생
        try {
            int[] arr = new int[3];
            arr[4] = 20;
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        // ClassCastException 예외 발생
        try {
            // 부모 클래스명 참조변수 = new 서브클래스생성자();
            Object x = Integer.valueOf(0);
            System.out.println((String)x);
        } catch(ClassCastException e){
            e.printStackTrace();
        }

        // NegativeArraySizeExceptoin 예외 발생
        try {
            int[] arr = new int[-10];
            System.out.println(arr.toString());
        } catch(NegativeArraySizeException e){
            e.printStackTrace();
        }

        // NullPointerException 예외 발생
        try {
            String data1 = "100";
            String data2 = "a100";

            int value1 = Integer.parseInt(data1); // -> 100
            int value2 = Integer.parseInt(data2); // -> X

            int result = value1 + value2;
            System.out.println(data1 + "+" + data2 +"="+result);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
}

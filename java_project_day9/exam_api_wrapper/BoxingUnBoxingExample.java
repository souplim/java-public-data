package exam_api_wrapper;

public class BoxingUnBoxingExample {
    public static void main(String[] args) {
        // Boxing
//         Integer obj1 = new Integer(100); // 현재 버젼에서는 생성자를 지원하지 않음
        Integer obj1 = Integer.valueOf(300); // 필요없는 박싱
//        Integer obj1 = Integer.valueOf("300"); // string -> Integer

        // Unboxing
        int value1 = obj1.intValue();
        System.out.println(value1);

        Double obj4 = Double.valueOf(3.8);
        double value4 = obj4.doubleValue();
        System.out.println(value4);
    }
}

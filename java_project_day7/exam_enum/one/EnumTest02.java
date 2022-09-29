package exam_enum.one;

enum Mandarin {
    금귤, 한라봉, 레드향, 천혜향, 황금향
}

public class EnumTest02 {
    public static void main(String[] args) {

        Mandarin ma = Mandarin.한라봉;
        System.out.println("이름 : "+ma.name()); // 열거형 상수의 name 반환
        System.out.println("위치 : "+ma.ordinal()); // 열거형 상수의 위치 반환
        // 인자로 전달된 상수르 기준으로 ma 변수가 가지는 상수의 위치 반환
        System.out.println("황금향과의 상대 위치 : "+ma.compareTo(Mandarin.황금향));

        Mandarin ma2 = Mandarin.레드향; // Mandarin.valueOf("레드향");
        System.out.println(ma2.toString());
        System.out.println();

        Mandarin list[] = Mandarin.values();
        System.out.println("== 귤의 종류 ==");
        for(Mandarin m : list)
            System.out.println(m.toString());
    }
}

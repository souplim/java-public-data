package exam_generic_type_book.generic_constructor;

class StringUtil {
    private String value;

    public <T extends CharSequence> StringUtil(T value) {
        this.value = value.toString();
    }

    public void printValue() {
        System.out.println("value: "+value);
    }
}

public class GenericConstructorTest {
    public static void main(String[] args) {
        String s = new String("서울");
        StringBuffer sbuf = new StringBuffer("대전");
        StringBuilder sbui = new StringBuilder("대구");

        StringUtil su1 = new StringUtil(s);
        StringUtil su2 = new StringUtil(sbuf);
        StringUtil su3 = new StringUtil(sbui);

        su1.printValue();
        su2.printValue();
        su3.printValue();
    }
}

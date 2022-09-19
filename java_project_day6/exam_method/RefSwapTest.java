package exam_method;

class RefSwap {
    public int x;

    public void change(RefSwap rs2){ // 매개변수 있는데 static 메서드가 아닌...?
        System.out.println("\nBefore Change x = " + rs2.x); // rs2.x = 10
        rs2.x = 200;
        System.out.println("\nAfter Change x = " + rs2.x); //  rs2.x = 200
    }
}

public class RefSwapTest {
    public static void main(String[] args) {
        RefSwap rs = new RefSwap();
        rs.x = 10;
        System.out.println("Main Before Calling x = " + rs.x); // rs.x = 10

        rs.change(rs);
        System.out.println("\nMain After Calling x = " + rs.x); // rs.x = 200
    }
}

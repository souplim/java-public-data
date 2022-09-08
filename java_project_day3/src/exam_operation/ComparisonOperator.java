package exam_operation;

public class ComparisonOperator {
    public static void main(String[] args){
        int x = 3;
        int y = 4;

        System.out.println("x==y"+(x==y)); // false
        System.out.println("x!=y"+(x!=y)); // true

        System.out.println("x>y"+(x>y)); // false
        System.out.println("x<y"+(x<y)); // true
        System.out.println("x<=y"+(x<=y)); // true

        char char1 = 'A';
        char char2 = 'B';
        Boolean result = (char1<char2); // true
        System.out.println("result="+result);
    }
}

package exam_switch;

public class SwitchCharExample {
    public static void main(String[] args) {
        char grade = 'B';

        switch(grade){
            case 'A':
            case 'a':
                System.out.println("우수 회원입니다.");
                break;
            case 'B':
            case 'b':
               System.out.println("일반 회원입니다.");
               break;
            default:
                System.out.println("손님입니다.");
        }

        /*Java 12 이후부터는 switch문에서 break문을 없애는 대신에 -> 화살표와 중괄호를 사용해 가독성이 좋아졌다. */
        grade = 'A';
        switch(grade){
            case 'A', 'a' -> {
                System.out.println("우수 회원입니다.");
            }
            case 'B', 'b' -> {
                System.out.println("일반 회원입니다.");
            }
            default -> {
                System.out.println("손님입니다.");
            }
        }

        switch(grade){
            case 'A', 'a' ->  System.out.println("우수 회원입니다.");
            case 'B', 'b' ->  System.out.println("일반 회원입니다.");
            default -> System.out.println("손님입니다.");
        }
    }
}

package exam_dowhile;

// do-while문을 이용하여 'a'부터 'z'까지 출력하는 프로그램을 작성하시오.
public class DoWhileExample2 {
    public static void main(String[] args) {
        char a = 'a';

        do{
            System.out.print(a+" ");
            a = (char)(a+1);
        } while(a<='z');
    }
}

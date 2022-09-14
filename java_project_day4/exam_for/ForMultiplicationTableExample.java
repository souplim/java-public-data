package exam_for;

/* [요구1] 2단부터 9단까지 출력하기
 * 2 * 1 = 2
 * 2 * 2 = 4
 */
/* [요구2] 또 다른 표현으로 2단부터 9단까지 출력하기
 * 2*1=2 3*1=3 4*1=4 ... 9*1=9
 * 2*2=4 3*2=6 ...       9*2=18
 */
public class ForMultiplicationTableExample {
    public static void main(String[] args) {
        // [요구1]
        for(int i=2; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.printf("%d * %d = %d\n",i,j,i*j);
            }
            System.out.println();
        }

        // [요구2]
        for(int i=1; i<10; i++){
            for(int j=2; j<10; j++){
                System.out.printf("%d * %d = %2d\t",j,i,j*i);
            }
            System.out.println();
        }


    }
}

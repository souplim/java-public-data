package exam_for;

public class ForOverlapExample {
    public static void main(String[] args) {
        // 결과 1 2 3 4 5
        for(int i=1; i<=5; i++){
            System.out.println(i+" ");
        }
        System.out.println();

        // 중첩반복문
        /* 결과
         * 1 2 3 4 5
         * 1 2 3 4 5
         * 1 2 3 4 5
         * 1 2 3 4 5
         * 1 2 3 4 5
         */
        System.out.println("\n중첩 반복문");
        for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();

        /* 결과
         * 1
         * 1 2
         * 1 2 3
         * 1 2 3 4
         * 1 2 3 4 5
         */
        System.out.println("\n중첩 반복문");
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();

        /* 결과
         * 1 2 3 4 5
         * 2 3 4 5 6
         * 3 4 5 6 7
         * 4 5 6 7 8
         * 5 6 7 8 9
         */
        System.out.println("\n중첩 반복문");
        for(int i=1; i<=5; i++){
            for(int j=i; j<=i+4; j++){
                System.out.print(j+" "); // 한 칸 띄어주기 위한 공백 부여
            }
            System.out.println();
        }
        System.out.println();
    }
}

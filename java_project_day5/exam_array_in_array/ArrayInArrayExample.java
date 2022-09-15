package exam_array_in_array;

public class ArrayInArrayExample {
    public static void main(String[] args) {
        // 2차원 배열
        // 자료형[][] 배열명 = new 자료형[행의 요소][열의 요소];
        int[][] arr1 = new int[2][3];

        System.out.println("arr1.length = "+arr1.length); // 배열의 행의 수
        System.out.println("arr1[0].length = "+arr1[0].length); // 0번째 행의 열의 수
        System.out.println("arr1[1].length = "+arr1[1].length); // 1번째 행의 열의 수
        System.out.println();

        for(int i=0; i<arr1.length; i++){ // 행의 요소
            for(int j=0; j<arr1[i].length; j++){ // 열의 요소
                System.out.print("arr1["+i+"]["+j+"]="+arr1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        int arr2[][] = new int[][]{{10, 20, 30},{40, 50, 60}};
        //int[][] arr2 = new int[][]{{10, 20, 30},{40, 50, 60}};
        /*  0열 1열 2열
         0행 10 20 30
         1행 40 50 60  */
        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arr2[i].length; j++){
                System.out.printf("%-5d", arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 2차원 배열(가변 배열)
        int[][] arr3 = new int[2][];
        arr3[0] = new int[]{1,5};
        arr3[1] = new int[3]; // 0값으로 초기화
        for(int i=0; i<arr3.length; i++){
            for(int j=0; j<arr3[i].length; j++){
                System.out.print("arr3["+i+"]["+j+"]="+arr3[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();

        // 5x5 2차원 배열에 1~25로 초기화하여 화면에 출력
        int[][] array = new int [5][5];
        // 배열 초기화
        for(int i=0, num=1; i<arr2.length; i++){
            for(int j=0; j<arr2[i].length; j++){
                arr2[i][j] = num++;
            }
        }

        // 2차원 배열 출력
        for(int i=0, num=1; i<arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%-5d", array[i][j]); // 변환문자에 숫자는 전체 자릿수를 의미
            }
            System.out.println();
        }
        System.out.println();

        // 합 구하기
        int sum = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(i==j){
                    sum += array[i][j];
                }
            }
        }
        System.out.println("sum = "+sum);
        System.out.println();

    }
}

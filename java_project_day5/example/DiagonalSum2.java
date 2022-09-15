package example;

// 5*5 이차원 배열의 가로, 세로, 대각선의 합 구하여 출력하는 코드를 작성하시오.
public class DiagonalSum2 {
    public static void main(String[] args){
        int[][] arr = { {10, 10, 10, 10, 0},
                        {30, 30, 30, 30, 0},
                        {40, 40, 40, 40, 0},
                        {50, 50, 50, 50, 0},
                        {0, 0, 0, 0, 0}};

        // [각 행의 합]
        for(int i=0; i<arr.length-1; i++) {
            for (int j = 0; j < arr[i].length-1; j++) {
                arr[i][4] += arr[i][j];
            }
        }


        // [대각선의 합]
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr[i].length-1; j++){
                if(i==j){
                    arr[4][4] += arr[i][j];
                }
            }
        }

        // [각 열의 합]
        for(int i=0; i<arr.length-1; i++) {
            for (int j = 0; j < arr[i].length-1; j++) {
                arr[4][j] += arr[i][j];
            }
        }

        // 이차원 배열 출력
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
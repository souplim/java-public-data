package example;

public class DiagonalSum {
    public static void main(String[] args){
        int[][] arr = { {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16 ,17 ,18 ,19, 20},
                        {21, 22, 23, 24, 25}};

        // 반복문을 이용하여 초기화하기
        int[][] arr2 = new int[5][5];
        for(int i=0, num=1; i<arr2.length; i++){
            for(int j=0; j<arr2[i].length; j++){
                arr2[i][j] = num++;
            }
        }

//        int[][] arr = new int[5][];
//        arr[0] = new int[]{1, 2, 3, 4, 5};

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(i==j){
                    sum += arr[i][j];
                }
            }
        }

        System.out.println("sum = "+sum);

        // [왼쪽 대각선 순환]
        int sum2 = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(i>=j){
                    sum2 += arr[i][j];
                }
            }
        }
        System.out.println("sum2 = "+sum2);
    }
}

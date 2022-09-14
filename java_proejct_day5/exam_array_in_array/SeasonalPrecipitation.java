package exam_array_in_array;

// 3년 동안의 계절별 강수량 데이터를 활용하여 연도별 강수량과 합계를 출력하는 프로그램을 작성해보자.
public class SeasonalPrecipitation {
    public static void main(String[] args){
        final int YEARS = 3; // 3년
        final int QUARTERS = 5; // 4계절+총합=5

        double[][] rainFall = {{368.1, 586.5, 351.2, 66.5, 0},
                            {173.9, 493.0, 448.4, 168.1, 0},
                            {172.8,  1012.4,  259.4, 46.7, 0}};

        for(int i=0; i<YEARS; i++){
            for(int j=0; j<QUARTERS-1; j++){
                rainFall[i][QUARTERS-1] += rainFall[i][j];
            }
        }

        String[] year = {"2018", "2019", "2020"};
        System.out.println("년도\t\t1분기\t2분기\t3분기\t4분기\t총합");
        System.out.println("----------------------------------------------");
        for(int i=0; i<YEARS; i++){
            System.out.print(year[i]+"년도\t");
            for(int j=0; j<QUARTERS; j++){
                System.out.printf("%.1f\t", rainFall[i][j]);
            }
            System.out.println();
        }
    }
}

package example;

// 공장에 있는 온도 센서에서 1시간마다 측정된 온도값에 따라 에어컨을 가동한다.
// 에어컨이 가동된 시간을 구하여 출력하는 코드이다. 빈칸을 채우시오.
// 참고) 1. 공장은 하루 8시간 가동한다.
//      2. 온도는 실시간으로 입력되지만, 여기서는 배열에 값을 저장해놓는 것으로 대신한다.
//      3. 온도가 30도가 넘으면 에어컨을 가동시킨다.
public class AirConditioner {
    public static void main(String[] args) {
        int degree[] = {28, 30, 29, 32, 31, 28, 29, 30};
        int airConditioner = 0;

        for(int i=0; i<degree.length; i++){
            if(degree[i]>30){
                airConditioner++;
            }
        }
        System.out.printf("에어컨은 총 %d시간 동안 가동되었다.\n", airConditioner);
    }
}

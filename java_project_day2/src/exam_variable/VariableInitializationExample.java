package exam_variable;

public class VariableInitializationExample {
    public static void main(String[] args){
        // 변수 선언과 동시에 초기값 설정. 10을 변수 value의 초기값으로 저장
        int value = 10;

        // 변수 value값을 읽고 10을 더하는 산술 연산을 수행
        // 연산의 결과값을 변수 result의 초기값으로 저장
        int result = value + 10;

        //  변수 result 값을 읽고 콘솔에 출력
        System.out.println("result="+result);
        // printf(format) 변수의 값을 출력하기 위해 변환문자(%)로 명시. 정수: %d 문자: %c 문자열: %s 실수: %f
        System.out.printf("result=%d", result);
    }
}

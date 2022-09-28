package exam_enum.one;

// 열거 상수를 가지고 있는 열거형 클래스 선언
enum Status {
    READY, SEND, COMPLETE, CLOSE // 열거 상수. 자동으로 public static final로 선언
}

public class EnumTest01 {
    public static void main(String[] args){
        // 열거형클래스 참조변수
        Status work = null;

        int n = 2;

        switch(n){
            case 1:
                work = Status.READY; // 클래스명. 상수 형태로 값을 저장
                break;
            case 2:
                work = Status.SEND;
                break;
            case 3:
                work = Status.COMPLETE;
                break;
            case 4:
                work = Status.CLOSE;
                break;
        }
        System.out.println("현재 작업 상태 : "+work); // 현재 작업 상태 : SEND
    }
}

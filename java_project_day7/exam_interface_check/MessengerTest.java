package exam_interface_check;

interface Messenger{
    public static final int MIN_SIZE = 1; // 최소문자수
    public static final int MAX_SIZE = 104857600; // 최대문자수

    public abstract String getMessage();
    public abstract void setMessage(String msg);

    public default void setLogin(boolean login){
        log();
        if(login)
            System.out.println("로그인 처리합니다.");
        else
            System.out.println("로그아웃 처리합니다.");
    }

    public static void getConnection(){
        System.out.println("network에 연결합니다.");
    }

    // 인터페이스 내에서만 쓰이는 private 메서드 정의
    private void log(){
        System.out.println("start job!");
    }
}

interface WorkFile{
    // 추상메서드. public abstract 생략 가능. 컴파일 시 자동 추가
    public abstract void fileUpload();
    public abstract void fileDownload();
}

class GalaxyMessenger implements Messenger, WorkFile{
    // Messenger 인터페이스 추상 메서드 오버라이딩
    @Override
    public String getMessage(){
        return "galaxy";
    }
    @Override
    public void setMessage(String msg){
        System.out.println("galaxy에서 메시지를 설정합니다 : "+msg);
    }

    // 일반 메서드
    @Override
    public void fileUpload() {
        System.out.println("file을 업로드합니다.");
    }

    @Override
    public void fileDownload() {
        System.out.println("file을 다운로드합니다.");
    }
}

class GraphicIOS{
    public void draw_textBok(){
        System.out.println("텍스트 상자를 그린다.");
    }
    public void draw_submitButton(){
        System.out.println("전송버튼을 그린다.");
    }
}

class IphoneMessenger extends GraphicIOS implements Messenger{
    @Override
    public String getMessage(){
        return "iPhone";
    }
    @Override
    public void setMessage(String msg){
        System.out.println("iPhone에서 메시지를 설정합니다 : "+msg);
    }

    public void clearMessage(){
        System.out.println("좌우로 흔들어 문자열을 지웁니다.");
    }
}

public class MessengerTest {
    public static void main(String[] args) {
        IphoneMessenger iphone = new IphoneMessenger();
        GalaxyMessenger galaxy = new GalaxyMessenger();


    }
}

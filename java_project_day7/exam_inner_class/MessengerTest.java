package exam_inner_class;

interface Messenger{
    public abstract String getMessage();
    public abstract void setMessage(String msg);
}

public class MessengerTest {
    public static void main(String[] args) {
        // 익명 클래스
        Messenger test = new Messenger() {
            @Override
            public String getMessage(){
                return "점심 식사 맛있게 드세요~~";
            }
            @Override
            public void setMessage(String msg){
                System.out.println("test에서 메시지를 설정합니다 : "+msg);
            }
        };
        System.out.println(test.getMessage());
        test.setMessage("have a nice day~~!");
    }
}

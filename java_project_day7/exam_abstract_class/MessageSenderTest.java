package exam_abstract_class;

abstract class MessageSender{
    String title;
    String senderName;

    public abstract void sendMessage();
}

class EMailSender extends MessageSender{
    String senderAddr;
    String emailBody;

    public void sendMessage(){
        System.out.println("제목: "+title+"\n보내는 사람: "+senderName+" "+senderAddr+"\n받는 사람: javaone@naver.com\n내용: "+emailBody);
    }
}

class SMSSender extends MessageSender {
    String returnPhoneNo;
    String message;

    public void sendMessage(){
        System.out.println("제목: "+title+"\n보내는 사람: "+senderName+"\n전화번호: 010-000-0000\n회신 전화번호: "+returnPhoneNo+"\n메시지 내용: "+message);
    }
}
public class MessageSenderTest {
    public static void main(String[] args) {
        EMailSender e = new EMailSender();
        SMSSender s = new SMSSender();

        e.title = "생일을 축하합니다.";
        e.senderName = "고객센터";
        e.senderAddr = "admin@dukeeshop.co.kr";
        e.emailBody = "10% 할인쿠폰이 발행되었습니다.";

        s.title = "생일을 축하합니다.";
        s.senderName = "고객센터";
        s.returnPhoneNo = "02-000-0000";
        s.message = "10% 할인쿠폰이 발행되었습니다.";

        System.out.println("-------------------------------");
        e.sendMessage();
        System.out.println("-------------------------------");
        s.sendMessage();

    }
}

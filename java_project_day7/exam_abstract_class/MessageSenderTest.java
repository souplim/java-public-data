package exam_abstract_class;

abstract class MessageSender{
    String title;
    String senderName;

    public abstract void sendMessage(String parameter);
}

class EMailSender extends MessageSender{
    String senderAddr;
    String emailBody;

    public EMailSender(){ }
    public EMailSender(String title, String senderName, String senderAddr, String emailBody){
        this.title = title;
        this.senderName = senderName;
        this.senderAddr = senderAddr;
        this.emailBody = emailBody;
    }

    @Override
    public void sendMessage(String receiverAddr){
        System.out.println("제목: "+title+"\n보내는 사람: "+senderName+" "+senderAddr+"\n받는 사람: "+receiverAddr+"\n내용: "+emailBody);
    }
}

class SMSSender extends MessageSender {
    String returnPhoneNo;
    String message;

    public SMSSender(){ }
    public SMSSender(String title, String senderName, String returnPhoneNo, String message){
        this.title = title;
        this.senderName = senderName;
        this.returnPhoneNo = returnPhoneNo;
        this.message = message;
    }

    @Override
    public void sendMessage(String phoneNo){
        System.out.println("제목: "+title+"\n보내는 사람: "+senderName+"\n전화번호: "+phoneNo+"\n회신 전화번호: "+returnPhoneNo+"\n메시지 내용: "+message);
    }
}
public class MessageSenderTest {
    public static void main(String[] args) {
        EMailSender e = new EMailSender("생일을 축하합니다.", "고객센터", "admin@dukeeshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
        SMSSender s = new SMSSender("생일을 축하합니다.", "고객센터", "02-000-0000", "10% 할인쿠폰이 발행되었습니다.");

        System.out.println("-------------------------------");
        e.sendMessage("javaone@naver.com");
        System.out.println("-------------------------------");
        s.sendMessage("010-000-0000");
    }
}

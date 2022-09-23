package exam_abstract_class;

abstract class MessageSender{
    private String title;
    private String senderName;

    MessageSender(String title, String senderName){
        this.title = title;
        this.senderName = senderName;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public abstract void sendMessage(String recipient);
}

class EMailSender extends MessageSender{
    private String senderAddr;
    private String emailBody;

    public String getSenderAddr() { return senderAddr; }
    public void setSenderAddr(String senderAddr) { this.senderAddr = senderAddr; }
    public String getEmailBody() { return emailBody; }
    public void setEmailBody(String emailBody) { this.emailBody = emailBody; }

    public EMailSender(String title, String senderName, String senderAddr, String emailBody){
        super(title, senderName); // 부모 클래스의 생성자 호출
        this.senderAddr = senderAddr;
        this.emailBody = emailBody;
    }

    @Override
    public void sendMessage(String recipient){
        System.out.println("제목: "+getTitle()+"\n보내는 사람: "+getSenderName()+getSenderAddr()+"\n받는 사람: "+recipient+"\n내용: "+getEmailBody());
    }
}

class SMSSender extends MessageSender {
    private String returnPhoneNo;
    private String message;

    public SMSSender(String title, String senderName, String returnPhoneNo, String message){
        super(title, senderName);
        this.returnPhoneNo = returnPhoneNo;
        this.message = message;
    }

    public String getReturnPhoneNo() { return returnPhoneNo; }
    public void setReturnPhoneNo(String returnPhoneNo) { this.returnPhoneNo = returnPhoneNo; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public void sendMessage(String recipient){
        System.out.println("제목: "+getTitle()+"\n보내는 사람: "+getSenderName()+"\n전화번호: "+recipient+"\n회신 전화번호: "+getReturnPhoneNo()+"\n메시지 내용: "+getMessage());
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

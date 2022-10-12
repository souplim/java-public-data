package exam_queue;

import java.util.LinkedList;
import java.util.Queue;

class Message {
    private String command;
    private String to;

    public Message(String command, String to){
        this.command = command;
        this.to = to;
    }

    public String getCommand(){ return command; }
    public void setCommand(String command){ this.command = command; }
    public String getTo(){ return to; }
    public void setTo(String to){ this.to = to; }
}

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail","홍길동"));
        messageQueue.offer(new Message("sendSMS","김철수"));
        messageQueue.offer(new Message("sendKakaotalk","조미진"));

        while(!messageQueue.isEmpty()){
            Message message = messageQueue.poll();

            switch(message.getCommand()){
                case "sendMail" :
                    System.out.println(message.getTo()+"님에게 메일을 보냅니다.");
                    break;
                case "sendSMS" :
                    System.out.println(message.getTo()+"님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaotalk" :
                    System.out.println(message.getTo()+"님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}

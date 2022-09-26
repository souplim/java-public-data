package exam_interface;

import java.rmi.Remote;

interface RemoteControl {
    // 상수
    public static final int MAX_VOLUME = 32;
    /*public static final*/ int MIN_VOLUME = 0;

    // 추상메서드
    public abstract void turnOn();
    public abstract void turnOff();
    void setVolume(int volume);

    // 디폴트 메서드. 자동으로 상속되기 때문에 따로 구현할 필요 없음
    public default void setMute(boolean mute){
        if(mute){
            System.out.println("무음 처리합니다.");
        } else {
            System.out.println("무음 해제합니다.");
        }
    }

    // static 메서드. 자동으로 상속되기 때문에 따로 구현할 필요 없음
    public static void changeBattery(){
        System.out.println("건전지를 교환합니다.");
    }
}

// 접근제어자 class 구현클래스 implements 인터페이스명 { }
class Television implements RemoteControl{
    private int volume;
    private int channel;

    @Override
    public void turnOn(){
        // 실제로 TV의 전원을 켜기 위한 코드 작성
        System.out.println("TV 켜기");
    }

    @Override
    public void turnOff(){
        // 실제로 TV의 전원을 켜기 위한 코드 작성
        System.out.println("TV 끄기");
    }

    @Override
    public void setVolume(int volume){
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;
    }

    public void printChannel(){
        System.out.println("현재 채널 선택은 "+channel+"번 입니다.");
    }

    public String toString(){
        return "현재 TV 볼륨: "+ volume;
    }
}

class Radio implements RemoteControl{
    private int volume;
    private String standard;
    private double radioFrequency; // 주파수

    public Radio(String standard, double radioFrequency){
        this.standard = standard;
        this.radioFrequency = radioFrequency;
    }

    @Override
    public void turnOn(){
        System.out.println("Radio 켜기");
    }

    @Override
    public void turnOff(){
        System.out.println("Radio 끄기");
    }

    @Override
    public void setVolume(int volume){
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;
    }

    public void printRF(){
        System.out.println("현재 주파수 선택은 "+standard+" "+radioFrequency+"MHz(KHz) 입니다.");
    }

    @Override
    public String toString(){
        return "현재 Radio 볼륨:"+volume;
    }
}

interface Searchable{
    public abstract void search(String url);
}

class SmartTelevision implements RemoteControl, Searchable{
    private int volume;

    @Override
    public void turnOn(){
        System.out.println("SmartTelevision 켜기");
    }

    @Override
    public void turnOff(){
        System.out.println("SmartTelevision 끄기");
    }

    @Override
    public void setVolume(int volume){
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;
    }

    @Override
    public void search(String url){
        System.out.println(url +"을(를) 검색합니다.");
    }

    @Override
    public String toString(){
        return "현재 TV 볼륨: "+volume;
    }
}

public class TelevisionTest {
    public static void main(String[] args){
        Television tv = new Television();
        RemoteControl.changeBattery(); // 인터페이스명.static메서드()
        tv.turnOn();
        tv.setVolume(20);
        System.out.println(tv.toString());
        tv.setMute(true); // 디폴트 메서드 호출
        tv.turnOff();
        System.out.println();

        Radio r = new Radio("세상의 모든 음악", 93.1);
        r.turnOn();
        r.printRF();
        r.turnOff();
        System.out.println();

        SmartTelevision st = new SmartTelevision();
        st.turnOn();
        st.setVolume(10);
        st.setVolume(50);
        System.out.println(st);
        st.search("http://www.naver.com(네이버)");
        st.turnOff();
    }
}
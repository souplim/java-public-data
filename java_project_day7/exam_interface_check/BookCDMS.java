package exam_interface_check;

import java.util.Arrays;

interface Lendable{
    public abstract void checkOut(String borrower, String checkOutDate);
    public abstract void checkIn();
}

class SeparateVolume implements Lendable{
    private int requestNo; // 청구번호
    private String bookTitle; // 제목
    private String writer; // 저자
    private String borrower; // 대출인
    private String checkOutDate; // 대출일
    private String state; // 대출상태

    public SeparateVolume(String bookTitle, String writer){
        this.bookTitle = bookTitle;
        this.writer = writer;
    }
    public void checkOut(String borrower, String checkOutDate){
        System.out.println("*"+bookTitle+"("+writer+") 이(가) 대출되었습니다.");
        System.out.println("대출인 : "+borrower);
        System.out.println("대출일 : "+checkOutDate);
        System.out.println();
    }
    public void checkIn(){
        System.out.println("*"+bookTitle+" 이(가) 반납되었습니다.");
        System.out.println();
    }
}

class CDInfo{
    protected int registerNo;
    protected String title;
}

class AppCDInfo extends CDInfo implements Lendable{
    private String borrower; // 대출인
    private int checkOutDate; // 대출일
    private String state; // 대출상태

    public AppCDInfo(String title){
        this.title = title;
    }

    public void checkOut(String borrower, String checkOutDate){
        System.out.println("*"+title+"가 대출되었습니다.");
        System.out.println("대출인 : "+borrower);
        System.out.println("대출일 : "+checkOutDate);
        System.out.println();
    }
    public void checkIn(){
        System.out.println("*"+title+"가 반납되었습니다.");
        System.out.println();
    }
}

class MusicCDInfo extends CDInfo{
    String artist;
    String[] songTitle;

    MusicCDInfo(String artist, String title, String[] songTitle){
        this.artist = artist;
        this.title = title;
        this.songTitle = songTitle;
    }

    public String toString(){
        return artist+" "+title+ Arrays.toString(songTitle)+"음반";
    }
}

public class BookCDMS {
    public static void main(String[] args) {
        SeparateVolume sv = new SeparateVolume("엄마를 부탁해", "신경숙");
        sv.checkOut("홍길동", "20210801");
        sv.checkIn();

        AppCDInfo ac = new AppCDInfo("Redhat Fedora CD");
        ac.checkOut("박희진", "20210810");

        MusicCDInfo mc = new MusicCDInfo("김동률", "동행", new String[]{"고백", "청춘", "내 사람"});
        System.out.println(mc.toString());

    }
}

package exam_interface_check;

import java.util.Arrays;

interface Lendable{
    public abstract void checkOut(String borrower, String checkOutDate);
    public abstract void checkIn();
}

class SeparateVolume implements Lendable{
    private String requestNo; // 청구번호
    private String bookTitle; // 제목
    private String writer; // 저자
    private String borrower; // 대출인
    private String checkOutDate; // 대출일
    private int state; // 대출상태

    public SeparateVolume(String requestNo, String bookTitle, String writer){
        this.requestNo = requestNo;
        this.bookTitle = bookTitle;
        this.writer = writer;
    }
    public void checkOut(String borrower, String checkOutDate){ // 대출 메서드
        if(state != 0){ // 대여 중이라면
            System.out.println("대여 중인 책입니다.");
            return; // 메서드를 종료하겠다는 의미
        }
        this.borrower = borrower;
        this.checkOutDate = checkOutDate;
        this.state = 1; // 대출상태
        System.out.println("*"+bookTitle+"("+writer+") 이(가) 대출되었습니다.");
        System.out.println("대출인 : "+borrower);
        System.out.println("대출일 : "+checkOutDate+"\n");
    }
    public void checkIn(){ // 반납 메서드
        if(state==0){ // 이미 반납 처리가 되었다면
            System.out.println("이미 반납 처리가 완료되었습니다.");
            return;
        }
        this.borrower = null;
        this.checkOutDate = null;
        this.state = 0; // 반납상태
        System.out.println("*"+bookTitle+" 이(가) 반납되었습니다.\n");
    }

    public String toString(){
        return "단행본 정보[ 청구번호: "+requestNo+", 책제목 : "+bookTitle+", 저자 : "+writer;
    }

    public String getRequestNo(){ return requestNo; }
    public void setRequestNo(String requestNo){ this.requestNo = requestNo; }
    public String getBookTitle(){ return bookTitle; }
    public void setBookTitle(String bookTitle){ this.bookTitle = bookTitle; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
    public String getBorrower() { return borrower; }
    public void setBorrower(String borrower) { this.borrower = borrower; }
    public String getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }
}

class CDInfo{
    protected String registerNo;
    protected String title;
}

class AppCDInfo extends CDInfo implements Lendable{
    private String borrower; // 대출인
    private String checkOutDate; // 대출일
    private int state; // 대출상태

    public AppCDInfo(String registerNo, String title){
        this.registerNo =registerNo;
        this.title = title;
    }

    public void checkOut(String borrower, String checkOutDate){
        if(state != 0){
            System.out.println("이미 대출된 자료입니다.");
            return;
        }
        this.borrower = borrower;
        this.checkOutDate = checkOutDate;
        this.state = 1;
        System.out.println("*"+title+"가 대출되었습니다.");
        System.out.println("대출인 : "+borrower);
        System.out.println("대출일 : "+checkOutDate+"\n");
    }
    public void checkIn(){
        if(state == 0){
            System.out.println("이미 반납된 자료입니다.");
            return;
        }
        this.borrower = null;
        this.checkOutDate = null;
        this.state = 0;
        System.out.println("*"+title+"가 반납되었습니다.\n");
    }

    public String getBorrower() { return borrower; }
    public void setBorrower(String borrower) { this.borrower = borrower; }
    public String getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }
}

class MusicCDInfo extends CDInfo{
    String artist;
    String[] songTitle;

    MusicCDInfo(String artist, String title, String[] songTitle){
        this.artist = artist;
        this.title = title;
        this.songTitle = songTitle;
    }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String[] getSongTitle() { return songTitle; }
    public void setSongTitle(String[] songTitle) { this.songTitle = songTitle; }

    public String toString(){
        return artist+" "+title+ Arrays.toString(songTitle)+"음반";
    }
}

public class BookCDMS {
    public static void main(String[] args) {
        SeparateVolume sv = new SeparateVolume("863774","엄마를 부탁해", "신경숙");
        sv.checkOut("홍길동", "20210801");
        sv.checkIn();

        AppCDInfo ac = new AppCDInfo("7963112", "Redhat Fedora CD");
        ac.checkOut("박희진", "20210810");

        MusicCDInfo mc = new MusicCDInfo("김동률", "동행", new String[]{"고백", "청춘", "내 사람"});
        System.out.println(mc.toString());
    }
}

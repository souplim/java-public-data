package phoneinfoproject;

import phoneinfoproject.PhoneInfo;

import java.awt.*;
import java.util.Scanner;

public class PhoneBookManager {
    private static final int size=100;
    PhoneInfo[] infoStorage; // 전화번호 저장하는 객체배열
    int type;
    String name, phone, major, company = null;
    int year;
    private int cnt = 0; // 현재 저장된 객체들의 인덱스

    public PhoneBookManager(){
        infoStorage = new PhoneInfo[size];
    }

    public void input() {
        System.out.println("데이터 입력을 시작합니다.");
        System.out.print("1.일반 2.대학 3.회사\n선택 >> ");

        type = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();
        PhoneInfo info = null;

        switch(type){
            case 1:
                info = readInfo();
                break;
            case 2:
                info = readUnivInfo();
                break;
            case 3:
                info = readCompanyInfo();
                break;
            default :
                System.out.println("잘못 입력 하셨습니다.");
                return;
        }
        infoStorage[cnt++] = info;
        System.out.println("데이터 입력이 완료되었습니다.");
    }

    private PhoneInfo readInfo(){
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();
        System.out.print("전화번호 : ");
        phone = MenuViewer.sc.nextLine();

        return new PhoneInfo(name, phone);
    }

    public PhoneInfo readUnivInfo(){
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();
        System.out.print("전화번호 : ");
        phone = MenuViewer.sc.nextLine();
        System.out.print("전공 : ");
        major = MenuViewer.sc.nextLine();
        System.out.print("학년 : ");
        year = MenuViewer.sc.nextInt();

        return new PhoneUnivInfo(name, phone, major, year);
    }

    public PhoneInfo readCompanyInfo(){
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();
        System.out.print("전화번호 : ");
        phone = MenuViewer.sc.nextLine();
        System.out.print("회사 : ");
        company = MenuViewer.sc.nextLine();
        System.out.println("데이터 입력이 완료되었습니다.");

        return new PhoneCompanyInfo(name, phone, company);
    }

    public void search() { // 인덱스 번호 반환하는 메서드 따로 떼기
        System.out.println("데이터 검색을 시작합니다.");
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();

        int dataIdx = searchName(name);
        if(dataIdx<0)
            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
        else{
            infoStorage[dataIdx].showPhoneInfo();
            System.out.println("데이터 검색이 완료되었습니다. \n");
        }
    }

    private int searchName(String name){ // 내부에서만 사용될 메서드 private
        for(int i=0; i<cnt; i++){
            PhoneInfo curInfo = infoStorage[i];
            // compareTo() 객체의 필드값을 비교할 때 사용하는 메서드
            // 비교대상인 값.compareTo(비교할 값)이 일치하면 0을 리턴
            // 두 개의 값이 일치하지 않을시 0외의 값인 1, -1을 리턴
            if(name.compareTo(curInfo.getName())==0)
                return i;
        }
        return -1;
    }

    public void delete() {
        System.out.println("데이터 삭제를 시작합니다.");
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();

        int dataIdx = searchName(name); // 그 사용자의 인덱스를 불러온다
        if(dataIdx<0)
            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
        else {
            for(int i=dataIdx; i<cnt-1; i++)
                infoStorage[i]=infoStorage[i+1];
            infoStorage[cnt-1] = null;
            cnt--;
            System.out.println("데이터 삭제가 완료되었습니다.");
        }
    }
}

class MenuViewer {
    public static Scanner sc = new Scanner(System.in);

    public static void intro() { // 메뉴 뷰어는 객체 생성 않고 사용할 수 있게 static으로 선언할 수 있음
        System.out.println();
        System.out.println("선택하세요");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택 : ");
    }
}

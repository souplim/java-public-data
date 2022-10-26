package phoneinfoproject8;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

interface InputMenu {
    // 1. 일반, 2. 대학, 3. 회사
    int NORMAL = 1, UNIV = 2, COMPANY = 3;
}

public class PhoneBookManager implements Comparable<PhoneBookManager> {
    private static final int size=100;
    //    PhoneInfo[] infoStorage; // 전화번호 저장하는 객체배열
    public HashSet<PhoneInfo> infoStorage; // 전화번호 저장하는 HashSet<PhoneInfo>
    int type;
    String name, phone, major, company = null;
    int year;
    private int cnt = 0; // 현재 저장된 객체들의 인덱스

    // 8단계 전화번호부 저장 파일 생성
    private File file = new File("PhoneBook.dat");

    private static PhoneBookManager instance = null;
    public static PhoneBookManager getInstance() {
        if(instance == null)
            instance = new PhoneBookManager();
        return instance;
    }

    // 현재 생성자 접근 제어자를 private로 설정
    public PhoneBookManager(){
//        infoStorage = new PhoneInfo[size];
        infoStorage = new HashSet<>();
        // 8단계 - PhoneBookManager의 인스턴스 생성시 파일로부터 데이터 읽어와 HashSet에 저장
        reloadPhoneBook();
    }

    public void input() throws MenuChoiceException {
        System.out.println("데이터 입력을 시작합니다.");
        System.out.print("1.일반 2.대학 3.회사\n선택 >> ");

        type = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();
        PhoneInfo info = null;

        // 6단계 예외 객체 생성
        if(type < InputMenu.NORMAL || InputMenu.COMPANY < type){
            throw new MenuChoiceException(type);
        }

        // 4단계까지 제어
//        switch(type){
//            case 1:
//                info = readInfo();
//                break;
//            case 2:
//                info = readUnivInfo();
//                break;
//            case 3:
//                info = readCompanyInfo();
//                break;
//        }

        // 5단계 상수로 제어
        switch(type){
            case InputMenu.NORMAL:
                info = readInfo();
                break;
            case InputMenu.UNIV:
                info = readUnivInfo();
                break;
            case InputMenu.COMPANY:
                info = readCompanyInfo();
                break;
        }

        // 7단계 HashSet에 저장
        boolean isAdded = infoStorage.add(info);
        if(isAdded)
            System.out.println("데이터 입력이 완료되었습니다.");
        else
            System.out.println("이미 저장된 데이터입니다.");
    }

    // 8단계 기존 전화번호부 프로그램상으로 복원하는 메서드
    public void reloadPhoneBook() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            Object pi;
            while ((pi = in.readObject()) != null) {
                PhoneInfo phoneInfo = (PhoneInfo) pi;
                infoStorage.add(phoneInfo);
            }
        } catch (IOException io) {
            return; // 역직렬화할 때 readObject()는 읽을 데이터가 없으면 EOException 발생시킴 -> 호출한 곳으로 돌아가게 해줌
        } catch (ClassNotFoundException cnf) {
            System.out.println("데이터 파일을 찾을 수 없습니다.");
            return;
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    // 8단계 입력된 데이터를 파일에 저장하는 메서드
    public void savePhoneBook(){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            Iterator<PhoneInfo> it = infoStorage.iterator();
            while(it.hasNext()){
                PhoneInfo p = it.next();
                out.writeObject(p);
            }
        } catch(IOException io){
            System.out.println("입출력 과정에서 문제가 발생했습니다.");
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    // 일반을 선택했을 때 호출할 메서드(참조값 반환)
    private PhoneInfo readInfo(){
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();
        System.out.print("전화번호 : ");
        phone = MenuViewer.sc.nextLine();

        return new PhoneInfo(name, phone);
    }

    // 대학(학교)을 선택했을 때 호출할 메서드(참조값 반환)
    private PhoneInfo readUnivInfo(){
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

    // 회사를 선택했을 때 호출할 메서드(참조값 반환)
    private PhoneInfo readCompanyInfo(){
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();
        System.out.print("전화번호 : ");
        phone = MenuViewer.sc.nextLine();
        System.out.print("회사 : ");
        company = MenuViewer.sc.nextLine();
        System.out.println("데이터 입력이 완료되었습니다.");

        return new PhoneCompanyInfo(name, phone, company);
    }

//    public void search() { // 인덱스 번호 반환하는 메서드 따로 떼기
//        System.out.println("데이터 검색을 시작합니다.");
//        System.out.print("이름 : ");
//        name = MenuViewer.sc.nextLine();
//
//        int dataIdx = searchName(name);
//        if(dataIdx<0)
//            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
//        else{
//            infoStorage[dataIdx].showPhoneInfo();
//            System.out.println("데이터 검색이 완료되었습니다. \n");
//        }
//    }

    public void search() { // 인덱스 번호 반환하는 메서드 따로 떼기
        System.out.println("데이터 검색을 시작합니다.");
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();

        // 7단계 HashSet에서 검색
        PhoneInfo pi = searchName(name);
        if(pi==null)
            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
        else{
            pi.showPhoneInfo();
            System.out.println("데이터 검색이 완료되었습니다. \n");
        }
    }

//    private int searchName(String name){ // 내부에서만 사용될 메서드 private
//        for(int i=0; i<cnt; i++){
//            PhoneInfo curInfo = infoStorage[i];
//            // compareTo() 객체의 필드값을 비교할 때 사용하는 메서드
//            // 비교대상인 값.compareTo(비교할 값)이 일치하면 0을 리턴
//            // 두 개의 값이 일치하지 않을시 0외의 값인 1, -1을 리턴
//            if(name.compareTo(curInfo.getName())==0)
//                return i;
//        }
//        return -1;
//    }

    private PhoneInfo searchName(String name){ // 내부에서만 사용될 메서드 private
        // 7단계 HashSet에서 검색
        Iterator<PhoneInfo> it = infoStorage.iterator();
        while(it.hasNext()){
            PhoneInfo p = it.next();
            String n = p.getName();
            if(name.compareTo(n)==0)
                return p;
        }
        return null;
    }

    public void delete() {
        System.out.println("데이터 삭제를 시작합니다.");
        System.out.print("이름 : ");
        name = MenuViewer.sc.nextLine();

        // 7단계 HashSet에서 삭제
        PhoneInfo pi = searchName(name);
        if(pi==null)
            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
        else{
            infoStorage.remove(pi);
            System.out.println("데이터 삭제가 완료되었습니다. \n");
        }
    }

//    public void delete() {
//        System.out.println("데이터 삭제를 시작합니다.");
//        System.out.print("이름 : ");
//        name = MenuViewer.sc.nextLine();
//
//        int dataIdx = searchName(name); // 그 사용자의 인덱스를 불러온다
//        if(dataIdx<0)
//            System.out.println("해당하는 데이터가 존재하지 않습니다. \n");
//        else {
//            for(int i=dataIdx; i<cnt-1; i++)
//                infoStorage[i]=infoStorage[i+1];
//            infoStorage[cnt-1] = null;
//            cnt--;
//            System.out.println("데이터 삭제가 완료되었습니다.");
//        }
//    }

    @Override
    public int compareTo(PhoneBookManager pm){
        return this.name.compareTo(pm.name);
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

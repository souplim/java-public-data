package simplephoneinfo;

import java.util.Scanner;

class PhoneBookManager {
    Scanner sc = new Scanner(System.in);
    PhoneInfo instance;
    String name, phone, birth = null;
    int size=100;
    PhoneInfo[] array = new PhoneInfo[size];
    int cnt=0;


    public void intro()
    {
        System.out.println();
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택 : ");
    }

    public void input()
    {
        System.out.println("데이터 입력을 시작합니다.");
        System.out.println("이름 : ");
        name = sc.nextLine();
        System.out.println("전화번호 : ");
        phone = sc.nextLine();
        System.out.println("생년월일 : ");
        birth = sc.nextLine();
        System.out.println("데이터 입력이 완료되었습니다.");
        instance = new PhoneInfo(name, phone, birth);
        array[cnt++] = instance;
    }

    public void search()
    {
        System.out.println("데이터 검색을 시작합니다.");
        System.out.print("이름 : ");
        name = sc.nextLine();
        for(int i=0;i<cnt;i++)
        {
            if(array[i].getName().equals(name))
            {
                array[i].showPhoneInfo();
                System.out.print("데이터 검색이 완료되었습니다.");
                break;
            }
            else
                System.out.print("데이터가 존재하지 않습니다.");
            break;
        }
        System.out.println();
    }

    public void delete()
    {
        System.out.println("데이터 삭제를 시작합니다.");
        System.out.print("이름 : ");
        name = sc.nextLine();

        control1 :
        do{
            for(int i=0;i<cnt;i++)
            {
                if((array[i].getName()).equals(name))
                {
                    for(int j=i; j<cnt-1;j++)
                    {
                        array[j]=array[j+1];
                    }
                    array[cnt-1] = null;
                    cnt--;
                    System.out.println("데이터 삭제가 완료되었습니다.");
                    break control1;
                }
            }
            for(int i=0;i<cnt;i++)
                if(!(array[i].getName()).equals(name)){
                    System.out.println("삭제할 데이터가 존재하지 않습니다.");
                    break control1;
                }
        } while(true);
    }
}

public class PhoneMain {
    public static void main(String[] args) {
        PhoneBookManager pbm = new PhoneBookManager();
        int menu = 0;

        while(true)
        {
            pbm.intro();
            menu = pbm.sc.nextInt();
            pbm.sc.nextLine();

            switch(menu)
            {
                case 1 :
                    pbm.input();
                    break;
                case 2 :
                    pbm.search();
                    break;
                case 3 :
                    pbm.delete();
                    break;
                case 4 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default :
                    System.out.println("잘못 입력 하셨습니다.");
                    return;
            }
        }
    }
}
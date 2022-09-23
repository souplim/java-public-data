package exam_class_extends;

import java.util.Scanner;

class Account {
    private String ano;
    private String owner;
    private int balance;

    public Account(){ }
    public Account(String ano, String owner, int balance){
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAno(){ return ano; }
    public void setAno(String ano){ this.ano = ano; }
    public String getOwner(){ return owner; }
    public void setOwner(String owner){ this.owner = owner; }
    public int getBalance(){ return balance; }
    public void setBalance(int balance){ this.balance = balance; }
}


public class BankApplication {
    public static int i = 0;
    public static Scanner scanner = new Scanner(System.in);

    public static void createAccount(Account[] ac){
        System.out.println("계좌생성");
        System.out.println("------------");
        System.out.print("계좌번호: ");
        ac[i].setAno(scanner.nextLine());
        System.out.print("계좌주: ");
        ac[i].setOwner(scanner.nextLine());
        System.out.print("초기입금액: ");
        ac[i].setBalance(scanner.nextInt());

        System.out.print("결과: 계좌가 생성되었습니다.\n");

        ac[i] = new Account(ac[i].getAno(), ac[i].getOwner(), ac[i].getBalance());
    }

    public static void accountList(Account[] ac){
        System.out.println("계좌목록");
        System.out.println("------------");
        for(i=0; i<ac.length; i++){
            if(ac[i].getAno() != null)
                System.out.printf("%-16s %-7s %-8d\n", ac[i].getAno(),ac[i].getOwner(),ac[i].getBalance());
        }
    }

    public static void deposit(Account[] ac){
        name:
        do{
            System.out.println("예금");
            System.out.println("------------");
            System.out.print("계좌번호: ");
            String ano = scanner.nextLine();
            for(i=0; i<ac.length; i++){
                if((ano).equals(ac[i].getAno())){
                    System.out.print("예금액: ");
                    int deposit = scanner.nextInt();
                    ac[i].setBalance(ac[i].getBalance()+deposit);
                    System.out.println("예금에 성공했습니다.");
                    break name;
                } else {
                    break;
                }
            }
            if(!(ac[i].getAno()).equals(ano)){
                System.out.println("원하시는 계좌를 찾지 못했습니다.");
                System.out.println("------------");
                continue;
            }
        }while(true);
    }

    public static void withdraw(Account[] ac){
        name:
        do{
            System.out.println("출금");
            System.out.println("------------");
            System.out.print("계좌번호: ");
            String ano = scanner.nextLine();
            for(i=0; i<ac.length; i++){
                if((ano).equals(ac[i].getAno())){
                    System.out.print("출금액: ");
                    int withdraw = scanner.nextInt();
                    if(ac[i].getBalance()>=withdraw){
                        ac[i].setBalance(ac[i].getBalance()-withdraw);
                        System.out.println("출금에 성공했습니다.");
                    } else{
                        System.out.println("잔액이 부족합니다.");
                    }
                    break name;
                } else {
                    break;
                }
            }
            if(!(ac[i].getAno()).equals(ano)){
                System.out.println("원하시는 계좌를 찾지 못했습니다.");
                System.out.println("------------");
                continue;
            }
        }while(true);
    }

    public static void main(String[] args) {
        final int SIZE = 10;
        Account[] ac = new Account[SIZE];
        for(int i=0; i<SIZE; i++)
            ac[i] = new Account(); // 객체배열의 참조변수 뿐 아니라 객체도 생성 및 초기화 해주어야 한다. 아니면 nullException 뜸

        do{
            System.out.println("----------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("----------------------------------------------");
            System.out.print("선택> ");

            int choice = scanner.nextInt(); // 선택한 메뉴 번호 담을 변수
            System.out.println("------------");

            switch(choice){
                case 1 :
                    scanner.nextLine();
                    BankApplication.createAccount(ac); // 메뉴 선택에서 2->1 누르면 ArrayIndexOutOfBoundsException 발생
                    i++;
                    break;
                case 2 :
                    BankApplication.accountList(ac);
                    break;
                case 3 :
                    scanner.nextLine();
                    BankApplication.deposit(ac);
                    break;
                case 4 :
                    scanner.nextLine();
                    BankApplication.withdraw(ac);
                    break;
                case 5 :
                    System.out.println("프로그램 종료");
                    scanner.close();
                    return;
                default :
                    System.out.println("잘못된 숫자를 입력하셨습니다.");
                    break;
            }
        }while(true);
    }
}

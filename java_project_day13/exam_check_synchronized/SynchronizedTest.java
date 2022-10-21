package exam_check_synchronized;

class MyAccount {
    private String owner; // 계좌 소유자
    private int money; // 계좌 보유 금액

    public MyAccount(String owner, int money){
        this.owner = owner;
        this.money = money;
    }

    // 예금
    public synchronized void deposit(int amount, String user){
        if(amount > 0) {
            money += amount;
            System.out.println("["+user+"] 입금 : "+amount);
        } else {
            System.out.println("입금액이 올바르지 않습니다.");
        }
        System.out.println("["+user+"] 님이 요청한 계좌의 잔액 : "+money);
    }

    // 출금
    public synchronized void withdraw(int amount, String user){
        if(money-amount>0){
            money -= amount;
            System.out.println("["+user+"] 출금 : "+amount);
        } else {
            System.out.println("금액이 부족합니다.");
        }
        System.out.println("["+user+"] 님이 요청한 계좌의 잔액 : "+money);
    }

    public String getOwner(){ return owner; }
}

// 사용자는 동시에 account에 접근할 수 있으므로 thread로 생성
class User extends Thread {
    private String userName; // 사용자명
    private MyAccount account; // 사용자가 사용하는 계좌

    public User(String userName, MyAccount account){
        this.userName = userName;
        this.account = account;
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            int m = (((int)(Math.random()*3)*100)+200); // 200~400
            if(i%2==0)
                account.withdraw(m, userName);
            else
                account.deposit(m, userName);

            // 시간간격 두고 실행시키기 위해
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizedTest {
    public static void main(String[] args) {
        MyAccount acc = new MyAccount("홍길동", 10000);

        User u1 = new User("본인", acc);
        User u2 = new User("가족", acc);
        User u3 = new User("친구", acc);

        u1.start();
        u2.start();
        u3.start();
    }
}

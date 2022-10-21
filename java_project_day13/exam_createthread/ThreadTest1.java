package exam_createthread;

class MyRunnable implements Runnable {
    String myName;

    public MyRunnable(String name){
        myName = name;
    }

    public void run(){
        for(int i=0;i<10;i++)
            System.out.printf("%-13s = %d\n",myName, i);
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        // 1. 인터페이스 구현한 클래스의 참조변수로 스레드 생성 후 메서드 호출
        MyRunnable r1 = new MyRunnable("First Thread");
        Thread t1 = new Thread(r1);
        t1.start();

        // 2. 인터페이스 구현한 클래스의 참조변수 바로 참조하여 스레드 생성
        Thread t2 = new Thread(new MyRunnable("Second Thread"));
        t2.start();

        // 3. 람다식을 사용하여 인터페이스 구현후 객체 생성, 그 후 메서드 호출
        Runnable r = () -> {
                for(int i=0;i<10;i++)
                    System.out.printf("%-13s = %d\n","First Thread", i);
        };
        (new Thread(r)).start();

        // 4. 람다식을 사용하여 인터페이스 구현, 객체 생성, 메서드 호출을 동시에
        (new Thread(() -> {
            for(int i=0;i<10;i++)
                System.out.printf("%-13s = %d\n","Second Thread", i);
        })).start();
    }
}

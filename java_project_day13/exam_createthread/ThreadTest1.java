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
        // 1
        MyRunnable r1 = new MyRunnable("First Thread");
        Thread t1 = new Thread(r1);
        t1.start();

        // 2
        Thread t2 = new Thread(new MyRunnable("Second Thread"));
        t2.start();

        // 3
        MyRunnable r = () -> {
            public void run(){
                for(int i=0;i<10;i++)
                    System.out.printf("%-13s = %d\n","First Thread", i);
            }
        };
        (new Thread(r)).start();

        // 4
        (new Thread(() -> {
            for(int i=0;i<10;i++)
                System.out.printf("%-13s = %d\n","Second Thread", i);
        })).start();
    }
}

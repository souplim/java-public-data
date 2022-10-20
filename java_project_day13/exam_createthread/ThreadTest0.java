package exam_createthread;

class Counting extends Thread {
    public Counting(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++)
            System.out.println(getName()+" : "+i);
    }
}

public class ThreadTest0 {
    public static void main(String[] args) {
        Thread t1 = new Counting("First Thread");
        Thread t2 = new Counting("Second Thread");

        t1.start();
        t2.start();
    }
}

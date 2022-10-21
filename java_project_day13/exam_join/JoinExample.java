package exam_join;

class SumThread extends Thread {
    private int first, last;
    private int sum;

    public SumThread(int first, int last){
        this.first = first;
        this.last = last;
    }

    @Override
    public void run(){
        for(int i = first; i<= last; i++)
            sum += i;
    }

    public int getSum(){ return sum; }
}

public class JoinExample {
    public static void main(String[] args) {
        SumThread joinThread1 = new SumThread(1, 5);
        SumThread joinThread2 = new SumThread(6, 10);

        joinThread1.start();
        joinThread2.start();

        try {
            joinThread1.join();
            joinThread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread1(1, 5) sum : "+joinThread1.getSum());
        System.out.println("Thread2(6, 10) sum : "+joinThread2.getSum());
        System.out.println("Total sum : "+(joinThread1.getSum()+joinThread2.getSum()));
    }
}

package exam_createthread;

class Food extends Thread {
    private String name;
    public Food(String name){
        this.name = name;
    }
    public void run(){
        for(int i=1; i<=10; i++)
            System.out.println(name+i);
    }
}

class Phone extends Thread {
    private String name;
    public Phone(String name){
        this.name = name;
    }
    public void run() {
        for(int i=1;i<=10;i++)
            System.out.println(name + i);
    }
}

public class ThreadTest4 {
    public static void main(String[] args) {
        Food work1 = new Food("음식 먹기 : ");
        Phone work2 = new Phone("카톡 확인 : ");

        work1.start();
        work2.start();

        for(int i=1;i<=10;i++)
            System.out.println("TV 보기 : "+i);
    }
}

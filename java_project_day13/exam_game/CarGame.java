package exam_game;

import javax.swing.*;

public class CarGame extends JFrame {
    private static final long serialVersionUID = 1L;

    class MyThread extends Thread {
        private JLabel label;
        private int x, y;

        public MyThread(String fname, int x, int y){
            this.x = x;
            this.y = y;
            label = new JLabel();
            label.setIcon(new ImageIcon(fname)); // setText -> 문자 출력, setIcon-> JLabel의 이미지 설정
            label.setBounds(x, y, 100, 100); // JLabel의 위치 설정. setBounds(x, y, width, height)
            add(label);
        }

        public void run(){
            for(int i=0; i<100; i++){
                x += 10 * Math.random(); // 랜덤한 값으로 위치값 설정
                label.setBounds(x, y, 100, 100);
                repaint(); // 화면에 나왔던 것을 새롭게 다른 위치에 출력하고...
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public CarGame(){
        setTitle("CarRace");
        setSize(680,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null); // 어디에 레이블 출력할지 정해줄 때 기본값 사용하지 않을 것 - null

        (new MyThread("car1.gif", 100, 0)).start();
        (new MyThread("car2.gif", 100, 50)).start();
        (new MyThread("car3.gif", 100, 100)).start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new CarGame();

    }
}

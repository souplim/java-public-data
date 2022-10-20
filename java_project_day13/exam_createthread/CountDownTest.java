package exam_createthread;

import javax.swing.*;
import java.awt.*;

public class CountDownTest extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel label;

    class MyThread extends Thread { // 내부클래스 - 외부 클래스의 private필드에 접근 용이
        @Override
        public void run(){
            for(int i=10;i>=0;i--){
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                label.setText(i+"");
            }
        }
    }

    public CountDownTest() {
        setTitle("카운트다운");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Start", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        add(label);
        (new MyThread()).start();

        setVisible(true);
    }

    public static void main(String[] args){
        new CountDownTest();
    }
}

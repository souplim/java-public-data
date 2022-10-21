package exam_interrupt;

import javax.swing.*;
import java.awt.*;

public class CountDownTest extends JFrame { // 윈도우창 상속
    private JLabel label; // 사용자한테 보여줄 때 사용할 클래스
    private Thread t;

    class Counter extends Thread { // 내부클래스 - 외부 클래스의 private필드에 접근 용이
        @Override
        public void run(){
            for(int i=10;i>=0;i--){
                try {
                    Thread.sleep(1000); // 스레드 1초간 실행대기 상태로 -> 이후 실행가능상태
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                label.setText(i+""); // 레이블에 숫자 띄우기 - 괄호 안에는 문자타입 와야
            }
        }
    }

    public CountDownTest() { // JFrame 상속 받은 CounDownTest의 창 관련 속성 - 생성자에서 설정
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);
        label = new JLabel("0");
        label.setBounds(0,0,384,111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        JButton btnNewButton = new JButton("카운터 중지");
        btnNewButton.setBounds(247,25,125,23);
        btnNewButton.addActionListener(e -> t.interrupt());
        getContentPane().add(btnNewButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // 프레임창 화면에 보이게 설정

        t = new Counter();
        t.start();
    }

    public static void main(String[] args){
        CountDownTest t = new CountDownTest(); // 생성자 호출
    }
}

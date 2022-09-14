package exam_for;

// 난수를 얻기 위해 자바에서는 Math.random()을 사용한다. 그럼 0과 1사이의 실수값을 반환한다.
// System.out.println(Math.random());

public class RandomExample {
    public static void main(String[] args){
        System.out.println(Math.random());

        System.out.println((int)(Math.random()*10)); // 0~9의 정수값 출력
        System.out.println((int)(Math.random()*10)+1); // 1~10의 정수값 출력

        int num = (int)(Math.random()*6)+1;
        System.out.println("주사위 : "+num);
    }
}

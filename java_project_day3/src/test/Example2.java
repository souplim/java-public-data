package test;

// x개의 사탕을 y명의 학생들에게 똑같이 나누어주려고 할 때, 각 학생들이 받을 수 있는 사탕의 수와 남는 사탕의 수를 계산해 출력하는 프로그램을 작성하시오.
public class Example2 {
    public static void main(String[] args) {
        int x = 100;
        int y = 33;
        int candy, rest;

        candy = x/y;
        rest = x%y;
        System.out.println(candy);
        System.out.println(rest);
    }
}


package exam_interface;

import java.util.Arrays;

/* Arrays 클래스의 sort()메소드는 대상 객체가
 * Comparable 인터페이스를 구현하고 있는 경우에만 정렬 서비스를 제공한다.
 * Student 클래스를 작성하고 학생들의 평점을 기준으로 정렬하는 예제이다.
 *
 * Student 클래스를 생성하고 이름(name)과 평점(gpa)을 필드로 가진다.
 * 매개변수를 가진 생성자, 접근자, toString()을 생성한다.
 */
@SuppressWarnings("rawtypes")
class Student implements Comparable{
    private String name; // 이름
    private double gpa; // 평점

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){ return name; }
    public double getGpa(){ return gpa; }

    @Override
    public String toString(){
        return "이름="+name+" 평점="+gpa;
    }

    // Comparable의 추상메서드 구현 - 이름도 있고 평점도 있는데 정렬의 근거는 무엇으로 줄 건가도 생각
    public int compareTo(Object obj){ // 슈퍼클래스 참조변수 = 서브클래스의 참조값. 업캐스팅
        Student other = (Student)obj; // 서브클래스 참조변수 = (서브클래스)슈퍼클래스의 타입 참조변수. 다운캐스팅
        // 평점 기준
        /*if(this.gpa < other.gpa)
            return -1;
        else if(this.gpa > other.gpa)
            return 1;
        else
            return 0;*/

        // 이름 기준
        // String 클래스에 이미 compareTo가 정의되어있음
        return this.name.compareTo(other.name);
    }
}


public class StudentSort {
    public static void main(String[] args) {
        // 5개의 숫자를 오름차순 정렬하여 출력하는 코드를 작성해주세요.
        int[] numbers = {60, 80, 10, 45, 90};
        Arrays.sort(numbers); // 자바에서 제공하는 Arrays 클래스의 sort 메서드 사용

        for(int num : numbers)
            System.out.print(num+" ");
        System.out.println("\n"); // System.out.println();와 다른 점?

        // 3명의 학생 평점으로 오름차순 정렬하여 출력하는 코드를 작성해 주세요.
        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 3.39);
        students[1] = new Student("이한솔", 4.21);
        students[2] = new Student("김희진", 2.19);
        Arrays.sort(students); // 각각의 클래스에 정렬 기준 제공해야

        for(Student s : students)
            System.out.println(s); // toString() 호출
    }
}

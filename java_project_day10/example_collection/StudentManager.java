package example_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*[요구사항] 학생 정보를 저장하기 위한 Student 클래스를 생성해야 한다.
 * Student 클래스는 이름(name), 학과(department), 학번(id), 학점평균(grade)을 저장하는 필드가 있다.
 *
 * 실행 클래스의 이름은 StudentManager이다.
 * 사용자로 하여금 학생정보를 입력받아 Student 객체를 생성하고
 * 4명의 학생 정보를 ArrayList<Student> 컬렉션에 저장한 후에(read()), ArrayList<Student>의 모든 학생(4명) 정보를 출력한다(printAll())
 * 반복문을 통해서 학생 이름을 입력받아 학생의 정보를 출력하되 종료를 입력하면 프로그램을 종료하도록(processQuery()) 프로그램을 작성하라.
*/
public class StudentManager {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(read());
        list.add(read());
        list.add(read());
        list.add(read());

        printAll(list);
    }
    public static Scanner scanner = new Scanner(System.in);
    public static Student read(){
        Student st = new Student();

        System.out.print("이름 : ");
        String name = scanner.nextLine();
        processQuery(name);
        st.setName(name);

        System.out.print("학과 : ");
        String department = scanner.nextLine();
        processQuery(department);
        st.setDepartment(department);

        System.out.print("학번 : ");
        String id = scanner.nextLine();
        processQuery(id);
        st.setId(id);

        System.out.print("학점평균 : ");
        String grade = scanner.nextLine();
        processQuery(grade);
        st.setGrade(grade);

        return st;
    }

    public static void processQuery(String s){
        if("종료".equals(s)){
            System.out.println("종료되었습니다.");
            scanner.close();
            System.exit(0);
        }
    }
    public static void printAll(List<Student> list){
//        System.out.println(list.toString()); // [ , , , , ] 배열에 담긴 걸 꺼내듯이 출력하는 거 말고 다른 방법이 있을까?

        for(int i=0; i<list.size(); i++)
            System.out.println("이름: "+list.get(i).getName()+", 학과: "+list.get(i).getDepartment()+", 학번: "+list.get(i).getId()+"학점평균: "+list.get(i).getGrade());
    }
}

class Student {
    private String name;
    private String department;
    private String id;
    private String grade;

    public Student(){ }
    public Student(String name, String department, String id, String grade){
        this.name = name;
        this.department = department;
        this.id = id;
        this.grade = grade;
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getDepartment(){ return department; }
    public void setDepartment(String department){ this.department = department; }
    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }
    public String getGrade(){ return grade; }
    public void setGrade(String grade){ this.grade = grade; }

    @Override
    public String toString(){
        return "이름: "+getName()+", 학과: "+getDepartment()+", 학번: "+getId()+", 학점평균: "+getGrade()+"\n";
    }
}

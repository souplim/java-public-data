package exam_object_stream;

import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name="+name+", age="+age+"]";
    }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }
}

/*이름(name)과 나이(age)를 필드로 가진 Person 클래스를 생성한다.
 * 생성자, 설정자, 접근자 등을 생성하고 사용자로 하여금 데이터를 입력받아 인스턴스를 생성한다.
 * 그 데이터를 person.dat 파일에 저장한다.
- person.dat 파일에 Person 데이터를 저장 : output 메서드 생성
- person.dat 파일에서 데이터로 읽어서 Person 복원하여 출력 : input 메서드 생성
*/
public class ObjectInputOutputSteramExample01 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String file = "person.dat";
        output(file);
        input(file);
    }

    public static void output(String file){
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            System.out.print("이름: ");
            String name = scan.nextLine();
            System.out.print("나이: ");
            int age = scan.nextInt();
            scan.nextLine();

            oos.writeObject(new Person(name, age));
        } catch (IOException io){
            System.out.println(io);
        }
    }

    public static void input(String file){
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            Person p = (Person)ois.readObject();
            System.out.println(p.toString());
        } catch(ClassNotFoundException e){
            System.out.println("클래스를 찾을 수 없습니다.");
        } catch(IOException io){
        }
    }
}

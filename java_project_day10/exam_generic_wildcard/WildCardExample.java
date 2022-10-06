package exam_generic_wildcard;

import java.util.Arrays;

class Person { // 일반인
    private String name;

    public Person(String name){ this.name = name; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
}

class Worker extends Person { // 직장인
    public Worker(String name){ super(name); }
}

class Student extends Person { // 학생
    public Student(String name){ super(name); }
}

class HighStudent extends Student { // 고등학교
    public HighStudent(String name){ super(name); }
}

class Course<T> {
    private String name; // 강좌명
    private T[] students; // 학생

    @SuppressWarnings("unchecked")
    public Course(String name, int size){
        this.name = name;
        students = (T[])(new Object[size]);
        //students = new T[size]; 성립할 수 없음. 아직 형이 결정되지 않았는데 인스턴스 만들 수 없음. 제네릭 타입으로 생성자, 배열 생성 불가
    }

    public String getName(){ return name; }
    public T[] getStudents(){ return students; }
    public void add(T t){ // 배열에 학생 추가
        for(int i=0; i<students.length; i++){
            if(students[i] == null){
                students[i] = t; // 비어있는 곳에 학생 추가
                break;
            }
        }
    }
}

public class WildCardExample {
    // 정적 제네릭 메서드
    public static void registerCourse(Course<?> course) { // Q. <?>는 왜 쓰나?
        System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
                                                         // 반복문 쓰지 않고 배열 출력하는 메서드
    }

    public static void registerCourseStudent(Course<? extends Student> course) { // 수강생 제한 - 학생, 고등학생
        System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
    }

    public static void registerCourseWorker(Course<? super Worker> course) { // 수강생 제한 - 일반인, 직장인
        System.out.println(course.getName() + "수강생: "+ Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {
        // 일반인 과정
        Course<Person> personCourse = new Course<>("일반인 과정", 4);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        // 직장인 과정
        Course<Worker> workerCourse = new Course<>("직장인 과정", 1);
        workerCourse.add(new Worker("직장인"));
        // 학생 과정
        Course<Student> studentCourse = new Course<>("학생 과정", 2);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));
        // 고등학생 과정
        Course<HighStudent> highStudentCourse = new Course<>("고등학생 과정", 1);
        highStudentCourse.add(new HighStudent("고등학생"));

        // 강좌 등록 - 강좌 등록할 수 있는 대상 제한할 수 있음
        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

//        registerCourseStudent(personCourse); (x)
//        registerCourseStudent(workerCourse); (x)
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
//        registerCourseWorker(studentCourse); (x)
//        registerCourseWorker(highStudentCourse); (x)
    }
}

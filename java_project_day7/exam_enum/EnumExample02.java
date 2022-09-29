package exam_enum;

enum Gender {
    MALE("남성"), FEMALE("여성");

    private String s;
    Gender(String s){ this.s = s; }

    public String toString(){ return s; }
}
public class EnumExample02 {
    public static void main(String[] args) {
        Gender gender = Gender.FEMALE;
        if(gender == Gender.MALE)
            System.out.println(Gender.MALE+"은 병역의무가 있다.");
        else
            System.out.println(Gender.FEMALE+"은 병역의무가 없다.");

        Gender[] gen = Gender.values();
        for(Gender g : gen)
            System.out.println(g.toString());

        System.out.println(Gender.valueOf("MALE"));
    }
}

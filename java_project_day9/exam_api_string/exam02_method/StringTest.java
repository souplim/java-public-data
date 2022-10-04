package exam_api_string.exam02_method;

public class StringTest {
    public static void main(String[] args) {
        String ssn = "660606-1234561";
        // 성별을 구하는 메서드 선언 및 호출. getGender()
        System.out.printf("당신의 성별 : %s\n", getGender(ssn));
        // 나이를 구하는 메서드 선언 및 호출. getAge()
        System.out.printf("당신의 (만)나이 : %d\n", getAge(ssn));

        /*변수 fileName에 저장된 파일명(예: test.txt)에서 확장자 체크하여 이미지 파일(gif/jpg/png/jpeg)
		외 나머지 확장자를 가진 파일인 경우 "이미지 파일만 등록가능합니다"라는 메시지를 출력하도록 작성해 보세요.
		파일 확장자를 체크하는 메서드 호출(fileExtCheck())*/

        String fileName = "test.txt";
        System.out.println("파일명 : "+fileName);

        if(!fileExtCheck(fileName))
            System.out.println("이미지 파일만 등록가능합니다.");
    }

    public static String getGender(String str){
        int g = str.indexOf("-")+1; // String g = str.substring(7,8); // index 7만 가져올 때
        char c = str.charAt(g);
        String gender = null;

        if(c=='1' || c=='3')
            gender = "남성";
        else if(c=='2' || c=='4')
            gender =  "여성";

        return gender;
    }

    public static int getAge(String str){
        String g = str.substring(0,2);
        int birthYear = Integer.parseInt(g);
        int age = 122-birthYear;
        return age;
    }

    public static Boolean fileExtCheck(String fileName){
        String[]  fileNameExt = {"gif","jpg","png","jpeg"}; // fileName = a.b.txt이면 앞에서부터 . 찾으면 안 됨
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);

        for(int i=0; i<fileNameExt.length; i++)
            if(ext.equalsIgnoreCase(fileNameExt[i]))
                return true;
        return false;
    }
}

package exam_try_with_resources;

class FileInputStream implements AutoCloseable{
    private String file;

    public FileInputStream(String file){ this.file = file; }
    public void read(){ System.out.println(file+"을 읽습니다."); }

    @Override
    public void close() throws Exception {
        System.out.println(file+"을 닫습니다.");
    }
}

public class TryWithResourceExample {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("file.txt")){
            fis.read();
            throw new Exception();
        } catch(Exception e){
            System.out.println("예외 처리 코드가 실행되었습니다.");
        } // 왜 닫고 나서 예외처리코드실행 문장이 뜰까? -> 읽고 나서 끝났으니까 자동으로 닫아줌, 그리고 예외 던지고 이후 실행되는 것
    }
}

package exam_class_constructor;

class Emp {
    private String empno; // 사번
    private int gi; // 기본급
    private double su; // 수당
    private double se; // 세금
    private  double bong; // 본봉
    private String grad; // 등급

    public Emp(){}
    public Emp(String empno, int gi){
        this.empno = empno;
        this.gi = gi;
    }

    public String getEmpno() { return empno; }
    public void setEmpno(String empno) { this.empno = empno; }
    public int getGi() { return gi; }
    public void setGi(int gi) { this.gi = gi; }
    public double getSu(){
        su = getGi()*0.15;
        return su;
    }
    public double getSe(){
        se = getGi()*0.20;
        return se;
    }
    public double getBong(){
        bong = getGi()+getSu()-getSe();
        return bong; }
    public String getGrad(){
        if(bong>=500000){ grad = "관리자"; }
        else{ grad = "영업"; }
        return grad;
    }

    public String toString(){
        return String.format("%5s | %8d | %10.0f | %10.0f | %10.0f | %6s",getEmpno(),getGi(),getSu(),getSe(),getBong(),getGrad());
    }
}

public class EmpMain {
    public static void main(String[] args) {
        Emp p1 = new Emp("A111", 780000);
        p1.getSu();
        p1.getSe();
        p1.getBong();
        p1.getGrad();

        Emp p2 = new Emp("B222", 450000);
        p2.getSu();
        p2.getSe();
        p2.getBong();
        p2.getGrad();

        Emp p3 = new Emp("C333", 570000);
        p3.getSu();
        p3.getSe();
        p3.getBong();
        p3.getGrad();

        // 객체배열 생성
        Emp[] p = new Emp[]{
                new Emp("A111", 780000),
                new Emp("B222", 450000),
                new Emp("C333", 570000)
        };

        for(int i=0; i<p.length; i++){
            p[i].getSu();
            p[i].getSe();
            p[i].getBong();
            p[i].getGrad();
        }

        System.out.println("                      봉급계산서                                    ");
        System.out.println("==================================================================");
        System.out.println(" 사번\t  기본급\t\t\t수당\t\t\t세금\t\t\t본봉\t\t\t등급");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        for(int i=0; i<p.length; i++){
            System.out.println(p[i].toString());
        }
    }
}

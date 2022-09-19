package exam_class_constructor;

class Payroll {
    private String empno; // 사번
    private int gi; // 기본급
    private double su; // 수당
    private double se; // 세금
    private  double bong; // 본봉
    private String grad; // 등급

    public Payroll(){}
    public Payroll(String empno, int gi){
        this.empno = empno;
        this.gi = gi;
    }

    public void getSu(){ su = gi*0.15; }
    public void getSe(){ se = gi*0.20; }
    public void getBong(){ bong = gi+su-se; }
    public void getGrad(){
        if(bong>=500000){ grad = "관리자"; }
        else{ grad = "영업"; }
    }

    public String toString(){
        return String.format("%5s | %8d | %10.0f | %10.0f | %10.0f | %6s",empno, gi, su, se, bong, grad);
    }
}

public class PayrollTest {
    public static void main(String[] args) {
        Payroll p1 = new Payroll("A111", 780000);
        p1.getSu();
        p1.getSe();
        p1.getBong();
        p1.getGrad();

        Payroll p2 = new Payroll("B222", 450000);
        p2.getSu();
        p2.getSe();
        p2.getBong();
        p2.getGrad();

        Payroll p3 = new Payroll("C333", 570000);
        p3.getSu();
        p3.getSe();
        p3.getBong();
        p3.getGrad();

        System.out.println("                      봉급계산서                                    ");
        System.out.println("==================================================================");
        System.out.println(" 사번\t  기본급\t\t\t수당\t\t\t세금\t\t\t본봉\t\t\t등급");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}

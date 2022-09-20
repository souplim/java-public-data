package exam_class_constructor;

/*사번과 기본급을 입력해서, 수당, 세금, 본봉, 등급을 저장하기 위한 사원 정보 클래스를 작성하여 다음과 같이 조건에 맞게 결과를 출력하려고 한다.
객체배열을 활용을 사용하여 아래 결과를 출력한다.
그리고 모든 필드마다 설정자와 접근자를 다 생성할 필요는 없으며 필요에 따라 설정자와 접근자를 적절하게 명시해 주시면 됩니다.
main() 메서드를 실행하여 다음의 결과를 얻을 수 있도록 구현하시오.

[조건]
1. 수당은 기본급의 15%
2. 세금은 기본급의 20%
3. 본봉은 기본급 + 수당 - 세금
4. 등급은 본봉이 500000 이상이면 관리자 나머지는 영업으로 계산한다.
5. 각 멤버 변수명은 사번(empno), 기본급(gi), 수당(su), 세금(se), 본봉(bong), 등급(grad)으로 지정한다.*/
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

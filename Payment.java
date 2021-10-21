import java.util.Scanner;

public class Payment {
    Scanner sc = new Scanner(System.in);
    int n;

    void payInfo(){
        System.out.print("===결제 안내===\n1 : 카드\n2 : 현금\n결제방식을 선택해주세요: ");
    }

    void paychoice(){
        while (true){
            n = sc.nextInt();
            if(n>2||1>n){
                System.out.print("다시 선택해주세요 : ");
                continue;
            }
            else {
                switch (n){
                    case 1 :
                        System.out.println("카드결제를 선택하셨습니다");
                        break;
                    case 2 :
                        System.out.println("현금결제를 선택하셨습니다");
                        break;}
                break;
            }
        }
    }

    void pay() {
        if (n == 1) {
            System.out.print("카드번호 16자리를 입력해주세요 : ");
            while (true) {
                String cn = sc.next();
                if (!(cn.length()==16)) {
                    System.out.println(cn + "를 입력하셨습니다\n다시 입력해주세요 : ");
                    continue;
                } else {
                    System.out.println("정상결제되었습니다");
                    Coffee coffee = new Coffee();
                    coffee.getCoffee();
                    break;
                }
            }
        }
        else {
            System.out.println("현금결제는 현재 지원하지 않는 기능입니다");
        }
    }
}

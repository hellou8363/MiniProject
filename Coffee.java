import java.util.Scanner;

public class Coffee {
    Scanner sc = new Scanner(System.in);
    int n;
    void coffeeInfo() {
        System.out.println("=====커피 자판기=====");
        System.out.println("1 : 아메리카노 4,100\n2 : 카페라떼 4,600\n3 : 카라멜 마끼아또 5,600");
        System.out.print("메뉴를 선택해주세요 : ");
    }

    void choice(){
        while(true){
            n = sc.nextInt();
            if(n>3||1>n){
                System.out.print("다시 선택해주세요 : ");
                continue;
            }
            else {
                switch (n){
                    case 1:
                        System.out.println("주문하신 음료는 아메리카노 입니다");
                        break;
                    case 2:
                        System.out.println("주문하신 음료는 카페라떼 입니다");
                        break;
                    case 3:
                        System.out.println("주문하신 음료는 카라멜 마끼아또 입니다");
                        break;
                }
                break;
            }
        }
    }
    void getCoffee(){
        System.out.println("주문하신 음료가 나왔습니다");
    }
}

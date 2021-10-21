public class CoffeeMachine {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Payment payment = new Payment();

        // 1. 커피메뉴 안내
        coffee.coffeeInfo();
        coffee.choice();

        // 2. 결제방법 안내
        payment.payInfo();
        payment.paychoice();

        // 3. 결제
        payment.pay();

        // 4. 커피제공


//
//        }
//        else {
//            System.out.println("현금결제는 현재 지원하지 않는 기능입니다");
//        }



    }
}

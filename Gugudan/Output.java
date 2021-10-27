public class Output {
    boolean ox;

    void info(){
        System.out.println("===== 구구단 게임 =====");
        System.out.println("정답 : +5점 / 오답 : -3점");
        System.out.println("100점 도달 시 정답 횟수, 오답 횟수 출력");
        System.out.println("===== 게임 시작 =====");
    }

    void printMul(){
        Calculation cal = new Calculation();
        cal.setNums();
        System.out.print(cal.getNum1()+" * "+ cal.getNum2()+" = ");
    }

    boolean result(){
        Input input = new Input();
        Calculation calculation = new Calculation();
        if(calculation.cal()==input.getUserNum()){
            System.out.println("정답-!!");
            return ox = true;
        }
        else {
            System.out.println("틀렸습니다\n정답은 "+calculation.cal());
            return ox = false;
        }
    }
}

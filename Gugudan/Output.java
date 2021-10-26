public class Output {
    void info(){
        System.out.println("===== 구구단 게임 시작 =====");
    }

    void printMul(){
        Calculation cal = new Calculation();
        cal.setNums();
        System.out.print(cal.getNum1()+" * "+ cal.getNum2()+" = ");
    }

    void result(){
        Input input = new Input();
        Calculation calculation = new Calculation();
        if(calculation.cal()==input.getUserNum()){
            System.out.println("정답-!!");
        }
        else {
            System.out.println("틀렸습니다\n정답은 "+calculation.cal());
        }
    }
}

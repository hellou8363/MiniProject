public class Calculation {
    static int num1;
    static int num2;
    static int mul;

    void setNums(){
        num1 = (int)(Math.random()*9)+1;
        num2 = (int)(Math.random()*9)+1;
    }

    public int getNum1(){
        return num1;
    }

    public int getNum2(){
        return num2;
    }

    int cal(){
        return mul = num1 * num2;
    }
}

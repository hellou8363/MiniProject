public class UpTo100 {
    int score, s, f;
    Output output = new Output();
    Input input = new Input();
    void upTo100(){
        output.info();
        while (score<100) {
            output.printMul();
            input.setUserNum();
            output.result();
            succeedAndFail();
        }
        System.out.println("총 풀이 횟수는 "+(s+f)+"회 입니다.");
        System.out.println("맞은 문제 : "+s+"개, 틀린 문제 : "+f+"개");
    }

    int succeedAndFail() {
        if (output.ox == true) {
            score += 5;
            s += 1;
        }
        else {
            score -= 3;
            f += 1;
        }
        return score;
    }
}

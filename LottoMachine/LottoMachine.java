import java.io.IOException;

public class LottoMachine {
    public static void main(String[] args) throws IOException {
        RandomNumber randomNumber = new RandomNumber();

        randomNumber.lottoInfo();
        randomNumber.userNum();
        randomNumber.userNumCheck();
        randomNumber.randomNum();
        randomNumber.matching();
        randomNumber.result();
    }
}

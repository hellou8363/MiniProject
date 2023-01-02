import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("---------- \uD83E\uDE9C LadderGame \uD83E\uDE9C ----------");
        System.out.print("사다리 게임에 참여할 인원 수를 입력해주세요: ");

        // 1. 게임에 참여할 인원 수를 입력 받는다.
        int member = in.nextInt();
        System.out.println();

        // 2. 입력된 인원 수가 참여 가능한 사다리를 만들기 위해 객체 생성
        Ladder ladder = new Ladder(member);

        // 3. 사다리 게임을 실행한다.
        try {
            ladder.playGame();
        } catch (InterruptedException e) {
            System.out.println("게임에 문제가 발생했습니다. :(");
            System.out.println("다음에 다시 이용해주세요.");
            throw new RuntimeException(e);
        } // try-catch

    } // main
} // end class

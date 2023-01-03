import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private int member;
    private List<List<Integer>> ladder;

    public Ladder() {
    } // default constructor

    public Ladder(int member) {
        this.member = member;
    } // constructor

    public void createLadder() { // 사다리 생성 메소드
        this.ladder = new ArrayList<>();

        for (int row = 0; row < member + (member - 1); row++) {

            if (row % 2 == 1) { // 사다리 연결부 생성
                List<Integer> tempList = new ArrayList<>(); // 임시 저장용 리스트

                for (int column = 0; column < member * 2; column++) {
                    int random = new Random().nextInt(2); // 범위: 0, 1

                    // 첫 번째 다리 연결부는 무작위, 두 번째 부터는 이중 연결되지 않게 체크
                    if (row > 1 && this.ladder.get(row - 2).get(column) == 1) {
                        tempList.add(0);
                        continue;
                    } // if

                    tempList.add(random);
                } // for

                // 연결부로 사용되는 리스트가 ALL 0으로 건널 다리가 없는 것은 아닌지 체크
                if (isEmptyBridge(tempList)) {

                    // ALL 0이라면 이전 연결부에서 다리가 이어지지 않은 부분을 하나 찾아서 1로 변경
                    if (row == 1) { // 정말 운 나쁘게 첫 연결부가 ALL 0이라면..
                        // 비교할 값이 없으므로 랜덤으로 하나의 인덱스에 1 저장
                        tempList.set(new Random().nextInt(member * 2), 1);

                    } else {
                        // 첫 연결부 리스트가 아니면 이전 값에서 요소가 0인 인덱스 가져와서 사용
                        int index = this.ladder.get(row - 2).indexOf(0);
                        tempList.set(index, 1);
                    } // if-else
                } // if

                this.ladder.add(tempList);

            } else {
                // 연결부가 필요없는 열(수직으로 내려가는 선)은 전부 0으로 채운다.
                this.ladder.add(IntStream.iterate(0, n -> n)
                        .limit(member * 2).boxed().collect(Collectors.toList()));
            } // if
        } // for
    } // createLadder

    public boolean isEmptyBridge(List<Integer> tempList) { // 요소가 모두 0이면 true 반환
        return tempList.stream().allMatch(e -> e == 0);
    } // isEmptyElement

    public void showLadder() throws InterruptedException { // 사다리를 보여줘!
        // 사다리를 보여주려면 일단 사다리를 생성해야 함
        if (this.ladder == null) { // 사다리 없니?
            createLadder(); // 그럼 만들어~
        } // if

        // 만든 사다리를 보여주기 시작

        // 인원 수 출력: (예) 1 2 3 4 5 <- 보여주기용
        IntStream.range(1, member + 1).forEach(member -> System.out.print(member + "    "));
        System.out.println();

        System.out.println("|    ".repeat(member)); // 인원 수 만큼 첫 '|' 출력 <- 보기 편하게 추가

        // 리스트의 요소 0과 1을 사용자가 보기 편하게 '|'와 '_', 필요없는 부분은 공백 처리
        for (int i = 0; i < this.ladder.get(0).size(); i++) {
            Thread.sleep(300);

            for (int j = 0; j < this.ladder.size(); j++) {
                // 짝수는 수직으로 내려가는 라인으로 '|', 연결 될 다리는 '--', 그외 공백
                System.out.print(this.ladder.get(j).get(i) == 0 ? j % 2 == 0 ? "| " : "   " : "__ ");
            } // for

            System.out.println();
        } // for

        System.out.println("|    ".repeat(member)); // 인원 수 만큼 마지막 '|' 부여
    } // showLadder

    public void playGame() throws InterruptedException {
        // 게임을 시작하면 랜덤 사다리를 보여준다.
        showLadder();

        // 보여준 사다리로 결과를 생성한다.
        int[] result = new int[member * 2]; // 결과 저장용 배열

        for (int row = 0; row < this.ladder.size(); row += 2) { // 2씩 증가: 홀수는 연결부
            int currentLocation = row;

            for (int column = 0; column < this.ladder.get(row).size(); column++) {

                // 현재 위치에서 오른쪽에 다리가 있다면 건넌다.
                // ladder.size() - 2: IndexOutOfBoundsException 예외방지!!
                if (this.ladder.size() - 2 > currentLocation && this.ladder.get(currentLocation + 1).get(column) == 1) {
                    currentLocation += 2;
                    continue;
                } // if

                // 현재 위치에서 왼쪽에 다리가 있다면 건넌다.
                // currentLocation >= 2: IndexOutOfBoundsException 예외방지!!
                if (currentLocation >= 2 && this.ladder.get(currentLocation - 1).get(column) == 1) {
                    currentLocation -= 2;
                } // if
            } // for

            // 도착 위치 저장 => row: 0 2 4 6 8 10 ...을 1 2 3 4 5로 변경해서 저장
            result[currentLocation] = (row / 2) + 1;
        } // for

        // 생성된 결과를 결과를 보여주는 메소드에게 전달
        showResult(result);
    } // playGame

    public void showResult(int[] result) { // 결과 보여주기
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";
        int random = new Random().nextInt(member) + 1; // 꽝을 뽑기위한 랜덤

        Arrays.stream(result).forEach(value -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } // try-catch

            // 꽝이 맨 왼쪽에 나오는 경우나 참여 인원이 10이상시 조금씩 옆으로 숫자가 밀려서 출력됨
            System.out.print(value == 0 ? "    " : value == random ? "\b\b\uD83D\uDCA3" : value);
        });

        //                                                       text color 변경                 콘솔을 기본값으로
        System.out.println("\n\uD83D\uDCA3을 받게 된 사람은?? " + ANSI_YELLOW + random + "번!!" + ANSI_RESET);

        this.ladder.clear(); // 게임이 종료되었으므로 자원 반환
    } // showResult
} // end class

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("---------- \uD83E\uDE9C LadderGame \uD83E\uDE9C ----------");
        System.out.print("사다리 게임에 참여할 인원 수를 입력해주세요: ");

        // 1. 게임에 참여할 인원 수를 입력 받는다.
        int memberCount = in.nextInt();

        // 2. 입력된 인원 수가 참여 가능한 사다리를 만든다.
        List<List<Integer>> ladder = createLadder(memberCount);


        // ----------------- 사다리 VIEW START ---------------------------------
        // 인원 수 출력: (예) 1 2 3 4 5 <- 보여주기용
        IntStream.range(1, memberCount + 1).forEach(member -> System.out.print(member + "   "));
        System.out.println();

        System.out.println("|   ".repeat(memberCount)); // 인원 수 만큼 첫 '|' 출력 <- 보기 편하게 추가

        // 리스트의 요소 0과 1을 사용자가 보기 편하게 '|'와 '_', 필요없는 부분은 공백 처리
        for (int i = 0; i < ladder.get(0).size(); i++) {
            for (int j = 0; j < ladder.size(); j++) {

                // 짝수는 수직으로 내려가는 라인으로 '|', 연결 될 다리는 '_', 그외엔은 공백
                System.out.print(ladder.get(j).get(i) == 0 ? j % 2 == 0 ? "| " : "  " : "_ ");
            } // for

            System.out.println();
        } // for

        System.out.println("|   ".repeat(memberCount)); // 인원 수 만큼 마지막 '|' 부여
        // ----------------- 사다리 VIEW END -----------------------------------


        // 리스트의 요소 확인용
//        for (int i = 0; i < ladder.size(); i++) {
//            for (int j = 0; j < ladder.get(i).size(); j++) {
//                System.out.print(ladder.get(i).get(j) + "  ");
//            } // for
//            System.out.println();
//        } // for


        // 3. 순서대로 사다리를 탄다.
        int[] result = new int[memberCount * 2];

        for (int i = 0; i < ladder.size(); i += 2) { // 순서
            int currentLocation = i;

            for (int j = 0; j < ladder.get(i).size(); j++) {

                // 현재 위치에서 오른쪽에 다리가 있다면 건넌다.
                if (ladder.size() - 2 > currentLocation && ladder.get(currentLocation + 1).get(j) == 1) {
                    currentLocation += 2;
                    continue;
                } // if

                // 현재 위치에서 왼쪽에 다리가 있다면 건넌다.
                if (currentLocation >= 2 && ladder.get(currentLocation - 1).get(j) == 1) {
                    currentLocation -= 2;
                } // if
            } // for

            // 도착 위치 저장
            result[currentLocation] = (i / 2) + 1;
        } // for

        // 결과 보여주기
        Arrays.stream(result).forEach(value -> System.out.print(value == 0 ? "   " : value));
    } // main

    public static List<List<Integer>> createLadder(int memberCount) { // 사다리 생성 메소드
        List<List<Integer>> ladder = new ArrayList<>();

        for (int i = 0; i < memberCount + (memberCount - 1); i++) {

            if (i % 2 == 1) { // 사다리 연결부 생성
                List<Integer> tempList = new ArrayList<>(); // 임시 저장용 리스트

                for (int j = 0; j < memberCount * 2; j++) {
                    int random = new Random().nextInt(2);

                    if (i > 1) { // 첫 번째 다리 연결부는 무작위, 두 번째 부터는 앞의 다리와 이중 연결되지 않게 체크
                        if (ladder.get(i - 2).get(j) == 1) {
                            tempList.add(0);
                            continue;
                        } // if
                    } // if

                    tempList.add(random);
                } // for

                ladder.add(tempList);
            } else {

                // 연결부가 필요없는 열은 전부 0으로 채운다.
                ladder.add(IntStream.iterate(0, n -> n)
                        .limit(memberCount * 2).boxed().collect(Collectors.toList()));
            } // if
        } // for

        return ladder;
    } // createLadder
} // end class

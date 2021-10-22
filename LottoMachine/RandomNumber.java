import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RandomNumber {
    int[] userArr = new int[6];
    int count=0;

    void lottoInfo(){
        System.out.println("=====Lotto 6/45 =====");
        System.out.println("1등 : 숫자 6개 일치 | 상금: 5만원");
        System.out.println("2등 : 숫자 5개 일치 | 상금: 3만원");
        System.out.println("3등 : 숫자 4개 일치 | 상금: 1만원");
        System.out.print("당신의 행운의 번호를 입력해주세요 : ");
    }

    void userNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    void userNumCheck(){
        System.out.println("입력하신 번호는 아래와 같습니다");
        System.out.println(Arrays.toString(userArr));
    }

    Set set = new HashSet();
    void randomNum(){
        int count=0;
        System.out.println("이번 주 행운의 번호는 다음과 같습니다");
        while(count<6){
            if(true == set.add((int)(Math.random()*45)+1)) {
                count++;
            }
        }
        System.out.println(set.toString());
    }

    void matching(){
        count=0;
        for(int i=0;i<userArr.length;i++) {
            if (set.contains(userArr[i])) {
                count++;
            }
        }
        System.out.println("일치하는 번호는 "+count+"개 입니다");
    }

    void result(){
        switch (count){
            case 4:
                System.out.println("3등 당첨-!! 축하드립니다:-)");
                break;
            case 5 :
                System.out.println("2등 당첨-!! 축하드립니다:-)");
                break;
            case 6:
                System.out.println("1등 당첨-!! 축하드립니다:-)");
                break;
            default:
                System.out.println("아쉽게도 당첨되지않았습니다:-(");
        }
    }
}

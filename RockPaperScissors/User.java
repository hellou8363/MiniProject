import java.util.Scanner;

public class User {
    public static int userNum;

    public void info(){
        System.out.println("=====가위바위보 게임시작=====");
        System.out.print("가위 바위 보 중 하나를 입력하세요 : ");
    }

    public void userTurn(){
        Scanner sc = new Scanner(System.in);
        String u = sc.nextLine();
        if(u.equals("가위")){
            userNum = 1;
            System.out.print("User : "+u);
        }
        if(u.equals("바위")){
            userNum = 2;
            System.out.print("User : "+u);
        }
        if(u.equals("보")){
            userNum = 3;
            System.out.print("User : "+u);
        }
    }

    public int getUserNumber(){
        return userNum;
    }
}
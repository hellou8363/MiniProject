import java.util.Scanner;

public class Input {
    static int userNum;
    int setUserNum(){
        Scanner scanner = new Scanner(System.in);
        userNum = scanner.nextInt();
        return userNum;
    }

    int getUserNum(){
        return userNum;
    }
}

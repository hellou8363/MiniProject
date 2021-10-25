
public class Bot {
    int botNum;
    public void botTurn(){
        botNum = (int) (Math.random() * 3) + 1;
        switch (botNum){
            case 1 :
                System.out.println(" vs 가위 : Bot");
                break;
            case 2 :
                System.out.println(" vs 바위 : Bot");
                break;
            case 3 :
                System.out.println(" vs 보 : Bot");
                break;
        }
    }

    public void matChing(){
        User user = new User();
        if(botNum==user.getUserNumber()){
            System.out.println("비겼습니다");
        }
        else if(botNum==1){ // 가위
            if(user.getUserNumber()==3)
            System.out.println("Bot의 승리-!!");
            if(user.getUserNumber()==2){
                System.out.println("User의 승리-!!");
            }
        }
        else if(botNum==2){ // 바위
            if(user.getUserNumber()==1)
            System.out.println("Bot의 승리-!!");
            if(user.getUserNumber()==3){
                System.out.println("User의 승리-!!");
            }
        }
        else if(botNum==3){ // 보
            if(user.getUserNumber()==1){
                System.out.println("User의 승리-!!");
            }
            if(user.getUserNumber()==2){
                System.out.println("Bot의 승리-!!");
            }
        }
    }
}


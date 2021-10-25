public class RockPaperScissors {
    public static void main(String[] args) {
        User user = new User();
        Bot bot = new Bot();
        user.info();
        user.userTurn();
        bot.botTurn();
        bot.matChing();

    }
}

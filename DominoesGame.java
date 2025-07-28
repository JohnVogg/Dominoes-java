import java.util.Scanner;


class DominoesGame
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to dominoes!");
        System.out.print("Give your player name: ");
        String playerName = input.nextLine();
        System.out.println("");

        Player humanPlayer = new Player(playerName);
        Player computerPlayer = new Player("Computer");
        
        boolean playAgain = true;

        while (playAgain){
            DominoesRound round = new DominoesRound(humanPlayer, computerPlayer);
            round.playRound();

            System.out.println(humanPlayer + " points: " + humanPlayer.getPoints());
            System.out.println(computerPlayer + " points: " +computerPlayer.getPoints());

            System.out.print("Do you want to play another round? (y/n)? ");
            String choice = input.next();
            playAgain = choice.equals("y");
        }

        System.out.println("Thank you for playing!!");
    }
}

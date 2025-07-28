class DominoesRound
{
    private Player player1;
    private Player player2;
    private Stock roundStock;
    private Board roundBoard;

    public DominoesRound(Player name1, Player name2){
        this.player1 = name1;
        this.player2 = name2;
        this.roundStock = new Stock();
        this.roundBoard = new Board();
    }


    public Player playRound(){
        player1.initializeHand(roundStock);
        player2.initializeHand(roundStock);
        boolean gameOver = false;
        boolean player1Turn = true;
        boolean player1CanPlay = true;
        boolean player2CanPlay = true;

        System.out.println("Board:");
        System.out.println(roundBoard);

        while (!gameOver){ //live game
            boolean playMade;

            if (player1Turn){ //Human
                playMade = player1.play(roundStock, roundBoard);
                if (!playMade){
                    player1CanPlay = false;
                }

                if (player1.emptyHand()){
                    System.out.println("Human won! Emptied Hand");
                    player1.collectPoints(player2);
                    return player1;
                }
            }
            
            else{ //Computer 
                playMade = player2.computerPlay(roundStock, roundBoard);
                if (!playMade){
                    player2CanPlay = false;
                }

                if (player2.emptyHand()){
                    System.out.println("Computer won the game!! Emptied Hand");
                    player2.collectPoints(player1);
                    return player2;
                }
            }

            if (!player1CanPlay && !player2CanPlay){ //Both blocked
                System.out.println("Game blocked! Comparing points...");
                if (player1.handPoints() < player2.handPoints()){
                    System.out.println("Human won!! Less points");
                    player1.collectPoints(player2);
                    return player1;
                }else{
                    System.out.println("Computer won!! Less points");
                    player2.collectPoints(player1);
                    return player2;
                }
            }

            player1Turn = !player1Turn; //Switch turn
        }
        
        return null; 
    }
}

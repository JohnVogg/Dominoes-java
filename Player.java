/*
 Name: Ioannis Voggelis
 AM: 5733
 */


import java.util.Scanner;

class Player
{
    private String name;
    private int currentPoints;
    private Hand currentHand;

    public Player(String name){
        this.name = name;
        this.currentPoints = 0;
        this.currentHand = new Hand();
    }

    public void initializeHand(Stock stock){ 
        currentHand = new Hand();
        for (int i = 0; i < 7; i++){
            currentHand.add(stock.draw());
        }
    }

    public void printHand(){
        System.out.println(name + ":");
        System.out.println(currentHand);
    }

    
    public boolean play(Stock stock, Board board){
        printHand();

        Scanner input = new Scanner(System.in);
        System.out.print("Select a tile to play, or -1 if no tile: ");
        int position = input.nextInt();
        if (position == -1){
            Tile newTile = draw(stock, board);
            if (newTile != null){
        	System.out.println("Tile to be added: " + newTile);
                addTileToBoard(newTile, board);
                return true;
            }
            return false;
        }   
        
        else{ //position != -1
            Tile selectedTile = currentHand.getTile(position);
            if (selectedTile != null && board.match(selectedTile)){
                System.out.println("Tile to be added: " + selectedTile);
                addTileToBoard(selectedTile, board);
                return true;
            }else{
                System.out.println("Invalid tile or position!!");
                currentHand.add(selectedTile);
                return play(stock, board); //Try again
                }
            }
        }

    
    public boolean computerPlay(Stock stock, Board board){
        printHand();
        Tile bestTile = currentHand.getBestTile(board);
        if (bestTile == null){
            bestTile = draw(stock, board);
            if (bestTile == null){
                return false;
            }
        }

        System.out.println("Tile to be added: " + bestTile);
        System.out.println("");
        addTileToBoard(bestTile, board);
        return true;
    }

    
    private Tile draw(Stock stock, Board board){
        while (!stock.isEmpty()){
            Tile newTile = stock.draw();
            System.out.println("Tile drawn: " + newTile);

            if (board.match(newTile)){
                return newTile;
            }else{
                currentHand.add(newTile);
            }
        }
        return null; //No matching tile in the stock
    }

    
    private void addTileToBoard(Tile tile, Board board){
        if (board.isEmpty()){ //1st category
            board.addLeft(tile);
        }
            
        else if (board.matchBoth(tile)){ //2nd category
            if (this.name.equals("Computer")){ //Computer chooses randomly
                if (Math.random() < 0.5){
                    board.addLeft(tile);
                }else{
                    board.addRight(tile);
                }
            }else{ 
                Scanner input = new Scanner(System.in); //Human player chooses 
                System.out.print("Add to the left(L) or to the right(R)? ");
                String answer = input.next();

                if (answer.equals("L")){
                    board.addLeft(tile);
                }else{
                    board.addRight(tile);
                }
            }
        }
        
        else if (board.matchLeft(tile)){ //3rd category
            board.addLeft(tile);
        }
        else if (board.matchRight(tile)){ //4rd category
            board.addRight(tile);
        }

        System.out.println("Board:");
        System.out.println(board);
    }

    public boolean emptyHand(){
        return currentHand.isEmpty();
    }

    public int handPoints(){
        return currentHand.points();
    }

    public void collectPoints(Player other){
        this.currentPoints += other.handPoints();
    }

    public String toString(){
        return name;
    }

    public int getPoints(){
        return currentPoints;
    }
}

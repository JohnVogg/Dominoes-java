class Board
{
    private Chain boardChain;
    
    public Board(){
        boardChain = new Chain();
    }

    public boolean matchLeft(Tile tile){
        if (isEmpty()){
            return true;
        }
        return tile.getLeftSide() == boardChain.getLeftValue() || tile.getRightSide() == boardChain.getLeftValue();
    }

    public Boolean matchRight(Tile tile){
        if (isEmpty()){
            return true;
        }
        return tile.getRightSide() == boardChain.getRightValue() || tile.getLeftSide() == boardChain.getRightValue();
    }

    public boolean matchBoth(Tile tile){
        return matchLeft(tile) && matchRight(tile);
    }

    public boolean match(Tile tile){
        return matchLeft(tile) || matchRight(tile);
    }

    public void addLeft(Tile tile){
        if (isEmpty()){
            boardChain.insertLeft(tile);
            return; //In order to stop the function
        }

        if (tile.getLeftSide() != boardChain.getLeftValue() && tile.getRightSide() != boardChain.getLeftValue()){
            return;
        }

        if (tile.getRightSide() != boardChain.getLeftValue()){
            tile.rotate();
        }
        boardChain.insertLeft(tile);
    }

    public void addRight(Tile tile){
        if (isEmpty()){
            boardChain.insertRight(tile);
            return;
        }

        if (tile.getLeftSide() != boardChain.getRightValue() && tile.getRightSide() != boardChain.getRightValue()){
            return;
        }

        if (tile.getLeftSide() != boardChain.getRightValue()){
            tile.rotate();
        }
        boardChain.insertRight(tile);
    }

    public boolean isEmpty(){
        return boardChain.isEmpty();
    }

    public String toString(){
        return boardChain.toString();
    }
    

    //Check 3rd part
    public static void main(String[] args) {
        // Test Board class
        Stock stock = new Stock();
        Board board = new Board();
        
        // Draw first tile and add it to board
        Tile firstTile = stock.draw();
        board.addLeft(firstTile);
        System.out.println("Board: " + board);
        
        // Continue drawing tiles and add to board if they match
        while (!stock.isEmpty()) {
            Tile tile = stock.draw();
            System.out.println("Tile drawn: " + tile);
            
            if (board.match(tile)) {
                // If it matches both ends, randomly decide where to add it
                if (board.matchBoth(tile)) {
                    if (Math.random() < 0.5) {
                        board.addLeft(tile);
                        System.out.println("Added to left: " + tile);
                    }else{
                        board.addRight(tile);
                        System.out.println("Added to right: " + tile);
                    }
                }else if (board.matchLeft(tile)){
                    board.addLeft(tile);
                    System.out.println("Added to left: " + tile);
                }else{
                    board.addRight(tile);
                    System.out.println("Added to right: " + tile);
                }
                
                System.out.println("Board: " + board);
                System.out.println("");
            }
        }
    }
}

/*
 Name: Ioannis Voggelis
 AM: 5733
 */


import java.util.ArrayList;

 
class Hand
{
    private ArrayList<Tile> hand;

    public Hand(){
        hand = new ArrayList<>();
    }
    
    public void add(Tile tile){
        hand.add(tile);
    }

    public Tile getTile(int position){
        if (position >= 0 && position < hand.size()){
            Tile til = hand.get(position);
            hand.remove(position);
            return til; 
        }
        return null;
    }

    public Tile getBestTile(Board board){
        Tile bestTile = null;
        int maxPoints = -1; // -1 < any tile points
        
        for (Tile tile : hand){
            if (board.match(tile) && tile.points() > maxPoints){
                bestTile = tile;
                maxPoints = tile.points();
            }
        }

        if (bestTile != null){
            hand.remove(bestTile);
        }
        
        return bestTile;
    }


    public String toString(){
        String handAppearance = "";
        for (Tile tile : hand){
            handAppearance += tile + " ";
        }
        
        handAppearance += "\n";
        for (int i = 0; i < this.hand.size(); i++){
            handAppearance += String.format(" %2d   ",i);
        }
        
        return handAppearance;
    }

    public boolean isEmpty(){
        return hand.isEmpty();
    }

    public int points(){
        int totalPoints = 0;
        for (Tile tile : hand){
            totalPoints += tile.points();
        }
        return totalPoints;
    }
}

/*
 Name: Ioannis Voggelis
 AM: 5733
 */


import java.util.Random;


class Stock 
{
    private int capacity = 28;
    private int size = 0;
    private Tile[] tiles; //The remaining tiles
    
    public Stock(){
        tiles = new Tile[capacity];
        int counter = 0;
        for (int i = 0; i <= 6; i ++){
            for (int j = i; j <= 6; j++){
                tiles[counter] = new Tile(i, j);
                counter ++;
            }
        } 

        this.size = 27; //Index of the last tile's position
        shuffle(); 
    }   

    private void shuffle(){
        Random luck = new Random();
        for (int i = size; i > 0; i--){
            int j = luck.nextInt(i + 1);
            Tile temp = tiles[i]; //In order to change the tiles
            tiles[i] = tiles[j];
            tiles[j] = temp;
        }
    }

    public Tile draw(){
        if (isEmpty()){
            System.out.println("No tiles left in the stock!!");
            return null;
        }
        return tiles[this.size--];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String tilesAppearance = "";
        for (int i = 0; i <= this.size; i++){
            tilesAppearance += tiles[i] + " ";
        }
        return tilesAppearance;
    }

    //Check 1st part
    public static void main(String[] args)
    {
        Stock myStock = new Stock();
        System.out.println("Initial stock: " + myStock);
        
        Tile tile1 = myStock.draw();
        System.out.println("Tile drawn: " + tile1);
        Tile tile2 = myStock.draw();
        tile2.rotate();
        System.out.println("Rotated tile drawn: " + tile2);
        System.out.println("Stock after the two draws: " + myStock);

        System.out.println("Drawing all tiles from the stock:");
        while (!myStock.isEmpty()){
            Tile newTile = myStock.draw();
            System.out.println("Tile drawn: " + newTile);
        }
    }
}
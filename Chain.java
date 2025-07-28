/*
 Name: Ioannis Voggelis
 AM: 5733
*/


class Chain
{
    private ChainElement start; //The left side of the chain
    private ChainElement finish; //THe right side of the chain
    private int leftValue;
    private int rightValue;

    public Chain(){
        start = null;
        finish = null;
    }

    public void insertLeft(Tile tile){
        ChainElement newElement = new ChainElement(tile);
        
        if (isEmpty()){
            start = newElement;
            finish = newElement;
            leftValue = tile.getLeftSide();
            rightValue = tile.getRightSide();
        }else{
            newElement.setNext(start);
            start.setPrevious(newElement);
            start = newElement;
            leftValue = tile.getLeftSide();
        }
    }

    public void insertRight(Tile tile){
        ChainElement newElement = new ChainElement(tile);

        if(isEmpty()){
            start = newElement;
            finish = newElement;
            leftValue = tile.getLeftSide();
            rightValue = tile.getRightSide();
        }else{
            finish.setNext(newElement);
            newElement.setPrevious(finish);
            finish = newElement;
            rightValue = tile.getRightSide();
        }
    }

    public String toString(){
        if (isEmpty()){
            return "-";
        }
        
        String chainAppearance = "";
        ChainElement temp = start; 
        while (temp != null){
            chainAppearance += temp.getTile() + " ";
            temp = temp.getNext();
        }
        return chainAppearance;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public int getLeftValue(){
        return leftValue;
    }

    public int getRightValue(){
        return rightValue;
    }


    //Check 2nd part
    public static void main(String[] args){
        Stock myStock = new Stock();
        Chain myChain = new Chain();
        System.out.println("Initial chain: -");

        for (int i = 0; i < 10; i++){
            Tile tile = myStock.draw();
            if (i % 2 == 0){ 
                myChain.insertLeft(tile);
                System.out.println("Added to left: " + tile);
            }else{
                myChain.insertRight(tile);
                System.out.println("Added to right: " + tile);
            }
            System.out.println("Current chain: " + myChain);
        }
    }
}
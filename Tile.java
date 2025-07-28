class Tile
{
    private int leftSide;
    private int rightSide;

    public Tile(int left, int right){
        if (left >= right){
            this.leftSide = right;
            this.rightSide = left;
        }else{
            this.leftSide = left;
            this.rightSide = right;
        }
    }

    public String toString(){
        return "[" + leftSide + "|" + rightSide + "]";
    }

    public void rotate(){
        int rotation = this.leftSide;
        this.leftSide = this.rightSide;
        this.rightSide = rotation;
    }

    public int points(){
        return this.leftSide + this.rightSide;
    }

    //Accessor methods
    public int getLeftSide(){
        return this.leftSide;
    }

    public int getRightSide(){
        return this.rightSide;
    }
}

class ChainElement
{
    private Tile tile;
    private ChainElement next = null;
    private ChainElement previous = null;

    public ChainElement(Tile tile){
        this.tile = tile;
    }

    public Tile getTile(){
        return tile;
    }
    
    public ChainElement getNext(){
        return next;
    }

    public ChainElement getPrevious(){
        return previous;
    }

    public void setNext(ChainElement next){
        this.next = next;
    }

    public void setPrevious(ChainElement prev){
        this.previous = prev;
    }
}   

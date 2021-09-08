public class Coordinates{
    private int x;
    private int y;
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }

    @Override
    public String toString(){
	return "(" + x + ", "+ y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() == this.getClass() && o.toString().equals(toString())) return true;
        return false;
    }
}

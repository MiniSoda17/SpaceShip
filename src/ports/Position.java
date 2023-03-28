package ports;

public class Position extends Object{
    final int x;
    final int y;
    final int z;

    public Position(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int distanceTo(Position other){
        int distance = (int) Math.sqrt((Math.pow(other.x - this.x, 2) +
                                        Math.pow(other.y - this.y, 2) +
                                        Math.pow(other.z - this.z, 2)));
        return distance;
    }

    public String toString(){
        String coordinates = String.format("(%d,%d,%d)", this.x, this.y, this.z);
        return coordinates;
    }
}
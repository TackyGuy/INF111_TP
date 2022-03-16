package physique;

public class Position {

    private int i;
    private int j;



    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }

    public Position(Position pos){
        //
        this.i = pos.i;
        this.j = pos.j;
    }

    public void additionnerPos(Position pos){
        this.i += pos.i;
        this.j += pos.j;
    }

    public void soustrairePos(Position pos){
        this.i -= pos.i;
        this.j -= pos.j;
    }

    public void multiplierPos(double i, double j){
        this.i *= i;
        this.j *= j;
    }



    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    protected Position clone() {
        return new Position(this);
    }

    @Override
    public boolean equals(Object obj) {
        Position pos = (Position) obj;

        if (pos != null){
            if (pos.i == this.i && pos.j == this.j){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "physique.Position{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

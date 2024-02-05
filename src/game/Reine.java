package game;

public class Reine extends Piece {
    public Reine(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean canMove(int destinationX, int destinationY, Table table) {
        return new Tour(x, y, isWhite).canMove(destinationX, destinationY, table)
                || new Fou(x, y, isWhite).canMove(destinationX, destinationY, table);
    }
}

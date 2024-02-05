package game;

public class Cavalier extends Piece{
    public Cavalier(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean canMove(int destinationX, int destinationY, Table table) {
        int dx = Math.abs(destinationX - x);
        int dy = Math.abs(destinationY - y);
        return (dx == 2 && dy == 1)
                || (dx == 1 && dy == 2)
                && (table.getPiece(destinationX, destinationY) == null
                || table.getPiece(destinationX, destinationY).isWhite != this.isWhite);
    }
}

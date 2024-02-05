package game;

public class Roi extends Piece {
    public Roi(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean canMove(int destinationX, int destinationY, Table table) {
        int dx = Math.abs(destinationX - x);
        int dy = Math.abs(destinationY - y);
        return (dx <= 1 && dy <= 1)
                && (table.getPiece(destinationX, destinationY) == null
                || table.getPiece(destinationX, destinationY).isWhite != this.isWhite);
    }
}

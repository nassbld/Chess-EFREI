package game;

public class Pion extends Piece {

    public Pion(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean canMove(int destinationX, int destinationY, Table table) {
        int direction = isWhite ? 1 : -1;
        // Mouvement simple
        if (x == destinationX
                && y + direction == destinationY
                && table.getPiece(destinationX, destinationY) == null) {
            return true;
        }
        // Capture en diagonale
        if (Math.abs(x - destinationX) == 1
                && y + direction == destinationY
                && table.getPiece(destinationX, destinationY) != null
                && table.getPiece(destinationX, destinationY).isWhite != this.isWhite) {
            return true;
        }
        // Premier mouvement de deux cases
        if (x == destinationX && Math.abs(destinationY - y) == 2
                && ((isWhite && y == 1) || (!isWhite && y == 6))
                && table.getPiece(destinationX, destinationY) == null
                && table.getPiece(x, y + direction) == null) {
            return true;
        }
        return false;
    }
}

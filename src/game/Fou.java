package game;

public class Fou extends Piece {
    public Fou(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    public boolean canMove(int destinationX, int destinationY, Table table) {
        if (Math.abs(destinationX - x) != Math.abs(destinationY - y)) {
            return false; // Le mouvement n'est pas diagonal.
        }
        int stepX = Integer.compare(destinationX, x);
        int stepY = Integer.compare(destinationY, y);
        int currentX = x + stepX;
        int currentY = y + stepY;
        while (currentX != destinationX || currentY != destinationY) {
            if (table.getPiece(currentX, currentY) != null) {
                return false; // Autre pièce bloque le chemin.
            }
            currentX += stepX;
            currentY += stepY;
        }
        return table.getPiece(destinationX, destinationY) == null
                || table.getPiece(destinationX, destinationY).isWhite != this.isWhite;
    }
}

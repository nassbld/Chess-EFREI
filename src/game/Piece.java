package game;

public abstract class Piece {
    protected int x;
    protected int y;
    protected boolean isWhite;

    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public abstract boolean canMove(int destinationX, int destinationY, Table table);
}

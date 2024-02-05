package game;

public class Table {
    private final Piece[][] table = new Piece[8][8];

    public Table() {
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialiser les pions
        for (int i = 0; i < 8; i++) {
            table[i][1] = new Pion(i, 1, true); // Pions blancs
            table[i][6] = new Pion(i, 6, false); // Pions noirs
        }

        // Initialiser les tours
        table[0][0] = new Tour(0, 0, true);
        table[7][0] = new Tour(7, 0, true);
        table[0][7] = new Tour(0, 7, false);
        table[7][7] = new Tour(7, 7, false);

        // Initialiser les cavaliers
        table[1][0] = new Cavalier(1, 0, true);
        table[6][0] = new Cavalier(6, 0, true);
        table[1][7] = new Cavalier(1, 7, false);
        table[6][7] = new Cavalier(6, 7, false);

        // Initialiser les fous
        table[2][0] = new Fou(2, 0, true);
        table[5][0] = new Fou(5, 0, true);
        table[2][7] = new Fou(2, 7, false);
        table[5][7] = new Fou(5, 7, false);

        // Initialiser les reines
        table[3][0] = new Reine(3, 0, true);
        table[3][7] = new Reine(3, 7, false);

        // Initialiser les rois
        table[4][0] = new Roi(4, 0, true);
        table[4][7] = new Roi(4, 7, false);
    }

    public Piece getPiece(int x, int y) {
        return table[x][y];
    }

    public void setPiece(Piece piece, int x, int y) {
        table[x][y] = piece;
    }

    public Piece[][] getTable() {
        return table;
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        if (this.getPiece(startX, startY) != null) {
            if (this.getPiece(startX, startY).canMove(endX, endY, this)) {
                this.table[endX][endY] = this.getPiece(startX, startY);
                this.table[startX][startY] = null;
            }
        }
    }
}

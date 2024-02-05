package game;

import java.util.Scanner;

public class ChessGame {
    private Table table;
    private boolean isWhiteTurn;

    public ChessGame() {
        table = new Table();
        isWhiteTurn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Afficher le plateau avec les pièces en UTF-8
            displayBoard();

            // Obtenir les coordonnées de départ et d'arrivée du joueur
            System.out.println(isWhiteTurn ? "game.Tour des Blancs" : "game.Tour des Noirs");
            System.out.print("Coordonnées de départ (ex. a2) : ");
            String startInput = scanner.next();
            System.out.print("Coordonnées d'arrivée (ex. a4) : ");
            String endInput = scanner.next();

            // Convertir les coordonnées en indices de tableau (ex. a2 -> x=0, y=1)
            int startX = startInput.charAt(0) - 'a';
            int startY = 7 - (startInput.charAt(1) - '1');
            int endX = endInput.charAt(0) - 'a';
            int endY = 7 - (endInput.charAt(1) - '1');

            // Vérifier si le mouvement est valide et effectuer le déplacement
            if (isValidMove(startX, startY, endX, endY)) {
                table.movePiece(startX, startY, endX, endY);
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Mouvement invalide. Réessayez.");
            }
        }
    }

    private boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Vérifier si le mouvement est valide en utilisant la méthode canMove de la pièce
        Piece piece = table.getPiece(startX, startY);
        if (piece == null || piece.isWhite != isWhiteTurn) {
            return false; // La pièce sélectionnée n'appartient pas au joueur en cours
        }
        return piece.canMove(endX, endY, table);
    }

    private void displayBoard() {
        int coordonnee = 1;

        System.out.println("\n   a b  c d  e f  g h");
        for (int y = 7; y >= 0; y--) {
            System.out.print(coordonnee + " ");
            coordonnee++;
            for (int x = 0; x < 8; x++) {
                Piece piece = table.getPiece(x, y);
                if (piece == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(getPieceSymbol(piece) + " ");
                }
            }
            System.out.println();
        }
    }

    private String getPieceSymbol(Piece piece) {
        // Mappez chaque type de pièce à un symbole UTF-8
        if (piece instanceof Pion) {
            return piece.isWhite ? "♟" : "♙"; // game.Pion
        } else if (piece instanceof Tour) {
            return piece.isWhite ? "♜" : "♖"; // game.Tour
        } else if (piece instanceof Cavalier) {
            return piece.isWhite ? "♞" : "♘"; // game.Cavalier
        } else if (piece instanceof Fou) {
            return piece.isWhite ? "♝" : "♗"; // game.Fou
        } else if (piece instanceof Reine) {
            return piece.isWhite ? "♛" : "♕"; // game.Reine
        } else if (piece instanceof Roi) {
            return piece.isWhite ? "♔" : "♚"; // game.Roi
        }
        return "  "; // Par défaut, espace vide
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.start();
    }
}


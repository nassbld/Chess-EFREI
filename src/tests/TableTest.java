package tests;

import game.Cavalier;
import game.Pion;
import game.Table;
import game.Tour;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void testPionMove() {
        Table table = new Table();

        // Effectuer un mouvement de pion valide
        assertTrue(table.getPiece(0, 1) instanceof Pion);
        table.movePiece(0, 1, 0, 3);        // Déplacement d'un pion de 2 cases en avant

        // Vérifier si le mouvement a été effectué correctement
        assertNotNull(table.getPiece(0, 3));
        assertNull(table.getPiece(0, 1));

        // Effectuer un mouvement de pion invalide
        assertTrue(table.getPiece(1, 1) instanceof Pion);
        table.movePiece(1, 1, 1, 4);        // Déplacement d'un pion de 2 cases en avant

        // Vérifier si le mouvement invalide a été détecté
        assertNull(table.getPiece(1, 4));
        assertNotNull(table.getPiece(1, 1));
    }

    @Test
    public void testTourMove() {
        Table table = new Table();

        // Effectuer un mouvement de tour non valide
        assertTrue(table.getPiece(0, 0) instanceof Tour);
        table.movePiece(0, 0, 0, 5);        // Déplacement d'une tour de 5 cases en avant au début de la partie

        // Vérifier si le mouvement invalide a été détecté
        assertNull(table.getPiece(0, 5));
        assertNotNull(table.getPiece(0, 0));
    }

    @Test
    public void testCavalierMove() {
        Table table = new Table();

        // Effectuer un mouvement de cavalier valide
        assertTrue(table.getPiece(1, 0) instanceof Cavalier);
        table.movePiece(1, 0, 0, 2);        // Déplacement d'un cavalier en L

        // Vérifier si le mouvement a été effectué correctement
        assertNotNull(table.getPiece(0, 2));
        assertNull(table.getPiece(1,0));

        // Effectuer un mouvement de cavalier invalide
        assertTrue(table.getPiece(6, 0) instanceof Cavalier);
        table.movePiece(6, 0, 6, 2);        // Déplacement d'un cavalier tout droit

        // Vérifier si le mouvement invalide a été détecté
        assertNull(table.getPiece(6, 2));
        assertNotNull(table.getPiece(6,0));
    }

    // LE TEST SUIVANT NE PASSE PAS
    // J'ai constaté que lorsque je déplace une pièce déjà déplacée, la pièce ne se déplace pas
    // J'ai donc créé un test pour vérifier, et j'ai pu confirmer la présence d'un bug via ce test

    @Test
    public void testBug() {
        Table table = new Table();

        // Effectuer un mouvement de pion valide
        assertTrue(table.getPiece(0, 1) instanceof Pion);
        table.movePiece(0, 1, 0, 3);        // Déplacement d'un pion de 2 cases en avant

        // Vérifier si le mouvement a été effectué correctement
        assertNotNull(table.getPiece(0, 3));
        assertNull(table.getPiece(0, 1));

        // Effectuer un mouvement de pion normalement valide avec le même pion
        assertTrue(table.getPiece(0, 3) instanceof Pion);
        table.movePiece(0, 3, 0, 4);        // Déplacement du pion d'une case en avant

        // Vérifier si le mouvement valide a été détecté
        assertNull(table.getPiece(0, 3));
        assertNotNull(table.getPiece(0, 4));
    }
}

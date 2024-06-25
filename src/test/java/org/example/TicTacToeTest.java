package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
public class TicTacToeTest {
    @Test
    public void testBrettHerstellen() {
        TicTacToe spiel = new TicTacToe();
        char[][] erwartetesBrett = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(erwartetesBrett, spiel.getSpielBrett());
    }

    @Test
    public void testSpielBrettAnzeigen() {
        TicTacToe spiel = new TicTacToe();
        assertDoesNotThrow(() -> spiel.spielbrettAnzeigen());
    }

    @Test
    public void testZugMachenGueltigePosition() {
        TicTacToe spiel = new TicTacToe();
        boolean ergebnis = spiel.zugMachen(1,1,'x');
        assertTrue(ergebnis);
        assertEquals('X', spiel.getSpielBrett()[1][1]);
    }

    @Test
    public void testZugMachenUngueltigePosition() {
        TicTacToe spiel = new TicTacToe();
        boolean ergebnis = spiel.zugMachen(3,7,'x');
        assertFalse(ergebnis);
    }

    @Test
    public void testZugMachenUngueltigesSymbol() {
        TicTacToe spiel = new TicTacToe();
        boolean ergebnis = spiel.zugMachen(1,1,'a');
        assertFalse(ergebnis);
    }

    @Test
    public void testZugMachenFeldBesetzt() {
        TicTacToe spiel = new TicTacToe();
        spiel.zugMachen(1,1,'x');
        boolean ergebnis = spiel.zugMachen(1,1,'o');
        assertFalse(ergebnis);
        assertEquals('X', spiel.getSpielBrett()[1][1]);
    }
    @Test
    public void testAktuellenStandAnzeigen() {
        // Vorbereitung: Redirect stdout, um die Konsolenausgabe abzufangen
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Erzeugen einer neuen TicTacToe-Instanz und Spielbrett initialisieren
        TicTacToe spiel = new TicTacToe();
        spiel.spielbrettHerstellen();

        // Aufruf der Methode, die den aktuellen Stand anzeigt
        spiel.aktuellenStandAnzeigen();

        // Erwartete Ausgabe: Mit System.lineSeparator() für plattformübergreifende Zeilenumbrüche
        String expectedOutput = "Aktueller Spielstand:" + System.lineSeparator()
                + "- - - " + System.lineSeparator()
                + "- - - " + System.lineSeparator()
                + "- - - " + System.lineSeparator()
                + System.lineSeparator();

        // Vergleich der erwarteten Ausgabe mit der tatsächlichen ausgegebenen Ausgabe
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    @Test
    public void testAktuellenStandAnzeigenNachEinigenZuegen() {
        // Vorbereitung: Redirect stdout, um die Konsolenausgabe abzufangen
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Erzeugen einer neuen TicTacToe-Instanz und Spielbrett initialisieren
        TicTacToe spiel = new TicTacToe();
        spiel.spielbrettHerstellen();

        // Einige Züge machen
        spiel.zugMachen(1, 1, 'X'); // Spieler X setzt auf (1,1)
        spiel.zugMachen(0, 0, 'O'); // Spieler O setzt auf (0,0)
        spiel.zugMachen(2, 2, 'X'); // Spieler X setzt auf (2,2)

        // Aufruf der Methode, die den aktuellen Stand anzeigt
        spiel.aktuellenStandAnzeigen();

        // Erwartete Ausgabe nach den Zügen
        String expectedOutput = "Aktueller Spielstand:" + System.lineSeparator()
                + "O - - " + System.lineSeparator()
                + "- X - " + System.lineSeparator()
                + "- - X " + System.lineSeparator()
                + System.lineSeparator();

        // Vergleich der erwarteten Ausgabe mit der tatsächlich ausgegebenen Ausgabe
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    @Test
    public void testAktuellenStandAnzeigenNachSpielende() {
        // Vorbereitung: Redirect stdout, um die Konsolenausgabe abzufangen
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Erzeugen einer neuen TicTacToe-Instanz und Spielbrett initialisieren
        TicTacToe spiel = new TicTacToe();
        spiel.spielbrettHerstellen();

        // Spiel simulieren: Alle Felder belegen
        spiel.zugMachen(0, 0, 'X'); // X
        spiel.zugMachen(0, 1, 'O'); // O
        spiel.zugMachen(0, 2, 'X'); // X
        spiel.zugMachen(1, 0, 'O'); // O
        spiel.zugMachen(1, 1, 'X'); // X
        spiel.zugMachen(1, 2, 'O'); // O
        spiel.zugMachen(2, 0, 'X'); // X
        spiel.zugMachen(2, 1, 'O'); // O
        spiel.zugMachen(2, 2, 'X'); // X

        // Aufruf der Methode, die den aktuellen Stand anzeigt
        spiel.aktuellenStandAnzeigen();

        // Erwartete Ausgabe nach dem Spielende
        String expectedOutput = "Aktueller Spielstand:" + System.lineSeparator()
                + "X O X " + System.lineSeparator()
                + "O X O " + System.lineSeparator()
                + "X O X " + System.lineSeparator()
                + System.lineSeparator();

        // Vergleich der erwarteten Ausgabe mit der tatsächlich ausgegebenen Ausgabe
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}

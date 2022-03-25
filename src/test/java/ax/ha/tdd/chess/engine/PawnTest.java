package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PawnTest {

    Chessboard chessboard;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        chessboard = game.getBoard();
    }

    @Test
    public void Pawn_move_forward() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a3");
        assertEquals(new Coordinates(0,5), chessPiece.getLocation());
    }

    @Test
    public void no_duplicate_with_move() {
        Coordinates coordinates = new Coordinates(0,6);
        game.move("a2-a3");
        assertNull(chessboard.getPiece(coordinates));
    }

    @Test
    public void Pawn_move_sideways_not_allowed() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-b2");
        assertEquals(new Coordinates(0,6), chessPiece.getLocation());

    }

    @Test
    public void Pawn_move_backwards_not_allowed() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a1");
        assertEquals(new Coordinates(0,6), chessPiece.getLocation());

    }

    @Test
    public void two_steps_at_start() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        assertEquals(new Coordinates(0,4), chessPiece.getLocation());

    }

    @Test
    public void two_steps_after_start_not_allowed() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a3");
        game.move("a7-a6");
        game.move("a3-a5");
        assertEquals(new Coordinates(0,5), chessPiece.getLocation());

    }

    @Test
    public void move_forward_to_occupied_spot_not_allowed() {
        Coordinates coordinates = new Coordinates(0,6);
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a5");
        game.move("a4-a5");
        assertEquals(new Coordinates(0,4), chessPiece.getLocation());

    }
}

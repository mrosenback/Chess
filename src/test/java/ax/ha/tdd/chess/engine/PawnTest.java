package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

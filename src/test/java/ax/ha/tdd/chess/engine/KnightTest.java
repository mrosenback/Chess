package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    Chessboard chessboard;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        chessboard = game.getBoard();
    }

    @Test
    public void Knight_move_to_allowed_spot() {
        Coordinates coordinates = new Coordinates("b1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("b1-c3");
        assertEquals(new Coordinates("c3"), chessPiece.getLocation());
    }
}

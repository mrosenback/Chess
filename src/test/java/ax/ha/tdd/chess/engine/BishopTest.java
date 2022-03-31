package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {

    Chessboard chessboard;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        chessboard = game.getBoard();
    }

    @Test
    public void Bishop_move_diagonally() {
        Coordinates coordinates = new Coordinates("c1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("d2-d4");
        game.move("a7-a6");
        game.move("c1-f4");
        assertEquals(new Coordinates("f4"), chessPiece.getLocation());
    }

    @Test
    public void Bishop_move_straight_not_allowed() {
        Coordinates coordinates = new Coordinates("c1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("c2-c4");
        game.move("c1-c3");
        assertEquals(new Coordinates("c1"), chessPiece.getLocation());
    }
}

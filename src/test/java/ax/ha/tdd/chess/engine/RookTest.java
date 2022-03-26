package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTest {

    Chessboard chessboard;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        chessboard = game.getBoard();
    }

    @Test
    public void Rook_move_forward() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a6");
        game.move("a1-a3");
        assertEquals(new Coordinates("a3"), chessPiece.getLocation());
    }

    @Test
    public void Rook_move_backwards() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a6");
        game.move("a1-a3");
        game.move("a6-a5");
        game.move("a3-a2");
        assertEquals(new Coordinates("a2"), chessPiece.getLocation());
    }
}

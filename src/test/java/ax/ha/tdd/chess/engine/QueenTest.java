package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

    Chessboard chessboard;
    Queen queen = new Queen(PieceType.BISHOP, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void Queen_move_forward() {
        chessboard.addPiece(queen);
        assertTrue(queen.canMove(chessboard, new Coordinates("d6")));
    }

    @Test
    public void Queen_move_backward() {
        chessboard.addPiece(queen);
        assertTrue(queen.canMove(chessboard, new Coordinates("d2")));
    }

    @Test
    public void Queen_move_sideways() {
        chessboard.addPiece(queen);
        assertTrue(queen.canMove(chessboard, new Coordinates("f4")));
    }
}

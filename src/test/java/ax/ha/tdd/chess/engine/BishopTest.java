package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.Bishop;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {

    Chessboard chessboard;
    Bishop bishop = new Bishop(PieceType.BISHOP, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void Bishop_move_diagonally() {
        chessboard.addPiece(bishop);
        assertTrue(bishop.canMove(chessboard, new Coordinates("f6")));
    }

    @Test
    public void Bishop_move_straight_not_allowed() {
        chessboard.addPiece(bishop);
        assertFalse(bishop.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void move_over_another_not_allowed() {
        chessboard.addPiece(bishop);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e5")));
        assertFalse(bishop.canMove(chessboard, new Coordinates("f6")));
    }
}

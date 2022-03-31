package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
import ax.ha.tdd.chess.engine.pieces.type.King;
import ax.ha.tdd.chess.engine.pieces.type.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    Chessboard chessboard;
    King king = new King(PieceType.BISHOP, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void King_move_forward() {
        chessboard.addPiece(king);
        assertTrue(king.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void King_move_backward() {
        chessboard.addPiece(king);
        assertTrue(king.canMove(chessboard, new Coordinates("d3")));
    }

    @Test
    public void King_move_sideways() {
        chessboard.addPiece(king);
        assertTrue(king.canMove(chessboard, new Coordinates("e4")));
    }

    @Test
    public void King_move_diagonally() {
        chessboard.addPiece(king);
        assertTrue(king.canMove(chessboard, new Coordinates("e5")));
    }

    @Test
    public void move_more_than_one_step_not_allowed() {
        chessboard.addPiece(king);
        assertFalse(king.canMove(chessboard, new Coordinates("d6")));
    }
}

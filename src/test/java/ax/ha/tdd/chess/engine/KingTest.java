package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {

    Chessboard chessboard;
    King king = new King(PieceType.KING, Player.WHITE, new Coordinates("d4"));

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

    @Test
    public void move_to_threatened_Knight_spot_not_allowed() {
        chessboard.addPiece(king);
        chessboard.addPiece(new Knight(PieceType.KNIGHT, Player.BLACK, new Coordinates("f6")));
        assertFalse(king.canMove(chessboard, new Coordinates("e4")));
    }

    @Test
    public void move_to_threatened_Pawn_spot_not_allowed() {
        chessboard.addPiece(king);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("b5")));
        assertFalse(king.canMove(chessboard, new Coordinates("c4")));
    }

    @Test
    public void move_to_threatened_King_spot_not_allowed() {
        chessboard.addPiece(king);
        chessboard.addPiece(new King(PieceType.KING, Player.BLACK, new Coordinates("f4")));
        assertFalse(king.canMove(chessboard, new Coordinates("e4")));
    }
}

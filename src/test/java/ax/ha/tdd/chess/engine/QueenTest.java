package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.King;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
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

    @Test
    public void Queen_move_diagonally() {
        chessboard.addPiece(queen);
        assertTrue(queen.canMove(chessboard, new Coordinates("f6")));
    }

    @Test
    public void move_to_not_allowed_spot() {
        chessboard.addPiece(queen);
        assertFalse(queen.canMove(chessboard, new Coordinates("e6")));
    }

    @Test
    public void move_over_another_not_allowed() {
        chessboard.addPiece(queen);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e5")));
        assertFalse(queen.canMove(chessboard, new Coordinates("f6")));
    }

    @Test
    public void move_to_occupied_spot_not_allowed() {
        chessboard.addPiece(queen);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5")));
        assertFalse(queen.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void move_to_enemy_spot() {
        chessboard.addPiece(queen);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("d3")));
        assertTrue(queen.canMove(chessboard, new Coordinates("d3")));
    }

    @Test
    public void take_King_not_allowed() {
        chessboard.addPiece(queen);
        chessboard.addPiece(new King(PieceType.KING, Player.BLACK, new Coordinates("g4")));
        assertFalse(queen.canMove(chessboard, new Coordinates("g4")));
    }
}

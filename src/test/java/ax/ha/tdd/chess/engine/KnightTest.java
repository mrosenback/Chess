package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.Knight;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    Chessboard chessboard;
    Knight knight = new Knight(PieceType.KNIGHT, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void Knight_move_to_allowed_spot() {
        chessboard.addPiece(knight);
        assertTrue(knight.canMove(chessboard, new Coordinates("e6")));
    }

    @Test
    public void Knight_move_straight_not_allowed() {
        chessboard.addPiece(knight);
        assertFalse(knight.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void Knight_move_over_another() {
        chessboard.addPiece(knight);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5")));
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d6")));
        assertTrue(knight.canMove(chessboard, new Coordinates("e6")));
    }

    @Test
    public void move_to_occupied_spot_not_allowed() {
        chessboard.addPiece(knight);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e6")));
        assertFalse(knight.canMove(chessboard, new Coordinates("e6")));
    }

    @Test
    public void move_to_enemy_spot() {
        chessboard.addPiece(knight);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("e6")));
        assertTrue(knight.canMove(chessboard, new Coordinates("e6")));
    }
}

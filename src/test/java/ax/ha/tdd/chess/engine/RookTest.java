package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.King;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
import ax.ha.tdd.chess.engine.pieces.type.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

    Chessboard chessboard;
    Rook rook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void Rook_move_forward() {
        chessboard.addPiece(rook);
        assertTrue(rook.canMove(chessboard,new Coordinates("d6")));
    }

    @Test
    public void Rook_move_backwards() {
        chessboard.addPiece(rook);
        assertTrue(rook.canMove(chessboard,new Coordinates("d2")));
    }

    @Test
    public void Rook_move_sideways() {
        chessboard.addPiece(rook);
        assertTrue(rook.canMove(chessboard,new Coordinates("f4")));
    }

    @Test
    public void move_to_occupied_spot_not_allowed() {
        chessboard.addPiece(rook);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5")));
        assertFalse(rook.canMove(chessboard,new Coordinates("d5")));
    }

    @Test
    public void move_to_enemy_spot() {
        chessboard.addPiece(rook);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("d5")));
        assertTrue(rook.canMove(chessboard,new Coordinates("d5")));
    }

    @Test
    public void move_over_another_not_allowed() {
        chessboard.addPiece(rook);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5")));
        assertFalse(rook.canMove(chessboard,new Coordinates("d6")));
    }

    @Test
    public void Rook_move_diagonally_not_allowed() {
        chessboard.addPiece(rook);
        assertFalse(rook.canMove(chessboard,new Coordinates("e5")));
    }

    @Test
    public void take_King_not_allowed() {
        chessboard.addPiece(rook);
        chessboard.addPiece(new King(PieceType.KING, Player.BLACK, new Coordinates("f4")));
        assertFalse(rook.canMove(chessboard, new Coordinates("f4")));
    }
}

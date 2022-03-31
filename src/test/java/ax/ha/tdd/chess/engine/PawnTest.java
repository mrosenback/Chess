package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.King;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    Chessboard chessboard;
    Pawn pawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d4"));

    @BeforeEach
    public void setUp() {
        chessboard = new Chessboard();
    }

    @Test
    public void Pawn_move_forward() {
        chessboard.addPiece(pawn);
        assertTrue(pawn.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void no_duplicate_with_move() {
        Coordinates coordinates = new Coordinates("d4");
        chessboard.addPiece(pawn);
        ChessPiece piece = chessboard.getPiece(coordinates);
        piece.updateLocation(new Coordinates("d5"));
        chessboard.updatePiece(piece, coordinates);
        assertNull(chessboard.getPiece(coordinates));
    }

    @Test
    public void Pawn_move_sideways_not_allowed() {
        chessboard.addPiece(pawn);
        assertFalse(pawn.canMove(chessboard, new Coordinates("e4")));
    }

    @Test
    public void Pawn_move_backwards_not_allowed() {
        chessboard.addPiece(pawn);
        assertFalse(pawn.canMove(chessboard, new Coordinates("d3")));
    }

    @Test
    public void two_steps_at_start() {
        Pawn pawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d2"));
        chessboard.addPiece(pawn);
        assertTrue(pawn.canMove(chessboard, new Coordinates("d4")));
    }

    @Test
    public void two_steps_after_start_not_allowed() {
        chessboard.addPiece(pawn);
        assertFalse(pawn.canMove(chessboard, new Coordinates("d6")));
    }

    @Test
    public void move_forward_to_occupied_spot_not_allowed() {
        chessboard.addPiece(pawn);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5")));
        assertFalse(pawn.canMove(chessboard, new Coordinates("d5")));
    }

    @Test
    public void move_diagonally_to_empty_spot_not_allowed() {
        chessboard.addPiece(pawn);
        assertFalse(pawn.canMove(chessboard, new Coordinates("e5")));
    }

    @Test
    public void move_diagonally_to_enemy_spot() {
        chessboard.addPiece(pawn);
        chessboard.addPiece(new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("e5")));
        assertTrue(pawn.canMove(chessboard, new Coordinates("e5")));
    }

    @Test
    public void move_freely_after_reaching_other_side() {
        Pawn pawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d8"));
        chessboard.addPiece(pawn);
        assertTrue(pawn.canMove(chessboard, new Coordinates("g5")));
    }

    @Test
    public void take_King_not_allowed() {
        chessboard.addPiece(pawn);
        chessboard.addPiece(new King(PieceType.KING, Player.BLACK, new Coordinates("e5")));
        assertFalse(pawn.canMove(chessboard, new Coordinates("e5")));
    }
}

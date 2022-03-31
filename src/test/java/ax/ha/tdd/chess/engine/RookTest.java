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

    @Test
    public void Rook_move_sideways() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a6");
        game.move("a1-a3");
        game.move("a6-a5");
        game.move("a3-d3");
        assertEquals(new Coordinates("d3"), chessPiece.getLocation());
        game.move("b7-b6");
        game.move("d3-b3");
        assertEquals(new Coordinates("b3"), chessPiece.getLocation());
    }

    @Test
    public void move_to_occupied_spot_not_allowed() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a1-a2");
        assertEquals(new Coordinates("a1"), chessPiece.getLocation());
    }

    @Test
    public void move_to_enemy_spot() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a6");
        game.move("a1-a3");
        game.move("a6-a5");
        game.move("a3-b3");
        game.move("h7-h6");
        game.move("b3-b7");
        assertEquals(new Coordinates("b7"), chessPiece.getLocation());
    }

    @Test
    public void move_over_another_not_allowed() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a1-a3");
        assertEquals(new Coordinates("a1"), chessPiece.getLocation());
    }

    @Test
    public void Rook_move_diagonally_not_allowed() {
        Coordinates coordinates = new Coordinates("a1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("a2-a4");
        game.move("a7-a6");
        game.move("a1-a3");
        game.move("a6-a5");
        game.move("a3-c5");
        assertEquals(new Coordinates("a3"), chessPiece.getLocation());
    }
}

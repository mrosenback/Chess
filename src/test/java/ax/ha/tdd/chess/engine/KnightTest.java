package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    Chessboard chessboard;
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        chessboard = game.getBoard();
    }

    @Test
    public void Knight_move_to_allowed_spot() {
        Coordinates coordinates = new Coordinates("b1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("b1-c3");
        assertEquals(new Coordinates("c3"), chessPiece.getLocation());
    }

    @Test
    public void Knight_move_straight_not_allowed() {
        Coordinates coordinates = new Coordinates("b1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("b1-b3");
        assertEquals(new Coordinates("b1"), chessPiece.getLocation());
    }

    @Test
    public void Knight_move_over_another() {
        Coordinates coordinates = new Coordinates("b1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("b1-c3");
        assertEquals(new Coordinates("c3"), chessPiece.getLocation());
    }

    @Test
    public void move_to_occupied_spot_not_allowed() {
        Coordinates coordinates = new Coordinates("b1");
        ChessPiece chessPiece = chessboard.getPiece(coordinates);
        game.move("b1-c3");
        game.move("a7-a6");
        game.move("c3-e2");
        assertEquals(new Coordinates("c3"), chessPiece.getLocation());
    }
}

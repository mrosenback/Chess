package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Pawn extends ChessPiece {
    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if (player.getSymbol().equals("W")) {
            if (destination.getY() < location.getY()) {
                return true;
            }
        } else if (player.getSymbol().equals("B")) {
            if (destination.getY() > location.getY()) {
                return true;
            }
        }
        return false;
    }
}

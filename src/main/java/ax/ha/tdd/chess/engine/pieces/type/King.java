package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class King extends ChessPiece {
    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        if (!chessboard.getPiece(location).getPlayer().equals(player)) {
            return false;
        }
        if (chessboard.getPiece(destination) != null) {
            return !chessboard.getPiece(destination).getPlayer().getSymbol().equals(player.getSymbol());
        }
        if (destination.getY() < location.getY()) {
            if (location.getY() - destination.getY() > 1) {
                return false;
            }
        }
        if (destination.getY() > location.getY()) {
            if (destination.getY() - location.getY() > 1) {
                return false;
            }
        }
        if (destination.getX() < location.getX()) {
            if (location.getX() - destination.getX() > 1) {
                return false;
            }
        }
        if (destination.getX() > location.getX()) {
            if (destination.getX() - location.getX() > 1) {
                return false;
            }
        }
        return true;
    }
}

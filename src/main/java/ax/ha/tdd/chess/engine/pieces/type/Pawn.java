package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.InvalidMovementException;
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
    public boolean canMove(Chessboard chessboard, Coordinates destination) throws InvalidMovementException {
        if (player.getSymbol().equals("W")) {
            if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                return false;
            }
            if (destination.getY() < location.getY()) {
                if (location.getY() - destination.getY() > 1) {
                    return location.getY() == 6;
                } if (destination.getX() != location.getX()) {
                    return chessboard.getPiece(destination) != null;
                }
                return chessboard.getPiece(destination) == null;
            }
        } else if (player.getSymbol().equals("B")) {
            if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                return false;
            }
            if (destination.getY() > location.getY()) {
                if (destination.getY() - location.getY() > 1) {
                    return location.getY() == 1;
                } if (destination.getX() != location.getX()) {
                    return chessboard.getPiece(destination) != null;
                }
                return chessboard.getPiece(destination) == null;
            }
        }
        throw new InvalidMovementException("Illegal move, try again");
    }
}

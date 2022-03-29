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
    public boolean canMove(Chessboard chessboard, Coordinates destination) {

        if (!chessboard.getPiece(location).getPromotion()) {
            if (player.getSymbol().equals("W")) {
                if (location.getY() == 0) {
                    chessboard.getPiece(location).setPromotion(true);
                }
                if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                    return false;
                }
                if (destination.getY() < location.getY()) {
                    if (location.getY() - destination.getY() > 1) {
                        if (location.getY() == 6 && location.getY() - destination.getY() < 3) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (destination.getX() != location.getX()) {
                        if (chessboard.getPiece(destination) != null) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (chessboard.getPiece(destination) == null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else if (player.getSymbol().equals("B")) {
                if (location.getY() == 7) {
                    chessboard.getPiece(location).setPromotion(true);
                }
                if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                    return false;
                }
                if (destination.getY() > location.getY()) {
                    if (destination.getY() - location.getY() > 1) {
                        if (location.getY() == 1 && destination.getY() - location.getY() < 3) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (destination.getX() != location.getX()) {
                        if (chessboard.getPiece(destination) != null) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (chessboard.getPiece(destination) == null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (chessboard.getPiece(location).getPromotion()){
            return true;
        }
        return false;
    }
}

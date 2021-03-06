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

        if (!chessboard.getPiece(location).getPromotion()) {
            if (player == Player.WHITE) {
                if (location.getY() == 0) {
                    chessboard.getPiece(location).setPromotion(true);
                }
                if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                    return false;
                }
                if (destination.getY() < location.getY()) {
                    if (location.getY() - destination.getY() > 1) {
                        return location.getY() == 6 && location.getY() - destination.getY() < 3;
                    }
                    if (destination.getX() != location.getX()) {
                        if (chessboard.getPiece(destination) != null) {
                            return chessboard.getPiece(destination).getPieceType() != PieceType.KING;
                        }
                        if (chessboard.getPiece(destination) == null) {
                            return false;
                        }
                    }
                    return chessboard.getPiece(destination) == null;
                }
            } else if (player == Player.BLACK) {
                if (location.getY() == 7) {
                    chessboard.getPiece(location).setPromotion(true);
                }
                if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                    return false;
                }
                if (destination.getY() > location.getY()) {
                    if (destination.getY() - location.getY() > 1) {
                        return location.getY() == 1 && destination.getY() - location.getY() < 3;
                    }
                    if (destination.getX() != location.getX()) {
                        if (chessboard.getPiece(destination) != null) {
                            return chessboard.getPiece(destination).getPieceType() != PieceType.KING;
                        }
                        if (chessboard.getPiece(destination) == null) {
                            return false;
                        }
                    }
                    return chessboard.getPiece(destination) == null;
                }
            }
        }
        return chessboard.getPiece(location).getPromotion();
    }
}

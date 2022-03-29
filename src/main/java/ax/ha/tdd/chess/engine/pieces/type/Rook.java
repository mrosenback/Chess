package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.InvalidMovementException;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Rook extends ChessPiece {
    public Rook(PieceType pieceType, Player player, Coordinates location) {
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
        if (location.getY() != destination.getY() && location.getX() != destination.getX()) {
            return false;
        }
        if (chessboard.getPiece(destination) != null) {
            return !chessboard.getPiece(destination).getPlayer().getSymbol().equals(player.getSymbol());
        }
        if (chessboard.getPiece(destination) == null) {
            int counter;

            if (location.getY() != destination.getY()) {
                if (location.getY() < destination.getY()) {
                    counter = 1;
                } else {
                    counter = -1;
                }

                for (int i = location.getY() + counter; i != destination.getY(); i += counter) {
                    if (chessboard.getPiece(new Coordinates(location.getX(), i)) != null) {
                        return false;
                    }
                }
            }
            if (location.getX() != destination.getX()) {
                if (location.getX() < destination.getX()) {
                    counter = 1;
                } else {
                    counter = -1;
                }

                for (int i = location.getX() + counter; i != destination.getX(); i += counter) {
                    if (chessboard.getPiece(new Coordinates(i, location.getY())) != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

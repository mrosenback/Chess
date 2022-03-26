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
    public boolean canMove(Chessboard chessboard, Coordinates destination) throws InvalidMovementException {
        if (player.getSymbol().equals("W")) {
            if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                return false;
            } if (chessboard.getPiece(destination) != null) {
                if (!chessboard.getPiece(destination).getPlayer().getSymbol().equals(player.getSymbol())) {
                    return true;
                }
            }
            return chessboard.getPiece(destination) == null;
        } else if (player.getSymbol().equals("B")) {
            if (!chessboard.getPiece(location).getPlayer().equals(player)) {
                return false;
            } if (chessboard.getPiece(destination) != null) {
                if (!chessboard.getPiece(destination).getPlayer().getSymbol().equals(player.getSymbol())) {
                    return true;
                }
            }
            return chessboard.getPiece(destination) == null;
        }
        throw new InvalidMovementException("Illegal move, try again");
    }
}

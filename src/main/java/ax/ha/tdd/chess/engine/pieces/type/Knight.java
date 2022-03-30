package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Knight extends ChessPiece {
    public Knight(PieceType pieceType, Player player, Coordinates location) {
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
        if (destination.getY() == location.getY()-2 || destination.getY() == location.getY()+2) {
            return destination.getX() == location.getX() + 1 || destination.getX() == location.getX() - 1;
        }
        if (destination.getX() == location.getX()-2 || destination.getX() == location.getX()+2) {
            return destination.getY() == location.getY()+1 || destination.getY() == location.getY()-1;
        }
        return false;
    }
}

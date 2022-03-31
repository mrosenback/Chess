package ax.ha.tdd.chess.engine.pieces.type;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Bishop extends ChessPiece {
    public Bishop(PieceType pieceType, Player player, Coordinates location) {
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
        if (location.getY() == destination.getY() || location.getX() == destination.getX()) {
            return false;
        }
        if(Math.abs(destination.getY() - location.getY()) != Math.abs(destination.getX() - location.getX())){
            return false;
        }

        int xCounter, yCounter;

        if (location.getX() < destination.getX()){
            xCounter = 1;
        } else {
            xCounter = -1;
        }

        if (location.getY() < destination.getY()){
            yCounter = 1;
        } else {
            yCounter = -1;
        }

        int y = location.getY() + yCounter;
        for (int x = location.getX() + xCounter; x != destination.getX(); x += xCounter){

            if (chessboard.getPiece(new Coordinates(x,y)) != null){
                return false;
            }

            y += yCounter;
        }
        return true;
    }
}

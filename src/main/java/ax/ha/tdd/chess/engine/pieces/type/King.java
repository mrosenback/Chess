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

        Coordinates coordinates;
        ChessPiece piece;

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                coordinates = new Coordinates(x,y);
                piece = chessboard.getPiece(coordinates);
                if (piece != null) {
                    if (piece.getPlayer() != player) {
                        if (piece.getPieceType() == PieceType.PAWN) {
                            chessboard.addPiece(new Pawn(PieceType.PAWN, player, destination));
                            if (new Pawn(PieceType.PAWN, piece.getPlayer(), coordinates).canMove(chessboard, destination)) {
                                chessboard.deletePiece(destination);
                                return false;
                            }
                        }
                        if (piece.getPieceType() == PieceType.ROOK) {
                            if (new Rook(PieceType.ROOK, piece.getPlayer(), coordinates).canMove(chessboard, destination)) {
                                return false;
                            }
                        }
                        if (piece.getPieceType() == PieceType.KNIGHT) {
                            if (new Knight(PieceType.KNIGHT, piece.getPlayer(), coordinates).canMove(chessboard, destination)) {
                                return false;
                            }
                        }
                        if (piece.getPieceType() == PieceType.BISHOP) {
                            if (new Bishop(PieceType.BISHOP, piece.getPlayer(), coordinates).canMove(chessboard, destination)) {
                                return false;
                            }
                        }
                        if (piece.getPieceType() == PieceType.QUEEN) {
                            if (new Queen(PieceType.QUEEN, piece.getPlayer(), coordinates).canMove(chessboard, destination)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

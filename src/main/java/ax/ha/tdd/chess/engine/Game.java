package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.type.Pawn;

public class Game {

    Chessboard board = Chessboard.startingBoard();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;
    boolean validMove = true;
    boolean playerWhite = true;

    public Player getPlayerToMove() {
        if (playerWhite) {
            return Player.WHITE;
        } else {
            return Player.BLACK;
        }
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        if (isNewGame) {
            return "Game hasn't begun";
        } if (validMove) {
            return "Last move was successful";
        }
        return "Illegal move, try again";
    }

    public void move(String move) {
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
        int currentX = 0;
        int currentY = 0;
        int newX = 0;
        int newY = 0;

        for (int i = 0; i < move.length(); i++) {
            if (i == 0) {
                currentX = letterToInteger(move.charAt(i));
            } if (i == 1) {
                currentY = integerConvert(move.charAt(i));
            } if (i == 3) {
                newX = letterToInteger(move.charAt(i));
            } if (i == 4) {
                newY = integerConvert(move.charAt(i));
            }
        }

        Coordinates currentLocation = new Coordinates(currentX, currentY);
        Coordinates newLocation = new Coordinates(newX, newY);
        ChessPiece piece = board.getPiece(currentLocation);

        try {
            if (new Pawn(piece.getPieceType(), getPlayerToMove(), currentLocation).canMove(board, newLocation)) {
                validMove = true;
                playerWhite = !playerWhite;
                piece.updateLocation(newLocation);
                board.updatePiece(piece, currentLocation);
            } else {
                validMove = false;
            }
        } catch (InvalidMovementException e) {
            System.out.println(e);
        }

    }



    public int letterToInteger(char n) {
        if (n == 'a') {
            return 0;
        } if (n == 'b') {
            return 1;
        } if (n == 'c') {
            return 2;
        } if (n == 'd') {
            return 3;
        } if (n == 'e') {
            return 4;
        } if (n == 'f') {
            return 5;
        } if (n == 'g') {
            return 6;
        } if (n == 'h') {
            return 7;
        } else {
            return 0;
        }
    }

    public int integerConvert(char n) {
        if (n == '1') {
            return 7;
        } if (n == '2') {
            return 6;
        } if (n == '3') {
            return 5;
        } if (n == '4') {
            return 4;
        } if (n == '5') {
            return 3;
        } if (n == '6') {
            return 2;
        } if (n == '7') {
            return 1;
        } else {
            return 0;
        }
    }
}

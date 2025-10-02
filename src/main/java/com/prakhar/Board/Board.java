package com.prakhar.Board;

import com.prakhar.Enums.Color;
import com.prakhar.Enums.PieceType;
import com.prakhar.Piece.Piece;
import com.prakhar.Piece.PieceFactory;
import com.prakhar.Sqaure.Square;

public class Board {
    private static Board instance;
    private final Piece[][] board;

    private Board(){
        board = new Piece[8][8];
        initialize();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private void initialize() {

        for(int i=0;i<8;i++){
            // Pawns
            board[1][i]= PieceFactory.createPiece(PieceType.PAWN,Color.WHITE);
            board[6][i]= PieceFactory.createPiece(PieceType.PAWN,Color.BLACK);
        }

        //Rooks
        board[0][0] = PieceFactory.createPiece(PieceType.ROOK, Color.WHITE);
        board[0][7] = PieceFactory.createPiece(PieceType.ROOK, Color.WHITE);
        board[7][0] = PieceFactory.createPiece(PieceType.ROOK, Color.BLACK);
        board[7][7] = PieceFactory.createPiece(PieceType.ROOK, Color.BLACK);

        //Knights
        board[0][1] = PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE);
        board[0][6] = PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE);
        board[7][1] = PieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK);
        board[7][6] = PieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK);

        // Bishops
        board[0][2] = PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE);
        board[0][5] = PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE);
        board[7][2] = PieceFactory.createPiece(PieceType.BISHOP, Color.BLACK);
        board[7][5] = PieceFactory.createPiece(PieceType.BISHOP, Color.BLACK);

        // Queens
        board[0][3] = PieceFactory.createPiece(PieceType.QUEEN, Color.WHITE);
        board[7][3] = PieceFactory.createPiece(PieceType.QUEEN, Color.BLACK);

        // Kings
        board[0][4] = PieceFactory.createPiece(PieceType.KING, Color.WHITE);
        board[7][4] = PieceFactory.createPiece(PieceType.KING, Color.BLACK);
    }

    public Piece getPiece(Square square){
        return board[square.getRow()][square.getCol()];
    }

    public void setPiece(Square square, Piece piece){
        board[square.getRow()][square.getCol()] = piece;
    }

    public boolean isInside(Square square) {
        return square.getRow() >= 0 && square.getRow() < 8 &&
               square.getCol() >= 0 && square.getCol() < 8;
    }
    
    public void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        System.out.println("  ---------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null) {
                    // Print a dot for empty square with alternating colors
                    if ((i + j) % 2 == 0) {
                        System.out.print("· ");
                    } else {
                        System.out.print(". ");
                    }
                } else {
                    // Use different characters for different pieces
                    char pieceChar;
                    switch (piece.getPieceType()) {
                        case KING:
                            pieceChar = 'K';
                            break;
                        case KNIGHT:
                            pieceChar = 'N'; // Using 'N' for Knight (common chess notation)
                            break;
                        default:
                            pieceChar = piece.getPieceType().toString().charAt(0);
                    }
                    
                    if (piece.getColor().toString().equals("WHITE")) {
                        System.out.print(pieceChar + " ");
                    } else {
                        System.out.print(Character.toLowerCase(pieceChar) + " ");
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("  ---------------");
    }
}


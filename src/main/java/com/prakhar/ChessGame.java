package com.prakhar;

import java.util.*;
import java.util.List;
import java.util.InputMismatchException;

import com.prakhar.Board.Board;
import com.prakhar.Enums.Color;
import com.prakhar.Piece.Piece;
import com.prakhar.Player.Player;
import com.prakhar.Sqaure.Square;

public class ChessGame {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Color currentTurn;

    public ChessGame(String whiteName, String blackName) {
        this.board = Board.getInstance();
        this.whitePlayer = new Player(whiteName, Color.WHITE);
        this.blackPlayer = new Player(blackName, Color.BLACK);
        this.currentTurn = Color.WHITE;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        
        // Print initial board state
        System.out.println("\nInitial Chess Board:");
        board.printBoard();
        
        while (true) {
            System.out.println("\n" + currentTurn + "'s turn.");
            
            // Select piece to move
            Square from = null;
            Piece piece = null;
            
            while (piece == null || piece.getColor() != currentTurn) {
                System.out.print("Enter position of piece to move (row col): ");
                try {
                    int fr = scanner.nextInt();
                    int fc = scanner.nextInt();
                    from = new Square(fr, fc);
                    
                    // Validate the square is on the board
                    if (!board.isInside(from)) {
                        System.out.println("Position is outside the board. Try again.");
                        continue;
                    }
                    
                    piece = board.getPiece(from);
                    
                    if (piece == null) {
                        System.out.println("No piece at that position. Try again.");
                    } else if (piece.getColor() != currentTurn) {
                        System.out.println("That's not your piece. Try again.");
                    } else {
                        // Show piece type and valid moves
                        System.out.println("Selected " + piece.getPieceType() + ". Valid moves:");
                        List<Square> validMoves = piece.getValidMoves(board, from);
                        if (validMoves.isEmpty()) {
                            System.out.println("No valid moves for this piece. Select another piece.");
                            piece = null;
                        } else {
                            for (Square move : validMoves) {
                                System.out.print(move + " ");
                            }
                            System.out.println();
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter row and column as numbers.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }
            
            // Select destination
            Square to = null;
            List<Square> validMoves = piece.getValidMoves(board, from);
            boolean validMove = false;
            
            while (!validMove) {
                System.out.print("Enter destination position (row col): ");
                try {
                    int tr = scanner.nextInt();
                    int tc = scanner.nextInt();
                    to = new Square(tr, tc);
                    
                    if (!board.isInside(to)) {
                        System.out.println("Destination is outside the board. Try again.");
                        continue;
                    }
                    
                    if (validMoves.contains(to)) {
                        validMove = true;
                    } else {
                        System.out.println("Invalid move. Try again or enter -1 -1 to select a different piece.");
                        
                        // Allow selecting a different piece
                        if (tr == -1 && tc == -1) {
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter row and column as numbers.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }
            
            // If user chose to select a different piece
            if (!validMove) {
                continue;
            }
            
            // Make the move
            board.setPiece(to, piece);
            board.setPiece(from, null);
            
            // Print updated board
            System.out.println("\nUpdated Chess Board:");
            board.printBoard();
            
            // Switch turns
            currentTurn = currentTurn.opposite();
        }
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame("Prakhar", "Gautam");
        game.play();
    }
}

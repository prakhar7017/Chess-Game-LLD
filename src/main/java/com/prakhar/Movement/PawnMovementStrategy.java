package com.prakhar.Movement;

import java.util.ArrayList;
import java.util.List;

import com.prakhar.Enums.Color;
import com.prakhar.Piece.Piece;
import com.prakhar.Sqaure.Square;
import com.prakhar.Board.Board;

public class PawnMovementStrategy implements MovementStrategy {
    @Override
    public List<Square> getValidMoves(Board board, Square from, Piece piece){
        List<Square> moves = new ArrayList<>();
        int dir = (piece.getColor() == Color.WHITE) ? 1 : -1;
        int row = from.getRow();;
        int col = from.getCol();

        // 1. Forward move 
        Square forward = new Square(row+dir, col);
        if(board.isInside(forward) && board.getPiece(forward)==null){
            moves.add(forward);

            // 2 forward move
            if((piece.getColor() == Color.WHITE && row==1) || (piece.getColor() == Color.BLACK && row==6)){

                Square twoStep = new Square(row+2*dir, col);
                if(board.isInside(twoStep) && board.getPiece(twoStep)==null){
                    moves.add(twoStep);
                }
            }
        }

        // capture diagonals
        int[] dy= {-1,1};
        for(int d: dy){
            Square diag = new Square(row+dir, col+d);
            if(board.isInside(diag)){
                Piece target = board.getPiece(diag);
                if(target!=null && target.getColor()!=piece.getColor()){
                    moves.add(diag);
                }
            }
        }
        return moves;
    }
}

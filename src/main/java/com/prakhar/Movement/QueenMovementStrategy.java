package com.prakhar.Movement;

import java.util.ArrayList;
import java.util.List;

import com.prakhar.Piece.Piece;
import com.prakhar.Sqaure.Square;
import com.prakhar.Board.Board;

public class QueenMovementStrategy implements MovementStrategy {
    public static final int[][] Directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // vertical & horizontal
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // diagonals
    };

    @Override
    public List<Square> getValidMoves(Board board, Square from, Piece piece) {
        List<Square> moves = new ArrayList<>();
        for(int[] direction:Directions){
            int row = from.getRow();
            int col = from.getCol();
            while(true){ // continue moving in direction
                row+=direction[0];
                col+=direction[1];
                Square nextSquare = new Square(row,col);
                if(!board.isInside(nextSquare)) break;

                Piece target = board.getPiece(nextSquare);

                if(target!=null){
                    // enemy piece is captured
                    if(target.getColor()!=piece.getColor()){
                        moves.add(nextSquare);
                    }
                    break; // stop after hitting any piece
                }else{
                    moves.add(nextSquare);
                }
            }
        }
        return moves;
    }
}

package com.prakhar.Movement;

import java.util.ArrayList;
import java.util.List;

import com.prakhar.Enums.Color;
import com.prakhar.Piece.Piece;
import com.prakhar.Sqaure.Square;
import com.prakhar.Board.Board;

public class BishopMovementStrategy implements MovementStrategy {
    public static final int[][] Directions = {
        {-1,-1},// up-left
        {-1,1}, // up-right
        {1,-1}, // down-left
        {1,1} // down-right
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

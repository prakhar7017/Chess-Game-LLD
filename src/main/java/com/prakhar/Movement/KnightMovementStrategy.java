package com.prakhar.Movement;

import java.util.ArrayList;
import java.util.List;

import com.prakhar.Piece.Piece;
import com.prakhar.Sqaure.Square;
import com.prakhar.Board.Board;

public class KnightMovementStrategy implements MovementStrategy {
    public static final int[][] Directions = {
        {-2, -1}, {-2, 1},  // up-left, up-right
        {-1, -2}, {-1, 2},  // left-up, right-up
        {1, -2},  {1, 2},   // left-down, right-down
        {2, -1},  {2, 1}    // down-left, down-right

    };

    @Override
    public List<Square> getValidMoves(Board board, Square from, Piece piece) {
        List<Square> moves = new ArrayList<>();
        int row = from.getRow();
        int col = from.getCol();
        for(int[] direction:Directions){
            int new_row=row+direction[0];
            int new_col=col+direction[1];
            Square nextSquare = new Square(new_row,new_col);
            if(!board.isInside(nextSquare)) continue;

            Piece target = board.getPiece(nextSquare);

            if (target == null || target.getColor() != piece.getColor()) {
                moves.add(nextSquare); // empty or enemy → valid
            }
        }
        return moves;
    }
}

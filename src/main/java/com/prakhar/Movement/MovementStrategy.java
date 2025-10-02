package com.prakhar.Movement;

import java.util.List;

import com.prakhar.Board.Board;
import com.prakhar.Piece.Piece;
import com.prakhar.Sqaure.Square;

public interface MovementStrategy {
    List<Square> getValidMoves(Board board, Square from , Piece piece);
}

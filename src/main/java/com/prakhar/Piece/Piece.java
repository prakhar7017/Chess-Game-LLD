package com.prakhar.Piece;

import java.util.List;

import com.prakhar.Board.Board;
import com.prakhar.Enums.Color;
import com.prakhar.Enums.PieceType;
import com.prakhar.Movement.MovementStrategy;
import com.prakhar.Sqaure.Square;

public class Piece {
    private final Color color;
    private final PieceType pieceType;
    private boolean isKilled;
    private MovementStrategy movementStrategy;

    public Piece(Color color,PieceType pieceType,MovementStrategy movementStrategy){
        this.color=color;
        this.pieceType=pieceType;
        this.movementStrategy=movementStrategy;
        this.isKilled = false;
    }

    public boolean isKilled() {
        return this.isKilled;
    }

    public Color getColor(){
        return this.color;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public void setKilled(boolean killed){
        this.isKilled=killed;
    }

    public MovementStrategy getMovementStrategy(){
        return this.movementStrategy;
    }
    
    public void setMovementStrategy(MovementStrategy strategy){
        this.movementStrategy=strategy;
    }

    public List<Square> getValidMoves(Board board, Square from){
        return movementStrategy.getValidMoves(board, from, this);
    }

    @Override
    public String toString() {
        return color + " " + pieceType;
    }
}

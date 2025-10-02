package com.prakhar.Piece;

import com.prakhar.Enums.Color;
import com.prakhar.Enums.PieceType;
import com.prakhar.Movement.BishopMovementStrategy;
import com.prakhar.Movement.KingMovementStrategy;
import com.prakhar.Movement.KnightMovementStrategy;
import com.prakhar.Movement.PawnMovementStrategy;
import com.prakhar.Movement.QueenMovementStrategy;
import com.prakhar.Movement.RookMovementStrategy;

public class PieceFactory {
    public static Piece createPiece(PieceType pieceType, Color color){
        switch (pieceType){
            case PAWN: return new Piece(color, pieceType, new PawnMovementStrategy());
            case KING: return new Piece(color, pieceType, new KingMovementStrategy());
            case QUEEN: return new Piece(color, pieceType, new QueenMovementStrategy());
            case BISHOP: return new Piece(color, pieceType, new BishopMovementStrategy());
            case ROOK: return new Piece(color, pieceType, new RookMovementStrategy());
            case KNIGHT: return new Piece(color, pieceType, new KnightMovementStrategy());
            default: throw new IllegalArgumentException("Unknown Piece");
        }
    }
}

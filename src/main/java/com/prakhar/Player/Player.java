package com.prakhar.Player;

import com.prakhar.Enums.Color;

public class Player {
    private String name;
    private Color color;

    public Player(String name,Color color){
        this.name=name;
        this.color=color;
    }

    public String getPlayerName(){
        return this.name;
    }

    public Color getPlayerColor(){
        return this.color;
    }
}

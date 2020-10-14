package com.ewer.mariokartcharacterrandomizer;

public class Character {
    String character;

    public Character() {
        this.character = "";
    }

    public Character(String character) {
        this.character = character;
    }

    String getCharacter() {
        return this.character;
    }

    void setCharacter(String character) {
        this.character = character;
    }
}

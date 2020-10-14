package com.ewer.mariokartcharacterrandomizer;

public class RandomBuild {
    String character;
    String frame;
    String wheels;
    String glider;

    public RandomBuild() {
        character = "";
        frame = "";
        wheels = "";
        glider = "";
    }
    public RandomBuild(String character, String frame, String wheels, String glider) {
        this.character = character;
        this.frame = frame;
        this.wheels = wheels;
        this.glider = glider;
    }

    public String getCharacter() {
        return this.character;
    }
    public String getFrame() {
        return this.frame;
    }
    public String getWheels() {
        return this.wheels;
    }
    public String getGlider() {
        return this.glider;
    }

    void setCharacter(String character) {
        this.character = character;
    }
    void setFrame(String frame) {
        this.frame = frame;
    }
    void setWheels(String wheels) {
        this.wheels = wheels;
    }
    void setGlider(String glider) {
        this.glider = glider;
    }
}

package com.ewer.mariokartcharacterrandomizer;

public class RandomBuild {
    private String character;
    private String frame;
    private String wheels;
    private String glider;

    public RandomBuild() {
        this.character = "";
        this.frame = "";
        this.wheels = "";
        this.glider = "";
    }
    public RandomBuild(String character, String frame, String wheels, String glider) {
        this.character = character;
        this.frame = frame;
        this.wheels = wheels;
        this.glider = glider;
    }

    public String getCharacter() {
        return character;
    }
    public String getFrame() {
        return frame;
    }
    public String getWheels() {
        return wheels;
    }
    public String getGlider() {
        return glider;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
    public void setFrame(String frame) {
        this.frame = frame;
    }
    public void setWheels(String wheels) {
        this.wheels = wheels;
    }
    public void setGlider(String glider) {
        this.glider = glider;
    }
}

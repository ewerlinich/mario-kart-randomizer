package com.ewer.mariokartcharacterrandomizer;

public class RandomBuild {
    Character character;
    Frame frame;
    Wheels wheels;
    Glider glider;

    public RandomBuild() {
        this.character = new Character();
        this.frame = new Frame();
        this.wheels = new Wheels();
        this.glider = new Glider();
    }
    public RandomBuild(String character, String frame, String wheels, String glider) {
        this.character = new Character(character);
        this.frame = new Frame(frame);
        this.wheels = new Wheels(wheels);
        this.glider = new Glider(glider);
    }

    public String getCharacter() {
        return character.getCharacter();
    }
    public String getFrame() {
        return frame.getFrame();
    }
    public String getWheels() {
        return wheels.getWheels();
    }
    public String getGlider() {
        return glider.getGlider();
    }

    public void setCharacter(String character) {
        this.character.setCharacter(character);
    }
    public void setFrame(String frame) {
        this.frame.setFrame(frame);
    }
    public void setWheels(String wheels) {
        this.wheels.setWheels(wheels);
    }
    public void setGlider(String glider) {
        this.glider.setGlider(glider);
    }
}

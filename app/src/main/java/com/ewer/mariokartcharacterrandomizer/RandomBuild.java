package com.ewer.mariokartcharacterrandomizer;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

public class RandomBuild {
    private String character;
    private String frame;
    private String tires;
    private String glider;

    public RandomBuild(String character, String frame, String tires, String glider) {
        this.character = character;
        this.frame = frame;
        this.tires = tires;
        this.glider = glider;
    }

    public String getCharacter() {
        return character;
    }
    public String getFrame() {
        return frame;
    }
    public String getTires() {
        return tires;
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
    public void setTires(String tires) {
        this.tires = tires;
    }
    public void setGlider(String glider) {
        this.glider = glider;
    }
}

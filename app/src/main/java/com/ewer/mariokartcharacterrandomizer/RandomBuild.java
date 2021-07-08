package com.ewer.mariokartcharacterrandomizer;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

public class RandomBuild implements Parcelable {
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

    public RandomBuild(Parcel source) {
        character = source.readString();
        frame = source.readString();
        tires = source.readString();
        glider = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(character);
        dest.writeString(frame);
        dest.writeString(tires);
        dest.writeString(glider);
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

    public static final Creator<RandomBuild> CREATOR = new Creator<RandomBuild>() {
        @Override
        public RandomBuild[] newArray(int size) {
            return new RandomBuild[size];
        }

        @Override
        public RandomBuild createFromParcel(Parcel source) {
            return new RandomBuild(source);
        }
    };

    public void saveBuild() {

    }
}

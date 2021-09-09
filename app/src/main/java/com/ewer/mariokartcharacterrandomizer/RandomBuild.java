package com.ewer.mariokartcharacterrandomizer;

public class RandomBuild {
    // the plain strings of each part
    private String character;
    private String frame;
    private String tires;
    private String glider;
    // the int locations of each String in the resource values
    private int characterStringTag;
    private int frameStringTag;
    private int tiresStringTag;
    private int gliderStringTag;

    public RandomBuild(String character, String frame, String tires, String glider) {
        this.character = character;
        this.frame = frame;
        this.tires = tires;
        this.glider = glider;

        setCharacterStringTag(this.character);
        setFrameStringTag(this.frame);
        setTiresStringTag(this.tires);
        setGliderStringTag(this.glider);
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }

    public String getGlider() {
        return glider;
    }

    public void setGlider(String glider) {
        this.glider = glider;
    }

    public int getCharacterStringTag() {
        return characterStringTag;
    }

    public void setCharacterStringTag(String character) {
        switch (character) {
            case "Baby Daisy":
                characterStringTag = R.string.baby_daisy;
                break;
            case "Baby Luigi":
                characterStringTag = R.string.baby_luigi;
                break;
            case "Baby Mario":
                characterStringTag = R.string.baby_mario;
                break;
            case "Baby Peach":
                characterStringTag = R.string.baby_peach;
                break;
            case "Baby Rosalina":
                characterStringTag = R.string.baby_rosalina;
                break;
            case "Bowser":
                characterStringTag = R.string.bowser;
                break;
            case "Bowser Jr.":
                characterStringTag = R.string.bowser_jr;
                break;
            case "Cat Peach":
                characterStringTag = R.string.cat_peach;
                break;
            case "Daisy":
                characterStringTag = R.string.daisy;
                break;
            case "Donkey Kong":
                characterStringTag = R.string.donkey_kong;
                break;
            case "Dry Bones":
                characterStringTag = R.string.dry_bones;
                break;
            case "Dry Bowser":
                characterStringTag = R.string.dry_bowser;
                break;
            case "Metal Mario (Gold)":
                characterStringTag = R.string.metal_mario_gold;
                break;
            case "Iggy":
                characterStringTag = R.string.iggy;
                break;
            case "Inkling Boy (Dark Blue)":
                characterStringTag = R.string.inkling_boy_darkblue;
                break;
            case "Inkling Boy (Light Blue)":
                characterStringTag = R.string.inkling_boy_lightblue;
                break;
            case "Inkling Boy (Purple)":
                characterStringTag = R.string.inkling_boy_purple;
                break;
            case "Inkling Girl (Green)":
                characterStringTag = R.string.inkling_girl_green;
                break;
            case "Inkling Girl (Orange)":
                characterStringTag = R.string.inkling_girl_orange;
                break;
            case "Inkling Girl (Pink)":
                characterStringTag = R.string.inkling_girl_pink;
                break;
            case "Isabelle":
                characterStringTag = R.string.isabelle;
                break;
            case "King Boo":
                characterStringTag = R.string.king_boo;
                break;
            case "Koopa Troopa":
                characterStringTag = R.string.koopa_troopa;
                break;
            case "Lakitu":
                characterStringTag = R.string.lakitu;
                break;
            case "Larry":
                characterStringTag = R.string.larry;
                break;
            case "Lemmy":
                characterStringTag = R.string.lemmy;
                break;
            case "Link (BOTW)":
                characterStringTag = R.string.link_botw;
                break;
            case "Link (Classic)":
                characterStringTag = R.string.link_classic;
                break;
            case "Ludwig":
                characterStringTag = R.string.ludwig;
                break;
            case "Luigi":
                characterStringTag = R.string.luigi;
                break;
            case "Mario":
                characterStringTag = R.string.mario;
                break;
            case "Metal Mario (Metal)":
                characterStringTag = R.string.metal_mario_metal;
                break;
            case "Mii":
                characterStringTag = R.string.mii;
                break;
            case "Morton":
                characterStringTag = R.string.morton;
                break;
            case "Peach":
                characterStringTag = R.string.peach;
                break;
            case "Pink Gold Peach":
                characterStringTag = R.string.pink_gold_peach;
                break;
            case "Rosalina":
                characterStringTag = R.string.rosalina;
                break;
            case "Roy":
                characterStringTag = R.string.roy;
                break;
            case "Shy Guy (Black)":
                characterStringTag = R.string.shy_guy_black;
                break;
            case "Shy Guy (Dark Blue)":
                characterStringTag = R.string.shy_guy_darkblue;
                break;
            case "Shy Guy (Green)":
                characterStringTag = R.string.shy_guy_green;
                break;
            case "Shy Guy (Light Blue)":
                characterStringTag = R.string.shy_guy_lightblue;
                break;
            case "Shy Guy (Orange)":
                characterStringTag = R.string.shy_guy_orange;
                break;
            case "Shy Guy (Pink)":
                characterStringTag = R.string.shy_guy_pink;
                break;
            case "Shy Guy (Red)":
                characterStringTag = R.string.shy_guy_red;
                break;
            case "Shy Guy (White)":
                characterStringTag = R.string.shy_guy_white;
                break;
            case "Shy Guy (Yellow)":
                characterStringTag = R.string.shy_guy_yellow;
                break;
            case "Tanooki Mario":
                characterStringTag = R.string.tanooki_mario;
                break;
            case "Toad":
                characterStringTag = R.string.toad;
                break;
            case "Toadette":
                characterStringTag = R.string.toadette;
                break;
            case "Villager Boy":
                characterStringTag = R.string.villager_boy;
                break;
            case "Villager Girl":
                characterStringTag = R.string.villager_girl;
                break;
            case "Waluigi":
                characterStringTag = R.string.waluigi;
                break;
            case "Wario":
                characterStringTag = R.string.wario;
                break;
            case "Wendy":
                characterStringTag = R.string.wendy;
                break;
            case "Yoshi (Black)":
                characterStringTag = R.string.yoshi_black;
                break;
            case "Yoshi (Dark Blue)":
                characterStringTag = R.string.yoshi_darkblue;
                break;
            case "Yoshi (Green)":
                characterStringTag = R.string.yoshi_green;
                break;
            case "Yoshi (Light Blue)":
                characterStringTag = R.string.yoshi_lightblue;
                break;
            case "Yoshi (Orange)":
                characterStringTag = R.string.yoshi_orange;
                break;
            case "Yoshi (Pink)":
                characterStringTag = R.string.yoshi_pink;
                break;
            case "Yoshi (Red)":
                characterStringTag = R.string.yoshi_red;
                break;
            case "Yoshi (White)":
                characterStringTag = R.string.yoshi_white;
                break;
            case "Yoshi (Yellow)":
                characterStringTag = R.string.yoshi_yellow;
                break;
            default:
                characterStringTag = R.string.default_error;
        }
    }

    public int getFrameStringTag() {
        return frameStringTag;
    }

    public void setFrameStringTag(String frame) {
        switch (frame) {
            case "Standard Kart":
                frameStringTag = R.string.standard_kart;
                break;
            case "Pipe Frame":
                frameStringTag = R.string.pipe_frame;
                break;
            case "Mach 8":
                frameStringTag = R.string.mach_8;
                break;
            case "Steel Driver":
                frameStringTag = R.string.steel_driver;
                break;
            case "Cat Cruiser":
                frameStringTag = R.string.cat_cruiser;
                break;
            case "Circuit Special":
                frameStringTag = R.string.circuit_special;
                break;
            case "Tri-Speeder":
                frameStringTag = R.string.trispeeder;
                break;
            case "Badwagon":
                frameStringTag = R.string.badwagon;
                break;
            case "Prancer":
                frameStringTag = R.string.prancer;
                break;
            case "Biddybuggy":
                frameStringTag = R.string.biddybuggy;
                break;
            case "Landship":
                frameStringTag = R.string.landship;
                break;
            case "Sneeker":
                frameStringTag = R.string.sneeker;
                break;
            case "Sports Coupe":
                frameStringTag = R.string.sports_coupe;
                break;
            case "Gold Standard":
                frameStringTag = R.string.gold_standard;
                break;
            case "GLA":
                frameStringTag = R.string.gla;
                break;
            case "W 25 Silver Arrow":
                frameStringTag = R.string.silver_arrow;
                break;
            case "300 SL Roadster":
                frameStringTag = R.string.roadster;
                break;
            case "Blue Falcon":
                frameStringTag = R.string.blue_falcon;
                break;
            case "Tanooki Kart":
                frameStringTag = R.string.tanooki_kart;
                break;
            case "B Dasher":
                frameStringTag = R.string.b_dasher;
                break;
            case "Streetle":
                frameStringTag = R.string.streetle;
                break;
            case "P-Wing":
                frameStringTag = R.string.p_wing;
                break;
            case "Koopa Clown":
                frameStringTag = R.string.koopa_clown;
                break;
            case "Standard Bike":
                frameStringTag = R.string.standard_bike;
                break;
            case "The Duke":
                frameStringTag = R.string.the_duke;
                break;
            case "Flame Rider":
                frameStringTag = R.string.flame_rider;
                break;
            case "Varmint":
                frameStringTag = R.string.varmint;
                break;
            case "Mr. Scooty":
                frameStringTag = R.string.mr_scooty;
                break;
            case "City Tripper":
                frameStringTag = R.string.city_tripper;
                break;
            case "Master Cycle Zero":
                frameStringTag = R.string.master_cycle_zero;
                break;
            case "Comet":
                frameStringTag = R.string.comet;
                break;
            case "Sports Bike":
                frameStringTag = R.string.sports_bike;
                break;
            case "Jet Bike":
                frameStringTag = R.string.jet_bike;
                break;
            case "Master Cycle":
                frameStringTag = R.string.master_cycle;
                break;
            case "Yoshi Bike":
                frameStringTag = R.string.yoshi_bike;
                break;
            case "Standard ATV":
                frameStringTag = R.string.standard_atv;
                break;
            case "Wild Wiggler":
                frameStringTag = R.string.wild_wiggler;
                break;
            case "Teddy Buggy":
                frameStringTag = R.string.teddy_buggy;
                break;
            case "Bone Rattler":
                frameStringTag = R.string.bone_rattler;
                break;
            case "Splat Buggy":
                frameStringTag = R.string.splat_buggy;
                break;
            case "Inkstriker":
                frameStringTag = R.string.inkstriker;
                break;
            default:
                frameStringTag = R.string.default_error;
        }
    }

    public int getTiresStringTag() {
        return tiresStringTag;
    }

    public void setTiresStringTag(String tires) {
        switch (tires) {
            case "Standard Tires":
                tiresStringTag = R.string.standard_tires;
                break;
            case "Monster Tires":
                tiresStringTag = R.string.monster_tires;
                break;
            case "Roller Tires":
                tiresStringTag = R.string.roller_tires;
                break;
            case "Slim Tires":
                tiresStringTag = R.string.slim_tires;
                break;
            case "Slick Tires":
                tiresStringTag = R.string.slick_tires;
                break;
            case "Metal Tires":
                tiresStringTag = R.string.metal_tires;
                break;
            case "Button Tires":
                tiresStringTag = R.string.button_tires;
                break;
            case "Off-Road Tires":
                tiresStringTag = R.string.off_road_tires;
                break;
            case "Sponge Tires":
                tiresStringTag = R.string.sponge_tires;
                break;
            case "Wood Tires":
                tiresStringTag = R.string.wood_tires;
                break;
            case "Cushion Tires":
                tiresStringTag = R.string.cushion_tires;
                break;
            case "Blue Standard Tires":
                tiresStringTag = R.string.blue_standard_tires;
                break;
            case "Hot Monster Tires":
                tiresStringTag = R.string.monster_tires_hot;
                break;
            case "Azure Roller Tires":
                tiresStringTag = R.string.roller_tires_azure;
                break;
            case "Crimson Slim Tires":
                tiresStringTag = R.string.slim_tires_crimson;
                break;
            case "Cyber Slick Tires":
                tiresStringTag = R.string.slick_tires_cyber;
                break;
            case "Retro Off-Road Tires":
                tiresStringTag = R.string.off_road_tires_retro;
                break;
            case "Gold Tires":
                tiresStringTag = R.string.gold_tires;
                break;
            case "GLA Tires":
                tiresStringTag = R.string.gla_tires;
                break;
            case "Triforce Tires":
                tiresStringTag = R.string.triforce_tires;
                break;
            case "Leaf Tires":
                tiresStringTag = R.string.leaf_tires;
                break;
            case "Ancient Tires":
                tiresStringTag = R.string.ancient_tires;
                break;
            default:
                tiresStringTag = R.string.default_error;
        }
    }

    public int getGliderStringTag() {
        return gliderStringTag;
    }

    public void setGliderStringTag(String glider) {
        switch (glider) {
            case "Super Glider":
                gliderStringTag = R.string.super_glider;
                break;
            case "Cloud Glider":
                gliderStringTag = R.string.cloud_glider;
                break;
            case "Wario Wing":
                gliderStringTag = R.string.wario_wing;
                break;
            case "Waddle Wing":
                gliderStringTag = R.string.waddle_wing;
                break;
            case "Peach Parasol":
                gliderStringTag = R.string.parasol;
                break;
            case "Parachute":
                gliderStringTag = R.string.parachute;
                break;
            case "Parafoil":
                gliderStringTag = R.string.parafoil;
                break;
            case "Flower Glider":
                gliderStringTag = R.string.flower_glider;
                break;
            case "Bowser Kite":
                gliderStringTag = R.string.bowser_kite;
                break;
            case "Plane Glider":
                gliderStringTag = R.string.plane_glider;
                break;
            case "MKTV Parafoil":
                gliderStringTag = R.string.parafoil_mktv;
                break;
            case "Gold Glider":
                gliderStringTag = R.string.gold_glider;
                break;
            case "Hylian Kite":
                gliderStringTag = R.string.hylian_kite;
                break;
            case "Paper Glider":
                gliderStringTag = R.string.paper_glider;
                break;
            case "Paraglider":
                gliderStringTag = R.string.paraglider;
                break;
            default:
                gliderStringTag = R.string.default_error;
        }
    }
}

package com.ewer.mariokartcharacterrandomizer;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

public class DisplayRandomBuilds extends AppCompatActivity {

    public static final String[] CHAR_LIGHT = {
            "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Baby Rosalina", "Lemmy",
            "Dry Bones", "Mii", "Koopa Troopa", "Lakitu", "Bowser Jr.", "Toadette", "Wendy",
            "Isabelle", "Toad", "Shy Guy", "Larry"};
    public static final String[] CHAR_MEDIUM = {
            "Cat Peach", "Inkling Girl", "Villager (G)", "Peach", "Daisy", "Yoshi", "Tanooki Mario",
            "Inkling (B)", "Villager (B)", "Luigi", "Iggy", "Mario", "Ludwig", "Mii"};
    public static final String[] CHAR_HEAVY = {
            "Rosalina", "King Boo", "Link", "Donkey Kong", "Waluigi", "Roy", "Wario", "Dry Bowser",
            "Metal Mario", "Rose Gold Peach", "Bowser", "Morton", "Mii"};
    public static final String[] CHAR_ALL = {
            "Mario", "Luigi", "Peach", "Daisy", "Rosalina", "Tanooki Mario", "Cat Peach", "Yoshi",
            "Toad", "Koopa Troopa", "Shy Guy", "Lakitu", "Toadette", "King Boo", "Baby Mario",
            "Baby Luigi", "Baby Peach", "Baby Daisy", "Baby Rosalina", "Metal Mario",
            "Pink Gold Peach", "Wario", "Waluigi", "Donkey Kong", "Bowser", "Dry Bones",
            "Bowser Jr.", "Dry Bowser", "Lemmy", "Larry", "Wendy", "Ludwig", "Iggy", "Roy",
            "Morton", "Inkling Girl", "Inkling Boy", "Link", "Villager (B)", "Villager (G)",
            "Isabelle", "Mii"};
    public static final String[] FRAME_BIKE = {
            "Standard Bike", "Comet", "Sport Bike", "The Duke", "Flame Rider", "Varmint",
            "Mr. Scooty", "Jet Bike", "Yoshi Bike", "Master Cycle", "City Tripper",
            "Master Cycle Zero"};
    public static final String[] FRAME_KART = {
            "Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
            "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship",
            "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow",
            "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing",
            "Koopa Clown", "Standard ATV", "Wild Wiggler", "Teddy Buggy", "Bone Rattler",
            "Splat Buggy", "Inkstriker"};
    public static final String[] FRAME_ALL = {
            "Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
            "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship",
            "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow",
            "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing",
            "Koopa Clown", "Standard Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty",
            "City Tripper", "Master Cycle Zero", "Comet", "Sports Bike", "Jet Bike", "Yoshi Bike",
            "Master Cycle", "Standard ATV", "Wild Wiggler", "Teddy Buggy", "Bone Rattler",
            "Splat Buggy", "Inkstriker"};
    public static final String[] TIRES_ALL = {
            "Standard Tires", "Monster Tires", "Roller Tires", "Slim Tires", "Slick Tires",
            "Metal Tires", "Button Tires", "Off-Road Tires", "Sponge Tires", "Wood Tires",
            "Cushion Tires", "Blue Standard Tires", "Hot Monster Tires", "Azure Roller Tires",
            "Crimson Slim Tires", "Cyber Slick Tires", "Retro Off-Road Tires", "Gold Tires",
            "GLA Tires", "Triforce Tires", "Leaf Tires", "Ancient Tires"};
    public static final String[] GLIDER_ALL = {
            "Super Glider", "Cloud Glider", "Wario Wing", "Waddle Wing", "Peach Parasol",
            "Parachute", "Parafoil", "Flower Glider", "Bowser Kite", "Plane Glider",
            "MKTV Parafoil", "Gold Glider", "Hylian Kite", "Paper Glider", "Paraglider"};

    private TableRow[] table_rows;
    private TextView[] text_arr;
    private RandomBuild[] build_arr;
    private int player_count;
    private String char_type;
    private String frame_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_builds);

        Intent intent = getIntent();
        player_count = intent.getIntExtra("PlayerNumber", 1);
        frame_type = intent.getStringExtra("FrameType");
        //obtain different values based on what button was pressed during MainActivity

        table_rows = new TableRow[player_count];
        // create the empty array of table rows. This will hold the horizontal LinearLayouts,
        // which will in turn hold the ImageViews of the players' builds

        text_arr = new TextView[player_count];
        // create the empty array of TextViews. These hold the player numbers for each build

        build_arr = new RandomBuild[player_count];
        // create the empty array of RandomBuilds.

        layoutInit();
        //initialize the layouts and random builds
    }

    /**
     * Create, generate, and deploy the array of texts and images to display the RandomBuilds
     */
    private void layoutInit() {
        LinearLayout parent_layout = findViewById(R.id.build_layout);
        // find the vertical LinearLayout that already exists in the XML. All of the following
        // views and layouts will be contained inside of this parent layout

        LinearLayout.LayoutParams linear_layout_params_text = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linear_layout_params_text.bottomMargin = 10;
        // the layout parameters for the horizontal layout params. the width matches the parent
        // so that all 4 images can fit, and wraps the height of the images vertically

        LinearLayout.LayoutParams linear_layout_params_row = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        linear_layout_params_row.bottomMargin = 40;
        // the layout parameters for the horizontal layout params. the width matches the parent
        // so that all 4 images can fit, and wraps the height of the images vertically

        TableRow.LayoutParams table_row_params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1);
        // the layout parameters for the horizontal table rows

        GradientDrawable border = new GradientDrawable();
        border.setStroke(4, 0xFF000000);
        border.setCornerRadius(60);

        for (int i = 0; i < player_count; i++) {
            text_arr[i] = new TextView(this);

            text_arr[i].setLayoutParams(linear_layout_params_text);
            text_arr[i].setGravity(Gravity.CENTER);
            text_arr[i].setTextSize(30f);
            text_arr[i].setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));
            //set common text attributes

            switch(i) {
                case 0:
                    text_arr[i].setText(R.string.player1caps);
                    break;
                case 1:
                    text_arr[i].setText(R.string.player2caps);
                    break;
                case 2:
                    text_arr[i].setText(R.string.player3caps);
                    break;
                case 3:
                    text_arr[i].setText(R.string.player4caps);
            }
            // set the correct player number based on which place in the array it is

            parent_layout.addView(text_arr[i]);
            // add the TextView to the parent LinearLayout

            table_rows[i] = new TableRow(this);
            table_rows[i].setLayoutParams(linear_layout_params_row);
            table_rows[i].setOrientation(LinearLayout.HORIZONTAL);
            // create the horizontal LinearLayouts

            build_arr[i] = createBuild();

            ImageView[] image_arr = new ImageView[4];

            for(int j = 0; j < 4; j++) {
                image_arr[j] = new ImageView(this);
                image_arr[j].setLayoutParams(table_row_params);

                int image = getImage(j, i);

                image_arr[j].setImageResource(image);
                image_arr[j].setTag(image);
                int finalJ = j;
                int finalI = i;
                image_arr[j].setOnClickListener(view -> {
                    TextView title = findViewById(R.id.part_name);
                    title.setText(getPartText(finalJ, finalI));
                });

                table_rows[i].addView(image_arr[j]);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                table_rows[i].setBackground(border);
            }  else {
                table_rows[i].setBackgroundDrawable(border);
            }

            parent_layout.addView(table_rows[i]);
            // add each player text and horizontal LinearLayout to the parent vertical LinearLayout
        }
    }

    /**
     * Create a full RandomBuild by randomly selecting one of each type of part
     * @return the created RandomBuild
     */
    private RandomBuild createBuild() {
        return new RandomBuild(randChar(), randFrame(), randTires(), randGlider());
    }

    /**
     * Obtain a random character from the list of characters. If the character that was chosen has
     * multiple color palettes, choose one randomly
     * @return the string of the character concatenated with the color pallete, if necessary
     */
    private String randChar() {
        int color;
        String randChar = CHAR_ALL[(int)(Math.random() * CHAR_ALL.length)];
        // get a random character from the list of all characters
        switch (randChar) {
            // certain characters have multiple different color palettes. They are not included in
            // the list of characters because that would interfere with the randomness of getting
            // each character
            case "Shy Guy":
            case "Yoshi":
                // these characters have the same color options
                color = (int) (Math.random() * 9);
                switch (color) {
                    case 0:
                        randChar = randChar.concat(" (Green)");
                        break;
                    case 1:
                        randChar = randChar.concat(" (Red)");
                        break;
                    case 2:
                        randChar = randChar.concat(" (Dark Blue)");
                        break;
                    case 3:
                        randChar = randChar.concat(" (Light Blue)");
                        break;
                    case 4:
                        randChar = randChar.concat(" (Yellow)");
                        break;
                    case 5:
                        randChar = randChar.concat(" (Pink)");
                        break;
                    case 6:
                        randChar = randChar.concat(" (Black)");
                        break;
                    case 7:
                        randChar = randChar.concat(" (White)");
                        break;
                    case 8:
                        randChar = randChar.concat(" (Orange)");
                        break;
                    default:
                        randChar = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Metal Mario":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    randChar = randChar.concat(" (Metal)");
                } else {
                    randChar = randChar.concat(" (Gold)");
                }
                break;
            case "Link":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    randChar = randChar.concat(" (Classic)");
                } else {
                    randChar = randChar.concat(" (BOTW)");
                }
                break;
            case "Inkling Girl":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        randChar = randChar.concat(" (Orange)");
                        break;
                    case 1:
                        randChar = randChar.concat(" (Green)");
                        break;
                    case 2:
                        randChar = randChar.concat(" (Pink)");
                        break;
                    default:
                        randChar = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Inkling Boy":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        randChar = randChar.concat(" (Dark Blue)");
                        break;
                    case 1:
                        randChar = randChar.concat(" (Purple)");
                        break;
                    case 2:
                        randChar = randChar.concat(" (Light Blue)");
                        break;
                    default:
                        randChar = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            default:
        }
        return randChar;
    }

    /**
     * Obtain a random frame from the chosen list of frames, depending on player choice
     * @return the string of the frame
     */
    private String randFrame() {
        switch(frame_type) {
            case "kart":
                return FRAME_KART[((int) (Math.random() * FRAME_KART.length))];
            case "bike":
                return FRAME_BIKE[((int) (Math.random() * FRAME_BIKE.length))];
            default:
                return FRAME_ALL[((int) (Math.random() * FRAME_ALL.length))];
        }
    }

    /**
     * Obtain a random set of tires from the list of tires. If the tires that were chosen have
     * multiple color palettes, choose one randomly
     * @return the string of the tires concatenated with the color pallete, if necessary
     */
    private String randTires() {
        int color;
        String tires = TIRES_ALL[(int) (Math.random() * TIRES_ALL.length)];
        // get random tires from the list of all tires
        switch (tires) {
            // color palettes are not in the base list because that would affect the randomness of
            // getting each type of wheel, so they are added
            case "Standard Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Blue ".concat(tires);
                }
                break;
            case "Roller Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Azure ".concat(tires);
                }
                break;
            case "Monster Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Hot ".concat(tires);
                }
                break;
            case "Slim Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Crimson ".concat(tires);
                }
                break;
            case "Off-Road Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Retro ".concat(tires);
                }
                break;
            case "Slick Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Cyber ".concat(tires);
                }
                break;
        }
        return tires;
    }

    /**
     * Obtain a random glider string from the list of gliders
     * @return the string that of the glider that was selected
     */
    private String randGlider() {
        return GLIDER_ALL[((int) (Math.random() * GLIDER_ALL.length))];  // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * Retrieve the ID of the image that correlates to the part in the respective RandomBuild
     * @param build_part the type of build part; 0 = character, 1 = frame, 2 = tires, 3 = glider
     * @param player the player number
     * @return the int ID of the image
     */
    private int getImage(int build_part, int player) {
        switch(build_part) {
            case 0:
                switch (build_arr[player].getCharacter()) {
                    case "Baby Daisy":
                        return R.drawable.baby_daisy;
                    case "Baby Luigi":
                        return R.drawable.baby_luigi;
                    case "Baby Mario":
                        return R.drawable.baby_mario;
                    case "Baby Peach":
                        return R.drawable.baby_peach;
                    case "Baby Rosalina":
                        return R.drawable.baby_rosalina;
                    case "Bowser":
                        return R.drawable.bowser;
                    case "Bowser Jr.":
                        return R.drawable.bowser_jr;
                    case "Cat Peach":
                        return R.drawable.cat_peach;
                    case "Daisy":
                        return R.drawable.daisy;
                    case "Donkey Kong":
                        return R.drawable.donkey_kong;
                    case "Dry Bones":
                        return R.drawable.dry_bones;
                    case "Dry Bowser":
                        return R.drawable.dry_bowser;
                    case "Metal Mario (Gold)":
                        return R.drawable.metal_mario_gold;
                    case "Iggy":
                        return R.drawable.iggy;
                    case "Inkling Boy (Dark Blue)":
                        return R.drawable.inkling_boy_darkblue;
                    case "Inkling Boy (Light Blue)":
                        return R.drawable.inkling_boy_lightblue;
                    case "Inkling Boy (Purple)":
                        return R.drawable.inkling_boy_purple;
                    case "Inkling Girl (Green)":
                        return R.drawable.inkling_girl_green;
                    case "Inkling Girl (Orange)":
                        return R.drawable.inkling_girl_orange;
                    case "Inkling Girl (Pink)":
                        return R.drawable.inkling_girl_pink;
                    case "Isabelle":
                        return R.drawable.isabelle;
                    case "King Boo":
                        return R.drawable.king_boo;
                    case "Koopa Troopa":
                        return R.drawable.koopa_troopa;
                    case "Lakitu":
                        return R.drawable.lakitu;
                    case "Larry":
                        return R.drawable.larry;
                    case "Lemmy":
                        return R.drawable.lemmy;
                    case "Link (BOTW)":
                        return R.drawable.link_botw;
                    case "Link (Classic)":
                        return R.drawable.link_classic;
                    case "Ludwig":
                        return R.drawable.ludwig;
                    case "Luigi":
                        return R.drawable.luigi;
                    case "Mario":
                        return R.drawable.mario;
                    case "Metal Mario (Metal)":
                        return R.drawable.metal_mario_metal;
                    case "Mii":
                        return R.drawable.mii;
                    case "Morton":
                        return R.drawable.morton;
                    case "Peach":
                        return R.drawable.peach;
                    case "Pink Gold Peach":
                        return R.drawable.pink_gold_peach;
                    case "Rosalina":
                        return R.drawable.rosalina;
                    case "Roy":
                        return R.drawable.roy;
                    case "Shy Guy (Black)":
                        return R.drawable.shyguy_black;
                    case "Shy Guy (Dark Blue)":
                        return R.drawable.shyguy_darkblue;
                    case "Shy Guy (Green)":
                        return R.drawable.shyguy_green;
                    case "Shy Guy (Light Blue)":
                        return R.drawable.shyguy_lightblue;
                    case "Shy Guy (Orange)":
                        return R.drawable.shyguy_orange;
                    case "Shy Guy (Pink)":
                        return R.drawable.shyguy_pink;
                    case "Shy Guy (Red)":
                        return R.drawable.shyguy_red;
                    case "Shy Guy (White)":
                        return R.drawable.shyguy_white;
                    case "Shy Guy (Yellow)":
                        return R.drawable.shyguy_yellow;
                    case "Tanooki Mario":
                        return R.drawable.tanooki_mario;
                    case "Toad":
                        return R.drawable.toad;
                    case "Toadette":
                        return R.drawable.toadette;
                    case "Villager (B)":
                        return R.drawable.villager_boy;
                    case "Villager (G)":
                        return R.drawable.villager_girl;
                    case "Waluigi":
                        return R.drawable.waluigi;
                    case "Wario":
                        return R.drawable.wario;
                    case "Wendy":
                        return R.drawable.wendy;
                    case "Yoshi (Black)":
                        return R.drawable.yoshi_black;
                    case "Yoshi (Dark Blue)":
                        return R.drawable.yoshi_darkblue;
                    case "Yoshi (Green)":
                        return R.drawable.yoshi_green;
                    case "Yoshi (Light Blue)":
                        return R.drawable.yoshi_lightblue;
                    case "Yoshi (Orange)":
                        return R.drawable.yoshi_orange;
                    case "Yoshi (Pink)":
                        return R.drawable.yoshi_pink;
                    case "Yoshi (Red)":
                        return R.drawable.yoshi_red;
                    case "Yoshi (White)":
                        return R.drawable.yoshi_white;
                    case "Yoshi (Yellow)":
                        return R.drawable.yoshi_yellow;
                    default:
                        return R.drawable.mario_kart_8_deluxe_mario_artwork;
                }
            case 1:
                switch (build_arr[player].getFrame()) {
                    case "Standard Kart":
                        return R.drawable.standard_kart;
                    case "Pipe Frame":
                        return R.drawable.pipe_frame;
                    case "Mach 8":
                        return R.drawable.mach_8;
                    case "Steel Driver":
                        return R.drawable.steel_driver;
                    case "Cat Cruiser":
                        return R.drawable.cat_cruiser;
                    case "Circuit Special":
                        return R.drawable.circuit_special;
                    case "Tri-Speeder":
                        return R.drawable.trispeeder;
                    case "Badwagon":
                        return R.drawable.badwagon;
                    case "Prancer":
                        return R.drawable.prancer;
                    case "Biddybuggy":
                        return R.drawable.biddybuggy;
                    case "Landship":
                        return R.drawable.landship;
                    case "Sneeker":
                        return R.drawable.sneeker;
                    case "Sports Coupe":
                        return R.drawable.sports_coupe;
                    case "Gold Standard":
                        return R.drawable.gold_standard;
                    case "GLA":
                        return R.drawable.gla;
                    case "W 25 Silver Arrow":
                        return R.drawable.silver_arrow;
                    case "300 SL Roadster":
                        return R.drawable.roadster;
                    case "Blue Falcon":
                        return R.drawable.blue_falcon;
                    case "Tanooki Kart":
                        return R.drawable.tanooki_kart;
                    case "B Dasher":
                        return R.drawable.b_dasher;
                    case "Streetle":
                        return R.drawable.streetle;
                    case "P-Wing":
                        return R.drawable.p_wing;
                    case "Koopa Clown":
                        return R.drawable.koopa_clown;
                    case "Standard Bike":
                        return R.drawable.standard_bike;
                    case "The Duke":
                        return R.drawable.the_duke;
                    case "Flame Rider":
                        return R.drawable.flame_rider;
                    case "Varmint":
                        return R.drawable.varmint;
                    case "Mr. Scooty":
                        return R.drawable.mr_scooty;
                    case "City Tripper":
                        return R.drawable.city_tripper;
                    case "Master Cycle Zero":
                        return R.drawable.master_cycle_zero;
                    case "Comet":
                        return R.drawable.comet;
                    case "Sports Bike":
                        return R.drawable.sports_bike;
                    case "Jet Bike":
                        return R.drawable.jet_bike;
                    case "Master Cycle":
                        return R.drawable.master_cycle;
                    case "Yoshi Bike":
                        return R.drawable.yoshi_bike;
                    case "Standard ATV":
                        return R.drawable.standard_atv;
                    case "Wild Wiggler":
                        return R.drawable.wild_wiggler;
                    case "Teddy Buggy":
                        return R.drawable.teddy_buggy;
                    case "Bone Rattler":
                        return R.drawable.bone_rattler;
                    case "Splat Buggy":
                        return R.drawable.splat_buggy;
                    case "Inkstriker":
                        return R.drawable.inkstriker;
                    default:
                        return R.drawable.mario_kart_8_deluxe_mario_artwork;
                }
            case 2:
                switch (build_arr[player].getTires()) {
                    case "Standard Tires":
                        return R.drawable.standard_tires;
                    case "Monster Tires":
                        return R.drawable.monster_tires;
                    case "Roller Tires":
                        return R.drawable.roller_tires;
                    case "Slim Tires":
                        return R.drawable.slim_tires;
                    case "Slick Tires":
                        return R.drawable.slick_tires;
                    case "Metal Tires":
                        return R.drawable.metal_tires;
                    case "Button Tires":
                        return R.drawable.button_tires;
                    case "Off-Road Tires":
                        return R.drawable.off_road_tires;
                    case "Sponge Tires":
                        return R.drawable.sponge_tires;
                    case "Wood Tires":
                        return R.drawable.wood_tires;
                    case "Cushion Tires":
                        return R.drawable.cushion_tires;
                    case "Blue Standard Tires":
                        return R.drawable.blue_standard_tires;
                    case "Hot Monster Tires":
                        return R.drawable.monster_tires_hot;
                    case "Azure Roller Tires":
                        return R.drawable.roller_tires_azure;
                    case "Crimson Slim Tires":
                        return R.drawable.slim_tires_crimson;
                    case "Cyber Slick Tires":
                        return R.drawable.slick_tires_cyber;
                    case "Retro Off-Road Tires":
                        return R.drawable.off_road_tires_retro;
                    case "Gold Tires":
                        return R.drawable.gold_tires;
                    case "GLA Tires":
                        return R.drawable.gla_tires;
                    case "Triforce Tires":
                        return R.drawable.triforce_tires;
                    case "Leaf Tires":
                        return R.drawable.leaf_tires;
                    case "Ancient Tires":
                        return R.drawable.ancient_tires;
                    default:
                        return R.drawable.mario_kart_8_deluxe_mario_artwork;
                }
            case 3:
                switch (build_arr[player].getGlider()) {
                    case "Super Glider":
                        return R.drawable.super_glider;
                    case "Cloud Glider":
                        return R.drawable.cloud_glider;
                    case "Wario Wing":
                        return R.drawable.wario_wing;
                    case "Waddle Wing":
                        return R.drawable.waddle_wing;
                    case "Peach Parasol":
                        return R.drawable.parasol;
                    case "Parachute":
                        return R.drawable.parachute;
                    case "Parafoil":
                        return R.drawable.parafoil;
                    case "Flower Glider":
                        return R.drawable.flower_glider;
                    case "Bowser Kite":
                        return R.drawable.bowser_kite;
                    case "Plane Glider":
                        return R.drawable.plane_glider;
                    case "MKTV Parafoil":
                        return R.drawable.parafoil_mktv;
                    case "Gold Glider":
                        return R.drawable.gold_glider;
                    case "Hylian Kite":
                        return R.drawable.hylian_kite;
                    case "Paper Glider":
                        return R.drawable.paper_glider;
                    case "Paraglider":
                        return R.drawable.paraglider;
                    default:
                        return R.drawable.mario_kart_8_deluxe_mario_artwork;
                }
            default:
                return R.drawable.mario_kart_8_deluxe_mario_artwork;
        }
    }

    /**
     * Retrieve the ID of the string that correlates to the part in the respective RandomBuild
     * @param build_part the type of build part; 0 = character, 1 = frame, 2 = tires, 3 = glider
     * @param player the player number
     * @return the int ID of the string
     */
    private int getPartText(int build_part, int player) {
        switch (build_part) {
            case 0:
                switch(build_arr[player].getCharacter()) {
                    case "Baby Daisy":
                        return R.string.baby_daisy;
                    case "Baby Luigi":
                        return R.string.baby_luigi;
                    case "Baby Mario":
                        return R.string.baby_mario;
                    case "Baby Peach":
                        return R.string.baby_peach;
                    case "Baby Rosalina":
                        return R.string.baby_rosalina;
                    case "Bowser":
                        return R.string.bowser;
                    case "Bowser Jr.":
                        return R.string.bowser_jr;
                    case "Cat Peach":
                        return R.string.cat_peach;
                    case "Daisy":
                        return R.string.daisy;
                    case "Donkey Kong":
                        return R.string.donkey_kong;
                    case "Dry Bones":
                        return R.string.dry_bones;
                    case "Dry Bowser":
                        return R.string.dry_bowser;
                    case "Metal Mario (Gold)":
                        return R.string.metal_mario_gold;
                    case "Iggy":
                        return R.string.iggy;
                    case "Inkling Boy (Dark Blue)":
                        return R.string.inkling_boy_darkblue;
                    case "Inkling Boy (Light Blue)":
                        return R.string.inkling_boy_lightblue;
                    case "Inkling Boy (Purple)":
                        return R.string.inkling_boy_purple;
                    case "Inkling Girl (Green)":
                        return R.string.inkling_girl_green;
                    case "Inkling Girl (Orange)":
                        return R.string.inkling_girl_orange;
                    case "Inkling Girl (Pink)":
                        return R.string.inkling_girl_pink;
                    case "Isabelle":
                        return R.string.isabelle;
                    case "King Boo":
                        return R.string.king_boo;
                    case "Koopa Troopa":
                        return R.string.koopa_troopa;
                    case "Lakitu":
                        return R.string.lakitu;
                    case "Larry":
                        return R.string.larry;
                    case "Lemmy":
                        return R.string.lemmy;
                    case "Link (BOTW)":
                        return R.string.link_botw;
                    case "Link (Classic)":
                        return R.string.link_classic;
                    case "Ludwig":
                        return R.string.ludwig;
                    case "Luigi":
                        return R.string.luigi;
                    case "Mario":
                        return R.string.mario;
                    case "Metal Mario (Metal)":
                        return R.string.metal_mario_metal;
                    case "Mii":
                        return R.string.mii;
                    case "Morton":
                        return R.string.morton;
                    case "Peach":
                        return R.string.peach;
                    case "Pink Gold Peach":
                        return R.string.pink_gold_peach;
                    case "Rosalina":
                        return R.string.rosalina;
                    case "Roy":
                        return R.string.roy;
                    case "Shy Guy (Black)":
                        return R.string.shy_guy_black;
                    case "Shy Guy (Dark Blue)":
                        return R.string.shy_guy_darkblue;
                    case "Shy Guy (Green)":
                        return R.string.shy_guy_green;
                    case "Shy Guy (Light Blue)":
                        return R.string.shy_guy_lightblue;
                    case "Shy Guy (Orange)":
                        return R.string.shy_guy_orange;
                    case "Shy Guy (Pink)":
                        return R.string.shy_guy_pink;
                    case "Shy Guy (Red)":
                        return R.string.shy_guy_red;
                    case "Shy Guy (White)":
                        return R.string.shy_guy_white;
                    case "Shy Guy (Yellow)":
                        return R.string.shy_guy_yellow;
                    case "Tanooki Mario":
                        return R.string.tanooki_mario;
                    case "Toad":
                        return R.string.toad;
                    case "Toadette":
                        return R.string.toadette;
                    case "Villager (B)":
                        return R.string.villager_boy;
                    case "Villager (G)":
                        return R.string.villager_girl;
                    case "Waluigi":
                        return R.string.waluigi;
                    case "Wario":
                        return R.string.wario;
                    case "Wendy":
                        return R.string.wendy;
                    case "Yoshi (Black)":
                        return R.string.yoshi_black;
                    case "Yoshi (Dark Blue)":
                        return R.string.yoshi_darkblue;
                    case "Yoshi (Green)":
                        return R.string.yoshi_green;
                    case "Yoshi (Light Blue)":
                        return R.string.yoshi_lightblue;
                    case "Yoshi (Orange)":
                        return R.string.yoshi_orange;
                    case "Yoshi (Pink)":
                        return R.string.yoshi_pink;
                    case "Yoshi (Red)":
                        return R.string.yoshi_red;
                    case "Yoshi (White)":
                        return R.string.yoshi_white;
                    case "Yoshi (Yellow)":
                        return R.string.yoshi_yellow;
                    default:
                        return R.string.default_error;
                }
            case 1:
                switch (build_arr[player].getFrame()) {
                    case "Standard Kart":
                        return R.string.standard_kart;
                    case "Pipe Frame":
                        return R.string.pipe_frame;
                    case "Mach 8":
                        return R.string.mach_8;
                    case "Steel Driver":
                        return R.string.steel_driver;
                    case "Cat Cruiser":
                        return R.string.cat_cruiser;
                    case "Circuit Special":
                        return R.string.circuit_special;
                    case "Tri-Speeder":
                        return R.string.trispeeder;
                    case "Badwagon":
                        return R.string.badwagon;
                    case "Prancer":
                        return R.string.prancer;
                    case "Biddybuggy":
                        return R.string.biddybuggy;
                    case "Landship":
                        return R.string.landship;
                    case "Sneeker":
                        return R.string.sneeker;
                    case "Sports Coupe":
                        return R.string.sports_coupe;
                    case "Gold Standard":
                        return R.string.gold_standard;
                    case "GLA":
                        return R.string.gla;
                    case "W 25 Silver Arrow":
                        return R.string.silver_arrow;
                    case "300 SL Roadster":
                        return R.string.roadster;
                    case "Blue Falcon":
                        return R.string.blue_falcon;
                    case "Tanooki Kart":
                        return R.string.tanooki_kart;
                    case "B Dasher":
                        return R.string.b_dasher;
                    case "Streetle":
                        return R.string.streetle;
                    case "P-Wing":
                        return R.string.p_wing;
                    case "Koopa Clown":
                        return R.string.koopa_clown;
                    case "Standard Bike":
                        return R.string.standard_bike;
                    case "The Duke":
                        return R.string.the_duke;
                    case "Flame Rider":
                        return R.string.flame_rider;
                    case "Varmint":
                        return R.string.varmint;
                    case "Mr. Scooty":
                        return R.string.mr_scooty;
                    case "City Tripper":
                        return R.string.city_tripper;
                    case "Master Cycle Zero":
                        return R.string.master_cycle_zero;
                    case "Comet":
                        return R.string.comet;
                    case "Sports Bike":
                        return R.string.sports_bike;
                    case "Jet Bike":
                        return R.string.jet_bike;
                    case "Master Cycle":
                        return R.string.master_cycle;
                    case "Yoshi Bike":
                        return R.string.yoshi_bike;
                    case "Standard ATV":
                        return R.string.standard_atv;
                    case "Wild Wiggler":
                        return R.string.wild_wiggler;
                    case "Teddy Buggy":
                        return R.string.teddy_buggy;
                    case "Bone Rattler":
                        return R.string.bone_rattler;
                    case "Splat Buggy":
                        return R.string.splat_buggy;
                    case "Inkstriker":
                        return R.string.inkstriker;
                    default:
                        return R.string.default_error;
                }
            case 2:
                switch (build_arr[player].getTires()) {
                    case "Standard Tires":
                        return R.string.standard_tires;
                    case "Monster Tires":
                        return R.string.monster_tires;
                    case "Roller Tires":
                        return R.string.roller_tires;
                    case "Slim Tires":
                        return R.string.slim_tires;
                    case "Slick Tires":
                        return R.string.slick_tires;
                    case "Metal Tires":
                        return R.string.metal_tires;
                    case "Button Tires":
                        return R.string.button_tires;
                    case "Off-Road Tires":
                        return R.string.off_road_tires;
                    case "Sponge Tires":
                        return R.string.sponge_tires;
                    case "Wood Tires":
                        return R.string.wood_tires;
                    case "Cushion Tires":
                        return R.string.cushion_tires;
                    case "Blue Standard Tires":
                        return R.string.blue_standard_tires;
                    case "Hot Monster Tires":
                        return R.string.monster_tires_hot;
                    case "Azure Roller Tires":
                        return R.string.roller_tires_azure;
                    case "Crimson Slim Tires":
                        return R.string.slim_tires_crimson;
                    case "Cyber Slick Tires":
                        return R.string.slick_tires_cyber;
                    case "Retro Off-Road Tires":
                        return R.string.off_road_tires_retro;
                    case "Gold Tires":
                        return R.string.gold_tires;
                    case "GLA Tires":
                        return R.string.gla_tires;
                    case "Triforce Tires":
                        return R.string.triforce_tires;
                    case "Leaf Tires":
                        return R.string.leaf_tires;
                    case "Ancient Tires":
                        return R.string.ancient_tires;
                    default:
                        return R.string.default_error;
                }
            case 3:
                switch (build_arr[player].getGlider()) {
                    case "Super Glider":
                        return R.string.super_glider;
                    case "Cloud Glider":
                        return R.string.cloud_glider;
                    case "Wario Wing":
                        return R.string.wario_wing;
                    case "Waddle Wing":
                        return R.string.waddle_wing;
                    case "Peach Parasol":
                        return R.string.parasol;
                    case "Parachute":
                        return R.string.parachute;
                    case "Parafoil":
                        return R.string.parafoil;
                    case "Flower Glider":
                        return R.string.flower_glider;
                    case "Bowser Kite":
                        return R.string.bowser_kite;
                    case "Plane Glider":
                        return R.string.plane_glider;
                    case "MKTV Parafoil":
                        return R.string.parafoil_mktv;
                    case "Gold Glider":
                        return R.string.gold_glider;
                    case "Hylian Kite":
                        return R.string.hylian_kite;
                    case "Paper Glider":
                        return R.string.paper_glider;
                    case "Paraglider":
                        return R.string.paraglider;
                    default:
                        return R.string.default_error;
                }
            default:
                return R.string.default_error;
        }
    }

    /**
     * after setting a tag with the resource that it is currently using, this method extracts the int ID from the tag
     *
     * @param img the ImageView that the tag ID is being extracted from
     * @return the ID int that corresponds to the given resource
     */
    public int getResourceId(ImageView img) {
        return (int) (img.getTag());
    }
}
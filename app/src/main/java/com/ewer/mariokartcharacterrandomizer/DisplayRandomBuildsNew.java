package com.ewer.mariokartcharacterrandomizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class DisplayRandomBuildsNew extends AppCompatActivity {

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

    private RandomBuild[] buildArr;
    private int playerNumber;
    private String frameType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_random_bikes_new);

        Intent intent = getIntent();
        playerNumber = intent.getIntExtra("PlayerNumber", 1);
        frameType = intent.getStringExtra("FrameType");
        //obtain different values based on what button was pressed during MainActivity

        layout_init();
        build_init();
        //initialize the layouts and random builds
    }

    /**
     * initialize the LinearLayout rows for the images of the builds
     */
    private void layout_init() {
        LinearLayout ll = findViewById(R.id.build_layout);
        // find the vertical LinearLayout that already exists in the XML. All of the following
        // views and layouts will be contained inside of this parent layout

        LinearLayout[] layoutArr = new LinearLayout[playerNumber];
        // create the empty array of LinearLayouts. This will hold the horizontal LinearLayouts,
        // which will in turn hold the ImageViews of the players' builds

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // create the layout parameters for the horizontal LinearLayouts. The layout wraps the
        // images vertically, and stretches across the entire screen horizontally

        TextView[] textArr = new TextView[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            textArr[i] = new TextView(this);
            textArr[i].setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));
            textArr[i].setGravity(Gravity.CENTER);
            textArr[i].setTextSize(24f);
        }
        // create, initialize, and format an array of TextViews for the amount of players

        for (int i = 0; i < playerNumber; i++) {
            layoutArr[i] = new LinearLayout(this);
            layoutArr[i].setLayoutParams(lp);
            layoutArr[i].setOrientation(LinearLayout.HORIZONTAL);
            // create the horizontal LinearLayouts

            ImageView[] imageArr = new ImageView[4];
            for (int j = 0; j < 4; j++) {
                imageArr[i] = new ImageView(this);
                layoutArr[i].addView(imageArr[j]);
            }
            // create the array of ImageViews for each layout and add them to the view

            ll.addView(textArr[i]);
            ll.addView(layoutArr[i]);
            // add each player text and horizontal LinearLayout to the parent vertical LinearLayout
        }
    }

    /**
     * create the random builds for the amount of players specified
     */
    private void build_init() {
        LinearLayout ll = findViewById(R.id.build_layout);

        for (int i = 0; i < playerNumber; i++) {
            buildArr[i] = new RandomBuild();
        }
        // construct the array of random builds as empty, so that random parts can be inserted

        for (int i = 0; i < playerNumber; i++) {
            ImageView[] images = new ImageView[4];
            // a set of 4 images for each player, ie. character, frame, tires, and glider
            LinearLayout llChild = (LinearLayout) ll.getChildAt((i * 2) + 1);
            // get the horizontal LinearLayout for each player, which are at the odd indexes

            buildArr[i].setCharacter(randChar());
            images[0] = new ImageView(this);
            setImageResource("char", images[0], i);
            llChild.addView(images[0]);
            // using the randomized part obtained, initialize and assign the image resource to its
            // respective ImageView in the array

            buildArr[i].setFrame(randFrame());
            images[1] = new ImageView(this);
            setImageResource("frame", images[1], i);
            llChild.addView(images[1]);

            buildArr[i].setTires(randTires());
            setImageResource("tires", images[2], i);
            llChild.addView(images[2]);

            buildArr[i].setGlider(randGlider());
            setImageResource("glider", images[4], i);
            llChild.addView(images[3]);
        }
        // set a randomized String for every player
    }

    /**
     * Obtain a random character from the character list. If the random character that was chosen
     * has multiple color palettes, this method chooses one randomly
     *
     * @return a random character concatenated with a random color palette if it has one
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
     * Depending on the inputted frame type from MainActivity, obtain a random frame from the
     * respective list
     * @return the string of the random frame
     */
    private String randFrame() {
        switch(frameType) {
            case "kart":
                return FRAME_KART[((int) (Math.random() * FRAME_KART.length))];
            case "bike":
                return FRAME_BIKE[((int) (Math.random() * FRAME_BIKE.length))];
            default:
                return FRAME_ALL[((int) (Math.random() * FRAME_ALL.length))];
        }
    }

    /**
     * Obtain a random set of tires from the tire list. If the random tires that were chosen have
     * multiple color palettes, this method chooses one randomly
     * @return the wheels that were inputted as the character, concatenated with the random color palette
     */
    private String randTires() {
        int color;
        String tires = TIRES_ALL[(int)(Math.random() * TIRES_ALL.length)];
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
     * Obtain a random glider from the list of gliders
     * @return the string that of the glider that was selected
     */
    private String randGlider() {
        return GLIDER_ALL[((int) (Math.random() * GLIDER_ALL.length))];  // returns a random item from the list by putting in a random integer for the index number
    }

    private void setImageResource(String part, ImageView iv, int player) {
        switch(part) {
            case "char":
                switch (buildArr[player].getCharacter()) {
                    case "Baby Daisy":
                        iv.setImageResource(R.drawable.baby_daisy);
                        iv.setTag(R.drawable.baby_daisy);
                        break;
                    case "Baby Luigi":
                        iv.setImageResource(R.drawable.baby_luigi);
                        iv.setTag(R.drawable.baby_luigi);
                        break;
                    case "Baby Mario":
                        iv.setImageResource(R.drawable.baby_mario);
                        iv.setTag(R.drawable.baby_mario);
                        break;
                    case "Baby Peach":
                        iv.setImageResource(R.drawable.baby_peach);
                        iv.setTag(R.drawable.baby_peach);
                        break;
                    case "Baby Rosalina":
                        iv.setImageResource(R.drawable.baby_rosalina);
                        iv.setTag(R.drawable.baby_rosalina);
                        break;
                    case "Bowser":
                        iv.setImageResource(R.drawable.bowser);
                        iv.setTag(R.drawable.bowser);
                        break;
                    case "Bowser Jr.":
                        iv.setImageResource(R.drawable.bowser_jr);
                        iv.setTag(R.drawable.bowser_jr);
                        break;
                    case "Cat Peach":
                        iv.setImageResource(R.drawable.cat_peach);
                        iv.setTag(R.drawable.cat_peach);
                        break;
                    case "Daisy":
                        iv.setImageResource(R.drawable.daisy);
                        iv.setTag(R.drawable.daisy);
                        break;
                    case "Donkey Kong":
                        iv.setImageResource(R.drawable.donkey_kong);
                        iv.setTag(R.drawable.donkey_kong);
                        break;
                    case "Dry Bones":
                        iv.setImageResource(R.drawable.dry_bones);
                        iv.setTag(R.drawable.dry_bones);
                        break;
                    case "Dry Bowser":
                        iv.setImageResource(R.drawable.dry_bowser);
                        iv.setTag(R.drawable.dry_bowser);
                        break;
                    case "Metal Mario (Gold)":
                        iv.setImageResource(R.drawable.metal_mario_gold);
                        iv.setTag(R.drawable.metal_mario_gold);
                        break;
                    case "Iggy":
                        iv.setImageResource(R.drawable.iggy);
                        iv.setTag(R.drawable.iggy);
                        break;
                    case "Inkling Boy (Dark Blue)":
                        iv.setImageResource(R.drawable.inkling_boy_darkblue);
                        iv.setTag(R.drawable.inkling_boy_darkblue);
                        break;
                    case "Inkling Boy (Light Blue)":
                        iv.setImageResource(R.drawable.inkling_boy_lightblue);
                        iv.setTag(R.drawable.inkling_boy_lightblue);
                        break;
                    case "Inkling Boy (Purple)":
                        iv.setImageResource(R.drawable.inkling_boy_purple);
                        iv.setTag(R.drawable.inkling_boy_purple);
                        break;
                    case "Inkling Girl (Green)":
                        iv.setImageResource(R.drawable.inkling_girl_green);
                        iv.setTag(R.drawable.inkling_girl_green);
                        break;
                    case "Inkling Girl (Orange)":
                        iv.setImageResource(R.drawable.inkling_girl_orange);
                        iv.setTag(R.drawable.inkling_girl_orange);
                        break;
                    case "Inkling Girl (Pink)":
                        iv.setImageResource(R.drawable.inkling_girl_pink);
                        iv.setTag(R.drawable.inkling_girl_pink);
                        break;
                    case "Isabelle":
                        iv.setImageResource(R.drawable.isabelle);
                        iv.setTag(R.drawable.isabelle);
                        break;
                    case "King Boo":
                        iv.setImageResource(R.drawable.king_boo);
                        iv.setTag(R.drawable.king_boo);
                        break;
                    case "Koopa Troopa":
                        iv.setImageResource(R.drawable.koopa_troopa);
                        iv.setTag(R.drawable.koopa_troopa);
                        break;
                    case "Lakitu":
                        iv.setImageResource(R.drawable.lakitu);
                        iv.setTag(R.drawable.lakitu);
                        break;
                    case "Larry":
                        iv.setImageResource(R.drawable.larry);
                        iv.setTag(R.drawable.larry);
                        break;
                    case "Lemmy":
                        iv.setImageResource(R.drawable.lemmy);
                        iv.setTag(R.drawable.lemmy);
                        break;
                    case "Link (BOTW)":
                        iv.setImageResource(R.drawable.link_botw);
                        iv.setTag(R.drawable.link_botw);
                        break;
                    case "Link (Classic)":
                        iv.setImageResource(R.drawable.link_classic);
                        iv.setTag(R.drawable.link_classic);
                        break;
                    case "Ludwig":
                        iv.setImageResource(R.drawable.ludwig);
                        iv.setTag(R.drawable.ludwig);
                        break;
                    case "Luigi":
                        iv.setImageResource(R.drawable.luigi);
                        iv.setTag(R.drawable.luigi);
                        break;
                    case "Mario":
                        iv.setImageResource(R.drawable.mario);
                        iv.setTag(R.drawable.mario);
                        break;
                    case "Metal Mario (Metal)":
                        iv.setImageResource(R.drawable.metal_mario_metal);
                        iv.setTag(R.drawable.metal_mario_metal);
                        break;
                    case "Mii":
                        iv.setImageResource(R.drawable.mii);
                        iv.setTag(R.drawable.mii);
                        break;
                    case "Morton":
                        iv.setImageResource(R.drawable.morton);
                        iv.setTag(R.drawable.morton);
                        break;
                    case "Peach":
                        iv.setImageResource(R.drawable.peach);
                        iv.setTag(R.drawable.peach);
                        break;
                    case "Pink Gold Peach":
                        iv.setImageResource(R.drawable.pink_gold_peach);
                        iv.setTag(R.drawable.pink_gold_peach);
                        break;
                    case "Rosalina":
                        iv.setImageResource(R.drawable.rosalina);
                        iv.setTag(R.drawable.rosalina);
                        break;
                    case "Roy":
                        iv.setImageResource(R.drawable.roy);
                        iv.setTag(R.drawable.roy);
                        break;
                    case "Shy Guy (Black)":
                        iv.setImageResource(R.drawable.shyguy_black);
                        iv.setTag(R.drawable.shyguy_black);
                        break;
                    case "Shy Guy (Dark Blue)":
                        iv.setImageResource(R.drawable.shyguy_darkblue);
                        iv.setTag(R.drawable.shyguy_darkblue);
                        break;
                    case "Shy Guy (Green)":
                        iv.setImageResource(R.drawable.shyguy_green);
                        iv.setTag(R.drawable.shyguy_green);
                        break;
                    case "Shy Guy (Light Blue)":
                        iv.setImageResource(R.drawable.shyguy_lightblue);
                        iv.setTag(R.drawable.shyguy_lightblue);
                        break;
                    case "Shy Guy (Orange)":
                        iv.setImageResource(R.drawable.shyguy_orange);
                        iv.setTag(R.drawable.shyguy_orange);
                        break;
                    case "Shy Guy (Pink)":
                        iv.setImageResource(R.drawable.shyguy_pink);
                        iv.setTag(R.drawable.shyguy_pink);
                        break;
                    case "Shy Guy (Red)":
                        iv.setImageResource(R.drawable.shyguy_red);
                        iv.setTag(R.drawable.shyguy_red);
                        break;
                    case "Shy Guy (White)":
                        iv.setImageResource(R.drawable.shyguy_white);
                        iv.setTag(R.drawable.shyguy_white);
                        break;
                    case "Shy Guy (Yellow)":
                        iv.setImageResource(R.drawable.shyguy_yellow);
                        iv.setTag(R.drawable.shyguy_yellow);
                        break;
                    case "Tanooki Mario":
                        iv.setImageResource(R.drawable.tanooki_mario);
                        iv.setTag(R.drawable.tanooki_mario);
                        break;
                    case "Toad":
                        iv.setImageResource(R.drawable.toad);
                        iv.setTag(R.drawable.toad);
                        break;
                    case "Toadette":
                        iv.setImageResource(R.drawable.toadette);
                        iv.setTag(R.drawable.toadette);
                        break;
                    case "Villager (B)":
                        iv.setImageResource(R.drawable.villager_boy);
                        iv.setTag(R.drawable.villager_boy);
                        break;
                    case "Villager (G)":
                        iv.setImageResource(R.drawable.villager_girl);
                        iv.setTag(R.drawable.villager_girl);
                        break;
                    case "Waluigi":
                        iv.setImageResource(R.drawable.waluigi);
                        iv.setTag(R.drawable.waluigi);
                        break;
                    case "Wario":
                        iv.setImageResource(R.drawable.wario);
                        iv.setTag(R.drawable.wario);
                        break;
                    case "Wendy":
                        iv.setImageResource(R.drawable.wendy);
                        iv.setTag(R.drawable.wendy);
                        break;
                    case "Yoshi (Black)":
                        iv.setImageResource(R.drawable.yoshi_black);
                        iv.setTag(R.drawable.yoshi_black);
                        break;
                    case "Yoshi (Dark Blue)":
                        iv.setImageResource(R.drawable.yoshi_darkblue);
                        iv.setTag(R.drawable.yoshi_darkblue);
                        break;
                    case "Yoshi (Green)":
                        iv.setImageResource(R.drawable.yoshi_green);
                        iv.setTag(R.drawable.yoshi_green);
                        break;
                    case "Yoshi (Light Blue)":
                        iv.setImageResource(R.drawable.yoshi_lightblue);
                        iv.setTag(R.drawable.yoshi_lightblue);
                        break;
                    case "Yoshi (Orange)":
                        iv.setImageResource(R.drawable.yoshi_orange);
                        iv.setTag(R.drawable.yoshi_orange);
                        break;
                    case "Yoshi (Pink)":
                        iv.setImageResource(R.drawable.yoshi_pink);
                        iv.setTag(R.drawable.yoshi_pink);
                        break;
                    case "Yoshi (Red)":
                        iv.setImageResource(R.drawable.yoshi_red);
                        iv.setTag(R.drawable.yoshi_red);
                        break;
                    case "Yoshi (White)":
                        iv.setImageResource(R.drawable.yoshi_white);
                        iv.setTag(R.drawable.yoshi_white);
                        break;
                    case "Yoshi (Yellow)":
                        iv.setImageResource(R.drawable.yoshi_yellow);
                        iv.setTag(R.drawable.yoshi_yellow);
                        break;
                    default:
                        iv.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }
                break;
            case "frame":
                switch (buildArr[player].getFrame()) {
                    case "Standard Kart":
                        iv.setImageResource(R.drawable.standard_kart);
                        iv.setTag(R.drawable.standard_kart);
                        break;
                    case "Pipe Frame":
                        iv.setImageResource(R.drawable.pipe_frame);
                        iv.setTag(R.drawable.pipe_frame);
                        break;
                    case "Mach 8":
                        iv.setImageResource(R.drawable.mach_8);
                        iv.setTag(R.drawable.mach_8);
                        break;
                    case "Steel Driver":
                        iv.setImageResource(R.drawable.steel_driver);
                        iv.setTag(R.drawable.steel_driver);
                        break;
                    case "Cat Cruiser":
                        iv.setImageResource(R.drawable.cat_cruiser);
                        iv.setTag(R.drawable.cat_cruiser);
                        break;
                    case "Circuit Special":
                        iv.setImageResource(R.drawable.circuit_special);
                        iv.setTag(R.drawable.circuit_special);
                        break;
                    case "Tri-Speeder":
                        iv.setImageResource(R.drawable.trispeeder);
                        iv.setTag(R.drawable.trispeeder);
                        break;
                    case "Badwagon":
                        iv.setImageResource(R.drawable.badwagon);
                        iv.setTag(R.drawable.badwagon);
                        break;
                    case "Prancer":
                        iv.setImageResource(R.drawable.prancer);
                        iv.setTag(R.drawable.prancer);
                        break;
                    case "Biddybuggy":
                        iv.setImageResource(R.drawable.biddybuggy);
                        iv.setTag(R.drawable.biddybuggy);
                        break;
                    case "Landship":
                        iv.setImageResource(R.drawable.landship);
                        iv.setTag(R.drawable.landship);
                        break;
                    case "Sneeker":
                        iv.setImageResource(R.drawable.sneeker);
                        iv.setTag(R.drawable.sneeker);
                        break;
                    case "Sports Coupe":
                        iv.setImageResource(R.drawable.sports_coupe);
                        iv.setTag(R.drawable.sports_coupe);
                        break;
                    case "Gold Standard":
                        iv.setImageResource(R.drawable.gold_standard);
                        iv.setTag(R.drawable.gold_standard);
                        break;
                    case "GLA":
                        iv.setImageResource(R.drawable.gla);
                        iv.setTag(R.drawable.gla);
                        break;
                    case "W 25 Silver Arrow":
                        iv.setImageResource(R.drawable.silver_arrow);
                        iv.setTag(R.drawable.silver_arrow);
                        break;
                    case "300 SL Roadster":
                        iv.setImageResource(R.drawable.roadster);
                        iv.setTag(R.drawable.roadster);
                        break;
                    case "Blue Falcon":
                        iv.setImageResource(R.drawable.blue_falcon);
                        iv.setTag(R.drawable.blue_falcon);
                        break;
                    case "Tanooki Kart":
                        iv.setImageResource(R.drawable.tanooki_kart);
                        iv.setTag(R.drawable.tanooki_kart);
                        break;
                    case "B Dasher":
                        iv.setImageResource(R.drawable.b_dasher);
                        iv.setTag(R.drawable.b_dasher);
                        break;
                    case "Streetle":
                        iv.setImageResource(R.drawable.streetle);
                        iv.setTag(R.drawable.streetle);
                        break;
                    case "P-Wing":
                        iv.setImageResource(R.drawable.p_wing);
                        iv.setTag(R.drawable.p_wing);
                        break;
                    case "Koopa Clown":
                        iv.setImageResource(R.drawable.koopa_clown);
                        iv.setTag(R.drawable.koopa_clown);
                        break;
                    case "Standard Bike":
                        iv.setImageResource(R.drawable.standard_bike);
                        iv.setTag(R.drawable.standard_bike);
                        break;
                    case "The Duke":
                        iv.setImageResource(R.drawable.the_duke);
                        iv.setTag(R.drawable.the_duke);
                        break;
                    case "Flame Rider":
                        iv.setImageResource(R.drawable.flame_rider);
                        iv.setTag(R.drawable.flame_rider);
                        break;
                    case "Varmint":
                        iv.setImageResource(R.drawable.varmint);
                        iv.setTag(R.drawable.varmint);
                        break;
                    case "Mr. Scooty":
                        iv.setImageResource(R.drawable.mr_scooty);
                        iv.setTag(R.drawable.mr_scooty);
                        break;
                    case "City Tripper":
                        iv.setImageResource(R.drawable.city_tripper);
                        iv.setTag(R.drawable.city_tripper);
                        break;
                    case "Master Cycle Zero":
                        iv.setImageResource(R.drawable.master_cycle_zero);
                        iv.setTag(R.drawable.master_cycle_zero);
                        break;
                    case "Comet":
                        iv.setImageResource(R.drawable.comet);
                        iv.setTag(R.drawable.comet);
                        break;
                    case "Sports Bike":
                        iv.setImageResource(R.drawable.sports_bike);
                        iv.setTag(R.drawable.sports_bike);
                        break;
                    case "Jet Bike":
                        iv.setImageResource(R.drawable.jet_bike);
                        iv.setTag(R.drawable.jet_bike);
                        break;
                    case "Master Cycle":
                        iv.setImageResource(R.drawable.master_cycle);
                        iv.setTag(R.drawable.master_cycle);
                        break;
                    case "Yoshi Bike":
                        iv.setImageResource(R.drawable.yoshi_bike);
                        iv.setTag(R.drawable.yoshi_bike);
                        break;
                    case "Standard ATV":
                        iv.setImageResource(R.drawable.standard_atv);
                        iv.setTag(R.drawable.standard_atv);
                        break;
                    case "Wild Wiggler":
                        iv.setImageResource(R.drawable.wild_wiggler);
                        iv.setTag(R.drawable.wild_wiggler);
                        break;
                    case "Teddy Buggy":
                        iv.setImageResource(R.drawable.teddy_buggy);
                        iv.setTag(R.drawable.teddy_buggy);
                        break;
                    case "Bone Rattler":
                        iv.setImageResource(R.drawable.bone_rattler);
                        iv.setTag(R.drawable.bone_rattler);
                        break;
                    case "Splat Buggy":
                        iv.setImageResource(R.drawable.splat_buggy);
                        iv.setTag(R.drawable.splat_buggy);
                        break;
                    case "Inkstriker":
                        iv.setImageResource(R.drawable.inkstriker);
                        iv.setTag(R.drawable.inkstriker);
                        break;
                    default:
                        iv.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }
                break;
            case "tires":
                switch (buildArr[player].getTires()) {
                    case "StandardTires":
                        iv.setImageResource(R.drawable.standard_tires);
                        iv.setTag(R.drawable.standard_tires);
                        break;
                    case "MonsterTires":
                        iv.setImageResource(R.drawable.monster_tires);
                        iv.setTag(R.drawable.monster_tires);
                        break;
                    case "RollerTires":
                        iv.setImageResource(R.drawable.roller_tires);
                        iv.setTag(R.drawable.roller_tires);
                        break;
                    case "SlimTires":
                        iv.setImageResource(R.drawable.slim_tires);
                        iv.setTag(R.drawable.slim_tires);
                        break;
                    case "SlickTires":
                        iv.setImageResource(R.drawable.slick_tires);
                        iv.setTag(R.drawable.slick_tires);
                        break;
                    case "MetalTires":
                        iv.setImageResource(R.drawable.metal_tires);
                        iv.setTag(R.drawable.metal_tires);
                        break;
                    case "ButtonTires":
                        iv.setImageResource(R.drawable.button_tires);
                        iv.setTag(R.drawable.button_tires);
                        break;
                    case "Off-RoadTires":
                        iv.setImageResource(R.drawable.off_road_tires);
                        iv.setTag(R.drawable.off_road_tires);
                        break;
                    case "SpongeTires":
                        iv.setImageResource(R.drawable.sponge_tires);
                        iv.setTag(R.drawable.sponge_tires);
                        break;
                    case "WoodTires":
                        iv.setImageResource(R.drawable.wood_tires);
                        iv.setTag(R.drawable.wood_tires);
                        break;
                    case "CushionTires":
                        iv.setImageResource(R.drawable.cushion_tires);
                        iv.setTag(R.drawable.cushion_tires);
                        break;
                    case "Blue StandardTires":
                        iv.setImageResource(R.drawable.blue_standard_tires);
                        iv.setTag(R.drawable.blue_standard_tires);
                        break;
                    case "Hot MonsterTires":
                        iv.setImageResource(R.drawable.monster_tires_hot);
                        iv.setTag(R.drawable.monster_tires_hot);
                        break;
                    case "Azure RollerTires":
                        iv.setImageResource(R.drawable.roller_tires_azure);
                        iv.setTag(R.drawable.roller_tires_azure);
                        break;
                    case "Crimson SlimTires":
                        iv.setImageResource(R.drawable.slim_tires_crimson);
                        iv.setTag(R.drawable.slim_tires_crimson);
                        break;
                    case "Cyber SlickTires":
                        iv.setImageResource(R.drawable.slick_tires_cyber);
                        iv.setTag(R.drawable.slick_tires_cyber);
                        break;
                    case "Retro Off-RoadTires":
                        iv.setImageResource(R.drawable.off_road_tires_retro);
                        iv.setTag(R.drawable.off_road_tires_retro);
                        break;
                    case "Gold Tires":
                        iv.setImageResource(R.drawable.gold_tires);
                        iv.setTag(R.drawable.gold_tires);
                        break;
                    case "GLA Tires":
                        iv.setImageResource(R.drawable.gla_tires);
                        iv.setTag(R.drawable.gla_tires);
                        break;
                    case "Triforce Tires":
                        iv.setImageResource(R.drawable.triforce_tires);
                        iv.setTag(R.drawable.triforce_tires);
                        break;
                    case "Leaf Tires":
                        iv.setImageResource(R.drawable.leaf_tires);
                        iv.setTag(R.drawable.leaf_tires);
                        break;
                    case "Ancient Tires":
                        iv.setImageResource(R.drawable.ancient_tires);
                        iv.setTag(R.drawable.ancient_tires);
                        break;
                    default:
                        iv.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }
                break;
            case "glider":
                switch (buildArr[player].getGlider()) {
                    case "Super Glider":
                        iv.setImageResource(R.drawable.super_glider);
                        iv.setTag(R.drawable.super_glider);
                        break;
                    case "Cloud Glider":
                        iv.setImageResource(R.drawable.cloud_glider);
                        iv.setTag(R.drawable.cloud_glider);
                        break;
                    case "Wario Wing":
                        iv.setImageResource(R.drawable.wario_wing);
                        iv.setTag(R.drawable.wario_wing);
                        break;
                    case "Waddle Wing":
                        iv.setImageResource(R.drawable.waddle_wing);
                        iv.setTag(R.drawable.waddle_wing);
                        break;
                    case "Peach Parasol":
                        iv.setImageResource(R.drawable.parasol);
                        iv.setTag(R.drawable.parasol);
                        break;
                    case "Parachute":
                        iv.setImageResource(R.drawable.parachute);
                        iv.setTag(R.drawable.parachute);
                        break;
                    case "Parafoil":
                        iv.setImageResource(R.drawable.parafoil);
                        iv.setTag(R.drawable.parafoil);
                        break;
                    case "Flower Glider":
                        iv.setImageResource(R.drawable.flower_glider);
                        iv.setTag(R.drawable.flower_glider);
                        break;
                    case "Bowser Kite":
                        iv.setImageResource(R.drawable.bowser_kite);
                        iv.setTag(R.drawable.bowser_kite);
                        break;
                    case "Plane Glider":
                        iv.setImageResource(R.drawable.plane_glider);
                        iv.setTag(R.drawable.plane_glider);
                        break;
                    case "MKTV Parafoil":
                        iv.setImageResource(R.drawable.parafoil_mktv);
                        iv.setTag(R.drawable.parafoil_mktv);
                        break;
                    case "Gold Glider":
                        iv.setImageResource(R.drawable.gold_glider);
                        iv.setTag(R.drawable.gold_glider);
                        break;
                    case "Hylian Kite":
                        iv.setImageResource(R.drawable.hylian_kite);
                        iv.setTag(R.drawable.hylian_kite);
                        break;
                    case "Paper Glider":
                        iv.setImageResource(R.drawable.paper_glider);
                        iv.setTag(R.drawable.paper_glider);
                        break;
                    case "Paraglider":
                        iv.setImageResource(R.drawable.paraglider);
                        iv.setTag(R.drawable.paraglider);
                        break;
                    default:
                        iv.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }
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
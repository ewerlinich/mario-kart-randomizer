package com.ewer.mariokartcharacterrandomizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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
        LinearLayout tl = findViewById(R.id.build_layout);
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
        // create and initialize an array of TextViews for the amount of players

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

            tl.addView(textArr[i]);
            tl.addView(layoutArr[i]);
            //add each player text and horizontal LinearLayout to the parent vertical LinearLayout
        }
    }

    /**
     * create the random builds for the amount of players specified
     */
    private void build_init() {
        for (int i = 0; i < playerNumber; i++) {
            buildArr[i] = new RandomBuild();
        }
        //construct the array of random builds as empty, so that random parts can be inserted

        for (int i = 0; i < playerNumber; i++) {
            buildArr[i].setCharacter(randCharAll());
            switch (frameType) {
                case "kart":
                    buildArr[i].setFrame(randFrameKart());
                    break;
                case "bike":
                    buildArr[i].setFrame(randFrameBike());
                    break;
                default:
                    buildArr[i].setFrame(randFrameAll());
            }
            //frame type changes depending on what button was pressed in MainActivity
            buildArr[i].setWheels(randWheels());
            buildArr[i].setGlider(randGlider());
        }
        //set a randomized String for every player

    }

    /**
     * randCharacterLight() returns a random String from a list of all of the light character names.
     * Excludes color variants of characters to ensure equal odds to select each character
     *
     * @return a String that is the name of the random character
     */
    private String randCharLight() {
        return CHAR_LIGHT[((int) (Math.random() * CHAR_LIGHT.length))];
    }

    /**
     * randCharacterMedium() returns a random String from a list of all of the medium character names.
     * Excludes color variants of characters to ensure equal odds to select each character
     *
     * @return a String that is the name of the random character
     */
    private String randCharMedium() {
        return CHAR_MEDIUM[((int) (Math.random() * CHAR_MEDIUM.length))];
    }

    /**
     * randCharacterHeavy() returns a random String from a list of all of the heavy character names.
     * Excludes color variants of characters to ensure equal odds to select each character
     *
     * @return a String that is the name of the random character
     */
    private String randCharHeavy() {
        return CHAR_HEAVY[((int) (Math.random() * CHAR_HEAVY.length))];
    }

    /**
     * randCharacterAll() returns a random String from a list of all of the character names.
     * Excludes color variants of characters to ensure equal odds to select each character
     *
     * @return a String that is the name of the random character
     */
    private String randCharAll() {
        return CHAR_ALL[((int) (Math.random() * CHAR_ALL.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randBikeFrame() returns a random String from a list of bike frames
     *
     * @return a String that is the name of the frame
     */
    private String randFrameBike() {
        return FRAME_BIKE[((int) (Math.random() * FRAME_BIKE.length))];
    }

    /**
     * randKartFrame() returns a random String from a list of kart frames
     *
     * @return a String that is the name of the frame
     */
    private String randFrameKart() {
        return FRAME_KART[((int) (Math.random() * FRAME_KART.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randAllFrame() returns a random String from a list of kart and bike frames
     *
     * @return a String that is the name of the frame
     */
    private String randFrameAll() {
        return FRAME_ALL[((int) (Math.random() * FRAME_ALL.length))];
    }

    /**
     * randFrame() returns a random String from a list of wheels
     *
     * @return a String that is the name of the wheels
     */
    private String randWheels() {
        return TIRES_ALL[((int) (Math.random() * TIRES_ALL.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randGlider() returns a random String from a list of gliders
     *
     * @return a String that is the name of the glider
     */
    private String randGlider() {
        return GLIDER_ALL[((int) (Math.random() * GLIDER_ALL.length))];  // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * If the random character that was chosen has multiple color palettes, this method chooses one randomly
     *
     * @param randChar is the character that is being assigned a color
     * @return the character that was inputted as the character, concatenated with the random color palette
     */
    private String setCharColor(String randChar) {
        int color;
        String character;
        switch (randChar) {
            case "Shy Guy":     // they use the same colors
            case "Yoshi":
                color = (int) (Math.random() * 9);
                switch (color) {
                    case 0:
                        character = randChar.concat(" (Green)");
                        break;
                    case 1:
                        character = randChar.concat(" (Red)");
                        break;
                    case 2:
                        character = randChar.concat(" (Dark Blue)");
                        break;
                    case 3:
                        character = randChar.concat(" (Light Blue)");
                        break;
                    case 4:
                        character = randChar.concat(" (Yellow)");
                        break;
                    case 5:
                        character = randChar.concat(" (Pink)");
                        break;
                    case 6:
                        character = randChar.concat(" (Black)");
                        break;
                    case 7:
                        character = randChar.concat(" (White)");
                        break;
                    case 8:
                        character = randChar.concat(" (Orange)");
                        break;
                    default:
                        character = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Metal Mario":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    character = randChar.concat(" (Metal)");
                } else {
                    character = randChar.concat(" (Gold)");
                }
                break;
            case "Link":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    character = randChar.concat(" (Classic)");
                } else {
                    character = randChar.concat(" (BOTW)");
                }
                break;
            case "Inkling Girl":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        character = randChar.concat(" (Orange)");
                        break;
                    case 1:
                        character = randChar.concat(" (Green)");
                        break;
                    case 2:
                        character = randChar.concat(" (Pink)");
                        break;
                    default:
                        character = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Inkling Boy":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        character = randChar.concat(" (Dark Blue)");
                        break;
                    case 1:
                        character = randChar.concat(" (Purple)");
                        break;
                    case 2:
                        character = randChar.concat(" (Light Blue)");
                        break;
                    default:
                        character = randChar.concat(" (ERROR ERROR ERROR)");
                }
                break;
            default:
                character = "ERROR ERROR ERROR";
        }
        return character;
    }

    /**
     * If the random wheels that were chosen have multiple color palettes, this method chooses one randomly
     *
     * @param randTires are the wheels that are being assigned a color
     * @return the wheels that were inputted as the character, concatenated with the random color palette
     */
    private String setTireColor(String randTires) {
        int color;
        String tires;
        switch (randTires) {
            case "Standard Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Blue ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            case "Roller Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Azure ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            case "Monster Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Hot ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            case "Slim Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Crimson ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            case "Off-Road Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Retro ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            case "Slick Tires":
                color = (int) (Math.random() * 2);
                if (color == 1) {
                    tires = "Cyber ".concat(randTires);
                } else {
                    tires = randTires;
                }
                break;
            default:
                tires = "";
        }
        return tires;
    }

    /**
     * takes in the number of players, calls randCharacterAll() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     *
     * @param playerNumber is the number of characters that need randomized characters
     */
    private void setCharImage(int playerNumber) {
        ImageView charImage1 = findViewById(R.id.char_image_p1);
        ImageView charImage2 = findViewById(R.id.char_image_p2);
        ImageView charImage3 = findViewById(R.id.char_image_p3);
        ImageView charImage4 = findViewById(R.id.char_image_p4);
        ImageView[] arr = {charImage1, charImage2, charImage3, charImage4};

        for (int i = playerNumber; i >= 1; i--) {
            String randChar = randCharAll();
            if (randChar.equals("Yoshi") || randChar.equals("Shy Guy")
                    || randChar.equals("Metal Mario") || randChar.equals("Link")
                    || randChar.equals("Inkling Boy") || randChar.equals("Inkling Girl")) {
                randChar = setCharColor(randChar);
            }
            switch (randChar) {
                case "Baby Daisy":
                    arr[i - 1].setImageResource(R.drawable.baby_daisy);
                    arr[i - 1].setTag(R.drawable.baby_daisy);
                    break;
                case "Baby Luigi":
                    arr[i - 1].setImageResource(R.drawable.baby_luigi);
                    arr[i - 1].setTag(R.drawable.baby_luigi);
                    break;
                case "Baby Mario":
                    arr[i - 1].setImageResource(R.drawable.baby_mario);
                    arr[i - 1].setTag(R.drawable.baby_mario);
                    break;
                case "Baby Peach":
                    arr[i - 1].setImageResource(R.drawable.baby_peach);
                    arr[i - 1].setTag(R.drawable.baby_peach);
                    break;
                case "Baby Rosalina":
                    arr[i - 1].setImageResource(R.drawable.baby_rosalina);
                    arr[i - 1].setTag(R.drawable.baby_rosalina);
                    break;
                case "Bowser":
                    arr[i - 1].setImageResource(R.drawable.bowser);
                    arr[i - 1].setTag(R.drawable.bowser);
                    break;
                case "Bowser Jr.":
                    arr[i - 1].setImageResource(R.drawable.bowser_jr);
                    arr[i - 1].setTag(R.drawable.bowser_jr);
                    break;
                case "Cat Peach":
                    arr[i - 1].setImageResource(R.drawable.cat_peach);
                    arr[i - 1].setTag(R.drawable.cat_peach);
                    break;
                case "Daisy":
                    arr[i - 1].setImageResource(R.drawable.daisy);
                    arr[i - 1].setTag(R.drawable.daisy);
                    break;
                case "Donkey Kong":
                    arr[i - 1].setImageResource(R.drawable.donkey_kong);
                    arr[i - 1].setTag(R.drawable.donkey_kong);
                    break;
                case "Dry Bones":
                    arr[i - 1].setImageResource(R.drawable.dry_bones);
                    arr[i - 1].setTag(R.drawable.dry_bones);
                    break;
                case "Dry Bowser":
                    arr[i - 1].setImageResource(R.drawable.dry_bowser);
                    arr[i - 1].setTag(R.drawable.dry_bowser);
                    break;
                case "Metal Mario (Gold)":
                    arr[i - 1].setImageResource(R.drawable.metal_mario_gold);
                    arr[i - 1].setTag(R.drawable.metal_mario_gold);
                    break;
                case "Iggy":
                    arr[i - 1].setImageResource(R.drawable.iggy);
                    arr[i - 1].setTag(R.drawable.iggy);
                    break;
                case "Inkling Boy (Dark Blue)":
                    arr[i - 1].setImageResource(R.drawable.inkling_boy_darkblue);
                    arr[i - 1].setTag(R.drawable.inkling_boy_darkblue);
                    break;
                case "Inkling Boy (Light Blue)":
                    arr[i - 1].setImageResource(R.drawable.inkling_boy_lightblue);
                    arr[i - 1].setTag(R.drawable.inkling_boy_lightblue);
                    break;
                case "Inkling Boy (Purple)":
                    arr[i - 1].setImageResource(R.drawable.inkling_boy_purple);
                    arr[i - 1].setTag(R.drawable.inkling_boy_purple);
                    break;
                case "Inkling Girl (Green)":
                    arr[i - 1].setImageResource(R.drawable.inkling_girl_green);
                    arr[i - 1].setTag(R.drawable.inkling_girl_green);
                    break;
                case "Inkling Girl (Orange)":
                    arr[i - 1].setImageResource(R.drawable.inkling_girl_orange);
                    arr[i - 1].setTag(R.drawable.inkling_girl_orange);
                    break;
                case "Inkling Girl (Pink)":
                    arr[i - 1].setImageResource(R.drawable.inkling_girl_pink);
                    arr[i - 1].setTag(R.drawable.inkling_girl_pink);
                    break;
                case "Isabelle":
                    arr[i - 1].setImageResource(R.drawable.isabelle);
                    arr[i - 1].setTag(R.drawable.isabelle);
                    break;
                case "King Boo":
                    arr[i - 1].setImageResource(R.drawable.king_boo);
                    arr[i - 1].setTag(R.drawable.king_boo);
                    break;
                case "Koopa Troopa":
                    arr[i - 1].setImageResource(R.drawable.koopa_troopa);
                    arr[i - 1].setTag(R.drawable.koopa_troopa);
                    break;
                case "Lakitu":
                    arr[i - 1].setImageResource(R.drawable.lakitu);
                    arr[i - 1].setTag(R.drawable.lakitu);
                    break;
                case "Larry":
                    arr[i - 1].setImageResource(R.drawable.larry);
                    arr[i - 1].setTag(R.drawable.larry);
                    break;
                case "Lemmy":
                    arr[i - 1].setImageResource(R.drawable.lemmy);
                    arr[i - 1].setTag(R.drawable.lemmy);
                    break;
                case "Link (BOTW)":
                    arr[i - 1].setImageResource(R.drawable.link_botw);
                    arr[i - 1].setTag(R.drawable.link_botw);
                    break;
                case "Link (Classic)":
                    arr[i - 1].setImageResource(R.drawable.link_classic);
                    arr[i - 1].setTag(R.drawable.link_classic);
                    break;
                case "Ludwig":
                    arr[i - 1].setImageResource(R.drawable.ludwig);
                    arr[i - 1].setTag(R.drawable.ludwig);
                    break;
                case "Luigi":
                    arr[i - 1].setImageResource(R.drawable.luigi);
                    arr[i - 1].setTag(R.drawable.luigi);
                    break;
                case "Mario":
                    arr[i - 1].setImageResource(R.drawable.mario);
                    arr[i - 1].setTag(R.drawable.mario);
                    break;
                case "Metal Mario (Metal)":
                    arr[i - 1].setImageResource(R.drawable.metal_mario_metal);
                    arr[i - 1].setTag(R.drawable.metal_mario_metal);
                    break;
                case "Mii":
                    arr[i - 1].setImageResource(R.drawable.mii);
                    arr[i - 1].setTag(R.drawable.mii);
                    break;
                case "Morton":
                    arr[i - 1].setImageResource(R.drawable.morton);
                    arr[i - 1].setTag(R.drawable.morton);
                    break;
                case "Peach":
                    arr[i - 1].setImageResource(R.drawable.peach);
                    arr[i - 1].setTag(R.drawable.peach);
                    break;
                case "Pink Gold Peach":
                    arr[i - 1].setImageResource(R.drawable.pink_gold_peach);
                    arr[i - 1].setTag(R.drawable.pink_gold_peach);
                    break;
                case "Rosalina":
                    arr[i - 1].setImageResource(R.drawable.rosalina);
                    arr[i - 1].setTag(R.drawable.rosalina);
                    break;
                case "Roy":
                    arr[i - 1].setImageResource(R.drawable.roy);
                    arr[i - 1].setTag(R.drawable.roy);
                    break;
                case "Shy Guy (Black)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_black);
                    arr[i - 1].setTag(R.drawable.shyguy_black);
                    break;
                case "Shy Guy (Dark Blue)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_darkblue);
                    arr[i - 1].setTag(R.drawable.shyguy_darkblue);
                    break;
                case "Shy Guy (Green)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_green);
                    arr[i - 1].setTag(R.drawable.shyguy_green);
                    break;
                case "Shy Guy (Light Blue)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_lightblue);
                    arr[i - 1].setTag(R.drawable.shyguy_lightblue);
                    break;
                case "Shy Guy (Orange)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_orange);
                    arr[i - 1].setTag(R.drawable.shyguy_orange);
                    break;
                case "Shy Guy (Pink)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_pink);
                    arr[i - 1].setTag(R.drawable.shyguy_pink);
                    break;
                case "Shy Guy (Red)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_red);
                    arr[i - 1].setTag(R.drawable.shyguy_red);
                    break;
                case "Shy Guy (White)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_white);
                    arr[i - 1].setTag(R.drawable.shyguy_white);
                    break;
                case "Shy Guy (Yellow)":
                    arr[i - 1].setImageResource(R.drawable.shyguy_yellow);
                    arr[i - 1].setTag(R.drawable.shyguy_yellow);
                    break;
                case "Tanooki Mario":
                    arr[i - 1].setImageResource(R.drawable.tanooki_mario);
                    arr[i - 1].setTag(R.drawable.tanooki_mario);
                    break;
                case "Toad":
                    arr[i - 1].setImageResource(R.drawable.toad);
                    arr[i - 1].setTag(R.drawable.toad);
                    break;
                case "Toadette":
                    arr[i - 1].setImageResource(R.drawable.toadette);
                    arr[i - 1].setTag(R.drawable.toadette);
                    break;
                case "Villager (B)":
                    arr[i - 1].setImageResource(R.drawable.villager_boy);
                    arr[i - 1].setTag(R.drawable.villager_boy);
                    break;
                case "Villager (G)":
                    arr[i - 1].setImageResource(R.drawable.villager_girl);
                    arr[i - 1].setTag(R.drawable.villager_girl);
                    break;
                case "Waluigi":
                    arr[i - 1].setImageResource(R.drawable.waluigi);
                    arr[i - 1].setTag(R.drawable.waluigi);
                    break;
                case "Wario":
                    arr[i - 1].setImageResource(R.drawable.wario);
                    arr[i - 1].setTag(R.drawable.wario);
                    break;
                case "Wendy":
                    arr[i - 1].setImageResource(R.drawable.wendy);
                    arr[i - 1].setTag(R.drawable.wendy);
                    break;
                case "Yoshi (Black)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_black);
                    arr[i - 1].setTag(R.drawable.yoshi_black);
                    break;
                case "Yoshi (Dark Blue)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_darkblue);
                    arr[i - 1].setTag(R.drawable.yoshi_darkblue);
                    break;
                case "Yoshi (Green)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_green);
                    arr[i - 1].setTag(R.drawable.yoshi_green);
                    break;
                case "Yoshi (Light Blue)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_lightblue);
                    arr[i - 1].setTag(R.drawable.yoshi_lightblue);
                    break;
                case "Yoshi (Orange)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_orange);
                    arr[i - 1].setTag(R.drawable.yoshi_orange);
                    break;
                case "Yoshi (Pink)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_pink);
                    arr[i - 1].setTag(R.drawable.yoshi_pink);
                    break;
                case "Yoshi (Red)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_red);
                    arr[i - 1].setTag(R.drawable.yoshi_red);
                    break;
                case "Yoshi (White)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_white);
                    arr[i - 1].setTag(R.drawable.yoshi_white);
                    break;
                case "Yoshi (Yellow)":
                    arr[i - 1].setImageResource(R.drawable.yoshi_yellow);
                    arr[i - 1].setTag(R.drawable.yoshi_yellow);
                    break;
                default:
                    arr[i - 1].setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }
        }
    }

    /**
     * takes in the number of players, calls randFrame() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     *
     * @param playerNumber is the number of characters that need randomized frames
     */
    private void setFrameImage(int playerNumber, String frameType) {
        ImageView frameImage1 = findViewById(R.id.frame_image_p1);
        ImageView frameImage2 = findViewById(R.id.frame_image_p2);
        ImageView frameImage3 = findViewById(R.id.frame_image_p3);
        ImageView frameImage4 = findViewById(R.id.frame_image_p4);
        ImageView[] arr = {frameImage1, frameImage2, frameImage3, frameImage4};

        String randFrame;
        for (int i = playerNumber; i >= 1; i--) {
            switch (frameType) {
                case "Bike":
                    randFrame = randFrameBike();
                    break;
                case "Kart":
                    randFrame = randFrameKart();
                    break;
                case "All":
                    randFrame = randFrameAll();
                    break;
                default:
                    randFrame = "ERROR";
            }
            switch (randFrame) {
                case "Standard Kart":
                    arr[i - 1].setImageResource(R.drawable.standard_kart);
                    arr[i - 1].setTag(R.drawable.standard_kart);
                    break;
                case "Pipe Frame":
                    arr[i - 1].setImageResource(R.drawable.pipe_frame);
                    arr[i - 1].setTag(R.drawable.pipe_frame);
                    break;
                case "Mach 8":
                    arr[i - 1].setImageResource(R.drawable.mach_8);
                    arr[i - 1].setTag(R.drawable.mach_8);
                    break;
                case "Steel Driver":
                    arr[i - 1].setImageResource(R.drawable.steel_driver);
                    arr[i - 1].setTag(R.drawable.steel_driver);
                    break;
                case "Cat Cruiser":
                    arr[i - 1].setImageResource(R.drawable.cat_cruiser);
                    arr[i - 1].setTag(R.drawable.cat_cruiser);
                    break;
                case "Circuit Special":
                    arr[i - 1].setImageResource(R.drawable.circuit_special);
                    arr[i - 1].setTag(R.drawable.circuit_special);
                    break;
                case "Tri-Speeder":
                    arr[i - 1].setImageResource(R.drawable.trispeeder);
                    arr[i - 1].setTag(R.drawable.trispeeder);
                    break;
                case "Badwagon":
                    arr[i - 1].setImageResource(R.drawable.badwagon);
                    arr[i - 1].setTag(R.drawable.badwagon);
                    break;
                case "Prancer":
                    arr[i - 1].setImageResource(R.drawable.prancer);
                    arr[i - 1].setTag(R.drawable.prancer);
                    break;
                case "Biddybuggy":
                    arr[i - 1].setImageResource(R.drawable.biddybuggy);
                    arr[i - 1].setTag(R.drawable.biddybuggy);
                    break;
                case "Landship":
                    arr[i - 1].setImageResource(R.drawable.landship);
                    arr[i - 1].setTag(R.drawable.landship);
                    break;
                case "Sneeker":
                    arr[i - 1].setImageResource(R.drawable.sneeker);
                    arr[i - 1].setTag(R.drawable.sneeker);
                    break;
                case "Sports Coupe":
                    arr[i - 1].setImageResource(R.drawable.sports_coupe);
                    arr[i - 1].setTag(R.drawable.sports_coupe);
                    break;
                case "Gold Standard":
                    arr[i - 1].setImageResource(R.drawable.gold_standard);
                    arr[i - 1].setTag(R.drawable.gold_standard);
                    break;
                case "GLA":
                    arr[i - 1].setImageResource(R.drawable.gla);
                    arr[i - 1].setTag(R.drawable.gla);
                    break;
                case "W 25 Silver Arrow":
                    arr[i - 1].setImageResource(R.drawable.silver_arrow);
                    arr[i - 1].setTag(R.drawable.silver_arrow);
                    break;
                case "300 SL Roadster":
                    arr[i - 1].setImageResource(R.drawable.roadster);
                    arr[i - 1].setTag(R.drawable.roadster);
                    break;
                case "Blue Falcon":
                    arr[i - 1].setImageResource(R.drawable.blue_falcon);
                    arr[i - 1].setTag(R.drawable.blue_falcon);
                    break;
                case "Tanooki Kart":
                    arr[i - 1].setImageResource(R.drawable.tanooki_kart);
                    arr[i - 1].setTag(R.drawable.tanooki_kart);
                    break;
                case "B Dasher":
                    arr[i - 1].setImageResource(R.drawable.b_dasher);
                    arr[i - 1].setTag(R.drawable.b_dasher);
                    break;
                case "Streetle":
                    arr[i - 1].setImageResource(R.drawable.streetle);
                    arr[i - 1].setTag(R.drawable.streetle);
                    break;
                case "P-Wing":
                    arr[i - 1].setImageResource(R.drawable.p_wing);
                    arr[i - 1].setTag(R.drawable.p_wing);
                    break;
                case "Koopa Clown":
                    arr[i - 1].setImageResource(R.drawable.koopa_clown);
                    arr[i - 1].setTag(R.drawable.koopa_clown);
                    break;
                case "Standard Bike":
                    arr[i - 1].setImageResource(R.drawable.standard_bike);
                    arr[i - 1].setTag(R.drawable.standard_bike);
                    break;
                case "The Duke":
                    arr[i - 1].setImageResource(R.drawable.the_duke);
                    arr[i - 1].setTag(R.drawable.the_duke);
                    break;
                case "Flame Rider":
                    arr[i - 1].setImageResource(R.drawable.flame_rider);
                    arr[i - 1].setTag(R.drawable.flame_rider);
                    break;
                case "Varmint":
                    arr[i - 1].setImageResource(R.drawable.varmint);
                    arr[i - 1].setTag(R.drawable.varmint);
                    break;
                case "Mr. Scooty":
                    arr[i - 1].setImageResource(R.drawable.mr_scooty);
                    arr[i - 1].setTag(R.drawable.mr_scooty);
                    break;
                case "City Tripper":
                    arr[i - 1].setImageResource(R.drawable.city_tripper);
                    arr[i - 1].setTag(R.drawable.city_tripper);
                    break;
                case "Master Cycle Zero":
                    arr[i - 1].setImageResource(R.drawable.master_cycle_zero);
                    arr[i - 1].setTag(R.drawable.master_cycle_zero);
                    break;
                case "Comet":
                    arr[i - 1].setImageResource(R.drawable.comet);
                    arr[i - 1].setTag(R.drawable.comet);
                    break;
                case "Sports Bike":
                    arr[i - 1].setImageResource(R.drawable.sports_bike);
                    arr[i - 1].setTag(R.drawable.sports_bike);
                    break;
                case "Jet Bike":
                    arr[i - 1].setImageResource(R.drawable.jet_bike);
                    arr[i - 1].setTag(R.drawable.jet_bike);
                    break;
                case "Master Cycle":
                    arr[i - 1].setImageResource(R.drawable.master_cycle);
                    arr[i - 1].setTag(R.drawable.master_cycle);
                    break;
                case "Yoshi Bike":
                    arr[i - 1].setImageResource(R.drawable.yoshi_bike);
                    arr[i - 1].setTag(R.drawable.yoshi_bike);
                    break;
                case "Standard ATV":
                    arr[i - 1].setImageResource(R.drawable.standard_atv);
                    arr[i - 1].setTag(R.drawable.standard_atv);
                    break;
                case "Wild Wiggler":
                    arr[i - 1].setImageResource(R.drawable.wild_wiggler);
                    arr[i - 1].setTag(R.drawable.wild_wiggler);
                    break;
                case "Teddy Buggy":
                    arr[i - 1].setImageResource(R.drawable.teddy_buggy);
                    arr[i - 1].setTag(R.drawable.teddy_buggy);
                    break;
                case "Bone Rattler":
                    arr[i - 1].setImageResource(R.drawable.bone_rattler);
                    arr[i - 1].setTag(R.drawable.bone_rattler);
                    break;
                case "Splat Buggy":
                    arr[i - 1].setImageResource(R.drawable.splat_buggy);
                    arr[i - 1].setTag(R.drawable.splat_buggy);
                    break;
                case "Inkstriker":
                    arr[i - 1].setImageResource(R.drawable.inkstriker);
                    arr[i - 1].setTag(R.drawable.inkstriker);
                    break;
                default:
                    arr[i - 1].setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }
        }
    }

    /**
     * takes in the number of players, calls randFrame() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     *
     * @param playerNumber is the number of characters that need randomized wheels
     */
    private void setWheelImage(int playerNumber) {
        ImageView wheelImage1 = findViewById(R.id.wheel_image_p1);
        ImageView wheelImage2 = findViewById(R.id.wheel_image_p2);
        ImageView wheelImage3 = findViewById(R.id.wheel_image_p3);
        ImageView wheelImage4 = findViewById(R.id.wheel_image_p4);
        ImageView[] arr = {wheelImage1, wheelImage2, wheelImage3, wheelImage4};

        for (int i = playerNumber; i >= 1; i--) {
            String randWheel = randWheels();
            switch (randWheel) {
                case "StandardTires":
                    arr[i - 1].setImageResource(R.drawable.standard_tires);
                    arr[i - 1].setTag(R.drawable.standard_tires);
                    break;
                case "MonsterTires":
                    arr[i - 1].setImageResource(R.drawable.monster_tires);
                    arr[i - 1].setTag(R.drawable.monster_tires);
                    break;
                case "RollerTires":
                    arr[i - 1].setImageResource(R.drawable.roller_tires);
                    arr[i - 1].setTag(R.drawable.roller_tires);
                    break;
                case "SlimTires":
                    arr[i - 1].setImageResource(R.drawable.slim_tires);
                    arr[i - 1].setTag(R.drawable.slim_tires);
                    break;
                case "SlickTires":
                    arr[i - 1].setImageResource(R.drawable.slick_tires);
                    arr[i - 1].setTag(R.drawable.slick_tires);
                    break;
                case "MetalTires":
                    arr[i - 1].setImageResource(R.drawable.metal_tires);
                    arr[i - 1].setTag(R.drawable.metal_tires);
                    break;
                case "ButtonTires":
                    arr[i - 1].setImageResource(R.drawable.button_tires);
                    arr[i - 1].setTag(R.drawable.button_tires);
                    break;
                case "Off-RoadTires":
                    arr[i - 1].setImageResource(R.drawable.off_road_tires);
                    arr[i - 1].setTag(R.drawable.off_road_tires);
                    break;
                case "SpongeTires":
                    arr[i - 1].setImageResource(R.drawable.sponge_tires);
                    arr[i - 1].setTag(R.drawable.sponge_tires);
                    break;
                case "WoodTires":
                    arr[i - 1].setImageResource(R.drawable.wood_tires);
                    arr[i - 1].setTag(R.drawable.wood_tires);
                    break;
                case "CushionTires":
                    arr[i - 1].setImageResource(R.drawable.cushion_tires);
                    arr[i - 1].setTag(R.drawable.cushion_tires);
                    break;
                case "Blue StandardTires":
                    arr[i - 1].setImageResource(R.drawable.blue_standard_tires);
                    arr[i - 1].setTag(R.drawable.blue_standard_tires);
                    break;
                case "Hot MonsterTires":
                    arr[i - 1].setImageResource(R.drawable.monster_tires_hot);
                    arr[i - 1].setTag(R.drawable.monster_tires_hot);
                    break;
                case "Azure RollerTires":
                    arr[i - 1].setImageResource(R.drawable.roller_tires_azure);
                    arr[i - 1].setTag(R.drawable.roller_tires_azure);
                    break;
                case "Crimson SlimTires":
                    arr[i - 1].setImageResource(R.drawable.slim_tires_crimson);
                    arr[i - 1].setTag(R.drawable.slim_tires_crimson);
                    break;
                case "Cyber SlickTires":
                    arr[i - 1].setImageResource(R.drawable.slick_tires_cyber);
                    arr[i - 1].setTag(R.drawable.slick_tires_cyber);
                    break;
                case "Retro Off-RoadTires":
                    arr[i - 1].setImageResource(R.drawable.off_road_tires_retro);
                    arr[i - 1].setTag(R.drawable.off_road_tires_retro);
                    break;
                case "Gold Tires":
                    arr[i - 1].setImageResource(R.drawable.gold_tires);
                    arr[i - 1].setTag(R.drawable.gold_tires);
                    break;
                case "GLA Tires":
                    arr[i - 1].setImageResource(R.drawable.gla_tires);
                    arr[i - 1].setTag(R.drawable.gla_tires);
                    break;
                case "Triforce Tires":
                    arr[i - 1].setImageResource(R.drawable.triforce_tires);
                    arr[i - 1].setTag(R.drawable.triforce_tires);
                    break;
                case "Leaf Tires":
                    arr[i - 1].setImageResource(R.drawable.leaf_tires);
                    arr[i - 1].setTag(R.drawable.leaf_tires);
                    break;
                case "Ancient Tires":
                    arr[i - 1].setImageResource(R.drawable.ancient_tires);
                    arr[i - 1].setTag(R.drawable.ancient_tires);
                    break;
                default:
                    arr[i - 1].setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }
        }
    }

    /**
     * takes in the number of players, calls randGlider() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     *
     * @param playerNumber is the number of characters that need randomized gliders
     */
    private void setGliderImage(int playerNumber) {
        ImageView gliderImage1 = findViewById(R.id.glider_image_p1);
        ImageView gliderImage2 = findViewById(R.id.glider_image_p2);
        ImageView gliderImage3 = findViewById(R.id.glider_image_p3);
        ImageView gliderImage4 = findViewById(R.id.glider_image_p4);
        ImageView[] arr = {gliderImage1, gliderImage2, gliderImage3, gliderImage4};


        for (int i = playerNumber; i >= 1; i--) {
            String randGlider = randGlider();
            switch (randGlider) {
                case "Super Glider":
                    arr[i - 1].setImageResource(R.drawable.super_glider);
                    arr[i - 1].setTag(R.drawable.super_glider);
                    break;
                case "Cloud Glider":
                    arr[i - 1].setImageResource(R.drawable.cloud_glider);
                    arr[i - 1].setTag(R.drawable.cloud_glider);
                    break;
                case "Wario Wing":
                    arr[i - 1].setImageResource(R.drawable.wario_wing);
                    arr[i - 1].setTag(R.drawable.wario_wing);
                    break;
                case "Waddle Wing":
                    arr[i - 1].setImageResource(R.drawable.waddle_wing);
                    arr[i - 1].setTag(R.drawable.waddle_wing);
                    break;
                case "Peach Parasol":
                    arr[i - 1].setImageResource(R.drawable.parasol);
                    arr[i - 1].setTag(R.drawable.parasol);
                    break;
                case "Parachute":
                    arr[i - 1].setImageResource(R.drawable.parachute);
                    arr[i - 1].setTag(R.drawable.parachute);
                    break;
                case "Parafoil":
                    arr[i - 1].setImageResource(R.drawable.parafoil);
                    arr[i - 1].setTag(R.drawable.parafoil);
                    break;
                case "Flower Glider":
                    arr[i - 1].setImageResource(R.drawable.flower_glider);
                    arr[i - 1].setTag(R.drawable.flower_glider);
                    break;
                case "Bowser Kite":
                    arr[i - 1].setImageResource(R.drawable.bowser_kite);
                    arr[i - 1].setTag(R.drawable.bowser_kite);
                    break;
                case "Plane Glider":
                    arr[i - 1].setImageResource(R.drawable.plane_glider);
                    arr[i - 1].setTag(R.drawable.plane_glider);
                    break;
                case "MKTV Parafoil":
                    arr[i - 1].setImageResource(R.drawable.parafoil_mktv);
                    arr[i - 1].setTag(R.drawable.parafoil_mktv);
                    break;
                case "Gold Glider":
                    arr[i - 1].setImageResource(R.drawable.gold_glider);
                    arr[i - 1].setTag(R.drawable.gold_glider);
                    break;
                case "Hylian Kite":
                    arr[i - 1].setImageResource(R.drawable.hylian_kite);
                    arr[i - 1].setTag(R.drawable.hylian_kite);
                    break;
                case "Paper Glider":
                    arr[i - 1].setImageResource(R.drawable.paper_glider);
                    arr[i - 1].setTag(R.drawable.paper_glider);
                    break;
                case "Paraglider":
                    arr[i - 1].setImageResource(R.drawable.paraglider);
                    arr[i - 1].setTag(R.drawable.paraglider);
                    break;
                default:
                    arr[i - 1].setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
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
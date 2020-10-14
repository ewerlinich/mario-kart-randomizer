package com.ewer.mariokartcharacterrandomizer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayRandomBuilds extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_random_bikes);

        Intent intent = getIntent();
        int playerNumber = intent.getIntExtra("PlayerNumber", 1);
        String frameType = intent.getStringExtra("FrameType");

        setPlayerText(playerNumber);
        setCharImage(playerNumber);
        setFrameImage(playerNumber, frameType);
        setWheelImage(playerNumber);
        setGliderImage(playerNumber);
    }

    /**
     * randCharacter() returns a random String from a list of character names
     *
     * @return a String that is the name of the random character
     */
    private String randCharacter() {
        String[] list = {"Mario", "Luigi", "Peach", "Daisy", "Rosalina", "Tanooki Mario",
                "Cat Peach", "Yoshi", "Toad", "Koopa Troopa", "Shy Guy", "Lakitu", "Toadette",
                "King Boo", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Baby Rosalina",
                "Metal Mario", "Pink Gold Peach", "Wario", "Waluigi", "Donkey Kong", "Bowser",
                "Dry Bones", "Bowser Jr.", "Dry Bowser", "Lemmy", "Larry", "Wendy", "Ludwig",
                "Iggy", "Roy", "Morton", "Inkling Girl", "Inkling Boy", "Link", "Villager (B)",
                "Villager (G)", "Isabelle", "Mii"};
        return list[((int) (Math.random() * list.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randFrame() returns a random String from a list of bike frames
     *
     * @return a String that is the name of the frame
     */
    private String randBikeFrame() {
        String[] list = {"Standard Bike", "Comet", "Sport Bike", "The Duke", "Flame Rider",
                "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike", "Master Cycle", "City Tripper",
                "Master Cycle Zero"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * randFrame() returns a random String from a list of kart frames
     * @return a String that is the name of the frame
     */
    private String randKartFrame() {
        String[] list = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
                "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship",
                "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow",
                "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing",
                "Koopa Clown", "Standard ATV", "Wild Wiggler", "Teddy Buggy", "Bone Rattler",
                "Splat Buggy", "Inkstriker"};
        return list[((int) (Math.random() * list.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randAllFrame() returns a random String from a list of kart and bike frames
     * @return a String that is the name of the frame
     */
    private String randAllFrame() {
        String[] list = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
                "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship",
                "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow",
                "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing",
                "Koopa Clown", "Standard Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty",
                "City Tripper", "Master Cycle Zero", "Comet", "Sports Bike", "Jet Bike",
                "Yoshi Bike", "Master Cycle", "Standard ATV", "Wild Wiggler", "Teddy Buggy",
                "Bone Rattler", "Splat Buggy", "Inkstriker"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * randFrame() returns a random String from a list of wheels
     *
     * @return a String that is the name of the wheels
     */
    private String randWheels() {
        String[] list = {"Standard Tires", "MonsterTires", "RollerTires", "SlimTires",
                "SlickTires", "MetalTires", "ButtonTires", "Off-RoadTires", "SpongeTires",
                "WoodTires", "CushionTires", "Blue StandardTires", "Hot MonsterTires",
                "Azure RollerTires", "Crimson SlimTires", "Cyber SlickTires",
                "Retro Off-RoadTires", "Gold Tires", "GLA Tires", "Triforce Tires", "Leaf Tires",
                "Ancient Tires"};
        return list[((int) (Math.random() * list.length))]; // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * randGlider() returns a random String from a list of gliders
     *
     * @return a String that is the name of the glider
     */
    private String randGlider() {
        String[] list = {"Super Glider", "Cloud Glider", "Wario Wing", "Waddle Wing",
                "Peach Parasol", "Parachute", "Parafoil", "Flower Glider", "Bowser Kite",
                "Plane Glider", "MKTV Parafoil", "Gold Glider", "Hylian Kite", "Paper Glider",
                "Paraglider"};
        return list[((int) (Math.random() * list.length))];  // returns a random item from the list by putting in a random integer for the index number
    }

    /**
     * If the random character is one that has multiple color palettes, this method goes about choosing a random color out of the selection per character
     *
     * @param randChar is the character that is being assigned a color
     * @return the character that was inputted as the character, concatenated with the random color palette
     */
    private String setColor(String randChar) {
        int color;
        String character = "";
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
     * Only make the text for players 2 through 4 visible if that many builds are selected
     *
     * @param playerNumber the number of players to make visible
     */
    private void setPlayerText(int playerNumber) {
        switch (playerNumber) {
            case 4:
                TextView textView4 = findViewById(R.id.player_text_p4);
                textView4.setText(R.string.player4);
            case 3:
                TextView textView3 = findViewById(R.id.player_text_p3);
                textView3.setText(R.string.player3);
            case 2:
                TextView textView2 = findViewById(R.id.player_text_p2);
                textView2.setText(R.string.player2);
                break;
            default:
                // uuuuuhhh shalom?
        }
    }

    /**
     * takes in the number of players, calls randCharacter() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     *
     * @param playerNumber is the number of characters that need randomized characters
     */
    private void setCharImage(int playerNumber) {
        ImageView charImage1 = findViewById(R.id.char_image_p1);
        ImageView charImage2 = findViewById(R.id.char_image_p2);
        ImageView charImage3 = findViewById(R.id.char_image_p3);
        ImageView charImage4 = findViewById(R.id.char_image_p4);
        ImageView[] arr = {charImage1, charImage2, charImage3, charImage4};

        for(int i = playerNumber; i >= 1; i--) {
            String randChar = randCharacter();
            if (randChar.equals("Yoshi") || randChar.equals("Shy Guy")
                    || randChar.equals("Metal Mario") || randChar.equals("Link")
                    || randChar.equals("Inkling Boy") || randChar.equals("Inkling Girl")) {
                randChar = setColor(randChar);
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
                    arr[i - 1].setImageResource(R.drawable.gold_mario);
                    arr[i - 1].setTag(R.drawable.gold_mario);
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
                    arr[i - 1].setImageResource(R.drawable.metal_mario);
                    arr[i - 1].setTag(R.drawable.metal_mario);
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
        for(int i = playerNumber; i >= 1; i--) {
            switch(frameType) {
                case "Bike":
                    randFrame = randBikeFrame();
                    break;
                case "Kart":
                    randFrame = randKartFrame();
                    break;
                case "All":
                    randFrame = randAllFrame();
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

        for(int i = playerNumber; i >= 1; i--) {
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
                    arr[i - 1].setImageResource(R.drawable.off_road);
                    arr[i - 1].setTag(R.drawable.off_road);
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
                    arr[i - 1].setImageResource(R.drawable.hot_monster_tires);
                    arr[i - 1].setTag(R.drawable.hot_monster_tires);
                    break;
                case "Azure RollerTires":
                    arr[i - 1].setImageResource(R.drawable.azure_rollers);
                    arr[i - 1].setTag(R.drawable.azure_rollers);
                    break;
                case "Crimson SlimTires":
                    arr[i - 1].setImageResource(R.drawable.crimson_slim_tires);
                    arr[i - 1].setTag(R.drawable.crimson_slim_tires);
                    break;
                case "Cyber SlickTires":
                    arr[i - 1].setImageResource(R.drawable.cyber_slick_tires);
                    arr[i - 1].setTag(R.drawable.cyber_slick_tires);
                    break;
                case "Retro Off-RoadTires":
                    arr[i - 1].setImageResource(R.drawable.retro_off_road);
                    arr[i - 1].setTag(R.drawable.retro_off_road);
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


        for(int i = playerNumber; i >= 1; i--) {
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
                    arr[i - 1].setImageResource(R.drawable.mktv_parafoil);
                    arr[i - 1].setTag(R.drawable.mktv_parafoil);
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
     * @param img the ImageView that the tag ID is being extracted from
     * @return the ID int that corresponds to the given resource
     */
    public int getResourceId(ImageView img) {
        return (int) (img.getTag());
    }

    /**
     * the onClick action for the player 1 character
     * @param view is the current view
     */
    public void bikesCharImage1(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.char_image_p1);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.baby_daisy:
                tv.setText(R.string.baby_daisy);
                break;
            case R.drawable.baby_luigi:
                tv.setText(R.string.baby_luigi);
                break;
            case R.drawable.baby_mario:
                tv.setText(R.string.baby_mario);
                break;
            case R.drawable.baby_peach:
                tv.setText(R.string.baby_peach);
                break;
            case R.drawable.baby_rosalina:
                tv.setText(R.string.baby_rosalina);
                break;
            case R.drawable.bowser:
                tv.setText(R.string.bowser);
                break;
            case R.drawable.bowser_jr:
                tv.setText(R.string.bowser_jr);
                break;
            case R.drawable.cat_peach:
                tv.setText(R.string.cat_peach);
                break;
            case R.drawable.daisy:
                tv.setText(R.string.daisy);
                break;
            case R.drawable.donkey_kong:
                tv.setText(R.string.donkey_kong);
                break;
            case R.drawable.dry_bones:
                tv.setText(R.string.dry_bones);
                break;
            case R.drawable.dry_bowser:
                tv.setText(R.string.dry_bowser);
                break;
            case R.drawable.gold_mario:
                tv.setText(R.string.metal_mario_gold);
                break;
            case R.drawable.iggy:
                tv.setText(R.string.iggy);
                break;
            case R.drawable.inkling_boy_darkblue:
                tv.setText(R.string.inkling_boy_darkblue);
                break;
            case R.drawable.inkling_boy_lightblue:
                tv.setText(R.string.inkling_boy_lightblue);
                break;
            case R.drawable.inkling_boy_purple:
                tv.setText(R.string.inkling_boy_purple);
                break;
            case R.drawable.inkling_girl_green:
                tv.setText(R.string.inkling_girl_green);
                break;
            case R.drawable.inkling_girl_orange:
                tv.setText(R.string.inkling_girl_orange);
                break;
            case R.drawable.inkling_girl_pink:
                tv.setText(R.string.inkling_girl_pink);
                break;
            case R.drawable.isabelle:
                tv.setText(R.string.isabelle);
                break;
            case R.drawable.king_boo:
                tv.setText(R.string.king_boo);
                break;
            case R.drawable.koopa_troopa:
                tv.setText(R.string.koopa_troopa);
                break;
            case R.drawable.lakitu:
                tv.setText(R.string.lakitu);
                break;
            case R.drawable.larry:
                tv.setText(R.string.larry);
                break;
            case R.drawable.lemmy:
                tv.setText(R.string.lemmy);
                break;
            case R.drawable.link_botw:
                tv.setText(R.string.link_botw);
                break;
            case R.drawable.link_classic:
                tv.setText(R.string.link_classic);
                break;
            case R.drawable.ludwig:
                tv.setText(R.string.ludwig);
                break;
            case R.drawable.luigi:
                tv.setText(R.string.luigi);
                break;
            case R.drawable.mario:
                tv.setText(R.string.mario);
                break;
            case R.drawable.metal_mario:
                tv.setText(R.string.metal_mario_metal);
                break;
            case R.drawable.mii:
                tv.setText(R.string.mii);
                break;
            case R.drawable.morton:
                tv.setText(R.string.morton);
                break;
            case R.drawable.peach:
                tv.setText(R.string.peach);
                break;
            case R.drawable.pink_gold_peach:
                tv.setText(R.string.pink_gold_peach);
                break;
            case R.drawable.rosalina:
                tv.setText(R.string.rosalina);
                break;
            case R.drawable.roy:
                tv.setText(R.string.roy);
                break;
            case R.drawable.shyguy_black:
                tv.setText(R.string.shy_guy_black);
                break;
            case R.drawable.shyguy_darkblue:
                tv.setText(R.string.shy_guy_darkblue);
                break;
            case R.drawable.shyguy_green:
                tv.setText(R.string.shy_guy_green);
                break;
            case R.drawable.shyguy_lightblue:
                tv.setText(R.string.shy_guy_lightblue);
                break;
            case R.drawable.shyguy_orange:
                tv.setText(R.string.shy_guy_orange);
                break;
            case R.drawable.shyguy_pink:
                tv.setText(R.string.shy_guy_pink);
                break;
            case R.drawable.shyguy_red:
                tv.setText(R.string.shy_guy_red);
                break;
            case R.drawable.shyguy_white:
                tv.setText(R.string.shy_guy_white);
                break;
            case R.drawable.shyguy_yellow:
                tv.setText(R.string.shy_guy_yellow);
                break;
            case R.drawable.tanooki_mario:
                tv.setText(R.string.tanooki_mario);
                break;
            case R.drawable.toad:
                tv.setText(R.string.toad);
                break;
            case R.drawable.toadette:
                tv.setText(R.string.toadette);
                break;
            case R.drawable.villager_boy:
                tv.setText(R.string.villager_boy);
                break;
            case R.drawable.villager_girl:
                tv.setText(R.string.villager_girl);
                break;
            case R.drawable.waluigi:
                tv.setText(R.string.waluigi);
                break;
            case R.drawable.wario:
                tv.setText(R.string.wario);
                break;
            case R.drawable.wendy:
                tv.setText(R.string.wendy);
                break;
            case R.drawable.yoshi_black:
                tv.setText(R.string.yoshi_black);
                break;
            case R.drawable.yoshi_darkblue:
                tv.setText(R.string.yoshi_darkblue);
                break;
            case R.drawable.yoshi_green:
                tv.setText(R.string.yoshi_green);
                break;
            case R.drawable.yoshi_lightblue:
                tv.setText(R.string.yoshi_lightblue);
                break;
            case R.drawable.yoshi_orange:
                tv.setText(R.string.yoshi_orange);
                break;
            case R.drawable.yoshi_pink:
                tv.setText(R.string.yoshi_pink);
                break;
            case R.drawable.yoshi_red:
                tv.setText(R.string.yoshi_red);
                break;
            case R.drawable.yoshi_white:
                tv.setText(R.string.yoshi_white);
                break;
            case R.drawable.yoshi_yellow:
                tv.setText(R.string.yoshi_yellow);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 2 character
     * @param view is the current view
     */
    public void bikesCharImage2(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.char_image_p2);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.baby_daisy:
                tv.setText(R.string.baby_daisy);
                break;
            case R.drawable.baby_luigi:
                tv.setText(R.string.baby_luigi);
                break;
            case R.drawable.baby_mario:
                tv.setText(R.string.baby_mario);
                break;
            case R.drawable.baby_peach:
                tv.setText(R.string.baby_peach);
                break;
            case R.drawable.baby_rosalina:
                tv.setText(R.string.baby_rosalina);
                break;
            case R.drawable.bowser:
                tv.setText(R.string.bowser);
                break;
            case R.drawable.bowser_jr:
                tv.setText(R.string.bowser_jr);
                break;
            case R.drawable.cat_peach:
                tv.setText(R.string.cat_peach);
                break;
            case R.drawable.daisy:
                tv.setText(R.string.daisy);
                break;
            case R.drawable.donkey_kong:
                tv.setText(R.string.donkey_kong);
                break;
            case R.drawable.dry_bones:
                tv.setText(R.string.dry_bones);
                break;
            case R.drawable.dry_bowser:
                tv.setText(R.string.dry_bowser);
                break;
            case R.drawable.gold_mario:
                tv.setText(R.string.metal_mario_gold);
                break;
            case R.drawable.iggy:
                tv.setText(R.string.iggy);
                break;
            case R.drawable.inkling_boy_darkblue:
                tv.setText(R.string.inkling_boy_darkblue);
                break;
            case R.drawable.inkling_boy_lightblue:
                tv.setText(R.string.inkling_boy_lightblue);
                break;
            case R.drawable.inkling_boy_purple:
                tv.setText(R.string.inkling_boy_purple);
                break;
            case R.drawable.inkling_girl_green:
                tv.setText(R.string.inkling_girl_green);
                break;
            case R.drawable.inkling_girl_orange:
                tv.setText(R.string.inkling_girl_orange);
                break;
            case R.drawable.inkling_girl_pink:
                tv.setText(R.string.inkling_girl_pink);
                break;
            case R.drawable.isabelle:
                tv.setText(R.string.isabelle);
                break;
            case R.drawable.king_boo:
                tv.setText(R.string.king_boo);
                break;
            case R.drawable.koopa_troopa:
                tv.setText(R.string.koopa_troopa);
                break;
            case R.drawable.lakitu:
                tv.setText(R.string.lakitu);
                break;
            case R.drawable.larry:
                tv.setText(R.string.larry);
                break;
            case R.drawable.lemmy:
                tv.setText(R.string.lemmy);
                break;
            case R.drawable.link_botw:
                tv.setText(R.string.link_botw);
                break;
            case R.drawable.link_classic:
                tv.setText(R.string.link_classic);
                break;
            case R.drawable.ludwig:
                tv.setText(R.string.ludwig);
                break;
            case R.drawable.luigi:
                tv.setText(R.string.luigi);
                break;
            case R.drawable.mario:
                tv.setText(R.string.mario);
                break;
            case R.drawable.metal_mario:
                tv.setText(R.string.metal_mario_metal);
                break;
            case R.drawable.mii:
                tv.setText(R.string.mii);
                break;
            case R.drawable.morton:
                tv.setText(R.string.morton);
                break;
            case R.drawable.peach:
                tv.setText(R.string.peach);
                break;
            case R.drawable.pink_gold_peach:
                tv.setText(R.string.pink_gold_peach);
                break;
            case R.drawable.rosalina:
                tv.setText(R.string.rosalina);
                break;
            case R.drawable.roy:
                tv.setText(R.string.roy);
                break;
            case R.drawable.shyguy_black:
                tv.setText(R.string.shy_guy_black);
                break;
            case R.drawable.shyguy_darkblue:
                tv.setText(R.string.shy_guy_darkblue);
                break;
            case R.drawable.shyguy_green:
                tv.setText(R.string.shy_guy_green);
                break;
            case R.drawable.shyguy_lightblue:
                tv.setText(R.string.shy_guy_lightblue);
                break;
            case R.drawable.shyguy_orange:
                tv.setText(R.string.shy_guy_orange);
                break;
            case R.drawable.shyguy_pink:
                tv.setText(R.string.shy_guy_pink);
                break;
            case R.drawable.shyguy_red:
                tv.setText(R.string.shy_guy_red);
                break;
            case R.drawable.shyguy_white:
                tv.setText(R.string.shy_guy_white);
                break;
            case R.drawable.shyguy_yellow:
                tv.setText(R.string.shy_guy_yellow);
                break;
            case R.drawable.tanooki_mario:
                tv.setText(R.string.tanooki_mario);
                break;
            case R.drawable.toad:
                tv.setText(R.string.toad);
                break;
            case R.drawable.toadette:
                tv.setText(R.string.toadette);
                break;
            case R.drawable.villager_boy:
                tv.setText(R.string.villager_boy);
                break;
            case R.drawable.villager_girl:
                tv.setText(R.string.villager_girl);
                break;
            case R.drawable.waluigi:
                tv.setText(R.string.waluigi);
                break;
            case R.drawable.wario:
                tv.setText(R.string.wario);
                break;
            case R.drawable.wendy:
                tv.setText(R.string.wendy);
                break;
            case R.drawable.yoshi_black:
                tv.setText(R.string.yoshi_black);
                break;
            case R.drawable.yoshi_darkblue:
                tv.setText(R.string.yoshi_darkblue);
                break;
            case R.drawable.yoshi_green:
                tv.setText(R.string.yoshi_green);
                break;
            case R.drawable.yoshi_lightblue:
                tv.setText(R.string.yoshi_lightblue);
                break;
            case R.drawable.yoshi_orange:
                tv.setText(R.string.yoshi_orange);
                break;
            case R.drawable.yoshi_pink:
                tv.setText(R.string.yoshi_pink);
                break;
            case R.drawable.yoshi_red:
                tv.setText(R.string.yoshi_red);
                break;
            case R.drawable.yoshi_white:
                tv.setText(R.string.yoshi_white);
                break;
            case R.drawable.yoshi_yellow:
                tv.setText(R.string.yoshi_yellow);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 3 character
     * @param view is the current view
     */
    public void bikesCharImage3(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.char_image_p3);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.baby_daisy:
                tv.setText(R.string.baby_daisy);
                break;
            case R.drawable.baby_luigi:
                tv.setText(R.string.baby_luigi);
                break;
            case R.drawable.baby_mario:
                tv.setText(R.string.baby_mario);
                break;
            case R.drawable.baby_peach:
                tv.setText(R.string.baby_peach);
                break;
            case R.drawable.baby_rosalina:
                tv.setText(R.string.baby_rosalina);
                break;
            case R.drawable.bowser:
                tv.setText(R.string.bowser);
                break;
            case R.drawable.bowser_jr:
                tv.setText(R.string.bowser_jr);
                break;
            case R.drawable.cat_peach:
                tv.setText(R.string.cat_peach);
                break;
            case R.drawable.daisy:
                tv.setText(R.string.daisy);
                break;
            case R.drawable.donkey_kong:
                tv.setText(R.string.donkey_kong);
                break;
            case R.drawable.dry_bones:
                tv.setText(R.string.dry_bones);
                break;
            case R.drawable.dry_bowser:
                tv.setText(R.string.dry_bowser);
                break;
            case R.drawable.gold_mario:
                tv.setText(R.string.metal_mario_gold);
                break;
            case R.drawable.iggy:
                tv.setText(R.string.iggy);
                break;
            case R.drawable.inkling_boy_darkblue:
                tv.setText(R.string.inkling_boy_darkblue);
                break;
            case R.drawable.inkling_boy_lightblue:
                tv.setText(R.string.inkling_boy_lightblue);
                break;
            case R.drawable.inkling_boy_purple:
                tv.setText(R.string.inkling_boy_purple);
                break;
            case R.drawable.inkling_girl_green:
                tv.setText(R.string.inkling_girl_green);
                break;
            case R.drawable.inkling_girl_orange:
                tv.setText(R.string.inkling_girl_orange);
                break;
            case R.drawable.inkling_girl_pink:
                tv.setText(R.string.inkling_girl_pink);
                break;
            case R.drawable.isabelle:
                tv.setText(R.string.isabelle);
                break;
            case R.drawable.king_boo:
                tv.setText(R.string.king_boo);
                break;
            case R.drawable.koopa_troopa:
                tv.setText(R.string.koopa_troopa);
                break;
            case R.drawable.lakitu:
                tv.setText(R.string.lakitu);
                break;
            case R.drawable.larry:
                tv.setText(R.string.larry);
                break;
            case R.drawable.lemmy:
                tv.setText(R.string.lemmy);
                break;
            case R.drawable.link_botw:
                tv.setText(R.string.link_botw);
                break;
            case R.drawable.link_classic:
                tv.setText(R.string.link_classic);
                break;
            case R.drawable.ludwig:
                tv.setText(R.string.ludwig);
                break;
            case R.drawable.luigi:
                tv.setText(R.string.luigi);
                break;
            case R.drawable.mario:
                tv.setText(R.string.mario);
                break;
            case R.drawable.metal_mario:
                tv.setText(R.string.metal_mario_metal);
                break;
            case R.drawable.mii:
                tv.setText(R.string.mii);
                break;
            case R.drawable.morton:
                tv.setText(R.string.morton);
                break;
            case R.drawable.peach:
                tv.setText(R.string.peach);
                break;
            case R.drawable.pink_gold_peach:
                tv.setText(R.string.pink_gold_peach);
                break;
            case R.drawable.rosalina:
                tv.setText(R.string.rosalina);
                break;
            case R.drawable.roy:
                tv.setText(R.string.roy);
                break;
            case R.drawable.shyguy_black:
                tv.setText(R.string.shy_guy_black);
                break;
            case R.drawable.shyguy_darkblue:
                tv.setText(R.string.shy_guy_darkblue);
                break;
            case R.drawable.shyguy_green:
                tv.setText(R.string.shy_guy_green);
                break;
            case R.drawable.shyguy_lightblue:
                tv.setText(R.string.shy_guy_lightblue);
                break;
            case R.drawable.shyguy_orange:
                tv.setText(R.string.shy_guy_orange);
                break;
            case R.drawable.shyguy_pink:
                tv.setText(R.string.shy_guy_pink);
                break;
            case R.drawable.shyguy_red:
                tv.setText(R.string.shy_guy_red);
                break;
            case R.drawable.shyguy_white:
                tv.setText(R.string.shy_guy_white);
                break;
            case R.drawable.shyguy_yellow:
                tv.setText(R.string.shy_guy_yellow);
                break;
            case R.drawable.tanooki_mario:
                tv.setText(R.string.tanooki_mario);
                break;
            case R.drawable.toad:
                tv.setText(R.string.toad);
                break;
            case R.drawable.toadette:
                tv.setText(R.string.toadette);
                break;
            case R.drawable.villager_boy:
                tv.setText(R.string.villager_boy);
                break;
            case R.drawable.villager_girl:
                tv.setText(R.string.villager_girl);
                break;
            case R.drawable.waluigi:
                tv.setText(R.string.waluigi);
                break;
            case R.drawable.wario:
                tv.setText(R.string.wario);
                break;
            case R.drawable.wendy:
                tv.setText(R.string.wendy);
                break;
            case R.drawable.yoshi_black:
                tv.setText(R.string.yoshi_black);
                break;
            case R.drawable.yoshi_darkblue:
                tv.setText(R.string.yoshi_darkblue);
                break;
            case R.drawable.yoshi_green:
                tv.setText(R.string.yoshi_green);
                break;
            case R.drawable.yoshi_lightblue:
                tv.setText(R.string.yoshi_lightblue);
                break;
            case R.drawable.yoshi_orange:
                tv.setText(R.string.yoshi_orange);
                break;
            case R.drawable.yoshi_pink:
                tv.setText(R.string.yoshi_pink);
                break;
            case R.drawable.yoshi_red:
                tv.setText(R.string.yoshi_red);
                break;
            case R.drawable.yoshi_white:
                tv.setText(R.string.yoshi_white);
                break;
            case R.drawable.yoshi_yellow:
                tv.setText(R.string.yoshi_yellow);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 4 character
     * @param view is the current view
     */
    public void bikesCharImage4(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.char_image_p4);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.baby_daisy:
                tv.setText(R.string.baby_daisy);
                break;
            case R.drawable.baby_luigi:
                tv.setText(R.string.baby_luigi);
                break;
            case R.drawable.baby_mario:
                tv.setText(R.string.baby_mario);
                break;
            case R.drawable.baby_peach:
                tv.setText(R.string.baby_peach);
                break;
            case R.drawable.baby_rosalina:
                tv.setText(R.string.baby_rosalina);
                break;
            case R.drawable.bowser:
                tv.setText(R.string.bowser);
                break;
            case R.drawable.bowser_jr:
                tv.setText(R.string.bowser_jr);
                break;
            case R.drawable.cat_peach:
                tv.setText(R.string.cat_peach);
                break;
            case R.drawable.daisy:
                tv.setText(R.string.daisy);
                break;
            case R.drawable.donkey_kong:
                tv.setText(R.string.donkey_kong);
                break;
            case R.drawable.dry_bones:
                tv.setText(R.string.dry_bones);
                break;
            case R.drawable.dry_bowser:
                tv.setText(R.string.dry_bowser);
                break;
            case R.drawable.gold_mario:
                tv.setText(R.string.metal_mario_gold);
                break;
            case R.drawable.iggy:
                tv.setText(R.string.iggy);
                break;
            case R.drawable.inkling_boy_darkblue:
                tv.setText(R.string.inkling_boy_darkblue);
                break;
            case R.drawable.inkling_boy_lightblue:
                tv.setText(R.string.inkling_boy_lightblue);
                break;
            case R.drawable.inkling_boy_purple:
                tv.setText(R.string.inkling_boy_purple);
                break;
            case R.drawable.inkling_girl_green:
                tv.setText(R.string.inkling_girl_green);
                break;
            case R.drawable.inkling_girl_orange:
                tv.setText(R.string.inkling_girl_orange);
                break;
            case R.drawable.inkling_girl_pink:
                tv.setText(R.string.inkling_girl_pink);
                break;
            case R.drawable.isabelle:
                tv.setText(R.string.isabelle);
                break;
            case R.drawable.king_boo:
                tv.setText(R.string.king_boo);
                break;
            case R.drawable.koopa_troopa:
                tv.setText(R.string.koopa_troopa);
                break;
            case R.drawable.lakitu:
                tv.setText(R.string.lakitu);
                break;
            case R.drawable.larry:
                tv.setText(R.string.larry);
                break;
            case R.drawable.lemmy:
                tv.setText(R.string.lemmy);
                break;
            case R.drawable.link_botw:
                tv.setText(R.string.link_botw);
                break;
            case R.drawable.link_classic:
                tv.setText(R.string.link_classic);
                break;
            case R.drawable.ludwig:
                tv.setText(R.string.ludwig);
                break;
            case R.drawable.luigi:
                tv.setText(R.string.luigi);
                break;
            case R.drawable.mario:
                tv.setText(R.string.mario);
                break;
            case R.drawable.metal_mario:
                tv.setText(R.string.metal_mario_metal);
                break;
            case R.drawable.mii:
                tv.setText(R.string.mii);
                break;
            case R.drawable.morton:
                tv.setText(R.string.morton);
                break;
            case R.drawable.peach:
                tv.setText(R.string.peach);
                break;
            case R.drawable.pink_gold_peach:
                tv.setText(R.string.pink_gold_peach);
                break;
            case R.drawable.rosalina:
                tv.setText(R.string.rosalina);
                break;
            case R.drawable.roy:
                tv.setText(R.string.roy);
                break;
            case R.drawable.shyguy_black:
                tv.setText(R.string.shy_guy_black);
                break;
            case R.drawable.shyguy_darkblue:
                tv.setText(R.string.shy_guy_darkblue);
                break;
            case R.drawable.shyguy_green:
                tv.setText(R.string.shy_guy_green);
                break;
            case R.drawable.shyguy_lightblue:
                tv.setText(R.string.shy_guy_lightblue);
                break;
            case R.drawable.shyguy_orange:
                tv.setText(R.string.shy_guy_orange);
                break;
            case R.drawable.shyguy_pink:
                tv.setText(R.string.shy_guy_pink);
                break;
            case R.drawable.shyguy_red:
                tv.setText(R.string.shy_guy_red);
                break;
            case R.drawable.shyguy_white:
                tv.setText(R.string.shy_guy_white);
                break;
            case R.drawable.shyguy_yellow:
                tv.setText(R.string.shy_guy_yellow);
                break;
            case R.drawable.tanooki_mario:
                tv.setText(R.string.tanooki_mario);
                break;
            case R.drawable.toad:
                tv.setText(R.string.toad);
                break;
            case R.drawable.toadette:
                tv.setText(R.string.toadette);
                break;
            case R.drawable.villager_boy:
                tv.setText(R.string.villager_boy);
                break;
            case R.drawable.villager_girl:
                tv.setText(R.string.villager_girl);
                break;
            case R.drawable.waluigi:
                tv.setText(R.string.waluigi);
                break;
            case R.drawable.wario:
                tv.setText(R.string.wario);
                break;
            case R.drawable.wendy:
                tv.setText(R.string.wendy);
                break;
            case R.drawable.yoshi_black:
                tv.setText(R.string.yoshi_black);
                break;
            case R.drawable.yoshi_darkblue:
                tv.setText(R.string.yoshi_darkblue);
                break;
            case R.drawable.yoshi_green:
                tv.setText(R.string.yoshi_green);
                break;
            case R.drawable.yoshi_lightblue:
                tv.setText(R.string.yoshi_lightblue);
                break;
            case R.drawable.yoshi_orange:
                tv.setText(R.string.yoshi_orange);
                break;
            case R.drawable.yoshi_pink:
                tv.setText(R.string.yoshi_pink);
                break;
            case R.drawable.yoshi_red:
                tv.setText(R.string.yoshi_red);
                break;
            case R.drawable.yoshi_white:
                tv.setText(R.string.yoshi_white);
                break;
            case R.drawable.yoshi_yellow:
                tv.setText(R.string.yoshi_yellow);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 1 frame
     * @param view is the current view
     */
    public void bikesFrameImage1(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frame_image_p2);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_kart:
                tv.setText(R.string.standard_kart);
                break;
            case R.drawable.pipe_frame:
                tv.setText(R.string.pipe_frame);
                break;
            case R.drawable.mach_8:
                tv.setText(R.string.mach_8);
                break;
            case R.drawable.steel_driver:
                tv.setText(R.string.steel_driver);
                break;
            case R.drawable.cat_cruiser:
                tv.setText(R.string.cat_cruiser);
                break;
            case R.drawable.circuit_special:
                tv.setText(R.string.circuit_special);
                break;
            case R.drawable.trispeeder:
                tv.setText(R.string.tri_speeder);
                break;
            case R.drawable.badwagon:
                tv.setText(R.string.badwagon);
                break;
            case R.drawable.prancer:
                tv.setText(R.string.prancer);
                break;
            case R.drawable.biddybuggy:
                tv.setText(R.string.biddybuggy);
                break;
            case R.drawable.landship:
                tv.setText(R.string.landship);
                break;
            case R.drawable.sneeker:
                tv.setText(R.string.sneeker);
                break;
            case R.drawable.sports_coupe:
                tv.setText(R.string.sports_coupe);
                break;
            case R.drawable.gold_standard:
                tv.setText(R.string.gold_standard);
                break;
            case R.drawable.gla:
                tv.setText(R.string.gla);
                break;
            case R.drawable.silver_arrow:
                tv.setText(R.string.silver_arrow);
                break;
            case R.drawable.roadster:
                tv.setText(R.string.roadster);
                break;
            case R.drawable.blue_falcon:
                tv.setText(R.string.blue_falcon);
                break;
            case R.drawable.tanooki_kart:
                tv.setText(R.string.tanooki_kart);
                break;
            case R.drawable.b_dasher:
                tv.setText(R.string.b_dasher);
                break;
            case R.drawable.streetle:
                tv.setText(R.string.streetle);
                break;
            case R.drawable.p_wing:
                tv.setText(R.string.p_wing);
                break;
            case R.drawable.koopa_clown:
                tv.setText(R.string.koopa_clown);
                break;
            case R.drawable.standard_bike:
                tv.setText(R.string.standard_bike);
                break;
            case R.drawable.the_duke:
                tv.setText(R.string.the_duke);
                break;
            case R.drawable.flame_rider:
                tv.setText(R.string.flame_rider);
                break;
            case R.drawable.varmint:
                tv.setText(R.string.varmint);
                break;
            case R.drawable.mr_scooty:
                tv.setText(R.string.mr_scooty);
                break;
            case R.drawable.city_tripper:
                tv.setText(R.string.city_tripper);
                break;
            case R.drawable.master_cycle_zero:
                tv.setText(R.string.master_cycle_zero);
                break;
            case R.drawable.comet:
                tv.setText(R.string.comet);
                break;
            case R.drawable.sports_bike:
                tv.setText(R.string.sports_bike);
                break;
            case R.drawable.jet_bike:
                tv.setText(R.string.jet_bike);
                break;
            case R.drawable.yoshi_bike:
                tv.setText(R.string.yoshi_bike);
                break;
            case R.drawable.master_cycle:
                tv.setText(R.string.master_cycle);
                break;
            case R.drawable.standard_atv:
                tv.setText(R.string.standard_atv);
                break;
            case R.drawable.wild_wiggler:
                tv.setText(R.string.wild_wiggler);
                break;
            case R.drawable.teddy_buggy:
                tv.setText(R.string.teddy_buggy);
                break;
            case R.drawable.bone_rattler:
                tv.setText(R.string.bone_rattler);
                break;
            case R.drawable.splat_buggy:
                tv.setText(R.string.splat_buggy);
                break;
            case R.drawable.inkstriker:
                tv.setText(R.string.inkstriker);
                break;
        }
    }

    /**
     * the onClick action for the player 2 frame
     * @param view is the current view
     */
    public void bikesFrameImage2(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frame_image_p2);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_kart:
                tv.setText(R.string.standard_kart);
                break;
            case R.drawable.pipe_frame:
                tv.setText(R.string.pipe_frame);
                break;
            case R.drawable.mach_8:
                tv.setText(R.string.mach_8);
                break;
            case R.drawable.steel_driver:
                tv.setText(R.string.steel_driver);
                break;
            case R.drawable.cat_cruiser:
                tv.setText(R.string.cat_cruiser);
                break;
            case R.drawable.circuit_special:
                tv.setText(R.string.circuit_special);
                break;
            case R.drawable.trispeeder:
                tv.setText(R.string.tri_speeder);
                break;
            case R.drawable.badwagon:
                tv.setText(R.string.badwagon);
                break;
            case R.drawable.prancer:
                tv.setText(R.string.prancer);
                break;
            case R.drawable.biddybuggy:
                tv.setText(R.string.biddybuggy);
                break;
            case R.drawable.landship:
                tv.setText(R.string.landship);
                break;
            case R.drawable.sneeker:
                tv.setText(R.string.sneeker);
                break;
            case R.drawable.sports_coupe:
                tv.setText(R.string.sports_coupe);
                break;
            case R.drawable.gold_standard:
                tv.setText(R.string.gold_standard);
                break;
            case R.drawable.gla:
                tv.setText(R.string.gla);
                break;
            case R.drawable.silver_arrow:
                tv.setText(R.string.silver_arrow);
                break;
            case R.drawable.roadster:
                tv.setText(R.string.roadster);
                break;
            case R.drawable.blue_falcon:
                tv.setText(R.string.blue_falcon);
                break;
            case R.drawable.tanooki_kart:
                tv.setText(R.string.tanooki_kart);
                break;
            case R.drawable.b_dasher:
                tv.setText(R.string.b_dasher);
                break;
            case R.drawable.streetle:
                tv.setText(R.string.streetle);
                break;
            case R.drawable.p_wing:
                tv.setText(R.string.p_wing);
                break;
            case R.drawable.koopa_clown:
                tv.setText(R.string.koopa_clown);
                break;
            case R.drawable.standard_bike:
                tv.setText(R.string.standard_bike);
                break;
            case R.drawable.the_duke:
                tv.setText(R.string.the_duke);
                break;
            case R.drawable.flame_rider:
                tv.setText(R.string.flame_rider);
                break;
            case R.drawable.varmint:
                tv.setText(R.string.varmint);
                break;
            case R.drawable.mr_scooty:
                tv.setText(R.string.mr_scooty);
                break;
            case R.drawable.city_tripper:
                tv.setText(R.string.city_tripper);
                break;
            case R.drawable.master_cycle_zero:
                tv.setText(R.string.master_cycle_zero);
                break;
            case R.drawable.comet:
                tv.setText(R.string.comet);
                break;
            case R.drawable.sports_bike:
                tv.setText(R.string.sports_bike);
                break;
            case R.drawable.jet_bike:
                tv.setText(R.string.jet_bike);
                break;
            case R.drawable.yoshi_bike:
                tv.setText(R.string.yoshi_bike);
                break;
            case R.drawable.master_cycle:
                tv.setText(R.string.master_cycle);
                break;
            case R.drawable.standard_atv:
                tv.setText(R.string.standard_atv);
                break;
            case R.drawable.wild_wiggler:
                tv.setText(R.string.wild_wiggler);
                break;
            case R.drawable.teddy_buggy:
                tv.setText(R.string.teddy_buggy);
                break;
            case R.drawable.bone_rattler:
                tv.setText(R.string.bone_rattler);
                break;
            case R.drawable.splat_buggy:
                tv.setText(R.string.splat_buggy);
                break;
            case R.drawable.inkstriker:
                tv.setText(R.string.inkstriker);
                break;
        }
    }

    /**
     * the onClick action for the player 1 frame
     * @param view is the current view
     */
    public void bikesFrameImage3(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frame_image_p3);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_kart:
                tv.setText(R.string.standard_kart);
                break;
            case R.drawable.pipe_frame:
                tv.setText(R.string.pipe_frame);
                break;
            case R.drawable.mach_8:
                tv.setText(R.string.mach_8);
                break;
            case R.drawable.steel_driver:
                tv.setText(R.string.steel_driver);
                break;
            case R.drawable.cat_cruiser:
                tv.setText(R.string.cat_cruiser);
                break;
            case R.drawable.circuit_special:
                tv.setText(R.string.circuit_special);
                break;
            case R.drawable.trispeeder:
                tv.setText(R.string.tri_speeder);
                break;
            case R.drawable.badwagon:
                tv.setText(R.string.badwagon);
                break;
            case R.drawable.prancer:
                tv.setText(R.string.prancer);
                break;
            case R.drawable.biddybuggy:
                tv.setText(R.string.biddybuggy);
                break;
            case R.drawable.landship:
                tv.setText(R.string.landship);
                break;
            case R.drawable.sneeker:
                tv.setText(R.string.sneeker);
                break;
            case R.drawable.sports_coupe:
                tv.setText(R.string.sports_coupe);
                break;
            case R.drawable.gold_standard:
                tv.setText(R.string.gold_standard);
                break;
            case R.drawable.gla:
                tv.setText(R.string.gla);
                break;
            case R.drawable.silver_arrow:
                tv.setText(R.string.silver_arrow);
                break;
            case R.drawable.roadster:
                tv.setText(R.string.roadster);
                break;
            case R.drawable.blue_falcon:
                tv.setText(R.string.blue_falcon);
                break;
            case R.drawable.tanooki_kart:
                tv.setText(R.string.tanooki_kart);
                break;
            case R.drawable.b_dasher:
                tv.setText(R.string.b_dasher);
                break;
            case R.drawable.streetle:
                tv.setText(R.string.streetle);
                break;
            case R.drawable.p_wing:
                tv.setText(R.string.p_wing);
                break;
            case R.drawable.koopa_clown:
                tv.setText(R.string.koopa_clown);
                break;
            case R.drawable.standard_bike:
                tv.setText(R.string.standard_bike);
                break;
            case R.drawable.the_duke:
                tv.setText(R.string.the_duke);
                break;
            case R.drawable.flame_rider:
                tv.setText(R.string.flame_rider);
                break;
            case R.drawable.varmint:
                tv.setText(R.string.varmint);
                break;
            case R.drawable.mr_scooty:
                tv.setText(R.string.mr_scooty);
                break;
            case R.drawable.city_tripper:
                tv.setText(R.string.city_tripper);
                break;
            case R.drawable.master_cycle_zero:
                tv.setText(R.string.master_cycle_zero);
                break;
            case R.drawable.comet:
                tv.setText(R.string.comet);
                break;
            case R.drawable.sports_bike:
                tv.setText(R.string.sports_bike);
                break;
            case R.drawable.jet_bike:
                tv.setText(R.string.jet_bike);
                break;
            case R.drawable.yoshi_bike:
                tv.setText(R.string.yoshi_bike);
                break;
            case R.drawable.master_cycle:
                tv.setText(R.string.master_cycle);
                break;
            case R.drawable.standard_atv:
                tv.setText(R.string.standard_atv);
                break;
            case R.drawable.wild_wiggler:
                tv.setText(R.string.wild_wiggler);
                break;
            case R.drawable.teddy_buggy:
                tv.setText(R.string.teddy_buggy);
                break;
            case R.drawable.bone_rattler:
                tv.setText(R.string.bone_rattler);
                break;
            case R.drawable.splat_buggy:
                tv.setText(R.string.splat_buggy);
                break;
            case R.drawable.inkstriker:
                tv.setText(R.string.inkstriker);
                break;
        }
    }

    /**
     * the onClick action for the player 4 frame
     * @param view is the current view
     */
    public void bikesFrameImage4(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frame_image_p4);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_kart:
                tv.setText(R.string.standard_kart);
                break;
            case R.drawable.pipe_frame:
                tv.setText(R.string.pipe_frame);
                break;
            case R.drawable.mach_8:
                tv.setText(R.string.mach_8);
                break;
            case R.drawable.steel_driver:
                tv.setText(R.string.steel_driver);
                break;
            case R.drawable.cat_cruiser:
                tv.setText(R.string.cat_cruiser);
                break;
            case R.drawable.circuit_special:
                tv.setText(R.string.circuit_special);
                break;
            case R.drawable.trispeeder:
                tv.setText(R.string.tri_speeder);
                break;
            case R.drawable.badwagon:
                tv.setText(R.string.badwagon);
                break;
            case R.drawable.prancer:
                tv.setText(R.string.prancer);
                break;
            case R.drawable.biddybuggy:
                tv.setText(R.string.biddybuggy);
                break;
            case R.drawable.landship:
                tv.setText(R.string.landship);
                break;
            case R.drawable.sneeker:
                tv.setText(R.string.sneeker);
                break;
            case R.drawable.sports_coupe:
                tv.setText(R.string.sports_coupe);
                break;
            case R.drawable.gold_standard:
                tv.setText(R.string.gold_standard);
                break;
            case R.drawable.gla:
                tv.setText(R.string.gla);
                break;
            case R.drawable.silver_arrow:
                tv.setText(R.string.silver_arrow);
                break;
            case R.drawable.roadster:
                tv.setText(R.string.roadster);
                break;
            case R.drawable.blue_falcon:
                tv.setText(R.string.blue_falcon);
                break;
            case R.drawable.tanooki_kart:
                tv.setText(R.string.tanooki_kart);
                break;
            case R.drawable.b_dasher:
                tv.setText(R.string.b_dasher);
                break;
            case R.drawable.streetle:
                tv.setText(R.string.streetle);
                break;
            case R.drawable.p_wing:
                tv.setText(R.string.p_wing);
                break;
            case R.drawable.koopa_clown:
                tv.setText(R.string.koopa_clown);
                break;
            case R.drawable.standard_bike:
                tv.setText(R.string.standard_bike);
                break;
            case R.drawable.the_duke:
                tv.setText(R.string.the_duke);
                break;
            case R.drawable.flame_rider:
                tv.setText(R.string.flame_rider);
                break;
            case R.drawable.varmint:
                tv.setText(R.string.varmint);
                break;
            case R.drawable.mr_scooty:
                tv.setText(R.string.mr_scooty);
                break;
            case R.drawable.city_tripper:
                tv.setText(R.string.city_tripper);
                break;
            case R.drawable.master_cycle_zero:
                tv.setText(R.string.master_cycle_zero);
                break;
            case R.drawable.comet:
                tv.setText(R.string.comet);
                break;
            case R.drawable.sports_bike:
                tv.setText(R.string.sports_bike);
                break;
            case R.drawable.jet_bike:
                tv.setText(R.string.jet_bike);
                break;
            case R.drawable.yoshi_bike:
                tv.setText(R.string.yoshi_bike);
                break;
            case R.drawable.master_cycle:
                tv.setText(R.string.master_cycle);
                break;
            case R.drawable.standard_atv:
                tv.setText(R.string.standard_atv);
                break;
            case R.drawable.wild_wiggler:
                tv.setText(R.string.wild_wiggler);
                break;
            case R.drawable.teddy_buggy:
                tv.setText(R.string.teddy_buggy);
                break;
            case R.drawable.bone_rattler:
                tv.setText(R.string.bone_rattler);
                break;
            case R.drawable.splat_buggy:
                tv.setText(R.string.splat_buggy);
                break;
            case R.drawable.inkstriker:
                tv.setText(R.string.inkstriker);
                break;
        }
    }

    /**
     * the onClick action for the player 1 wheels
     * @param view is the current view
     */
    public void bikesWheelImage1(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheel_image_p1);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_tires:
                tv.setText(R.string.standard_tires);
                break;
            case R.drawable.monster_tires:
                tv.setText(R.string.monster_tires);
                break;
            case R.drawable.roller_tires:
                tv.setText(R.string.roller_wheels);
                break;
            case R.drawable.slim_tires:
                tv.setText(R.string.slim_tires);
                break;
            case R.drawable.slick_tires:
                tv.setText(R.string.slick_tires);
                break;
            case R.drawable.metal_tires:
                tv.setText(R.string.metal_wheels);
                break;
            case R.drawable.button_tires:
                tv.setText(R.string.button_wheels);
                break;
            case R.drawable.off_road:
                tv.setText(R.string.off_road_tires);
                break;
            case R.drawable.sponge_tires:
                tv.setText(R.string.sponge_tires);
                break;
            case R.drawable.wood_tires:
                tv.setText(R.string.wood_wheels);
                break;
            case R.drawable.cushion_tires:
                tv.setText(R.string.cushion_tires);
                break;
            case R.drawable.blue_standard_tires:
                tv.setText(R.string.blue_standard_tires);
                break;
            case R.drawable.hot_monster_tires:
                tv.setText(R.string.hot_monster_tires);
                break;
            case R.drawable.azure_rollers:
                tv.setText(R.string.azure_roller_wheels);
                break;
            case R.drawable.crimson_slim_tires:
                tv.setText(R.string.crimson_slim_tires);
                break;
            case R.drawable.cyber_slick_tires:
                tv.setText(R.string.cyber_slick_tires);
                break;
            case R.drawable.retro_off_road:
                tv.setText(R.string.retro_off_road_tires);
                break;
            case R.drawable.gold_tires:
                tv.setText(R.string.gold_tires);
                break;
            case R.drawable.gla_tires:
                tv.setText(R.string.gla_tires);
                break;
            case R.drawable.triforce_tires:
                tv.setText(R.string.triforce_tires);
                break;
            case R.drawable.leaf_tires:
                tv.setText(R.string.leaf_tires);
                break;
            case R.drawable.ancient_tires:
                tv.setText(R.string.ancient_tires);
                break;
        }
    }

    /**
     * the onClick action for the player 2 wheels
     * @param view is the current view
     */
    public void bikesWheelImage2(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheel_image_p2);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_tires:
                tv.setText(R.string.standard_tires);
                break;
            case R.drawable.monster_tires:
                tv.setText(R.string.monster_tires);
                break;
            case R.drawable.roller_tires:
                tv.setText(R.string.roller_wheels);
                break;
            case R.drawable.slim_tires:
                tv.setText(R.string.slim_tires);
                break;
            case R.drawable.slick_tires:
                tv.setText(R.string.slick_tires);
                break;
            case R.drawable.metal_tires:
                tv.setText(R.string.metal_wheels);
                break;
            case R.drawable.button_tires:
                tv.setText(R.string.button_wheels);
                break;
            case R.drawable.off_road:
                tv.setText(R.string.off_road_tires);
                break;
            case R.drawable.sponge_tires:
                tv.setText(R.string.sponge_tires);
                break;
            case R.drawable.wood_tires:
                tv.setText(R.string.wood_wheels);
                break;
            case R.drawable.cushion_tires:
                tv.setText(R.string.cushion_tires);
                break;
            case R.drawable.blue_standard_tires:
                tv.setText(R.string.blue_standard_tires);
                break;
            case R.drawable.hot_monster_tires:
                tv.setText(R.string.hot_monster_tires);
                break;
            case R.drawable.azure_rollers:
                tv.setText(R.string.azure_roller_wheels);
                break;
            case R.drawable.crimson_slim_tires:
                tv.setText(R.string.crimson_slim_tires);
                break;
            case R.drawable.cyber_slick_tires:
                tv.setText(R.string.cyber_slick_tires);
                break;
            case R.drawable.retro_off_road:
                tv.setText(R.string.retro_off_road_tires);
                break;
            case R.drawable.gold_tires:
                tv.setText(R.string.gold_tires);
                break;
            case R.drawable.gla_tires:
                tv.setText(R.string.gla_tires);
                break;
            case R.drawable.triforce_tires:
                tv.setText(R.string.triforce_tires);
                break;
            case R.drawable.leaf_tires:
                tv.setText(R.string.leaf_tires);
                break;
            case R.drawable.ancient_tires:
                tv.setText(R.string.ancient_tires);
                break;
        }
    }

    /**
     * the onClick action for the player 3 wheels
     * @param view is the current view
     */
    public void bikesWheelImage3(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheel_image_p3);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_tires:
                tv.setText(R.string.standard_tires);
                break;
            case R.drawable.monster_tires:
                tv.setText(R.string.monster_tires);
                break;
            case R.drawable.roller_tires:
                tv.setText(R.string.roller_wheels);
                break;
            case R.drawable.slim_tires:
                tv.setText(R.string.slim_tires);
                break;
            case R.drawable.slick_tires:
                tv.setText(R.string.slick_tires);
                break;
            case R.drawable.metal_tires:
                tv.setText(R.string.metal_wheels);
                break;
            case R.drawable.button_tires:
                tv.setText(R.string.button_wheels);
                break;
            case R.drawable.off_road:
                tv.setText(R.string.off_road_tires);
                break;
            case R.drawable.sponge_tires:
                tv.setText(R.string.sponge_tires);
                break;
            case R.drawable.wood_tires:
                tv.setText(R.string.wood_wheels);
                break;
            case R.drawable.cushion_tires:
                tv.setText(R.string.cushion_tires);
                break;
            case R.drawable.blue_standard_tires:
                tv.setText(R.string.blue_standard_tires);
                break;
            case R.drawable.hot_monster_tires:
                tv.setText(R.string.hot_monster_tires);
                break;
            case R.drawable.azure_rollers:
                tv.setText(R.string.azure_roller_wheels);
                break;
            case R.drawable.crimson_slim_tires:
                tv.setText(R.string.crimson_slim_tires);
                break;
            case R.drawable.cyber_slick_tires:
                tv.setText(R.string.cyber_slick_tires);
                break;
            case R.drawable.retro_off_road:
                tv.setText(R.string.retro_off_road_tires);
                break;
            case R.drawable.gold_tires:
                tv.setText(R.string.gold_tires);
                break;
            case R.drawable.gla_tires:
                tv.setText(R.string.gla_tires);
                break;
            case R.drawable.triforce_tires:
                tv.setText(R.string.triforce_tires);
                break;
            case R.drawable.leaf_tires:
                tv.setText(R.string.leaf_tires);
                break;
            case R.drawable.ancient_tires:
                tv.setText(R.string.ancient_tires);
                break;
        }
    }

    /**
     * the onClick action for the player 4 wheels
     * @param view is the current view
     */
    public void bikesWheelImage4(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheel_image_p4);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.standard_tires:
                tv.setText(R.string.standard_tires);
                break;
            case R.drawable.monster_tires:
                tv.setText(R.string.monster_tires);
                break;
            case R.drawable.roller_tires:
                tv.setText(R.string.roller_wheels);
                break;
            case R.drawable.slim_tires:
                tv.setText(R.string.slim_tires);
                break;
            case R.drawable.slick_tires:
                tv.setText(R.string.slick_tires);
                break;
            case R.drawable.metal_tires:
                tv.setText(R.string.metal_wheels);
                break;
            case R.drawable.button_tires:
                tv.setText(R.string.button_wheels);
                break;
            case R.drawable.off_road:
                tv.setText(R.string.off_road_tires);
                break;
            case R.drawable.sponge_tires:
                tv.setText(R.string.sponge_tires);
                break;
            case R.drawable.wood_tires:
                tv.setText(R.string.wood_wheels);
                break;
            case R.drawable.cushion_tires:
                tv.setText(R.string.cushion_tires);
                break;
            case R.drawable.blue_standard_tires:
                tv.setText(R.string.blue_standard_tires);
                break;
            case R.drawable.hot_monster_tires:
                tv.setText(R.string.hot_monster_tires);
                break;
            case R.drawable.azure_rollers:
                tv.setText(R.string.azure_roller_wheels);
                break;
            case R.drawable.crimson_slim_tires:
                tv.setText(R.string.crimson_slim_tires);
                break;
            case R.drawable.cyber_slick_tires:
                tv.setText(R.string.cyber_slick_tires);
                break;
            case R.drawable.retro_off_road:
                tv.setText(R.string.retro_off_road_tires);
                break;
            case R.drawable.gold_tires:
                tv.setText(R.string.gold_tires);
                break;
            case R.drawable.gla_tires:
                tv.setText(R.string.gla_tires);
                break;
            case R.drawable.triforce_tires:
                tv.setText(R.string.triforce_tires);
                break;
            case R.drawable.leaf_tires:
                tv.setText(R.string.leaf_tires);
                break;
            case R.drawable.ancient_tires:
                tv.setText(R.string.ancient_tires);
                break;
        }
    }

    /**
     * the onClick action for the player 1 glider
     * @param view is the current view
     */
    public void bikesGliderImage1(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.glider_image_p1);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.super_glider:
                tv.setText(R.string.super_glider);
                break;
            case R.drawable.cloud_glider:
                tv.setText(R.string.cloud_glider);
                break;
            case R.drawable.wario_wing:
                tv.setText(R.string.wario_wing);
                break;
            case R.drawable.waddle_wing:
                tv.setText(R.string.waddle_wing);
                break;
            case R.drawable.parasol:
                tv.setText(R.string.parasol);
                break;
            case R.drawable.parachute:
                tv.setText(R.string.parachute);
                break;
            case R.drawable.parafoil:
                tv.setText(R.string.parafoil);
                break;
            case R.drawable.flower_glider:
                tv.setText(R.string.flower_glider);
                break;
            case R.drawable.bowser_kite:
                tv.setText(R.string.bowser_kite);
                break;
            case R.drawable.plane_glider:
                tv.setText(R.string.plane_glider);
                break;
            case R.drawable.mktv_parafoil:
                tv.setText(R.string.mktv_parafoil);
                break;
            case R.drawable.gold_glider:
                tv.setText(R.string.gold_glider);
                break;
            case R.drawable.hylian_kite:
                tv.setText(R.string.hylian_kite);
                break;
            case R.drawable.paper_glider:
                tv.setText(R.string.paper_glider);
                break;
            case R.drawable.paraglider:
                tv.setText(R.string.paraglider);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 2 glider
     * @param view is the current view
     */
    public void bikesGliderImage2(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.glider_image_p1);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.super_glider:
                tv.setText(R.string.super_glider);
                break;
            case R.drawable.cloud_glider:
                tv.setText(R.string.cloud_glider);
                break;
            case R.drawable.wario_wing:
                tv.setText(R.string.wario_wing);
                break;
            case R.drawable.waddle_wing:
                tv.setText(R.string.waddle_wing);
                break;
            case R.drawable.parasol:
                tv.setText(R.string.parasol);
                break;
            case R.drawable.parachute:
                tv.setText(R.string.parachute);
                break;
            case R.drawable.parafoil:
                tv.setText(R.string.parafoil);
                break;
            case R.drawable.flower_glider:
                tv.setText(R.string.flower_glider);
                break;
            case R.drawable.bowser_kite:
                tv.setText(R.string.bowser_kite);
                break;
            case R.drawable.plane_glider:
                tv.setText(R.string.plane_glider);
                break;
            case R.drawable.mktv_parafoil:
                tv.setText(R.string.mktv_parafoil);
                break;
            case R.drawable.gold_glider:
                tv.setText(R.string.gold_glider);
                break;
            case R.drawable.hylian_kite:
                tv.setText(R.string.hylian_kite);
                break;
            case R.drawable.paper_glider:
                tv.setText(R.string.paper_glider);
                break;
            case R.drawable.paraglider:
                tv.setText(R.string.paraglider);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 3 glider
     * @param view is the current view
     */
    public void bikesGliderImage3(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.glider_image_p3);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.super_glider:
                tv.setText(R.string.super_glider);
                break;
            case R.drawable.cloud_glider:
                tv.setText(R.string.cloud_glider);
                break;
            case R.drawable.wario_wing:
                tv.setText(R.string.wario_wing);
                break;
            case R.drawable.waddle_wing:
                tv.setText(R.string.waddle_wing);
                break;
            case R.drawable.parasol:
                tv.setText(R.string.parasol);
                break;
            case R.drawable.parachute:
                tv.setText(R.string.parachute);
                break;
            case R.drawable.parafoil:
                tv.setText(R.string.parafoil);
                break;
            case R.drawable.flower_glider:
                tv.setText(R.string.flower_glider);
                break;
            case R.drawable.bowser_kite:
                tv.setText(R.string.bowser_kite);
                break;
            case R.drawable.plane_glider:
                tv.setText(R.string.plane_glider);
                break;
            case R.drawable.mktv_parafoil:
                tv.setText(R.string.mktv_parafoil);
                break;
            case R.drawable.gold_glider:
                tv.setText(R.string.gold_glider);
                break;
            case R.drawable.hylian_kite:
                tv.setText(R.string.hylian_kite);
                break;
            case R.drawable.paper_glider:
                tv.setText(R.string.paper_glider);
                break;
            case R.drawable.paraglider:
                tv.setText(R.string.paraglider);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }

    /**
     * the onClick action for the player 4 glider
     * @param view is the current view
     */
    public void bikesGliderImage4(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.glider_image_p4);
        int id = getResourceId(img);

        switch (id) {
            case R.drawable.super_glider:
                tv.setText(R.string.super_glider);
                break;
            case R.drawable.cloud_glider:
                tv.setText(R.string.cloud_glider);
                break;
            case R.drawable.wario_wing:
                tv.setText(R.string.wario_wing);
                break;
            case R.drawable.waddle_wing:
                tv.setText(R.string.waddle_wing);
                break;
            case R.drawable.parasol:
                tv.setText(R.string.parasol);
                break;
            case R.drawable.parachute:
                tv.setText(R.string.parachute);
                break;
            case R.drawable.parafoil:
                tv.setText(R.string.parafoil);
                break;
            case R.drawable.flower_glider:
                tv.setText(R.string.flower_glider);
                break;
            case R.drawable.bowser_kite:
                tv.setText(R.string.bowser_kite);
                break;
            case R.drawable.plane_glider:
                tv.setText(R.string.plane_glider);
                break;
            case R.drawable.mktv_parafoil:
                tv.setText(R.string.mktv_parafoil);
                break;
            case R.drawable.gold_glider:
                tv.setText(R.string.gold_glider);
                break;
            case R.drawable.hylian_kite:
                tv.setText(R.string.hylian_kite);
                break;
            case R.drawable.paper_glider:
                tv.setText(R.string.paper_glider);
                break;
            case R.drawable.paraglider:
                tv.setText(R.string.paraglider);
                break;
            default:
                tv.setText(R.string.default_error);
        }
    }
}
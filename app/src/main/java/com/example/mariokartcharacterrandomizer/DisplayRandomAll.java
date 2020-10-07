package com.example.mariokartcharacterrandomizer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayRandomAll extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_random_with_bikes);

        Intent intent = getIntent();
        int playerNumber = intent.getIntExtra("PlayerNumber", 1); // get the number of players

        setPlayerText(playerNumber);
        setCharImage(playerNumber);
        setFrameImage(playerNumber);
        setWheelImage(playerNumber);
        setGliderImage(playerNumber);
    }

    /**
     * randCharacter() returns a random String from a list of character names
     * @return a String that is the name of the random character
     */
    private String randCharacter() {
        String[] list = {"Mario", "Luigi", "Peach", "Daisy", "Rosalina", "Tanooki Mario", "Cat Peach", "Yoshi", "Toad", "Koopa Troopa", "Shy Guy", "Lakitu", "Toadette", "King Boo", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Baby Rosalina", "Metal Mario", "Pink Gold Peach", "Wario", "Waluigi", "Donkey Kong", "Bowser", "Dry Bones", "Bowser Jr.", "Dry Bowser", "Lemmy", "Larry", "Wendy", "Ludwig", "Iggy", "Roy", "Morton", "Inkling Girl", "Inkling Boy", "Link", "Villager (B)", "Villager (G)", "Isabelle", "Mii"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * randFrame() returns a random String from a list of kart/bike frames
     * @return a String that is the name of the frame
     */
    private String randFrame() {
        String[] list = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow", "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing", "Koopa Clown", "Standard Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "City Tripper", "Master Cycle Zero", "Comet", "Sports Bike", "Jet Bike", "Yoshi Bike", "Master Cycle", "Standard ATV", "Wild Wiggler", "Teddy Buggy", "Bone Rattler", "Splat Buggy", "Inkstriker"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * randWheels() returns a random String from a list of wheels
     * @return a String that is the name of the wheels
     */
    private String randWheels() {
        String[] list = {"Standard Wheels", "Monster Wheels", "Roller Wheels", "Slim Wheels", "Slick Wheels", "Metal Wheels", "Button Wheels", "Off-Road Wheels", "Sponge Wheels", "Wood Wheels", "Cushion Wheels", "Blue Standard Wheels", "Hot Monster Wheels", "Azure Roller Wheels", "Crimson Slim Wheels", "Cyber Slick Wheels", "Retro Off-Road Wheels", "Gold Tires", "GLA Tires", "Triforce Tires", "Leaf Tires", "Ancient Tires"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * randGlider() returns a random String from a list of gliders
     * @return a String that is the name of the glider
     */
    private String randGlider() {
        String[] list = {"Super Glider", "Cloud Glider", "Wario Wing", "Waddle Wing", "Peach Parasol", "Parachute", "Parafoil", "Flower Glider", "Bowser Kite", "Plane Glider", "MKTV Parafoil", "Gold Glider", "Hylian Kite", "Paper Glider", "Paraglider"};
        return list[((int) (Math.random() * list.length))];
    }

    /**
     * If the random character is one that has multiple color palettes, this method goes about choosing a random palette out of the selection per character
     * @param randChar is the character that is being assigned a color
     * @return the character that was inputted as the character, concatenated with the random color palette
     */
    private String setColor(String randChar) {
        int color;
        String character = "";
        if (randChar.equals("Shy Guy") || randChar.equals("Yoshi")) {
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
                    character = randChar.concat(" (Green)");
            }
        } else if (randChar.equals("Metal Mario")) {
            color = (int) (Math.random() * 2);
            if (color == 0)
                character = randChar.concat(" (Metal)");
            else
                character = randChar.concat(" (Gold)");
        } else if (randChar.equals("Link")) {
            color = (int) (Math.random() * 2);
            if (color == 0)
                character = randChar.concat(" (Classic)");
            else
                character = randChar.concat(" (BOTW)");
        } else if (randChar.equals("Inkling Girl")) {
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
                    character = randChar.concat(" (Orange)");
            }
        } else if (randChar.equals("Inkling Boy")) {
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
                    character = randChar.concat(" (Dark Blue)");
            }
        }
        return character;
    }

    /**
     * Only make the text for players 2 through 4 visible if that many builds are selected
     * @param playerNumber the number of players to make visible
     */
    private void setPlayerText(int playerNumber) {
        if(playerNumber >= 2) {
            TextView textView2 = findViewById(R.id.playerText1b);
            textView2.setText(R.string.player2);
            if(playerNumber >= 3) {
                TextView textView3 = findViewById(R.id.playerText1c);
                textView3.setText(R.string.player3);
                if(playerNumber == 4) {
                    TextView textView4 = findViewById(R.id.playerText1d);
                    textView4.setText(R.string.player4);
                }
            }
        }
    }

    /**
     * takes in the number of players, calls randCharacter() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     * @param playerNumber is the number of characters that need randomized characters
     */
    private void setCharImage(int playerNumber) {
        ImageView charImage = findViewById(R.id.charImage1a);

        String randChar = randCharacter();
        if (randChar.equals("Yoshi") || randChar.equals("Shy Guy") || randChar.equals("Metal Mario") || randChar.equals("Link") || randChar.equals("Inkling Boy") || randChar.equals("Inkling Girl"))
            randChar = setColor(randChar);

        switch (randChar) {
            case "Baby Daisy":
                charImage.setImageResource(R.drawable.baby_daisy);
                charImage.setTag(R.drawable.baby_daisy);
                break;
            case "Baby Luigi":
                charImage.setImageResource(R.drawable.baby_luigi);
                charImage.setTag(R.drawable.baby_luigi);
                break;
            case "Baby Mario":
                charImage.setImageResource(R.drawable.baby_mario);
                charImage.setTag(R.drawable.baby_mario);
                break;
            case "Baby Peach":
                charImage.setImageResource(R.drawable.baby_peach);
                charImage.setTag(R.drawable.baby_peach);
                break;
            case "Baby Rosalina":
                charImage.setImageResource(R.drawable.baby_rosalina);
                charImage.setTag(R.drawable.baby_rosalina);
                break;
            case "Bowser":
                charImage.setImageResource(R.drawable.bowser);
                charImage.setTag(R.drawable.bowser);
                break;
            case "Bowser Jr.":
                charImage.setImageResource(R.drawable.bowser_jr);
                charImage.setTag(R.drawable.bowser_jr);
                break;
            case "Cat Peach":
                charImage.setImageResource(R.drawable.cat_peach);
                charImage.setTag(R.drawable.cat_peach);
                break;
            case "Daisy":
                charImage.setImageResource(R.drawable.daisy);
                charImage.setTag(R.drawable.daisy);
                break;
            case "Donkey Kong":
                charImage.setImageResource(R.drawable.donkey_kong);
                charImage.setTag(R.drawable.donkey_kong);
                break;
            case "Dry Bones":
                charImage.setImageResource(R.drawable.dry_bones);
                charImage.setTag(R.drawable.dry_bones);
                break;
            case "Dry Bowser":
                charImage.setImageResource(R.drawable.dry_bowser);
                charImage.setTag(R.drawable.dry_bowser);
                break;
            case "Metal Mario (Gold)":
                charImage.setImageResource(R.drawable.gold_mario);
                charImage.setTag(R.drawable.gold_mario);
                break;
            case "Iggy":
                charImage.setImageResource(R.drawable.iggy);
                charImage.setTag(R.drawable.iggy);
                break;
            case "Inkling Boy (Dark Blue)":
                charImage.setImageResource(R.drawable.inkling_boy_darkblue);
                charImage.setTag(R.drawable.inkling_boy_darkblue);
                break;
            case "Inkling Boy (Light Blue)":
                charImage.setImageResource(R.drawable.inkling_boy_lightblue);
                charImage.setTag(R.drawable.inkling_boy_lightblue);
                break;
            case "Inkling Boy (Purple)":
                charImage.setImageResource(R.drawable.inkling_boy_purple);
                charImage.setTag(R.drawable.inkling_boy_purple);
                break;
            case "Inkling Girl (Green)":
                charImage.setImageResource(R.drawable.inkling_girl_green);
                charImage.setTag(R.drawable.inkling_girl_green);
                break;
            case "Inkling Girl (Orange)":
                charImage.setImageResource(R.drawable.inkling_girl_orange);
                charImage.setTag(R.drawable.inkling_girl_orange);
                break;
            case "Inkling Girl (Pink)":
                charImage.setImageResource(R.drawable.inkling_girl_pink);
                charImage.setTag(R.drawable.inkling_girl_pink);
                break;
            case "Isabelle":
                charImage.setImageResource(R.drawable.isabelle);
                charImage.setTag(R.drawable.isabelle);
                break;
            case "King Boo":
                charImage.setImageResource(R.drawable.king_boo);
                charImage.setTag(R.drawable.king_boo);
                break;
            case "Koopa Troopa":
                charImage.setImageResource(R.drawable.koopa_troopa);
                charImage.setTag(R.drawable.koopa_troopa);
                break;
            case "Lakitu":
                charImage.setImageResource(R.drawable.lakitu);
                charImage.setTag(R.drawable.lakitu);
                break;
            case "Larry":
                charImage.setImageResource(R.drawable.larry);
                charImage.setTag(R.drawable.larry);
                break;
            case "Lemmy":
                charImage.setImageResource(R.drawable.lemmy);
                charImage.setTag(R.drawable.lemmy);
                break;
            case "Link (BOTW)":
                charImage.setImageResource(R.drawable.link_botw);
                charImage.setTag(R.drawable.link_botw);
                break;
            case "Link (Classic)":
                charImage.setImageResource(R.drawable.link_classic);
                charImage.setTag(R.drawable.link_classic);
                break;
            case "Ludwig":
                charImage.setImageResource(R.drawable.ludwig);
                charImage.setTag(R.drawable.ludwig);
                break;
            case "Luigi":
                charImage.setImageResource(R.drawable.luigi);
                charImage.setTag(R.drawable.luigi);
                break;
            case "Mario":
                charImage.setImageResource(R.drawable.mario);
                charImage.setTag(R.drawable.mario);
                break;
            case "Metal Mario (Metal)":
                charImage.setImageResource(R.drawable.metal_mario);
                charImage.setTag(R.drawable.metal_mario);
                break;
            case "Mii":
                charImage.setImageResource(R.drawable.mii);
                charImage.setTag(R.drawable.mii);
                break;
            case "Morton":
                charImage.setImageResource(R.drawable.morton);
                charImage.setTag(R.drawable.morton);
                break;
            case "Peach":
                charImage.setImageResource(R.drawable.peach);
                charImage.setTag(R.drawable.peach);
                break;
            case "Pink Gold Peach":
                charImage.setImageResource(R.drawable.pink_gold_peach);
                charImage.setTag(R.drawable.pink_gold_peach);
                break;
            case "Rosalina":
                charImage.setImageResource(R.drawable.rosalina);
                charImage.setTag(R.drawable.rosalina);
                break;
            case "Roy":
                charImage.setImageResource(R.drawable.roy);
                charImage.setTag(R.drawable.roy);
                break;
            case "Shy Guy (Black)":
                charImage.setImageResource(R.drawable.shyguy_black);
                charImage.setTag(R.drawable.shyguy_black);
                break;
            case "Shy Guy (Dark Blue)":
                charImage.setImageResource(R.drawable.shyguy_darkblue);
                charImage.setTag(R.drawable.shyguy_darkblue);
                break;
            case "Shy Guy (Green)":
                charImage.setImageResource(R.drawable.shyguy_green);
                charImage.setTag(R.drawable.shyguy_green);
                break;
            case "Shy Guy (Light Blue)":
                charImage.setImageResource(R.drawable.shyguy_lightblue);
                charImage.setTag(R.drawable.shyguy_lightblue);
                break;
            case "Shy Guy (Orange)":
                charImage.setImageResource(R.drawable.shyguy_orange);
                charImage.setTag(R.drawable.shyguy_orange);
                break;
            case "Shy Guy (Pink)":
                charImage.setImageResource(R.drawable.shyguy_pink);
                charImage.setTag(R.drawable.shyguy_pink);
                break;
            case "Shy Guy (Red)":
                charImage.setImageResource(R.drawable.shyguy_red);
                charImage.setTag(R.drawable.shyguy_red);
                break;
            case "Shy Guy (White)":
                charImage.setImageResource(R.drawable.shyguy_white);
                charImage.setTag(R.drawable.shyguy_white);
                break;
            case "Shy Guy (Yellow)":
                charImage.setImageResource(R.drawable.shyguy_yellow);
                charImage.setTag(R.drawable.shyguy_yellow);
                break;
            case "Tanooki Mario":
                charImage.setImageResource(R.drawable.tanooki_mario);
                charImage.setTag(R.drawable.tanooki_mario);
                break;
            case "Toad":
                charImage.setImageResource(R.drawable.toad);
                charImage.setTag(R.drawable.toad);
                break;
            case "Toadette":
                charImage.setImageResource(R.drawable.toadette);
                charImage.setTag(R.drawable.toadette);
                break;
            case "Villager (B)":
                charImage.setImageResource(R.drawable.villager_boy);
                charImage.setTag(R.drawable.villager_boy);
                break;
            case "Villager (G)":
                charImage.setImageResource(R.drawable.villager_girl);
                charImage.setTag(R.drawable.villager_girl);
                break;
            case "Waluigi":
                charImage.setImageResource(R.drawable.waluigi);
                charImage.setTag(R.drawable.waluigi);
                break;
            case "Wario":
                charImage.setImageResource(R.drawable.wario);
                charImage.setTag(R.drawable.wario);
                break;
            case "Wendy":
                charImage.setImageResource(R.drawable.wendy);
                charImage.setTag(R.drawable.wendy);
                break;
            case "Yoshi (Black)":
                charImage.setImageResource(R.drawable.yoshi_black);
                charImage.setTag(R.drawable.yoshi_black);
                break;
            case "Yoshi (Dark Blue)":
                charImage.setImageResource(R.drawable.yoshi_darkblue);
                charImage.setTag(R.drawable.yoshi_darkblue);
                break;
            case "Yoshi (Green)":
                charImage.setImageResource(R.drawable.yoshi_green);
                charImage.setTag(R.drawable.yoshi_green);
                break;
            case "Yoshi (Light Blue)":
                charImage.setImageResource(R.drawable.yoshi_lightblue);
                charImage.setTag(R.drawable.yoshi_lightblue);
                break;
            case "Yoshi (Orange)":
                charImage.setImageResource(R.drawable.yoshi_orange);
                charImage.setTag(R.drawable.yoshi_orange);
                break;
            case "Yoshi (Pink)":
                charImage.setImageResource(R.drawable.yoshi_pink);
                charImage.setTag(R.drawable.yoshi_pink);
                break;
            case "Yoshi (Red)":
                charImage.setImageResource(R.drawable.yoshi_red);
                charImage.setTag(R.drawable.yoshi_red);
                break;
            case "Yoshi (White)":
                charImage.setImageResource(R.drawable.yoshi_white);
                charImage.setTag(R.drawable.yoshi_white);
                break;
            case "Yoshi (Yellow)":
                charImage.setImageResource(R.drawable.yoshi_yellow);
                charImage.setTag(R.drawable.yoshi_yellow);
                break;
            default:
                charImage.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
        }

        if (playerNumber > 1) {
            ImageView charImage2 = findViewById(R.id.charImage1b);;

            String randChar2 = randCharacter();
            if (randChar2.equals("Yoshi") || randChar2.equals("Shy Guy") || randChar2.equals("Metal Mario") || randChar2.equals("Link") || randChar2.equals("Inkling Boy") || randChar2.equals("Inkling Girl"))
                randChar2 = setColor(randChar2);

            switch (randChar2) {
                case "Baby Daisy":
                    charImage2.setImageResource(R.drawable.baby_daisy);
                    charImage2.setTag(R.drawable.baby_daisy);
                    break;
                case "Baby Luigi":
                    charImage2.setImageResource(R.drawable.baby_luigi);
                    charImage2.setTag(R.drawable.baby_luigi);
                    break;
                case "Baby Mario":
                    charImage2.setImageResource(R.drawable.baby_mario);
                    charImage2.setTag(R.drawable.baby_mario);
                    break;
                case "Baby Peach":
                    charImage2.setImageResource(R.drawable.baby_peach);
                    charImage2.setTag(R.drawable.baby_peach);
                    break;
                case "Baby Rosalina":
                    charImage2.setImageResource(R.drawable.baby_rosalina);
                    charImage2.setTag(R.drawable.baby_rosalina);
                    break;
                case "Bowser":
                    charImage2.setImageResource(R.drawable.bowser);
                    charImage2.setTag(R.drawable.bowser);
                    break;
                case "Bowser Jr.":
                    charImage2.setImageResource(R.drawable.bowser_jr);
                    charImage2.setTag(R.drawable.bowser_jr);
                    break;
                case "Cat Peach":
                    charImage2.setImageResource(R.drawable.cat_peach);
                    charImage2.setTag(R.drawable.cat_peach);
                    break;
                case "Daisy":
                    charImage2.setImageResource(R.drawable.daisy);
                    charImage2.setTag(R.drawable.daisy);
                    break;
                case "Donkey Kong":
                    charImage2.setImageResource(R.drawable.donkey_kong);
                    charImage2.setTag(R.drawable.donkey_kong);
                    break;
                case "Dry Bones":
                    charImage2.setImageResource(R.drawable.dry_bones);
                    charImage2.setTag(R.drawable.dry_bones);
                    break;
                case "Dry Bowser":
                    charImage2.setImageResource(R.drawable.dry_bowser);
                    charImage2.setTag(R.drawable.dry_bowser);
                    break;
                case "Metal Mario (Gold)":
                    charImage2.setImageResource(R.drawable.gold_mario);
                    charImage2.setTag(R.drawable.gold_mario);
                    break;
                case "Iggy":
                    charImage2.setImageResource(R.drawable.iggy);
                    charImage2.setTag(R.drawable.iggy);
                    break;
                case "Inkling Boy (Dark Blue)":
                    charImage2.setImageResource(R.drawable.inkling_boy_darkblue);
                    charImage2.setTag(R.drawable.inkling_boy_darkblue);
                    break;
                case "Inkling Boy (Light Blue)":
                    charImage2.setImageResource(R.drawable.inkling_boy_lightblue);
                    charImage2.setTag(R.drawable.inkling_boy_lightblue);
                    break;
                case "Inkling Boy (Purple)":
                    charImage2.setImageResource(R.drawable.inkling_boy_purple);
                    charImage2.setTag(R.drawable.inkling_boy_purple);
                    break;
                case "Inkling Girl (Green)":
                    charImage2.setImageResource(R.drawable.inkling_girl_green);
                    charImage2.setTag(R.drawable.inkling_girl_green);
                    break;
                case "Inkling Girl (Orange)":
                    charImage2.setImageResource(R.drawable.inkling_girl_orange);
                    charImage2.setTag(R.drawable.inkling_girl_orange);
                    break;
                case "Inkling Girl (Pink)":
                    charImage2.setImageResource(R.drawable.inkling_girl_pink);
                    charImage2.setTag(R.drawable.inkling_girl_pink);
                    break;
                case "Isabelle":
                    charImage2.setImageResource(R.drawable.isabelle);
                    charImage2.setTag(R.drawable.isabelle);
                    break;
                case "King Boo":
                    charImage2.setImageResource(R.drawable.king_boo);
                    charImage2.setTag(R.drawable.king_boo);
                    break;
                case "Koopa Troopa":
                    charImage2.setImageResource(R.drawable.koopa_troopa);
                    charImage2.setTag(R.drawable.koopa_troopa);
                    break;
                case "Lakitu":
                    charImage2.setImageResource(R.drawable.lakitu);
                    charImage2.setTag(R.drawable.lakitu);
                    break;
                case "Larry":
                    charImage2.setImageResource(R.drawable.larry);
                    charImage2.setTag(R.drawable.larry);
                    break;
                case "Lemmy":
                    charImage2.setImageResource(R.drawable.lemmy);
                    charImage2.setTag(R.drawable.lemmy);
                    break;
                case "Link (BOTW)":
                    charImage2.setImageResource(R.drawable.link_botw);
                    charImage2.setTag(R.drawable.link_botw);
                    break;
                case "Link (Classic)":
                    charImage2.setImageResource(R.drawable.link_classic);
                    charImage2.setTag(R.drawable.link_classic);
                    break;
                case "Ludwig":
                    charImage2.setImageResource(R.drawable.ludwig);
                    charImage2.setTag(R.drawable.ludwig);
                    break;
                case "Luigi":
                    charImage2.setImageResource(R.drawable.luigi);
                    charImage2.setTag(R.drawable.luigi);
                    break;
                case "Mario":
                    charImage2.setImageResource(R.drawable.mario);
                    charImage2.setTag(R.drawable.mario);
                    break;
                case "Metal Mario (Metal)":
                    charImage2.setImageResource(R.drawable.metal_mario);
                    charImage2.setTag(R.drawable.metal_mario);
                    break;
                case "Mii":
                    charImage2.setImageResource(R.drawable.mii);
                    charImage2.setTag(R.drawable.mii);
                    break;
                case "Morton":
                    charImage2.setImageResource(R.drawable.morton);
                    charImage2.setTag(R.drawable.morton);
                    break;
                case "Peach":
                    charImage2.setImageResource(R.drawable.peach);
                    charImage2.setTag(R.drawable.peach);
                    break;
                case "Pink Gold Peach":
                    charImage2.setImageResource(R.drawable.pink_gold_peach);
                    charImage2.setTag(R.drawable.pink_gold_peach);
                    break;
                case "Rosalina":
                    charImage2.setImageResource(R.drawable.rosalina);
                    charImage2.setTag(R.drawable.rosalina);
                    break;
                case "Roy":
                    charImage2.setImageResource(R.drawable.roy);
                    charImage2.setTag(R.drawable.roy);
                    break;
                case "Shy Guy (Black)":
                    charImage2.setImageResource(R.drawable.shyguy_black);
                    charImage2.setTag(R.drawable.shyguy_black);
                    break;
                case "Shy Guy (Dark Blue)":
                    charImage2.setImageResource(R.drawable.shyguy_darkblue);
                    charImage2.setTag(R.drawable.shyguy_darkblue);
                    break;
                case "Shy Guy (Green)":
                    charImage2.setImageResource(R.drawable.shyguy_green);
                    charImage2.setTag(R.drawable.shyguy_green);
                    break;
                case "Shy Guy (Light Blue)":
                    charImage2.setImageResource(R.drawable.shyguy_lightblue);
                    charImage2.setTag(R.drawable.shyguy_lightblue);
                    break;
                case "Shy Guy (Orange)":
                    charImage2.setImageResource(R.drawable.shyguy_orange);
                    charImage2.setTag(R.drawable.shyguy_orange);
                    break;
                case "Shy Guy (Pink)":
                    charImage2.setImageResource(R.drawable.shyguy_pink);
                    charImage2.setTag(R.drawable.shyguy_pink);
                    break;
                case "Shy Guy (Red)":
                    charImage2.setImageResource(R.drawable.shyguy_red);
                    charImage2.setTag(R.drawable.shyguy_red);
                    break;
                case "Shy Guy (White)":
                    charImage2.setImageResource(R.drawable.shyguy_white);
                    charImage2.setTag(R.drawable.shyguy_white);
                    break;
                case "Shy Guy (Yellow)":
                    charImage2.setImageResource(R.drawable.shyguy_yellow);
                    charImage2.setTag(R.drawable.shyguy_yellow);
                    break;
                case "Tanooki Mario":
                    charImage2.setImageResource(R.drawable.tanooki_mario);
                    charImage2.setTag(R.drawable.tanooki_mario);
                    break;
                case "Toad":
                    charImage2.setImageResource(R.drawable.toad);
                    charImage2.setTag(R.drawable.toad);
                    break;
                case "Toadette":
                    charImage2.setImageResource(R.drawable.toadette);
                    charImage2.setTag(R.drawable.toadette);
                    break;
                case "Villager (B)":
                    charImage2.setImageResource(R.drawable.villager_boy);
                    charImage2.setTag(R.drawable.villager_boy);
                    break;
                case "Villager (G)":
                    charImage2.setImageResource(R.drawable.villager_girl);
                    charImage2.setTag(R.drawable.villager_girl);
                    break;
                case "Waluigi":
                    charImage2.setImageResource(R.drawable.waluigi);
                    charImage2.setTag(R.drawable.waluigi);
                    break;
                case "Wario":
                    charImage2.setImageResource(R.drawable.wario);
                    charImage2.setTag(R.drawable.wario);
                    break;
                case "Wendy":
                    charImage2.setImageResource(R.drawable.wendy);
                    charImage2.setTag(R.drawable.wendy);
                    break;
                case "Yoshi (Black)":
                    charImage2.setImageResource(R.drawable.yoshi_black);
                    charImage2.setTag(R.drawable.yoshi_black);
                    break;
                case "Yoshi (Dark Blue)":
                    charImage2.setImageResource(R.drawable.yoshi_darkblue);
                    charImage2.setTag(R.drawable.yoshi_darkblue);
                    break;
                case "Yoshi (Green)":
                    charImage2.setImageResource(R.drawable.yoshi_green);
                    charImage2.setTag(R.drawable.yoshi_green);
                    break;
                case "Yoshi (Light Blue)":
                    charImage2.setImageResource(R.drawable.yoshi_lightblue);
                    charImage2.setTag(R.drawable.yoshi_lightblue);
                    break;
                case "Yoshi (Orange)":
                    charImage2.setImageResource(R.drawable.yoshi_orange);
                    charImage2.setTag(R.drawable.yoshi_orange);
                    break;
                case "Yoshi (Pink)":
                    charImage2.setImageResource(R.drawable.yoshi_pink);
                    charImage2.setTag(R.drawable.yoshi_pink);
                    break;
                case "Yoshi (Red)":
                    charImage2.setImageResource(R.drawable.yoshi_red);
                    charImage2.setTag(R.drawable.yoshi_red);
                    break;
                case "Yoshi (White)":
                    charImage2.setImageResource(R.drawable.yoshi_white);
                    charImage2.setTag(R.drawable.yoshi_white);
                    break;
                case "Yoshi (Yellow)":
                    charImage2.setImageResource(R.drawable.yoshi_yellow);
                    charImage2.setTag(R.drawable.yoshi_yellow);
                    break;
                default:
                    charImage2.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }

            if(playerNumber > 2) {
                ImageView charImage3 = findViewById(R.id.charImage1c);

                String randChar3 = randCharacter();
                if (randChar3.equals("Yoshi") || randChar3.equals("Shy Guy") || randChar3.equals("Metal Mario") || randChar3.equals("Link") || randChar3.equals("Inkling Boy") || randChar3.equals("Inkling Girl"))
                    randChar3 = setColor(randChar3);

                switch (randChar3) {
                    case "Baby Daisy":
                        charImage3.setImageResource(R.drawable.baby_daisy);
                        charImage3.setTag(R.drawable.baby_daisy);
                        break;
                    case "Baby Luigi":
                        charImage3.setImageResource(R.drawable.baby_luigi);
                        charImage3.setTag(R.drawable.baby_luigi);
                        break;
                    case "Baby Mario":
                        charImage3.setImageResource(R.drawable.baby_mario);
                        charImage3.setTag(R.drawable.baby_mario);
                        break;
                    case "Baby Peach":
                        charImage3.setImageResource(R.drawable.baby_peach);
                        charImage3.setTag(R.drawable.baby_peach);
                        break;
                    case "Baby Rosalina":
                        charImage3.setImageResource(R.drawable.baby_rosalina);
                        charImage3.setTag(R.drawable.baby_rosalina);
                        break;
                    case "Bowser":
                        charImage3.setImageResource(R.drawable.bowser);
                        charImage3.setTag(R.drawable.bowser);
                        break;
                    case "Bowser Jr.":
                        charImage3.setImageResource(R.drawable.bowser_jr);
                        charImage3.setTag(R.drawable.bowser_jr);
                        break;
                    case "Cat Peach":
                        charImage3.setImageResource(R.drawable.cat_peach);
                        charImage3.setTag(R.drawable.cat_peach);
                        break;
                    case "Daisy":
                        charImage3.setImageResource(R.drawable.daisy);
                        charImage3.setTag(R.drawable.daisy);
                        break;
                    case "Donkey Kong":
                        charImage3.setImageResource(R.drawable.donkey_kong);
                        charImage3.setTag(R.drawable.donkey_kong);
                        break;
                    case "Dry Bones":
                        charImage3.setImageResource(R.drawable.dry_bones);
                        charImage3.setTag(R.drawable.dry_bones);
                        break;
                    case "Dry Bowser":
                        charImage3.setImageResource(R.drawable.dry_bowser);
                        charImage3.setTag(R.drawable.dry_bowser);
                        break;
                    case "Metal Mario (Gold)":
                        charImage3.setImageResource(R.drawable.gold_mario);
                        charImage3.setTag(R.drawable.gold_mario);
                        break;
                    case "Iggy":
                        charImage3.setImageResource(R.drawable.iggy);
                        charImage3.setTag(R.drawable.iggy);
                        break;
                    case "Inkling Boy (Dark Blue)":
                        charImage3.setImageResource(R.drawable.inkling_boy_darkblue);
                        charImage3.setTag(R.drawable.inkling_boy_darkblue);
                        break;
                    case "Inkling Boy (Light Blue)":
                        charImage3.setImageResource(R.drawable.inkling_boy_lightblue);
                        charImage3.setTag(R.drawable.inkling_boy_lightblue);
                        break;
                    case "Inkling Boy (Purple)":
                        charImage3.setImageResource(R.drawable.inkling_boy_purple);
                        charImage3.setTag(R.drawable.inkling_boy_purple);
                        break;
                    case "Inkling Girl (Green)":
                        charImage3.setImageResource(R.drawable.inkling_girl_green);
                        charImage3.setTag(R.drawable.inkling_girl_green);
                        break;
                    case "Inkling Girl (Orange)":
                        charImage3.setImageResource(R.drawable.inkling_girl_orange);
                        charImage3.setTag(R.drawable.inkling_girl_orange);
                        break;
                    case "Inkling Girl (Pink)":
                        charImage3.setImageResource(R.drawable.inkling_girl_pink);
                        charImage3.setTag(R.drawable.inkling_girl_pink);
                        break;
                    case "Isabelle":
                        charImage3.setImageResource(R.drawable.isabelle);
                        charImage3.setTag(R.drawable.isabelle);
                        break;
                    case "King Boo":
                        charImage3.setImageResource(R.drawable.king_boo);
                        charImage3.setTag(R.drawable.king_boo);
                        break;
                    case "Koopa Troopa":
                        charImage3.setImageResource(R.drawable.koopa_troopa);
                        charImage3.setTag(R.drawable.koopa_troopa);
                        break;
                    case "Lakitu":
                        charImage3.setImageResource(R.drawable.lakitu);
                        charImage3.setTag(R.drawable.lakitu);
                        break;
                    case "Larry":
                        charImage3.setImageResource(R.drawable.larry);
                        charImage3.setTag(R.drawable.larry);
                        break;
                    case "Lemmy":
                        charImage3.setImageResource(R.drawable.lemmy);
                        charImage3.setTag(R.drawable.lemmy);
                        break;
                    case "Link (BOTW)":
                        charImage3.setImageResource(R.drawable.link_botw);
                        charImage3.setTag(R.drawable.link_botw);
                        break;
                    case "Link (Classic)":
                        charImage3.setImageResource(R.drawable.link_classic);
                        charImage3.setTag(R.drawable.link_classic);
                        break;
                    case "Ludwig":
                        charImage3.setImageResource(R.drawable.ludwig);
                        charImage3.setTag(R.drawable.ludwig);
                        break;
                    case "Luigi":
                        charImage3.setImageResource(R.drawable.luigi);
                        charImage3.setTag(R.drawable.luigi);
                        break;
                    case "Mario":
                        charImage3.setImageResource(R.drawable.mario);
                        charImage3.setTag(R.drawable.mario);
                        break;
                    case "Metal Mario (Metal)":
                        charImage3.setImageResource(R.drawable.metal_mario);
                        charImage3.setTag(R.drawable.metal_mario);
                        break;
                    case "Mii":
                        charImage3.setImageResource(R.drawable.mii);
                        charImage3.setTag(R.drawable.mii);
                        break;
                    case "Morton":
                        charImage3.setImageResource(R.drawable.morton);
                        charImage3.setTag(R.drawable.morton);
                        break;
                    case "Peach":
                        charImage3.setImageResource(R.drawable.peach);
                        charImage3.setTag(R.drawable.peach);
                        break;
                    case "Pink Gold Peach":
                        charImage3.setImageResource(R.drawable.pink_gold_peach);
                        charImage3.setTag(R.drawable.pink_gold_peach);
                        break;
                    case "Rosalina":
                        charImage3.setImageResource(R.drawable.rosalina);
                        charImage3.setTag(R.drawable.rosalina);
                        break;
                    case "Roy":
                        charImage3.setImageResource(R.drawable.roy);
                        charImage3.setTag(R.drawable.roy);
                        break;
                    case "Shy Guy (Black)":
                        charImage3.setImageResource(R.drawable.shyguy_black);
                        charImage3.setTag(R.drawable.shyguy_black);
                        break;
                    case "Shy Guy (Dark Blue)":
                        charImage3.setImageResource(R.drawable.shyguy_darkblue);
                        charImage3.setTag(R.drawable.shyguy_darkblue);
                        break;
                    case "Shy Guy (Green)":
                        charImage3.setImageResource(R.drawable.shyguy_green);
                        charImage3.setTag(R.drawable.shyguy_green);
                        break;
                    case "Shy Guy (Light Blue)":
                        charImage3.setImageResource(R.drawable.shyguy_lightblue);
                        charImage3.setTag(R.drawable.shyguy_lightblue);
                        break;
                    case "Shy Guy (Orange)":
                        charImage3.setImageResource(R.drawable.shyguy_orange);
                        charImage3.setTag(R.drawable.shyguy_orange);
                        break;
                    case "Shy Guy (Pink)":
                        charImage3.setImageResource(R.drawable.shyguy_pink);
                        charImage3.setTag(R.drawable.shyguy_pink);
                        break;
                    case "Shy Guy (Red)":
                        charImage3.setImageResource(R.drawable.shyguy_red);
                        charImage3.setTag(R.drawable.shyguy_red);
                        break;
                    case "Shy Guy (White)":
                        charImage3.setImageResource(R.drawable.shyguy_white);
                        charImage3.setTag(R.drawable.shyguy_white);
                        break;
                    case "Shy Guy (Yellow)":
                        charImage3.setImageResource(R.drawable.shyguy_yellow);
                        charImage3.setTag(R.drawable.shyguy_yellow);
                        break;
                    case "Tanooki Mario":
                        charImage3.setImageResource(R.drawable.tanooki_mario);
                        charImage3.setTag(R.drawable.tanooki_mario);
                        break;
                    case "Toad":
                        charImage3.setImageResource(R.drawable.toad);
                        charImage3.setTag(R.drawable.toad);
                        break;
                    case "Toadette":
                        charImage3.setImageResource(R.drawable.toadette);
                        charImage3.setTag(R.drawable.toadette);
                        break;
                    case "Villager (B)":
                        charImage3.setImageResource(R.drawable.villager_boy);
                        charImage3.setTag(R.drawable.villager_boy);
                        break;
                    case "Villager (G)":
                        charImage3.setImageResource(R.drawable.villager_girl);
                        charImage3.setTag(R.drawable.villager_girl);
                        break;
                    case "Waluigi":
                        charImage3.setImageResource(R.drawable.waluigi);
                        charImage3.setTag(R.drawable.waluigi);
                        break;
                    case "Wario":
                        charImage3.setImageResource(R.drawable.wario);
                        charImage3.setTag(R.drawable.wario);
                        break;
                    case "Wendy":
                        charImage3.setImageResource(R.drawable.wendy);
                        charImage3.setTag(R.drawable.wendy);
                        break;
                    case "Yoshi (Black)":
                        charImage3.setImageResource(R.drawable.yoshi_black);
                        charImage3.setTag(R.drawable.yoshi_black);
                        break;
                    case "Yoshi (Dark Blue)":
                        charImage3.setImageResource(R.drawable.yoshi_darkblue);
                        charImage3.setTag(R.drawable.yoshi_darkblue);
                        break;
                    case "Yoshi (Green)":
                        charImage3.setImageResource(R.drawable.yoshi_green);
                        charImage3.setTag(R.drawable.yoshi_green);
                        break;
                    case "Yoshi (Light Blue)":
                        charImage3.setImageResource(R.drawable.yoshi_lightblue);
                        charImage3.setTag(R.drawable.yoshi_lightblue);
                        break;
                    case "Yoshi (Orange)":
                        charImage3.setImageResource(R.drawable.yoshi_orange);
                        charImage3.setTag(R.drawable.yoshi_orange);
                        break;
                    case "Yoshi (Pink)":
                        charImage3.setImageResource(R.drawable.yoshi_pink);
                        charImage3.setTag(R.drawable.yoshi_pink);
                        break;
                    case "Yoshi (Red)":
                        charImage3.setImageResource(R.drawable.yoshi_red);
                        charImage3.setTag(R.drawable.yoshi_red);
                        break;
                    case "Yoshi (White)":
                        charImage3.setImageResource(R.drawable.yoshi_white);
                        charImage3.setTag(R.drawable.yoshi_white);
                        break;
                    case "Yoshi (Yellow)":
                        charImage3.setImageResource(R.drawable.yoshi_yellow);
                        charImage3.setTag(R.drawable.yoshi_yellow);
                        break;
                    default:
                        charImage3.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }

                if(playerNumber == 4) {
                    ImageView charImage4 = findViewById(R.id.charImage1d);

                    String randChar4 = randCharacter();
                    if (randChar4.equals("Yoshi") || randChar4.equals("Shy Guy") || randChar4.equals("Metal Mario") || randChar4.equals("Link") || randChar4.equals("Inkling Boy") || randChar4.equals("Inkling Girl"))
                        randChar4 = setColor(randChar4);

                    switch (randChar4) {
                        case "Baby Daisy":
                            charImage4.setImageResource(R.drawable.baby_daisy);
                            charImage4.setTag(R.drawable.baby_daisy);
                            break;
                        case "Baby Luigi":
                            charImage4.setImageResource(R.drawable.baby_luigi);
                            charImage4.setTag(R.drawable.baby_luigi);
                            break;
                        case "Baby Mario":
                            charImage4.setImageResource(R.drawable.baby_mario);
                            charImage4.setTag(R.drawable.baby_mario);
                            break;
                        case "Baby Peach":
                            charImage4.setImageResource(R.drawable.baby_peach);
                            charImage4.setTag(R.drawable.baby_peach);
                            break;
                        case "Baby Rosalina":
                            charImage4.setImageResource(R.drawable.baby_rosalina);
                            charImage4.setTag(R.drawable.baby_rosalina);
                            break;
                        case "Bowser":
                            charImage4.setImageResource(R.drawable.bowser);
                            charImage4.setTag(R.drawable.bowser);
                            break;
                        case "Bowser Jr.":
                            charImage4.setImageResource(R.drawable.bowser_jr);
                            charImage4.setTag(R.drawable.bowser_jr);
                            break;
                        case "Cat Peach":
                            charImage4.setImageResource(R.drawable.cat_peach);
                            charImage4.setTag(R.drawable.cat_peach);
                            break;
                        case "Daisy":
                            charImage4.setImageResource(R.drawable.daisy);
                            charImage4.setTag(R.drawable.daisy);
                            break;
                        case "Donkey Kong":
                            charImage4.setImageResource(R.drawable.donkey_kong);
                            charImage4.setTag(R.drawable.donkey_kong);
                            break;
                        case "Dry Bones":
                            charImage4.setImageResource(R.drawable.dry_bones);
                            charImage4.setTag(R.drawable.dry_bones);
                            break;
                        case "Dry Bowser":
                            charImage4.setImageResource(R.drawable.dry_bowser);
                            charImage4.setTag(R.drawable.dry_bowser);
                            break;
                        case "Metal Mario (Gold)":
                            charImage4.setImageResource(R.drawable.gold_mario);
                            charImage4.setTag(R.drawable.gold_mario);
                            break;
                        case "Iggy":
                            charImage4.setImageResource(R.drawable.iggy);
                            charImage4.setTag(R.drawable.iggy);
                            break;
                        case "Inkling Boy (Dark Blue)":
                            charImage4.setImageResource(R.drawable.inkling_boy_darkblue);
                            charImage4.setTag(R.drawable.inkling_boy_darkblue);
                            break;
                        case "Inkling Boy (Light Blue)":
                            charImage4.setImageResource(R.drawable.inkling_boy_lightblue);
                            charImage4.setTag(R.drawable.inkling_boy_lightblue);
                            break;
                        case "Inkling Boy (Purple)":
                            charImage4.setImageResource(R.drawable.inkling_boy_purple);
                            charImage4.setTag(R.drawable.inkling_boy_purple);
                            break;
                        case "Inkling Girl (Green)":
                            charImage4.setImageResource(R.drawable.inkling_girl_green);
                            charImage4.setTag(R.drawable.inkling_girl_green);
                            break;
                        case "Inkling Girl (Orange)":
                            charImage4.setImageResource(R.drawable.inkling_girl_orange);
                            charImage4.setTag(R.drawable.inkling_girl_orange);
                            break;
                        case "Inkling Girl (Pink)":
                            charImage4.setImageResource(R.drawable.inkling_girl_pink);
                            charImage4.setTag(R.drawable.inkling_girl_pink);
                            break;
                        case "Isabelle":
                            charImage4.setImageResource(R.drawable.isabelle);
                            charImage4.setTag(R.drawable.isabelle);
                            break;
                        case "King Boo":
                            charImage4.setImageResource(R.drawable.king_boo);
                            charImage4.setTag(R.drawable.king_boo);
                            break;
                        case "Koopa Troopa":
                            charImage4.setImageResource(R.drawable.koopa_troopa);
                            charImage4.setTag(R.drawable.koopa_troopa);
                            break;
                        case "Lakitu":
                            charImage4.setImageResource(R.drawable.lakitu);
                            charImage4.setTag(R.drawable.lakitu);
                            break;
                        case "Larry":
                            charImage4.setImageResource(R.drawable.larry);
                            charImage4.setTag(R.drawable.larry);
                            break;
                        case "Lemmy":
                            charImage4.setImageResource(R.drawable.lemmy);
                            charImage4.setTag(R.drawable.lemmy);
                            break;
                        case "Link (BOTW)":
                            charImage4.setImageResource(R.drawable.link_botw);
                            charImage4.setTag(R.drawable.link_botw);
                            break;
                        case "Link (Classic)":
                            charImage4.setImageResource(R.drawable.link_classic);
                            charImage4.setTag(R.drawable.link_classic);
                            break;
                        case "Ludwig":
                            charImage4.setImageResource(R.drawable.ludwig);
                            charImage4.setTag(R.drawable.ludwig);
                            break;
                        case "Luigi":
                            charImage4.setImageResource(R.drawable.luigi);
                            charImage4.setTag(R.drawable.luigi);
                            break;
                        case "Mario":
                            charImage4.setImageResource(R.drawable.mario);
                            charImage4.setTag(R.drawable.mario);
                            break;
                        case "Metal Mario (Metal)":
                            charImage4.setImageResource(R.drawable.metal_mario);
                            charImage4.setTag(R.drawable.metal_mario);
                            break;
                        case "Mii":
                            charImage4.setImageResource(R.drawable.mii);
                            charImage4.setTag(R.drawable.mii);
                            break;
                        case "Morton":
                            charImage4.setImageResource(R.drawable.morton);
                            charImage4.setTag(R.drawable.morton);
                            break;
                        case "Peach":
                            charImage4.setImageResource(R.drawable.peach);
                            charImage4.setTag(R.drawable.peach);
                            break;
                        case "Pink Gold Peach":
                            charImage4.setImageResource(R.drawable.pink_gold_peach);
                            charImage4.setTag(R.drawable.pink_gold_peach);
                            break;
                        case "Rosalina":
                            charImage4.setImageResource(R.drawable.rosalina);
                            charImage4.setTag(R.drawable.rosalina);
                            break;
                        case "Roy":
                            charImage4.setImageResource(R.drawable.roy);
                            charImage4.setTag(R.drawable.roy);
                            break;
                        case "Shy Guy (Black)":
                            charImage4.setImageResource(R.drawable.shyguy_black);
                            charImage4.setTag(R.drawable.shyguy_black);
                            break;
                        case "Shy Guy (Dark Blue)":
                            charImage4.setImageResource(R.drawable.shyguy_darkblue);
                            charImage4.setTag(R.drawable.shyguy_darkblue);
                            break;
                        case "Shy Guy (Green)":
                            charImage4.setImageResource(R.drawable.shyguy_green);
                            charImage4.setTag(R.drawable.shyguy_green);
                            break;
                        case "Shy Guy (Light Blue)":
                            charImage4.setImageResource(R.drawable.shyguy_lightblue);
                            charImage4.setTag(R.drawable.shyguy_lightblue);
                            break;
                        case "Shy Guy (Orange)":
                            charImage4.setImageResource(R.drawable.shyguy_orange);
                            charImage4.setTag(R.drawable.shyguy_orange);
                            break;
                        case "Shy Guy (Pink)":
                            charImage4.setImageResource(R.drawable.shyguy_pink);
                            charImage4.setTag(R.drawable.shyguy_pink);
                            break;
                        case "Shy Guy (Red)":
                            charImage4.setImageResource(R.drawable.shyguy_red);
                            charImage4.setTag(R.drawable.shyguy_red);
                            break;
                        case "Shy Guy (White)":
                            charImage4.setImageResource(R.drawable.shyguy_white);
                            charImage4.setTag(R.drawable.shyguy_white);
                            break;
                        case "Shy Guy (Yellow)":
                            charImage4.setImageResource(R.drawable.shyguy_yellow);
                            charImage4.setTag(R.drawable.shyguy_yellow);
                            break;
                        case "Tanooki Mario":
                            charImage4.setImageResource(R.drawable.tanooki_mario);
                            charImage4.setTag(R.drawable.tanooki_mario);
                            break;
                        case "Toad":
                            charImage4.setImageResource(R.drawable.toad);
                            charImage4.setTag(R.drawable.toad);
                            break;
                        case "Toadette":
                            charImage4.setImageResource(R.drawable.toadette);
                            charImage4.setTag(R.drawable.toadette);
                            break;
                        case "Villager (B)":
                            charImage4.setImageResource(R.drawable.villager_boy);
                            charImage4.setTag(R.drawable.villager_boy);
                            break;
                        case "Villager (G)":
                            charImage4.setImageResource(R.drawable.villager_girl);
                            charImage4.setTag(R.drawable.villager_girl);
                            break;
                        case "Waluigi":
                            charImage4.setImageResource(R.drawable.waluigi);
                            charImage4.setTag(R.drawable.waluigi);
                            break;
                        case "Wario":
                            charImage4.setImageResource(R.drawable.wario);
                            charImage4.setTag(R.drawable.wario);
                            break;
                        case "Wendy":
                            charImage4.setImageResource(R.drawable.wendy);
                            charImage4.setTag(R.drawable.wendy);
                            break;
                        case "Yoshi (Black)":
                            charImage4.setImageResource(R.drawable.yoshi_black);
                            charImage4.setTag(R.drawable.yoshi_black);
                            break;
                        case "Yoshi (Dark Blue)":
                            charImage4.setImageResource(R.drawable.yoshi_darkblue);
                            charImage4.setTag(R.drawable.yoshi_darkblue);
                            break;
                        case "Yoshi (Green)":
                            charImage4.setImageResource(R.drawable.yoshi_green);
                            charImage4.setTag(R.drawable.yoshi_green);
                            break;
                        case "Yoshi (Light Blue)":
                            charImage4.setImageResource(R.drawable.yoshi_lightblue);
                            charImage4.setTag(R.drawable.yoshi_lightblue);
                            break;
                        case "Yoshi (Orange)":
                            charImage4.setImageResource(R.drawable.yoshi_orange);
                            charImage4.setTag(R.drawable.yoshi_orange);
                            break;
                        case "Yoshi (Pink)":
                            charImage4.setImageResource(R.drawable.yoshi_pink);
                            charImage4.setTag(R.drawable.yoshi_pink);
                            break;
                        case "Yoshi (Red)":
                            charImage4.setImageResource(R.drawable.yoshi_red);
                            charImage4.setTag(R.drawable.yoshi_red);
                            break;
                        case "Yoshi (White)":
                            charImage4.setImageResource(R.drawable.yoshi_white);
                            charImage4.setTag(R.drawable.yoshi_white);
                            break;
                        case "Yoshi (Yellow)":
                            charImage4.setImageResource(R.drawable.yoshi_yellow);
                            charImage4.setTag(R.drawable.yoshi_yellow);
                            break;
                        default:
                            charImage4.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                    }
                }
            }
        }
    }

    /**
     * takes in the number of players, calls randFrame() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     * @param playerNumber is the number of characters that need randomized frames
     */
    private void setFrameImage(int playerNumber) {
        ImageView frameImage = findViewById(R.id.frameImage1a);

        String randFrame = randFrame();
        switch (randFrame) {
            case "Standard Kart":
                frameImage.setImageResource(R.drawable.standard_kart);
                frameImage.setTag(R.drawable.standard_kart);
                break;
            case "Pipe Frame":
                frameImage.setImageResource(R.drawable.pipe_frame);
                frameImage.setTag(R.drawable.pipe_frame);
                break;
            case "Mach 8":
                frameImage.setImageResource(R.drawable.mach_8);
                frameImage.setTag(R.drawable.mach_8);
                break;
            case "Steel Driver":
                frameImage.setImageResource(R.drawable.steel_driver);
                frameImage.setTag(R.drawable.steel_driver);
                break;
            case "Cat Cruiser":
                frameImage.setImageResource(R.drawable.cat_cruiser);
                frameImage.setTag(R.drawable.cat_cruiser);
                break;
            case "Circuit Special":
                frameImage.setImageResource(R.drawable.circuit_special);
                frameImage.setTag(R.drawable.circuit_special);
                break;
            case "Tri-Speeder":
                frameImage.setImageResource(R.drawable.trispeeder);
                frameImage.setTag(R.drawable.trispeeder);
                break;
            case "Badwagon":
                frameImage.setImageResource(R.drawable.badwagon);
                frameImage.setTag(R.drawable.badwagon);
                break;
            case "Prancer":
                frameImage.setImageResource(R.drawable.prancer);
                frameImage.setTag(R.drawable.prancer);
                break;
            case "Biddybuggy":
                frameImage.setImageResource(R.drawable.biddybuggy);
                frameImage.setTag(R.drawable.biddybuggy);
                break;
            case "Landship":
                frameImage.setImageResource(R.drawable.landship);
                frameImage.setTag(R.drawable.landship);
                break;
            case "Sneeker":
                frameImage.setImageResource(R.drawable.sneeker);
                frameImage.setTag(R.drawable.sneeker);
                break;
            case "Sports Coupe":
                frameImage.setImageResource(R.drawable.sports_coupe);
                frameImage.setTag(R.drawable.sports_coupe);
                break;
            case "Gold Standard":
                frameImage.setImageResource(R.drawable.gold_standard);
                frameImage.setTag(R.drawable.gold_standard);
                break;
            case "GLA":
                frameImage.setImageResource(R.drawable.gla);
                frameImage.setTag(R.drawable.gla);
                break;
            case "W 25 Silver Arrow":
                frameImage.setImageResource(R.drawable.silver_arrow);
                frameImage.setTag(R.drawable.silver_arrow);
                break;
            case "300 SL Roadster":
                frameImage.setImageResource(R.drawable.roadster);
                frameImage.setTag(R.drawable.roadster);
                break;
            case "Blue Falcon":
                frameImage.setImageResource(R.drawable.blue_falcon);
                frameImage.setTag(R.drawable.blue_falcon);
                break;
            case "Tanooki Kart":
                frameImage.setImageResource(R.drawable.tanooki_kart);
                frameImage.setTag(R.drawable.tanooki_kart);
                break;
            case "B Dasher":
                frameImage.setImageResource(R.drawable.b_dasher);
                frameImage.setTag(R.drawable.b_dasher);
                break;
            case "Streetle":
                frameImage.setImageResource(R.drawable.streetle);
                frameImage.setTag(R.drawable.streetle);
                break;
            case "P-Wing":
                frameImage.setImageResource(R.drawable.p_wing);
                frameImage.setTag(R.drawable.p_wing);
                break;
            case "Koopa Clown":
                frameImage.setImageResource(R.drawable.koopa_clown);
                frameImage.setTag(R.drawable.koopa_clown);
                break;
            case "Standard Bike":
                frameImage.setImageResource(R.drawable.standard_bike);
                frameImage.setTag(R.drawable.standard_bike);
                break;
            case "The Duke":
                frameImage.setImageResource(R.drawable.the_duke);
                frameImage.setTag(R.drawable.the_duke);
                break;
            case "Flame Rider":
                frameImage.setImageResource(R.drawable.flame_rider);
                frameImage.setTag(R.drawable.flame_rider);
                break;
            case "Varmint":
                frameImage.setImageResource(R.drawable.varmint);
                frameImage.setTag(R.drawable.varmint);
                break;
            case "Mr. Scooty":
                frameImage.setImageResource(R.drawable.mr_scooty);
                frameImage.setTag(R.drawable.mr_scooty);
                break;
            case "City Tripper":
                frameImage.setImageResource(R.drawable.city_tripper);
                frameImage.setTag(R.drawable.city_tripper);
                break;
            case "Master Cycle Zero":
                frameImage.setImageResource(R.drawable.master_cycle_zero);
                frameImage.setTag(R.drawable.master_cycle_zero);
                break;
            case "Comet":
                frameImage.setImageResource(R.drawable.comet);
                frameImage.setTag(R.drawable.comet);
                break;
            case "Sports Bike":
                frameImage.setImageResource(R.drawable.sports_bike);
                frameImage.setTag(R.drawable.sports_bike);
                break;
            case "Jet Bike":
                frameImage.setImageResource(R.drawable.jet_bike);
                frameImage.setTag(R.drawable.jet_bike);
                break;
            case "Master Cycle":
                frameImage.setImageResource(R.drawable.master_cycle);
                frameImage.setTag(R.drawable.master_cycle);
                break;
            case "Standard ATV":
                frameImage.setImageResource(R.drawable.standard_atv);
                frameImage.setTag(R.drawable.standard_atv);
                break;
            case "Wild Wiggler":
                frameImage.setImageResource(R.drawable.wild_wiggler);
                frameImage.setTag(R.drawable.wild_wiggler);
                break;
            case "Teddy Buggy":
                frameImage.setImageResource(R.drawable.teddy_buggy);
                frameImage.setTag(R.drawable.teddy_buggy);
                break;
            case "Bone Rattler":
                frameImage.setImageResource(R.drawable.bone_rattler);
                frameImage.setTag(R.drawable.bone_rattler);
                break;
            case "Splat Buggy":
                frameImage.setImageResource(R.drawable.splat_buggy);
                frameImage.setTag(R.drawable.splat_buggy);
                break;
            case "Inkstriker":
                frameImage.setImageResource(R.drawable.inkstriker);
                frameImage.setTag(R.drawable.inkstriker);
                break;
            case "Yoshi Bike":
                frameImage.setImageResource(R.drawable.yoshi_bike);
                frameImage.setTag(R.drawable.yoshi_bike);
                break;
            default:
                frameImage.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
        }

        if(playerNumber > 1) {
            ImageView frameImage2 = findViewById(R.id.frameImage1b);

            String randFrame2 = randFrame();
            switch (randFrame2) {
                case "Standard Kart":
                    frameImage2.setImageResource(R.drawable.standard_kart);
                    frameImage2.setTag(R.drawable.standard_kart);
                    break;
                case "Pipe Frame":
                    frameImage2.setImageResource(R.drawable.pipe_frame);
                    frameImage2.setTag(R.drawable.pipe_frame);
                    break;
                case "Mach 8":
                    frameImage2.setImageResource(R.drawable.mach_8);
                    frameImage2.setTag(R.drawable.mach_8);
                    break;
                case "Steel Driver":
                    frameImage2.setImageResource(R.drawable.steel_driver);
                    frameImage2.setTag(R.drawable.steel_driver);
                    break;
                case "Cat Cruiser":
                    frameImage2.setImageResource(R.drawable.cat_cruiser);
                    frameImage2.setTag(R.drawable.cat_cruiser);
                    break;
                case "Circuit Special":
                    frameImage2.setImageResource(R.drawable.circuit_special);
                    frameImage2.setTag(R.drawable.circuit_special);
                    break;
                case "Tri-Speeder":
                    frameImage2.setImageResource(R.drawable.trispeeder);
                    frameImage2.setTag(R.drawable.trispeeder);
                    break;
                case "Badwagon":
                    frameImage2.setImageResource(R.drawable.badwagon);
                    frameImage2.setTag(R.drawable.badwagon);
                    break;
                case "Prancer":
                    frameImage2.setImageResource(R.drawable.prancer);
                    frameImage2.setTag(R.drawable.prancer);
                    break;
                case "Biddybuggy":
                    frameImage2.setImageResource(R.drawable.biddybuggy);
                    frameImage2.setTag(R.drawable.biddybuggy);
                    break;
                case "Landship":
                    frameImage2.setImageResource(R.drawable.landship);
                    frameImage2.setTag(R.drawable.landship);
                    break;
                case "Sneeker":
                    frameImage2.setImageResource(R.drawable.sneeker);
                    frameImage2.setTag(R.drawable.sneeker);
                    break;
                case "Sports Coupe":
                    frameImage2.setImageResource(R.drawable.sports_coupe);
                    frameImage2.setTag(R.drawable.sports_coupe);
                    break;
                case "Gold Standard":
                    frameImage2.setImageResource(R.drawable.gold_standard);
                    frameImage2.setTag(R.drawable.gold_standard);
                    break;
                case "GLA":
                    frameImage2.setImageResource(R.drawable.gla);
                    frameImage2.setTag(R.drawable.gla);
                    break;
                case "W 25 Silver Arrow":
                    frameImage2.setImageResource(R.drawable.silver_arrow);
                    frameImage2.setTag(R.drawable.silver_arrow);
                    break;
                case "300 SL Roadster":
                    frameImage2.setImageResource(R.drawable.roadster);
                    frameImage2.setTag(R.drawable.roadster);
                    break;
                case "Blue Falcon":
                    frameImage2.setImageResource(R.drawable.blue_falcon);
                    frameImage2.setTag(R.drawable.blue_falcon);
                    break;
                case "Tanooki Kart":
                    frameImage2.setImageResource(R.drawable.tanooki_kart);
                    frameImage2.setTag(R.drawable.tanooki_kart);
                    break;
                case "B Dasher":
                    frameImage2.setImageResource(R.drawable.b_dasher);
                    frameImage2.setTag(R.drawable.b_dasher);
                    break;
                case "Streetle":
                    frameImage2.setImageResource(R.drawable.streetle);
                    frameImage2.setTag(R.drawable.streetle);
                    break;
                case "P-Wing":
                    frameImage2.setImageResource(R.drawable.p_wing);
                    frameImage2.setTag(R.drawable.p_wing);
                    break;
                case "Koopa Clown":
                    frameImage2.setImageResource(R.drawable.koopa_clown);
                    frameImage2.setTag(R.drawable.koopa_clown);
                    break;
                case "Standard Bike":
                    frameImage2.setImageResource(R.drawable.standard_bike);
                    frameImage2.setTag(R.drawable.standard_bike);
                    break;
                case "The Duke":
                    frameImage2.setImageResource(R.drawable.the_duke);
                    frameImage2.setTag(R.drawable.the_duke);
                    break;
                case "Flame Rider":
                    frameImage2.setImageResource(R.drawable.flame_rider);
                    frameImage2.setTag(R.drawable.flame_rider);
                    break;
                case "Varmint":
                    frameImage2.setImageResource(R.drawable.varmint);
                    frameImage2.setTag(R.drawable.varmint);
                    break;
                case "Mr. Scooty":
                    frameImage2.setImageResource(R.drawable.mr_scooty);
                    frameImage2.setTag(R.drawable.mr_scooty);
                    break;
                case "City Tripper":
                    frameImage2.setImageResource(R.drawable.city_tripper);
                    frameImage2.setTag(R.drawable.city_tripper);
                    break;
                case "Master Cycle Zero":
                    frameImage2.setImageResource(R.drawable.master_cycle_zero);
                    frameImage2.setTag(R.drawable.master_cycle_zero);
                    break;
                case "Comet":
                    frameImage2.setImageResource(R.drawable.comet);
                    frameImage2.setTag(R.drawable.comet);
                    break;
                case "Sports Bike":
                    frameImage2.setImageResource(R.drawable.sports_bike);
                    frameImage2.setTag(R.drawable.sports_bike);
                    break;
                case "Jet Bike":
                    frameImage2.setImageResource(R.drawable.jet_bike);
                    frameImage2.setTag(R.drawable.jet_bike);
                    break;
                case "Master Cycle":
                    frameImage2.setImageResource(R.drawable.master_cycle);
                    frameImage2.setTag(R.drawable.master_cycle);
                    break;
                case "Standard ATV":
                    frameImage2.setImageResource(R.drawable.standard_atv);
                    frameImage2.setTag(R.drawable.standard_atv);
                    break;
                case "Wild Wiggler":
                    frameImage2.setImageResource(R.drawable.wild_wiggler);
                    frameImage2.setTag(R.drawable.wild_wiggler);
                    break;
                case "Teddy Buggy":
                    frameImage2.setImageResource(R.drawable.teddy_buggy);
                    frameImage2.setTag(R.drawable.teddy_buggy);
                    break;
                case "Bone Rattler":
                    frameImage2.setImageResource(R.drawable.bone_rattler);
                    frameImage2.setTag(R.drawable.bone_rattler);
                    break;
                case "Splat Buggy":
                    frameImage2.setImageResource(R.drawable.splat_buggy);
                    frameImage2.setTag(R.drawable.splat_buggy);
                    break;
                case "Inkstriker":
                    frameImage2.setImageResource(R.drawable.inkstriker);
                    frameImage2.setTag(R.drawable.inkstriker);
                    break;
                case "Yoshi Bike":
                    frameImage2.setImageResource(R.drawable.yoshi_bike);
                    frameImage2.setTag(R.drawable.yoshi_bike);
                    break;
                default:
                    frameImage2.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }

            if(playerNumber > 2) {
                ImageView frameImage3 = findViewById(R.id.frameImage1c);

                String randFrame3 = randFrame();
                switch (randFrame3) {
                    case "Standard Kart":
                        frameImage3.setImageResource(R.drawable.standard_kart);
                        frameImage3.setTag(R.drawable.standard_kart);
                        break;
                    case "Pipe Frame":
                        frameImage3.setImageResource(R.drawable.pipe_frame);
                        frameImage3.setTag(R.drawable.pipe_frame);
                        break;
                    case "Mach 8":
                        frameImage3.setImageResource(R.drawable.mach_8);
                        frameImage3.setTag(R.drawable.mach_8);
                        break;
                    case "Steel Driver":
                        frameImage3.setImageResource(R.drawable.steel_driver);
                        frameImage3.setTag(R.drawable.steel_driver);
                        break;
                    case "Cat Cruiser":
                        frameImage3.setImageResource(R.drawable.cat_cruiser);
                        frameImage3.setTag(R.drawable.cat_cruiser);
                        break;
                    case "Circuit Special":
                        frameImage3.setImageResource(R.drawable.circuit_special);
                        frameImage3.setTag(R.drawable.circuit_special);
                        break;
                    case "Tri-Speeder":
                        frameImage3.setImageResource(R.drawable.trispeeder);
                        frameImage3.setTag(R.drawable.trispeeder);
                        break;
                    case "Badwagon":
                        frameImage3.setImageResource(R.drawable.badwagon);
                        frameImage3.setTag(R.drawable.badwagon);
                        break;
                    case "Prancer":
                        frameImage3.setImageResource(R.drawable.prancer);
                        frameImage3.setTag(R.drawable.prancer);
                        break;
                    case "Biddybuggy":
                        frameImage3.setImageResource(R.drawable.biddybuggy);
                        frameImage3.setTag(R.drawable.biddybuggy);
                        break;
                    case "Landship":
                        frameImage3.setImageResource(R.drawable.landship);
                        frameImage3.setTag(R.drawable.landship);
                        break;
                    case "Sneeker":
                        frameImage3.setImageResource(R.drawable.sneeker);
                        frameImage3.setTag(R.drawable.sneeker);
                        break;
                    case "Sports Coupe":
                        frameImage3.setImageResource(R.drawable.sports_coupe);
                        frameImage3.setTag(R.drawable.sports_coupe);
                        break;
                    case "Gold Standard":
                        frameImage3.setImageResource(R.drawable.gold_standard);
                        frameImage3.setTag(R.drawable.gold_standard);
                        break;
                    case "GLA":
                        frameImage3.setImageResource(R.drawable.gla);
                        frameImage3.setTag(R.drawable.gla);
                        break;
                    case "W 25 Silver Arrow":
                        frameImage3.setImageResource(R.drawable.silver_arrow);
                        frameImage3.setTag(R.drawable.silver_arrow);
                        break;
                    case "300 SL Roadster":
                        frameImage3.setImageResource(R.drawable.roadster);
                        frameImage3.setTag(R.drawable.roadster);
                        break;
                    case "Blue Falcon":
                        frameImage3.setImageResource(R.drawable.blue_falcon);
                        frameImage3.setTag(R.drawable.blue_falcon);
                        break;
                    case "Tanooki Kart":
                        frameImage3.setImageResource(R.drawable.tanooki_kart);
                        frameImage3.setTag(R.drawable.tanooki_kart);
                        break;
                    case "B Dasher":
                        frameImage3.setImageResource(R.drawable.b_dasher);
                        frameImage3.setTag(R.drawable.b_dasher);
                        break;
                    case "Streetle":
                        frameImage3.setImageResource(R.drawable.streetle);
                        frameImage3.setTag(R.drawable.streetle);
                        break;
                    case "P-Wing":
                        frameImage3.setImageResource(R.drawable.p_wing);
                        frameImage3.setTag(R.drawable.p_wing);
                        break;
                    case "Koopa Clown":
                        frameImage3.setImageResource(R.drawable.koopa_clown);
                        frameImage3.setTag(R.drawable.koopa_clown);
                        break;
                    case "Standard Bike":
                        frameImage3.setImageResource(R.drawable.standard_bike);
                        frameImage3.setTag(R.drawable.standard_bike);
                        break;
                    case "The Duke":
                        frameImage3.setImageResource(R.drawable.the_duke);
                        frameImage3.setTag(R.drawable.the_duke);
                        break;
                    case "Flame Rider":
                        frameImage3.setImageResource(R.drawable.flame_rider);
                        frameImage3.setTag(R.drawable.flame_rider);
                        break;
                    case "Varmint":
                        frameImage3.setImageResource(R.drawable.varmint);
                        frameImage3.setTag(R.drawable.varmint);
                        break;
                    case "Mr. Scooty":
                        frameImage3.setImageResource(R.drawable.mr_scooty);
                        frameImage3.setTag(R.drawable.mr_scooty);
                        break;
                    case "City Tripper":
                        frameImage3.setImageResource(R.drawable.city_tripper);
                        frameImage3.setTag(R.drawable.city_tripper);
                        break;
                    case "Master Cycle Zero":
                        frameImage3.setImageResource(R.drawable.master_cycle_zero);
                        frameImage3.setTag(R.drawable.master_cycle_zero);
                        break;
                    case "Comet":
                        frameImage3.setImageResource(R.drawable.comet);
                        frameImage3.setTag(R.drawable.comet);
                        break;
                    case "Sports Bike":
                        frameImage3.setImageResource(R.drawable.sports_bike);
                        frameImage3.setTag(R.drawable.sports_bike);
                        break;
                    case "Jet Bike":
                        frameImage3.setImageResource(R.drawable.jet_bike);
                        frameImage3.setTag(R.drawable.jet_bike);
                        break;
                    case "Master Cycle":
                        frameImage3.setImageResource(R.drawable.master_cycle);
                        frameImage3.setTag(R.drawable.master_cycle);
                        break;
                    case "Standard ATV":
                        frameImage3.setImageResource(R.drawable.standard_atv);
                        frameImage3.setTag(R.drawable.standard_atv);
                        break;
                    case "Wild Wiggler":
                        frameImage3.setImageResource(R.drawable.wild_wiggler);
                        frameImage3.setTag(R.drawable.wild_wiggler);
                        break;
                    case "Teddy Buggy":
                        frameImage3.setImageResource(R.drawable.teddy_buggy);
                        frameImage3.setTag(R.drawable.teddy_buggy);
                        break;
                    case "Bone Rattler":
                        frameImage3.setImageResource(R.drawable.bone_rattler);
                        frameImage3.setTag(R.drawable.bone_rattler);
                        break;
                    case "Splat Buggy":
                        frameImage3.setImageResource(R.drawable.splat_buggy);
                        frameImage3.setTag(R.drawable.splat_buggy);
                        break;
                    case "Inkstriker":
                        frameImage3.setImageResource(R.drawable.inkstriker);
                        frameImage3.setTag(R.drawable.inkstriker);
                        break;
                    case "Yoshi Bike":
                        frameImage3.setImageResource(R.drawable.yoshi_bike);
                        frameImage3.setTag(R.drawable.yoshi_bike);
                        break;
                    default:
                        frameImage3.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }

                if(playerNumber == 4) {
                    ImageView frameImage4 = findViewById(R.id.frameImage1d);

                    String randFrame4 = randFrame();
                    switch (randFrame4) {
                        case "Standard Kart":
                            frameImage4.setImageResource(R.drawable.standard_kart);
                            frameImage4.setTag(R.drawable.standard_kart);
                            break;
                        case "Pipe Frame":
                            frameImage4.setImageResource(R.drawable.pipe_frame);
                            frameImage4.setTag(R.drawable.pipe_frame);
                            break;
                        case "Mach 8":
                            frameImage4.setImageResource(R.drawable.mach_8);
                            frameImage4.setTag(R.drawable.mach_8);
                            break;
                        case "Steel Driver":
                            frameImage4.setImageResource(R.drawable.steel_driver);
                            frameImage4.setTag(R.drawable.steel_driver);
                            break;
                        case "Cat Cruiser":
                            frameImage4.setImageResource(R.drawable.cat_cruiser);
                            frameImage4.setTag(R.drawable.cat_cruiser);
                            break;
                        case "Circuit Special":
                            frameImage4.setImageResource(R.drawable.circuit_special);
                            frameImage4.setTag(R.drawable.circuit_special);
                            break;
                        case "Tri-Speeder":
                            frameImage4.setImageResource(R.drawable.trispeeder);
                            frameImage4.setTag(R.drawable.trispeeder);
                            break;
                        case "Badwagon":
                            frameImage4.setImageResource(R.drawable.badwagon);
                            frameImage4.setTag(R.drawable.badwagon);
                            break;
                        case "Prancer":
                            frameImage4.setImageResource(R.drawable.prancer);
                            frameImage4.setTag(R.drawable.prancer);
                            break;
                        case "Biddybuggy":
                            frameImage4.setImageResource(R.drawable.biddybuggy);
                            frameImage4.setTag(R.drawable.biddybuggy);
                            break;
                        case "Landship":
                            frameImage4.setImageResource(R.drawable.landship);
                            frameImage4.setTag(R.drawable.landship);
                            break;
                        case "Sneeker":
                            frameImage4.setImageResource(R.drawable.sneeker);
                            frameImage4.setTag(R.drawable.sneeker);
                            break;
                        case "Sports Coupe":
                            frameImage4.setImageResource(R.drawable.sports_coupe);
                            frameImage4.setTag(R.drawable.sports_coupe);
                            break;
                        case "Gold Standard":
                            frameImage4.setImageResource(R.drawable.gold_standard);
                            frameImage4.setTag(R.drawable.gold_standard);
                            break;
                        case "GLA":
                            frameImage4.setImageResource(R.drawable.gla);
                            frameImage4.setTag(R.drawable.gla);
                            break;
                        case "W 25 Silver Arrow":
                            frameImage4.setImageResource(R.drawable.silver_arrow);
                            frameImage4.setTag(R.drawable.silver_arrow);
                            break;
                        case "300 SL Roadster":
                            frameImage4.setImageResource(R.drawable.roadster);
                            frameImage4.setTag(R.drawable.roadster);
                            break;
                        case "Blue Falcon":
                            frameImage4.setImageResource(R.drawable.blue_falcon);
                            frameImage4.setTag(R.drawable.blue_falcon);
                            break;
                        case "Tanooki Kart":
                            frameImage4.setImageResource(R.drawable.tanooki_kart);
                            frameImage4.setTag(R.drawable.tanooki_kart);
                            break;
                        case "B Dasher":
                            frameImage4.setImageResource(R.drawable.b_dasher);
                            frameImage4.setTag(R.drawable.b_dasher);
                            break;
                        case "Streetle":
                            frameImage4.setImageResource(R.drawable.streetle);
                            frameImage4.setTag(R.drawable.streetle);
                            break;
                        case "P-Wing":
                            frameImage4.setImageResource(R.drawable.p_wing);
                            frameImage4.setTag(R.drawable.p_wing);
                            break;
                        case "Koopa Clown":
                            frameImage4.setImageResource(R.drawable.koopa_clown);
                            frameImage4.setTag(R.drawable.koopa_clown);
                            break;
                        case "Standard Bike":
                            frameImage4.setImageResource(R.drawable.standard_bike);
                            frameImage4.setTag(R.drawable.standard_bike);
                            break;
                        case "The Duke":
                            frameImage4.setImageResource(R.drawable.the_duke);
                            frameImage4.setTag(R.drawable.the_duke);
                            break;
                        case "Flame Rider":
                            frameImage4.setImageResource(R.drawable.flame_rider);
                            frameImage4.setTag(R.drawable.flame_rider);
                            break;
                        case "Varmint":
                            frameImage4.setImageResource(R.drawable.varmint);
                            frameImage4.setTag(R.drawable.varmint);
                            break;
                        case "Mr. Scooty":
                            frameImage4.setImageResource(R.drawable.mr_scooty);
                            frameImage4.setTag(R.drawable.mr_scooty);
                            break;
                        case "City Tripper":
                            frameImage4.setImageResource(R.drawable.city_tripper);
                            frameImage4.setTag(R.drawable.city_tripper);
                            break;
                        case "Master Cycle Zero":
                            frameImage4.setImageResource(R.drawable.master_cycle_zero);
                            frameImage4.setTag(R.drawable.master_cycle_zero);
                            break;
                        case "Comet":
                            frameImage4.setImageResource(R.drawable.comet);
                            frameImage4.setTag(R.drawable.comet);
                            break;
                        case "Sports Bike":
                            frameImage4.setImageResource(R.drawable.sports_bike);
                            frameImage4.setTag(R.drawable.sports_bike);
                            break;
                        case "Jet Bike":
                            frameImage4.setImageResource(R.drawable.jet_bike);
                            frameImage4.setTag(R.drawable.jet_bike);
                            break;
                        case "Master Cycle":
                            frameImage4.setImageResource(R.drawable.master_cycle);
                            frameImage4.setTag(R.drawable.master_cycle);
                            break;
                        case "Standard ATV":
                            frameImage4.setImageResource(R.drawable.standard_atv);
                            frameImage4.setTag(R.drawable.standard_atv);
                            break;
                        case "Wild Wiggler":
                            frameImage4.setImageResource(R.drawable.wild_wiggler);
                            frameImage4.setTag(R.drawable.wild_wiggler);
                            break;
                        case "Teddy Buggy":
                            frameImage4.setImageResource(R.drawable.teddy_buggy);
                            frameImage4.setTag(R.drawable.teddy_buggy);
                            break;
                        case "Bone Rattler":
                            frameImage4.setImageResource(R.drawable.bone_rattler);
                            frameImage4.setTag(R.drawable.bone_rattler);
                            break;
                        case "Splat Buggy":
                            frameImage4.setImageResource(R.drawable.splat_buggy);
                            frameImage4.setTag(R.drawable.splat_buggy);
                            break;
                        case "Inkstriker":
                            frameImage4.setImageResource(R.drawable.inkstriker);
                            frameImage4.setTag(R.drawable.inkstriker);
                            break;
                        case "Yoshi Bike":
                            frameImage4.setImageResource(R.drawable.yoshi_bike);
                            frameImage4.setTag(R.drawable.yoshi_bike);
                            break;
                        default:
                            frameImage4.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                    }
                }
            }
        }
    }

    /**
     * takes in the number of players, calls randWheels() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     * @param playerNumber is the number of characters that need randomized wheels
     */
    private void setWheelImage(int playerNumber) {
        ImageView wheelImage = findViewById(R.id.wheelImage1a);

        String randWheels = randWheels();
        switch (randWheels) {
            case "Standard Wheels":
                wheelImage.setImageResource(R.drawable.standard_tires);
                wheelImage.setTag(R.drawable.standard_tires);
                break;
            case "Monster Wheels":
                wheelImage.setImageResource(R.drawable.monster_tires);
                wheelImage.setTag(R.drawable.monster_tires);
                break;
            case "Roller Wheels":
                wheelImage.setImageResource(R.drawable.roller_tires);
                wheelImage.setTag(R.drawable.roller_tires);
                break;
            case "Slim Wheels":
                wheelImage.setImageResource(R.drawable.slim_tires);
                wheelImage.setTag(R.drawable.slim_tires);
                break;
            case "Slick Wheels":
                wheelImage.setImageResource(R.drawable.slick_tires);
                wheelImage.setTag(R.drawable.slick_tires);
                break;
            case "Metal Wheels":
                wheelImage.setImageResource(R.drawable.metal_tires);
                wheelImage.setTag(R.drawable.metal_tires);
                break;
            case "Button Wheels":
                wheelImage.setImageResource(R.drawable.button_tires);
                wheelImage.setTag(R.drawable.button_tires);
                break;
            case "Off-Road Wheels":
                wheelImage.setImageResource(R.drawable.off_road);
                wheelImage.setTag(R.drawable.off_road);
                break;
            case "Sponge Wheels":
                wheelImage.setImageResource(R.drawable.sponge_tires);
                wheelImage.setTag(R.drawable.sponge_tires);
                break;
            case "Wood Wheels":
                wheelImage.setImageResource(R.drawable.wood_tires);
                wheelImage.setTag(R.drawable.wood_tires);
                break;
            case "Cushion Wheels":
                wheelImage.setImageResource(R.drawable.cushion_tires);
                wheelImage.setTag(R.drawable.cushion_tires);
                break;
            case "Blue Standard Wheels":
                wheelImage.setImageResource(R.drawable.blue_standard_tires);
                wheelImage.setTag(R.drawable.blue_standard_tires);
                break;
            case "Hot Monster Wheels":
                wheelImage.setImageResource(R.drawable.hot_monster_tires);
                wheelImage.setTag(R.drawable.hot_monster_tires);
                break;
            case "Azure Roller Wheels":
                wheelImage.setImageResource(R.drawable.azure_rollers);
                wheelImage.setTag(R.drawable.azure_rollers);
                break;
            case "Crimson Slim Wheels":
                wheelImage.setImageResource(R.drawable.crimson_slim_tires);
                wheelImage.setTag(R.drawable.crimson_slim_tires);
                break;
            case "Cyber Slick Wheels":
                wheelImage.setImageResource(R.drawable.cyber_slick_tires);
                wheelImage.setTag(R.drawable.cyber_slick_tires);
                break;
            case "Retro Off-Road Wheels":
                wheelImage.setImageResource(R.drawable.retro_off_road);
                wheelImage.setTag(R.drawable.retro_off_road);
                break;
            case "Gold Tires":
                wheelImage.setImageResource(R.drawable.gold_tires);
                wheelImage.setTag(R.drawable.gold_tires);
                break;
            case "GLA Tires":
                wheelImage.setImageResource(R.drawable.gla_tires);
                wheelImage.setTag(R.drawable.gla_tires);
                break;
            case "Triforce Tires":
                wheelImage.setImageResource(R.drawable.triforce_tires);
                wheelImage.setTag(R.drawable.triforce_tires);
                break;
            case "Leaf Tires":
                wheelImage.setImageResource(R.drawable.leaf_tires);
                wheelImage.setTag(R.drawable.leaf_tires);
                break;
            case "Ancient Tires":
                wheelImage.setImageResource(R.drawable.ancient_tires);
                wheelImage.setTag(R.drawable.ancient_tires);
                break;
            default:
                wheelImage.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
        }

        if(playerNumber > 1) {
            ImageView wheelImage2 = findViewById(R.id.wheelImage1b);

            String randWheels2 = randWheels();
            switch (randWheels2) {
                case "Standard Wheels":
                    wheelImage2.setImageResource(R.drawable.standard_tires);
                    wheelImage2.setTag(R.drawable.standard_tires);
                    break;
                case "Monster Wheels":
                    wheelImage2.setImageResource(R.drawable.monster_tires);
                    wheelImage2.setTag(R.drawable.monster_tires);
                    break;
                case "Roller Wheels":
                    wheelImage2.setImageResource(R.drawable.roller_tires);
                    wheelImage2.setTag(R.drawable.roller_tires);
                    break;
                case "Slim Wheels":
                    wheelImage2.setImageResource(R.drawable.slim_tires);
                    wheelImage2.setTag(R.drawable.slim_tires);
                    break;
                case "Slick Wheels":
                    wheelImage2.setImageResource(R.drawable.slick_tires);
                    wheelImage2.setTag(R.drawable.slick_tires);
                    break;
                case "Metal Wheels":
                    wheelImage2.setImageResource(R.drawable.metal_tires);
                    wheelImage2.setTag(R.drawable.metal_tires);
                    break;
                case "Button Wheels":
                    wheelImage2.setImageResource(R.drawable.button_tires);
                    wheelImage2.setTag(R.drawable.button_tires);
                    break;
                case "Off-Road Wheels":
                    wheelImage2.setImageResource(R.drawable.off_road);
                    wheelImage2.setTag(R.drawable.off_road);
                    break;
                case "Sponge Wheels":
                    wheelImage2.setImageResource(R.drawable.sponge_tires);
                    wheelImage2.setTag(R.drawable.sponge_tires);
                    break;
                case "Wood Wheels":
                    wheelImage2.setImageResource(R.drawable.wood_tires);
                    wheelImage2.setTag(R.drawable.wood_tires);
                    break;
                case "Cushion Wheels":
                    wheelImage2.setImageResource(R.drawable.cushion_tires);
                    wheelImage2.setTag(R.drawable.cushion_tires);
                    break;
                case "Blue Standard Wheels":
                    wheelImage2.setImageResource(R.drawable.blue_standard_tires);
                    wheelImage2.setTag(R.drawable.blue_standard_tires);
                    break;
                case "Hot Monster Wheels":
                    wheelImage2.setImageResource(R.drawable.hot_monster_tires);
                    wheelImage2.setTag(R.drawable.hot_monster_tires);
                    break;
                case "Azure Roller Wheels":
                    wheelImage2.setImageResource(R.drawable.azure_rollers);
                    wheelImage2.setTag(R.drawable.azure_rollers);
                    break;
                case "Crimson Slim Wheels":
                    wheelImage2.setImageResource(R.drawable.crimson_slim_tires);
                    wheelImage2.setTag(R.drawable.crimson_slim_tires);
                    break;
                case "Cyber Slick Wheels":
                    wheelImage2.setImageResource(R.drawable.cyber_slick_tires);
                    wheelImage2.setTag(R.drawable.cyber_slick_tires);
                    break;
                case "Retro Off-Road Wheels":
                    wheelImage2.setImageResource(R.drawable.retro_off_road);
                    wheelImage2.setTag(R.drawable.retro_off_road);
                    break;
                case "Gold Tires":
                    wheelImage2.setImageResource(R.drawable.gold_tires);
                    wheelImage2.setTag(R.drawable.gold_tires);
                    break;
                case "GLA Tires":
                    wheelImage2.setImageResource(R.drawable.gla_tires);
                    wheelImage2.setTag(R.drawable.gla_tires);
                    break;
                case "Triforce Tires":
                    wheelImage2.setImageResource(R.drawable.triforce_tires);
                    wheelImage2.setTag(R.drawable.triforce_tires);
                    break;
                case "Leaf Tires":
                    wheelImage2.setImageResource(R.drawable.leaf_tires);
                    wheelImage2.setTag(R.drawable.leaf_tires);
                    break;
                case "Ancient Tires":
                    wheelImage2.setImageResource(R.drawable.ancient_tires);
                    wheelImage2.setTag(R.drawable.ancient_tires);
                    break;
                default:
                    wheelImage2.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }

            if(playerNumber > 2) {
                ImageView wheelImage3 = findViewById(R.id.wheelImage1c);

                String randWheels3 = randWheels();
                switch (randWheels3) {
                    case "Standard Wheels":
                        wheelImage3.setImageResource(R.drawable.standard_tires);
                        wheelImage3.setTag(R.drawable.standard_tires);
                        break;
                    case "Monster Wheels":
                        wheelImage3.setImageResource(R.drawable.monster_tires);
                        wheelImage3.setTag(R.drawable.monster_tires);
                        break;
                    case "Roller Wheels":
                        wheelImage3.setImageResource(R.drawable.roller_tires);
                        wheelImage3.setTag(R.drawable.roller_tires);
                        break;
                    case "Slim Wheels":
                        wheelImage3.setImageResource(R.drawable.slim_tires);
                        wheelImage3.setTag(R.drawable.slim_tires);
                        break;
                    case "Slick Wheels":
                        wheelImage3.setImageResource(R.drawable.slick_tires);
                        wheelImage3.setTag(R.drawable.slick_tires);
                        break;
                    case "Metal Wheels":
                        wheelImage3.setImageResource(R.drawable.metal_tires);
                        wheelImage3.setTag(R.drawable.metal_tires);
                        break;
                    case "Button Wheels":
                        wheelImage3.setImageResource(R.drawable.button_tires);
                        wheelImage3.setTag(R.drawable.button_tires);
                        break;
                    case "Off-Road Wheels":
                        wheelImage3.setImageResource(R.drawable.off_road);
                        wheelImage3.setTag(R.drawable.off_road);
                        break;
                    case "Sponge Wheels":
                        wheelImage3.setImageResource(R.drawable.sponge_tires);
                        wheelImage3.setTag(R.drawable.sponge_tires);
                        break;
                    case "Wood Wheels":
                        wheelImage3.setImageResource(R.drawable.wood_tires);
                        wheelImage3.setTag(R.drawable.wood_tires);
                        break;
                    case "Cushion Wheels":
                        wheelImage3.setImageResource(R.drawable.cushion_tires);
                        wheelImage3.setTag(R.drawable.cushion_tires);
                        break;
                    case "Blue Standard Wheels":
                        wheelImage3.setImageResource(R.drawable.blue_standard_tires);
                        wheelImage3.setTag(R.drawable.blue_standard_tires);
                        break;
                    case "Hot Monster Wheels":
                        wheelImage3.setImageResource(R.drawable.hot_monster_tires);
                        wheelImage3.setTag(R.drawable.hot_monster_tires);
                        break;
                    case "Azure Roller Wheels":
                        wheelImage3.setImageResource(R.drawable.azure_rollers);
                        wheelImage3.setTag(R.drawable.azure_rollers);
                        break;
                    case "Crimson Slim Wheels":
                        wheelImage3.setImageResource(R.drawable.crimson_slim_tires);
                        wheelImage3.setTag(R.drawable.crimson_slim_tires);
                        break;
                    case "Cyber Slick Wheels":
                        wheelImage3.setImageResource(R.drawable.cyber_slick_tires);
                        wheelImage3.setTag(R.drawable.cyber_slick_tires);
                        break;
                    case "Retro Off-Road Wheels":
                        wheelImage3.setImageResource(R.drawable.retro_off_road);
                        wheelImage3.setTag(R.drawable.retro_off_road);
                        break;
                    case "Gold Tires":
                        wheelImage3.setImageResource(R.drawable.gold_tires);
                        wheelImage3.setTag(R.drawable.gold_tires);
                        break;
                    case "GLA Tires":
                        wheelImage3.setImageResource(R.drawable.gla_tires);
                        wheelImage3.setTag(R.drawable.gla_tires);
                        break;
                    case "Triforce Tires":
                        wheelImage3.setImageResource(R.drawable.triforce_tires);
                        wheelImage3.setTag(R.drawable.triforce_tires);
                        break;
                    case "Leaf Tires":
                        wheelImage3.setImageResource(R.drawable.leaf_tires);
                        wheelImage3.setTag(R.drawable.leaf_tires);
                        break;
                    case "Ancient Tires":
                        wheelImage3.setImageResource(R.drawable.ancient_tires);
                        wheelImage3.setTag(R.drawable.ancient_tires);
                        break;
                    default:
                        wheelImage3.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }

                if(playerNumber == 4) {
                    ImageView wheelImage4 = findViewById(R.id.wheelImage1d);

                    String randWheels4 = randWheels();
                    switch (randWheels4) {
                        case "Standard Wheels":
                            wheelImage4.setImageResource(R.drawable.standard_tires);
                            wheelImage4.setTag(R.drawable.standard_tires);
                            break;
                        case "Monster Wheels":
                            wheelImage4.setImageResource(R.drawable.monster_tires);
                            wheelImage4.setTag(R.drawable.monster_tires);
                            break;
                        case "Roller Wheels":
                            wheelImage4.setImageResource(R.drawable.roller_tires);
                            wheelImage4.setTag(R.drawable.roller_tires);
                            break;
                        case "Slim Wheels":
                            wheelImage4.setImageResource(R.drawable.slim_tires);
                            wheelImage4.setTag(R.drawable.slim_tires);
                            break;
                        case "Slick Wheels":
                            wheelImage4.setImageResource(R.drawable.slick_tires);
                            wheelImage4.setTag(R.drawable.slick_tires);
                            break;
                        case "Metal Wheels":
                            wheelImage4.setImageResource(R.drawable.metal_tires);
                            wheelImage4.setTag(R.drawable.metal_tires);
                            break;
                        case "Button Wheels":
                            wheelImage4.setImageResource(R.drawable.button_tires);
                            wheelImage4.setTag(R.drawable.button_tires);
                            break;
                        case "Off-Road Wheels":
                            wheelImage4.setImageResource(R.drawable.off_road);
                            wheelImage4.setTag(R.drawable.off_road);
                            break;
                        case "Sponge Wheels":
                            wheelImage4.setImageResource(R.drawable.sponge_tires);
                            wheelImage4.setTag(R.drawable.sponge_tires);
                            break;
                        case "Wood Wheels":
                            wheelImage4.setImageResource(R.drawable.wood_tires);
                            wheelImage4.setTag(R.drawable.wood_tires);
                            break;
                        case "Cushion Wheels":
                            wheelImage4.setImageResource(R.drawable.cushion_tires);
                            wheelImage4.setTag(R.drawable.cushion_tires);
                            break;
                        case "Blue Standard Wheels":
                            wheelImage4.setImageResource(R.drawable.blue_standard_tires);
                            wheelImage4.setTag(R.drawable.blue_standard_tires);
                            break;
                        case "Hot Monster Wheels":
                            wheelImage4.setImageResource(R.drawable.hot_monster_tires);
                            wheelImage4.setTag(R.drawable.hot_monster_tires);
                            break;
                        case "Azure Roller Wheels":
                            wheelImage4.setImageResource(R.drawable.azure_rollers);
                            wheelImage4.setTag(R.drawable.azure_rollers);
                            break;
                        case "Crimson Slim Wheels":
                            wheelImage4.setImageResource(R.drawable.crimson_slim_tires);
                            wheelImage4.setTag(R.drawable.crimson_slim_tires);
                            break;
                        case "Cyber Slick Wheels":
                            wheelImage4.setImageResource(R.drawable.cyber_slick_tires);
                            wheelImage4.setTag(R.drawable.cyber_slick_tires);
                            break;
                        case "Retro Off-Road Wheels":
                            wheelImage4.setImageResource(R.drawable.retro_off_road);
                            wheelImage4.setTag(R.drawable.retro_off_road);
                            break;
                        case "Gold Tires":
                            wheelImage4.setImageResource(R.drawable.gold_tires);
                            wheelImage4.setTag(R.drawable.gold_tires);
                            break;
                        case "GLA Tires":
                            wheelImage4.setImageResource(R.drawable.gla_tires);
                            wheelImage4.setTag(R.drawable.gla_tires);
                            break;
                        case "Triforce Tires":
                            wheelImage4.setImageResource(R.drawable.triforce_tires);
                            wheelImage4.setTag(R.drawable.triforce_tires);
                            break;
                        case "Leaf Tires":
                            wheelImage4.setImageResource(R.drawable.leaf_tires);
                            wheelImage4.setTag(R.drawable.leaf_tires);
                            break;
                        case "Ancient Tires":
                            wheelImage4.setImageResource(R.drawable.ancient_tires);
                            wheelImage4.setTag(R.drawable.ancient_tires);
                            break;
                        default:
                            wheelImage4.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                    }
                }
            }
        }
    }

    /**
     * takes in the number of players, calls randGlider() for the necessary number of players, and sets the appropriate ImageViews to the correct image per player
     * @param playerNumber is the number of characters that need randomized gliders
     */
    private void setGliderImage(int playerNumber) {
        ImageView gliderImage = findViewById(R.id.gliderImage1a);

        String randGlider = randGlider();
        switch (randGlider) {
            case "Super Glider":
                gliderImage.setImageResource(R.drawable.super_glider);
                gliderImage.setTag(R.drawable.super_glider);
                break;
            case "Cloud Glider":
                gliderImage.setImageResource(R.drawable.cloud_glider);
                gliderImage.setTag(R.drawable.cloud_glider);
                break;
            case "Wario Wing":
                gliderImage.setImageResource(R.drawable.wario_wing);
                gliderImage.setTag(R.drawable.wario_wing);
                break;
            case "Waddle Wing":
                gliderImage.setImageResource(R.drawable.waddle_wing);
                gliderImage.setTag(R.drawable.waddle_wing);
                break;
            case "Peach Parasol":
                gliderImage.setImageResource(R.drawable.parasol);
                gliderImage.setTag(R.drawable.parasol);
                break;
            case "Parachute":
                gliderImage.setImageResource(R.drawable.parachute);
                gliderImage.setTag(R.drawable.parachute);
                break;
            case "Parafoil":
                gliderImage.setImageResource(R.drawable.parafoil);
                gliderImage.setTag(R.drawable.parafoil);
                break;
            case "Flower Glider":
                gliderImage.setImageResource(R.drawable.flower_glider);
                gliderImage.setTag(R.drawable.flower_glider);
                break;
            case "Bowser Kite":
                gliderImage.setImageResource(R.drawable.bowser_kite);
                gliderImage.setTag(R.drawable.bowser_kite);
                break;
            case "Plane Glider":
                gliderImage.setImageResource(R.drawable.plane_glider);
                gliderImage.setTag(R.drawable.plane_glider);
                break;
            case "MKTV Parafoil":
                gliderImage.setImageResource(R.drawable.mktv_parafoil);
                gliderImage.setTag(R.drawable.mktv_parafoil);
                break;
            case "Gold Glider":
                gliderImage.setImageResource(R.drawable.gold_glider);
                gliderImage.setTag(R.drawable.gold_glider);
                break;
            case "Hylian Kite":
                gliderImage.setImageResource(R.drawable.hylian_kite);
                gliderImage.setTag(R.drawable.hylian_kite);
                break;
            case "Paper Glider":
                gliderImage.setImageResource(R.drawable.paper_glider);
                gliderImage.setTag(R.drawable.paper_glider);
                break;
            case "Paraglider":
                gliderImage.setImageResource(R.drawable.paraglider);
                gliderImage.setTag(R.drawable.paraglider);
                break;
            default:
                gliderImage.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
        }

        if(playerNumber > 1) {
            ImageView gliderImage2 = findViewById(R.id.gliderImage1b);

            String randGlider2 = randGlider();
            switch (randGlider2) {
                case "Super Glider":
                    gliderImage2.setImageResource(R.drawable.super_glider);
                    gliderImage2.setTag(R.drawable.super_glider);
                    break;
                case "Cloud Glider":
                    gliderImage2.setImageResource(R.drawable.cloud_glider);
                    gliderImage2.setTag(R.drawable.cloud_glider);
                    break;
                case "Wario Wing":
                    gliderImage2.setImageResource(R.drawable.wario_wing);
                    gliderImage2.setTag(R.drawable.wario_wing);
                    break;
                case "Waddle Wing":
                    gliderImage2.setImageResource(R.drawable.waddle_wing);
                    gliderImage2.setTag(R.drawable.waddle_wing);
                    break;
                case "Peach Parasol":
                    gliderImage2.setImageResource(R.drawable.parasol);
                    gliderImage2.setTag(R.drawable.parasol);
                    break;
                case "Parachute":
                    gliderImage2.setImageResource(R.drawable.parachute);
                    gliderImage2.setTag(R.drawable.parachute);
                    break;
                case "Parafoil":
                    gliderImage2.setImageResource(R.drawable.parafoil);
                    gliderImage2.setTag(R.drawable.parafoil);
                    break;
                case "Flower Glider":
                    gliderImage2.setImageResource(R.drawable.flower_glider);
                    gliderImage2.setTag(R.drawable.flower_glider);
                    break;
                case "Bowser Kite":
                    gliderImage2.setImageResource(R.drawable.bowser_kite);
                    gliderImage2.setTag(R.drawable.bowser_kite);
                    break;
                case "Plane Glider":
                    gliderImage2.setImageResource(R.drawable.plane_glider);
                    gliderImage2.setTag(R.drawable.plane_glider);
                    break;
                case "MKTV Parafoil":
                    gliderImage2.setImageResource(R.drawable.mktv_parafoil);
                    gliderImage2.setTag(R.drawable.mktv_parafoil);
                    break;
                case "Gold Glider":
                    gliderImage2.setImageResource(R.drawable.gold_glider);
                    gliderImage2.setTag(R.drawable.gold_glider);
                    break;
                case "Hylian Kite":
                    gliderImage2.setImageResource(R.drawable.hylian_kite);
                    gliderImage2.setTag(R.drawable.hylian_kite);
                    break;
                case "Paper Glider":
                    gliderImage2.setImageResource(R.drawable.paper_glider);
                    gliderImage2.setTag(R.drawable.paper_glider);
                    break;
                case "Paraglider":
                    gliderImage2.setImageResource(R.drawable.paraglider);
                    gliderImage2.setTag(R.drawable.paraglider);
                    break;
                default:
                    gliderImage2.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
            }

            if(playerNumber > 2) {
                ImageView gliderImage3 = findViewById(R.id.gliderImage1c);

                String randGlider3 = randGlider();
                switch (randGlider3) {
                    case "Super Glider":
                        gliderImage3.setImageResource(R.drawable.super_glider);
                        gliderImage3.setTag(R.drawable.super_glider);
                        break;
                    case "Cloud Glider":
                        gliderImage3.setImageResource(R.drawable.cloud_glider);
                        gliderImage3.setTag(R.drawable.cloud_glider);
                        break;
                    case "Wario Wing":
                        gliderImage3.setImageResource(R.drawable.wario_wing);
                        gliderImage3.setTag(R.drawable.wario_wing);
                        break;
                    case "Waddle Wing":
                        gliderImage3.setImageResource(R.drawable.waddle_wing);
                        gliderImage3.setTag(R.drawable.waddle_wing);
                        break;
                    case "Peach Parasol":
                        gliderImage3.setImageResource(R.drawable.parasol);
                        gliderImage3.setTag(R.drawable.parasol);
                        break;
                    case "Parachute":
                        gliderImage3.setImageResource(R.drawable.parachute);
                        gliderImage3.setTag(R.drawable.parachute);
                        break;
                    case "Parafoil":
                        gliderImage3.setImageResource(R.drawable.parafoil);
                        gliderImage3.setTag(R.drawable.parafoil);
                        break;
                    case "Flower Glider":
                        gliderImage3.setImageResource(R.drawable.flower_glider);
                        gliderImage3.setTag(R.drawable.flower_glider);
                        break;
                    case "Bowser Kite":
                        gliderImage3.setImageResource(R.drawable.bowser_kite);
                        gliderImage3.setTag(R.drawable.bowser_kite);
                        break;
                    case "Plane Glider":
                        gliderImage3.setImageResource(R.drawable.plane_glider);
                        gliderImage3.setTag(R.drawable.plane_glider);
                        break;
                    case "MKTV Parafoil":
                        gliderImage3.setImageResource(R.drawable.mktv_parafoil);
                        gliderImage3.setTag(R.drawable.mktv_parafoil);
                        break;
                    case "Gold Glider":
                        gliderImage3.setImageResource(R.drawable.gold_glider);
                        gliderImage3.setTag(R.drawable.gold_glider);
                        break;
                    case "Hylian Kite":
                        gliderImage3.setImageResource(R.drawable.hylian_kite);
                        gliderImage3.setTag(R.drawable.hylian_kite);
                        break;
                    case "Paper Glider":
                        gliderImage3.setImageResource(R.drawable.paper_glider);
                        gliderImage3.setTag(R.drawable.paper_glider);
                        break;
                    case "Paraglider":
                        gliderImage3.setImageResource(R.drawable.paraglider);
                        gliderImage3.setTag(R.drawable.paraglider);
                        break;
                    default:
                        gliderImage3.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                }

                if(playerNumber == 4) {
                    ImageView gliderImage4 = findViewById(R.id.gliderImage1d);

                    String randGlider4 = randGlider();
                    switch (randGlider4) {
                        case "Super Glider":
                            gliderImage4.setImageResource(R.drawable.super_glider);
                            gliderImage4.setTag(R.drawable.super_glider);
                            break;
                        case "Cloud Glider":
                            gliderImage4.setImageResource(R.drawable.cloud_glider);
                            gliderImage4.setTag(R.drawable.cloud_glider);
                            break;
                        case "Wario Wing":
                            gliderImage4.setImageResource(R.drawable.wario_wing);
                            gliderImage4.setTag(R.drawable.wario_wing);
                            break;
                        case "Waddle Wing":
                            gliderImage4.setImageResource(R.drawable.waddle_wing);
                            gliderImage4.setTag(R.drawable.waddle_wing);
                            break;
                        case "Peach Parasol":
                            gliderImage4.setImageResource(R.drawable.parasol);
                            gliderImage4.setTag(R.drawable.parasol);
                            break;
                        case "Parachute":
                            gliderImage4.setImageResource(R.drawable.parachute);
                            gliderImage4.setTag(R.drawable.parachute);
                            break;
                        case "Parafoil":
                            gliderImage4.setImageResource(R.drawable.parafoil);
                            gliderImage4.setTag(R.drawable.parafoil);
                            break;
                        case "Flower Glider":
                            gliderImage4.setImageResource(R.drawable.flower_glider);
                            gliderImage4.setTag(R.drawable.flower_glider);
                            break;
                        case "Bowser Kite":
                            gliderImage4.setImageResource(R.drawable.bowser_kite);
                            gliderImage4.setTag(R.drawable.bowser_kite);
                            break;
                        case "Plane Glider":
                            gliderImage4.setImageResource(R.drawable.plane_glider);
                            gliderImage4.setTag(R.drawable.plane_glider);
                            break;
                        case "MKTV Parafoil":
                            gliderImage4.setImageResource(R.drawable.mktv_parafoil);
                            gliderImage4.setTag(R.drawable.mktv_parafoil);
                            break;
                        case "Gold Glider":
                            gliderImage4.setImageResource(R.drawable.gold_glider);
                            gliderImage4.setTag(R.drawable.gold_glider);
                            break;
                        case "Hylian Kite":
                            gliderImage4.setImageResource(R.drawable.hylian_kite);
                            gliderImage4.setTag(R.drawable.hylian_kite);
                            break;
                        case "Paper Glider":
                            gliderImage4.setImageResource(R.drawable.paper_glider);
                            gliderImage4.setTag(R.drawable.paper_glider);
                            break;
                        case "Paraglider":
                            gliderImage4.setImageResource(R.drawable.paraglider);
                            gliderImage4.setTag(R.drawable.paraglider);
                            break;
                        default:
                            gliderImage4.setImageResource(R.drawable.mario_kart_8_deluxe_mario_artwork);
                    }
                }
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
    public void charImage1a(View view) {
       TextView tv = findViewById(R.id.title);
       ImageView img = findViewById(R.id.charImage1a);
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
    public void charImage1b(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.charImage1b);
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
    public void charImage1c(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.charImage1c);
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
    public void charImage1d(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.charImage1d);
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
    public void frameImage1a(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frameImage1a);
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
    public void frameImage1b(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frameImage1b);
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
    public void frameImage1c(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frameImage1c);
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
    public void frameImage1d(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.frameImage1d);
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
    public void wheelImage1a(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheelImage1a);
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
    public void wheelImage1b(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheelImage1b);
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
    public void wheelImage1c(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheelImage1c);
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
    public void wheelImage1d(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.wheelImage1d);
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
    public void gliderImage1a(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.gliderImage1a);
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
    public void gliderImage1b(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.gliderImage1b);
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
    public void gliderImage1c(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.gliderImage1c);
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
    public void gliderImage1d(View view) {
        TextView tv = findViewById(R.id.title);
        ImageView img = findViewById(R.id.gliderImage1d);
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
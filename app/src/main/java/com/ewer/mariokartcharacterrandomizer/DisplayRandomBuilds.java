package com.ewer.mariokartcharacterrandomizer;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.text.InputFilter;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import static java.lang.String.valueOf;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayRandomBuilds extends AppCompatActivity {

    public static final String[] CHAR_LIGHT = {
            "Baby Daisy", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Rosalina", "Bowser Jr.",
            "Dry Bones", "Isabelle", "Koopa Troopa", "Lakitu", "Larry", "Lemmy", "Shy Guy", "Toad",
            "Toadette", "Wendy"};
    public static final String[] CHAR_MEDIUM = {
            "Cat Peach", "Daisy", "Iggy", "Inkling Boy", "Inkling Girl", "Ludwig", "Luigi", "Mario",
            "Peach", "Tanooki Mario", "Villager Boy", "Villager Girl", "Yoshi"};
    public static final String[] CHAR_HEAVY = {
            "Bowser", "Donkey Kong", "Dry Bowser", "King Boo", "Link", "Metal Mario", "Morton",
            "Pink Gold Peach", "Rosalina", "Roy", "Waluigi", "Wario"};
    public static final String[] CHAR_ALL = {
            "Baby Daisy", "Baby Luigi", "Baby Mario", "Baby Peach", "Baby Rosalina", "Bowser Jr.",
            "Bowser", "Cat Peach", "Daisy", "Donkey Kong", "Dry Bones", "Dry Bowser", "Iggy",
            "Inkling Boy", "Inkling Girl", "Isabelle", "King Boo", "Koopa Troopa", "Lakitu",
            "Larry", "Lemmy", "Link", "Ludwig", "Luigi", "Mario", "Metal Mario", "Morton", "Peach",
            "Pink Gold Peach", "Rosalina", "Roy", "Shy Guy", "Tanooki Mario", "Toad", "Toadette",
            "Villager Boy", "Villager Girl", "Waluigi", "Wario", "Wendy", "Yoshi"};
    public static final String[] FRAME_BIKE = {
            "City Tripper", "Comet", "Flame Rider", "Jet Bike", "Master Cycle", "Master Cycle Zero",
            "Mr. Scooty", "Sport Bike", "Standard Bike", "The Duke", "Varmint", "Yoshi Bike"};
    public static final String[] FRAME_KART = {
            "300 SL Roadster", "B Dasher", "Badwagon", "Biddybuggy", "Blue Falcon", "Bone Rattler",
            "Cat Cruiser", "Circuit Special", "GLA", "Gold Standard", "Inkstriker", "Koopa Clown",
            "Landship", "Mach 8", "P-Wing", "Pipe Frame", "Prancer", "Sneeker", "Splat Buggy",
            "Sports Coupe", "Standard ATV", "Standard Kart", "Steel Driver", "Streetle",
            "Tanooki Kart", "Teddy Buggy", "Tri-Speeder", "W 25 Silver Arrow", "Wild Wiggler"};
    public static final String[] FRAME_ALL = {
            "300 SL Roadster", "B Dasher", "Badwagon", "Biddybuggy", "Blue Falcon", "Bone Rattler",
            "Cat Cruiser", "Circuit Special", "City Tripper", "Comet", "Flame Rider", "GLA",
            "Gold Standard", "Inkstriker", "Jet Bike", "Koopa Clown", "Landship", "Mach 8",
            "Master Cycle Zero", "Master Cycle", "Mr. Scooty", "P-Wing", "Pipe Frame", "Prancer",
            "Sneeker", "Splat Buggy", "Sports Bike", "Sports Coupe", "Standard ATV",
            "Standard Bike", "Standard Kart", "Steel Driver", "Streetle", "Tanooki Kart",
            "Teddy Buggy", "The Duke", "Tri-Speeder", "Varmint", "W 25 Silver Arrow",
            "Wild Wiggler", "Yoshi Bike"};
    public static final String[] TIRES_ALL = {
            "Ancient Tires", "Button Tires", "Cushion Tires", "GLA Tires", "Gold Tires",
            "Leaf Tires", "Metal Tires", "Monster Tires", "Off-Road Tires", "Roller Tires",
            "Slick Tires", "Slim Tires", "Sponge Tires", "Standard Tires", "Triforce Tires",
            "Wood Tires"};
    public static final String[] GLIDER_ALL = {
            "Bowser Kite", "Cloud Glider", "Flower Glider", "Gold Glider", "Hylian Kite",
            "MKTV Parafoil", "Paper Glider", "Parachute", "Parafoil", "Paraglider", "Peach Parasol",
            "Plane Glider", "Super Glider", "Waddle Wing", "Wario Wing"};

    private BuildsDBHelper dbHelper;
    private SQLiteDatabase db;
    private RandomBuild[] build_arr;
    private int[] char_type_arr;
    private int[] frame_type_arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_builds);

        // retrieve the bundle containing the passed data from the previous activity, including
        // the number of players, and the arrays of character and frame preferences
        Bundle bundle = this.getIntent().getExtras();
        int player_count = bundle.getInt("player_count");
        char_type_arr = bundle.getIntArray("char_array");
        frame_type_arr = bundle.getIntArray("frame_array");

        // create the empty array of RandomBuilds
        build_arr = new RandomBuild[player_count];

        // create an SQLite DB helper to access the database of saved builds and build history
        dbHelper = new BuildsDBHelper(this);
        db = dbHelper.getWritableDatabase();

        // find the vertical LinearLayout that already exists in the XML. All of the following
        // views and layouts will be contained inside of this parent layout
        LinearLayout parent_layout = findViewById(R.id.build_layout);
        TextView title = findViewById(R.id.part_name);

        // 4 different layout parameters for the table rows, vertical wrapper containers, the
        // TextViews, and the ImageViews, respectively
        LinearLayout.LayoutParams layout_params_row = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams layout_params_wrapper = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_wrapper.bottomMargin = 40;

        LinearLayout.LayoutParams layout_params_text = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_text.topMargin = 16;
        layout_params_text.bottomMargin = 16;

        LinearLayout.LayoutParams layout_params_save = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_text.topMargin = 16;
        layout_params_text.bottomMargin = 16;

        LinearLayout.LayoutParams layout_params_image = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1);

        // the visual rounded rectangle that encases the wrapper containers
        GradientDrawable border = new GradientDrawable();
        border.setStroke(6, 0xFF000000);
        border.setCornerRadius(60);

        // creation of the layouts and images for a given number of players
        for (int i = 0; i < player_count; i++) {
            // create the container that holds the player name and images for a respective build
            LinearLayout player_wrapper = new LinearLayout(this);
            player_wrapper.setLayoutParams(layout_params_wrapper);
            player_wrapper.setOrientation(LinearLayout.VERTICAL);

            // create a TextView for displaying the player name and set common text attributes
            TextView text_view = new TextView(this);

            text_view.setLayoutParams(layout_params_text);
            text_view.setGravity(Gravity.CENTER);
            text_view.setTextSize(32f);
            text_view.setTextScaleX(1.3f);
            text_view.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));

            // set the correct player number name based on which place in the array it is
            switch (i) {
                case 0:
                    text_view.setText(R.string.player_one_caps);
                    break;
                case 1:
                    text_view.setText(R.string.player_two_caps);
                    break;
                case 2:
                    text_view.setText(R.string.player_three_caps);
                    break;
                case 3:
                    text_view.setText(R.string.player_four_caps);
            }

            // add the TextView to the parent LinearLayout
            player_wrapper.addView(text_view);

            // create the horizontal LinearLayouts
            LinearLayout player_row = new LinearLayout(this);
            player_row.setLayoutParams(layout_params_row);
            player_row.setOrientation(LinearLayout.HORIZONTAL);

            // generate a new build and add it to the build history database table
            build_arr[i] = createBuild(i);
            addHistoryBuild(build_arr[i]);

            // create, set, and display the array of build images
            ImageView[] image_arr = new ImageView[4];
            for (int j = 0; j < 4; j++) {
                image_arr[j] = new ImageView(this);
                image_arr[j].setLayoutParams(layout_params_image);

                int image = getPartImage(j, i);
                image_arr[j].setImageResource(image);
                image_arr[j].setTag(image);

                int finalJ = j;
                int finalI = i;
                image_arr[j].setOnClickListener(view -> title.setText(getPartText(finalJ, build_arr[finalI])));

                player_row.addView(image_arr[j]);
            }

            // add the set of images to the wrapper layout containing them
            player_wrapper.addView(player_row);

            TextView save_button = new TextView(this);
            save_button.setLayoutParams(layout_params_save);
            save_button.setGravity(Gravity.CENTER);
            save_button.setText(R.string.save_build);
            save_button.setTextSize(28f);
            save_button.setTextColor(getResources().getColor(R.color.forest_green));
            save_button.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));

            int finalI = i;
            save_button.setOnClickListener(view -> {
                saveOnClick(finalI);
            });

            player_wrapper.addView(save_button);
            // set border of wrapper container depending on android version
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                player_wrapper.setBackground(border);
            } else {
                player_wrapper.setBackgroundDrawable(border);
            }

            parent_layout.addView(player_wrapper);
        }
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    /**
     * The on-click action for the save buttons when builds are displayed. Creates an AlertDialog
     * for inputting a build name and saving to the proper database
     * @param build_index the index of build_arr for the build in question
     */
    private void saveOnClick(int build_index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.save_build_dialog_title);

        final EditText build_name_input = new EditText(this);
        InputFilter filter = (source, start, end, spanned, dstart, dend) -> {
            StringBuilder builder1 = new StringBuilder();
            for(int k = start; k < end; k++) {
                char c = source.charAt(k);
                if(Character.isLetterOrDigit(c))
                    builder1.append(c);
            }

            boolean allCharactersValid = builder1.length() == (end - start);
            if(allCharactersValid) {
                return null;
            } else {
                return builder1.toString();
            }
        };
        ArrayList<InputFilter> inputFilters = new ArrayList<>(Arrays.asList(build_name_input.getFilters()));
        inputFilters.add(0, filter);
        InputFilter[] filterList = inputFilters.toArray(new InputFilter[inputFilters.size()]);
        build_name_input.setFilters(filterList);

        builder.setView(build_name_input);

        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            String build_name;
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                build_name = build_name_input.getText().toString();
                if(isNameAlreadyInDatabase(build_name)) {
                    Snackbar.make(findViewById(R.id.build_layout), R.string.error_already_exists, Snackbar.LENGTH_LONG)
                            .show();
                } else {
                    addSavedBuild(build_index, build_name);
                    if(isNameAlreadyInDatabase(build_name)) {
                        Snackbar.make(findViewById(R.id.build_layout), R.string.save_success, Snackbar.LENGTH_LONG)
                                .show();
                    } else {
                        Snackbar.make(findViewById(R.id.build_layout), R.string.error_database, Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        builder.show();
    }

    /**
     * Create a full RandomBuild by randomly selecting one of each type of part
     * @return the created RandomBuild
     */
    private RandomBuild createBuild(int player_num) {
        return new RandomBuild(randChar(player_num), randFrame(player_num),
                randTires(), randGlider());
    }

    /**
     * Obtain a random character from the list of characters. If the character that was chosen has
     * multiple color palettes, choose one randomly
     *
     * @param player_num the player whose character is being chosen
     * @return the string of the character concatenated with the color pallete, if necessary
     */
    private String randChar(int player_num) {
        // create a new array that's populated with the user's choice of character weight
        String[] correct_char_array;
        switch (char_type_arr[player_num]) {
            case 1:
                correct_char_array = CHAR_LIGHT;
                break;
            case 2:
                correct_char_array = CHAR_MEDIUM;
                break;
            case 3:
                correct_char_array = CHAR_HEAVY;
                break;
            case 4:
                // using System.arraycopy to merge two arrays
                correct_char_array = new String[CHAR_LIGHT.length + CHAR_MEDIUM.length];
                System.arraycopy(CHAR_LIGHT, 0, correct_char_array, 0, CHAR_LIGHT.length);
                System.arraycopy(CHAR_MEDIUM, 0, correct_char_array,
                        CHAR_LIGHT.length, CHAR_MEDIUM.length);
                break;
            case 5:
                correct_char_array = new String[CHAR_LIGHT.length + CHAR_HEAVY.length];
                System.arraycopy(CHAR_LIGHT, 0, correct_char_array, 0, CHAR_LIGHT.length);
                System.arraycopy(CHAR_HEAVY, 0, correct_char_array,
                        CHAR_LIGHT.length, CHAR_HEAVY.length);
                break;
            case 6:
                correct_char_array = new String[CHAR_MEDIUM.length + CHAR_HEAVY.length];
                System.arraycopy(CHAR_MEDIUM, 0, correct_char_array, 0, CHAR_MEDIUM.length);
                System.arraycopy(CHAR_HEAVY, 0, correct_char_array,
                        CHAR_MEDIUM.length, CHAR_HEAVY.length);
                break;
            default:
                correct_char_array = CHAR_ALL;
        }

        String rand_char;
        // check to see if there are duplicated characters which are not allowed
        if(player_num > 0) {
            rand_char = getCharNoDuplicates(player_num, correct_char_array);
        } else {
            rand_char = correct_char_array[(int) (Math.random() * correct_char_array.length)];
        }

        // randomly choose a color palette for characters that have multiple palettes
        rand_char = setCharColorPalette(rand_char);

        return rand_char;
    }

    /**
     * Retrieves a character from the active list that hasn't already been picked for a previous
     * player's build
     * @param player_num the player whose character is being picked
     * @param char_array the list of all possible characters
     * @return a character that has not already been picked for a previous buld
     */
    private String getCharNoDuplicates(int player_num, String[] char_array) {
        String rand_char;
        boolean char_flag;
        while (true) {
            rand_char = char_array[(int) (Math.random() * char_array.length)];
            char_flag = true;

            // check previous players' characters for duplication
            for (int i = 0; i < player_num; i++) {
                if (rand_char.equals(build_arr[i].getCharacter())) {
                    char_flag = false;
                    break;
                }
            }
            if (char_flag)
                break;
        }
        return rand_char;
    }

    /**
     * Adds a color palette to the end of specific chosen characters
     * Ex. Shy Guy -> Shy Guy (Pink)
     * @param rand_char the character that is (possibly) being given a color palette
     * @return the character with or without an added color palette
     */
    private String setCharColorPalette(String rand_char) {
        int color;

        switch (rand_char) {
            case "Shy Guy":
            case "Yoshi":
                color = (int) (Math.random() * 9);
                switch (color) {
                    case 0:
                        rand_char = rand_char.concat(" (Green)");
                        break;
                    case 1:
                        rand_char = rand_char.concat(" (Red)");
                        break;
                    case 2:
                        rand_char = rand_char.concat(" (Dark Blue)");
                        break;
                    case 3:
                        rand_char = rand_char.concat(" (Light Blue)");
                        break;
                    case 4:
                        rand_char = rand_char.concat(" (Yellow)");
                        break;
                    case 5:
                        rand_char = rand_char.concat(" (Pink)");
                        break;
                    case 6:
                        rand_char = rand_char.concat(" (Black)");
                        break;
                    case 7:
                        rand_char = rand_char.concat(" (White)");
                        break;
                    case 8:
                        rand_char = rand_char.concat(" (Orange)");
                        break;
                    default:
                        rand_char = rand_char.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Metal Mario":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    rand_char = rand_char.concat(" (Metal)");
                } else {
                    rand_char = rand_char.concat(" (Gold)");
                }
                break;
            case "Link":
                color = (int) (Math.random() * 2);
                if (color == 0) {
                    rand_char = rand_char.concat(" (Classic)");
                } else {
                    rand_char = rand_char.concat(" (BOTW)");
                }
                break;
            case "Inkling Girl":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        rand_char = rand_char.concat(" (Orange)");
                        break;
                    case 1:
                        rand_char = rand_char.concat(" (Green)");
                        break;
                    case 2:
                        rand_char = rand_char.concat(" (Pink)");
                        break;
                    default:
                        rand_char = rand_char.concat(" (ERROR ERROR ERROR)");
                }
                break;
            case "Inkling Boy":
                color = (int) (Math.random() * 3);
                switch (color) {
                    case 0:
                        rand_char = rand_char.concat(" (Dark Blue)");
                        break;
                    case 1:
                        rand_char = rand_char.concat(" (Purple)");
                        break;
                    case 2:
                        rand_char = rand_char.concat(" (Light Blue)");
                        break;
                    default:
                        rand_char = rand_char.concat(" (ERROR ERROR ERROR)");
                }
                break;
            default:
        }
        return rand_char;
    }

    /**
     * Obtain a random frame from the chosen list of frames, depending on player choice
     *
     * @param player_num the player whose frame is being chosen
     * @return the string of the frame
     */
    private String randFrame(int player_num) {
        switch (frame_type_arr[player_num]) {
            case 1:
                return FRAME_BIKE[(int) (Math.random() * FRAME_BIKE.length)];
            case 2:
                return FRAME_KART[(int) (Math.random() * FRAME_KART.length)];
            default:
                return FRAME_ALL[(int) (Math.random() * FRAME_ALL.length)];
        }
    }

    /**
     * Obtain a random set of tires from the list of tires.
     * @return the string of the tires concatenated with the color pallete, if necessary
     */
    private String randTires() {
        String tires = TIRES_ALL[(int) (Math.random() * TIRES_ALL.length)];

        tires = setTiresColorPalette(tires);

        return tires;
    }

    /**
     * If the random tires have multiple color palettes, automatically choose one randomly
     * @param tires the randomly selected tires
     * @return the tires with a color palette chosen (if needed)
     */
    private String setTiresColorPalette(String tires) {
        int color;

        switch (tires) {
            // color palettes are not in the base list because that would affect the
            // randomness of getting each type of wheel, so they are added
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
        return GLIDER_ALL[((int) (Math.random() * GLIDER_ALL.length))];
    }

    /**
     * Retrieve the ID of the image that correlates to the part in the respective RandomBuild
     * @param build_part the type of build part; 0 = character, 1 = frame, 2 = tires, 3 = glider
     * @param player     the player number
     * @return the int ID of the image
     */
    private int getPartImage(int build_part, int player) {
        switch (build_part) {
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
                    case "Villager Boy":
                        return R.drawable.villager_boy;
                    case "Villager Girl":
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
     * @param build      the build whose part is getting its text retrieved
     * @return the int tag of the string version of the part name
     */
    private int getPartText(int build_part, RandomBuild build) {
        switch(build_part) {
            case 0:
                return build.getCharacterStringTag();
            case 1:
                return build.getFrameStringTag();
            case 2:
                return build.getTiresStringTag();
            case 3:
                return build.getGliderStringTag();
            default:
                return R.string.default_error;
        }
    }

    /**
     * Before adding a build to the saved build database, check to see if there is already a build
     * with that name
     * @param name the name of the build being saved
     * @return true if the name already exists, false otherwise
     */
    private boolean isNameAlreadyInDatabase(String name) {
        boolean build_name_exists = false;

        String[] projection = {
                BaseColumns._ID,
                BuildsDBContract.SavedEntry.COLUMN_BUILD_NAME};
        String selection = BuildsDBContract.SavedEntry.COLUMN_BUILD_NAME + " = ?";
        String[] selectionArgs = {name};
        String sort_order = BaseColumns._ID + " ASC";

        Cursor cursor = db.query(
                BuildsDBContract.SavedEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sort_order
        );

        if(cursor.getCount() > 0)
            build_name_exists = true;

        cursor.close();
        return build_name_exists;
    }

    /**
     * Save build to the saved table of the build database
     * @param build_index the index of the build being saved
     * @param build_name the user-inputted name of the build being saved
     */
    public void addSavedBuild(int build_index, String build_name) {
        RandomBuild build = build_arr[build_index];

        ContentValues values = new ContentValues();
        values.put(BuildsDBContract.SavedEntry.COLUMN_BUILD_NAME, build_name);
        values.put(BuildsDBContract.SavedEntry.COLUMN_BUILD_CHARACTER, build.getCharacter());
        values.put(BuildsDBContract.SavedEntry.COLUMN_BUILD_FRAME, build.getFrame());
        values.put(BuildsDBContract.SavedEntry.COLUMN_BUILD_TIRES, build.getTires());
        values.put(BuildsDBContract.SavedEntry.COLUMN_BUILD_GLIDER, build.getGlider());

        db.insert(BuildsDBContract.SavedEntry.TABLE_NAME, null, values);
    }

    /**
     * Save build to the history table of the build database
     * @param build the build being saved
     */
    private void addHistoryBuild(RandomBuild build) {
        ContentValues values = new ContentValues();
        values.put(BuildsDBContract.HistoryEntry.COLUMN_BUILD_CHARACTER, build.getCharacter());
        values.put(BuildsDBContract.HistoryEntry.COLUMN_BUILD_FRAME, build.getFrame());
        values.put(BuildsDBContract.HistoryEntry.COLUMN_BUILD_TIRES, build.getTires());
        values.put(BuildsDBContract.HistoryEntry.COLUMN_BUILD_GLIDER, build.getGlider());

        db.insert(BuildsDBContract.HistoryEntry.TABLE_NAME, null, values);
        BuildsDBHelper.setHistoryCounter(true);

        if(BuildsDBHelper.getHistoryCounter() > 60) {
            String where_clause = "_ID=?";
            String[] where_args = new String[] {valueOf(BuildsDBHelper.getDeleteIndex())};
            db.delete(BuildsDBContract.HistoryEntry.TABLE_NAME, where_clause, where_args);
            BuildsDBHelper.setHistoryCounter(false);
        }
    }
}
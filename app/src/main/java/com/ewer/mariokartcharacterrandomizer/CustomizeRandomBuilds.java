package com.ewer.mariokartcharacterrandomizer;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class CustomizeRandomBuilds extends AppCompatActivity implements OnItemSelectedListener {

    private GradientDrawable border;
    private int player_count = 0;
    private int[] char_weight_array;
    private int[] frame_type_array;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_builds);

        Spinner player_spinner = (Spinner) findViewById(R.id.spinner_player_amount);
        player_spinner.setOnItemSelectedListener(this);
        player_spinner.setTag("0");

        border = new GradientDrawable();
        border.setStroke(6, 0xFF000000);
        border.setCornerRadius(60);

        Button go_button = findViewById(R.id.go_button);
        go_button.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));
        go_button.setBackgroundColor(Color.GREEN);

        char_weight_array = new int[4];
        frame_type_array = new int[4];
    }

    /**
     * The method that controls what happens when an item is selected in one of the spinners
     *
     * @param spinner the spinner that was activated
     * @param view
     * @param spinner_index    the position of the selected item in the list of spinner options
     * @param id
     */
    public void onItemSelected(AdapterView<?> spinner, View view, int spinner_index, long id) {
        LinearLayout current_player;
        int child_index;

        switch(spinner.getTag().toString().substring(0, 1)) {
            case "0":
                playerSpinnerAction(spinner_index);
                break;
            case "1":
                current_player = (LinearLayout) spinner.getParent();
                child_index = ((LinearLayout) current_player.getParent()).indexOfChild(current_player);

                charSpinnerAction(spinner_index, child_index);
                break;
            case "2":
                current_player = (LinearLayout) spinner.getParent();
                child_index = ((LinearLayout) current_player.getParent()).indexOfChild(current_player);

                frameSpinnerAction(spinner_index, child_index);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void playerSpinnerAction(int pos) {
        int player_count_old = player_count;
        player_count = pos + 1;
        LinearLayout outer_layout = findViewById(R.id.customization_layout);

        // the layout parameters for the horizontal layout params. the width matches the parent
        // so that all 4 images can fit, and wraps the height of the images vertically
        LinearLayout.LayoutParams layout_params_player = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_player.gravity = Gravity.CENTER_HORIZONTAL;
        layout_params_player.bottomMargin = 48;

        // the layout parameters for the horizontal layout params. the width matches the parent
        // so that all 4 images can fit, and wraps the height of the images vertically
        LinearLayout.LayoutParams layout_params_text = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_text.bottomMargin = 32;

        LinearLayout.LayoutParams layout_params_spinner = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout_params_spinner.bottomMargin = 32;

        // if the new player count selected is higher than the old one, then new rows of player
        // options need to be generated. Otherwise, the player options for the players that don't
        // exist need to be removed. Ignore when the same option is selected
        if (player_count > player_count_old) {
            for (int i = player_count_old; i < player_count; i++) {
                LinearLayout new_player = new LinearLayout(this);
                new_player.setLayoutParams(layout_params_player);
                new_player.setOrientation(LinearLayout.VERTICAL);

                TextView player_title = new TextView(this);
                player_title.setLayoutParams(layout_params_text);
                player_title.setTypeface(ResourcesCompat.getFont(this, R.font.paytone_one));
                player_title.setTextSize(20f);
                player_title.setGravity(Gravity.CENTER_HORIZONTAL);

                // set the correct player number based on which place in the array it is
                switch (i) {
                    case 0:
                        player_title.setText(R.string.player_one_caps);
                        break;
                    case 1:
                        player_title.setText(R.string.player_two_caps);
                        break;
                    case 2:
                        player_title.setText(R.string.player_three_caps);
                        break;
                    case 3:
                        player_title.setText(R.string.player_four_caps);
                }
                new_player.addView(player_title);

                // create and add the spinner that determines the character weight
                Spinner char_spinner = new Spinner(this);
                char_spinner.setLayoutParams(layout_params_spinner);
                char_spinner.setTag("1" + i);
                ArrayAdapter<CharSequence> char_adapter = ArrayAdapter.createFromResource(this,
                        R.array.character_weight_array, android.R.layout.simple_spinner_item);
                char_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                char_spinner.setAdapter(char_adapter);
                char_spinner.setOnItemSelectedListener(this);

                new_player.addView(char_spinner);

                // create and add the spinner that determines the character weight
                Spinner frame_spinner = new Spinner(this);
                char_spinner.setLayoutParams(layout_params_spinner);
                frame_spinner.setTag("2" + i);
                ArrayAdapter<CharSequence> frame_adapter = ArrayAdapter.createFromResource(this,
                        R.array.frame_type_array, android.R.layout.simple_spinner_item);
                frame_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                frame_spinner.setAdapter(frame_adapter);
                frame_spinner.setOnItemSelectedListener(this);

                new_player.addView(frame_spinner);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    new_player.setBackground(border);
                }  else {
                    new_player.setBackgroundDrawable(border);
                }

                outer_layout.addView(new_player);
            }
        } else {
            for(int i = player_count_old; i > player_count; i--) {
                outer_layout.removeViewAt(i - 1);
            }
        }
    }

    private void charSpinnerAction(int spinner_index, int child_index) {
        char_weight_array[child_index] = spinner_index;
    }

    private void frameSpinnerAction(int spinner_index, int child_index) {
        frame_type_array[child_index] = spinner_index;
    }

    public void goButtonOnClickAction(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("player_count", player_count);
        bundle.putIntArray("char_array", char_weight_array);
        bundle.putIntArray("frame_array", frame_type_array);

        Intent intent = new Intent(this, DisplayRandomBuilds.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}

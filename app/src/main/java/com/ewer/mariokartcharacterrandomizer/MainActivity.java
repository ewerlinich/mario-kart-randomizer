package com.ewer.mariokartcharacterrandomizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create_button = findViewById(R.id.create_button);
        create_button.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));

        Button history_button = findViewById(R.id.history_button);
        history_button.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));

        Button saved_button = findViewById(R.id.saved_button);
        saved_button.setTypeface(ResourcesCompat.getFont(this, R.font.mario_kart_ds));
    }

    public void createButtonOnClick(View view) {
        Intent intent = new Intent(this, CustomizeRandomBuilds.class);
        startActivity(intent);
    }

    public void historyButtonOnClick(View view) {
        Intent intent = new Intent(this, DisplayHistory.class);
        startActivity(intent);
    }

    public void savedButtonOnClick(View view) {
        Intent intent = new Intent(this, DisplaySavedBuilds.class);
        startActivity(intent);
    }
}

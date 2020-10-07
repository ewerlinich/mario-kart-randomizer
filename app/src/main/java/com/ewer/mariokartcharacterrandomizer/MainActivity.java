package com.ewer.mariokartcharacterrandomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the 'Karts 1P' button */
    public void karts1(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 1);
        startActivity(intent);
    }
    /** Called when the user taps the 'Karts 2P' button */
    public void karts2(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 2);
        startActivity(intent);
    }
    /** Called when the user taps the 'Karts 3P' button */
    public void karts3(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 3);
        startActivity(intent);
    }
    /** Called when the user taps the 'Karts 4P' button */
    public void karts4(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 4);
        startActivity(intent);
    }

    /** Called when the user taps the 'All 1P' button */
    public void all1(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 1);
        startActivity(intent);
    }
    /** Called when the user taps the 'All 2P' button */
    public void all2(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 2);
        startActivity(intent);
    }
    /** Called when the user taps the 'All 3P' button */
    public void all3(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 3);
        startActivity(intent);
    }
    /** Called when the user taps the 'All 4P' button */
    public void all4(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 4);
        startActivity(intent);
    }


}
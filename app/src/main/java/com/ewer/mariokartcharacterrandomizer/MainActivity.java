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

    /** Called when the user taps the 'No Bikes 1P' button */
    public void noBikes(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 1);
        startActivity(intent);
    }
    /** Called when the user taps the 'No Bikes 2P' button */
    public void noBikes2(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 2);
        startActivity(intent);
    }
    /** Called when the user taps the 'No Bikes 3P' button */
    public void noBikes3(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 3);
        startActivity(intent);
    }
    /** Called when the user taps the 'No Bikes 4P' button */
    public void noBikes4(View view) {
        Intent intent = new Intent(this, DisplayRandomKarts.class);
        intent.putExtra("PlayerNumber", 4);
        startActivity(intent);
    }

    /** Called when the user taps the 'With Bikes 1P' button */
    public void withBikes(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 1);
        startActivity(intent);
    }
    /** Called when the user taps the 'With Bikes 2P' button */
    public void withBikes2(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 2);
        startActivity(intent);
    }
    /** Called when the user taps the 'With Bikes 3P' button */
    public void withBikes3(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 3);
        startActivity(intent);
    }
    /** Called when the user taps the 'With Bikes 4P' button */
    public void withBikes4(View view) {
        Intent intent = new Intent(this, DisplayRandomAll.class);
        intent.putExtra("PlayerNumber", 4);
        startActivity(intent);
    }


}

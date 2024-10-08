package com.cst2335.vani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN_ACTIVITY";
    private static final String PREFS_NAME = "MyPrefsFile";
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);

        // Load SharedPreferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String savedEmail = settings.getString("email", "");
        emailEditText.setText(savedEmail);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save email to SharedPreferences when paused
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("email", emailEditText.getText().toString());
        editor.apply();
    }
}

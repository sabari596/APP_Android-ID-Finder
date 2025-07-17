package com.example.androididfinder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView androidIdTextView;
    private Button copyButton;
    private String androidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get views
        androidIdTextView = findViewById(R.id.android_id_textview);
        copyButton = findViewById(R.id.copy_button);

        // Get Android ID
        androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        // Set Android ID to TextView
        androidIdTextView.setText("ANDROID_ID: " + androidId);

        // Optional: Log and Toast
        Toast.makeText(this, "ANDROID_ID: " + androidId, Toast.LENGTH_LONG).show();
        Log.d("MY_ANDROID_ID", "ANDROID_ID: " + androidId);

        // Copy to clipboard on button click
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("ANDROID_ID", androidId);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

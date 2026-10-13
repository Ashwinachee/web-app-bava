package com.example.placementpreparationapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JavaActivity extends AppCompatActivity {

    private CheckBox[] topics;
    private TextView javaProgressText;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        javaProgressText = findViewById(R.id.javaProgressText);
        preferences = getSharedPreferences("JavaProgress", MODE_PRIVATE);

        // Initialize CheckBoxes using an array for cleaner processing
        topics = new CheckBox[]{
                findViewById(R.id.topic1),
                findViewById(R.id.topic2),
                findViewById(R.id.topic3),
                findViewById(R.id.topic4),
                findViewById(R.id.topic5),
                findViewById(R.id.topic6),
                findViewById(R.id.topic7)
        };

        // Load saved status and set listeners
        for (int i = 0; i < topics.length; i++) {
            String key = "topic" + (i + 1);
            topics[i].setChecked(preferences.getBoolean(key, false));
            topics[i].setOnCheckedChangeListener((buttonView, isChecked) -> updateProgress());
        }

        // Display initial progress
        updateProgress();
    }

    private void updateProgress() {
        int completed = 0;
        SharedPreferences.Editor editor = preferences.edit();

        for (int i = 0; i < topics.length; i++) {
            boolean isChecked = topics[i].isChecked();
            if (isChecked) {
                completed++;
            }
            editor.putBoolean("topic" + (i + 1), isChecked);
        }
        editor.apply();

        // Calculate percentage
        int progress = (completed * 100) / topics.length;

        // Display progress using string resource
        javaProgressText.setText(getString(R.string.progress_percentage, progress));
    }
}

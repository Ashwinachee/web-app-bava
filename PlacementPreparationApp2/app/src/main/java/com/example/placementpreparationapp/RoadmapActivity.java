package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoadmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_roadmap);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize and setup navigation
        setupNavigation(R.id.javaButton, JavaActivity.class);
        setupNavigation(R.id.dsaButton, DSAActivity.class);
        setupNavigation(R.id.aptitudeButton, AptitudeActivity.class);
        setupNavigation(R.id.dbmsButton, DBMSActivity.class);
        setupNavigation(R.id.cnButton, CNActivity.class);
        setupNavigation(R.id.sqlButton, SQLActivity.class);
        setupNavigation(R.id.hrButton, HRActivity.class);

        // Buttons for features coming soon
        findViewById(R.id.osButton).setOnClickListener(v -> showToast(getString(R.string.os_roadmap_coming_soon)));
    }

    private void setupNavigation(int buttonId, Class<?> targetActivity) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v -> startActivity(new Intent(this, targetActivity)));
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

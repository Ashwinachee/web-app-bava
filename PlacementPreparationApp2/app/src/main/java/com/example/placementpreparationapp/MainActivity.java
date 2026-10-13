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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Edge to Edge
        EdgeToEdge.enable(this);

        // Connect Java file with XML layout
        setContentView(R.layout.activity_main);

        // Handle system bar padding
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );


        // ==============================
        // Initialize Buttons
        // ==============================

        Button roadmapButton =
                findViewById(R.id.roadmapButton);

        Button codingButton =
                findViewById(R.id.codingButton);

        Button notesButton =
                findViewById(R.id.notesButton);

        Button resumeButton =
                findViewById(R.id.resumeButton);

        Button progressButton =
                findViewById(R.id.progressButton);

        Button profileButton =
                findViewById(R.id.profileButton);


        // ==============================
        // Placement Roadmap
        // ==============================

        roadmapButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    RoadmapActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // Coding Practice
        // ==============================

        codingButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    CodingActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // Study Notes
        // ==============================

        notesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    NotesActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // Resume Builder
        // ==============================

        resumeButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ResumeActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // My Progress
        // ==============================

        progressButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ProgressActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // Profile
        // ==============================

        profileButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);

        });

    }


    // ==============================
    // Show Toast Message
    // ==============================

    private void showToast(String message) {

        Toast.makeText(
                MainActivity.this,
                message,
                Toast.LENGTH_SHORT
        ).show();

    }

}
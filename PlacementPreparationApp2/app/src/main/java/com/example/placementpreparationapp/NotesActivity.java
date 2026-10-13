package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_notes);


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

        Button javaNotesButton =
                findViewById(R.id.javaNotesButton);

        Button dsaNotesButton =
                findViewById(R.id.dsaNotesButton);

        Button aptitudeNotesButton =
                findViewById(R.id.aptitudeNotesButton);

        Button dbmsNotesButton =
                findViewById(R.id.dbmsNotesButton);

        Button osNotesButton =
                findViewById(R.id.osNotesButton);

        Button sqlNotesButton =
                findViewById(R.id.sqlNotesButton);

        Button cnNotesButton =
                findViewById(R.id.cnNotesButton);

        Button hrNotesButton =
                findViewById(R.id.hrNotesButton);


        // ==============================
        // Java Notes
        // ==============================

        javaNotesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotesActivity.this,
                    JavaNotesActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // DSA Notes
        // ==============================

        dsaNotesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotesActivity.this,
                    DSANotesActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // Aptitude Notes
        // ==============================

        aptitudeNotesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotesActivity.this,
                    AptitudeNotesActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // DBMS Notes
        // ==============================

        dbmsNotesButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    NotesActivity.this,
                    DBMSNotesActivity.class
            );

            startActivity(intent);

        });


        // ==============================
        // OS Notes
        // ==============================

        if (osNotesButton != null) {
            osNotesButton.setOnClickListener(v -> {
                Intent intent = new Intent(NotesActivity.this, OSActivity.class);
                startActivity(intent);
            });
        }


        // ==============================
        // SQL Notes
        // ==============================

        if (sqlNotesButton != null) {
            sqlNotesButton.setOnClickListener(v -> {
                Intent intent = new Intent(NotesActivity.this, SQLActivity.class);
                startActivity(intent);
            });
        }


        // ==============================
        // Computer Networks Notes
        // ==============================

        if (cnNotesButton != null) {
            cnNotesButton.setOnClickListener(v -> {
                Intent intent = new Intent(NotesActivity.this, CNActivity.class);
                startActivity(intent);
            });
        }


        // ==============================
        // HR Interview Notes
        // ==============================

        if (hrNotesButton != null) {
            hrNotesButton.setOnClickListener(v -> {
                Intent intent = new Intent(NotesActivity.this, HRActivity.class);
                startActivity(intent);
            });
        }

    }

}
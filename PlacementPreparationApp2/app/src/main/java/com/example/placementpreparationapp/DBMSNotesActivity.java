package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DBMSNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbms_notes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons using a helper for cleaner navigation
        setupTopicButton(R.id.dbmsBasicsNotesButton, "DBMS Basics");
        setupTopicButton(R.id.erModelNotesButton, "ER Model");
        setupTopicButton(R.id.keysNotesButton, "Keys");
        setupTopicButton(R.id.normalizationNotesButton, "Normalization");
        setupTopicButton(R.id.transactionsNotesButton, "Transactions");
        setupTopicButton(R.id.acidNotesButton, "ACID Properties");
        setupTopicButton(R.id.indexingNotesButton, "Indexing");
        setupTopicButton(R.id.sqlNotesButton, "SQL");
        setupTopicButton(R.id.joinsNotesButton, "SQL Joins");
    }

    private void setupTopicButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v -> {
                ResourcesHelper.launch(DBMSNotesActivity.this, "DBMS", topicName);
            });
        }
    }
}

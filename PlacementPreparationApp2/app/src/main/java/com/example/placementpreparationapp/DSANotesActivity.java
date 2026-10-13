package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DSANotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dsa_notes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize and setup buttons
        setupTopicButton(R.id.arraysNotesButton, "Arrays");
        setupTopicButton(R.id.stringsNotesButton, "Strings");
        setupTopicButton(R.id.linkedListNotesButton, "Linked List");
        setupTopicButton(R.id.stackNotesButton, "Stack");
        setupTopicButton(R.id.queueNotesButton, "Queue");
        setupTopicButton(R.id.hashingNotesButton, "Hashing");
        setupTopicButton(R.id.recursionNotesButton, "Recursion");
        setupTopicButton(R.id.binarySearchNotesButton, "Binary Search");
        setupTopicButton(R.id.treesNotesButton, "Trees");
        setupTopicButton(R.id.graphsNotesButton, "Graphs");
        setupTopicButton(R.id.dpNotesButton, "Dynamic Programming");
    }

    private void setupTopicButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v -> {
                ResourcesHelper.launch(DSANotesActivity.this, "DSA", topicName);
            });
        }
    }
}

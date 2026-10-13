package com.example.placementpreparationapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DSAActivity extends AppCompatActivity {

    private CheckBox[] topics;
    private TextView dsaProgressText;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_dsa);


        // Handle system bar padding

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
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


        // Initialize Progress Text

        dsaProgressText =
                findViewById(R.id.dsaProgressText);


        // Initialize SharedPreferences

        preferences =
                getSharedPreferences(
                        "DSAProgress",
                        MODE_PRIVATE
                );


        // Initialize CheckBoxes

        topics = new CheckBox[]{

                findViewById(R.id.arraysCheckBox),

                findViewById(R.id.stringsCheckBox),

                findViewById(R.id.linkedListCheckBox),

                findViewById(R.id.stackCheckBox),

                findViewById(R.id.queueCheckBox),

                findViewById(R.id.hashingCheckBox),

                findViewById(R.id.recursionCheckBox),

                findViewById(R.id.binarySearchCheckBox),

                findViewById(R.id.treesCheckBox),

                findViewById(R.id.graphsCheckBox),

                findViewById(R.id.dpCheckBox)

        };


        // Load previously saved status

        for (int i = 0; i < topics.length; i++) {

            String key =
                    "topic" + (i + 1);

            topics[i].setChecked(
                    preferences.getBoolean(
                            key,
                            false
                    )
            );


            topics[i].setOnCheckedChangeListener(
                    (buttonView, isChecked) ->
                            updateProgress()
            );

        }


        // ==============================
        // DSA Topic Buttons
        // ==============================

        setupButton(
                R.id.arraysButton,
                "Arrays"
        );

        setupButton(
                R.id.stringsButton,
                "Strings"
        );

        setupButton(
                R.id.linkedListButton,
                "Linked List"
        );

        setupButton(
                R.id.stackButton,
                "Stack"
        );

        setupButton(
                R.id.queueButton,
                "Queue"
        );

        setupButton(
                R.id.hashingButton,
                "Hashing"
        );

        setupButton(
                R.id.recursionButton,
                "Recursion"
        );

        setupButton(
                R.id.binarySearchButton,
                "Binary Search"
        );

        setupButton(
                R.id.treesButton,
                "Trees"
        );

        setupButton(
                R.id.graphsButton,
                "Graphs"
        );

        setupButton(
                R.id.dpButton,
                "Dynamic Programming"
        );


        // Display initial progress

        updateProgress();

    }


    // ==============================
    // Setup Topic Button
    // ==============================

    private void setupButton(
            int buttonId,
            String topicName
    ) {

        Button button =
                findViewById(buttonId);


        button.setOnClickListener(v ->

                Toast.makeText(
                        DSAActivity.this,
                        topicName + " - Coming Soon!",
                        Toast.LENGTH_SHORT
                ).show()

        );

    }


    // ==============================
    // Update DSA Progress
    // ==============================

    private void updateProgress() {

        int completed = 0;


        SharedPreferences.Editor editor =
                preferences.edit();


        for (int i = 0; i < topics.length; i++) {

            boolean isChecked =
                    topics[i].isChecked();


            if (isChecked) {

                completed++;

            }


            editor.putBoolean(
                    "topic" + (i + 1),
                    isChecked
            );

        }


        // Save completed topic status

        editor.apply();


        // Calculate percentage

        int progress =
                (completed * 100)
                        / topics.length;


        // Display progress

        dsaProgressText.setText(
                "DSA Progress: "
                        + progress
                        + "%"
        );

    }

}
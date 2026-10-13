package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AptitudeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aptitude);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons using a helper for cleaner code
        setupButton(R.id.quantitativeButton, getString(R.string.quantitative_aptitude));
        setupButton(R.id.logicalButton, getString(R.string.logical_reasoning));
        setupButton(R.id.verbalButton, getString(R.string.verbal_ability));
        setupButton(R.id.numberSystemButton, getString(R.string.number_system));
        setupButton(R.id.percentageButton, getString(R.string.percentages));
        setupButton(R.id.profitLossButton, getString(R.string.profit_loss));
        setupButton(R.id.timeWorkButton, getString(R.string.time_work));
        setupButton(R.id.timeSpeedButton, getString(R.string.time_speed_distance));
        setupButton(R.id.ratioButton, getString(R.string.ratio_proportion));
        setupButton(R.id.probabilityButton, getString(R.string.probability));
        setupButton(R.id.permutationButton, getString(R.string.permutation_combination));
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> 
                Toast.makeText(this, getString(R.string.topic_coming_soon_format, topicName), Toast.LENGTH_SHORT).show()
        );
    }
}

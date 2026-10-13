package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DBMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbms);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons
        setupButton(R.id.dbmsBasicsButton, getString(R.string.dbms_basics));
        setupButton(R.id.erModelButton, getString(R.string.er_model));
        setupButton(R.id.normalizationButton, getString(R.string.normalization));
        setupButton(R.id.keysButton, getString(R.string.keys));
        setupButton(R.id.transactionsButton, getString(R.string.transactions));
        setupButton(R.id.acidButton, getString(R.string.acid_properties));
        setupButton(R.id.indexingButton, getString(R.string.indexing));
        setupButton(R.id.sqlButton, getString(R.string.sql));
        setupButton(R.id.joinsButton, getString(R.string.sql_joins));
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> 
                Toast.makeText(this, getString(R.string.topic_coming_soon_format, topicName), Toast.LENGTH_SHORT).show()
        );
    }
}

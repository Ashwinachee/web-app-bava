package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sql);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons – open notes with external resources
        setupButton(R.id.sqlBasicsButton,   getString(R.string.sql_basics));
        setupButton(R.id.selectButton,      getString(R.string.select_queries));
        setupButton(R.id.whereButton,       getString(R.string.where_conditions));
        setupButton(R.id.aggregateButton,   getString(R.string.aggregate_functions));
        setupButton(R.id.groupByButton,     getString(R.string.group_by_having));
        setupButton(R.id.orderByButton,     getString(R.string.order_by));
        setupButton(R.id.joinsSqlButton,    getString(R.string.sql_joins));
        setupButton(R.id.subqueryButton,    getString(R.string.subqueries));
        setupButton(R.id.sqlInterviewButton, getString(R.string.sql_interview_questions));
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v ->
                ResourcesHelper.launch(this, "SQL", topicName)
            );
        }
    }
}

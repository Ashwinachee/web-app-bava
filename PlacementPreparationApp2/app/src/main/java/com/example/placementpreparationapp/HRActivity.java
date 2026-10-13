package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hr);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons – open notes with external resources
        setupButton(R.id.introButton,       getString(R.string.hr_intro));
        setupButton(R.id.strengthButton,    getString(R.string.hr_strengths));
        setupButton(R.id.whyCompanyButton,  getString(R.string.hr_why_hire));
        setupButton(R.id.whyCompanyButton2, getString(R.string.hr_why_company));
        setupButton(R.id.goalButton,        getString(R.string.hr_goals));
        setupButton(R.id.teamworkButton,    getString(R.string.hr_teamwork));
        setupButton(R.id.conflictButton,    getString(R.string.hr_conflict));
        setupButton(R.id.questionsButton,   getString(R.string.hr_ask_interviewer));
        setupButton(R.id.mockButton,        getString(R.string.hr_mock));
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v ->
                ResourcesHelper.launch(this, "HR", topicName)
            );
        }
    }
}

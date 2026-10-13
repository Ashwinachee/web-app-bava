package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumePreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resume_preview);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TextViews
        TextView previewName          = findViewById(R.id.previewName);
        TextView previewContact       = findViewById(R.id.previewContact);
        TextView previewEducation     = findViewById(R.id.previewEducation);
        TextView previewSkills        = findViewById(R.id.previewSkills);
        TextView previewProjects      = findViewById(R.id.previewProjects);
        TextView previewCertifications = findViewById(R.id.previewCertifications);
        Button   atsCheckerButton     = findViewById(R.id.atsCheckerButton);

        // Get data from Intent
        String name           = getIntent().getStringExtra("name");
        String email          = getIntent().getStringExtra("email");
        String phone          = getIntent().getStringExtra("phone");
        String education      = getIntent().getStringExtra("education");
        String skills         = getIntent().getStringExtra("skills");
        String projects       = getIntent().getStringExtra("projects");
        String certifications = getIntent().getStringExtra("certifications");

        // Display data
        previewName.setText(name);
        previewContact.setText(String.format("%s | %s", email, phone));
        previewEducation.setText(education);
        previewSkills.setText(skills);
        previewProjects.setText(projects);
        previewCertifications.setText(certifications);

        // ATS Checker button
        atsCheckerButton.setOnClickListener(v -> {
            // Build combined resume text for ATS analysis
            String resumeText =
                    (name != null ? name + " " : "") +
                    (email != null ? email + " " : "") +
                    (education != null ? education + " " : "") +
                    (skills != null ? skills + " " : "") +
                    (projects != null ? projects + " " : "") +
                    (certifications != null ? certifications : "");

            Intent intent = new Intent(ResumePreviewActivity.this, ATSCheckerActivity.class);
            intent.putExtra("resumeContent", resumeText.trim());
            startActivity(intent);
        });
    }
}
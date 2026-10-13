package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resume);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize EditTexts
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText phoneEditText = findViewById(R.id.phoneEditText);
        EditText educationEditText = findViewById(R.id.educationEditText);
        EditText skillsEditText = findViewById(R.id.skillsEditText);
        EditText projectsEditText = findViewById(R.id.projectsEditText);
        EditText certificationsEditText = findViewById(R.id.certificationsEditText);

        // Auto-fill from UserProfile if available
        android.content.SharedPreferences userPrefs = getSharedPreferences("UserProfile", MODE_PRIVATE);
        String savedName  = userPrefs.getString("name", "");
        String savedEmail = userPrefs.getString("email", "");
        String savedPhone = userPrefs.getString("phone", "");
        if (!savedName.isEmpty())  nameEditText.setText(savedName);
        if (!savedEmail.isEmpty()) emailEditText.setText(savedEmail);
        if (!savedPhone.isEmpty()) phoneEditText.setText(savedPhone);

        // Initialize Buttons
        Button generateResumeButton = findViewById(R.id.generateResumeButton);
        Button atsDirectButton     = findViewById(R.id.atsDirectButton);

        // Generate Resume Button
        generateResumeButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String education = educationEditText.getText().toString().trim();
            String skills = skillsEditText.getText().toString().trim();
            String projects = projectsEditText.getText().toString().trim();
            String certifications = certificationsEditText.getText().toString().trim();

            // Validate required fields
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(ResumeActivity.this, getString(R.string.fill_required_fields), Toast.LENGTH_SHORT).show();
                return;
            }

            // Create Intent to open ResumePreviewActivity
            Intent intent = new Intent(ResumeActivity.this, ResumePreviewActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("education", education);
            intent.putExtra("skills", skills);
            intent.putExtra("projects", projects);
            intent.putExtra("certifications", certifications);

            startActivity(intent);
        });

        // Direct ATS Checker Button
        if (atsDirectButton != null) {
            atsDirectButton.setOnClickListener(v -> {
                String resumeText =
                        nameEditText.getText().toString().trim() + " " +
                        emailEditText.getText().toString().trim() + " " +
                        skillsEditText.getText().toString().trim() + " " +
                        educationEditText.getText().toString().trim() + " " +
                        projectsEditText.getText().toString().trim();

                Intent intent = new Intent(ResumeActivity.this, ATSCheckerActivity.class);
                intent.putExtra("resumeContent", resumeText.trim());
                startActivity(intent);
            });
        }
    }
}
package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ATSCheckerActivity extends AppCompatActivity {

    // Common ATS keywords by category
    private static final String[] TECH_SKILLS = {
            "java", "python", "c++", "javascript", "html", "css", "sql", "kotlin",
            "android", "react", "node", "spring", "git", "linux", "docker",
            "aws", "rest", "api", "xml", "json", "mysql", "mongodb", "postgresql",
            "data structures", "algorithms", "machine learning", "ai", "cloud",
            "agile", "scrum", "oop", "design patterns"
    };

    private static final String[] SOFT_SKILLS = {
            "communication", "teamwork", "leadership", "problem-solving", "analytical",
            "time management", "adaptability", "critical thinking", "creativity",
            "collaboration", "initiative", "attention to detail", "organized"
    };

    private EditText jobDescEditText;
    private EditText resumeContentEditText;
    private Button checkAtsButton;
    private ProgressBar atsProgressBar;
    private TextView atsScoreText;
    private TextView atsResultText;
    private TextView matchedKeywordsText;
    private TextView missingKeywordsText;
    private TextView atsTipsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ats_checker);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        jobDescEditText      = findViewById(R.id.jobDescEditText);
        resumeContentEditText = findViewById(R.id.resumeContentEditText);
        checkAtsButton       = findViewById(R.id.checkAtsButton);
        atsProgressBar       = findViewById(R.id.atsProgressBar);
        atsScoreText         = findViewById(R.id.atsScoreText);
        atsResultText        = findViewById(R.id.atsResultText);
        matchedKeywordsText  = findViewById(R.id.matchedKeywordsText);
        missingKeywordsText  = findViewById(R.id.missingKeywordsText);
        atsTipsText          = findViewById(R.id.atsTipsText);

        checkAtsButton.setOnClickListener(v -> runATSCheck());
    }

    // =========================================
    // Run ATS Check
    // =========================================

    private void runATSCheck() {
        String jobDesc  = jobDescEditText.getText().toString().trim().toLowerCase(Locale.ROOT);
        String resume   = resumeContentEditText.getText().toString().trim().toLowerCase(Locale.ROOT);

        if (jobDesc.isEmpty() || resume.isEmpty()) {
            Toast.makeText(this, "Please enter both Job Description and Resume content", Toast.LENGTH_SHORT).show();
            return;
        }

        // Extract keywords from job description
        List<String> jobKeywords = extractKeywords(jobDesc);

        // Find matched and missing keywords
        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        for (String keyword : jobKeywords) {
            if (resume.contains(keyword)) {
                matched.add(keyword);
            } else {
                missing.add(keyword);
            }
        }

        // Calculate score
        int score;
        if (jobKeywords.isEmpty()) {
            score = 0;
        } else {
            score = (matched.size() * 100) / jobKeywords.size();
        }

        // Display results
        displayResults(score, matched, missing, resume);
    }

    // =========================================
    // Extract Keywords from Job Description
    // =========================================

    private List<String> extractKeywords(String jobDesc) {
        List<String> keywords = new ArrayList<>();

        // Check all known tech skills
        for (String skill : TECH_SKILLS) {
            if (jobDesc.contains(skill)) {
                keywords.add(skill);
            }
        }

        // Check soft skills
        for (String skill : SOFT_SKILLS) {
            if (jobDesc.contains(skill)) {
                keywords.add(skill);
            }
        }

        // Extract common action verbs from JD
        String[] actionWords = {"developed", "designed", "implemented", "built", "managed",
                "led", "created", "analyzed", "optimized", "tested", "deployed",
                "maintained", "automated", "integrated", "collaborated"};
        for (String word : actionWords) {
            if (jobDesc.contains(word)) {
                keywords.add(word);
            }
        }

        return keywords;
    }

    // =========================================
    // Display Results
    // =========================================

    private void displayResults(int score, List<String> matched, List<String> missing, String resume) {
        // Update progress bar
        atsProgressBar.setProgress(score);

        // Score text
        atsScoreText.setText("ATS Score: " + score + "%");

        // Result label
        String resultLabel;
        int resultColor;
        if (score >= 80) {
            resultLabel = "✅ Excellent! Your resume is highly ATS-friendly.";
            resultColor = 0xFF00C9A7;
        } else if (score >= 60) {
            resultLabel = "🟡 Good. A few improvements can boost your score.";
            resultColor = 0xFFFFD700;
        } else if (score >= 40) {
            resultLabel = "🟠 Moderate. Add more relevant keywords from the JD.";
            resultColor = 0xFFFF8C00;
        } else {
            resultLabel = "🔴 Low Score. Significant keyword gaps found.";
            resultColor = 0xFFFF6B6B;
        }
        atsResultText.setText(resultLabel);
        atsResultText.setTextColor(resultColor);

        // Matched keywords
        if (matched.isEmpty()) {
            matchedKeywordsText.setText("✅ Matched Keywords:\nNone found");
        } else {
            matchedKeywordsText.setText("✅ Matched Keywords (" + matched.size() + "):\n" +
                    formatList(matched));
        }

        // Missing keywords
        if (missing.isEmpty()) {
            missingKeywordsText.setText("❌ Missing Keywords:\nNone — Perfect match!");
        } else {
            missingKeywordsText.setText("❌ Missing Keywords (" + missing.size() + "):\n" +
                    formatList(missing));
        }

        // ATS Tips
        StringBuilder tips = new StringBuilder("💡 ATS Improvement Tips:\n\n");
        tips.append("• Use keywords exactly as they appear in the job description\n");
        tips.append("• Avoid tables, images and fancy formatting in ATS submissions\n");
        tips.append("• Add a Skills section with all relevant technologies\n");
        tips.append("• Use standard section headings (Experience, Education, Skills)\n");
        tips.append("• Quantify achievements with numbers (e.g. '50% improvement')\n");

        // Check for action words
        boolean hasActionWords = resume.contains("developed") || resume.contains("implemented")
                || resume.contains("built") || resume.contains("designed");
        if (!hasActionWords) {
            tips.append("• Start bullet points with strong action verbs\n");
        }

        // Check resume length
        String[] resumeWords = resume.split("\\s+");
        if (resumeWords.length < 200) {
            tips.append("• Your resume seems short — add more project details and descriptions\n");
        } else if (resumeWords.length > 800) {
            tips.append("• Your resume may be too long — aim for 1 page (300–600 words)\n");
        }

        atsTipsText.setText(tips.toString());
    }

    // =========================================
    // Format list to bullet string
    // =========================================

    private String formatList(List<String> items) {
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append("• ").append(item).append("\n");
        }
        return sb.toString().trim();
    }
}

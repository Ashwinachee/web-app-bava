package com.example.placementpreparationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CodingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coding);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button leetcodeButton = findViewById(R.id.leetcodeButton);
        Button hackerrankButton = findViewById(R.id.hackerrankButton);
        Button codechefButton = findViewById(R.id.codechefButton);
        Button codeforcesButton = findViewById(R.id.codeforcesButton);
        Button gfgButton = findViewById(R.id.gfgButton);

        leetcodeButton.setOnClickListener(v -> openWebsite("https://leetcode.com"));
        hackerrankButton.setOnClickListener(v -> openWebsite("https://www.hackerrank.com"));
        codechefButton.setOnClickListener(v -> openWebsite("https://www.codechef.com"));
        codeforcesButton.setOnClickListener(v -> openWebsite("https://codeforces.com"));
        gfgButton.setOnClickListener(v -> openWebsite("https://www.geeksforgeeks.org"));
    }

    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

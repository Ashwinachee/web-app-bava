package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_os);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons – open notes with external resources
        setupButton(R.id.processButton,       "Process Management");
        setupButton(R.id.threadsButton,       "Threads");
        setupButton(R.id.memoryButton,        "Memory Management");
        setupButton(R.id.deadlockButton,      "Deadlock");
        setupButton(R.id.cpuSchedulingButton, "CPU Scheduling");
        setupButton(R.id.fileSystemButton,    "File Systems");
        setupButton(R.id.pagingButton,        "Paging & Segmentation");
        setupButton(R.id.syncButton,          "Synchronization");
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v ->
                ResourcesHelper.launch(this, "OS", topicName)
            );
        }
    }
}

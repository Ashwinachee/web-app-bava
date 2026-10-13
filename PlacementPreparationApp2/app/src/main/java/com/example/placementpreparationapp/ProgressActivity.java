package com.example.placementpreparationapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar overallProgressBar;
    private TextView overallProgressText;

    private SeekBar[] seekBars;

    private final String[] prefKeys = {
            "java",
            "dsa",
            "aptitude",
            "dbms",
            "os",
            "cn",
            "sql",
            "hr"
    };

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_progress);


        // System bar padding

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


        // Initialize overall progress

        overallProgressBar =
                findViewById(R.id.overallProgressBar);

        overallProgressText =
                findViewById(R.id.overallProgressText);


        // ProgressData

        preferences =
                getSharedPreferences(
                        "ProgressData",
                        MODE_PRIVATE
                );


        // Initialize SeekBars

        seekBars = new SeekBar[]{

                findViewById(R.id.javaProgressBar),

                findViewById(R.id.dsaProgressBar),

                findViewById(R.id.aptitudeProgressBar),

                findViewById(R.id.dbmsProgressBar),

                findViewById(R.id.osProgressBar),

                findViewById(R.id.cnProgressBar),

                findViewById(R.id.sqlProgressBar),

                findViewById(R.id.hrProgressBar)

        };


        // Load Java and DSA progress

        loadJavaProgress();

        loadDSAProgress();


        // Load other subject progress

        loadOtherProgress();


        // Save button

        findViewById(
                R.id.saveProgressButton
        ).setOnClickListener(v -> {

            saveProgress();

            Toast.makeText(
                    ProgressActivity.this,
                    "Progress Saved Successfully!",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Calculate overall progress

        calculateOverallProgress();

    }


    // =========================================
    // Load Java Progress
    // =========================================

    private void loadJavaProgress() {

        SharedPreferences javaPreferences =
                getSharedPreferences(
                        "JavaProgress",
                        MODE_PRIVATE
                );


        int completedTopics = 0;

        int totalTopics = 7;


        for (int i = 1; i <= totalTopics; i++) {

            boolean completed =
                    javaPreferences.getBoolean(
                            "topic" + i,
                            false
                    );


            if (completed) {

                completedTopics++;

            }

        }


        int javaProgress =
                (completedTopics * 100)
                        / totalTopics;


        seekBars[0].setProgress(
                javaProgress
        );

    }


    // =========================================
    // Load DSA Progress
    // =========================================

    private void loadDSAProgress() {

        SharedPreferences dsaPreferences =
                getSharedPreferences(
                        "DSAProgress",
                        MODE_PRIVATE
                );


        int completedTopics = 0;

        int totalTopics = 11;


        for (int i = 1; i <= totalTopics; i++) {

            boolean completed =
                    dsaPreferences.getBoolean(
                            "topic" + i,
                            false
                    );


            if (completed) {

                completedTopics++;

            }

        }


        int dsaProgress =
                (completedTopics * 100)
                        / totalTopics;


        seekBars[1].setProgress(
                dsaProgress
        );

    }


    // =========================================
    // Load Other Subjects
    // =========================================

    private void loadOtherProgress() {

        seekBars[2].setProgress(
                preferences.getInt(
                        "aptitude",
                        0
                )
        );


        seekBars[3].setProgress(
                preferences.getInt(
                        "dbms",
                        0
                )
        );


        seekBars[4].setProgress(
                preferences.getInt(
                        "os",
                        0
                )
        );


        seekBars[5].setProgress(
                preferences.getInt(
                        "cn",
                        0
                )
        );


        seekBars[6].setProgress(
                preferences.getInt(
                        "sql",
                        0
                )
        );


        seekBars[7].setProgress(
                preferences.getInt(
                        "hr",
                        0
                )
        );

    }


    // =========================================
    // Calculate Overall Progress
    // =========================================

    private void calculateOverallProgress() {

        int total = 0;


        for (SeekBar seekBar : seekBars) {

            total += seekBar.getProgress();

        }


        int overall =
                total / seekBars.length;


        overallProgressBar.setProgress(
                overall
        );


        overallProgressText.setText(
                "Overall Progress: "
                        + overall
                        + "%"
        );

    }


    // =========================================
    // Save Other Subject Progress
    // =========================================

    private void saveProgress() {

        SharedPreferences.Editor editor =
                preferences.edit();


        // Save Aptitude

        editor.putInt(
                "aptitude",
                seekBars[2].getProgress()
        );


        // Save DBMS

        editor.putInt(
                "dbms",
                seekBars[3].getProgress()
        );


        // Save OS

        editor.putInt(
                "os",
                seekBars[4].getProgress()
        );


        // Save CN

        editor.putInt(
                "cn",
                seekBars[5].getProgress()
        );


        // Save SQL

        editor.putInt(
                "sql",
                seekBars[6].getProgress()
        );


        // Save HR

        editor.putInt(
                "hr",
                seekBars[7].getProgress()
        );


        editor.apply();

    }


    // =========================================
    // Refresh Progress When Returning
    // =========================================

    @Override
    protected void onResume() {

        super.onResume();


        if (seekBars != null) {

            loadJavaProgress();

            loadDSAProgress();

            loadOtherProgress();

            calculateOverallProgress();

        }

    }

}
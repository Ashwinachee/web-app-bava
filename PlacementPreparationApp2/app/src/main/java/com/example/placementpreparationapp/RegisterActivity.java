package com.example.placementpreparationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button registerButton = findViewById(R.id.registerButton);
        android.widget.EditText nameEditText = findViewById(R.id.nameEditText);
        android.widget.EditText emailEditText = findViewById(R.id.emailEditText);

        registerButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();

            if (!name.isEmpty() || !email.isEmpty()) {
                android.content.SharedPreferences prefs = getSharedPreferences("UserProfile", MODE_PRIVATE);
                android.content.SharedPreferences.Editor editor = prefs.edit();
                if (!name.isEmpty()) editor.putString("name", name);
                if (!email.isEmpty()) editor.putString("email", email);
                editor.apply();
            }

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

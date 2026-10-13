package com.example.placementpreparationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProfileActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserProfile";

    private ImageView profileImageView;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText collegeEditText;
    private EditText branchEditText;
    private EditText gradYearEditText;
    private EditText linkedinEditText;
    private EditText githubEditText;

    private Button editSaveButton;
    private Button changePhotoButton;

    private boolean isEditMode = false;
    private SharedPreferences preferences;

    private ActivityResultLauncher<Intent> galleryLauncher;
    private ActivityResultLauncher<Intent> cameraLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Initialize views
        profileImageView    = findViewById(R.id.profileImageView);
        nameEditText        = findViewById(R.id.profileNameEditText);
        emailEditText       = findViewById(R.id.profileEmailEditText);
        phoneEditText       = findViewById(R.id.profilePhoneEditText);
        collegeEditText     = findViewById(R.id.profileCollegeEditText);
        branchEditText      = findViewById(R.id.profileBranchEditText);
        gradYearEditText    = findViewById(R.id.profileGradYearEditText);
        linkedinEditText    = findViewById(R.id.profileLinkedinEditText);
        githubEditText      = findViewById(R.id.profileGithubEditText);
        editSaveButton      = findViewById(R.id.editSaveButton);
        changePhotoButton   = findViewById(R.id.changePhotoButton);

        // Gallery launcher
        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            profileImageView.setImageBitmap(bitmap);
                            saveProfilePhoto(bitmap);
                        } catch (IOException e) {
                            Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        // Camera launcher
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle extras = result.getData().getExtras();
                        if (extras != null) {
                            Bitmap bitmap = (Bitmap) extras.get("data");
                            if (bitmap != null) {
                                profileImageView.setImageBitmap(bitmap);
                                saveProfilePhoto(bitmap);
                            }
                        }
                    }
                }
        );

        // Load saved profile data
        loadProfileData();

        // Set initial state: view mode (not editable)
        setEditMode(false);

        // Edit/Save button
        editSaveButton.setOnClickListener(v -> {
            if (isEditMode) {
                saveProfileData();
            } else {
                setEditMode(true);
            }
        });

        // Change photo button
        changePhotoButton.setOnClickListener(v -> showPhotoDialog());

        // Open LinkedIn on click
        TextView linkedinLabel = findViewById(R.id.linkedinLabel);
        linkedinLabel.setOnClickListener(v -> openUrl(linkedinEditText.getText().toString().trim()));

        // Open GitHub on click
        TextView githubLabel = findViewById(R.id.githubLabel);
        githubLabel.setOnClickListener(v -> openUrl(githubEditText.getText().toString().trim()));
    }


    // =========================================
    // Set Edit Mode
    // =========================================

    private void setEditMode(boolean edit) {
        isEditMode = edit;

        nameEditText.setEnabled(edit);
        emailEditText.setEnabled(edit);
        phoneEditText.setEnabled(edit);
        collegeEditText.setEnabled(edit);
        branchEditText.setEnabled(edit);
        gradYearEditText.setEnabled(edit);
        linkedinEditText.setEnabled(edit);
        githubEditText.setEnabled(edit);
        changePhotoButton.setVisibility(edit ? View.VISIBLE : View.GONE);

        editSaveButton.setText(edit ? "Save Profile" : "Edit Profile");
    }


    // =========================================
    // Load Profile Data from SharedPreferences
    // =========================================

    private void loadProfileData() {
        nameEditText.setText(preferences.getString("name", ""));
        emailEditText.setText(preferences.getString("email", ""));
        phoneEditText.setText(preferences.getString("phone", ""));
        collegeEditText.setText(preferences.getString("college", ""));
        branchEditText.setText(preferences.getString("branch", ""));
        gradYearEditText.setText(preferences.getString("gradYear", ""));
        linkedinEditText.setText(preferences.getString("linkedin", ""));
        githubEditText.setText(preferences.getString("github", ""));

        // Load profile photo
        String photoBase64 = preferences.getString("photo", null);
        if (photoBase64 != null) {
            byte[] imageBytes = Base64.decode(photoBase64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            profileImageView.setImageBitmap(bitmap);
        }
    }


    // =========================================
    // Save Profile Data to SharedPreferences
    // =========================================

    private void saveProfileData() {
        String name     = nameEditText.getText().toString().trim();
        String email    = emailEditText.getText().toString().trim();
        String phone    = phoneEditText.getText().toString().trim();
        String college  = collegeEditText.getText().toString().trim();
        String branch   = branchEditText.getText().toString().trim();
        String gradYear = gradYearEditText.getText().toString().trim();
        String linkedin = linkedinEditText.getText().toString().trim();
        String github   = githubEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Name and Email are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",     name);
        editor.putString("email",    email);
        editor.putString("phone",    phone);
        editor.putString("college",  college);
        editor.putString("branch",   branch);
        editor.putString("gradYear", gradYear);
        editor.putString("linkedin", linkedin);
        editor.putString("github",   github);
        editor.apply();

        setEditMode(false);
        Toast.makeText(this, "Profile Saved Successfully! ✅", Toast.LENGTH_SHORT).show();
    }


    // =========================================
    // Save Profile Photo (Base64)
    // =========================================

    private void saveProfilePhoto(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // Scale down if too large
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String base64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
        preferences.edit().putString("photo", base64).apply();
    }


    // =========================================
    // Show Photo Selection Dialog
    // =========================================

    private void showPhotoDialog() {
        String[] options = {"Choose from Gallery", "Take a Photo"};
        new AlertDialog.Builder(this)
                .setTitle("Change Profile Photo")
                .setItems(options, (dialog, which) -> {
                    if (which == 0) {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        galleryLauncher.launch(galleryIntent);
                    } else {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        cameraLauncher.launch(cameraIntent);
                    }
                })
                .show();
    }


    // =========================================
    // Open External URL
    // =========================================

    private void openUrl(String url) {
        if (url.isEmpty()) {
            Toast.makeText(this, "URL not set in your profile", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

}

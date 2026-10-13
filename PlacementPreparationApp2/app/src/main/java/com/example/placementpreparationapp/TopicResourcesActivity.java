package com.example.placementpreparationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Generic Topic Notes Activity
 * Shows learning content + official website links + YouTube links
 * for any subject topic.
 */
public class TopicResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topic_resources);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String subject = getIntent().getStringExtra("subject");
        String topic   = getIntent().getStringExtra("topic");
        String content = getIntent().getStringExtra("content");
        String[] webLinks  = getIntent().getStringArrayExtra("webLinks");
        String[] webTitles = getIntent().getStringArrayExtra("webTitles");
        String[] ytLinks   = getIntent().getStringArrayExtra("ytLinks");
        String[] ytTitles  = getIntent().getStringArrayExtra("ytTitles");

        if (subject == null) subject = "";
        if (topic   == null) topic   = "Topic";
        if (content == null) content = "Content coming soon...";

        // Set titles
        TextView subjectTitle = findViewById(R.id.resourceSubjectTitle);
        TextView topicTitle   = findViewById(R.id.resourceTopicTitle);
        TextView contentText  = findViewById(R.id.resourceContentText);

        subjectTitle.setText(subject);
        topicTitle.setText(topic);
        contentText.setText(content);

        // Populate web links
        LinearLayout webLinksLayout = findViewById(R.id.webLinksLayout);
        if (webLinks != null && webTitles != null) {
            for (int i = 0; i < webLinks.length && i < webTitles.length; i++) {
                addLinkButton(webLinksLayout, "🌐  " + webTitles[i], webLinks[i], "#0A84FF");
            }
        }

        // Populate YouTube links
        LinearLayout ytLinksLayout = findViewById(R.id.ytLinksLayout);
        if (ytLinks != null && ytTitles != null) {
            for (int i = 0; i < ytLinks.length && i < ytTitles.length; i++) {
                addLinkButton(ytLinksLayout, "▶  " + ytTitles[i], ytLinks[i], "#FF0000");
            }
        }
    }

    private void addLinkButton(LinearLayout parent, String title, String url, String colorHex) {
        Button btn = new Button(this);
        btn.setText(title);
        btn.setTextColor(android.graphics.Color.WHITE);
        btn.setAllCaps(false);
        btn.setTextSize(13f);
        btn.setPadding(20, 16, 20, 16);

        int color = android.graphics.Color.parseColor(colorHex);
        btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(color));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 12);
        btn.setLayoutParams(params);

        btn.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        });

        parent.addView(btn);
    }
}

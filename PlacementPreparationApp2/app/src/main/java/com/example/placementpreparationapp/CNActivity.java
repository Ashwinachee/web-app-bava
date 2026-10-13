package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CNActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup Buttons – open notes with external resources
        setupButton(R.id.networkBasicsButton, getString(R.string.network_basics));
        setupButton(R.id.osiButton,           getString(R.string.osi_model));
        setupButton(R.id.tcpIpButton,         getString(R.string.tcp_ip_model));
        setupButton(R.id.ipAddressButton,     getString(R.string.ip_addressing));
        setupButton(R.id.protocolsButton,     getString(R.string.network_protocols));
        setupButton(R.id.tcpUdpButton,        getString(R.string.tcp_vs_udp));
        setupButton(R.id.dnsButton,           getString(R.string.dns));
        setupButton(R.id.httpButton,          getString(R.string.http_https));
        setupButton(R.id.networkSecurityButton, getString(R.string.network_security));
    }

    private void setupButton(int buttonId, String topicName) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(v ->
                ResourcesHelper.launch(this, "CN", topicName)
            );
        }
    }
}

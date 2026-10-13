package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AptitudeTopicNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aptitude_topic_notes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView aptitudeTopicTitle = findViewById(R.id.aptitudeTopicTitle);
        TextView aptitudeTopicContent = findViewById(R.id.aptitudeTopicContent);

        String topic = getIntent().getStringExtra("topic");
        if (topic == null) {
            topic = "Aptitude";
        }

        aptitudeTopicTitle.setText(topic);

        if (topic.equals("Number System")) {
            aptitudeTopicContent.setText(
                    "NUMBER SYSTEM\n\n" +
                            "A number system is a method of representing numbers using different symbols and rules.\n\n" +
                            "Important Types:\n\n" +
                            "1. Natural Numbers\n1, 2, 3, 4, 5, ...\n\n" +
                            "2. Whole Numbers\n0, 1, 2, 3, ...\n\n" +
                            "3. Integers\n..., -3, -2, -1, 0, 1, 2, 3, ...\n\n" +
                            "4. Prime Numbers\nNumbers having exactly two factors: 1 and itself.\n\n" +
                            "Examples: 2, 3, 5, 7, 11\n\n" +
                            "Important Topics:\n\n" +
                            "• Divisibility Rules\n• Factors and Multiples\n• HCF and LCM\n• Prime Numbers\n• Remainders\n• Unit Digit\n\n" +
                            "Important Formula:\n\n" +
                            "For two positive integers:\nHCF × LCM = Product of the two numbers"
            );
        } else if (topic.equals("Percentages")) {
            aptitudeTopicContent.setText(
                    "PERCENTAGES\n\n" +
                            "Percentage means a value expressed out of 100.\n\n" +
                            "Basic Formula:\n\n" +
                            "Percentage = (Part / Whole) × 100\n\n" +
                            "Example:\n\n" +
                            "If a student scores 80 marks out of 100:\n\n" +
                            "Percentage = (80 / 100) × 100\nPercentage = 80%\n\n" +
                            "Important Concepts:\n\n" +
                            "• Percentage Increase\n• Percentage Decrease\n• Successive Percentage\n• Marks and Results\n• Population Problems\n\n" +
                            "Percentage Increase:\n\n" +
                            "Increase % = (Increase / Original Value) × 100\n\n" +
                            "Percentage Decrease:\n\n" +
                            "Decrease % = (Decrease / Original Value) × 100"
            );
        } else if (topic.equals("Profit & Loss")) {
            aptitudeTopicContent.setText(
                    "PROFIT AND LOSS\n\n" +
                            "Cost Price (CP):\nThe price at which an item is purchased.\n\n" +
                            "Selling Price (SP):\nThe price at which an item is sold.\n\n" +
                            "Profit:\n\nProfit = SP - CP\n\n" +
                            "Loss:\n\nLoss = CP - SP\n\n" +
                            "Profit Percentage:\n\nProfit % = (Profit / CP) × 100\n\n" +
                            "Loss Percentage:\n\nLoss % = (Loss / CP) × 100\n\n" +
                            "Important Topics:\n\n" +
                            "• Discount\n• Marked Price\n• Selling Price\n• Cost Price\n• Successive Discounts"
            );
        } else if (topic.equals("Time & Work")) {
            aptitudeTopicContent.setText(
                    "TIME AND WORK\n\n" +
                            "Time and Work problems deal with the amount of work completed by one or more people.\n\n" +
                            "Basic Formula:\n\n" +
                            "Work = Efficiency × Time\n\n" +
                            "If a person completes a work in 10 days:\n\nOne Day Work = 1 / 10\n\n" +
                            "If A completes work in 10 days and B completes the same work in 15 days:\n\n" +
                            "A's One Day Work = 1/10\nB's One Day Work = 1/15\n\n" +
                            "Together:\n\n1/10 + 1/15\n\n" +
                            "Important Topics:\n\n" +
                            "• Individual Work\n• Combined Work\n• Efficiency\n• Pipes and Cisterns"
            );
        } else if (topic.equals("Time, Speed & Distance")) {
            aptitudeTopicContent.setText(
                    "TIME, SPEED AND DISTANCE\n\n" +
                            "Basic Formula:\n\n" +
                            "Speed = Distance / Time\n\nDistance = Speed × Time\n\nTime = Distance / Speed\n\n" +
                            "Important Unit Conversions:\n\n1 km = 1000 metres\n\n1 hour = 3600 seconds\n\n" +
                            "To convert km/hr to m/sec:\n\nMultiply by 5/18\n\n" +
                            "To convert m/sec to km/hr:\n\nMultiply by 18/5\n\n" +
                            "Important Topics:\n\n" +
                            "• Relative Speed\n• Average Speed\n• Trains\n• Boats and Streams\n• Races"
            );
        } else if (topic.equals("Ratio & Proportion")) {
            aptitudeTopicContent.setText(
                    "RATIO AND PROPORTION\n\n" +
                            "A ratio compares two quantities of the same kind.\n\n" +
                            "Example:\n\nIf A = 10 and B = 20:\n\nRatio = 10 : 20\n\nSimplified Ratio = 1 : 2\n\n" +
                            "Proportion:\n\nIf two ratios are equal, they form a proportion.\n\n" +
                            "Example:\n\n2 : 4 = 3 : 6\n\n" +
                            "Important Topics:\n\n" +
                            "• Direct Proportion\n• Inverse Proportion\n• Partnership\n• Mixtures\n• Ages"
            );
        } else if (topic.equals("Probability")) {
            aptitudeTopicContent.setText(
                    "PROBABILITY\n\n" +
                            "Probability measures the chance of an event occurring.\n\n" +
                            "Basic Formula:\n\n" +
                            "Probability = Favourable Outcomes / Total Outcomes\n\n" +
                            "Example:\n\nWhen a fair coin is tossed:\n\nPossible Outcomes = Head, Tail\n\nProbability of Head = 1/2\n\n" +
                            "Important Topics:\n\n" +
                            "• Coins\n• Dice\n• Cards\n• Independent Events\n• Dependent Events"
            );
        } else if (topic.equals("Permutation & Combination")) {
            aptitudeTopicContent.setText(
                    "PERMUTATION AND COMBINATION\n\n" +
                            "Permutation deals with arrangements where order matters.\n\n" +
                            "Formula:\n\nnPr = n! / (n-r)!\n\n" +
                            "Combination deals with selections where order does not matter.\n\n" +
                            "Formula:\n\nnCr = n! / (r! × (n-r)!)\n\n" +
                            "Example:\n\nSelecting students for a team is a combination.\n\nArranging students in different positions is a permutation.\n\n" +
                            "Important Topics:\n\n" +
                            "• Factorials\n• Arrangements\n• Selections\n• Circular Arrangements\n• Repeated Elements"
            );
        }
    }
}

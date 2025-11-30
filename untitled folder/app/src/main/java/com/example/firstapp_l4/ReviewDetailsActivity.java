package com.example.firstapp_l4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewDetailsActivity extends AppCompatActivity {

    private int selectedDate;
    private String selectedTime;
    private int guestCount;
    private String guestPhone;
    private String guestName;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);

        selectedDate = getIntent().getIntExtra("selectedDate", -1);
        selectedTime = getIntent().getStringExtra("selectedTime");
        guestCount = getIntent().getIntExtra("guestCount", 1);
        guestPhone = getIntent().getStringExtra("guestPhone");
        guestName = getIntent().getStringExtra("guestName");
        notes = getIntent().getStringExtra("notes");

        TextView textDate = findViewById(R.id.textReviewDate);
        TextView textTime = findViewById(R.id.textReviewTime);
        TextView textGuest = findViewById(R.id.textReviewGuest);
        TextView textPhone = findViewById(R.id.textReviewPhone);

        textDate.setText("Date: " + selectedDate + " Dec 2025");
        textTime.setText("Time: " + selectedTime);
        textGuest.setText("Guest: " + guestCount);
        textPhone.setText("Phone: " + guestPhone);

        Button next = findViewById(R.id.buttonNextReview);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewDetailsActivity.this, ConfirmBookingActivity.class);
            intent.putExtra("selectedDate", selectedDate);
            intent.putExtra("selectedTime", selectedTime);
            intent.putExtra("guestName", guestName);
            intent.putExtra("guestPhone", guestPhone);
            intent.putExtra("guestCount", guestCount);
            intent.putExtra("notes", notes);
            startActivity(intent);
        });
    }
}
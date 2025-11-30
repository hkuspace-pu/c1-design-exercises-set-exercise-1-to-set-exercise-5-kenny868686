package com.example.firstapp_l4;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookingSuccessActivity extends AppCompatActivity {

    private int selectedDate;
    private String selectedTime;
    private int guestCount;
    private String guestPhone;
    private String guestName;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);

        selectedDate = getIntent().getIntExtra("selectedDate", -1);
        selectedTime = getIntent().getStringExtra("selectedTime");
        guestCount = getIntent().getIntExtra("guestCount", 1);
        guestPhone = getIntent().getStringExtra("guestPhone");
        guestName = getIntent().getStringExtra("guestName");
        notes = getIntent().getStringExtra("notes");

        TextView textMessage = findViewById(R.id.textSuccessMessage);
        textMessage.setText("Booking Success!\n" +
                "Date: " + selectedDate + " Dec 2025\n" +
                "Time: " + selectedTime);

        Button buttonBookingConfirmed = findViewById(R.id.buttonBookingConfirmed);
        buttonBookingConfirmed.setOnClickListener(v -> {
            Intent intent = new Intent(BookingSuccessActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
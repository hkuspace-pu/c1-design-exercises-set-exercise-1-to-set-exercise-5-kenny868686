package com.example.firstapp_l4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmBookingActivity extends AppCompatActivity {

    private int selectedDate;
    private String selectedTime;
    private int guestCount;
    private String guestPhone;
    private String guestName;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        selectedDate = getIntent().getIntExtra("selectedDate", -1);
        selectedTime = getIntent().getStringExtra("selectedTime");
        guestCount = getIntent().getIntExtra("guestCount", 1);
        guestPhone = getIntent().getStringExtra("guestPhone");
        guestName = getIntent().getStringExtra("guestName");
        notes = getIntent().getStringExtra("notes");

        TextView textDate = findViewById(R.id.textConfirmDate);
        TextView textTime = findViewById(R.id.textConfirmTime);
        TextView textGuest = findViewById(R.id.textConfirmGuest);
        TextView textPhone = findViewById(R.id.textConfirmPhone);

        textDate.setText("Date: " + selectedDate + " Dec 2025");
        textTime.setText("Time: " + selectedTime);
        textGuest.setText("Guest: " + guestCount);
        textPhone.setText("Phone: " + guestPhone);

        Button confirm = findViewById(R.id.buttonConfirmBooking);
        confirm.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmBookingActivity.this, BookingSuccessActivity.class);
            intent.putExtra("selectedDate", selectedDate);
            intent.putExtra("selectedTime", selectedTime);
            intent.putExtra("guestName", guestName);
            intent.putExtra("guestPhone", guestPhone);
            intent.putExtra("guestCount", guestCount);
            intent.putExtra("notes", notes);
            startActivity(intent);
            finish();
        });
    }
}
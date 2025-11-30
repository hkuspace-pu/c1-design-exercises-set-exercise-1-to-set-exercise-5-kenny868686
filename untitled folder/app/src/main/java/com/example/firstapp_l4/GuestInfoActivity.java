package com.example.firstapp_l4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class GuestInfoActivity extends AppCompatActivity {

    private int selectedDate;
    private String selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_info);

        selectedDate = getIntent().getIntExtra("selectedDate", -1);
        selectedTime = getIntent().getStringExtra("selectedTime");

        EditText editName = findViewById(R.id.editGuestName);
        EditText editPhone = findViewById(R.id.editGuestPhone);
        EditText editGuests = findViewById(R.id.editGuestCount);
        EditText editNotes = findViewById(R.id.editNotes);

        Button next = findViewById(R.id.buttonNextGuest);
        next.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String guestsStr = editGuests.getText().toString().trim();
            String notes = editNotes.getText().toString().trim();

            int guestCount = 1;
            if (!TextUtils.isEmpty(guestsStr)) {
                try {
                    guestCount = Integer.parseInt(guestsStr);
                } catch (NumberFormatException ignored) {}
            }

            Intent intent = new Intent(GuestInfoActivity.this, ReviewDetailsActivity.class);
            intent.putExtra("selectedDate", selectedDate);
            intent.putExtra("selectedTime", selectedTime);
            intent.putExtra("guestName", name);
            intent.putExtra("guestPhone", phone);
            intent.putExtra("guestCount", guestCount);
            intent.putExtra("notes", notes);
            startActivity(intent);
        });
    }
}
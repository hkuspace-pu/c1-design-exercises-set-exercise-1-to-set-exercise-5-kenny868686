package com.example.firstapp_l4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectTimeActivity extends AppCompatActivity {

    private String selectedTime = "6:00PM";
    private int selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        selectedDate = getIntent().getIntExtra("selectedDate", -1);

        TextView dateBadge = findViewById(R.id.textSelectedDate);
        dateBadge.setText("Date : " + selectedDate);

        int[] timeBtnIds = {
                R.id.btnTime1, R.id.btnTime2, R.id.btnTime3, R.id.btnTime4, R.id.btnTime5
        };
        String[] timeStrings = {"6:00PM", "6:30PM", "7:00PM", "7:30PM", "8:30PM"};

        for (int i = 0; i < timeBtnIds.length; i++) {
            int index = i;
            Button tBtn = findViewById(timeBtnIds[i]);
            tBtn.setOnClickListener(v -> {
                selectedTime = timeStrings[index];
                resetAllTimeButtons(timeBtnIds);
                tBtn.setBackgroundResource(R.drawable.bg_chip_selected);
                tBtn.setTextColor(getColor(android.R.color.white));
            });
        }

        Button defaultTimeBtn = findViewById(R.id.btnTime1);
        defaultTimeBtn.setBackgroundResource(R.drawable.bg_chip_selected);
        defaultTimeBtn.setTextColor(getColor(android.R.color.white));

        Button next = findViewById(R.id.buttonNextTime);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SelectTimeActivity.this, GuestInfoActivity.class);
            intent.putExtra("selectedDate", selectedDate);
            intent.putExtra("selectedTime", selectedTime);
            startActivity(intent);
        });
    }

    private void resetAllTimeButtons(int[] ids) {
        for (int id : ids) {
            Button b = findViewById(id);
            b.setBackgroundResource(R.drawable.bg_chip_neutral);
            b.setTextColor(getColor(android.R.color.black));
        }
    }
}
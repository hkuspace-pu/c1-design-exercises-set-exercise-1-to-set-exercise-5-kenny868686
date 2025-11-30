package com.example.firstapp_l4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectDateActivity extends AppCompatActivity {

    private int selectedDate = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        int[] dayButtonIds = {
                R.id.btnDay1, R.id.btnDay2, R.id.btnDay3, R.id.btnDay4, R.id.btnDay5, R.id.btnDay6,
                R.id.btnDay7, R.id.btnDay8, R.id.btnDay9, R.id.btnDay10, R.id.btnDay11, R.id.btnDay12
        };

        for (int i = 0; i < dayButtonIds.length; i++) {
            int day = i + 1;
            Button dayBtn = findViewById(dayButtonIds[i]);

            dayBtn.setOnClickListener(v -> {
                selectedDate = day;
                resetAllDateButtons(dayButtonIds);

            });
        }

        Button next = findViewById(R.id.buttonNextDate);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SelectDateActivity.this, SelectTimeActivity.class);
            intent.putExtra("selectedDate", selectedDate);
            startActivity(intent);
        });
    }

    private void resetAllDateButtons(int[] ids) {
        for (int id : ids) {
            Button b = findViewById(id);
            b.setBackgroundResource(R.drawable.bg_chip_neutral);
            b.setTextColor(getColor(android.R.color.black));
        }
    }
}
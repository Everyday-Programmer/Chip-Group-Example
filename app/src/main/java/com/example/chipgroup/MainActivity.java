package com.example.chipgroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ChipGroup chipGroup = findViewById(R.id.chipGroup);
        TextView textView = findViewById(R.id.tv);

        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (checkedIds.isEmpty()) {
                    textView.setText("No language selected");
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i: checkedIds) {
                        Chip chip = findViewById(i);
                        stringBuilder.append(",").append(chip.getText());
                    }
                    textView.setText("Selected languages: " + stringBuilder.toString().replaceFirst(",",""));
                }
            }
        });
    }
}
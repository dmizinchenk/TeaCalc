package com.activity.teacalc;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText score;
    SeekBar seek;
    TextView sum;
    TextView sumTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sum = findViewById(R.id.sum);
        sumTotal = findViewById(R.id.sumTotal);
        seek = findViewById(R.id.seek);
        score = findViewById(R.id.score);

        score.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sum.setText(String.valueOf(charSequence));
                sumTotal.setText(String.valueOf(Double.valueOf(charSequence.toString()) * (1 + (double)seek.getProgress()/100)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sumTotal.setText(String.valueOf(Double.valueOf(score.getText().toString()) * (1 + (double)i/100)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
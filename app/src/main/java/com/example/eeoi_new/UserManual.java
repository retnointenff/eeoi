package com.example.eeoi_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

public class UserManual extends AppCompatActivity {
    JustifiedTextView desc;
    Toolbar toolbar;
    TextView manual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manual);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        desc = findViewById(R.id.description);
        desc.setText(R.string.description);

        manual = findViewById(R.id.manual);
        manual.setText(R.string.manual);
    }
}

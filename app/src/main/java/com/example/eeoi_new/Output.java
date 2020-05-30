package com.example.eeoi_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Output extends AppCompatActivity {
    Toolbar toolbar;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        Bundle extras = getIntent().getExtras();
        String[] theta = extras.getStringArray("theta");
        double[] input_theta = extras.getDoubleArray("input");
        double hasil_eeoi = extras.getDouble("eeoi");

        TableLayout tableLayout = findViewById(R.id.tabel);
        for (int i = 0; i < input_theta.length; i++){
            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0,0,0,20);
            TextView thetaName = new TextView(this);
            thetaName.setText(theta[i]);
            thetaName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            thetaName.setTypeface(null, Typeface.BOLD);
            thetaName.setTypeface(ResourcesCompat.getFont(this, R.font.imprima));
            thetaName.setPadding(5,0,0,25);
            row.addView(thetaName);
            TextView thetaValue = new TextView(this);
            thetaValue.setText(String.valueOf(input_theta[i]));
            thetaValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            thetaValue.setTypeface(ResourcesCompat.getFont(this, R.font.imprima));
            thetaValue.setPadding(0,0,5,25);
            thetaValue.setGravity(Gravity.END);
            row.addView(thetaValue);
            tableLayout.addView(row);
        }

        TextView resulteeoi = findViewById(R.id.eeoi);

        resulteeoi.setText(String.format("%.6f", hasil_eeoi));
    }
}

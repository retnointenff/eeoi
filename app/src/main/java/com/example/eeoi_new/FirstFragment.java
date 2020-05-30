package com.example.eeoi_new;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputLayout;

public class FirstFragment extends Fragment {
    private double[] theta_eeoi = {0.0000002017577,
            0.0000032768108,
            -0.0000010597306,
            0.0000003770884,
            -0.0000225000532,
            -0.0000000219683,
            0.0000105549721,
            -0.000002778712,
            0.0000000023285};
    private double[] input_theta;
    private String[] theta = {"LOA", "B", "H", "T", "Vs", "Container Capacity", "Avg Speed", "Avg Draught", "Power Installed"};
    private double hasil_eeoi, theta0 = 0.0003163739758;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final TextInputLayout var_loa = getActivity().findViewById(R.id.var_loa);
        final TextInputLayout var_b = getActivity().findViewById(R.id.var_b);
        final TextInputLayout var_h = getActivity().findViewById(R.id.var_h);
        final TextInputLayout var_t = getActivity().findViewById(R.id.var_t);
        final TextInputLayout var_vs = getActivity().findViewById(R.id.var_vs);
        final TextInputLayout var_containerCapacity = getActivity().findViewById(R.id.var_containerCapacity);
        final TextInputLayout var_avgSpeed = getActivity().findViewById(R.id.var_avgSpeed);
        final TextInputLayout var_avgDraught = getActivity().findViewById(R.id.var_avgDraught);
        final TextInputLayout var_powerInstalled = getActivity().findViewById(R.id.var_powerInstalled);
        final Button hitung = getActivity().findViewById(R.id.hitung);
        final Button reset = getActivity().findViewById(R.id.reset);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (var_loa.getEditText().getText().length() == 0) {
                    var_loa.setError("Enter LOA");
                } else if (var_b.getEditText().getText().length() == 0){
                    var_b.setError("Enter B");
                } else if (var_h.getEditText().getText().length() == 0){
                    var_h.setError("Enter H");
                } else if (var_t.getEditText().getText().length() == 0){
                    var_t.setError("Enter T");
                } else if (var_vs.getEditText().getText().length() == 0){
                    var_vs.setError("Enter Vs");
                } else if (var_containerCapacity.getEditText().getText().length() == 0) {
                    var_containerCapacity.setError("Enter Container Capacity");
                } else if (var_avgSpeed.getEditText().getText().length() == 0){
                    var_avgSpeed.setError("Enter Avg Speed");
                } else if (var_avgDraught.getEditText().getText().length() == 0){
                    var_avgDraught.setError("Enter Avg Draught");
                } else if (var_powerInstalled.getEditText().getText().length() == 0){
                    var_powerInstalled.setError("Enter Power Installed");
                } else {
                    input_theta = new double[9];
                    input_theta[0] = Double.parseDouble(var_loa.getEditText().getText().toString());
                    input_theta[1] = Double.parseDouble(var_b.getEditText().getText().toString());
                    input_theta[2] = Double.parseDouble(var_h.getEditText().getText().toString());
                    input_theta[3] = Double.parseDouble(var_t.getEditText().getText().toString());
                    input_theta[4] = Double.parseDouble(var_vs.getEditText().getText().toString());
                    input_theta[5] = Double.parseDouble(var_containerCapacity.getEditText().getText().toString());
                    input_theta[6] = Double.parseDouble(var_avgSpeed.getEditText().getText().toString());
                    input_theta[7] = Double.parseDouble(var_avgDraught.getEditText().getText().toString());
                    input_theta[8] = Double.parseDouble(var_powerInstalled.getEditText().getText().toString());
                    hasil_eeoi += theta0;
                    for (int i = 0; i < input_theta.length; i++){
                        hasil_eeoi += (input_theta[i] * theta_eeoi[i]);
                    }
                    Intent intent = new Intent(getActivity(), Output.class);
                    intent.putExtra("theta", theta);
                    intent.putExtra("input", input_theta);
                    intent.putExtra("eeoi", hasil_eeoi);
                    startActivity(intent);
                    hasil_eeoi = 0;
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil_eeoi = 0;
                var_loa.getEditText().getText().clear();
                var_b.getEditText().getText().clear();
                var_h.getEditText().getText().clear();
                var_t.getEditText().getText().clear();
                var_vs.getEditText().getText().clear();
                var_avgSpeed.getEditText().getText().clear();
                var_avgDraught.getEditText().getText().clear();
                var_containerCapacity.getEditText().getText().clear();
                var_powerInstalled.getEditText().getText().clear();
            }
        });
    }
}

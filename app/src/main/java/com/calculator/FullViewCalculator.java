package com.calculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.calculator.databinding.ActivityFullViewCalculatorBinding;
import com.calculator.util.Helper;


public class FullViewCalculator extends AppCompatActivity {

    private ActivityFullViewCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_full_view_calculator);
        onUIAction();
    }

    private void appendDisplay(String append) {
        if (binding.display.getText().toString().equals("0")) {
            binding.display.setText(append);
        } else {
            binding.display.append(append);
        }
    }

    private void onUIAction() {

        binding.btnOne.setOnClickListener(view -> appendDisplay("1"));
        binding.btnTwo.setOnClickListener(view -> appendDisplay("2"));
        binding.btnThree.setOnClickListener(view -> appendDisplay("3"));
        binding.btnFour.setOnClickListener(view -> appendDisplay("4"));
        binding.btnFive.setOnClickListener(view -> appendDisplay("5"));
        binding.btnSix.setOnClickListener(view -> appendDisplay("6"));
        binding.btnSeven.setOnClickListener(view -> appendDisplay("7"));
        binding.btnEight.setOnClickListener(view -> appendDisplay("8"));
        binding.btnNine.setOnClickListener(view -> appendDisplay("9"));
        binding.btnZero.setOnClickListener(view -> appendDisplay("0"));

        binding.btnAdd.setOnClickListener(view -> {
            appendDisplay(binding.btnAdd.getText().toString());
        });
        binding.btnDivide.setOnClickListener(view -> {
            appendDisplay(binding.btnDivide.getText().toString());
        });
        binding.btnMultiply.setOnClickListener(view -> {
            appendDisplay(binding.btnMultiply.getText().toString());
        });
        binding.btnSubtraction.setOnClickListener(view -> {
            appendDisplay(binding.btnSubtraction.getText().toString());
        });

        binding.btnDecimal.setOnClickListener(view -> {
            appendDisplay(binding.btnDecimal.getText().toString());
        });
        binding.btnOpenBr.setOnClickListener(view -> {
            appendDisplay(binding.btnOpenBr.getText().toString());
        });
        binding.btnCloseBr.setOnClickListener(view -> {
            appendDisplay(binding.btnCloseBr.getText().toString());
        });

        binding.btnC.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(binding.display.getText())) {
                String value = binding.display.getText().toString();
                value = value.substring(0, value.length() - 1);
                binding.display.setText(value);
            }

        });

        binding.btnAc.setOnClickListener(view -> {
            binding.display.setText("");
            binding.history.setText("");
        });

        binding.btnEquals.setOnClickListener(view -> {
            calculate();
        });


    }

    private void calculate() {
        String value = binding.display.getText().toString();
//        45 + 998
//        445 x 45
//        767 / 55
//        56 - 76
//        ["45", "998"]
        //

        double value1;
        double value2;
        double answer = 0;

        if (value.contains(binding.btnAdd.getText().toString())) {
            value1 = Double.parseDouble(value.split("\\+")[0]);
            value2 = Double.parseDouble(value.split("\\+")[1]);
            answer = value1 + value2;
        } else if (value.contains(binding.btnSubtraction.getText().toString())) {
            value1 = Double.parseDouble(value.split(binding.btnSubtraction.getText().toString())[0]);
            value2 = Double.parseDouble(value.split(binding.btnSubtraction.getText().toString())[1]);
            answer = value1 - value2;

        } else if (value.contains(binding.btnMultiply.getText().toString())) {

            value1 = Double.parseDouble(value.split(binding.btnMultiply.getText().toString())[0]);
            value2 = Double.parseDouble(value.split(binding.btnMultiply.getText().toString())[1]);
            answer = value1 * value2;

        } else if (value.contains(binding.btnDivide.getText().toString())) {

            value1 = Double.parseDouble(value.split(binding.btnDivide.getText().toString())[0]);
            value2 = Double.parseDouble(value.split(binding.btnDivide.getText().toString())[1]);
            answer = value1 / value2;

        }

        binding.history.setText(value);
        binding.display.setText(Helper.getResponsiveNumber(answer));


    }


}
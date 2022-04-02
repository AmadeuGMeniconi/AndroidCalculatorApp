package com.amadeu.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button four;
    private Button three;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button sub;
    private Button add;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView operation;
    private TextView result;
    private double val1 = Double.NaN;
    private double val2;
    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText(operation.getText().toString() + "9");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '*';
                result.setText(String.valueOf(val1) + " * ");
                operation.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '/';
                result.setText(String.valueOf(val1) + " / ");
                operation.setText(null);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '+';
                result.setText(String.valueOf(val1) + " + ");
                operation.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '-';
                result.setText(String.valueOf(val1) + " - ");
                operation.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = '=';
                result.setText(result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                operation.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.getText().length() > 0){
                    CharSequence name = operation.getText().toString();
                    operation.setText(name.subSequence(0, name.length() -1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    operation.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    private void setupUIViews(){
        zero = findViewById(R.id.btn_0);
        one = findViewById(R.id.btn_1);
        two = findViewById(R.id.btn_2);
        three = findViewById(R.id.btn_3);
        four = findViewById(R.id.btn_4);
        five = findViewById(R.id.btn_5);
        six = findViewById(R.id.btn_6);
        seven = findViewById(R.id.btn_7);
        eight = findViewById(R.id.btn_8);
        nine = findViewById(R.id.btn_9);
        equal = findViewById(R.id.btn_equal);
        clear = findViewById(R.id.btn_clear);
        mul= findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        operation = findViewById(R.id.txt_operation);
        result = findViewById(R.id.txt_result);
    }

    private void compute(){
        if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(operation.getText().toString());
            switch (action){
                case '*':
                    val1 = val1 * val2;
                    break;
                case '/':
                    val1 = val1 / val2;
                    break;
                case '+':
                    val1 = val1 + val2;
                    break;
                case '-':
                    val1 = val1 - val2;
                    break;
                case '=':

                    break;
            }
        }
        else {
            val1 = Double.parseDouble(operation.getText().toString());
        }
    }
}
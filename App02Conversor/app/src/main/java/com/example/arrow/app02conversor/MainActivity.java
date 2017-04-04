package com.example.arrow.app02conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final double FACTOR = 166.386;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_euro_ptas).setOnClickListener(this);
        findViewById(R.id.button_ptas_euros).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edit_text_moneda_a;
        EditText edit_text_moneda_b;
        double valor1;
        double valor2 = 0.0;
        edit_text_moneda_a = (EditText)findViewById(R.id.edit_text_moneda_a);
        edit_text_moneda_b = (EditText)findViewById(R.id.edit_text_moneda_b);
        valor1 = Double.parseDouble(edit_text_moneda_a.getText().toString());

        switch (v.getId()){
            case R.id.button_euro_ptas:
                valor2 = valor1*FACTOR;
                break;
            case R.id.button_ptas_euros:
                valor2 = (valor1/FACTOR)*100;
                break;
        }
        edit_text_moneda_b.setText(String.format("%.2f",valor2));
    }
}

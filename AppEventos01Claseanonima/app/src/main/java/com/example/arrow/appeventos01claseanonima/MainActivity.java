package com.example.arrow.appeventos01claseanonima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button_pulsar);

        View.OnClickListener manejador = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv =(TextView) findViewById(R.id.text_view_saludo);
                tv.setText("Hola");
            }
        };
        b.setOnClickListener(manejador);
    }
}

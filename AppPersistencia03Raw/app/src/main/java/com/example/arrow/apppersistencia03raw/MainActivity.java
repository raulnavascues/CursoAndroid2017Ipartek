package com.example.arrow.apppersistencia03raw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textViewFabula = (TextView) findViewById(R.id.text_view_fabula);
        InputStream is = getResources().openRawResource(R.raw.fabula);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String linea = null;

        try {
            linea = br.readLine();

            while (linea != null) {
                textViewFabula.append(linea.concat(System.getProperty("line.separator")));
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {

        }



    }
}

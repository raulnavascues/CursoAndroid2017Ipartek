package com.example.arrow.apppersistencia01almacenamientointerno;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    public static final String NOMBRE_FICHERO = "AppPersistencia02AlmacenamientoInterno.dat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BufferedReader br = null;
        FileInputStream fis = null;
        EditText editTextAnotaciones = (EditText) findViewById(R.id.edit_text_anotaciones);

        try {
            fis = openFileInput(NOMBRE_FICHERO);
            br = new BufferedReader(new InputStreamReader(fis));

            String linea = br.readLine();
            while (linea != null) {
                editTextAnotaciones.append(linea + "\n");
                linea = br.readLine();
            }
            br.close();
            fis.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText)findViewById(R.id.edit_text_anotaciones)).setText("");
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        FileOutputStream fos = null;
        EditText editTextAnotaciones = (EditText) findViewById(R.id.edit_text_anotaciones);

        try {
            fos = openFileOutput(NOMBRE_FICHERO, Context.MODE_PRIVATE); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            bw.write(editTextAnotaciones.getText().toString());

            bw.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }
}
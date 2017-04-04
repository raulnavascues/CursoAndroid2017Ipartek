package com.example.arrow.apppersistencia04almacenamientoexterno;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static final String ARCHIVO = "AppPersistencia04AlmacenamientoExterno.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textViewDato = (EditText) findViewById(R.id.edit_text_dato);
       final File directorioPublicoDocumentos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        findViewById(R.id.button_leer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();

                if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                   // File directorioPublicoDocumentos =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    File ficheroDatos = new File(directorioPublicoDocumentos, ARCHIVO);
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
                        textViewDato.setText(br.readLine());
                        br.close();
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    }
                }

            }
        });


        findViewById(R.id.button_guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();

                if (Environment.MEDIA_MOUNTED.equals(state)) {

                    File ficheroDatos = new File(directorioPublicoDocumentos, ARCHIVO);
                    if (!ficheroDatos.exists()) {
                        try {
                            ficheroDatos.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    BufferedWriter bw = null;

                    try {
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDatos)));
                        bw.write(textViewDato.getText().toString());
                        bw.close();
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    }
                }

            }
        }

    );

}
}

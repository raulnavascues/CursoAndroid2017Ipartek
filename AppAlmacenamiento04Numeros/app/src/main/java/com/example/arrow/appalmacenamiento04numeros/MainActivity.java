package com.example.arrow.appalmacenamiento04numeros;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> arrayAdapterNumeros = null;
    ArrayList<String> arrayListNumeros = null;
    private static final String ARCHIVO = "numeros.txt";
    private File directorioDocumentos = null;

    private void cargarDatosFichero() {
        //Lectura del fichero
        String state = Environment.getExternalStorageState();

        arrayListNumeros = new ArrayList<String>();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // File directorioPublicoDocumentos =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File ficheroDatos = new File(directorioDocumentos, ARCHIVO);
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroDatos)));
                String linea = br.readLine();
                while (linea != null) {
                    arrayListNumeros.add(br.readLine());
                    linea = br.readLine();
                }
                br.close();

                arrayAdapterNumeros = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListNumeros);
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        directorioDocumentos = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        cargarDatosFichero();
        // Cargar el listview con los datos

        ((ListView) findViewById(R.id.list_view_numeros)).setAdapter(arrayAdapterNumeros);

        findViewById(R.id.button_guardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();

                if (Environment.MEDIA_MOUNTED.equals(state)) {

                    File ficheroDatos = new File(directorioDocumentos, ARCHIVO);
                    if (!ficheroDatos.exists()) {
                        try {
                            ficheroDatos.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    BufferedWriter bw = null;

                    try {
                        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDatos,true)));
                        bw.append(((EditText) findViewById(R.id.edit_text_numeros)).getText().toString()+"\n");
                        bw.close();

                        cargarDatosFichero();
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    }
                }
            }
        });

    }


}

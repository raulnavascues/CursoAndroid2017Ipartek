package com.example.arrow.apppersistencia01sharedpreferenceslogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String NOMBRE_ARCHIVO_PREFERNECIAS = "AppPersistencia01PrefsFiesLogin";

    public static final String NOMBRE_PREFERENCIA_EMAIL = "Email";
    public static final String NOMBRE_PREFERENCIA_PASS = "Pass";
    public static final String NOMBRE_PREFERENCIA_RECORDAR = "Recordar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences settings = getSharedPreferences(NOMBRE_ARCHIVO_PREFERNECIAS, Context.MODE_PRIVATE);

        String email = settings.getString(NOMBRE_PREFERENCIA_EMAIL, "");
        String pass = settings.getString(NOMBRE_PREFERENCIA_PASS, "");
        boolean recordar = settings.getBoolean(NOMBRE_PREFERENCIA_RECORDAR, false);

        ((EditText) findViewById(R.id.edit_text_email)).setText(email);
        ((EditText) findViewById(R.id.edit_text_pass)).setText(pass);
        ((CheckBox) findViewById(R.id.check_box_recordar)).setChecked(recordar);


        findViewById(R.id.button_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // SharedPreferences settings = getSharedPreferences(NOMBRE_ARCHIVO_PREFERNECIAS, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();

                if (((CheckBox) findViewById(R.id.check_box_recordar)).isChecked()) {
                    editor.putString(NOMBRE_PREFERENCIA_EMAIL, ((EditText) findViewById(R.id.edit_text_email)).getText().toString());
                    editor.putString(NOMBRE_PREFERENCIA_PASS, ((EditText) findViewById(R.id.edit_text_pass)).getText().toString());
                    editor.putBoolean(NOMBRE_PREFERENCIA_RECORDAR, ((CheckBox) findViewById(R.id.check_box_recordar)).isChecked());
                } else {
                    editor.remove(NOMBRE_PREFERENCIA_EMAIL);
                    editor.remove(NOMBRE_PREFERENCIA_PASS);
                    editor.remove(NOMBRE_PREFERENCIA_RECORDAR);
                }

                Toast.makeText(v.getContext(), "Se han guardado las preferencias", Toast.LENGTH_SHORT).show();

                editor.commit();
                finish();
            }
        });


    }
}

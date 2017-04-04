package com.example.arrow.app01formatearnombre;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    public static final String NOMBRE_COMPLETO = "NOMBRE_COMPLETO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String nombreCompleto = "";
                String apellido1 = ((EditText) findViewById(R.id.editText)).getText().toString();
                String apellido2 = ((EditText) findViewById(R.id.editText3)).getText().toString();
                String nombre = ((EditText) findViewById(R.id.editText2)).getText().toString();
                nombreCompleto.concat(apellido1.concat(", "));
                nombreCompleto.concat(apellido2.concat(", "));
                nombreCompleto.concat(nombre);

                intent.putExtra(NOMBRE_COMPLETO, nombreCompleto);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

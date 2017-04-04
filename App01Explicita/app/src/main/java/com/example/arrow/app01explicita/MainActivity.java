package com.example.arrow.app01explicita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO_ESCRITO = "TEXTO_ESCRITO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_abrir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OtherActivity.class);
                intent.putExtra(EXTRA_TEXTO_ESCRITO, ((EditText) findViewById(R.id.edit_text_texto)).getText().toString());
                startActivity(intent);
            }
        });

    }
}

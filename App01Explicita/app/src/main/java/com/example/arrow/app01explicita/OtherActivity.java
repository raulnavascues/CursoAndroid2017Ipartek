package com.example.arrow.app01explicita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();

        ((TextView)findViewById(R.id.text_view_dato)).setText(intent.getStringExtra(MainActivity.EXTRA_TEXTO_ESCRITO));
    }
}

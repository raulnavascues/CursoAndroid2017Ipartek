package com.example.arrow.app01explicita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    public final static String RESULT_ME_GUSTA = "LE GUSTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        final Intent intent = getIntent();

        ((TextView) findViewById(R.id.text_view_dato)).setText(intent.getStringExtra(MainActivity.EXTRA_TEXTO_ESCRITO));

        findViewById(R.id.button_me_gusta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RESULT_ME_GUSTA, true);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.button_no_me_gusta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(RESULT_ME_GUSTA, false);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

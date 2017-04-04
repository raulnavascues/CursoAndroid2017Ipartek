package com.example.arrow.app01formatearnombre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String NOMBRE_INTENT = "NOMBRE_INTENT";
    public static final int REQUEST_ME_GUSTA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OtherActivity.class);
                startActivityForResult(intent,REQUEST_ME_GUSTA);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ME_GUSTA) {
            if (resultCode == RESULT_OK) {
                ((TextView) findViewById(R.id.edit_textNombre)).setText(data.getStringExtra(OtherActivity.NOMBRE_COMPLETO));
            }
        }

    }
}
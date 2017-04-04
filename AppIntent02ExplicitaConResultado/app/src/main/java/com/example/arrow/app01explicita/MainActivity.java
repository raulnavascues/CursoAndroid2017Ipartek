package com.example.arrow.app01explicita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO_ESCRITO = "TEXTO_ESCRITO";
    public static final int REQUEST_ME_GUSTA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_abrir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OtherActivity.class);
                intent.putExtra(EXTRA_TEXTO_ESCRITO, ((EditText) findViewById(R.id.edit_text_texto)).getText().toString());
                startActivityForResult(intent, REQUEST_ME_GUSTA);
            }
        });
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ME_GUSTA){
            if(resultCode == RESULT_OK){
                if (data.getBooleanExtra(OtherActivity.RESULT_ME_GUSTA,false)){
                    Toast.makeText(this,"He contestado Me gusta",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "He contestado no me gusta", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

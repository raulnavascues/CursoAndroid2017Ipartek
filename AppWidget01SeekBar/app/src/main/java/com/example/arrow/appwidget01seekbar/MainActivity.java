package com.example.arrow.appwidget01seekbar;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBarValor = (SeekBar) findViewById(R.id.seek_bar_valor);

        TextView text = (TextView) findViewById(R.id.text_view_valor);

        text.setText(String.valueOf(seekBarValor.getProgress()));
        seekBarValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            TextView text = (TextView) findViewById(R.id.text_view_valor);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView text = (TextView) findViewById(R.id.text_view_valor);

                text.setText(String.valueOf(progress));
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

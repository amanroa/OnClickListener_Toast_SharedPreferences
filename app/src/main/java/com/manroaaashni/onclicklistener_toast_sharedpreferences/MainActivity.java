package com.manroaaashni.onclicklistener_toast_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    SeekBar seekBar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
//        editor.clear();
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        seekBar = findViewById(R.id.seekBar);

        int text1 = 0;
        editor.putInt("text1", text1);

        int text2 = 0;
        editor.putInt("text2", text2);

        int text3 = 0;
        editor.putInt("text3", text3);

        int text4 = 0;
        editor.putInt("text4", text4);

        editor.apply();

        txt1.setOnClickListener(onClickListener);
        txt2.setOnClickListener(onClickListener);
        txt3.setOnClickListener(onClickListener);
        txt4.setOnClickListener(onClickListener);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt1.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);
                txt2.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);
                txt3.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);
                txt4.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textView1:
                    int click_int = sharedPreferences.getInt("txt1", 0);
                    click_int += 1;
                    editor.putInt("txt1", click_int);
                    editor.apply();
                    String count = "TextView 1 has been pressed " + Integer.toString(click_int) + " amount of times";
                    Toast.makeText(getApplicationContext(),
                            count,
                            Toast.LENGTH_LONG).show();
                    break;
                case R.id.textView2:
                    click_int = sharedPreferences.getInt("txt2", 0);
                    click_int += 1;
                    editor.putInt("txt2", click_int);
                    editor.apply();
                    count = "TextView 2 has been pressed " + Integer.toString(click_int) + " amount of times";
                    Toast.makeText(getApplicationContext(),
                            count,
                            Toast.LENGTH_LONG).show();
                    break;
                case R.id.textView3:
                    click_int = sharedPreferences.getInt("txt3", 0);
                    click_int += 1;
                    editor.putInt("txt3", click_int);
                    count = "TextView 3 has been pressed " + Integer.toString(click_int) + " amount of times";
                    Toast.makeText(getApplicationContext(),
                            count,
                            Toast.LENGTH_LONG).show();
                    break;
                case R.id.textView4:
                    click_int = sharedPreferences.getInt("txt4", 0);
                    click_int += 1;
                    editor.putInt("txt4", click_int);
                    editor.apply();
                    count = "TextView 4 has been pressed " + Integer.toString(click_int) + " amount of times";
                    Toast.makeText(getApplicationContext(),
                            count,
                            Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };


}

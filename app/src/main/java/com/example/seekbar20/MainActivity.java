package com.example.seekbar20;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar redSeekbar, greenSeekBar, blueSeekBar;
    private TextView textRGB;
    private int red, green, blue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRGB = (TextView) findViewById(R.id.text_RGB);
        redSeekbar = (SeekBar) findViewById(R.id.seekBar_Red);
        greenSeekBar = (SeekBar) findViewById(R.id.seekBar_Green);
        blueSeekBar = (SeekBar) findViewById(R.id.seekBar_Blue);
        updateBackground();


        redSeekbar.setOnSeekBarChangeListener(SeekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(SeekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(SeekBarChangeListener);

        //seekbar=(SeekBar)findViewById(R.id.seekBar_Red);

    }
    private SeekBar.OnSeekBarChangeListener SeekBarChangeListener = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser)
        {
            //Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
            updateBackground();
            textRGB.setText("("+ red + "," + green + "," + blue + ")");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {
            // Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {
            // Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
        }
    };

    public void updateBackground()
    {
        red = redSeekbar.getProgress();
        green = greenSeekBar.getProgress();
        blue = blueSeekBar.getProgress();
        textRGB.setBackgroundColor(
                0xff000000
                        + red * 0x10000
                        + green * 0x100
                        + blue
        );
    }
}
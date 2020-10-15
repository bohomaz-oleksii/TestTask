package com.example.thedots;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    public FigureView gameView;
    private final Handler handler = new Handler();
    private long updateDelay = 25;
    public Button startBtn, clearBtn, btnMode;

    public Boolean btnState = false;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = (FigureView) findViewById(R.id.figureView);



        startBtn = (Button) findViewById(R.id.btnStart);
        clearBtn = (Button) findViewById(R.id.btnClear);
        btnMode = (Button) findViewById(R.id.btnMode);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btnState){
                    startUpdateHandler();
                    startBtn.setText("Stop");
                    btnState = true;
                }else{
                    handler.removeCallbacksAndMessages(null);
                    startBtn.setText("Start");
                btnState = false;
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.clearDisplay();
                gameView.invalidate();
            }
        });

        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean mode = gameView.getMode();
                if (mode){
                    gameView.setMode(false);
                    btnMode.setText("MODE 2");
                }else{
                    gameView.setMode(true);
                    btnMode.setText("MODE 1");
                }
            }
        });

    }

    private void startUpdateHandler() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    handler.postDelayed(this, updateDelay);
                    gameView.invalidate();
                }

        }, updateDelay);

    }



}

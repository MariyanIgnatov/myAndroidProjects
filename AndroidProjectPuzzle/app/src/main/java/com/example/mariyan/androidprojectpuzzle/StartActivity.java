package com.example.mariyan.androidprojectpuzzle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartActivity extends Activity implements View.OnClickListener {

    private Button loginButton;
    private Button soundButton;
    private Button exitButton;
    private Button rankListButton;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        musicPlay();

        loginButton = (Button) findViewById(R.id.login_button_id);
        loginButton.setOnClickListener(this);

        soundButton = (Button) findViewById(R.id.sound_button_id);
        soundButton.setOnClickListener(this);

        rankListButton = (Button) findViewById(R.id.rank_list_button_id);
        rankListButton.setOnClickListener(this);


        exitButton = (Button) findViewById(R.id.exit_button_id);
        exitButton.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        musicStop();
        super.onDestroy();
    }


    private void musicPlay() {

        if (mp == null) {
            mp = MediaPlayer.create(StartActivity.this, R.raw.music);
            if (!mp.isPlaying()) {

                mp.setLooping(true);
                mp.start();
            }
        }
    }

    private void musicStop() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button_id: {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);

                startActivity(intent);
                break;
            }
            case R.id.sound_button_id: {
                String title = "Sound Settings";

                if (mp != null) {
                    String message = "Are you sure you want to stop the music?";
                    AlertDialog.Builder builder = Constants.alertMessage(title, message,
                            "No", view.getContext());
                    builder.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            musicStop();


                        }
                    });
                    builder.show();
                } else {
                    String message = "Are you sure you want to turn on the music?";
                    AlertDialog.Builder builder = Constants.alertMessage(title, message,
                            "No", view.getContext());
                    builder.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            musicPlay();


                        }
                    });
                    builder.show();
                }


                break;
            }
            case R.id.rank_list_button_id: {
                Intent intentRanking = new Intent(StartActivity.this, RankingList.class);
                startActivity(intentRanking);
                break;
            }
            case R.id.exit_button_id: {
                String titleExit = "Exit";
                String message = "Are you sure you want to quit?";
                AlertDialog.Builder builder = Constants.alertMessage(titleExit, message,
                        "No", view.getContext());


                builder.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        finish();
                    }
                });

                builder.show();

                break;
            }
        }
    }
}

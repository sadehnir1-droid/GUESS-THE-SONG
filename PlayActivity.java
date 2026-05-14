package com.nirs.guessthesong;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity
{
    private String selectedValue;
    private String selectedCategory;
    private String selectedOption;
    private String songName;
    private Vibrator vibrate;

    private EditText eSong;
    private TextView songLyrics;
    private TextView valueTitle;
    private ImageButton btnPlay, btnStop, btnPause;
    private Button btnGuess, btnGiveUp;
    private MediaPlayer player;
    private boolean showTextBox = false;

    private int resAudioFile;
    private int arrayLength;
    private int currSongPos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String[] decadeArray = getResources().getStringArray(R.array.years_list);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_actvity);
        eSong = findViewById(R.id.eSongName);
        songLyrics = findViewById(R.id.songLyrics);
        valueTitle = findViewById(R.id.valueTitle);
        btnPlay = findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);
        btnStop = findViewById(R.id.stop);
        btnGuess = findViewById(R.id.guessSong);
        btnGiveUp = findViewById(R.id.giveUp);
        vibrate =  (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        FirebaseLogic.init(PlayActivity.this);


        registerReceiver(receiver, new IntentFilter(FirebaseLogic.LOAD));


        selectedValue = getIntent().getStringExtra("selectedValue");
        selectedCategory = getIntent().getStringExtra("selectedCategory");
        selectedOption = getIntent().getStringExtra("lyricsOrAudio");
        valueTitle.setText(selectedValue);




        if (selectedCategory.equals("Genre"))
        {
            FirebaseLogic.getSongsByGenre(selectedValue);
        }

        else if (selectedCategory.equals("Artist"))
        {
            FirebaseLogic.getSongsByArtist(selectedValue);
        }


        else if(selectedCategory.equals("Year"))
        {
            FirebaseLogic.getSongsByYear(Integer.parseInt(selectedValue));
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            arrayLength = FirebaseLogic.songs.getSize();
            setSong();
            unregisterReceiver(receiver);
        }
    };


    public void setSong()
    {
        if (arrayLength > 0)
        {
            Song song = FirebaseLogic.songs.getSong(currSongPos);
            songLyrics.setText(song.getLyrics());
            songName = song.getName();
            resAudioFile = getResources().getIdentifier(song.getFileAudioName(), "raw", getPackageName());


            if (selectedOption.equals("lyrics")) {
                btnPlay.setVisibility(View.GONE);
                btnStop.setVisibility(View.GONE);
                btnPause.setVisibility(View.GONE);
                songLyrics.setVisibility(View.VISIBLE);

            } else {
                btnPlay.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                songLyrics.setVisibility(View.GONE);

            }


            btnPlay.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (player == null) {
                        player = MediaPlayer.create(PlayActivity.this, resAudioFile);
                    }
                    player.start();
                }
            });


            btnPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player != null) {
                        player.pause();
                    }
                }
            });


            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player != null) {
                        player.release();
                        player = null;
                    }
                }
            });
        }
        else
        {
            btnGiveUp.setEnabled(false);
            btnGuess.setEnabled(false);
            btnPause.setEnabled(false);
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
            Toast.makeText(this, "No songs of that category was found", Toast.LENGTH_SHORT).show();
        }
    }


    public void goToGame(View v)
    {
        if (player != null)
        {
            player.release();
            player = null;
        }

        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }







    public void guessSong(View v)
    {
        if (player != null)
        {
            player.release();
            player = null;
        }
        String eSongString = eSong.getText().toString().trim();
        if (songName.toLowerCase().equalsIgnoreCase(eSongString) || songName.toLowerCase().equalsIgnoreCase(eSongString.toLowerCase()) || (songName.replace("'", "")).equalsIgnoreCase(eSongString))
        {
            if (SaveData.isVibrate())
            {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
                {
                    vibrate.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                }
            }

            Toast.makeText(this, "Well Done", Toast.LENGTH_SHORT).show();
            currSongPos++;

            registerReceiver(receiver_two, new IntentFilter(FirebaseLogic.LOAD));
            FirebaseLogic.markSongAsGuessedForUser(songName);

            if (currSongPos < arrayLength)
            {
                setSong();
            }
            else
            {
                Toast.makeText(this, "You finished to guess all the songs of that category", Toast.LENGTH_SHORT).show();
                btnGiveUp.setEnabled(false);
                btnGuess.setEnabled(false);
                btnPause.setEnabled(false);
                btnPlay.setEnabled(false);
                btnStop.setEnabled(false);
            }
        }
        else
        {
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
        }
        eSong.setText("");
    }




    private BroadcastReceiver receiver_two = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            unregisterReceiver(receiver_two);
        }
    };




    public void giveUp (View v)
    {
        if (player != null)
        {
            player.release();
            player = null;
        }        Toast.makeText(this, "The song is: " + songName, Toast.LENGTH_SHORT).show();
        currSongPos++;
        if(currSongPos < arrayLength)
        {
            setSong();
        }
        else
        {
            Toast.makeText(this, "You finished to guess all the songs of that category", Toast.LENGTH_SHORT).show();
            btnGiveUp.setEnabled(false);
            btnGuess.setEnabled(false);
            btnPause.setEnabled(false);
            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);
        }
        eSong.setText("");
    }


    public void goToSettings(View v)
    {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}


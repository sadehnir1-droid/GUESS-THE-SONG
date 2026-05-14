package com.nirs.guessthesong;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity
{

        private Switch sVibrate;
        private Switch sSound;


    @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            SaveData.init(this);
            sVibrate = findViewById(R.id.sVibrate);
            sSound = findViewById(R.id.sSound);
            sVibrate.setChecked(SaveData.isVibrate());
            sSound.setChecked(SaveData.isSound());
            FirebaseLogic.init(SettingsActivity.this);
        }



        public void changeVibrate(View v)
        {
            if(sVibrate.isChecked())
            {
                Toast.makeText(this, "Vibrate is ON", Toast.LENGTH_SHORT).show();
                SaveData.setVibrate(sVibrate.isChecked());
            }
            else
            {
                Toast.makeText(this, "Vibrate is OFF", Toast.LENGTH_SHORT).show();
                SaveData.setVibrate(sVibrate.isChecked());

            }
        }



    public void changeSound(View v)
    {
        if(sSound.isChecked())
        {
            Toast.makeText(this, "Sound is ON", Toast.LENGTH_SHORT).show();
            SaveData.setSound(sSound.isChecked());
        }
        else
        {
            Toast.makeText(this, "Sound is OFF", Toast.LENGTH_SHORT).show();
            SaveData.setSound(sSound.isChecked());

        }
    }



        public void resetBtn(View v)
        {
            registerReceiver(receiver, new IntentFilter(FirebaseLogic.LOAD));
            FirebaseLogic.resetGame();
            Toast.makeText(this, "Game reseted", Toast.LENGTH_SHORT).show();
        }

        private BroadcastReceiver receiver = new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                unregisterReceiver(receiver);
            }
        };




        public void goToGame(View v)
        {
            Intent intent = new Intent(this, OptionsActivity.class);
            startActivity(intent);
        }
};
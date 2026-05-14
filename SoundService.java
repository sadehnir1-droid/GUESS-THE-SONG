package com.nirs.guessthesong;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundService
{
    private static SoundPool soundpool;
    private static float volume;
    public static int playOk;
    public static int playWrong;

    public static void setValue(Context context)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            soundpool = new SoundPool.Builder().setMaxStreams(20).build();
        }
        else
        {
            soundpool = new SoundPool(20, AudioManager.STREAM_MUSIC, 1);
        }
        volume = 1;
        playOk = soundpool.load(context,R.raw.entry,1);
        playWrong = soundpool.load(context,R.raw.fail, 1);

    }

    public static void playSoundWrong()
    {
        if(SaveData.isSound())
        {
            soundpool.play(playWrong, volume, volume, 1, 0, 1);
        }
    }

    public static void playSoundOk()
    {
        if(SaveData.isSound())
        {
            soundpool.play(playOk,volume,volume,1,0,1);
        }
    }


}



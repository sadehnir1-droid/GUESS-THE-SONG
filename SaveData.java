package com.nirs.guessthesong;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveData
{
    private static SharedPreferences sp;
    private static SharedPreferences.Editor edit;

    private static final String YEAR_VALUE_KEY = "year";
    private static final String GENRE_VALUE_KEY = "genre";
    private static final String ARTIST_VALUE_KEY = "artist";
    private static final String VALUE_KEY = "value";
    private static final String VIBRATE_KEY = "vibrate";
    private static final String CATEGORY_KEY = "category";
    private static final String AUDIO_OR_LYRICS_KEY = "audioOrLyrics";
    private static final String SOUND_KEY = "sound";

    private static boolean sound ;
    private static String category = " ";
    private static String year_value = " ";
    private static String genre_value = " ";
    private static String artist_value = " ";
    private static String value = " ";
    private static String audioOrLyrics = "audio";
    private static boolean vibrate;



    public static void init(Context context)
    {
        sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        edit = sp.edit();
        category = sp.getString(CATEGORY_KEY, "");
        artist_value = sp.getString(ARTIST_VALUE_KEY, "");
        year_value = sp.getString(YEAR_VALUE_KEY, "");
        genre_value = sp.getString(GENRE_VALUE_KEY, "");

        audioOrLyrics = sp.getString(AUDIO_OR_LYRICS_KEY, "audio");
        vibrate = sp.getBoolean(VIBRATE_KEY,true);
    }


    public static String returnYearValue() {
        return year_value;
    }


    public static void setYearValue(String value)
    {
        SaveData.year_value = value;
        edit.putString(YEAR_VALUE_KEY,value);
        edit.apply();
    }


    public static String returnGenreValue() {
        return genre_value;
    }

    public static void setGenreValue(String value)
    {
        SaveData.genre_value = value;
        edit.putString(GENRE_VALUE_KEY,value);
        edit.apply();
    }

    public static String returnArtistValue() {
        return artist_value;
    }

    public static void setArtistValue(String value)
    {
        SaveData.artist_value = value;
        edit.putString(ARTIST_VALUE_KEY,value);
        edit.apply();
    }




    public static String returnValue()
    {
        if(category.equals("Genre"))
        {
            value = returnGenreValue();
        }

        if(category.equals("Year"))
        {
            value = returnYearValue();
        }
        if(category.equals("Artist"))
        {
            value = returnArtistValue();
        }

        return value;
    }

    public static void setValue(String value)
    {
        SaveData.value = value;
        edit.putString(VALUE_KEY,value);
        edit.apply();
    }


    public static String returnCategory() {
        return category;
    }

    public static void setCategory(String category)
    {
        SaveData.category = category;
        edit.putString(CATEGORY_KEY, category);
        edit.apply();
    }



    public static String returnAudioOrLyrics()
    {
        return audioOrLyrics;
    }

    public static void setAudioOrLyrics(String choice)
    {
        SaveData.audioOrLyrics = choice;
        edit.putString(AUDIO_OR_LYRICS_KEY, choice);
        edit.apply();
    }



    public static boolean isVibrate() {
        return vibrate;
    }

    public static void setVibrate(boolean vibrate) {
        SaveData.vibrate = vibrate;
        edit.putBoolean(VIBRATE_KEY,vibrate);
        edit.commit();
    }


    public static boolean isSound() {
        return sound;
    }

    public static void setSound(boolean sound) {
        SaveData.sound = sound;
        edit.putBoolean(SOUND_KEY,sound);
        edit.commit();
    }
}
package com.nirs.guessthesong;

import java.util.HashMap;
import java.util.Map;

public class Song
{
    private String name;
    private int year;
    private String genre;
    private String fileAudioName;
    private String lyrics;
    private String artist;
    private boolean isGuessed;



    public Song(String name, int year, String genre, String fileAudioName, String lyrics, String artist)
    {
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.fileAudioName = fileAudioName;
        this.lyrics = lyrics;
        this.artist = artist;
        this.isGuessed = false;
    }

    public Song(String name, int year, String genre, String fileAudioName, String lyrics, String artist, boolean isGuessed)
    {
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.fileAudioName = fileAudioName;
        this.lyrics = lyrics;
        this.artist = artist;
        this.isGuessed = isGuessed;
    }

    public Song()
    {

    }

    public Song(Map<String, Object> map)
    {
        this.name = (String) map.get("name");
        this.year = (int) map.get("year");
        this.genre = (String) map.get("genre");
        this.fileAudioName = (String) map.get("fileAudioName");
        this.lyrics = (String) map.get("lyrics");
        this.artist = (String) map.get("artist");
        this.isGuessed = (boolean) map.get("isGuessed");
    }

    public Map<String, Object> getMap()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name" , name);
        map.put("year" , year);
        map.put("genre" , genre);
        map.put("fileAudioName" , (fileAudioName.toLowerCase()).replace(" ", "_"));
        map.put("lyrics" , lyrics);
        map.put("artist" , artist);
        map.put("isGuessed" , isGuessed);
        return map;
    }

    public void setFileAudioName(String fileAudioName) {this.fileAudioName = fileAudioName;}


    public void setName(String name) {this.name = name;}

    public void setYear(int year) {this.year = year;}


    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public void setIsGuessed(boolean isGuessed){this.isGuessed = isGuessed;}

    public String getFileAudioName()
    {
        return this.fileAudioName;
    }


    public String getName()
    {
        return this.name;
    }

    public int getYear()
    {
        return this.year;
    }


    public String getGenre()
    {
        return this.genre;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public boolean getIsGuessed() {return this.isGuessed;}


    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }
}
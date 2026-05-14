package com.nirs.guessthesong;

import java.util.ArrayList;

public class Songs {
    private ArrayList<Song> songs;

    public Songs()
    {
        this.songs = new ArrayList<>();
    }


    public void addSongs(Song s) {
        songs.add(s);
    }

    public void removeSong(int number) {songs.remove(number);}

    public ArrayList<Song> getAll() {
        return songs;
    }

    public Song getSong(int number) {
        return songs.get(number);
    }

    public int getSize()
    {
        return songs.size();
    }

    public void create() {
        songs.add(new Song("Space Oddity", 1969, "ROCK", "Space Oddity", "Ground control to Major Tom\nTake your protein pills and put your helmet on", "David Bowie"));
        songs.add(new Song("Starman", 1972, "ROCK", "Starman", "Didn't know what time it was, the lights were low\nI leaned back on my radio\nSome cat was layin' down some rock 'n' roll\nLotta soul, he said", "David Bowie"));
        songs.add(new Song("Let's Dance", 1983, "ROCK", "Lets Dance", "Let's dance\nPut on your red shoes and dance the blues", "David Bowie"));


        songs.add(new Song("Wonderwall", 1995, "BRITPOP", "Wonderwall", "Today is gonna be the day that they're gonna throw it back to you\nBy now, you should've somehow realised what you gotta do\nI don't believe that anybody feels the way I do about you now", "Oasis"));
        songs.add(new Song("Supersonic", 1994, "BRITPOP", "Supersonic", "I need to be myself\nI can't be no one else", "Oasis"));
        songs.add(new Song("Don't Look Back in Anger", 1995, "BRITPOP", "Dont Look Back in Anger", "Slip inside the eye of your mind\nDon't you know you might\nfind A better place to play", "Oasis"));
        songs.add(new Song("Live Forever", 1994, "BRITPOP", "Live Forever", "Maybe I don't really want to know\nHow your garden grows, 'cause I just want to fly", "Oasis"));


        songs.add(new Song("Lithium", 1991, "GRUNGE", "Lithium", "I'm so happy 'cause today I've found my friends\nThey're in my head", "Nirvana"));
        songs.add(new Song("Come as You Are", 1991, "GRUNGE", "Come as You Are", "Come as you are, as you were\nAs I want you to be", "Nirvana"));
        songs.add(new Song("Smells Like Teen Spirit", 1991, "GRUNGE", "Smells Like Teen Spirit", "Load up on guns, bring your friends\nIt's fun to lose and to pretend", "Nirvana"));
        songs.add(new Song("About a Girl", 1989, "GRUNGE", "About a Girl", "I need an easy friend\nI do, with an ear to lend", "Nirvana"));

        songs.add(new Song("Bohemian Rhapsody", 1975, "ROCK", "Bohemian Rhapsody", "Is this the real life?\nIs this just fantasy?\nCaught in a landslide, no escape from reality", "Queen"));
        songs.add(new Song("We Will Rock You", 1977, "ROCK", "We Will Rock You", "Buddy, you're a boy, make a big noise\nPlayin' in the street, gonna be a big man someday", "Queen"));
        songs.add(new Song("The Show Must Go On", 1991, "ROCK", "The Show Must Go On", "Empty spaces, what are we living for\nAbandoned places, I guess we know the score", "Queen"));
        songs.add(new Song("Don't Stop Me Now", 1978, "ROCK", "Dont Stop Me Now", "Tonight I'm gonna have myself a real good time\nI feel alive", "Queen"));
        songs.add(new Song("I Want to Break Free", 1984, "ROCK", "I Want to Break Free", "I want to break free\nI want to break free", "Queen"));
        songs.add(new Song("Hammer to Fall", 1984, "ROCK", "Hammer to Fall", "Here we stand or here we fall\nHistory won't care at all", "Queen"));
        songs.add(new Song("We Are the Champions", 1977, "ROCK", "We Are the Champions", "I've paid my dues\nTime after time", "Queen"));

        songs.add(new Song("Wish You Were Here", 1975, "PROGRESSIVE ROCK", "Wish You Were Here", "So, so you think you can tell\nHeaven from Hell?", "Pink Floyd"));
        songs.add(new Song("Comfortably Numb", 1979, "PROGRESSIVE ROCK", "Comfortably Numb", "Hello?\nIs there anybody in there?\nJust nod if you can hear me", "Pink Floyd"));
        songs.add(new Song("Time", 1973, "PROGRESSIVE ROCK", "Time", "Ticking away the moments that make up a dull day\nYou fritter and waste the hours in an offhand way", "Pink Floyd"));
        songs.add(new Song("Another Brick in the Wall", 1979, "PROGRESSIVE ROCK", "Another Brick in the Wall", "We don't need no education\nWe don't need no thought control", "Pink Floyd"));
        songs.add(new Song("Shine On You Crazy Diamond", 1975, "PROGRESSIVE ROCK", "Shine On You Crazy Diamond", "Remember when you were young\nYou shone like the sun", "Pink Floyd"));
        songs.add(new Song("Money", 1973, "PROGRESSIVE ROCK", "Money", "Money\nGet away\nYou get a good job with more pay and you're okay", "Pink Floyd"));
        songs.add(new Song("Hey You", 1979, "PROGRESSIVE ROCK", "Hey You", "Hey you, out there in the cold\nGetting lonely, getting old\nCan you feel me?", "Pink Floyd"));
        songs.add(new Song("Us and Them", 1973, "PROGRESSIVE ROCK", "Us and Them", "Us, and them\nAnd after all, we're only ordinary men", "Pink Floyd"));
        songs.add(new Song("High Hopes", 1994, "PROGRESSIVE ROCK", "High Hopes", "Beyond the horizon of the place we lived when we were young\nIn a world of magnets and miracles", "Pink Floyd"));
        songs.add(new Song("Breathe", 1973, "PROGRESSIVE ROCK", "Breathe", "Breathe, breathe in the air\nDon't be afraid to care", "Pink Floyd"));



        songs.add(new Song("Back in Black", 1980, "ROCK", "Back in Black", "Back in black\nI hit the sack\nI've been too long, I'm glad to be back", "AC/DC"));
        songs.add(new Song("Highway to Hell", 1979, "ROCK", "Highway to Hell", "Living easy, living free\nSeason ticket on a one-way ride", "AC/DC"));
        songs.add(new Song("Thunderstruck", 1990, "ROCK", "Thunderstruck", "I was caught\nIn the middle of a railroad track", "AC/DC"));


        songs.add(new Song("Sunday Bloody Sunday", 1983, "ROCK", "Sunday Bloody Sunday", "I can't believe the news today\nOh, I can't close my eyes and make it go away", "U2"));
        songs.add(new Song("One", 1991, "ROCK", "One", "Is it getting better\nOr do you feel the same?\nWill it make it easier on you\nNow you got someone to blame?", "U2"));
        songs.add(new Song("Pride", 1984, "ROCK", "Pride", "One man come in the name of love\nOne man come and go", "U2"));
        songs.add(new Song("Mysterious Ways", 1991, "ROCK", "Mysterious Ways", "Johnny take a walk with your sister the moon\nLet her pale light in to fill up your room", "U2"));
        songs.add(new Song("Beautiful Day", 2000, "ROCK", "Beautiful Day", "The heart is a bloom\nShoots up through the stony ground", "U2"));
        songs.add(new Song("With or Without You", 1987, "ROCK", "With or Without You", "See the stone set in your eyes\nSee the thorn twist in your side", "U2"));

        songs.add(new Song("Californication", 1999, "ALTERNATIVE ROCK", "Californication", "Psychic spies from China\nTry to steal your mind's elation", "Red Hot Chili Peppers"));
        songs.add(new Song("Under the Bridge", 1992, "ALTERNATIVE ROCK", "Under the Bridge", "Sometimes I feel like I don't have a partner\nSometimes I feel like my only friend", "Red Hot Chili Peppers"));
        songs.add(new Song("Scar Tissue", 1999, "ALTERNATIVE ROCK", "Scar Tissue", "Scar tissue that I wish you saw\nSarcastic mister know-it-all", "Red Hot Chili Peppers"));
        songs.add(new Song("Otherside", 1999, "ALTERNATIVE ROCK", "Otherside", "How long, how long will I slide?\nSeparate my side, I don't", "Red Hot Chili Peppers"));
        songs.add(new Song("By the Way", 2002, "ALTERNATIVE ROCK", "By the Way", "Standing in line\nTo see the show tonight", "Red Hot Chili Peppers"));
        songs.add(new Song("Dani California", 2006, "ALTERNATIVE ROCK", "Dani California", "Gettin' born in the state of Mississippi\nPapa was a copper and mama was a hippie", "Red Hot Chili Peppers"));
        songs.add(new Song("Can't Stop", 2002, "ALTERNATIVE ROCK", "Cant Stop", "Can't stop, addicted to the shindig\nChop top, he says I'm gonna win big", "Red Hot Chili Peppers"));
        songs.add(new Song("Snow", 2006, "ALTERNATIVE ROCK", "Snow", "Come to decide that the things that I tried\nWere in my life just to get high on", "Red Hot Chili Peppers"));
        songs.add(new Song("Give It Away", 1991, "FUNK ROCK", "Give It Away", "What I got, you gotta give it to your mama\nWhat I got, you gotta give it to your papa", "Red Hot Chili Peppers"));


        songs.add(new Song("Sweet Child o' Mine", 1987, "ROCK", "Sweet Child o Mine", "She's got a smile that it seems to me\nReminds me of childhood memories", "Guns N' Roses"));
        songs.add(new Song("Welcome to the Jungle", 1987, "HARD ROCK", "Welcome to the Jungle", "Welcome to the jungle, we got fun and games", "Guns N' Roses"));
        songs.add(new Song("Paradise City", 1987, "ROCK", "Paradise City", "Take me down to the paradise city,\nWhere the grass is green and the girls are pretty", "Guns N' Roses"));
        songs.add(new Song("Don't Cry", 1991, "ROCK", "Dont Cry", "Talk to me softly, there's something in your eyes\nDon't hang your head in sorrow and please don't cry", "Guns N' Roses"));
        songs.add(new Song("November Rain", 1991, "ROCK", "November Rain", "When I look into your eyes\nI can see a love restrained", "Guns N' Roses"));

        songs.add(new Song("Yellow", 2000, "ALTERNATIVE ROCK", "Yellow", "Look at the stars, look how they shine for you", "Coldplay"));
        songs.add(new Song("Fix You", 2005, "ALTERNATIVE ROCK", "Fix You", "When you try your best, but you don't succeed", "Coldplay"));
        songs.add(new Song("Viva La Vida", 2008, "ALTERNATIVE ROCK", "Viva La Vida", "I used to rule the world\nSeas would rise when I gave the word", "Coldplay"));
        songs.add(new Song("Clocks", 2002, "ALTERNATIVE ROCK", "Clocks", "The lights go out and I can't be saved", "Coldplay"));
        songs.add(new Song("The Scientist", 2002, "ALTERNATIVE ROCK", "The Scientist", "Come up to meet you, tell you I'm sorry", "Coldplay"));
        songs.add(new Song("Paradise", 2011, "ALTERNATIVE ROCK", "Paradise", "When she was just a girl\nShe expected the world", "Coldplay"));
        songs.add(new Song("Adventure of a Lifetime", 2015, "POP ROCK", "Adventure of a Lifetime", "Turn your magic on, to me she'd say\nEverything you want's a dream away", "Coldplay"));
        songs.add(new Song("A Sky Full of Stars", 2014, "POP ROCK", "A Sky Full of Stars", "'Cause you're a sky, 'cause you're a sky full of stars", "Coldplay"));
        songs.add(new Song("Magic", 2014, "POP ROCK", "Magic", "Call it magic, call it true\nI call it magic when I'm with you", "Coldplay"));
    }
}
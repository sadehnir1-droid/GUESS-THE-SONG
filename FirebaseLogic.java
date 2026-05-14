package com.nirs.guessthesong;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class FirebaseLogic
{
    public static final String LOAD = "Load songs";
    private static FirebaseAuth mAuth;
    public  static Songs songs;
    private static  String uid;
    private static Context context;


    public static void init(Context c)
    {
        mAuth = FirebaseAuth.getInstance();
        context = c;
    }



    public static void readUserData()
    {
        uid = mAuth.getCurrentUser().getUid();
        ArrayList<Map> list = new ArrayList<>();
        songs = new Songs();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(uid).collection("songs")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if(task.isSuccessful())
                {
                    for(QueryDocumentSnapshot document : task.getResult())
                    {
                       // Map<String ,Object> map = document.getData();
                        Song song = document.toObject(Song.class);
                        songs.addSongs(song);
                    }
                    /*
                    used for creating a new database for a user
                     */
                   // writeAllData(list);
                }
                else
                {

                }
            }
        });
    }




    public static void readAllData()
    {
        ArrayList<Map> list = new ArrayList<>();
        songs = new Songs();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Master").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if(task.isSuccessful())
                {
                    for(QueryDocumentSnapshot document : task.getResult())
                    {
                        Map<String ,Object> map = document.getData();
                        list.add(map);
                        /*
                        used for creating the ArrayList
                         */
                        //songs.addSongs(new Song(map));
                    }
                   writeAllData(list);
                }
                else
                {

                }
            }
        });
    }

    public static void writeAllData(ArrayList<Map> list)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();
        for (Map map : list)
        {
            db.collection("Users").document(uid).collection("songs")
                    .document().set(map).addOnCompleteListener(new OnCompleteListener()
                    {
                        @Override
                        public void onComplete(@NonNull Task task)
                        {

                        }
                    });
        }
    }


    //add all data to master
    public static void writeAllData(Songs songs)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        for(int i = 0; i < songs.getAll().size() ;i++)
        {
            Song song = (Song) songs.getAll().get(i);
            Map<String ,Object> map = song.getMap();
            db.collection("Master")
                    .document().set(map).addOnCompleteListener(new OnCompleteListener()
                    {
                        @Override
                        public void onComplete(@NonNull Task task)
                        {

                        }
                    });
        }
    }




    public static Songs getSongs()
    {
        return songs;
    }





    public static void getSongsByGenre(String genreType)
    {
        songs = new Songs();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid).collection("songs")
                .whereEqualTo("genre", genreType)
                .whereEqualTo("isGuessed", false)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                Song song = document.toObject(Song.class);
                                songs.addSongs(song);
                            }
                            context.sendBroadcast(new Intent(LOAD));
                        }
                        else
                        {
                            Log.e("FirebaseLogic", "Error fetching songs", task.getException());
                        }
                    }
                });
    }







    public static void  getSongsByArtist(String artistName)
    {
        songs = new Songs();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid).collection("songs")
                .whereEqualTo("artist", artistName)
                .whereEqualTo("isGuessed", false)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                Song song = document.toObject(Song.class);
                                songs.addSongs(song);
                            }
                            context.sendBroadcast(new Intent(LOAD));
                        }
                        else
                        {
                            Log.e("FirebaseLogic", "Error fetching songs", task.getException());
                        }
                    }
                });
    }









    public static void getSongsByYear(int year)
    {
        songs = new Songs();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid).collection("songs")
                .whereEqualTo("isGuessed", false)
                .whereEqualTo("year", year)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                Song song = document.toObject(Song.class);
                                songs.addSongs(song);
                            }
                            context.sendBroadcast(new Intent(LOAD));
                        }
                        else
                        {
                            Log.e("FirebaseLogic", "Error fetching songs", task.getException());
                        }
                    }
                });
    }




    public static void markSongAsGuessedForUser(String songName)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid).collection("songs")
                .whereEqualTo("name", songName)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                       for (QueryDocumentSnapshot document : queryDocumentSnapshots)
                       {
                            db.collection("Users").document(uid)
                                    .collection("songs").document(document.getId())
                                    .update("isGuessed", true);
                       }
                        context.sendBroadcast(new Intent(LOAD));
                })
                .addOnFailureListener(e -> Log.e("Firestore", "Error fetching song", e));
    }



    public static void resetGame()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        db.collection("Users").document(uid).collection("songs")
                .whereEqualTo("isGuessed", true)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (QueryDocumentSnapshot document : queryDocumentSnapshots)
                    {
                        db.collection("Users").document(uid)
                                .collection("songs").document(document.getId())
                                .update("isGuessed", false);
                    }
                    context.sendBroadcast(new Intent(LOAD));
                })
                .addOnFailureListener(e -> Log.e("Firestore", "Error fetching song", e));
    }
}
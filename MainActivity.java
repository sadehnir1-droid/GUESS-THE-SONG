package com.nirs.guessthesong;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static FirebaseAuth mAuth;
    private ImageView img;
    private EditText eUser;
    private EditText ePass;
    private Songs songs = new Songs();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnLgn);
        SoundService.setValue(this);

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String mail = "b@gmail.com";
                String password = "123123";
                login(mail, password);
                return true;
            }
        });

        eUser = findViewById(R.id.eUserName);
        ePass = findViewById(R.id.eUserPassword);
        mAuth = FirebaseAuth.getInstance();



        img = findViewById(R.id.imgLogo);
        img.setY(1000f);
        timer.start();
    }

    float alpha = 0f;
    CountDownTimer timer = new CountDownTimer(4000, 100) {
        @Override
        public void onTick(long l) {
            alpha += +10f;
            img.setY(alpha);
        }

        @Override
        public void onFinish() {
            img.setScaleX(1);
            img.setScaleY(1);
        }
    };


    private void login(String mail, String password) {

        String n = eUser.getText().toString();
        String p = ePass.getText().toString();

        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseLogic.init(MainActivity.this);
                    FirebaseLogic.readUserData();
                    Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                    SoundService.playSoundOk();

                    startActivity(intent);
                } else {
                    SoundService.playSoundWrong();
                    Toast.makeText(MainActivity.this, "Fail: " + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void login(View v) {


        String n = eUser.getText().toString().trim();
        String p = ePass.getText().toString().trim();


        if (n.isEmpty() || p.isEmpty())
        {
            SoundService.playSoundWrong();
            Toast.makeText(MainActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            login(n, p);
        }

    }


    public void createNewAccount(View v)
    {
        String mail = eUser.getText().toString().trim();
        String password = ePass.getText().toString().trim();
        if (mail.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            songs.create();
            mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        FirebaseLogic.init(MainActivity.this);
                        /*
                        for creating the database for the first time
                         */
                        //FirebaseLogic.writeAllData(songs);
                        FirebaseLogic.readAllData();

                        SoundService.playSoundOk();
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        SoundService.playSoundWrong();
                        Toast.makeText(MainActivity.this, "Fail: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }
}
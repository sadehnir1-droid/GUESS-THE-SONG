package com.nirs.guessthesong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;


public class OptionsActivity extends AppCompatActivity
{
    private static FirebaseAuth mAuth;
    private Spinner spinner;
    private String selectedCategory;
    private String selectedValue;
    private String isLyricsOrAudio ;
    private Button playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        SaveData.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        String[] decadeArray = getResources().getStringArray(R.array.years_list);

        selectedCategory = SaveData.returnCategory();
        selectedValue = SaveData.returnValue();
        isLyricsOrAudio = SaveData.returnAudioOrLyrics();


        TextInputLayout textYear = findViewById(R.id.yearOption);
        TextInputLayout textArtist = findViewById(R.id.artistOption);
        TextInputLayout textGenre = findViewById(R.id.genreOption);
        playBtn = findViewById(R.id.playBtn);
        RadioGroup radioGroup = findViewById(R.id.typeOption);
        spinner = findViewById(R.id.spinner);



        MaterialAutoCompleteTextView autoCompleteTextViewGenre = findViewById(R.id.genreTV);
        MaterialAutoCompleteTextView autoCompleteTextViewArtist = findViewById(R.id.artistTV);
        MaterialAutoCompleteTextView autoCompleteTextViewYear = findViewById(R.id.yearTV);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        if (selectedCategory != null && !selectedCategory.isEmpty())
        {
            int spinnerPosition = adapter.getPosition(selectedCategory);
            spinner.setSelection(spinnerPosition);
        }


        if (isLyricsOrAudio.equals("audio"))
        {
            radioGroup.check(R.id.radioButtonAudio);
        }
        else
        {
            radioGroup.check(R.id.radioButtonLyrics);
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (checkedId == R.id.radioButtonAudio)
                {
                    isLyricsOrAudio = "audio";
                }
                else if (checkedId == R.id.radioButtonLyrics)
                {
                    isLyricsOrAudio = "lyrics";
                }
                SaveData.setAudioOrLyrics(isLyricsOrAudio); // Save radio group choice

            }
        });





        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                selectedCategory = parentView.getItemAtPosition(position).toString();
                SaveData.setCategory(selectedCategory);

                switch (position)
                {
                    case 0:
                        textArtist.setEnabled(false);
                        textYear.setEnabled(false);
                        textGenre.setEnabled(true);
                        autoCompleteTextViewGenre.setText(SaveData.returnGenreValue(), false);
                        break;
                    case 1:
                        textArtist.setEnabled(true);
                        textYear.setEnabled(false);
                        textGenre.setEnabled(false);
                        autoCompleteTextViewArtist.setText(SaveData.returnArtistValue(), false);
                        break;
                    case 2:
                        textArtist.setEnabled(false);
                        textYear.setEnabled(true);
                        textGenre.setEnabled(false);
                        autoCompleteTextViewYear.setText(SaveData.returnYearValue(), false);
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                textArtist.setEnabled(false);
                textYear.setEnabled(false);
                textGenre.setEnabled(false);
            }
        });





        autoCompleteTextViewGenre.setOnItemClickListener((parent, view, position, id) ->
        {
            selectedValue = (String) parent.getItemAtPosition(position);
            SaveData.setGenreValue(selectedValue);
            SaveData.setValue(selectedValue);
        });


        autoCompleteTextViewArtist.setOnItemClickListener((parent, view, position, id) ->
        {
            selectedValue = (String) parent.getItemAtPosition(position);
            SaveData.setArtistValue(selectedValue);
            SaveData.setValue(selectedValue);
        });


        autoCompleteTextViewYear.setOnItemClickListener((parent, view, position, id) ->
        {
            selectedValue = (String) parent.getItemAtPosition(position);
            SaveData.setYearValue(selectedValue);
            SaveData.setValue(selectedValue);
        });
    }






    public void goToSettings(View v)
    {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }



    public void goToPlay(View v)
    {
        selectedValue = SaveData.returnValue();
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("lyricsOrAudio", isLyricsOrAudio);
        intent.putExtra("selectedValue", selectedValue);
        intent.putExtra("selectedCategory", selectedCategory);
        startActivity(intent);
    }


    public void goToActivity(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
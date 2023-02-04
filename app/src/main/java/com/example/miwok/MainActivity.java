package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NumbersClickListener clickListener = new NumbersClickListener();
        //Find the view that shows the numbers category
        TextView numbers = findViewById(R.id.numbers);
        // Set a clickListener on that View
        numbers.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent Number = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(Number);

            }
        });



        TextView color = findViewById(R.id.colors);
        // Set a clickListener on that View
        color.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent color = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(color);

            }
        });

        TextView family = findViewById(R.id.family);
        // Set a clickListener on that View
        family.setOnClickListener(this);

        TextView phrases = findViewById(R.id.phrases);
        // Set a clickListener on that View
        phrases.setOnClickListener(this);




//    public void openNumbersList(View view){
//        Intent Number = new Intent(this, NumbersActivity.class);
//        startActivity(Number);
//    }

//    public void openFamilyList(View view){
//        Intent Family = new Intent(this, FamilyMembersActivity.class);
//        startActivity(Family);
//    }
//
//    public void openColorList(View view){
//        Intent Color = new Intent(this, ColorsActivity.class);
//        startActivity(Color);
//    }
//
//    public void openPhraseList(View view){
//        Intent Phrase = new Intent(this, PhrasesActivity.class);
//        startActivity(Phrase);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phrases:
                Intent family = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(family);
                break;
            case R.id.family:
                Intent family1 = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(family1);
                break;
        }
    }
}
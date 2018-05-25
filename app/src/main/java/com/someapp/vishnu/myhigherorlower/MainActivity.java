package com.someapp.vishnu.myhigherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Integer randomNumber = 0;

    public void onClick(View view){

        Log.i("Info", "Button pressed");
        if(randomNumber==0) {
            Random rand = new Random(); // Random object to call nextInt()
            randomNumber = rand.nextInt(20) + 1; // Put + 1 next to it for the minimum
        }

        EditText numberGuess = findViewById(R.id.numberEntered);
        String guessString = numberGuess.getText().toString();

        if (guessString.length() == 0) {
            Toast.makeText(this, "Enter a number value before pressing the button",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        for (int i = 0; i < guessString.length(); i++) {
            if (!Character.isDigit(guessString.charAt(i))) {
                Toast.makeText(this,
                        "Only enter number values", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        Log.i("Guess", guessString);

        Integer guessValue = Integer.parseInt(guessString);

        if (guessValue < randomNumber) {
            Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT).show();
        } else if (guessValue > randomNumber) {
            Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Correct!" + " it was " +
                            randomNumber.toString() + "."
                        , Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.example.renanrhoden.appwheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] movements = {
            "Direções", "Aceleração"
    };
    private String[] movementsDescription = {
            "Para alterar direções, incline o dispositivo para os lados.",
            "Para acelerar ou dar ré, incline o dispositivo para frente ou para trás."
    };
    private int tutorialScreenNumber = 0;
    private TextView movementText;
    private TextView descriptionText;
    private ImageView tutorialImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movementText = (TextView) findViewById(R.id.headerText);
        descriptionText = (TextView) findViewById(R.id.descriptionText);
        tutorialImage = (ImageView) findViewById(R.id.exampleImage);

        movementText.setText(movements[tutorialScreenNumber]);
        descriptionText.setText(movementsDescription[tutorialScreenNumber]);
        tutorialImage.setImageResource(R.drawable.directions_image);
    }

    public void nextTutorialScreen(View view) {
        if (++tutorialScreenNumber < movements.length) {
            movementText.setText(movements[tutorialScreenNumber]);
            descriptionText.setText(movementsDescription[tutorialScreenNumber]);
            tutorialImage.setImageResource(R.drawable.accelerating_image);
        } else {
            tutorialScreenNumber--;
            movementText.setText(movements[tutorialScreenNumber]);
            descriptionText.setText(movementsDescription[tutorialScreenNumber]);
        }
    }

    public void backTutorialScreen(View view) {
        if (--tutorialScreenNumber >= 0) {
            movementText.setText(movements[tutorialScreenNumber]);
            descriptionText.setText(movementsDescription[tutorialScreenNumber]);
            tutorialImage.setImageResource(R.drawable.directions_image);
        } else {
            tutorialScreenNumber++;
            movementText.setText(movements[tutorialScreenNumber]);
            descriptionText.setText(movementsDescription[tutorialScreenNumber]);
        }
    }
}

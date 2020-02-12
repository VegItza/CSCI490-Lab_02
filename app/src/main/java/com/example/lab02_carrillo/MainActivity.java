package com.example.lab02_carrillo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public static final int RESPONSE_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button homeButton = findViewById(R.id.button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
    }

    public void openSecondActivity() {
        final Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ConstraintLayout currentLayout = findViewById(R.id.mainLayout);
        if (requestCode == REQUEST_CODE && resultCode == RESPONSE_CODE) {
                int imageID = data.getExtras().getInt("imageID");
                currentLayout.setBackground(getDrawable(imageID));
        }
    }


}

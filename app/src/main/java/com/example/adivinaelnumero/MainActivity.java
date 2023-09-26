package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = random_num();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this /* MyActivity */, text, duration);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                toast.show();
            }
        });

    }

    static int random_num() {
        int randomNumber = (int) (Math.random() * (100 - 1) + 1);
        return randomNumber;
    }

}
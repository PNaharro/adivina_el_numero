package com.example.adivinaelnumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    int altnum = randnum();
    int intentos=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CharSequence text = "";
                int duration = Toast.LENGTH_SHORT;
                // Code here executes on main thread after user presses button
                EditText et = findViewById(R.id.introducido);
                int num = Integer.parseInt(String.valueOf(et.getText()));

                if (num<altnum) {
                    text = "El numero a adivinar es mas grande a " + num;

                } else  if (altnum<num){
                    text = "El numero a adivinar es mas pequeno a " + num;
                }
                Toast toast = Toast.makeText(MainActivity.this /* MyActivity */, text, duration);

                if (num==altnum){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("has ganado");
                    builder.setTitle("Ganador !");
                    builder.setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                        recreate();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    TextView men = findViewById(R.id.mesajes);
                    String contnum = String.valueOf(men.getText());
                    String add = num+"\n"+contnum;
                    men.setText(add);
                    intentos++;
                    TextView ints = findViewById(R.id.id_intentos);
                    String addint = "Intentos = "+intentos;
                    ints.setText(addint);
                    toast.show();
                    et.setText("");
                }
            }
        });

    }





    static int randnum() {
        int randomNumber = (int) (Math.random() * (100 - 1) + 1);
        return randomNumber;
    }

}
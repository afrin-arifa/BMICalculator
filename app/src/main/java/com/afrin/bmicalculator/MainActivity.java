package com.afrin.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculateBmi;

    TextView currentHeight;
    TextView currentAge, currentWeight;
    ImageView incrementAge,incrementWeight,decrementAge,decrementWeight;
    SeekBar seekbarForHeight;

    RelativeLayout male,female;

    int intWeight = 55;
    int intAge = 22;
    int currentProgress;

    String intProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2  = "22";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        calculateBmi = findViewById(R.id.calculatorBmi);
        currentHeight = findViewById(R.id.currentHeight);
        currentAge = findViewById(R.id.currentAge);
        currentWeight = findViewById(R.id.currentWeight);
        incrementAge = findViewById(R.id.incrementAge);
        decrementAge = findViewById(R.id.decrementAge);
        incrementWeight = findViewById(R.id.incrementWeight);
        decrementWeight = findViewById(R.id.decrementWeight);
        seekbarForHeight = findViewById(R.id.seekerBarForHeight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);




        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));

                typeOfUser = "Male";


            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_not_focus));

                typeOfUser = "Female";


            }
        });

        seekbarForHeight.setMax(300);
        seekbarForHeight.setProgress(170);
        seekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgress= progress;
                intProgress = String.valueOf(currentProgress);
                currentHeight.setText(intProgress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge+1;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });


        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge-1;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight+1;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight-1;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });


        calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeOfUser.equals("0")){

                    Toast.makeText(MainActivity.this, "Select Your Gender First..", Toast.LENGTH_SHORT).show();
                }else if (intProgress.equals("0")){

                    Toast.makeText(MainActivity.this, "Select Your Height First..", Toast.LENGTH_SHORT).show();
                }else if (intAge == 0 || intAge<0){

                    Toast.makeText(MainActivity.this, "Age IS Incorrect..", Toast.LENGTH_SHORT).show();
                }else if (intWeight == 0 || intWeight<0){

                    Toast.makeText(MainActivity.this, "Weight IS Incorrect..", Toast.LENGTH_SHORT).show();
                }else {

                   Intent intent = new Intent(MainActivity.this,BmiActivity.class);
                   intent.putExtra("gender",typeOfUser);
                   intent.putExtra("height",intProgress);
                   intent.putExtra("weight",weight2);
                   intent.putExtra("age",age2);

                   startActivity(intent);


                }


            }
        });





    }
}
package com.afrin.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button reCalculator;

    TextView bmiDisplay,bmiCategory,gender;
    Intent intent;
    ImageView imageView;
    String bmi;
    float intbmi;

    String height;
    String weight;
    float intHeight,intWeight;

    RelativeLayout background;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

       // getSupportActionBar().hide();

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        imageView = findViewById(R.id.imageView);
        reCalculator = findViewById(R.id.reCalculatorBmi);
        bmiDisplay = findViewById(R.id.bmiDisplay);
        bmiCategory = findViewById(R.id.bmiCategory);
        gender = findViewById(R.id.genderDisplay);
        background =findViewById(R.id.contentLayout);


        height =intent.getStringExtra("height");
        weight =intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;
        intbmi = intWeight/(intHeight*intHeight);

        bmi = Float.toString(intbmi);


        if (intbmi<16){
            bmiCategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        }else if (intbmi<16.9 && intbmi>16){

            bmiCategory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }else if (intbmi<18.4 && intbmi>17){

            bmiCategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }else if (intbmi<25 && intbmi>18.4){

            bmiCategory.setText("Normal");
           // background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ok);
        }else if (intbmi<29.4 && intbmi>25){

            bmiCategory.setText("Over Weight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }else {
            bmiCategory.setText("Obese class 1");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);

        }

        gender.setText(intent.getStringExtra("gender"));
        bmiDisplay.setText(bmi);




        reCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(BmiActivity.this,MainActivity.class));
                finish();
            }
        });


    }
}
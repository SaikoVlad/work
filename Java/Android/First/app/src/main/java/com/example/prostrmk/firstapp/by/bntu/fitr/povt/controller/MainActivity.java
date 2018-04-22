package com.example.prostrmk.firstapp.by.bntu.fitr.povt.controller;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prostrmk.firstapp.R;
import com.example.prostrmk.firstapp.by.bntu.fitr.povt.model.Calculating;
import com.example.prostrmk.firstapp.by.bntu.fitr.povt.model.Matrix;
import com.example.prostrmk.firstapp.by.bntu.fitr.povt.model.Verification;
import com.example.prostrmk.firstapp.by.bntu.fitr.povt.util.Input;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView textView;
    Button mainbu;
    CheckBox mincheck;
    CheckBox maxcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        mainbu = (Button) findViewById(R.id.mainbutton);
        mincheck = (CheckBox) findViewById(R.id.minCheck);
        maxcheck = (CheckBox) findViewById(R.id.maxCheck);
        onClick(mainbu);



    }


    public void mainButtonPressed(View view){
        textView.setText(" ");
        //start matrix
        StringBuilder stringBuilder = new StringBuilder();
        Matrix matrix = new Matrix(5,5,Input.randomMaker(5,5,100));
        stringBuilder.append(matrix.toString());
        //matrix attributes
        stringBuilder.append("\nMax: ").append(Calculating.maxFinder(5, 5, matrix.getMatrix()));
        stringBuilder.append("\nSingle: ").append(Verification.checkForUnique(matrix.getMatrix(), 5, 5, Calculating.maxFinder(5, 5, matrix.getMatrix())));
        stringBuilder.append("\nMin: ").append(Calculating.minFinder(5, 5, matrix.getMatrix()));
        stringBuilder.append("\nSingle: ").append(Verification.checkForUnique(matrix.getMatrix(), 5, 5, Calculating.minFinder(5, 5, matrix.getMatrix())));
        //sorting
        boolean works = true;
        if (mincheck.isChecked()&&maxcheck.isChecked()){
            maxcheck.setChecked(false);
            mincheck.setChecked(false);
            works = false;
            Toast.makeText(this, "Only one checkbox must be pressed!", Toast.LENGTH_SHORT).show();
        }else if (!mincheck.isChecked() && !maxcheck.isChecked()){
            works = false;
            Toast.makeText(this, "Select sorting method", Toast.LENGTH_SHORT).show();
        }
        if (works){
            if (mincheck.isChecked()){
                matrix = new Matrix(5,5,Calculating.sort(5,5,matrix.getMatrix(),1));
            }else{
                matrix = new Matrix(5,5,Calculating.sort(5,5,matrix.getMatrix(),2));
            }
            stringBuilder.append("\n\n").append("After Sorting\n").append(matrix.toString());
        }




        textView.setText(stringBuilder.toString());

    }


    @Override
    public void onClick(View view) {

    }
}

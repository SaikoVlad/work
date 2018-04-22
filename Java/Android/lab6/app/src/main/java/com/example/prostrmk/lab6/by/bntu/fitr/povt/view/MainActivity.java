package com.example.prostrmk.lab6.by.bntu.fitr.povt.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prostrmk.lab6.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button databutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textMain);
        databutton = (Button)findViewById(R.id.buttonData);


        databutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(String.valueOf(DataWorks.class));
//
//                startActivity(intent);
            }
        });


    }

    public void sendMessage(View view) {


    }






}

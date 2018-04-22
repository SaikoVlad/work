package com.example.prostrmk.lab6.by.bntu.fitr.povt.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.prostrmk.lab6.by.bntu.fitr.povt.model.Data;

import com.example.prostrmk.lab6.R;

public class DataWorks extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editDataText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        textView = (TextView) findViewById(R.id.textData);
        button = (Button) findViewById(R.id.buttonData);
        editDataText = (EditText) findViewById(R.id.editData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int datamas[] = getTextFromEdit(editDataText.getText().toString());
                textView.setText(Data.next(datamas[0],datamas[1],datamas[2]));

            }
        });

    }


    private static int[] getTextFromEdit(String text){
        String []mas = text.split(".");

        int [] masint = new int [3];
        for (int i = 0; i < 3; i++) {
            masint[i] = Integer.parseInt(mas[i]);
        }

        return masint;
    }


}

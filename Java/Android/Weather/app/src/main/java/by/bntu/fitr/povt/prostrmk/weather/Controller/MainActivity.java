package by.bntu.fitr.povt.prostrmk.weather.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.URL;
import java.net.URLConnection;
import java.util.regex.*;

import by.bntu.fitr.povt.prostrmk.weather.R;

public class MainActivity extends AppCompatActivity {

    TextView todayText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todayText = (TextView) findViewById(R.id.todayView);



    }
}

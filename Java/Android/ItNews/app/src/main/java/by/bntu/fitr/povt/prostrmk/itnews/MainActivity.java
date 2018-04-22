package by.bntu.fitr.povt.prostrmk.itnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import by.bntu.fitr.povt.prostrmk.itnews.controller.MainController;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemNews:
                Toast.makeText(MainActivity.this, "News", Toast.LENGTH_SHORT).show();
                mainTextView = (TextView) findViewById(R.id.mainText);
                mainTextView.setText(MainController.getNews());
                return true;
            case R.id.itemProgramming:
                Toast.makeText(MainActivity.this, "Programming", Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

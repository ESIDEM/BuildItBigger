package ng.com.techdepo.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_acivity);

        Intent intent = getIntent();
        Toast.makeText(this,intent.getStringExtra("joke"),Toast.LENGTH_LONG).show();
    }
}

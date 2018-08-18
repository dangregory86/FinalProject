package gregory.dan.jokedisplaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";
    public static final String PUNCHLINE = "punchline";

    TextView jokeTv, punchlineTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE);
        String punchline = intent.getStringExtra(PUNCHLINE);

        jokeTv = findViewById(R.id.joke_activity_text);
        punchlineTv = findViewById(R.id.joke_activity_punchline_text);

        jokeTv.setText(joke);
        punchlineTv.setText(punchline);
    }
}

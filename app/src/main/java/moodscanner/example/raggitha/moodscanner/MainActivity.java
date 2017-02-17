package moodscanner.example.raggitha.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView thumbprint;
    private TextView result;
    private Runnable mRunnable;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodResults = new String[]{
                "ಉರ್ಕೊಂಡಿದೀಯ",
                "ತಿಕ ಹರ್ಕೊಂಡಿದೀಯ",
                "ಎಗರಾಡ್ತಾ ಇದ್ದೀಯ",
                "ಶಾಂತ ಸ್ವರೂಪನಾಗಿ ಇದ್ದೀಯ ",
                "ಹೀಟ್ ಗೆ  ಬಂದಿದ್ದೀಯಾ!",
                "ಗೊತ್ತಿಲ್ಲ ಮಚ್ಚಾ",
                "ಬೇಜಾರ್ ಆಗಿದ್ದೀಯಾ",
        };

        thumbprint = (ImageView) findViewById(R.id.thumbPrint);
        thumbprint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable) thumbprint.getBackground();

        result = (TextView) findViewById(R.id.resultText);

        thumbprint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                thumbAnimation.start();
               // Toast.makeText(getApplicationContext(),"Hello buddy", Toast.LENGTH_SHORT).show();
                showResult();
                return true;
            }
        });
    }

    public void showResult()
    {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int rand = (int) (Math.random()* moodResults.length);
                result.setText(moodResults[rand]);
                thumbAnimation.stop();
            }
        };

        Handler mhandler = new Handler();
        mhandler.postDelayed(mRunnable,3000);
    }
}

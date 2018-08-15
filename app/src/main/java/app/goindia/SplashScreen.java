package app.goindia;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends Activity {
TextView goindia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        goindia = (TextView) findViewById(R.id.goindia);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink);
        goindia.startAnimation(animation);
          new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  Intent home = new Intent(SplashScreen.this,Home.class);
                  startActivity(home);
              }
          },2000);

        DBHelper dbHelper = new DBHelper(SplashScreen.this);
    }
}

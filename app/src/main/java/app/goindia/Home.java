package app.goindia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity {
    CardView card_view_fycp;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
         /*Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shrink);
        flag_img.startAnimation(animation);*/
        // 1. find ur career path
        // 2. d.ob to set ur career
        // 3. after tenth & more
        // 4. find ur career through hobbies ..trending technology

         card_view_fycp  = (CardView) findViewById(R.id.card_view_fycp);
         card_view_fycp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent card_view_fycp = new Intent(Home.this,Careepath.class);
                 startActivity(card_view_fycp);
             }
         });
    }
}

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

public class Home extends Activity implements View.OnClickListener {
    CardView card_view_fycp, dob_card, aftertenth_cv;

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
        dob_card = (CardView) findViewById(R.id.dob_card);
        card_view_fycp = (CardView) findViewById(R.id.card_view_fycp);
        aftertenth_cv = (CardView) findViewById(R.id.aftertenth_cv);
        aftertenth_cv.setOnClickListener(this);
        dob_card.setOnClickListener(this);
        card_view_fycp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_view_fycp:
                Intent card_view_fycp = new Intent(Home.this, Careepath.class);
                card_view_fycp.putExtra("value", "1");
                startActivity(card_view_fycp);
                break;
            case R.id.dob_card:
                Intent dob_card = new Intent(Home.this, Careepath.class);
                dob_card.putExtra("value", "2");
                startActivity(dob_card);
                break;
            case R.id.aftertenth_cv:
                Intent add = new Intent(Home.this, Additon.class);
                add.putExtra("value", "2");
                startActivity(add);
                break;
        }
    }
}

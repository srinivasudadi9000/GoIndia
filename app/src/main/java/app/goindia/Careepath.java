package app.goindia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Careepath extends Activity {
    TextView goindia_htv;
    CardView beforetenth,aftertenth,aftertenthgvtjobs,aftertenthpvtjobs,afterinter,afterintergovtjobs,afterinterjobs;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careepath);
        goindia_htv = (TextView) findViewById(R.id.heading_tv);
        goindia_htv.setText("Find your career path");

        beforetenth = (CardView) findViewById(R.id.beforetenth);
        aftertenth = (CardView) findViewById(R.id.aftertenth);
        aftertenthgvtjobs = (CardView) findViewById(R.id.aftertenthgvtjobs);
        aftertenthpvtjobs = (CardView) findViewById(R.id.aftertenthpvtjobs);
        afterinter = (CardView) findViewById(R.id.afterinter);
        afterintergovtjobs = (CardView) findViewById(R.id.afterintergovtjobs);
        afterinterjobs = (CardView) findViewById(R.id.afterinterjobs);

        beforetenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compleview = new Intent(Careepath.this,Completeview.class);
                compleview.putExtra("path","aftertenth");
                startActivity(compleview);
            }
        });

        afterinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compleview = new Intent(Careepath.this,Completeview.class);
                compleview.putExtra("path","afterinter");
                startActivity(compleview);
            }
        });
    }


}

package app.goindia;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class Completeview extends Activity {
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completeview);

        mImageView=(ImageView)findViewById(R.id.display_img);


        switch (getIntent().getStringExtra("path")){
            case "aftertenth":
                TouchImageView img = new TouchImageView(this);
                img.setImageResource(R.drawable.mytenth);
                img.setMaxZoom(4f);
                setContentView(img);
                break;
            case "afterinter":
                TouchImageView inter = new TouchImageView(this);
                inter.setImageResource(R.drawable.after12);
                inter.setMaxZoom(4f);
                setContentView(inter);
                break;
        }


    }


}

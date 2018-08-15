package app.goindia;

import android.app.Activity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class hobbiess extends Activity {
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;

    ImageView flag_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hobbies);
        flag_img = (ImageView) findViewById(R.id.flag_img);
        mImageView = (ImageView) findViewById(R.id.display_img);

        TouchImageView img = new TouchImageView(this);
        img.setImageResource(R.drawable.hobbiess);
        img.setMaxZoom(4f);
        setContentView(img);

        flag_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}

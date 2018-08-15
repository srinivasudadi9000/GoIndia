package app.goindia;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CompleteviewImage extends Activity {
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;

    ImageView flag_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completeview_image);
        flag_img = (ImageView) findViewById(R.id.flag_img);
        mImageView = (ImageView) findViewById(R.id.display_img);
        switch (getIntent().getStringExtra("path")) {
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
        flag_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}

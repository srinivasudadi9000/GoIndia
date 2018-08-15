package app.goindia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Completeview extends Activity {
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;
    RecyclerView details_rv;
    ArrayList<Checkins> checkins;
    CheckinAdapter checkinAdapter;
    ImageView flag_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completeview);
        flag_img = (ImageView) findViewById(R.id.flag_img);
        details_rv = (RecyclerView) findViewById(R.id.details_rv);
        mImageView = (ImageView) findViewById(R.id.display_img);
        details_rv.setLayoutManager(new LinearLayoutManager(this));
        getcheckins_from_local();
       /* switch (getIntent().getStringExtra("path")){
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
        }*/
        flag_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void getcheckins_from_local() {

        checkins = new ArrayList<Checkins>();
        checkins.clear();
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String cdt_date = sdf.format(cd.getTime());

        Log.d("displaycount", cdt_date.toString());
        SQLiteDatabase db;
        db = openOrCreateDatabase("COURSE", Context.MODE_PRIVATE, null);

       // Cursor c = db.rawQuery("SELECT * FROM messages WHERE status=2  ORDER BY cdt DESC ", null);
        Cursor c = db.rawQuery("SELECT * FROM messages WHERE status='"+getIntent().getStringExtra("path")+"'ORDER BY cdt DESC ", null);
        Log.d("overallstring", c.toString());
        String ccc = String.valueOf(c.getCount());
        // Toast.makeText(getBaseContext(),"installation "+ccc.toString(),Toast.LENGTH_SHORT).show();
        Log.d("displaycount", ccc);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                checkins.add(new Checkins(c.getString(c.getColumnIndex("title"))));
                Log.d("hello",c.getString(c.getColumnIndex("status")));
                c.moveToNext();
            }
        }
        db.close();

        checkinAdapter = new CheckinAdapter(checkins, R.layout.check_single, getApplicationContext());
        details_rv.setAdapter(checkinAdapter);
        checkinAdapter.notifyDataSetChanged();
        //finish();
    }


}

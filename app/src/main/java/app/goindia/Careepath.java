package app.goindia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Careepath extends Activity implements View.OnClickListener{
    TextView goindia_htv;
    CardView beforetenth,aftertenth,aftertenthgvtjobs,aftertenthpvtjobs,afterinter,afterintergovtjobs,afterinterjobs;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView mImageView;
    EditText dob_edtxt;
    LinearLayout dob_ll,display_ll;
    ImageView search_img,flag_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.careepath);
        search_img = (ImageView) findViewById(R.id.search_img);
        flag_img = (ImageView) findViewById(R.id.flag_img);
        display_ll = (LinearLayout) findViewById(R.id.display_ll);
        dob_ll = (LinearLayout) findViewById(R.id.dob_ll);
        goindia_htv = (TextView) findViewById(R.id.heading_tv);
        goindia_htv.setText("Find your career path");
        dob_edtxt = (EditText) findViewById(R.id.dob_edtxt);
        beforetenth = (CardView) findViewById(R.id.beforetenth);
        aftertenth = (CardView) findViewById(R.id.aftertenth);
        aftertenthgvtjobs = (CardView) findViewById(R.id.aftertenthgvtjobs);
        aftertenthpvtjobs = (CardView) findViewById(R.id.aftertenthpvtjobs);
        afterinter = (CardView) findViewById(R.id.afterinter);
        afterintergovtjobs = (CardView) findViewById(R.id.afterintergovtjobs);
        afterinterjobs = (CardView) findViewById(R.id.afterinterjobs);

        if (getIntent().getStringExtra("value").equals("1")){
            dob_ll.setVisibility(View.GONE);
        }else {
             display_ll.setVisibility(View.GONE);
        }
        beforetenth.setOnClickListener(this);
        afterinter.setOnClickListener(this);
        search_img.setOnClickListener(this);
        flag_img.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.beforetenth:
                Intent compleview = new Intent(Careepath.this,Completeview.class);
                compleview.putExtra("path","aftertenth");
                startActivity(compleview);
                break;
            case R.id.afterinter:
                Intent cv = new Intent(Careepath.this,Completeview.class);
                cv.putExtra("path","afterinter");
                startActivity(cv);
                break;
            case R.id.search_img:

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date1 = Calendar.getInstance().getTime();
                    Date date2 = dateFormat.parse(dob_edtxt.getText().toString());
                    long diff = date1.getTime() - date2.getTime();
                    long seconds = diff / 1000;
                    long minutes = seconds / 60;
                    long hours = minutes / 60;
                    long days = hours / 24;
                    System.out.println("how many dayes :"+days/365);
                    if (days/365 >=15){
                        display_ll.setVisibility(View.VISIBLE);
                    }else {
                        Toast.makeText(getBaseContext(),"You are below 15 Years",Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.flag_img:
                finish();
                break;
        }
    }
}

package app.goindia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Additon extends Activity {
    EditText title_et;
    RadioGroup myradiogrp;
    RadioButton radiotxt, afterinter_rb, jobs_rb;
    TextView heading_tv;
    Button save_btn;
    String status = "no";
    ImageView flag_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additon);
        flag_img = (ImageView) findViewById(R.id.flag_img);
        heading_tv = (TextView) findViewById(R.id.heading_tv);
        heading_tv.setText("Adding Carrer Elements");
        save_btn = (Button) findViewById(R.id.save_btn);
        title_et = (EditText) findViewById(R.id.title_et);
        myradiogrp = (RadioGroup) findViewById(R.id.myradiogrp);
        myradiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = group.getCheckedRadioButtonId();
                radiotxt = (RadioButton) findViewById(selectedId);
                afterinter_rb = (RadioButton) findViewById(selectedId);
                jobs_rb = (RadioButton) findViewById(selectedId);
                if (radiotxt.getText().toString().equals("If After Tenth")) {
                    status = "2";
                } else if (afterinter_rb.getText().toString().equals("If After Inter")) {
                    status = "3";
                } else if (jobs_rb.getText().toString().equals("Jobs")) {
                    status = "4";
                } else {
                    status = "1";
                }
                Toast.makeText(getApplicationContext(), radiotxt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("no")) {
                    Toast.makeText(getBaseContext(), "Please Select Radio Group", Toast.LENGTH_SHORT).show();
                } else if (title_et.getText().toString().length() == 0) {
                    Toast.makeText(getBaseContext(), "Please Enter Title", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String cdt = dateFormat.format(new Date());


                    DBHelper dbHelper = new DBHelper(Additon.this);
                    dbHelper.insertProject(title_et.getText().toString(), status, "2", cdt, Additon.this);

                    Intent addition= new Intent(Additon.this,Additon.class);
                    startActivity(addition);
                    finish();
                }
            }
        });
        flag_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

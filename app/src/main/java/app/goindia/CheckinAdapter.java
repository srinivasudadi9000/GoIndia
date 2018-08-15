package app.goindia;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CheckinAdapter extends RecyclerView.Adapter<CheckinAdapter.CheckIn> {
    ArrayList<Checkins> checkIns;
    int Rowlayout;
    Context context;

    public CheckinAdapter(ArrayList<Checkins> checkins, int check_single, Context applicationContext) {
        this.context = applicationContext;
        this.Rowlayout = check_single;
        this.checkIns = checkins;
    }

    @Override
    public CheckIn onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(Rowlayout, parent, false);
        return new CheckIn(view);

    }

    @SuppressLint({"NewApi", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(final CheckIn holder, int position) {
        holder.title_tv.setText(checkIns.get(position).getTitle());
        holder.title_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.title_tv.getText().toString().contains("tenth")){
                    Intent call = new Intent(context,CompleteviewImage.class);
                    call.putExtra("path","afterinter");
                    context.startActivity(call);
                }else {
                    Intent call = new Intent(context,CompleteviewImage.class);
                    call.putExtra("path","aftertenth");
                    context.startActivity(call);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return checkIns.size();
    }

    public class CheckIn extends RecyclerView.ViewHolder {
        TextView title_tv;

        public CheckIn(View itemView) {
            super(itemView);
            title_tv = (TextView) itemView.findViewById(R.id.title_tv);

        }
    }
}

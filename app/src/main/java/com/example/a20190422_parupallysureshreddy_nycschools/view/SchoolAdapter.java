package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;
import com.example.a20190422_parupallysureshreddy_nycschools.model.School;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

     private Context context;
        List<School>  schoolList;
    onItemClickListner onItemClickListner;
        //constructor
        public SchoolAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList =schoolList;
    }


    public void setOnItemClickListner(SchoolAdapter.onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface onItemClickListner{
        void onClick(String str);//pass your object types.
    }
    //creating view
    @NonNull
    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(layoutInflater.inflate(R.layout.recylerview_school, viewGroup, false));
    }
    //binding view
    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.ViewHolder viewHolder, int i) {
        final School school = schoolList.get(i);
        if(school !=null) {
            viewHolder.textView.setText(school.getSchool_name());
            viewHolder.linerlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListner.onClick(school.getSchool_name());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout linerlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            linerlayout = (LinearLayout)itemView.findViewById(R.id.linerlayout);
        }
    }
}

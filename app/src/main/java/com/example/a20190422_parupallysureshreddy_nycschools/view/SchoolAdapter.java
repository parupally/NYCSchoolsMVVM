package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;
import com.example.a20190422_parupallysureshreddy_nycschools.model.School;
import com.example.a20190422_parupallysureshreddy_nycschools.onItemClickListner;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {


    private List<School> schoolList;
    private com.example.a20190422_parupallysureshreddy_nycschools.onItemClickListner onItemClickListner;

    //constructor
    SchoolAdapter(List<School> schoolList) {
        this.schoolList = schoolList;
    }


    void setOnItemClickListner(onItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
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
        viewHolder.bind(schoolList.get(i), onItemClickListner);
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        void bind(final School school, final onItemClickListner listener) {

            textView.setText(school.getSchool_name());
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // This is OnClick of any list Item
                    listener.onClick(school.getSchool_name());
                }

            });
        }
    }
}

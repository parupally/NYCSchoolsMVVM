package com.example.a20190422_parupallysureshreddy_nycschools;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SchoolAdapter extends PagedListAdapter<School, SchoolAdapter.ViewHolder> {

     private Context context;

        //constructor
    protected SchoolAdapter(@NonNull DiffUtil.ItemCallback<School> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
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

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

package com.app.lawyerly.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.lawyerly.R;

public class LawyerAdapter extends RecyclerView.Adapter<HolderLawyer> {
    @NonNull
    @Override
    public HolderLawyer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_feature, parent, false);
        return new HolderLawyer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderLawyer holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

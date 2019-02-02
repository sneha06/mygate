package com.aasa.android.mygatetestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasa.android.mygatetestapp.model.ItemDetails;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<ItemDetails> itemList;
    Context mContext;
    OnButtonClick onButtonClick;
    public UserAdapter(List<ItemDetails> itemList, MainActivity mainActivity, OnButtonClick onButtonClick) {
        this.itemList = itemList;
        mContext = mainActivity;
        this.onButtonClick = onButtonClick;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_adapter,viewGroup,false);
        MyViewHolder mv = new MyViewHolder(view);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText(itemList.get(i).getName());
        myViewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick.onButtonClickListner(myViewHolder,i );
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        Button add;
        TextView name,passcode;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            add = itemView.findViewById(R.id.add);
            name= itemView.findViewById(R.id.name);
            passcode = itemView.findViewById(R.id.passcode);
            image = itemView.findViewById(R.id.image);
        }
    }
}

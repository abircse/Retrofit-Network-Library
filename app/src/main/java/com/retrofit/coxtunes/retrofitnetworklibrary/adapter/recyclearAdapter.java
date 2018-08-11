package com.retrofit.coxtunes.retrofitnetworklibrary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.retrofit.coxtunes.retrofitnetworklibrary.R;
import com.retrofit.coxtunes.retrofitnetworklibrary.model.contact;

import java.util.List;

public class recyclearAdapter extends RecyclerView.Adapter<recyclearAdapter.MyviewHolder> {


    private List<contact> contacts;

    public recyclearAdapter(List<contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.Name.setText(contacts.get(position).getName());
        holder.Email.setText(contacts.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder
    {

        TextView Name, Email;

        public MyviewHolder(View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);
            Email = itemView.findViewById(R.id.email);

        }

    }

}

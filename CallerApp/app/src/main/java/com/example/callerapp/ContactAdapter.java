package com.example.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<Contact> contactList;
    private ItemClickListener itemClickListener;

    public ContactAdapter(ArrayList<Contact> contactList, ItemClickListener itemClickListener){
        this.contactList=contactList;
        this.itemClickListener=itemClickListener;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ContactViewHolder holder, int position) {
        Contact contact= contactList.get(position);
        holder.setData(contact, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}

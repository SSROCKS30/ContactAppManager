package com.example.contactappmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactappmanager.databinding.ContactListModelBinding;

import java.util.List;

public class MyAdapterRV extends RecyclerView.Adapter<MyAdapterRV.MyViewHolder>{
    List<Contacts> contactsList;
    Context context;
    MainActivityClickHandlers mainActivityClickHandlers;

    public MyAdapterRV(List<Contacts> contactsList, Context context, MainActivityClickHandlers mainActivityClickHandlers) {
        this.contactsList = contactsList;
        this.context = context;
        this.mainActivityClickHandlers = mainActivityClickHandlers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListModelBinding contactListModelBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.contact_list_model, parent, false);
        return new MyViewHolder(contactListModelBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Contacts contacts = contactsList.get(position);
        holder.contactListModelBinding.setContact(contacts);

    }

    @Override
    public int getItemCount() {
        if(contactsList != null){
            return contactsList.size();
        }else{
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ContactListModelBinding contactListModelBinding;
        public MyViewHolder(@NonNull ContactListModelBinding contactListModelBinding) {
            super(contactListModelBinding.getRoot());
            this.contactListModelBinding = contactListModelBinding;

            contactListModelBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mainActivityClickHandlers != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                        mainActivityClickHandlers.onContactClicked(contactsList.get(getAdapterPosition()), contactsList.get(getAdapterPosition()).getId());
                    }
                }
            });
        }
    }
}


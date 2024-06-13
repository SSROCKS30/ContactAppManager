package com.example.contactappmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandlers {
    Context context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view){
        Intent i = new Intent(context, AddContactActivity.class);
        context.startActivity(i);
    }

    public void onContactClicked(Contacts contacts, int id){
        Intent i = new Intent(context, UpdateContactActivity.class);
        i.putExtra("id", id);
        i.putExtra("name", contacts.getName());
        i.putExtra("no", contacts.getNo());
        i.putExtra("email", contacts.getEmail());
        context.startActivity(i);
    }
}

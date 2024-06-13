package com.example.contactappmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.contactappmanager.databinding.ActivityAddContactBinding;

public class AddNewContactClickHandler {
    Context context;
    Contacts contacts;

    public AddNewContactClickHandler(Context context, Contacts contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    public void onSubmitBtnClicked(View view){

        if(contacts.getName() == null || contacts.getEmail() == null || contacts.getNo() == null){
            Toast.makeText(context, "Enter the details", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("name", contacts.getName());
            i.putExtra("no", contacts.getNo());
            i.putExtra("email", contacts.getEmail());
            context.startActivity(i);
        }
    }
}

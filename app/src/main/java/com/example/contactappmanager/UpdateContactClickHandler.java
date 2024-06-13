package com.example.contactappmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.contactappmanager.databinding.ActivityUpdateContactBinding;


public class UpdateContactClickHandler {
    Context context;
    Contacts contacts;
    public UpdateContactClickHandler(Context context, Contacts contacts) {
        this.context = context;
        this.contacts = contacts;
    }
    public void onUpdateBtnClicked(View view) {
        if (contacts.getName() == null || contacts.getEmail() == null || contacts.getNo() == null) {
            Toast.makeText(context, "Enter the details", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("update_id", contacts.getId());
            i.putExtra("update_name", contacts.getName());
            i.putExtra("update_no", contacts.getNo());
            i.putExtra("update_email", contacts.getEmail());
            context.startActivity(i);
        }
    }

    public void onDeleteBtnClicked(View view) {
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("delete_id", contacts.getId());
        i.putExtra("delete_name", contacts.getName());
        i.putExtra("delete_no", contacts.getNo());
        i.putExtra("delete_email", contacts.getEmail());
        context.startActivity(i);
    }

}

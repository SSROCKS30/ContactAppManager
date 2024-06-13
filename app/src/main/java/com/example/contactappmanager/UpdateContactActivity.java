package com.example.contactappmanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.contactappmanager.databinding.ActivityUpdateContactBinding;

public class UpdateContactActivity extends AppCompatActivity {
    private ActivityUpdateContactBinding updateContactBinding;
    private UpdateContactClickHandler updateContactClickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        Intent intent = getIntent();
        Contacts contacts = new Contacts();
        contacts.setId(intent.getIntExtra("id", -1));
        contacts.setName(intent.getStringExtra("name"));
        contacts.setNo(intent.getStringExtra("no"));
        contacts.setEmail(intent.getStringExtra("email"));
        updateContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_contact);
        updateContactClickHandler = new UpdateContactClickHandler(this, contacts);
        updateContactBinding.setClickHandler(updateContactClickHandler);
        updateContactBinding.setContact(contacts);
    }
}
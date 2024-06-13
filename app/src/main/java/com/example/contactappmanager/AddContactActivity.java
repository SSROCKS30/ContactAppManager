package com.example.contactappmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.contactappmanager.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity {
    private ActivityAddContactBinding addContactBinding;
    private AddNewContactClickHandler addNewContactClickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        Contacts contacts = new Contacts();
        addContactBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_contact);
        addNewContactClickHandler = new AddNewContactClickHandler(this, contacts);
        addContactBinding.setClickHandler(addNewContactClickHandler);
        addContactBinding.setContact(contacts);
    }
}
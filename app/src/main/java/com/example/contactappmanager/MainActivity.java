package com.example.contactappmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactappmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private List<Contacts> contactsList = new ArrayList<>();
    private MyAdapterRV adapterRV;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);
        binding.setClickHandler(handlers);
        // Getting the instance of RecyclerView from binding object
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapterRV = new MyAdapterRV(contactsList, (Context) this, handlers);
        // Getting the instance of viewModel
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        Intent intent = getIntent();
        if(intent.hasExtra("name")) {
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("no");
            String email = intent.getStringExtra("email");
            Contacts contact = new Contacts(name, phone, email);
            viewModel.insert(contact);
        }
        if(intent.hasExtra("update_id")) {
            int id = intent.getIntExtra("update_id", -1);
            String name = intent.getStringExtra("update_name");
            String phone = intent.getStringExtra("update_no");
            String email = intent.getStringExtra("update_email");
            Log.d("MainActivity", "onCreate: " + id);
            if(id != -1) {
                Contacts contact = new Contacts(name, phone, email);
                contact.setId(id);
                viewModel.update(contact);
            }
            else Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
        }
        if(intent.hasExtra("delete_id")) {
            int id = intent.getIntExtra("delete_id", -1);
            String name = intent.getStringExtra("delete_name");
            String phone = intent.getStringExtra("delete_no");
            String email = intent.getStringExtra("delete_email");
            Log.d("MainActivity", "onCreate: " + id);
            if(id != -1) {
                Contacts contact = new Contacts(name, phone, email);
                contact.setId(id);
                viewModel.delete(contact);
            }
            else Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show();
        }

        //Observe the LiveData object from ViewModel
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsList.clear();
                for(Contacts contact : contacts) {
                    Log.d("MainActivity", "onChanged: " + contact.getName());
                    contactsList.add(contact);
                }
                adapterRV.notifyDataSetChanged();
            }
        });
        recyclerView.setAdapter(adapterRV);
    }
}
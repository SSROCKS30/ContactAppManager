package com.example.contactappmanager;

import android.app.Application;
import android.os.Looper;
import android.os.Handler;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Repository class is a mediator between our data sources and UI component to handle data operations
//Repository class provides clean API to access data from multiple data sources
//It act as a layer of abstraction that separates the database from the rest of the application
public class ContactRepository {
    private final DAO dao;
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    public ContactRepository(Application application) {
        ContactDataBase db = ContactDataBase.getInstance(application);
        this.dao = db.dao();
    }
    public void insert(Contacts contacts) {
        executor.execute(() -> {
            dao.insert(contacts);
        });
    }
    public void update(Contacts contacts) {
        executor.execute(() -> {
            dao.update(contacts);
        });
    }
    public void delete(Contacts contacts) {
        executor.execute(() -> {
            dao.delete(contacts);
        });
    }
    // Why LiveData? All other method does not return anything and they do happen in background thread but getAllContacts() needs to return data to UI and we cannot return data from background thread to UI thread directly. So, we use LiveData to observe the data and return it to UI.
    public LiveData<List<Contacts>> getAllContacts() {
        return dao.getAllContacts();
    }
}

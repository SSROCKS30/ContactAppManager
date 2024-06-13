package com.example.contactappmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
//ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way
//ViewModel class allows data to survive configuration changes such as screen rotations
public class ViewModel extends AndroidViewModel {
    private final ContactRepository contactRepository;
    private LiveData<List<Contacts>> allContacts;

    public ViewModel(@NonNull Application application) {
        super(application);
        this.contactRepository = new ContactRepository(application);
    }

    public void insert(Contacts contacts) {
        contactRepository.insert(contacts);
    }

    public void update(Contacts contacts) {
        contactRepository.update(contacts);
    }

    public void delete(Contacts contacts) {
        contactRepository.delete(contacts);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = contactRepository.getAllContacts();
        return allContacts;
    }
}

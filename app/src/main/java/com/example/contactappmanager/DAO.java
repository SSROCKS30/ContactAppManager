package com.example.contactappmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {
    @Insert // Insert Query
    void insert(Contacts contacts);
    @Update // Update Query
    void update(Contacts contacts);
    @Delete // Delete Query
    void delete(Contacts contacts);
    @Query("SELECT * FROM contacts_table") // Custom Query
    LiveData<List<Contacts>> getAllContacts();
}

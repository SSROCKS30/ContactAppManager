package com.example.contactappmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDataBase extends RoomDatabase {
    public abstract DAO dao();
    private static ContactDataBase instance;
    public static synchronized ContactDataBase getInstance(Context context) { // To ensure only one instance is created
        if(instance == null) {
            instance = Room.databaseBuilder(context, ContactDataBase.class, "contacts_database").fallbackToDestructiveMigration().build();
            //.fallbackToDestructiveMigration() is used to delete the table and recreate it according to the new schema if the version is changed
        }
        return instance;
    }
}

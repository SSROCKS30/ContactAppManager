package com.example.contactappmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contacts {
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "contact_name")
    private String name;
    @ColumnInfo(name = "contact_no")
    private String no;
    @ColumnInfo(name = "contact_email")
    private String email;

    public Contacts(String name, String no, String email) {
        this.name = name;
        this.no = no;
        this.email = email;
    }

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

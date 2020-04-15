package com.example.listviews_recyclerview_missionandroid123.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.listviews_recyclerview_missionandroid123.Model.Contact;
import com.example.listviews_recyclerview_missionandroid123.R;
import com.example.listviews_recyclerview_missionandroid123.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table _contacts(id, name, emailId, mobileNumber)

        String CREATE_TABLE = "CREATE TABLE " +Util.TABLE_NAME + "("
                + Util.COLUMN_ID + " INTEGER PRIMARY KEY,"
                + Util.COLUMN_NAME + " TEXT,"
                + Util.COLUMN_EMAIL_ID + " TEXT,"
                + Util.COLUMN_MOBILE_NUMBER + " TEXT"
                +")";

        //execute sql command
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE = String.valueOf((R.string.drop_table));
        sqLiteDatabase.execSQL(DROP_TABLE,new String[]{Util.DATABASE_NAME});

        //create table again
        onCreate(sqLiteDatabase);
    }

    //CRUD= create, read, update, delete

    //create--add contact
    public void addContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.COLUMN_NAME,contact.getName());
        contentValues.put(Util.COLUMN_EMAIL_ID,contact.getEmailId());
        contentValues.put(Util.COLUMN_MOBILE_NUMBER,contact.getMobileNumber());

        //insert in row
        sqLiteDatabase.insert(Util.TABLE_NAME,null,contentValues);

        //close db connection
        sqLiteDatabase.close();
    }

    //read--read single entry
    public Contact readSingleContact(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //add cursor to iterate
        Cursor cursor = sqLiteDatabase.query(Util.TABLE_NAME,
                new String[]{Util.COLUMN_ID},
                Util.COLUMN_ID+"=?",
                new String[]{String.valueOf(id)},
                null,null,null);

        if (cursor!=null)
            cursor.moveToFirst();
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setEmailId(cursor.getString(2));
            contact.setMobileNumber(cursor.getString(3));
            return contact;
    }

    //read--read all entries
    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //sqli command to get all entries
        String GET_ALL_CONTACTS = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(GET_ALL_CONTACTS, null);
        if (cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setEmailId(cursor.getString(2));
                contact.setMobileNumber(cursor.getString(3));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }

    //update
    public int updateContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.COLUMN_NAME,contact.getName());
        contentValues.put(Util.COLUMN_EMAIL_ID,contact.getMobileNumber());
        contentValues.put(Util.COLUMN_MOBILE_NUMBER,contact.getMobileNumber());

        return sqLiteDatabase.update(Util.TABLE_NAME,
                contentValues,
                Util.COLUMN_ID+"=?",
                new String[]{String.valueOf(contact.getId())});
    }

    //delete
    public void deleteContact(Contact contact){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.delete(Util.TABLE_NAME,Util.COLUMN_ID+"=?",
                new String[]{String.valueOf(contact.getId())});

        sqLiteDatabase.close();
    }

    //get count of total entries in a table
    public int getCount(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String COUNT_QUERY = "SELECT * FROM "+ Util.TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(COUNT_QUERY,null);
        return cursor.getCount();

    }
}

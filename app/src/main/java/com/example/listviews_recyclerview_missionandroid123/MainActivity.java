package com.example.listviews_recyclerview_missionandroid123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.listviews_recyclerview_missionandroid123.Data.DatabaseHandler;
import com.example.listviews_recyclerview_missionandroid123.Model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);

        //adding  entries, comment them after 1st run;
//        databaseHandler.addContact(new Contact("james","j@xyz.com","48445681"));
//        databaseHandler.addContact(new Contact("mathew","matt@xyz.com","00096487"));
//        databaseHandler.addContact(new Contact("ricky","ricky@gmail.com.com","0006341789"));
//        databaseHandler.addContact(new Contact("shaun","shaun@xyz.com","9003178991"));
//        databaseHandler.addContact(new Contact("robbin","robb@yahoo.com","5410006350046"));

//        databaseHandler.addContact(new Contact("marshall","marsh@xyz.com","480000681"));
//        databaseHandler.addContact(new Contact("anjuna","anjuna@xyz.com","000000087"));
//        databaseHandler.addContact(new Contact("spencer","sp@gmail.com.com","00063400089"));
//        databaseHandler.addContact(new Contact("william","shaun@xyz.com","9003100091"));
//        databaseHandler.addContact(new Contact("nure","nure@yahoo.com","0600444446"));

//        databaseHandler.addContact(new Contact("james","j@xyz.com","48445681"));
//        databaseHandler.addContact(new Contact("mathew","matt@xyz.com","00096487"));
//        databaseHandler.addContact(new Contact("ricky","ricky@gmail.com.com","0006341789"));
//        databaseHandler.addContact(new Contact("shaun","shaun@xyz.com","9003178991"));
//        databaseHandler.addContact(new Contact("robbin","robb@yahoo.com","5410006350046"));

        //get all entries
        List<Contact> contactList = databaseHandler.getAllContacts();
        for (Contact contact : contactList){
            Log.d("GETALLCONTACTS", "onCreate: "+"Id: "+contact.getId()
                    +",Name: "+contact.getName()
                    + ", Email Id: "+contact.getEmailId()
                    + ", Mobile Number: "+contact.getMobileNumber());
        }
    }
}

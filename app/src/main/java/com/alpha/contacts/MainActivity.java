package com.alpha.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alpha.contacts.Adapter.RecyclerViewAdapter;
import com.alpha.contacts.Data.DatabaseHandler;
import com.alpha.contacts.Model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Contact> contactArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact Shubham = new Contact();
        Contact Ritik = new Contact();
        Contact Anshul = new Contact();
        Contact Harshit = new Contact();
        Contact Ishant = new Contact();
        Contact Hemant = new Contact();

        Shubham.setName("Shubham");
        Shubham.setPhoneNumber("9459669904");

        Ritik.setName("Ritik");
        Ritik.setPhoneNumber("8219424641");

        Anshul.setName("Anshul");
        Anshul.setPhoneNumber("8219456858");

        Harshit.setName("Harshit");
        Harshit.setPhoneNumber("854976248");

        Ishant.setName("Ishant");
        Ishant.setPhoneNumber("9816710772");

        Hemant.setName("Hemant");
        Hemant.setPhoneNumber("8219198123");

        db.addContact(Shubham);
        db.addContact(Ritik);
        db.addContact(Anshul);
        db.addContact(Harshit);
        db.addContact(Ishant);
        db.addContact(Hemant);



        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<Contact> contactList = db.getAllContact();
        for(Contact contact: contactList){
            contactArrayList.add(contact);
        }

        adapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);

        recyclerView.setAdapter(adapter);





    }
}
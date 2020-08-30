package com.alpha.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String name = bundle.getString("name");
            String phoneNumber = bundle.getString("phone_number");
            int id = bundle.getInt("id");
        }
    }
}

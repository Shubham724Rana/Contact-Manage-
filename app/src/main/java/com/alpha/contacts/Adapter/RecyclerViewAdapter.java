package com.alpha.contacts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alpha.contacts.Menu;
import com.alpha.contacts.Model.Contact;
import com.alpha.contacts.R;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row_xml, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     Contact contact = contactList.get(position);

     holder.Name.setText(contact.getName());
     holder.PhoneNumber.setText(contact.getPhoneNumber());


    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public ImageView ImageEdit;
        public TextView Name;
        public TextView PhoneNumber;
        public ImageView ImageId;
        public RelativeLayout relativeLayout;
        public Intent intent_menu;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            Name = itemView.findViewById(R.id.name);
            PhoneNumber = itemView.findViewById(R.id.phone_number);
            ImageId = itemView.findViewById(R.id.imageId);
            ImageEdit = itemView.findViewById(R.id.edit_contact);
            relativeLayout = itemView.findViewById(R.id.relative_layout);

            relativeLayout.setOnClickListener(this);
            Name.setOnClickListener(this);
            ImageId.setOnClickListener(this);
            PhoneNumber.setOnClickListener(this);
            ImageEdit.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position  = getAdapterPosition();
            Contact contact = contactList.get(position);
            intent_menu = new Intent(context , Menu.class);
            intent_menu.putExtra("name", contact.getName());
            intent_menu.putExtra("phone_number", contact.getPhoneNumber());
            intent_menu.putExtra("id", contact.getId());

            switch (v.getId()){

                    case (R.id.relative_layout):
                         context.startActivity(intent_menu);
                          break;
                    case (R.id.name):
                         context.startActivity(intent_menu);
                          break;
                    case R.id.phone_number:
                         context.startActivity(intent_menu);
                         break;

                    case R.id.edit_contact:
                        Toast.makeText(context , "Edit Contcat", Toast.LENGTH_LONG).show();
                           break;
                    case R.id.imageId:
                        Toast.makeText(context , "Add Contact Image", Toast.LENGTH_LONG).show();
                       break; }
        }
    }
}

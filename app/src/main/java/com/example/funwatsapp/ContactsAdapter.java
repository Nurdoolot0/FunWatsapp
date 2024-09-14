package com.example.funwatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.funwatsapp.databinding.ItemContactBinding;
import java.util.HashMap;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private final List<String> contacts;
    private final Context context;
    private final HashMap<String, String> contactImages;

    public ContactsAdapter(Context context, List<String> contacts, HashMap<String, String> contactImages) {
        this.context = context;
        this.contacts = contacts;
        this.contactImages = contactImages;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemContactBinding binding = ItemContactBinding.inflate(inflater, parent, false);
        return new ContactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        String contact = contacts.get(position);
        holder.binding.contactName.setText(contact);
        holder.binding.contactDescription.setText("Привет, я использую WhatsApp!");

        String imageUrl = contactImages.get(contact);
        Glide.with(context)
                .load(imageUrl)
                .circleCrop()
                .into(holder.binding.contactImage);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        final ItemContactBinding binding;

        public ContactViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

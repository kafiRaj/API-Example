package com.example.class5api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ExampleViewHolder> {


    private Context mContext;
    private ArrayList<ProfileModel> profileModels;

    public ProfileAdapter(Context context, ArrayList<ProfileModel> profileModelArrayList){
        mContext = context;
        profileModels = profileModelArrayList;


    }


    @NonNull
    @Override
    public ProfileAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.profile, parent, false);

        return new ProfileAdapter.ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ExampleViewHolder holder, int position) {


        ProfileModel currentItem = profileModels.get(position);

        String email = currentItem.getEmail();
        String firstname = currentItem.getFirst_name();
        String lastname = currentItem.getLast_name();
        String avatar = currentItem.getAvater();


        holder.emailText.setText(email);
        holder.nameText.setText(firstname+" "+lastname);
        Picasso.get().load(avatar).into(holder.avatar);


    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }



    public class ExampleViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView avatar;
        public TextView nameText, emailText;

        public ExampleViewHolder (View view){
            super(view);


            avatar = view.findViewById(R.id.avatarId);
            nameText = view.findViewById(R.id.nameId);
            emailText = view.findViewById(R.id.emailId);
        }
    }

}

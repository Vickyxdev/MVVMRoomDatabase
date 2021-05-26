package com.vicky.mvvmroomdatabse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vicky.mvvmroomdatabse.R;
import com.vicky.mvvmroomdatabse.repository.User;

import java.util.List;


public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {


    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userNameView;
        private  final TextView userOccupationView;

        private UserViewHolder(View itemView) {
            super(itemView);
            userNameView = itemView.findViewById(R.id.user_name);
            userOccupationView = itemView.findViewById(R.id.user_occ);
        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUsers; // Cached copy of users


    public UserListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (mUsers != null) {
            User current = mUsers.get(position);
            holder.userNameView.setText(current.getUserName());
            holder.userOccupationView.setText(current.getUserDesignation());
        } else {
            // Covers the case of data not being ready yet.
            holder.userNameView.setText("No Word");
        }
    }
    public void setWords(List<User> users){
        mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mUsers != null) {
            return mUsers.size();
        }else{
            return  0;
        }
    }
}

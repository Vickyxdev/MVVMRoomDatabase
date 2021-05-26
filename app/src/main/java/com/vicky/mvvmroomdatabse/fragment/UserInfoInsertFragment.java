package com.vicky.mvvmroomdatabse.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vicky.mvvmroomdatabse.R;
import com.vicky.mvvmroomdatabse.repository.User;
import com.vicky.mvvmroomdatabse.viewmodels.UserListViewModel;

import java.util.List;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserInfoInsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInfoInsertFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserInfoInsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInfoInsertFragment.
     */
    private  View userInfoView  = null;
    private UserListViewModel userListViewModel;
    EditText userName,userDesignation;
    Button saveUser;

    // TODO: Rename and change types and number of parameters
    public static UserInfoInsertFragment newInstance(String param1, String param2) {
        UserInfoInsertFragment fragment = new UserInfoInsertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        userListViewModel = ViewModelProviders.of(getActivity()).get(UserListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userInfoView = inflater.inflate(R.layout.fragment_user_info_insert, container, false);
        initView(userInfoView);

        return userInfoView;
    }

    private void initView(View view) {
        userName = (EditText) view.findViewById(R.id.edit_name);
        userDesignation = (EditText)view.findViewById(R.id.edit_designation);
        saveUser = (Button) view.findViewById(R.id.insert_btn);
        saveUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.insert_btn){
            saveInfo();
        }
    }

    private void saveInfo() {
        if(!TextUtils.isEmpty(userName.getText().toString()) && !TextUtils.isEmpty(userDesignation.getText().toString())){
            String name = userName.getText().toString();
            String userOccup = userDesignation.getText().toString();
            User user = new User(name,userOccup);
            userListViewModel.insert(user);
            userName.setText("");
            userDesignation.setText("");


        }else{
            Toast.makeText(getActivity(),"Fill Required info",Toast.LENGTH_LONG).show();
        }
    }
}
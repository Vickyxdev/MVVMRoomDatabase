package com.vicky.mvvmroomdatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vicky.mvvmroomdatabse.fragment.UserInfoInsertFragment;
import com.vicky.mvvmroomdatabse.fragment.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment1, new UserListFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment2, new UserInfoInsertFragment()).commit();
    }
}
package com.example.fragment11_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.replace(R.id.frameLayout,new LoginFragment());
        fragmenttransaction.commit();
    }
}
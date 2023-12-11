package com.example.fragment11_12;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


public class LoginFragment extends Fragment {



    EditText user, pass;
    Button btn;
    View view;
    public String PASSWORD1 = "1234567890", PASSWORD2 = "0987654321" , PASSWORD3="1234509876";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_login, container, false);
        user = view.findViewById(R.id.username);
        pass = view.findViewById(R.id.password);
        btn = view.findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isCorrect = validate(user.getText().toString(),pass.getText().toString());
                if(isCorrect){
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout,new recylerFragment());
                    fragmentTransaction.commit();
                    Toast.makeText(view.getContext(), "Successful", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(view.getContext(), "Hey,Password does not match", Toast.LENGTH_SHORT).show();
                }


            }


        });
        return view;
    }
    public Boolean validate(String user,String pass) {
        List<String> storedPasswords = Arrays.asList(PASSWORD1, PASSWORD2, PASSWORD3);
        if(user.length() !=10) {
            Toast.makeText(view.getContext(), "username contains exactly 10 Numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        // validation
        try{
            long data = Long.parseLong(user);
        }
        catch (NumberFormatException e){
            Toast.makeText(view.getContext(), "Username contains only Numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        //password
        if(user.length() !=10) {
            Toast.makeText(view.getContext(), "Password contains exactly 10 Numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

        try{
            long data = Long.parseLong(pass);
        }
        catch (NumberFormatException e){
            Toast.makeText(view.getContext(), "Enter only numbers in password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if( !user.equals(pass)) {Toast.makeText(view.getContext(), "Username and password not match", Toast.LENGTH_SHORT).show();
            return false;}
        return storedPasswords.contains(pass);
    }
}
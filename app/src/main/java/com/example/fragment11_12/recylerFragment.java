package com.example.fragment11_12;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;


public class recylerFragment extends Fragment {


View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_recyler, container, false);
        List<WidgetItem> widgetItems = Arrays.asList(
                new WidgetItem("Item : 1", "text"),
                new WidgetItem("", "image"),
                new WidgetItem("Item : 3", "text"),
                new WidgetItem("", "image"),
                new WidgetItem("Item : 5", "text"),
                new WidgetItem("", "image"),
                new WidgetItem("Item : 7", "text"),
                new WidgetItem("", "image"),
                new WidgetItem("Item : 9", "text"),
                new WidgetItem("", "image")
        );
//        Gson gson = new Gson();
//        List<WidgetItem> widgetItems = gson.fromJson(loadJSONFromAsset(), new TypeToken<List<WidgetItem>>(){}.getType());


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);


        MyAdapter adapter = new MyAdapter(widgetItems);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
    }

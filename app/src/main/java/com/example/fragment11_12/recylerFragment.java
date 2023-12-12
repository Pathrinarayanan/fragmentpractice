package com.example.fragment11_12;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment11_12.MyAdapter;
import com.example.fragment11_12.WidgetItem;
import com.example.fragment11_12.WidgetResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recylerFragment extends Fragment {

    private static final String API_BASE_URL = "https://run.mocky.io/";
//    private static final String API_ENDPOINT = "06780b47-23b7-4218-829b-7e5b7ed30fb3";

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyler, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        fetchData();

        return view;
    }

    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiInterface = retrofit.create(ApiService.class);
        Call<WidgetResponse> call = apiInterface.getWidgets();

        call.enqueue(new Callback<WidgetResponse>() {
            @Override
            public void onResponse(Call<WidgetResponse> call, Response<WidgetResponse> response) {
                if (response.isSuccessful()) {
                    WidgetResponse widgetResponse = response.body();
                    System.out.println("hi->"+widgetResponse.getWidgets().size());
                    Log.d("Raw JSON", new Gson().toJson(response.body()));

                    if (widgetResponse != null) {
                        List<WidgetItem> widgetItems = widgetResponse.getWidgets();

                        adapter = new MyAdapter(widgetItems);
                        System.out.print(widgetItems.get(0));
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    Log.e("ApiError", "Failed to fetch widgets. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<WidgetResponse> call, Throwable t) {
                Log.e("ApiError", "Failed to fetch widgets", t);
            }
        });
    }
}

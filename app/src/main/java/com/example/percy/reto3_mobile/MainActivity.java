package com.example.percy.reto3_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.percy.reto3_mobile.models.Coinmarket;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "COINMARKET";
    ArrayList<String> listDatos;
    RecyclerView recyclerView ;
    private Retrofit retrofit;
    AdapterDatos adapterDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.coinmarketcap.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerId);

    }

    private void obtenerDatos() {
        clientService service = retrofit.create(clientService.class);
        Call<List<Coinmarket>> coinmarketCall = service.obtenerListaCoinmarket();
        coinmarketCall.enqueue(new Callback<List<Coinmarket>>() {
            @Override
            public void onResponse(Call<List<Coinmarket>> call, Response<List<Coinmarket>> response) {
                if(response.isSuccessful()){
                    setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Coinmarket>> call, Throwable t) {
                Log.e(TAG,"on Failure:"+ t.getMessage());
            }
        });

    }

    private void setData(List<Coinmarket> body) {
        adapterDatos = new AdapterDatos(body);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterDatos);

    }
}

package com.example.percy.reto3_mobile;

import com.example.percy.reto3_mobile.models.Coinmarket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by percy on 21/02/18.
 */

public interface clientService {
    @GET("ticker")
    Call<List<Coinmarket>> obtenerListaCoinmarket();
}

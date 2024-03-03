package com.example.testproject.retrofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("items")
    Call<List<Product>> getProducts();

}

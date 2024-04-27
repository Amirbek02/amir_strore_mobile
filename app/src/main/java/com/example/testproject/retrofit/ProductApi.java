package com.example.testproject.retrofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductApi {
    @GET("items")
    Call<List<Product>> getProducts();
    @POST("basket")
    Call<Void>postProducts(@Body Product product);

}

package com.example.testproject;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.retrofit.Product;
import com.example.testproject.retrofit.ProductApi;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://384b3adb2bb70528.mokky.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductApi productApi = retrofit.create(ProductApi.class);
        Call<List<Product>> call = productApi.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products = response.body();
                    Log.d("Amirbek", products.toString());
                    if (products != null && !products.isEmpty()) {
                        ProductAdapter productAdapter = new ProductAdapter(products);
                        Log.d("Amirbek1", String.valueOf(productAdapter));
                        recyclerView.setAdapter(productAdapter);
                    } else {
                        Log.e("Error", "Response body is null or empty");
                    }
                } else {
                    Log.e("Error", "Request failed: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("Error", "Request failed: " + t.getMessage());
            }
        });
    }
}

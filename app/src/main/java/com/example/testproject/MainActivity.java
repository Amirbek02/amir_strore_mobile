package com.example.testproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.retrofit.Product;
import com.example.testproject.retrofit.ProductApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    ImageView basketIcon, profileIcon, heartIcon, addBasket;
    List<Product> productsRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        basketIcon = findViewById(R.id.basket);
        heartIcon = findViewById(R.id.heart);
        profileIcon = findViewById(R.id.profile);
        addBasket = findViewById(R.id.btnPlus);
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
                    productsRef = response.body();
                    Log.d("Amirbek1234", productsRef.toString());
                    if (productsRef != null && !productsRef.isEmpty()) {
                        ProductAdapter productAdapter = new ProductAdapter(productsRef);
                        Log.d("Amirbek1", String.valueOf(productAdapter.toString()));
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
//        Intent intent = new Intent(SecondActivity.this, com.example.ourfirstproject.MainActivity.class);
//        startActivity(intent);
        basketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.testproject.BasketActivity.class);
                startActivity(intent);
            }
        });
        heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.testproject.HeartActivty.class);
                startActivity(intent);
            }
        });
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.testproject.profileActivity.class);
                startActivity(intent);
            }
        });
//        addBasket.setOnClickListener(new View.OnClickListener() {
//            final List<Product> products = productsRef;
//            @Override
//            public void onClick(View view) {
//
//                Product firstProduct = products.get(0);
//                Log.d("Amirbek12345", String.valueOf(firstProduct.getProductImg()));
//                Product productToAddToBasket = new Product(firstProduct.getId(), firstProduct.getProductImg(), firstProduct.getProductText(), firstProduct.getProductCost());
//                Call<Void> calls = productApi.postProducts(productToAddToBasket);
//                calls.enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> calls, Response<Void> response) {
//                        if (response.isSuccessful()) {
//                            Log.d("Amirbek", "Post request successful");
//                        } else {
//                            Log.e("Error", "Request failed: " + response.code() + " - " + response.message());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Void> calls, Throwable t) {
//                        // Обработка ошибки во время выполнения запроса
//                        Log.e("Error", "Request failed: " + t.getMessage());
//                    }
//                });
//            }
//        });

    }}



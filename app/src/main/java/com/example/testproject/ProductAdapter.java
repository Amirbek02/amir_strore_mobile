package com.example.testproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.retrofit.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_products, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        Log.d("Amirbek22", String.valueOf(product.getProductText()));
        holder.textViewProductText.setText(product.getProductText());
        holder.textViewProductCost.setText(product.getProductCost());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewProductText;
        TextView textViewProductCost;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductText = itemView.findViewById(R.id.textViewProductText);
            textViewProductCost = itemView.findViewById(R.id.textViewProductCost);
        }
    }
}

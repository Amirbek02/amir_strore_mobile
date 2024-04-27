package com.example.testproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        String image = product.getProductImg();
        String newText = image.substring(0, image.length() - 4);
        String[] parts = newText.split("/");
        String imageName = parts[parts.length - 1];

        Log.d("Amirbek22", String.valueOf(imageName));
        holder.textViewProductText.setText(product.getProductText());
        holder.textViewProductCost.setInputType(product.getProductCost());
        holder.imageView.setImageResource(holder.imageView.getContext().getResources().getIdentifier(
                imageName,
                "drawable",
                holder.itemView.getContext().getPackageName()
        ));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewProductText;
        TextView textViewProductCost;
        ImageView imageView;
        int index;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductText = itemView.findViewById(R.id.textViewProductText);
            textViewProductCost = itemView.findViewById(R.id.textViewProductCost);
            imageView = itemView.findViewById(R.id.imagesItems);
        }
    }
}

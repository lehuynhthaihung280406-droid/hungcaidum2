package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;
    private ImageButton buttonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        buttonCart = findViewById(R.id.buttonCart);
        
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();
        // Đã cập nhật lại để sử dụng đúng ảnh trong drawable mà bạn vừa lưu
        productList.add(new Product(getString(R.string.product_1_name), getString(R.string.product_1_price), R.drawable.img));
        productList.add(new Product(getString(R.string.product_2_name), getString(R.string.product_2_price), R.drawable.img_1));
        productList.add(new Product(getString(R.string.product_3_name), getString(R.string.product_3_price), R.drawable.img_2));
        productList.add(new Product(getString(R.string.product_4_name), getString(R.string.product_4_price), R.drawable.img_3));
        productList.add(new Product(getString(R.string.product_5_name), getString(R.string.product_5_price), R.drawable.img_4));
        productList.add(new Product(getString(R.string.product_6_name), getString(R.string.product_6_price), R.drawable.img_5));

        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        // Mở màn hình Giỏ hàng
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}
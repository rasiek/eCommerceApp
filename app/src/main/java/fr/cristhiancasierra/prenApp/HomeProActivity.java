package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeProActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pro);
        ImageButton homePro = findViewById(R.id.homepro_btn);
        ImageButton addProduct = findViewById(R.id.add_product_btn);
        ImageButton orders = findViewById(R.id.orders_btn);
        ImageButton comptePro = findViewById(R.id.comptepro_btn);

        homePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeProActivity.this, HomeProActivity.class);
                startActivity(intent);
            }
        });

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeProActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeProActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        comptePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeProActivity.this, AccountGestionProActivity.class);
                startActivity(intent);
            }
        });
    }

}
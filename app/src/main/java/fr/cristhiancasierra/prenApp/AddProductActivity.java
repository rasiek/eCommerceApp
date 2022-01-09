package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {

    private EditText nomProduit, brang, description, prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        nomProduit = findViewById(R.id.product_name);
        brang = findViewById(R.id.brang);
        description = findViewById(R.id.description_product);
        prix = findViewById(R.id.price_product);

        Button ajoutProduitBtn = findViewById(R.id.add_produit_btn);
        ajoutProduitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddProductActivity.this, HomeActivity.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });
    }
}
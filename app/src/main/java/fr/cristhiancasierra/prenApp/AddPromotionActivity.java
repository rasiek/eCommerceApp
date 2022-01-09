package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPromotionActivity extends AppCompatActivity {

    private EditText idProduit, nvPrix, duree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotion);

        idProduit = findViewById(R.id.id_promos);
        nvPrix = findViewById(R.id.prix_promos);
        duree = findViewById(R.id.duree);

        Button ajoutPromosBtn = findViewById(R.id.add_promos_btn);
        ajoutPromosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddPromotionActivity.this, HomeActivity.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });
    }


}
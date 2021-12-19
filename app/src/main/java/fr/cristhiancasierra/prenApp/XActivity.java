package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class XActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);

        TextView advancedSearch = findViewById(R.id.advanced_search);

        advancedSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XActivity.this, AdvancedSearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
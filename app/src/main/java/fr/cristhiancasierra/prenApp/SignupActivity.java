package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        ImageButton clientSignupBtn = findViewById(R.id.client_signup_btn);
        ImageButton proSignupBtn = findViewById(R.id.pro_signup_btn);


        clientSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignupActivity.this, SignupClientActivity.class);
                startActivity(intent);
            }
        });

        proSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, SignupProActivity.class);
                startActivity(intent);
            }
        });

    }



}
package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupProActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pro);

        EditText firstname, lastname, email, phone, address, password, confirmPassword;

        firstname = findViewById(R.id.firstname_pro);
        lastname = findViewById(R.id.lastname_pro);
        email = findViewById(R.id.email_pro);
        phone = findViewById(R.id.phone_pro);
        address = findViewById(R.id.address_pro);
        password = findViewById(R.id.password_pro);
        confirmPassword = findViewById(R.id.password_pro);

        Button homeproBtn = findViewById(R.id.form_homepro_btn);
        homeproBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupProActivity.this);
                builder.setTitle("Attention!");
                builder.setMessage("Voulez vous enregistrer les informations saisies?");
                builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(SignupProActivity.this, HomeProActivity.class);
                startActivity(intent);
            }
        });
                builder.setNegativeButton("Annuler", null);

                AlertDialog alert = builder.create();

                alert.show();
            }
        });
    }
}
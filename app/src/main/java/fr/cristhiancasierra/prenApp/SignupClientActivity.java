package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.cristhiancasierra.prenApp.db.AppDatabase;
import fr.cristhiancasierra.prenApp.entities.Client;
import android.widget.Toast;


public class SignupClientActivity extends AppCompatActivity {

    private List<Client> listClient;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_client);

        EditText firstname, lastname, email, phone, address, city, password, confirmPassword;

        firstname = findViewById(R.id.firstname_client);
        lastname = findViewById(R.id.lastname_client);
        email = findViewById(R.id.email_client);
        phone = findViewById(R.id.phone_client);
        address = findViewById(R.id.address_client);
        city = findViewById(R.id.city_client);
        password = findViewById(R.id.password_client);
        confirmPassword = findViewById(R.id.confirm_password_client);


        Button singUpBtn = findViewById(R.id.form_home_btn);
        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupClientActivity.this);
                builder.setTitle("Attention!");
                builder.setMessage("Voulez vous enregistrer les informations saisies?");
                builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Intent intent = new Intent(SignupClientActivity.this, HomeActivity.class);
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
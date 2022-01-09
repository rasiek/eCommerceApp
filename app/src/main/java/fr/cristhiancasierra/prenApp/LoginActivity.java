package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;

public class LoginActivity extends AppCompatActivity {


    private Button access_btn;
    private TextView forgot_btn;
    private EditText email;
    private EditText password;
    private ClientViewModel clientViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgot_btn = findViewById(R.id.forgot_password);
        access_btn = findViewById(R.id.access_btn);
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        clientViewModel = new ViewModelProvider(LoginActivity.this).get(ClientViewModel.class);



        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PasswordRecoveryActivity.class);
                startActivity(intent);
            }
        });

        access_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                clientViewModel.getClientByPass(password.getText().toString(), email.getText().toString()).observe(
                        LoginActivity.this,
                        client -> {

                            if (client != null) {

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.putExtra("id", client.getId());
                                startActivity(intent);
                            } else {

                                Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();

                            }

                        }
                );

            }
        });
    }
}
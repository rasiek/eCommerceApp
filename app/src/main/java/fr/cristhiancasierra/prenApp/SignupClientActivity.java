package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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

public class SignupClientActivity extends AppCompatActivity {

    private List<Client> listClient;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_client);

        appDatabase = AppDatabase.getDatabase(this);



        /*EditText firstname = findViewById(R.id.edit_firstname);
        EditText lastname = findViewById(R.id.edit_firstname);
        EditText phone = findViewById(R.id.edit_firstname);

        firstname.getText();

        Client client = new Client(
                firstname.getText(),
                lastname.getText(),
                phone.getText()
        );*/


        Client client = new Client("Cristhian", "Casierra", "tst@test", "12345", "twr", "Rennes");
        Client client2 = new Client("Kenza", "Bouraya", "tst@test", "12345", "twr", "Rennes");


        new Thread(new Runnable() {
            @Override
            public void run() {

                appDatabase.clientDao().insertClient(client);
                appDatabase.clientDao().insertClient(client2);
            }
        }) .start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                listClient = appDatabase.clientDao().getListClients();

            }
        }) .start();





        LinearLayout testLl = findViewById(R.id.test_ll);
        TextView tv = new TextView(this);
        TextView tv2 = new TextView(this);
        tv.setText(appDatabase.toString());
        /*tv2.setText(listClient.size());*//**/
        testLl.addView(tv);
        /*testLl.addView(tv2);*/

        /*for (Client c:
             listClient) {
            TextView tv = new TextView(this);

            tv.setText(c.getFirstname());

            testLl.addView(tv);
        }*/

        Button saveBtn = findViewById(R.id.form_home_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupClientActivity.this, HomeActivity.class);
                startActivity(intent);



            }
        });
    }
}
package fr.cristhiancasierra.prenApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.cristhiancasierra.prenApp.ViewModels.ClientViewModel;
import fr.cristhiancasierra.prenApp.ViewModels.ProductViewModel;
import fr.cristhiancasierra.prenApp.entities.Client;

public class HomeActivity extends AppCompatActivity {

    ClientViewModel clientViewModel;
    ProductViewModel productViewModel;
    Intent intent;
    private Client client;
    private String idString;
    private long id;
    private NavInflater navInflater;
    private NavGraph graph;
    private NavArgument argument;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        clientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);

        try {
            intent = getIntent();
            idString = intent.getStringExtra("id");

            id = Long.parseLong(idString);
        } catch (Exception exception) {
            id = 0;
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();

        navInflater = navController.getNavInflater();
        graph = navInflater.inflate(R.navigation.client_nav);
        argument = new NavArgument.Builder().setDefaultValue(id).build();
        graph.addArgument("id", argument);

        navController.setGraph(graph);


        NavigationUI.setupWithNavController(
                bottomNavigationView,
                navController
        );


    }
}
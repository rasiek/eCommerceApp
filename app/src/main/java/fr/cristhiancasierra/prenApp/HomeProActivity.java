package fr.cristhiancasierra.prenApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeProActivity extends AppCompatActivity {

    private NavInflater navInflater;
    private NavGraph graph;
    private NavArgument argument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pro);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_pro);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_pro);
        NavController navController = navHostFragment.getNavController();

        navInflater = navController.getNavInflater();
        graph = navInflater.inflate(R.navigation.pro_nav);


        navController.setGraph(graph);


        NavigationUI.setupWithNavController(
                bottomNavigationView,
                navController
        );

    }

}
package com.example.agenfree;

import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.agenfree.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;

    private ActionBarDrawerToggle toggle;

    public Boolean testStirng = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNavigations();
        initDrawer();

        // Clica no perfil do usuário e muda de Activity
        binding.profileBtn.setOnClickListener(v -> {

            if (AppData.getInstance().fakeToken == true) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);

            } else {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }

    // Configuração da navegação inferior
    private void initNavigations() {
        navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);

        assert navHostFragment != null;

        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(
                binding.bottomNavigation,
                navController
        );
    }

    // Configuração do menu lateral
    private void initDrawer() {

        setSupportActionBar(binding.toolbar);

        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        );

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // Navegação do Drawer
        binding.navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_myService) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startActivity(intent);
            } else if (id == R.id.nav_config) {
                Intent intent = new Intent(MainActivity.this, Config.class);
                startActivity(intent);
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}


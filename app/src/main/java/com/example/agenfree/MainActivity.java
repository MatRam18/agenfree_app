
package com.example.agenfree;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.agenfree.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNavigations();
        initDrawer();
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

        binding.navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_perfil ||
                    id == R.id.nav_configuracoes ||
                    id == R.id.nav_sobre) {

                navController.navigate(id);
            }

            binding.drawerLayout.closeDrawers();

            return true;
        });
    }
}

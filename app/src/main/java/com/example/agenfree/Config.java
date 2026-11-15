package com.example.agenfree;

import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenfree.databinding.ActivityConfigBinding;

public class Config extends AppCompatActivity {

    private ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        ir para pagina de editar perfil
        binding.profileEditBtn.setOnClickListener(v -> {
            if (AppData.getInstance().fakeToken == true) {
                Intent intent = new Intent(Config.this, ProfileEdit.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(Config.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

//        Realizar o log out
        binding.logoutBtn.setOnClickListener(v -> {
            if (AppData.getInstance().fakeToken == true) {
                AppData.getInstance().fakeToken = false;
                finish();
            }
        });
    }
}
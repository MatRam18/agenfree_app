package com.example.agenfree;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenfree.databinding.ActivityUserPageBinding;

public class UserPage extends AppCompatActivity {

//    Sempre mudar essa variável conforme o .java que ele estiver
    private ActivityUserPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        binding = ActivityUserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //      Clica no perfil do usuário e muda de Activity
        binding.userBackButton.setOnClickListener(v -> {
//            Intent intent = new Intent(UserPage.this, MainActivity.class);
//            startActivity(intent);
            finish();
        });

    }
}
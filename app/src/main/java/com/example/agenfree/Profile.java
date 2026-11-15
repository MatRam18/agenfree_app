package com.example.agenfree;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenfree.databinding.ActivityProfileBinding;

public class Profile extends AppCompatActivity {

//    Sempre mudar essa variável conforme o .java que ele estiver
    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //      Clica no perfil do usuário e muda de Activity
        binding.profileBackBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(Profile.this, MainActivity.class);
//            startActivity(intent);
            finish();
        });

    }
}
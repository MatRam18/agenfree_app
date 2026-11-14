package com.example.agenfree;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenfree.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Todo esse pedaço funciona para os botões
//        No confirm, ele muda a variável definida no AppData e sai da tela
//        E no Logon ele muda para tela de logon e fecha a tela atual, imposibilitando do usuário retornar
        binding.confirmBtn.setOnClickListener(v -> {
            AppData.getInstance().fakeToken = true;
            finish();
        });

        binding.logonBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Logon.class);
            startActivity(intent);
            finish();
        });
    }
}
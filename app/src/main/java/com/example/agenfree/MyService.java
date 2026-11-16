package com.example.agenfree;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.agenfree.databinding.ActivityMyServiceBinding;

public class MyService extends AppCompatActivity {

    private ActivityMyServiceBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.newServiceBtn.setOnClickListener( v -> {
            Intent intent = new Intent(MyService.this, NewService.class);
            startActivity(intent);
        });

        binding.editServiceBtn.setOnClickListener( v -> {
            Intent intent = new Intent(MyService.this, EditService.class);
            startActivity(intent);
        });

    }
}
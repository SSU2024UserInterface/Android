package com.example.mohassu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mohassu.databinding.ActivityStartBinding;

public class ActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartBinding binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
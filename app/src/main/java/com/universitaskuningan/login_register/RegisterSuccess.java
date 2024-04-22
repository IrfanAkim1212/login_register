package com.universitaskuningan.login_register;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.universitaskuningan.login_register.databinding.ActivityRegisterSuccessBinding;

public class RegisterSuccess extends AppCompatActivity {
    private ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Menerima data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("username");
            String email = intent.getStringExtra("email");
            String password = intent.getStringExtra("password");

            // Menampilkan data yang diterima di EditText
            binding.editTextUsername.setText(username);
            binding.editTextEmail.setText(email);
            binding.editTextPassword.setText(password);

            // Menyimpan data ke SharedPreferences
            saveCredentials(username, email, password);
        }

        // Mengatur listener klik untuk tombol "kembali"
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke halaman login
                Intent intent = new Intent(RegisterSuccess.this, LoginActivity.class);

                // Menambahkan flag untuk membersihkan tumpukan aktivitas
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
    }
    private void saveCredentials(String username, String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }
}
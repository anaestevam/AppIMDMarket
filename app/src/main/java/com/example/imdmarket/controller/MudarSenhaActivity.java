package com.example.imdmarket.controller;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.imdmarket.R;

public class MudarSenhaActivity extends AppCompatActivity {

    private EditText etNovaSenha;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_senha);

        etNovaSenha = findViewById(R.id.etNovaSenha);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para salvar a nova senha e indicar o sucesso
                salvarNovaSenha();
            }
        });
    }

    private void salvarNovaSenha() {

        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "admin"); // Nome de usuário fixo como "admin"
        editor.putString("password", etNovaSenha.getText().toString());
        editor.apply();

        Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK);
        finish();
    }
}

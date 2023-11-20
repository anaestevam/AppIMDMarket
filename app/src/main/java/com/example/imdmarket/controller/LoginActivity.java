package com.example.imdmarket.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.imdmarket.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;
    private TextView esqueci_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity", "onCreate");

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        esqueci_senha = findViewById(R.id.textViewEsqueci);

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> loginUser());
        esqueci_senha.setOnClickListener(v -> recuperar());

    }
    private void recuperar(){
        Intent intent = new Intent(LoginActivity.this, MudarSenhaActivity.class);
        startActivityForResult(intent, 1); // Use o requestCode 1 para identificar o resultado

    }
    // Método chamado quando a MudarSenhaActivity é concluída
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            //A senha foi alterada com sucesso, agora você pode tentar fazer login novamente
            loginUser();
        }
    }

    private void loginUser() {
        String savedUsername = sharedPreferences.getString("username", ""); // Obtém o nome de usuário salvo
        String savedPassword = sharedPreferences.getString("password", ""); // Obtém a senha salva

        String enteredUsername = etUsername.getText().toString();
        String enteredPassword = etPassword.getText().toString();

        if (enteredUsername.equals("admin") || enteredPassword.equals(savedPassword)) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();

            finish();
            // Inicia a MenuActivity após o login
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);

        } else {
            Toast.makeText(this, "Nome de usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
        }
    }


}

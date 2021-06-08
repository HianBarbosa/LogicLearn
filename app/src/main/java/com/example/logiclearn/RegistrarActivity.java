package com.example.logiclearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarActivity extends AppCompatActivity {

    private EditText nome, sobrenome, email, senha;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nome = findViewById(R.id.cadastroNome);
        sobrenome = findViewById(R.id.cadastroSobrenome);
        email = findViewById(R.id.cadastroEmail);
        senha = findViewById(R.id.cadastroSenha);
    }

    public void cadastrarUsuario(View view){
        usuario.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
        .addOnCompleteListener(RegistrarActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("Criar usuário", "Usuário criado");
                }
                else {
                    Log.i("Criar usuário", "Erro no cadastro");
                }
            }
        });
    }

    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

}

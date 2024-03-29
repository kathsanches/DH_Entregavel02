package br.com.digitalhouse.entregavel02.views.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.entregavel02.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button buttonregister;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacampo();
            }
        });
    }

    public void register() {

        Intent intentCadastro = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intentCadastro);
    }


    private void initViews() {

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.botaoLogin);
        buttonregister = findViewById(R.id.botaoregistre);
    }

    public void validacampo() {
        textInputLayoutEmail.setErrorEnabled(false);
        textInputLayoutPassword.setErrorEnabled(false);

        email = textInputLayoutEmail.getEditText().getText().toString().trim();
        password = textInputLayoutPassword.getEditText().getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            textInputLayoutEmail.setError("Campo vazio. ");
            textInputLayoutPassword.setError("Campo vazio. ");
            vibrar(400);

        } else {
            register();
        }
    }

    private void vibrar(int i) {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 30;
        rr.vibrate(milliseconds);
    }
}

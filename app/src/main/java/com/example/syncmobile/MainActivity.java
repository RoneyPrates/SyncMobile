package com.example.syncmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        errorMessageTextView = findViewById(R.id.error_message);
        Button entrarButton = findViewById(R.id.entrar);

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(MainActivity.this, OrdensDeComprasActivity.class);
            startActivity(intent);
            finish();
        } else {
            errorMessageTextView.setText("Usuário ou senha incorretos");
        }
    }
}

package com.example.a17controlespersonalizados_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ControlLogin clLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clLogin = findViewById(R.id.clLogin);

        clLogin.setOnLoginListener(new ControlLogin.OnLoginListener() {
            @Override
            public void onLogin(String usuario, String password) {
                if (usuario.equals("demo") && password.equals("demo"))
                    clLogin.setMensaje("Login Correcto!!!");
                else
                    clLogin.setMensaje("Vuelva a Intentarlo!!!");
            }
        });
    }
}

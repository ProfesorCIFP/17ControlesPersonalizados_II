package com.example.a17controlespersonalizados_ii;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputLayout;

public class ControlLogin extends ConstraintLayout {
    private TextInputLayout tilUsuario, tilContrasena;
    private Button btnLogin;
    private TextView tvMensaje;

    private OnLoginListener listener;

    public void setOnLoginListener(OnLoginListener l) {
        listener = l;
    }


    public ControlLogin(Context context) {
        super(context);
        inicializar();
    }

    public ControlLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }

    public ControlLogin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializar();
    }

    private void inicializar() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.control_login,this,true);

        tilUsuario = findViewById(R.id.tilUsuario);
        tilContrasena = findViewById(R.id.tilContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        tvMensaje = findViewById(R.id.tvMensaje);
        
        
        AsignarEventos();
    }

    public void setMensaje (String mensaje) {
        tvMensaje.setText(mensaje);
    }

    public interface OnLoginListener {
        void onLogin (String usuario, String password);
    }

    private void AsignarEventos() {
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLogin(tilUsuario.getEditText().getText().toString(),
                                 tilContrasena.getEditText().getText().toString());
            }
        });

    }
}

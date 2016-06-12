package com.example.lunagonzalez.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText pass;
    Button enviar, nuevo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.txtUsuario);
        pass = (EditText) findViewById(R.id.txtPass);
        enviar = (Button) findViewById(R.id.btnIngresar);
        nuevo = (Button) findViewById(R.id.btnRegistrar);


        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentR = new Intent(MainActivity.this, registroActiviy.class);
                startActivity(intentR);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context contexto = getApplication();
                int tiempo = Toast.LENGTH_SHORT;

                if (usuario.length() <= 0) {

                    Toast toast = Toast.makeText(contexto, "Debe ingresar un usuario", tiempo);
                    toast.show();
                } else {
                    if (pass.length() <= 0) {
                        Toast toast = Toast.makeText(contexto, "Debe ingresar una contraseña", tiempo);
                        toast.show();
                    } else {
                        if (pass.length() < 6) {
                            Toast toast = Toast.makeText(contexto, "La contraseña debe tener minimo 6 caracteres", tiempo);
                            toast.show();
                        } else {

                            SharedPreferences sp = getSharedPreferences("datos",contexto.MODE_PRIVATE);
                            String gUsuario = sp.getString("nUsuario", "No name defined");
                            String gPass = sp.getString("nPass", "No name defined");

                            if (usuario.getText().toString().equals(gUsuario) && pass.getText().toString().equals(gPass)){
                                Intent intentMenu = new Intent(MainActivity.this, Main2Activity.class);
                                String loguear = usuario.getText().toString();
                                intentMenu.putExtra("logueado", loguear);
                                startActivity(intentMenu);

                            } else {

                                Toast toast = Toast.makeText(contexto, "Usuario NO Registrado", tiempo);
                                toast.show();
                            }
                        }
                    }
               }
            }
        });
    }
}


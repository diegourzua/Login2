package com.example.lunagonzalez.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroActiviy extends AppCompatActivity {

    EditText userR;
    EditText passR;
    Button btnRegsitrar;

    public void validarCuenta(){

        Context contexto = getApplication();
        int tiempo = Toast.LENGTH_SHORT;

        if(userR.length() <= 0 ) {
            Toast toast = Toast.makeText(contexto,"Debe ingresar un usuario",tiempo);
            toast.show();
        }else{

            if (passR.length() <= 0 )
            {
                Toast toast = Toast.makeText(contexto,"Debe ingresar una contraseña",tiempo);
                toast.show();
            }else{
                if (passR.length() < 6 )
                {
                    Toast toast = Toast.makeText(contexto,"La contraseña debe tener minimo 6 caracteres",tiempo);
                    toast.show();
                }else{

                    Toast toast = Toast.makeText(contexto, "Usuario registrado", tiempo);
                    toast.show();

                    SharedPreferences pref = getSharedPreferences("datos",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("nUsuario",userR.getText().toString());
                    editor.putString("nPass",passR.getText().toString());
                    editor.commit();
                    userR.setText("");
                    passR.setText("");

                    Intent intentMenu = new Intent(registroActiviy.this,MainActivity.class);
                    startActivity(intentMenu);
                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_activiy);



        userR = (EditText) findViewById(R.id.EditUser);
        passR = (EditText) findViewById(R.id.EditPass);
        btnRegsitrar = (Button) findViewById(R.id.btnRegistro);



        btnRegsitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarCuenta();
            }
        });

    }
}

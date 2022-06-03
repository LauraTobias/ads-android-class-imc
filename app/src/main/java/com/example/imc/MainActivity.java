package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = findViewById(R.id.txtAltura);
        peso = findViewById(R.id.txtPeso);
    }

    public void IMC(View v)
    {
        Intent i = new Intent(getApplicationContext(), IMCActivity.class);

        String valorAltura = altura.getText().toString();
        String valorPeso = peso.getText().toString();

        Log.i("altura:", valorAltura);

        if (ValidacaoCampos(valorPeso, valorAltura))
            return;

        i.putExtra("altura", Double.parseDouble(valorAltura));
        i.putExtra("peso", Double.parseDouble(valorPeso));

        startActivity(i);
    }

    private Boolean ValidacaoCampos(String valorPeso, String valorAltura)
    {
        if (valorPeso.isEmpty() || valorAltura.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}